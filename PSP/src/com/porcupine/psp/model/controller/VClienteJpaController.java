/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.controller.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.view.VCliente;
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
public class VClienteJpaController implements Serializable {

    public VClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VCliente VCliente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(VCliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVCliente(VCliente.getCedulae()) != null) {
                throw new PreexistingEntityException("VCliente " + VCliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VCliente VCliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VCliente = em.merge(VCliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = VCliente.getCedulae();
                if (findVCliente(id) == null) {
                    throw new NonexistentEntityException("The vCliente with id " + id + " no longer exists.");
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
            VCliente VCliente;
            try {
                VCliente = em.getReference(VCliente.class, id);
                VCliente.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The VCliente with id " + id + " no longer exists.", enfe);
            }
            em.remove(VCliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VCliente> findVClienteEntities() {
        return findVClienteEntities(true, -1, -1);
    }

    public List<VCliente> findVClienteEntities(int maxResults, int firstResult) {
        return findVClienteEntities(false, maxResults, firstResult);
    }

    private List<VCliente> findVClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VCliente.class));
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

    public VCliente findVCliente(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VCliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getVClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VCliente> rt = cq.from(VCliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
