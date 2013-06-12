/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.entity.AsignacionC;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.porcupine.psp.model.entity.CoordContrato;
import com.porcupine.psp.model.entity.Contrato;
import com.porcupine.psp.model.entity.EmpTemp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class AsignacionCJpaController implements Serializable {

    public AsignacionCJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AsignacionC asignacionC) {
        if (asignacionC.getEmpTempList() == null) {
            asignacionC.setEmpTempList(new ArrayList<EmpTemp>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CoordContrato cooCedulae = asignacionC.getCooCedulae();
            if (cooCedulae != null) {
                cooCedulae = em.getReference(cooCedulae.getClass(), cooCedulae.getCedulae());
                asignacionC.setCooCedulae(cooCedulae);
            }
            Contrato idContrato = asignacionC.getIdContrato();
            if (idContrato != null) {
                idContrato = em.getReference(idContrato.getClass(), idContrato.getIdContrato());
                asignacionC.setIdContrato(idContrato);
            }
            List<EmpTemp> attachedEmpTempList = new ArrayList<EmpTemp>();
            for (EmpTemp empTempListEmpTempToAttach : asignacionC.getEmpTempList()) {
                empTempListEmpTempToAttach = em.getReference(empTempListEmpTempToAttach.getClass(), empTempListEmpTempToAttach.getCedulae());
                attachedEmpTempList.add(empTempListEmpTempToAttach);
            }
            asignacionC.setEmpTempList(attachedEmpTempList);
            em.persist(asignacionC);
            if (cooCedulae != null) {
                cooCedulae.getAsignacionCList().add(asignacionC);
                cooCedulae = em.merge(cooCedulae);
            }
            if (idContrato != null) {
                idContrato.getAsignacionCList().add(asignacionC);
                idContrato = em.merge(idContrato);
            }
            for (EmpTemp empTempListEmpTemp : asignacionC.getEmpTempList()) {
                AsignacionC oldIdAsigOfEmpTempListEmpTemp = empTempListEmpTemp.getIdAsig();
                empTempListEmpTemp.setIdAsig(asignacionC);
                empTempListEmpTemp = em.merge(empTempListEmpTemp);
                if (oldIdAsigOfEmpTempListEmpTemp != null) {
                    oldIdAsigOfEmpTempListEmpTemp.getEmpTempList().remove(empTempListEmpTemp);
                    oldIdAsigOfEmpTempListEmpTemp = em.merge(oldIdAsigOfEmpTempListEmpTemp);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AsignacionC asignacionC) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AsignacionC persistentAsignacionC = em.find(AsignacionC.class, asignacionC.getIdAsig());
            CoordContrato cooCedulaeOld = persistentAsignacionC.getCooCedulae();
            CoordContrato cooCedulaeNew = asignacionC.getCooCedulae();
            Contrato idContratoOld = persistentAsignacionC.getIdContrato();
            Contrato idContratoNew = asignacionC.getIdContrato();
            List<EmpTemp> empTempListOld = persistentAsignacionC.getEmpTempList();
            List<EmpTemp> empTempListNew = asignacionC.getEmpTempList();
            if (cooCedulaeNew != null) {
                cooCedulaeNew = em.getReference(cooCedulaeNew.getClass(), cooCedulaeNew.getCedulae());
                asignacionC.setCooCedulae(cooCedulaeNew);
            }
            if (idContratoNew != null) {
                idContratoNew = em.getReference(idContratoNew.getClass(), idContratoNew.getIdContrato());
                asignacionC.setIdContrato(idContratoNew);
            }
            List<EmpTemp> attachedEmpTempListNew = new ArrayList<EmpTemp>();
            for (EmpTemp empTempListNewEmpTempToAttach : empTempListNew) {
                empTempListNewEmpTempToAttach = em.getReference(empTempListNewEmpTempToAttach.getClass(), empTempListNewEmpTempToAttach.getCedulae());
                attachedEmpTempListNew.add(empTempListNewEmpTempToAttach);
            }
            empTempListNew = attachedEmpTempListNew;
            asignacionC.setEmpTempList(empTempListNew);
            asignacionC = em.merge(asignacionC);
            if (cooCedulaeOld != null && !cooCedulaeOld.equals(cooCedulaeNew)) {
                cooCedulaeOld.getAsignacionCList().remove(asignacionC);
                cooCedulaeOld = em.merge(cooCedulaeOld);
            }
            if (cooCedulaeNew != null && !cooCedulaeNew.equals(cooCedulaeOld)) {
                cooCedulaeNew.getAsignacionCList().add(asignacionC);
                cooCedulaeNew = em.merge(cooCedulaeNew);
            }
            if (idContratoOld != null && !idContratoOld.equals(idContratoNew)) {
                idContratoOld.getAsignacionCList().remove(asignacionC);
                idContratoOld = em.merge(idContratoOld);
            }
            if (idContratoNew != null && !idContratoNew.equals(idContratoOld)) {
                idContratoNew.getAsignacionCList().add(asignacionC);
                idContratoNew = em.merge(idContratoNew);
            }
            for (EmpTemp empTempListOldEmpTemp : empTempListOld) {
                if (!empTempListNew.contains(empTempListOldEmpTemp)) {
                    empTempListOldEmpTemp.setIdAsig(null);
                    empTempListOldEmpTemp = em.merge(empTempListOldEmpTemp);
                }
            }
            for (EmpTemp empTempListNewEmpTemp : empTempListNew) {
                if (!empTempListOld.contains(empTempListNewEmpTemp)) {
                    AsignacionC oldIdAsigOfEmpTempListNewEmpTemp = empTempListNewEmpTemp.getIdAsig();
                    empTempListNewEmpTemp.setIdAsig(asignacionC);
                    empTempListNewEmpTemp = em.merge(empTempListNewEmpTemp);
                    if (oldIdAsigOfEmpTempListNewEmpTemp != null && !oldIdAsigOfEmpTempListNewEmpTemp.equals(asignacionC)) {
                        oldIdAsigOfEmpTempListNewEmpTemp.getEmpTempList().remove(empTempListNewEmpTemp);
                        oldIdAsigOfEmpTempListNewEmpTemp = em.merge(oldIdAsigOfEmpTempListNewEmpTemp);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = asignacionC.getIdAsig();
                if (findAsignacionC(id) == null) {
                    throw new NonexistentEntityException("The asignacionC with id " + id + " no longer exists.");
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
            AsignacionC asignacionC;
            try {
                asignacionC = em.getReference(AsignacionC.class, id);
                asignacionC.getIdAsig();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asignacionC with id " + id + " no longer exists.", enfe);
            }
            CoordContrato cooCedulae = asignacionC.getCooCedulae();
            if (cooCedulae != null) {
                cooCedulae.getAsignacionCList().remove(asignacionC);
                cooCedulae = em.merge(cooCedulae);
            }
            Contrato idContrato = asignacionC.getIdContrato();
            if (idContrato != null) {
                idContrato.getAsignacionCList().remove(asignacionC);
                idContrato = em.merge(idContrato);
            }
            List<EmpTemp> empTempList = asignacionC.getEmpTempList();
            for (EmpTemp empTempListEmpTemp : empTempList) {
                empTempListEmpTemp.setIdAsig(null);
                empTempListEmpTemp = em.merge(empTempListEmpTemp);
            }
            em.remove(asignacionC);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AsignacionC> findAsignacionCEntities() {
        return findAsignacionCEntities(true, -1, -1);
    }

    public List<AsignacionC> findAsignacionCEntities(int maxResults, int firstResult) {
        return findAsignacionCEntities(false, maxResults, firstResult);
    }

    private List<AsignacionC> findAsignacionCEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AsignacionC.class));
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

    public AsignacionC findAsignacionC(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AsignacionC.class, id);
        } finally {
            em.close();
        }
    }

    public int getAsignacionCCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AsignacionC> rt = cq.from(AsignacionC.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
