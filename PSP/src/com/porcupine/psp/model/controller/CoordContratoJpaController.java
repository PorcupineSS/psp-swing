/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.IllegalOrphanException;
import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.porcupine.psp.model.entity.EmpPlanta;
import com.porcupine.psp.model.entity.AsignacionC;
import com.porcupine.psp.model.entity.CoordContrato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class CoordContratoJpaController implements Serializable {

    public CoordContratoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CoordContrato coordContrato) throws IllegalOrphanException, PreexistingEntityException, Exception {
        if (coordContrato.getAsignacionCList() == null) {
            coordContrato.setAsignacionCList(new ArrayList<AsignacionC>());
        }
        List<String> illegalOrphanMessages = null;
        EmpPlanta empPlantaOrphanCheck = coordContrato.getEmpPlanta();
        if (empPlantaOrphanCheck != null) {
            CoordContrato oldCoordContratoOfEmpPlanta = empPlantaOrphanCheck.getCoordContrato();
            if (oldCoordContratoOfEmpPlanta != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The EmpPlanta " + empPlantaOrphanCheck + " already has an item of type CoordContrato whose empPlanta column cannot be null. Please make another selection for the empPlanta field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmpPlanta empPlanta = coordContrato.getEmpPlanta();
            if (empPlanta != null) {
                empPlanta = em.getReference(empPlanta.getClass(), empPlanta.getCedulae());
                coordContrato.setEmpPlanta(empPlanta);
            }
            List<AsignacionC> attachedAsignacionCList = new ArrayList<AsignacionC>();
            for (AsignacionC asignacionCListAsignacionCToAttach : coordContrato.getAsignacionCList()) {
                asignacionCListAsignacionCToAttach = em.getReference(asignacionCListAsignacionCToAttach.getClass(), asignacionCListAsignacionCToAttach.getIdAsig());
                attachedAsignacionCList.add(asignacionCListAsignacionCToAttach);
            }
            coordContrato.setAsignacionCList(attachedAsignacionCList);
            em.persist(coordContrato);
            if (empPlanta != null) {
                empPlanta.setCoordContrato(coordContrato);
                empPlanta = em.merge(empPlanta);
            }
            for (AsignacionC asignacionCListAsignacionC : coordContrato.getAsignacionCList()) {
                CoordContrato oldCooCedulaeOfAsignacionCListAsignacionC = asignacionCListAsignacionC.getCooCedulae();
                asignacionCListAsignacionC.setCooCedulae(coordContrato);
                asignacionCListAsignacionC = em.merge(asignacionCListAsignacionC);
                if (oldCooCedulaeOfAsignacionCListAsignacionC != null) {
                    oldCooCedulaeOfAsignacionCListAsignacionC.getAsignacionCList().remove(asignacionCListAsignacionC);
                    oldCooCedulaeOfAsignacionCListAsignacionC = em.merge(oldCooCedulaeOfAsignacionCListAsignacionC);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCoordContrato(coordContrato.getCedulae()) != null) {
                throw new PreexistingEntityException("CoordContrato " + coordContrato + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CoordContrato coordContrato) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CoordContrato persistentCoordContrato = em.find(CoordContrato.class, coordContrato.getCedulae());
            EmpPlanta empPlantaOld = persistentCoordContrato.getEmpPlanta();
            EmpPlanta empPlantaNew = coordContrato.getEmpPlanta();
            List<AsignacionC> asignacionCListOld = persistentCoordContrato.getAsignacionCList();
            List<AsignacionC> asignacionCListNew = coordContrato.getAsignacionCList();
            List<String> illegalOrphanMessages = null;
            if (empPlantaNew != null && !empPlantaNew.equals(empPlantaOld)) {
                CoordContrato oldCoordContratoOfEmpPlanta = empPlantaNew.getCoordContrato();
                if (oldCoordContratoOfEmpPlanta != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The EmpPlanta " + empPlantaNew + " already has an item of type CoordContrato whose empPlanta column cannot be null. Please make another selection for the empPlanta field.");
                }
            }
            for (AsignacionC asignacionCListOldAsignacionC : asignacionCListOld) {
                if (!asignacionCListNew.contains(asignacionCListOldAsignacionC)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AsignacionC " + asignacionCListOldAsignacionC + " since its cooCedulae field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empPlantaNew != null) {
                empPlantaNew = em.getReference(empPlantaNew.getClass(), empPlantaNew.getCedulae());
                coordContrato.setEmpPlanta(empPlantaNew);
            }
            List<AsignacionC> attachedAsignacionCListNew = new ArrayList<AsignacionC>();
            for (AsignacionC asignacionCListNewAsignacionCToAttach : asignacionCListNew) {
                asignacionCListNewAsignacionCToAttach = em.getReference(asignacionCListNewAsignacionCToAttach.getClass(), asignacionCListNewAsignacionCToAttach.getIdAsig());
                attachedAsignacionCListNew.add(asignacionCListNewAsignacionCToAttach);
            }
            asignacionCListNew = attachedAsignacionCListNew;
            coordContrato.setAsignacionCList(asignacionCListNew);
            coordContrato = em.merge(coordContrato);
            if (empPlantaOld != null && !empPlantaOld.equals(empPlantaNew)) {
                empPlantaOld.setCoordContrato(null);
                empPlantaOld = em.merge(empPlantaOld);
            }
            if (empPlantaNew != null && !empPlantaNew.equals(empPlantaOld)) {
                empPlantaNew.setCoordContrato(coordContrato);
                empPlantaNew = em.merge(empPlantaNew);
            }
            for (AsignacionC asignacionCListNewAsignacionC : asignacionCListNew) {
                if (!asignacionCListOld.contains(asignacionCListNewAsignacionC)) {
                    CoordContrato oldCooCedulaeOfAsignacionCListNewAsignacionC = asignacionCListNewAsignacionC.getCooCedulae();
                    asignacionCListNewAsignacionC.setCooCedulae(coordContrato);
                    asignacionCListNewAsignacionC = em.merge(asignacionCListNewAsignacionC);
                    if (oldCooCedulaeOfAsignacionCListNewAsignacionC != null && !oldCooCedulaeOfAsignacionCListNewAsignacionC.equals(coordContrato)) {
                        oldCooCedulaeOfAsignacionCListNewAsignacionC.getAsignacionCList().remove(asignacionCListNewAsignacionC);
                        oldCooCedulaeOfAsignacionCListNewAsignacionC = em.merge(oldCooCedulaeOfAsignacionCListNewAsignacionC);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = coordContrato.getCedulae();
                if (findCoordContrato(id) == null) {
                    throw new NonexistentEntityException("The coordContrato with id " + id + " no longer exists.");
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
            CoordContrato coordContrato;
            try {
                coordContrato = em.getReference(CoordContrato.class, id);
                coordContrato.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The coordContrato with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<AsignacionC> asignacionCListOrphanCheck = coordContrato.getAsignacionCList();
            for (AsignacionC asignacionCListOrphanCheckAsignacionC : asignacionCListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This CoordContrato (" + coordContrato + ") cannot be destroyed since the AsignacionC " + asignacionCListOrphanCheckAsignacionC + " in its asignacionCList field has a non-nullable cooCedulae field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            EmpPlanta empPlanta = coordContrato.getEmpPlanta();
            if (empPlanta != null) {
                empPlanta.setCoordContrato(null);
                empPlanta = em.merge(empPlanta);
            }
            em.remove(coordContrato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CoordContrato> findCoordContratoEntities() {
        return findCoordContratoEntities(true, -1, -1);
    }

    public List<CoordContrato> findCoordContratoEntities(int maxResults, int firstResult) {
        return findCoordContratoEntities(false, maxResults, firstResult);
    }

    private List<CoordContrato> findCoordContratoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CoordContrato.class));
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

    public CoordContrato findCoordContrato(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CoordContrato.class, id);
        } finally {
            em.close();
        }
    }

    public int getCoordContratoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CoordContrato> rt = cq.from(CoordContrato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
