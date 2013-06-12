/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.IllegalOrphanException;
import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.controller.exceptions.PreexistingEntityException;
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
public class CoordTYTJpaController implements Serializable {

    public CoordTYTJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CoordTYT coordTYT) throws IllegalOrphanException, PreexistingEntityException, Exception {
        if (coordTYT.getImplSeguridadList() == null) {
            coordTYT.setImplSeguridadList(new ArrayList<ImplSeguridad>());
        }
        if (coordTYT.getProveedorList() == null) {
            coordTYT.setProveedorList(new ArrayList<Proveedor>());
        }
        if (coordTYT.getAsigImplList() == null) {
            coordTYT.setAsigImplList(new ArrayList<AsigImpl>());
        }
        if (coordTYT.getActuImplList() == null) {
            coordTYT.setActuImplList(new ArrayList<ActuImpl>());
        }
        List<String> illegalOrphanMessages = null;
        EmpPlanta empPlantaOrphanCheck = coordTYT.getEmpPlanta();
        if (empPlantaOrphanCheck != null) {
            CoordTYT oldCoordTYTOfEmpPlanta = empPlantaOrphanCheck.getCoordTYT();
            if (oldCoordTYTOfEmpPlanta != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The EmpPlanta " + empPlantaOrphanCheck + " already has an item of type CoordTYT whose empPlanta column cannot be null. Please make another selection for the empPlanta field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmpPlanta empPlanta = coordTYT.getEmpPlanta();
            if (empPlanta != null) {
                empPlanta = em.getReference(empPlanta.getClass(), empPlanta.getCedulae());
                coordTYT.setEmpPlanta(empPlanta);
            }
            List<ImplSeguridad> attachedImplSeguridadList = new ArrayList<ImplSeguridad>();
            for (ImplSeguridad implSeguridadListImplSeguridadToAttach : coordTYT.getImplSeguridadList()) {
                implSeguridadListImplSeguridadToAttach = em.getReference(implSeguridadListImplSeguridadToAttach.getClass(), implSeguridadListImplSeguridadToAttach.getIdImplemento());
                attachedImplSeguridadList.add(implSeguridadListImplSeguridadToAttach);
            }
            coordTYT.setImplSeguridadList(attachedImplSeguridadList);
            List<Proveedor> attachedProveedorList = new ArrayList<Proveedor>();
            for (Proveedor proveedorListProveedorToAttach : coordTYT.getProveedorList()) {
                proveedorListProveedorToAttach = em.getReference(proveedorListProveedorToAttach.getClass(), proveedorListProveedorToAttach.getIdPro());
                attachedProveedorList.add(proveedorListProveedorToAttach);
            }
            coordTYT.setProveedorList(attachedProveedorList);
            List<AsigImpl> attachedAsigImplList = new ArrayList<AsigImpl>();
            for (AsigImpl asigImplListAsigImplToAttach : coordTYT.getAsigImplList()) {
                asigImplListAsigImplToAttach = em.getReference(asigImplListAsigImplToAttach.getClass(), asigImplListAsigImplToAttach.getIdAsignacionI());
                attachedAsigImplList.add(asigImplListAsigImplToAttach);
            }
            coordTYT.setAsigImplList(attachedAsigImplList);
            List<ActuImpl> attachedActuImplList = new ArrayList<ActuImpl>();
            for (ActuImpl actuImplListActuImplToAttach : coordTYT.getActuImplList()) {
                actuImplListActuImplToAttach = em.getReference(actuImplListActuImplToAttach.getClass(), actuImplListActuImplToAttach.getIdActualizacionI());
                attachedActuImplList.add(actuImplListActuImplToAttach);
            }
            coordTYT.setActuImplList(attachedActuImplList);
            em.persist(coordTYT);
            if (empPlanta != null) {
                empPlanta.setCoordTYT(coordTYT);
                empPlanta = em.merge(empPlanta);
            }
            for (ImplSeguridad implSeguridadListImplSeguridad : coordTYT.getImplSeguridadList()) {
                CoordTYT oldCedulaeOfImplSeguridadListImplSeguridad = implSeguridadListImplSeguridad.getCedulae();
                implSeguridadListImplSeguridad.setCedulae(coordTYT);
                implSeguridadListImplSeguridad = em.merge(implSeguridadListImplSeguridad);
                if (oldCedulaeOfImplSeguridadListImplSeguridad != null) {
                    oldCedulaeOfImplSeguridadListImplSeguridad.getImplSeguridadList().remove(implSeguridadListImplSeguridad);
                    oldCedulaeOfImplSeguridadListImplSeguridad = em.merge(oldCedulaeOfImplSeguridadListImplSeguridad);
                }
            }
            for (Proveedor proveedorListProveedor : coordTYT.getProveedorList()) {
                CoordTYT oldCedulaeOfProveedorListProveedor = proveedorListProveedor.getCedulae();
                proveedorListProveedor.setCedulae(coordTYT);
                proveedorListProveedor = em.merge(proveedorListProveedor);
                if (oldCedulaeOfProveedorListProveedor != null) {
                    oldCedulaeOfProveedorListProveedor.getProveedorList().remove(proveedorListProveedor);
                    oldCedulaeOfProveedorListProveedor = em.merge(oldCedulaeOfProveedorListProveedor);
                }
            }
            for (AsigImpl asigImplListAsigImpl : coordTYT.getAsigImplList()) {
                CoordTYT oldCooCedulaeOfAsigImplListAsigImpl = asigImplListAsigImpl.getCooCedulae();
                asigImplListAsigImpl.setCooCedulae(coordTYT);
                asigImplListAsigImpl = em.merge(asigImplListAsigImpl);
                if (oldCooCedulaeOfAsigImplListAsigImpl != null) {
                    oldCooCedulaeOfAsigImplListAsigImpl.getAsigImplList().remove(asigImplListAsigImpl);
                    oldCooCedulaeOfAsigImplListAsigImpl = em.merge(oldCooCedulaeOfAsigImplListAsigImpl);
                }
            }
            for (ActuImpl actuImplListActuImpl : coordTYT.getActuImplList()) {
                CoordTYT oldCedulaeOfActuImplListActuImpl = actuImplListActuImpl.getCedulae();
                actuImplListActuImpl.setCedulae(coordTYT);
                actuImplListActuImpl = em.merge(actuImplListActuImpl);
                if (oldCedulaeOfActuImplListActuImpl != null) {
                    oldCedulaeOfActuImplListActuImpl.getActuImplList().remove(actuImplListActuImpl);
                    oldCedulaeOfActuImplListActuImpl = em.merge(oldCedulaeOfActuImplListActuImpl);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCoordTYT(coordTYT.getCedulae()) != null) {
                throw new PreexistingEntityException("CoordTYT " + coordTYT + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CoordTYT coordTYT) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CoordTYT persistentCoordTYT = em.find(CoordTYT.class, coordTYT.getCedulae());
            EmpPlanta empPlantaOld = persistentCoordTYT.getEmpPlanta();
            EmpPlanta empPlantaNew = coordTYT.getEmpPlanta();
            List<ImplSeguridad> implSeguridadListOld = persistentCoordTYT.getImplSeguridadList();
            List<ImplSeguridad> implSeguridadListNew = coordTYT.getImplSeguridadList();
            List<Proveedor> proveedorListOld = persistentCoordTYT.getProveedorList();
            List<Proveedor> proveedorListNew = coordTYT.getProveedorList();
            List<AsigImpl> asigImplListOld = persistentCoordTYT.getAsigImplList();
            List<AsigImpl> asigImplListNew = coordTYT.getAsigImplList();
            List<ActuImpl> actuImplListOld = persistentCoordTYT.getActuImplList();
            List<ActuImpl> actuImplListNew = coordTYT.getActuImplList();
            List<String> illegalOrphanMessages = null;
            if (empPlantaNew != null && !empPlantaNew.equals(empPlantaOld)) {
                CoordTYT oldCoordTYTOfEmpPlanta = empPlantaNew.getCoordTYT();
                if (oldCoordTYTOfEmpPlanta != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The EmpPlanta " + empPlantaNew + " already has an item of type CoordTYT whose empPlanta column cannot be null. Please make another selection for the empPlanta field.");
                }
            }
            for (ImplSeguridad implSeguridadListOldImplSeguridad : implSeguridadListOld) {
                if (!implSeguridadListNew.contains(implSeguridadListOldImplSeguridad)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ImplSeguridad " + implSeguridadListOldImplSeguridad + " since its cedulae field is not nullable.");
                }
            }
            for (Proveedor proveedorListOldProveedor : proveedorListOld) {
                if (!proveedorListNew.contains(proveedorListOldProveedor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Proveedor " + proveedorListOldProveedor + " since its cedulae field is not nullable.");
                }
            }
            for (AsigImpl asigImplListOldAsigImpl : asigImplListOld) {
                if (!asigImplListNew.contains(asigImplListOldAsigImpl)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AsigImpl " + asigImplListOldAsigImpl + " since its cooCedulae field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empPlantaNew != null) {
                empPlantaNew = em.getReference(empPlantaNew.getClass(), empPlantaNew.getCedulae());
                coordTYT.setEmpPlanta(empPlantaNew);
            }
            List<ImplSeguridad> attachedImplSeguridadListNew = new ArrayList<ImplSeguridad>();
            for (ImplSeguridad implSeguridadListNewImplSeguridadToAttach : implSeguridadListNew) {
                implSeguridadListNewImplSeguridadToAttach = em.getReference(implSeguridadListNewImplSeguridadToAttach.getClass(), implSeguridadListNewImplSeguridadToAttach.getIdImplemento());
                attachedImplSeguridadListNew.add(implSeguridadListNewImplSeguridadToAttach);
            }
            implSeguridadListNew = attachedImplSeguridadListNew;
            coordTYT.setImplSeguridadList(implSeguridadListNew);
            List<Proveedor> attachedProveedorListNew = new ArrayList<Proveedor>();
            for (Proveedor proveedorListNewProveedorToAttach : proveedorListNew) {
                proveedorListNewProveedorToAttach = em.getReference(proveedorListNewProveedorToAttach.getClass(), proveedorListNewProveedorToAttach.getIdPro());
                attachedProveedorListNew.add(proveedorListNewProveedorToAttach);
            }
            proveedorListNew = attachedProveedorListNew;
            coordTYT.setProveedorList(proveedorListNew);
            List<AsigImpl> attachedAsigImplListNew = new ArrayList<AsigImpl>();
            for (AsigImpl asigImplListNewAsigImplToAttach : asigImplListNew) {
                asigImplListNewAsigImplToAttach = em.getReference(asigImplListNewAsigImplToAttach.getClass(), asigImplListNewAsigImplToAttach.getIdAsignacionI());
                attachedAsigImplListNew.add(asigImplListNewAsigImplToAttach);
            }
            asigImplListNew = attachedAsigImplListNew;
            coordTYT.setAsigImplList(asigImplListNew);
            List<ActuImpl> attachedActuImplListNew = new ArrayList<ActuImpl>();
            for (ActuImpl actuImplListNewActuImplToAttach : actuImplListNew) {
                actuImplListNewActuImplToAttach = em.getReference(actuImplListNewActuImplToAttach.getClass(), actuImplListNewActuImplToAttach.getIdActualizacionI());
                attachedActuImplListNew.add(actuImplListNewActuImplToAttach);
            }
            actuImplListNew = attachedActuImplListNew;
            coordTYT.setActuImplList(actuImplListNew);
            coordTYT = em.merge(coordTYT);
            if (empPlantaOld != null && !empPlantaOld.equals(empPlantaNew)) {
                empPlantaOld.setCoordTYT(null);
                empPlantaOld = em.merge(empPlantaOld);
            }
            if (empPlantaNew != null && !empPlantaNew.equals(empPlantaOld)) {
                empPlantaNew.setCoordTYT(coordTYT);
                empPlantaNew = em.merge(empPlantaNew);
            }
            for (ImplSeguridad implSeguridadListNewImplSeguridad : implSeguridadListNew) {
                if (!implSeguridadListOld.contains(implSeguridadListNewImplSeguridad)) {
                    CoordTYT oldCedulaeOfImplSeguridadListNewImplSeguridad = implSeguridadListNewImplSeguridad.getCedulae();
                    implSeguridadListNewImplSeguridad.setCedulae(coordTYT);
                    implSeguridadListNewImplSeguridad = em.merge(implSeguridadListNewImplSeguridad);
                    if (oldCedulaeOfImplSeguridadListNewImplSeguridad != null && !oldCedulaeOfImplSeguridadListNewImplSeguridad.equals(coordTYT)) {
                        oldCedulaeOfImplSeguridadListNewImplSeguridad.getImplSeguridadList().remove(implSeguridadListNewImplSeguridad);
                        oldCedulaeOfImplSeguridadListNewImplSeguridad = em.merge(oldCedulaeOfImplSeguridadListNewImplSeguridad);
                    }
                }
            }
            for (Proveedor proveedorListNewProveedor : proveedorListNew) {
                if (!proveedorListOld.contains(proveedorListNewProveedor)) {
                    CoordTYT oldCedulaeOfProveedorListNewProveedor = proveedorListNewProveedor.getCedulae();
                    proveedorListNewProveedor.setCedulae(coordTYT);
                    proveedorListNewProveedor = em.merge(proveedorListNewProveedor);
                    if (oldCedulaeOfProveedorListNewProveedor != null && !oldCedulaeOfProveedorListNewProveedor.equals(coordTYT)) {
                        oldCedulaeOfProveedorListNewProveedor.getProveedorList().remove(proveedorListNewProveedor);
                        oldCedulaeOfProveedorListNewProveedor = em.merge(oldCedulaeOfProveedorListNewProveedor);
                    }
                }
            }
            for (AsigImpl asigImplListNewAsigImpl : asigImplListNew) {
                if (!asigImplListOld.contains(asigImplListNewAsigImpl)) {
                    CoordTYT oldCooCedulaeOfAsigImplListNewAsigImpl = asigImplListNewAsigImpl.getCooCedulae();
                    asigImplListNewAsigImpl.setCooCedulae(coordTYT);
                    asigImplListNewAsigImpl = em.merge(asigImplListNewAsigImpl);
                    if (oldCooCedulaeOfAsigImplListNewAsigImpl != null && !oldCooCedulaeOfAsigImplListNewAsigImpl.equals(coordTYT)) {
                        oldCooCedulaeOfAsigImplListNewAsigImpl.getAsigImplList().remove(asigImplListNewAsigImpl);
                        oldCooCedulaeOfAsigImplListNewAsigImpl = em.merge(oldCooCedulaeOfAsigImplListNewAsigImpl);
                    }
                }
            }
            for (ActuImpl actuImplListOldActuImpl : actuImplListOld) {
                if (!actuImplListNew.contains(actuImplListOldActuImpl)) {
                    actuImplListOldActuImpl.setCedulae(null);
                    actuImplListOldActuImpl = em.merge(actuImplListOldActuImpl);
                }
            }
            for (ActuImpl actuImplListNewActuImpl : actuImplListNew) {
                if (!actuImplListOld.contains(actuImplListNewActuImpl)) {
                    CoordTYT oldCedulaeOfActuImplListNewActuImpl = actuImplListNewActuImpl.getCedulae();
                    actuImplListNewActuImpl.setCedulae(coordTYT);
                    actuImplListNewActuImpl = em.merge(actuImplListNewActuImpl);
                    if (oldCedulaeOfActuImplListNewActuImpl != null && !oldCedulaeOfActuImplListNewActuImpl.equals(coordTYT)) {
                        oldCedulaeOfActuImplListNewActuImpl.getActuImplList().remove(actuImplListNewActuImpl);
                        oldCedulaeOfActuImplListNewActuImpl = em.merge(oldCedulaeOfActuImplListNewActuImpl);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = coordTYT.getCedulae();
                if (findCoordTYT(id) == null) {
                    throw new NonexistentEntityException("The coordTYT with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CoordTYT coordTYT;
            try {
                coordTYT = em.getReference(CoordTYT.class, id);
                coordTYT.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The coordTYT with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<ImplSeguridad> implSeguridadListOrphanCheck = coordTYT.getImplSeguridadList();
            for (ImplSeguridad implSeguridadListOrphanCheckImplSeguridad : implSeguridadListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This CoordTYT (" + coordTYT + ") cannot be destroyed since the ImplSeguridad " + implSeguridadListOrphanCheckImplSeguridad + " in its implSeguridadList field has a non-nullable cedulae field.");
            }
            List<Proveedor> proveedorListOrphanCheck = coordTYT.getProveedorList();
            for (Proveedor proveedorListOrphanCheckProveedor : proveedorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This CoordTYT (" + coordTYT + ") cannot be destroyed since the Proveedor " + proveedorListOrphanCheckProveedor + " in its proveedorList field has a non-nullable cedulae field.");
            }
            List<AsigImpl> asigImplListOrphanCheck = coordTYT.getAsigImplList();
            for (AsigImpl asigImplListOrphanCheckAsigImpl : asigImplListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This CoordTYT (" + coordTYT + ") cannot be destroyed since the AsigImpl " + asigImplListOrphanCheckAsigImpl + " in its asigImplList field has a non-nullable cooCedulae field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            EmpPlanta empPlanta = coordTYT.getEmpPlanta();
            if (empPlanta != null) {
                empPlanta.setCoordTYT(null);
                empPlanta = em.merge(empPlanta);
            }
            List<ActuImpl> actuImplList = coordTYT.getActuImplList();
            for (ActuImpl actuImplListActuImpl : actuImplList) {
                actuImplListActuImpl.setCedulae(null);
                actuImplListActuImpl = em.merge(actuImplListActuImpl);
            }
            em.remove(coordTYT);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CoordTYT> findCoordTYTEntities() {
        return findCoordTYTEntities(true, -1, -1);
    }

    public List<CoordTYT> findCoordTYTEntities(int maxResults, int firstResult) {
        return findCoordTYTEntities(false, maxResults, firstResult);
    }

    private List<CoordTYT> findCoordTYTEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CoordTYT.class));
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

    public CoordTYT findCoordTYT(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CoordTYT.class, id);
        } finally {
            em.close();
        }
    }

    public int getCoordTYTCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CoordTYT> rt = cq.from(CoordTYT.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
