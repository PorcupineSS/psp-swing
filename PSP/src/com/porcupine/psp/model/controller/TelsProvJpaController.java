/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.porcupine.psp.model.entity.Proveedor;
import com.porcupine.psp.model.entity.TelsProv;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class TelsProvJpaController implements Serializable {

    public TelsProvJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TelsProv telsProv) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor idPro = telsProv.getIdPro();
            if (idPro != null) {
                idPro = em.getReference(idPro.getClass(), idPro.getIdPro());
                telsProv.setIdPro(idPro);
            }
            em.persist(telsProv);
            if (idPro != null) {
                idPro.getTelsProvList().add(telsProv);
                idPro = em.merge(idPro);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTelsProv(telsProv.getIdTp()) != null) {
                throw new PreexistingEntityException("TelsProv " + telsProv + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TelsProv telsProv) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TelsProv persistentTelsProv = em.find(TelsProv.class, telsProv.getIdTp());
            Proveedor idProOld = persistentTelsProv.getIdPro();
            Proveedor idProNew = telsProv.getIdPro();
            if (idProNew != null) {
                idProNew = em.getReference(idProNew.getClass(), idProNew.getIdPro());
                telsProv.setIdPro(idProNew);
            }
            telsProv = em.merge(telsProv);
            if (idProOld != null && !idProOld.equals(idProNew)) {
                idProOld.getTelsProvList().remove(telsProv);
                idProOld = em.merge(idProOld);
            }
            if (idProNew != null && !idProNew.equals(idProOld)) {
                idProNew.getTelsProvList().add(telsProv);
                idProNew = em.merge(idProNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = telsProv.getIdTp();
                if (findTelsProv(id) == null) {
                    throw new NonexistentEntityException("The telsProv with id " + id + " no longer exists.");
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
            TelsProv telsProv;
            try {
                telsProv = em.getReference(TelsProv.class, id);
                telsProv.getIdTp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The telsProv with id " + id + " no longer exists.", enfe);
            }
            Proveedor idPro = telsProv.getIdPro();
            if (idPro != null) {
                idPro.getTelsProvList().remove(telsProv);
                idPro = em.merge(idPro);
            }
            em.remove(telsProv);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TelsProv> findTelsProvEntities() {
        return findTelsProvEntities(true, -1, -1);
    }

    public List<TelsProv> findTelsProvEntities(int maxResults, int firstResult) {
        return findTelsProvEntities(false, maxResults, firstResult);
    }

    private List<TelsProv> findTelsProvEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TelsProv.class));
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

    public TelsProv findTelsProv(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TelsProv.class, id);
        } finally {
            em.close();
        }
    }

    public int getTelsProvCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TelsProv> rt = cq.from(TelsProv.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
