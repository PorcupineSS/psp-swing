/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.controller.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.view.VAimpl;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Zergio
 */
public class VAimplJpaController implements Serializable {

    public VAimplJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VAimpl VAimpl) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(VAimpl);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVAimpl(VAimpl.getIdImplemento()) != null) {
                throw new PreexistingEntityException("VAimpl " + VAimpl + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VAimpl VAimpl) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VAimpl = em.merge(VAimpl);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = VAimpl.getIdImplemento();
                if (findVAimpl(id) == null) {
                    throw new NonexistentEntityException("The vAimpl with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Short id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VAimpl VAimpl;
            try {
                VAimpl = em.getReference(VAimpl.class, id);
                VAimpl.getIdImplemento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The VAimpl with id " + id + " no longer exists.", enfe);
            }
            em.remove(VAimpl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VAimpl> findVAimplEntities() {
        return findVAimplEntities(true, -1, -1);
    }

    public List<VAimpl> findVAimplEntities(int maxResults, int firstResult) {
        return findVAimplEntities(false, maxResults, firstResult);
    }

    private List<VAimpl> findVAimplEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VAimpl.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public VAimpl findVAimpl(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VAimpl.class, id);
        } finally {
            em.close();
        }
    }

    public int getVAimplCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VAimpl> rt = cq.from(VAimpl.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
