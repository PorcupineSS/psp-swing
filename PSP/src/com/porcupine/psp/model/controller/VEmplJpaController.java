/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.controller.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.view.VEmpl;
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
public class VEmplJpaController implements Serializable {

    public VEmplJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VEmpl VEmpl) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(VEmpl);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVEmpl(VEmpl.getCedulae()) != null) {
                throw new PreexistingEntityException("VEmpl " + VEmpl + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VEmpl VEmpl) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VEmpl = em.merge(VEmpl);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = VEmpl.getCedulae();
                if (findVEmpl(id) == null) {
                    throw new NonexistentEntityException("The vEmpl with id " + id + " no longer exists.");
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
            VEmpl VEmpl;
            try {
                VEmpl = em.getReference(VEmpl.class, id);
                VEmpl.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The VEmpl with id " + id + " no longer exists.", enfe);
            }
            em.remove(VEmpl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VEmpl> findVEmplEntities() {
        return findVEmplEntities(true, -1, -1);
    }

    public List<VEmpl> findVEmplEntities(int maxResults, int firstResult) {
        return findVEmplEntities(false, maxResults, firstResult);
    }

    private List<VEmpl> findVEmplEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VEmpl.class));
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

    public VEmpl findVEmpl(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VEmpl.class, id);
        } finally {
            em.close();
        }
    }

    public int getVEmplCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VEmpl> rt = cq.from(VEmpl.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
