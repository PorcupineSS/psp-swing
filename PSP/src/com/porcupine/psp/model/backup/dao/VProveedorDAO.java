/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.VEmpleado;
import com.porcupine.psp.model.entity.VProveedor;
import com.porcupine.psp.model.entity.VProveedor;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Johan
 */
public class VProveedorDAO implements ICrudDAO<VProveedor, BigDecimal> {

    private EntityManagerFactory entityManagerFactory;

    public VProveedorDAO(String PU) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(VProveedor entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                if (find(entity.getIdProveedor()) != null) {
                    throw new PreexistingEntityException("¡El proveedor " + entity.getNombreProveedor()
                            + " ya existe!", ex);
                }
                throw ex;
            } catch (Exception ex1) {
                Logger.getLogger(VProveedorDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    @Override
    public VProveedor find(BigDecimal id) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(VProveedor.class, id);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("¡El proveedor con " + id + " no existe!");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    @Override
    public void update(VProveedor entity) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            VProveedor persistentProveedor = entityManager.find(VProveedor.class, entity.getIdProveedor());
            entity = entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
            BigDecimal id = entity.getIdProveedor();
            if (find(id) == null) {
                throw new NonexistentEntityException("¡El proveedor con id " + id + " no existe!", e);
            }
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    @Override
    public void delete(BigDecimal id) throws NonexistentEntityException {
                EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            VProveedor proveedor = null;
            try {
                proveedor = entityManager.getReference(VProveedor.class, id);
            } catch (EntityNotFoundException e) {
                throw new NonexistentEntityException("¡El proveedor con id " + id + " no existe!", e);
            }
            
            entityManager.remove(proveedor);
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
    public List<VProveedor> getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VProveedor.class));
            Query q = entityManager.createQuery(cq);
            return q.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        } 
    }         
    
}
