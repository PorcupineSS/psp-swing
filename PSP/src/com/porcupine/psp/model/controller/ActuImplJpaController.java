/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.entity.ActuImpl;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.entity.CoordTYT;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class ActuImplJpaController implements Serializable {

    public ActuImplJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ActuImpl actuImpl) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ImplSeguridad idImplemento = actuImpl.getIdImplemento();
            if (idImplemento != null) {
                idImplemento = em.getReference(idImplemento.getClass(), idImplemento.getIdImplemento());
                actuImpl.setIdImplemento(idImplemento);
            }
            CoordTYT cedulae = actuImpl.getCedulae();
            if (cedulae != null) {
                cedulae = em.getReference(cedulae.getClass(), cedulae.getCedulae());
                actuImpl.setCedulae(cedulae);
            }
            em.persist(actuImpl);
            if (idImplemento != null) {
                idImplemento.getActuImplList().add(actuImpl);
                idImplemento = em.merge(idImplemento);
            }
            if (cedulae != null) {
                cedulae.getActuImplList().add(actuImpl);
                cedulae = em.merge(cedulae);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ActuImpl actuImpl) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ActuImpl persistentActuImpl = em.find(ActuImpl.class, actuImpl.getIdActualizacionI());
            ImplSeguridad idImplementoOld = persistentActuImpl.getIdImplemento();
            ImplSeguridad idImplementoNew = actuImpl.getIdImplemento();
            CoordTYT cedulaeOld = persistentActuImpl.getCedulae();
            CoordTYT cedulaeNew = actuImpl.getCedulae();
            if (idImplementoNew != null) {
                idImplementoNew = em.getReference(idImplementoNew.getClass(), idImplementoNew.getIdImplemento());
                actuImpl.setIdImplemento(idImplementoNew);
            }
            if (cedulaeNew != null) {
                cedulaeNew = em.getReference(cedulaeNew.getClass(), cedulaeNew.getCedulae());
                actuImpl.setCedulae(cedulaeNew);
            }
            actuImpl = em.merge(actuImpl);
            if (idImplementoOld != null && !idImplementoOld.equals(idImplementoNew)) {
                idImplementoOld.getActuImplList().remove(actuImpl);
                idImplementoOld = em.merge(idImplementoOld);
            }
            if (idImplementoNew != null && !idImplementoNew.equals(idImplementoOld)) {
                idImplementoNew.getActuImplList().add(actuImpl);
                idImplementoNew = em.merge(idImplementoNew);
            }
            if (cedulaeOld != null && !cedulaeOld.equals(cedulaeNew)) {
                cedulaeOld.getActuImplList().remove(actuImpl);
                cedulaeOld = em.merge(cedulaeOld);
            }
            if (cedulaeNew != null && !cedulaeNew.equals(cedulaeOld)) {
                cedulaeNew.getActuImplList().add(actuImpl);
                cedulaeNew = em.merge(cedulaeNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = actuImpl.getIdActualizacionI();
                if (findActuImpl(id) == null) {
                    throw new NonexistentEntityException("The actuImpl with id " + id + " no longer exists.");
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
            ActuImpl actuImpl;
            try {
                actuImpl = em.getReference(ActuImpl.class, id);
                actuImpl.getIdActualizacionI();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The actuImpl with id " + id + " no longer exists.", enfe);
            }
            ImplSeguridad idImplemento = actuImpl.getIdImplemento();
            if (idImplemento != null) {
                idImplemento.getActuImplList().remove(actuImpl);
                idImplemento = em.merge(idImplemento);
            }
            CoordTYT cedulae = actuImpl.getCedulae();
            if (cedulae != null) {
                cedulae.getActuImplList().remove(actuImpl);
                cedulae = em.merge(cedulae);
            }
            em.remove(actuImpl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ActuImpl> findActuImplEntities() {
        return findActuImplEntities(true, -1, -1);
    }

    public List<ActuImpl> findActuImplEntities(int maxResults, int firstResult) {
        return findActuImplEntities(false, maxResults, firstResult);
    }

    private List<ActuImpl> findActuImplEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ActuImpl.class));
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

    public ActuImpl findActuImpl(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ActuImpl.class, id);
        } finally {
            em.close();
        }
    }

    public int getActuImplCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ActuImpl> rt = cq.from(ActuImpl.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
