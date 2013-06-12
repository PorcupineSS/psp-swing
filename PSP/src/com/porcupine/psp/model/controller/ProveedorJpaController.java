/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.porcupine.psp.model.entity.CoordTYT;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.entity.Proveedor;
import java.util.ArrayList;
import java.util.List;
import com.porcupine.psp.model.entity.TelsProv;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class ProveedorJpaController implements Serializable {

    public ProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedor proveedor) {
        if (proveedor.getImplSeguridadList() == null) {
            proveedor.setImplSeguridadList(new ArrayList<ImplSeguridad>());
        }
        if (proveedor.getTelsProvList() == null) {
            proveedor.setTelsProvList(new ArrayList<TelsProv>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CoordTYT cedulae = proveedor.getCedulae();
            if (cedulae != null) {
                cedulae = em.getReference(cedulae.getClass(), cedulae.getCedulae());
                proveedor.setCedulae(cedulae);
            }
            List<ImplSeguridad> attachedImplSeguridadList = new ArrayList<ImplSeguridad>();
            for (ImplSeguridad implSeguridadListImplSeguridadToAttach : proveedor.getImplSeguridadList()) {
                implSeguridadListImplSeguridadToAttach = em.getReference(implSeguridadListImplSeguridadToAttach.getClass(), implSeguridadListImplSeguridadToAttach.getIdImplemento());
                attachedImplSeguridadList.add(implSeguridadListImplSeguridadToAttach);
            }
            proveedor.setImplSeguridadList(attachedImplSeguridadList);
            List<TelsProv> attachedTelsProvList = new ArrayList<TelsProv>();
            for (TelsProv telsProvListTelsProvToAttach : proveedor.getTelsProvList()) {
                telsProvListTelsProvToAttach = em.getReference(telsProvListTelsProvToAttach.getClass(), telsProvListTelsProvToAttach.getIdTp());
                attachedTelsProvList.add(telsProvListTelsProvToAttach);
            }
            proveedor.setTelsProvList(attachedTelsProvList);
            em.persist(proveedor);
            if (cedulae != null) {
                cedulae.getProveedorList().add(proveedor);
                cedulae = em.merge(cedulae);
            }
            for (ImplSeguridad implSeguridadListImplSeguridad : proveedor.getImplSeguridadList()) {
                Proveedor oldIdProOfImplSeguridadListImplSeguridad = implSeguridadListImplSeguridad.getIdPro();
                implSeguridadListImplSeguridad.setIdPro(proveedor);
                implSeguridadListImplSeguridad = em.merge(implSeguridadListImplSeguridad);
                if (oldIdProOfImplSeguridadListImplSeguridad != null) {
                    oldIdProOfImplSeguridadListImplSeguridad.getImplSeguridadList().remove(implSeguridadListImplSeguridad);
                    oldIdProOfImplSeguridadListImplSeguridad = em.merge(oldIdProOfImplSeguridadListImplSeguridad);
                }
            }
            for (TelsProv telsProvListTelsProv : proveedor.getTelsProvList()) {
                Proveedor oldIdProOfTelsProvListTelsProv = telsProvListTelsProv.getIdPro();
                telsProvListTelsProv.setIdPro(proveedor);
                telsProvListTelsProv = em.merge(telsProvListTelsProv);
                if (oldIdProOfTelsProvListTelsProv != null) {
                    oldIdProOfTelsProvListTelsProv.getTelsProvList().remove(telsProvListTelsProv);
                    oldIdProOfTelsProvListTelsProv = em.merge(oldIdProOfTelsProvListTelsProv);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedor proveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor persistentProveedor = em.find(Proveedor.class, proveedor.getIdPro());
            CoordTYT cedulaeOld = persistentProveedor.getCedulae();
            CoordTYT cedulaeNew = proveedor.getCedulae();
            List<ImplSeguridad> implSeguridadListOld = persistentProveedor.getImplSeguridadList();
            List<ImplSeguridad> implSeguridadListNew = proveedor.getImplSeguridadList();
            List<TelsProv> telsProvListOld = persistentProveedor.getTelsProvList();
            List<TelsProv> telsProvListNew = proveedor.getTelsProvList();
            if (cedulaeNew != null) {
                cedulaeNew = em.getReference(cedulaeNew.getClass(), cedulaeNew.getCedulae());
                proveedor.setCedulae(cedulaeNew);
            }
            List<ImplSeguridad> attachedImplSeguridadListNew = new ArrayList<ImplSeguridad>();
            for (ImplSeguridad implSeguridadListNewImplSeguridadToAttach : implSeguridadListNew) {
                implSeguridadListNewImplSeguridadToAttach = em.getReference(implSeguridadListNewImplSeguridadToAttach.getClass(), implSeguridadListNewImplSeguridadToAttach.getIdImplemento());
                attachedImplSeguridadListNew.add(implSeguridadListNewImplSeguridadToAttach);
            }
            implSeguridadListNew = attachedImplSeguridadListNew;
            proveedor.setImplSeguridadList(implSeguridadListNew);
            List<TelsProv> attachedTelsProvListNew = new ArrayList<TelsProv>();
            for (TelsProv telsProvListNewTelsProvToAttach : telsProvListNew) {
                telsProvListNewTelsProvToAttach = em.getReference(telsProvListNewTelsProvToAttach.getClass(), telsProvListNewTelsProvToAttach.getIdTp());
                attachedTelsProvListNew.add(telsProvListNewTelsProvToAttach);
            }
            telsProvListNew = attachedTelsProvListNew;
            proveedor.setTelsProvList(telsProvListNew);
            proveedor = em.merge(proveedor);
            if (cedulaeOld != null && !cedulaeOld.equals(cedulaeNew)) {
                cedulaeOld.getProveedorList().remove(proveedor);
                cedulaeOld = em.merge(cedulaeOld);
            }
            if (cedulaeNew != null && !cedulaeNew.equals(cedulaeOld)) {
                cedulaeNew.getProveedorList().add(proveedor);
                cedulaeNew = em.merge(cedulaeNew);
            }
            for (ImplSeguridad implSeguridadListOldImplSeguridad : implSeguridadListOld) {
                if (!implSeguridadListNew.contains(implSeguridadListOldImplSeguridad)) {
                    implSeguridadListOldImplSeguridad.setIdPro(null);
                    implSeguridadListOldImplSeguridad = em.merge(implSeguridadListOldImplSeguridad);
                }
            }
            for (ImplSeguridad implSeguridadListNewImplSeguridad : implSeguridadListNew) {
                if (!implSeguridadListOld.contains(implSeguridadListNewImplSeguridad)) {
                    Proveedor oldIdProOfImplSeguridadListNewImplSeguridad = implSeguridadListNewImplSeguridad.getIdPro();
                    implSeguridadListNewImplSeguridad.setIdPro(proveedor);
                    implSeguridadListNewImplSeguridad = em.merge(implSeguridadListNewImplSeguridad);
                    if (oldIdProOfImplSeguridadListNewImplSeguridad != null && !oldIdProOfImplSeguridadListNewImplSeguridad.equals(proveedor)) {
                        oldIdProOfImplSeguridadListNewImplSeguridad.getImplSeguridadList().remove(implSeguridadListNewImplSeguridad);
                        oldIdProOfImplSeguridadListNewImplSeguridad = em.merge(oldIdProOfImplSeguridadListNewImplSeguridad);
                    }
                }
            }
            for (TelsProv telsProvListOldTelsProv : telsProvListOld) {
                if (!telsProvListNew.contains(telsProvListOldTelsProv)) {
                    telsProvListOldTelsProv.setIdPro(null);
                    telsProvListOldTelsProv = em.merge(telsProvListOldTelsProv);
                }
            }
            for (TelsProv telsProvListNewTelsProv : telsProvListNew) {
                if (!telsProvListOld.contains(telsProvListNewTelsProv)) {
                    Proveedor oldIdProOfTelsProvListNewTelsProv = telsProvListNewTelsProv.getIdPro();
                    telsProvListNewTelsProv.setIdPro(proveedor);
                    telsProvListNewTelsProv = em.merge(telsProvListNewTelsProv);
                    if (oldIdProOfTelsProvListNewTelsProv != null && !oldIdProOfTelsProvListNewTelsProv.equals(proveedor)) {
                        oldIdProOfTelsProvListNewTelsProv.getTelsProvList().remove(telsProvListNewTelsProv);
                        oldIdProOfTelsProvListNewTelsProv = em.merge(oldIdProOfTelsProvListNewTelsProv);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = proveedor.getIdPro();
                if (findProveedor(id) == null) {
                    throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.");
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
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getIdPro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.", enfe);
            }
            CoordTYT cedulae = proveedor.getCedulae();
            if (cedulae != null) {
                cedulae.getProveedorList().remove(proveedor);
                cedulae = em.merge(cedulae);
            }
            List<ImplSeguridad> implSeguridadList = proveedor.getImplSeguridadList();
            for (ImplSeguridad implSeguridadListImplSeguridad : implSeguridadList) {
                implSeguridadListImplSeguridad.setIdPro(null);
                implSeguridadListImplSeguridad = em.merge(implSeguridadListImplSeguridad);
            }
            List<TelsProv> telsProvList = proveedor.getTelsProvList();
            for (TelsProv telsProvListTelsProv : telsProvList) {
                telsProvListTelsProv.setIdPro(null);
                telsProvListTelsProv = em.merge(telsProvListTelsProv);
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedor.class));
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

    public Proveedor findProveedor(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedor> rt = cq.from(Proveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
