/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.*;
import com.porcupine.psp.model.entity.Proveedor;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;


/**
 *
 * @author Jeisson Andrés Vergara
 */
public class ProveedorDAO implements ICrudDAO<Proveedor, Short> {
    
    private EntityManagerFactory entityManagerFactory;

    ProveedorDAO(String PU, Map propierties) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU, propierties);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
    @Override
    public void create(Proveedor entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }  
    }

    @Override
    public Proveedor find(Short id) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(Proveedor.class, id);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("¡El proveedor con id: " + id + ", no existe!");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        } 
    }

    @Override
    public void update(Proveedor entity) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entity = entityManager.merge(entity);
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
    public void delete(Short id) throws NonexistentEntityException {
         EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Proveedor proveedor = null;
            try {
                proveedor = entityManager.getReference(Proveedor.class, id);
            } catch (EntityNotFoundException e) {
                throw new NonexistentEntityException("¡El proveedor con id: " + id + ", no existe!", e);
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
    public List<Proveedor> getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedor.class));
            Query q = entityManager.createQuery(cq);
            return q.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public Iterable<Proveedor> findByName(String name) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            List<Proveedor> proveedores;
            Query q = entityManager.createNamedQuery("Proveedor.findByNombre").setParameter("nombre", name);
            proveedores = q.getResultList();
            return proveedores;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("¡No hay proveedores con nombre: " + name + "!");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
    
    public Short findName(String name) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            List<Proveedor> proveedores;
            Query q = entityManager.createNamedQuery("Proveedor.findByNombre").setParameter("nombre", name);
            proveedores = q.getResultList();
            return proveedores.get(0).getIdPro();
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("¡No hay proveedores con nombre: " + name + "!");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
    
}
