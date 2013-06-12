/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.IllegalOrphanException;
import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.entity.*;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class ImplSeguridadJpaController implements Serializable {

    public ImplSeguridadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ImplSeguridad implSeguridad) {
        if (implSeguridad.getAsigImplList() == null) {
            implSeguridad.setAsigImplList(new ArrayList<AsigImpl>());
        }
        if (implSeguridad.getActuImplList() == null) {
            implSeguridad.setActuImplList(new ArrayList<ActuImpl>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor idPro = implSeguridad.getIdPro();
            if (idPro != null) {
                idPro = em.getReference(idPro.getClass(), idPro.getIdPro());
                implSeguridad.setIdPro(idPro);
            }
            CoordTYT cedulae = implSeguridad.getCedulae();
            if (cedulae != null) {
                cedulae = em.getReference(cedulae.getClass(), cedulae.getCedulae());
                implSeguridad.setCedulae(cedulae);
            }
            List<AsigImpl> attachedAsigImplList = new ArrayList<AsigImpl>();
            for (AsigImpl asigImplListAsigImplToAttach : implSeguridad.getAsigImplList()) {
                asigImplListAsigImplToAttach = em.getReference(asigImplListAsigImplToAttach.getClass(), asigImplListAsigImplToAttach.getIdAsignacionI());
                attachedAsigImplList.add(asigImplListAsigImplToAttach);
            }
            implSeguridad.setAsigImplList(attachedAsigImplList);
            List<ActuImpl> attachedActuImplList = new ArrayList<ActuImpl>();
            for (ActuImpl actuImplListActuImplToAttach : implSeguridad.getActuImplList()) {
                actuImplListActuImplToAttach = em.getReference(actuImplListActuImplToAttach.getClass(), actuImplListActuImplToAttach.getIdActualizacionI());
                attachedActuImplList.add(actuImplListActuImplToAttach);
            }
            implSeguridad.setActuImplList(attachedActuImplList);
            em.persist(implSeguridad);
            if (idPro != null) {
                idPro.getImplSeguridadList().add(implSeguridad);
                idPro = em.merge(idPro);
            }
            if (cedulae != null) {
                cedulae.getImplSeguridadList().add(implSeguridad);
                cedulae = em.merge(cedulae);
            }
            for (AsigImpl asigImplListAsigImpl : implSeguridad.getAsigImplList()) {
                ImplSeguridad oldIdImplementoOfAsigImplListAsigImpl = asigImplListAsigImpl.getIdImplemento();
                asigImplListAsigImpl.setIdImplemento(implSeguridad);
                asigImplListAsigImpl = em.merge(asigImplListAsigImpl);
                if (oldIdImplementoOfAsigImplListAsigImpl != null) {
                    oldIdImplementoOfAsigImplListAsigImpl.getAsigImplList().remove(asigImplListAsigImpl);
                    oldIdImplementoOfAsigImplListAsigImpl = em.merge(oldIdImplementoOfAsigImplListAsigImpl);
                }
            }
            for (ActuImpl actuImplListActuImpl : implSeguridad.getActuImplList()) {
                ImplSeguridad oldIdImplementoOfActuImplListActuImpl = actuImplListActuImpl.getIdImplemento();
                actuImplListActuImpl.setIdImplemento(implSeguridad);
                actuImplListActuImpl = em.merge(actuImplListActuImpl);
                if (oldIdImplementoOfActuImplListActuImpl != null) {
                    oldIdImplementoOfActuImplListActuImpl.getActuImplList().remove(actuImplListActuImpl);
                    oldIdImplementoOfActuImplListActuImpl = em.merge(oldIdImplementoOfActuImplListActuImpl);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ImplSeguridad implSeguridad) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ImplSeguridad persistentImplSeguridad = em.find(ImplSeguridad.class, implSeguridad.getIdImplemento());
            Proveedor idProOld = persistentImplSeguridad.getIdPro();
            Proveedor idProNew = implSeguridad.getIdPro();
            CoordTYT cedulaeOld = persistentImplSeguridad.getCedulae();
            CoordTYT cedulaeNew = implSeguridad.getCedulae();
            List<AsigImpl> asigImplListOld = persistentImplSeguridad.getAsigImplList();
            List<AsigImpl> asigImplListNew = implSeguridad.getAsigImplList();
            List<ActuImpl> actuImplListOld = persistentImplSeguridad.getActuImplList();
            List<ActuImpl> actuImplListNew = implSeguridad.getActuImplList();
            List<String> illegalOrphanMessages = null;
            for (AsigImpl asigImplListOldAsigImpl : asigImplListOld) {
                if (!asigImplListNew.contains(asigImplListOldAsigImpl)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AsigImpl " + asigImplListOldAsigImpl + " since its idImplemento field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idProNew != null) {
                idProNew = em.getReference(idProNew.getClass(), idProNew.getIdPro());
                implSeguridad.setIdPro(idProNew);
            }
            if (cedulaeNew != null) {
                cedulaeNew = em.getReference(cedulaeNew.getClass(), cedulaeNew.getCedulae());
                implSeguridad.setCedulae(cedulaeNew);
            }
            List<AsigImpl> attachedAsigImplListNew = new ArrayList<AsigImpl>();
            for (AsigImpl asigImplListNewAsigImplToAttach : asigImplListNew) {
                asigImplListNewAsigImplToAttach = em.getReference(asigImplListNewAsigImplToAttach.getClass(), asigImplListNewAsigImplToAttach.getIdAsignacionI());
                attachedAsigImplListNew.add(asigImplListNewAsigImplToAttach);
            }
            asigImplListNew = attachedAsigImplListNew;
            implSeguridad.setAsigImplList(asigImplListNew);
            List<ActuImpl> attachedActuImplListNew = new ArrayList<ActuImpl>();
            for (ActuImpl actuImplListNewActuImplToAttach : actuImplListNew) {
                actuImplListNewActuImplToAttach = em.getReference(actuImplListNewActuImplToAttach.getClass(), actuImplListNewActuImplToAttach.getIdActualizacionI());
                attachedActuImplListNew.add(actuImplListNewActuImplToAttach);
            }
            actuImplListNew = attachedActuImplListNew;
            implSeguridad.setActuImplList(actuImplListNew);
            implSeguridad = em.merge(implSeguridad);
            if (idProOld != null && !idProOld.equals(idProNew)) {
                idProOld.getImplSeguridadList().remove(implSeguridad);
                idProOld = em.merge(idProOld);
            }
            if (idProNew != null && !idProNew.equals(idProOld)) {
                idProNew.getImplSeguridadList().add(implSeguridad);
                idProNew = em.merge(idProNew);
            }
            if (cedulaeOld != null && !cedulaeOld.equals(cedulaeNew)) {
                cedulaeOld.getImplSeguridadList().remove(implSeguridad);
                cedulaeOld = em.merge(cedulaeOld);
            }
            if (cedulaeNew != null && !cedulaeNew.equals(cedulaeOld)) {
                cedulaeNew.getImplSeguridadList().add(implSeguridad);
                cedulaeNew = em.merge(cedulaeNew);
            }
            for (AsigImpl asigImplListNewAsigImpl : asigImplListNew) {
                if (!asigImplListOld.contains(asigImplListNewAsigImpl)) {
                    ImplSeguridad oldIdImplementoOfAsigImplListNewAsigImpl = asigImplListNewAsigImpl.getIdImplemento();
                    asigImplListNewAsigImpl.setIdImplemento(implSeguridad);
                    asigImplListNewAsigImpl = em.merge(asigImplListNewAsigImpl);
                    if (oldIdImplementoOfAsigImplListNewAsigImpl != null && !oldIdImplementoOfAsigImplListNewAsigImpl.equals(implSeguridad)) {
                        oldIdImplementoOfAsigImplListNewAsigImpl.getAsigImplList().remove(asigImplListNewAsigImpl);
                        oldIdImplementoOfAsigImplListNewAsigImpl = em.merge(oldIdImplementoOfAsigImplListNewAsigImpl);
                    }
                }
            }
            for (ActuImpl actuImplListOldActuImpl : actuImplListOld) {
                if (!actuImplListNew.contains(actuImplListOldActuImpl)) {
                    actuImplListOldActuImpl.setIdImplemento(null);
                    actuImplListOldActuImpl = em.merge(actuImplListOldActuImpl);
                }
            }
            for (ActuImpl actuImplListNewActuImpl : actuImplListNew) {
                if (!actuImplListOld.contains(actuImplListNewActuImpl)) {
                    ImplSeguridad oldIdImplementoOfActuImplListNewActuImpl = actuImplListNewActuImpl.getIdImplemento();
                    actuImplListNewActuImpl.setIdImplemento(implSeguridad);
                    actuImplListNewActuImpl = em.merge(actuImplListNewActuImpl);
                    if (oldIdImplementoOfActuImplListNewActuImpl != null && !oldIdImplementoOfActuImplListNewActuImpl.equals(implSeguridad)) {
                        oldIdImplementoOfActuImplListNewActuImpl.getActuImplList().remove(actuImplListNewActuImpl);
                        oldIdImplementoOfActuImplListNewActuImpl = em.merge(oldIdImplementoOfActuImplListNewActuImpl);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = implSeguridad.getIdImplemento();
                if (findImplSeguridad(id) == null) {
                    throw new NonexistentEntityException("The implSeguridad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Short id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ImplSeguridad implSeguridad;
            try {
                implSeguridad = em.getReference(ImplSeguridad.class, id);
                implSeguridad.getIdImplemento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The implSeguridad with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<AsigImpl> asigImplListOrphanCheck = implSeguridad.getAsigImplList();
            for (AsigImpl asigImplListOrphanCheckAsigImpl : asigImplListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ImplSeguridad (" + implSeguridad + ") cannot be destroyed since the AsigImpl " + asigImplListOrphanCheckAsigImpl + " in its asigImplList field has a non-nullable idImplemento field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Proveedor idPro = implSeguridad.getIdPro();
            if (idPro != null) {
                idPro.getImplSeguridadList().remove(implSeguridad);
                idPro = em.merge(idPro);
            }
            CoordTYT cedulae = implSeguridad.getCedulae();
            if (cedulae != null) {
                cedulae.getImplSeguridadList().remove(implSeguridad);
                cedulae = em.merge(cedulae);
            }
            List<ActuImpl> actuImplList = implSeguridad.getActuImplList();
            for (ActuImpl actuImplListActuImpl : actuImplList) {
                actuImplListActuImpl.setIdImplemento(null);
                actuImplListActuImpl = em.merge(actuImplListActuImpl);
            }
            em.remove(implSeguridad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ImplSeguridad> findImplSeguridadEntities() {
        return findImplSeguridadEntities(true, -1, -1);
    }

    public List<ImplSeguridad> findImplSeguridadEntities(int maxResults, int firstResult) {
        return findImplSeguridadEntities(false, maxResults, firstResult);
    }

    private List<ImplSeguridad> findImplSeguridadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ImplSeguridad.class));
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

    public ImplSeguridad findImplSeguridad(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ImplSeguridad.class, id);
        } finally {
            em.close();
        }
    }

    public int getImplSeguridadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ImplSeguridad> rt = cq.from(ImplSeguridad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
