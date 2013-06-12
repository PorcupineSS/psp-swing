/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.controller.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.view.VComun;
import java.io.Serializable;
import java.math.BigInteger;
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
public class VComunJpaController implements Serializable {

    public VComunJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VComun VComun) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(VComun);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVComun(VComun.getCedulae()) != null) {
                throw new PreexistingEntityException("VComun " + VComun + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VComun VComun) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VComun = em.merge(VComun);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = VComun.getCedulae();
                if (findVComun(id) == null) {
                    throw new NonexistentEntityException("The vComun with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigInteger id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VComun VComun;
            try {
                VComun = em.getReference(VComun.class, id);
                VComun.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The VComun with id " + id + " no longer exists.", enfe);
            }
            em.remove(VComun);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VComun> findVComunEntities() {
        return findVComunEntities(true, -1, -1);
    }

    public List<VComun> findVComunEntities(int maxResults, int firstResult) {
        return findVComunEntities(false, maxResults, firstResult);
    }

    private List<VComun> findVComunEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VComun.class));
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

    public VComun findVComun(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VComun.class, id);
        } finally {
            em.close();
        }
    }

    public int getVComunCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VComun> rt = cq.from(VComun.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
