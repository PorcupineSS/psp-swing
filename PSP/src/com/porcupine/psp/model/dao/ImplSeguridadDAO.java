/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.ImplSeguridad;
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
 * @author andres
 */
public class ImplSeguridadDAO implements ICrudDAO<ImplSeguridad, Long> {

    private EntityManagerFactory entityManagerFactory;

    public ImplSeguridadDAO(String PUName) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PUName);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(ImplSeguridad entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                if (find(entity.getIdImplemento().longValue()) != null) {
                    throw new PreexistingEntityException("¡El implemento " + entity.getNombreI() + " ya existe!", ex);
                }
                throw ex;
            } catch (Exception ex1) {
                Logger.getLogger(ImplSeguridadDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public ImplSeguridad find(Long idImplemento) throws EntityNotFoundException {
        
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(ImplSeguridad.class, idImplemento);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("¡El implemento con id: " + idImplemento + " no existe!");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    @Override
    public void update(ImplSeguridad entity) throws NonexistentEntityException {
        
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            ImplSeguridad persistentImplSeguridad = entityManager.find(ImplSeguridad.class, entity.getIdImplemento());
            entity = entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
            Long id = entity.getIdImplemento().longValue();
            if (find(id) == null) {
                throw new NonexistentEntityException("¡El implemento con id: " + id + " no existe!", e);
            }
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }

    }
    
    @Override
    public void delete(Long id) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            ImplSeguridad implemento = null;
            try {
                implemento = entityManager.getReference(ImplSeguridad.class, id);
            } catch (EntityNotFoundException e) {
                throw new NonexistentEntityException("¡El implemento con el id: " + id + " no existe!", e);
            }
            
            entityManager.remove(implemento);
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
    public List<ImplSeguridad> getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ImplSeguridad.class));
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
