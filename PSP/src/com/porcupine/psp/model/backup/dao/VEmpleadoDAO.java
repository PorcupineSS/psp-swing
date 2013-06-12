/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.DataBaseException;
import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.Empleados;
import com.porcupine.psp.model.entity.VEmpleado;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Zergio
 */
public class VEmpleadoDAO implements ICrudDAO<VEmpleado, BigDecimal> {

    private EntityManagerFactory entityManagerFactory;
    
    public VEmpleadoDAO(String PU) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(VEmpleado entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                if (find(entity.getCedula()) != null) {
                    throw new PreexistingEntityException("¡El empleado " + entity.getNombreEmpleado()
                            + " " + entity.getApellidoEmpleado() + " ya existe!", ex);
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
    public VEmpleado find(BigDecimal cedula) throws EntityNotFoundException {
        
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(VEmpleado.class, cedula);
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
    public void update(VEmpleado entity) throws NonexistentEntityException {
        
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            VEmpleado persistentEmpleados = entityManager.find(VEmpleado.class, entity.getCedula());
            entity = entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
            BigDecimal cedula = entity.getCedula();
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
    public void delete(BigDecimal cedula) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            VEmpleado empleado = null;
            try {
                empleado = entityManager.getReference(VEmpleado.class, cedula);
            } catch (EntityNotFoundException e) {
                throw new NonexistentEntityException("¡El empleado con la C.C. " + cedula + " no existe!", e);
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
    public List<VEmpleado> getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VEmpleado.class));
            Query q = entityManager.createQuery(cq);
            return q.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
    
    public VEmpleado login(VEmpleado entity) throws DataBaseException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            VEmpleado empleado;
            Query q = entityManager.createQuery("SELECT u FROM VEmpleado u "
                    + "WHERE u.cedula LIKE :username "
                    + "AND u.contraseniaEmpleado LIKE :password")
                    .setParameter("username", entity.getCedula().toString())
                    .setParameter("password", entity.getContraseniaEmpleado());
            try {
                empleado = (VEmpleado) q.getSingleResult();
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
