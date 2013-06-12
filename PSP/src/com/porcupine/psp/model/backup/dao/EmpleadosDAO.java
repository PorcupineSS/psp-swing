/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.DataBaseException;
import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.Empleados;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author javergarav
 */
public class EmpleadosDAO implements ICrudDAO<Empleados, Long> {

    private EntityManagerFactory entityManagerFactory;

    public EmpleadosDAO(String PUName) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PUName);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(Empleados entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                if (find(entity.getCedulae()) != null) {
                    throw new PreexistingEntityException("¡El empleado " + entity.getNombree()
                            + " " + entity.getApellidoe() + " ya existe!", ex);
                }
                throw ex;
            } catch (Exception ex1) {
                Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public Empleados find(Long cedula) throws EntityNotFoundException {
        
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(Empleados.class, cedula);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("¡El empleado con C.C. " + cedula + " no existe!");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    @Override
    public void update(Empleados entity) throws NonexistentEntityException {
        
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Empleados persistentEmpleados = entityManager.find(Empleados.class, entity.getCedulae());
            entity = entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
            Long cedula = entity.getCedulae();
            if (find(cedula) == null) {
                throw new NonexistentEntityException("¡El empleado con C.C. " + cedula + " no existe!", e);
            }
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }

    }
    
    @Override
    public void delete(Long cedulae) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Empleados empleado = null;
            try {
                empleado = entityManager.getReference(Empleados.class, cedulae);
            } catch (EntityNotFoundException e) {
                throw new NonexistentEntityException("¡El empleado con la C.C. " + cedulae + " no existe!", e);
            }
            
            entityManager.remove(empleado);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
    
    @Override
    public List<Empleados> getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleados.class));
            Query q = entityManager.createQuery(cq);
            return q.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
    
    public Empleados login(Empleados entity) throws DataBaseException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            Empleados empleado;
            Query q = entityManager.createQuery("SELECT u FROM Empleados u "
                    + "WHERE u.cedulae LIKE :username "
                    + "AND u.contrasenae LIKE :password")
                    .setParameter("username", entity.getCedulae().toString())
                    .setParameter("password", entity.getContrasenae());
            try {
                empleado = (Empleados) q.getSingleResult();
            } catch (NoResultException e) {
                empleado = null;
            }
            return empleado;
        } catch (Exception e) {
            throw new DataBaseException("¡Error de Conexion a la Base de Datos!", e);
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }    
    
}
