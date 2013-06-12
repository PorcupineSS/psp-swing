/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.entity.BitacoraSeg;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.porcupine.psp.model.entity.Empleados;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class BitacoraSegJpaController implements Serializable {

    public BitacoraSegJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BitacoraSeg bitacoraSeg) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados cedulae = bitacoraSeg.getCedulae();
            if (cedulae != null) {
                cedulae = em.getReference(cedulae.getClass(), cedulae.getCedulae());
                bitacoraSeg.setCedulae(cedulae);
            }
            em.persist(bitacoraSeg);
            if (cedulae != null) {
                cedulae.getBitacoraSegList().add(bitacoraSeg);
                cedulae = em.merge(cedulae);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BitacoraSeg bitacoraSeg) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BitacoraSeg persistentBitacoraSeg = em.find(BitacoraSeg.class, bitacoraSeg.getIdOper());
            Empleados cedulaeOld = persistentBitacoraSeg.getCedulae();
            Empleados cedulaeNew = bitacoraSeg.getCedulae();
            if (cedulaeNew != null) {
                cedulaeNew = em.getReference(cedulaeNew.getClass(), cedulaeNew.getCedulae());
                bitacoraSeg.setCedulae(cedulaeNew);
            }
            bitacoraSeg = em.merge(bitacoraSeg);
            if (cedulaeOld != null && !cedulaeOld.equals(cedulaeNew)) {
                cedulaeOld.getBitacoraSegList().remove(bitacoraSeg);
                cedulaeOld = em.merge(cedulaeOld);
            }
            if (cedulaeNew != null && !cedulaeNew.equals(cedulaeOld)) {
                cedulaeNew.getBitacoraSegList().add(bitacoraSeg);
                cedulaeNew = em.merge(cedulaeNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bitacoraSeg.getIdOper();
                if (findBitacoraSeg(id) == null) {
                    throw new NonexistentEntityException("The bitacoraSeg with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BitacoraSeg bitacoraSeg;
            try {
                bitacoraSeg = em.getReference(BitacoraSeg.class, id);
                bitacoraSeg.getIdOper();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bitacoraSeg with id " + id + " no longer exists.", enfe);
            }
            Empleados cedulae = bitacoraSeg.getCedulae();
            if (cedulae != null) {
                cedulae.getBitacoraSegList().remove(bitacoraSeg);
                cedulae = em.merge(cedulae);
            }
            em.remove(bitacoraSeg);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BitacoraSeg> findBitacoraSegEntities() {
        return findBitacoraSegEntities(true, -1, -1);
    }

    public List<BitacoraSeg> findBitacoraSegEntities(int maxResults, int firstResult) {
        return findBitacoraSegEntities(false, maxResults, firstResult);
    }

    private List<BitacoraSeg> findBitacoraSegEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BitacoraSeg.class));
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

    public BitacoraSeg findBitacoraSeg(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BitacoraSeg.class, id);
        } finally {
            em.close();
        }
    }

    public int getBitacoraSegCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BitacoraSeg> rt = cq.from(BitacoraSeg.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
