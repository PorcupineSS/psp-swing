/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.controller.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.view.VBitacora;
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
public class VBitacoraJpaController implements Serializable {

    public VBitacoraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VBitacora VBitacora) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(VBitacora);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVBitacora(VBitacora.getCedulae()) != null) {
                throw new PreexistingEntityException("VBitacora " + VBitacora + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VBitacora VBitacora) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VBitacora = em.merge(VBitacora);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = VBitacora.getCedulae();
                if (findVBitacora(id) == null) {
                    throw new NonexistentEntityException("The vBitacora with id " + id + " no longer exists.");
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
            VBitacora VBitacora;
            try {
                VBitacora = em.getReference(VBitacora.class, id);
                VBitacora.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The VBitacora with id " + id + " no longer exists.", enfe);
            }
            em.remove(VBitacora);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VBitacora> findVBitacoraEntities() {
        return findVBitacoraEntities(true, -1, -1);
    }

    public List<VBitacora> findVBitacoraEntities(int maxResults, int firstResult) {
        return findVBitacoraEntities(false, maxResults, firstResult);
    }

    private List<VBitacora> findVBitacoraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VBitacora.class));
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

    public VBitacora findVBitacora(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VBitacora.class, id);
        } finally {
            em.close();
        }
    }

    public int getVBitacoraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VBitacora> rt = cq.from(VBitacora.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
