/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.entity.Comunicado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.porcupine.psp.model.entity.EmpTemp;
import com.porcupine.psp.model.entity.DirOperaciones;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class ComunicadoJpaController implements Serializable {

    public ComunicadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Comunicado comunicado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmpTemp cedulae = comunicado.getCedulae();
            if (cedulae != null) {
                cedulae = em.getReference(cedulae.getClass(), cedulae.getCedulae());
                comunicado.setCedulae(cedulae);
            }
            DirOperaciones dirCedulae = comunicado.getDirCedulae();
            if (dirCedulae != null) {
                dirCedulae = em.getReference(dirCedulae.getClass(), dirCedulae.getCedulae());
                comunicado.setDirCedulae(dirCedulae);
            }
            em.persist(comunicado);
            if (cedulae != null) {
                cedulae.getComunicadoList().add(comunicado);
                cedulae = em.merge(cedulae);
            }
            if (dirCedulae != null) {
                dirCedulae.getComunicadoList().add(comunicado);
                dirCedulae = em.merge(dirCedulae);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Comunicado comunicado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comunicado persistentComunicado = em.find(Comunicado.class, comunicado.getIdComunicado());
            EmpTemp cedulaeOld = persistentComunicado.getCedulae();
            EmpTemp cedulaeNew = comunicado.getCedulae();
            DirOperaciones dirCedulaeOld = persistentComunicado.getDirCedulae();
            DirOperaciones dirCedulaeNew = comunicado.getDirCedulae();
            if (cedulaeNew != null) {
                cedulaeNew = em.getReference(cedulaeNew.getClass(), cedulaeNew.getCedulae());
                comunicado.setCedulae(cedulaeNew);
            }
            if (dirCedulaeNew != null) {
                dirCedulaeNew = em.getReference(dirCedulaeNew.getClass(), dirCedulaeNew.getCedulae());
                comunicado.setDirCedulae(dirCedulaeNew);
            }
            comunicado = em.merge(comunicado);
            if (cedulaeOld != null && !cedulaeOld.equals(cedulaeNew)) {
                cedulaeOld.getComunicadoList().remove(comunicado);
                cedulaeOld = em.merge(cedulaeOld);
            }
            if (cedulaeNew != null && !cedulaeNew.equals(cedulaeOld)) {
                cedulaeNew.getComunicadoList().add(comunicado);
                cedulaeNew = em.merge(cedulaeNew);
            }
            if (dirCedulaeOld != null && !dirCedulaeOld.equals(dirCedulaeNew)) {
                dirCedulaeOld.getComunicadoList().remove(comunicado);
                dirCedulaeOld = em.merge(dirCedulaeOld);
            }
            if (dirCedulaeNew != null && !dirCedulaeNew.equals(dirCedulaeOld)) {
                dirCedulaeNew.getComunicadoList().add(comunicado);
                dirCedulaeNew = em.merge(dirCedulaeNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = comunicado.getIdComunicado();
                if (findComunicado(id) == null) {
                    throw new NonexistentEntityException("The comunicado with id " + id + " no longer exists.");
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
            Comunicado comunicado;
            try {
                comunicado = em.getReference(Comunicado.class, id);
                comunicado.getIdComunicado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comunicado with id " + id + " no longer exists.", enfe);
            }
            EmpTemp cedulae = comunicado.getCedulae();
            if (cedulae != null) {
                cedulae.getComunicadoList().remove(comunicado);
                cedulae = em.merge(cedulae);
            }
            DirOperaciones dirCedulae = comunicado.getDirCedulae();
            if (dirCedulae != null) {
                dirCedulae.getComunicadoList().remove(comunicado);
                dirCedulae = em.merge(dirCedulae);
            }
            em.remove(comunicado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Comunicado> findComunicadoEntities() {
        return findComunicadoEntities(true, -1, -1);
    }

    public List<Comunicado> findComunicadoEntities(int maxResults, int firstResult) {
        return findComunicadoEntities(false, maxResults, firstResult);
    }

    private List<Comunicado> findComunicadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comunicado.class));
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

    public Comunicado findComunicado(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comunicado.class, id);
        } finally {
            em.close();
        }
    }

    public int getComunicadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comunicado> rt = cq.from(Comunicado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
