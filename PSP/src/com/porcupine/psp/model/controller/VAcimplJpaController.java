/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.controller.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.view.VAcimpl;
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
public class VAcimplJpaController implements Serializable {

    public VAcimplJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VAcimpl VAcimpl) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(VAcimpl);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVAcimpl(VAcimpl.getIdImplemento()) != null) {
                throw new PreexistingEntityException("VAcimpl " + VAcimpl + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VAcimpl VAcimpl) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VAcimpl = em.merge(VAcimpl);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = VAcimpl.getIdImplemento();
                if (findVAcimpl(id) == null) {
                    throw new NonexistentEntityException("The vAcimpl with id " + id + " no longer exists.");
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
            VAcimpl VAcimpl;
            try {
                VAcimpl = em.getReference(VAcimpl.class, id);
                VAcimpl.getIdImplemento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The VAcimpl with id " + id + " no longer exists.", enfe);
            }
            em.remove(VAcimpl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VAcimpl> findVAcimplEntities() {
        return findVAcimplEntities(true, -1, -1);
    }

    public List<VAcimpl> findVAcimplEntities(int maxResults, int firstResult) {
        return findVAcimplEntities(false, maxResults, firstResult);
    }

    private List<VAcimpl> findVAcimplEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VAcimpl.class));
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

    public VAcimpl findVAcimpl(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VAcimpl.class, id);
        } finally {
            em.close();
        }
    }

    public int getVAcimplCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VAcimpl> rt = cq.from(VAcimpl.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
