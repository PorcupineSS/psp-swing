/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.controller.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.view.VImseg;
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
public class VImsegJpaController implements Serializable {

    public VImsegJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VImseg VImseg) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(VImseg);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVImseg(VImseg.getCedulae()) != null) {
                throw new PreexistingEntityException("VImseg " + VImseg + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VImseg VImseg) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VImseg = em.merge(VImseg);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = VImseg.getCedulae();
                if (findVImseg(id) == null) {
                    throw new NonexistentEntityException("The vImseg with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VImseg VImseg;
            try {
                VImseg = em.getReference(VImseg.class, id);
                VImseg.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The VImseg with id " + id + " no longer exists.", enfe);
            }
            em.remove(VImseg);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VImseg> findVImsegEntities() {
        return findVImsegEntities(true, -1, -1);
    }

    public List<VImseg> findVImsegEntities(int maxResults, int firstResult) {
        return findVImsegEntities(false, maxResults, firstResult);
    }

    private List<VImseg> findVImsegEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VImseg.class));
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

    public VImseg findVImseg(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VImseg.class, id);
        } finally {
            em.close();
        }
    }

    public int getVImsegCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VImseg> rt = cq.from(VImseg.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
