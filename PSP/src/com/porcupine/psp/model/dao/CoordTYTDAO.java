/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.*;
import com.porcupine.psp.model.entity.CoordTYT;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;


/**
 *
 * @author Jeisson Andrés Vergara
 */
public class CoordTYTDAO implements ICrudDAO<CoordTYT, Integer> {
    
    private EntityManagerFactory entityManagerFactory;

    public CoordTYTDAO(String PU, Map propierties) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU, propierties);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(CoordTYT entity) throws PreexistingEntityException, NonexistentEntityException {
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
    public CoordTYT find(Integer id) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(CoordTYT.class, id);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("¡El coordinador T y T con id: " + id + ", no existe!");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        } 
    }

    @Override
    public void update(CoordTYT entity) throws NonexistentEntityException {
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
    public void delete(Integer id) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            CoordTYT empleado = null;
            try {
                empleado = entityManager.getReference(CoordTYT.class, id);
            } catch (EntityNotFoundException e) {
                throw new NonexistentEntityException("El usuario con id " + id + " no existe.", e);
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
    public List<CoordTYT> getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CoordTYT.class));
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
