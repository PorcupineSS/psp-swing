/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.entity.AsigImpl;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.entity.EmpTemp;
import com.porcupine.psp.model.entity.CoordTYT;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class AsigImplJpaController implements Serializable {

    public AsigImplJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AsigImpl asigImpl) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ImplSeguridad idImplemento = asigImpl.getIdImplemento();
            if (idImplemento != null) {
                idImplemento = em.getReference(idImplemento.getClass(), idImplemento.getIdImplemento());
                asigImpl.setIdImplemento(idImplemento);
            }
            EmpTemp cedulae = asigImpl.getCedulae();
            if (cedulae != null) {
                cedulae = em.getReference(cedulae.getClass(), cedulae.getCedulae());
                asigImpl.setCedulae(cedulae);
            }
            CoordTYT cooCedulae = asigImpl.getCooCedulae();
            if (cooCedulae != null) {
                cooCedulae = em.getReference(cooCedulae.getClass(), cooCedulae.getCedulae());
                asigImpl.setCooCedulae(cooCedulae);
            }
            em.persist(asigImpl);
            if (idImplemento != null) {
                idImplemento.getAsigImplList().add(asigImpl);
                idImplemento = em.merge(idImplemento);
            }
            if (cedulae != null) {
                cedulae.getAsigImplList().add(asigImpl);
                cedulae = em.merge(cedulae);
            }
            if (cooCedulae != null) {
                cooCedulae.getAsigImplList().add(asigImpl);
                cooCedulae = em.merge(cooCedulae);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AsigImpl asigImpl) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AsigImpl persistentAsigImpl = em.find(AsigImpl.class, asigImpl.getIdAsignacionI());
            ImplSeguridad idImplementoOld = persistentAsigImpl.getIdImplemento();
            ImplSeguridad idImplementoNew = asigImpl.getIdImplemento();
            EmpTemp cedulaeOld = persistentAsigImpl.getCedulae();
            EmpTemp cedulaeNew = asigImpl.getCedulae();
            CoordTYT cooCedulaeOld = persistentAsigImpl.getCooCedulae();
            CoordTYT cooCedulaeNew = asigImpl.getCooCedulae();
            if (idImplementoNew != null) {
                idImplementoNew = em.getReference(idImplementoNew.getClass(), idImplementoNew.getIdImplemento());
                asigImpl.setIdImplemento(idImplementoNew);
            }
            if (cedulaeNew != null) {
                cedulaeNew = em.getReference(cedulaeNew.getClass(), cedulaeNew.getCedulae());
                asigImpl.setCedulae(cedulaeNew);
            }
            if (cooCedulaeNew != null) {
                cooCedulaeNew = em.getReference(cooCedulaeNew.getClass(), cooCedulaeNew.getCedulae());
                asigImpl.setCooCedulae(cooCedulaeNew);
            }
            asigImpl = em.merge(asigImpl);
            if (idImplementoOld != null && !idImplementoOld.equals(idImplementoNew)) {
                idImplementoOld.getAsigImplList().remove(asigImpl);
                idImplementoOld = em.merge(idImplementoOld);
            }
            if (idImplementoNew != null && !idImplementoNew.equals(idImplementoOld)) {
                idImplementoNew.getAsigImplList().add(asigImpl);
                idImplementoNew = em.merge(idImplementoNew);
            }
            if (cedulaeOld != null && !cedulaeOld.equals(cedulaeNew)) {
                cedulaeOld.getAsigImplList().remove(asigImpl);
                cedulaeOld = em.merge(cedulaeOld);
            }
            if (cedulaeNew != null && !cedulaeNew.equals(cedulaeOld)) {
                cedulaeNew.getAsigImplList().add(asigImpl);
                cedulaeNew = em.merge(cedulaeNew);
            }
            if (cooCedulaeOld != null && !cooCedulaeOld.equals(cooCedulaeNew)) {
                cooCedulaeOld.getAsigImplList().remove(asigImpl);
                cooCedulaeOld = em.merge(cooCedulaeOld);
            }
            if (cooCedulaeNew != null && !cooCedulaeNew.equals(cooCedulaeOld)) {
                cooCedulaeNew.getAsigImplList().add(asigImpl);
                cooCedulaeNew = em.merge(cooCedulaeNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = asigImpl.getIdAsignacionI();
                if (findAsigImpl(id) == null) {
                    throw new NonexistentEntityException("The asigImpl with id " + id + " no longer exists.");
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
            AsigImpl asigImpl;
            try {
                asigImpl = em.getReference(AsigImpl.class, id);
                asigImpl.getIdAsignacionI();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asigImpl with id " + id + " no longer exists.", enfe);
            }
            ImplSeguridad idImplemento = asigImpl.getIdImplemento();
            if (idImplemento != null) {
                idImplemento.getAsigImplList().remove(asigImpl);
                idImplemento = em.merge(idImplemento);
            }
            EmpTemp cedulae = asigImpl.getCedulae();
            if (cedulae != null) {
                cedulae.getAsigImplList().remove(asigImpl);
                cedulae = em.merge(cedulae);
            }
            CoordTYT cooCedulae = asigImpl.getCooCedulae();
            if (cooCedulae != null) {
                cooCedulae.getAsigImplList().remove(asigImpl);
                cooCedulae = em.merge(cooCedulae);
            }
            em.remove(asigImpl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AsigImpl> findAsigImplEntities() {
        return findAsigImplEntities(true, -1, -1);
    }

    public List<AsigImpl> findAsigImplEntities(int maxResults, int firstResult) {
        return findAsigImplEntities(false, maxResults, firstResult);
    }

    private List<AsigImpl> findAsigImplEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AsigImpl.class));
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

    public AsigImpl findAsigImpl(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AsigImpl.class, id);
        } finally {
            em.close();
        }
    }

    public int getAsigImplCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AsigImpl> rt = cq.from(AsigImpl.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
