/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.IllegalOrphanException;
import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.porcupine.psp.model.entity.DirComercial;
import com.porcupine.psp.model.entity.Cliente;
import com.porcupine.psp.model.entity.AsignacionC;
import com.porcupine.psp.model.entity.Contrato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class ContratoJpaController implements Serializable {

    public ContratoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contrato contrato) {
        if (contrato.getAsignacionCList() == null) {
            contrato.setAsignacionCList(new ArrayList<AsignacionC>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DirComercial cedulae = contrato.getCedulae();
            if (cedulae != null) {
                cedulae = em.getReference(cedulae.getClass(), cedulae.getCedulae());
                contrato.setCedulae(cedulae);
            }
            Cliente idcl = contrato.getIdcl();
            if (idcl != null) {
                idcl = em.getReference(idcl.getClass(), idcl.getIdcl());
                contrato.setIdcl(idcl);
            }
            List<AsignacionC> attachedAsignacionCList = new ArrayList<AsignacionC>();
            for (AsignacionC asignacionCListAsignacionCToAttach : contrato.getAsignacionCList()) {
                asignacionCListAsignacionCToAttach = em.getReference(asignacionCListAsignacionCToAttach.getClass(), asignacionCListAsignacionCToAttach.getIdAsig());
                attachedAsignacionCList.add(asignacionCListAsignacionCToAttach);
            }
            contrato.setAsignacionCList(attachedAsignacionCList);
            em.persist(contrato);
            if (cedulae != null) {
                cedulae.getContratoList().add(contrato);
                cedulae = em.merge(cedulae);
            }
            if (idcl != null) {
                idcl.getContratoList().add(contrato);
                idcl = em.merge(idcl);
            }
            for (AsignacionC asignacionCListAsignacionC : contrato.getAsignacionCList()) {
                Contrato oldIdContratoOfAsignacionCListAsignacionC = asignacionCListAsignacionC.getIdContrato();
                asignacionCListAsignacionC.setIdContrato(contrato);
                asignacionCListAsignacionC = em.merge(asignacionCListAsignacionC);
                if (oldIdContratoOfAsignacionCListAsignacionC != null) {
                    oldIdContratoOfAsignacionCListAsignacionC.getAsignacionCList().remove(asignacionCListAsignacionC);
                    oldIdContratoOfAsignacionCListAsignacionC = em.merge(oldIdContratoOfAsignacionCListAsignacionC);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contrato contrato) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contrato persistentContrato = em.find(Contrato.class, contrato.getIdContrato());
            DirComercial cedulaeOld = persistentContrato.getCedulae();
            DirComercial cedulaeNew = contrato.getCedulae();
            Cliente idclOld = persistentContrato.getIdcl();
            Cliente idclNew = contrato.getIdcl();
            List<AsignacionC> asignacionCListOld = persistentContrato.getAsignacionCList();
            List<AsignacionC> asignacionCListNew = contrato.getAsignacionCList();
            List<String> illegalOrphanMessages = null;
            for (AsignacionC asignacionCListOldAsignacionC : asignacionCListOld) {
                if (!asignacionCListNew.contains(asignacionCListOldAsignacionC)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AsignacionC " + asignacionCListOldAsignacionC + " since its idContrato field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (cedulaeNew != null) {
                cedulaeNew = em.getReference(cedulaeNew.getClass(), cedulaeNew.getCedulae());
                contrato.setCedulae(cedulaeNew);
            }
            if (idclNew != null) {
                idclNew = em.getReference(idclNew.getClass(), idclNew.getIdcl());
                contrato.setIdcl(idclNew);
            }
            List<AsignacionC> attachedAsignacionCListNew = new ArrayList<AsignacionC>();
            for (AsignacionC asignacionCListNewAsignacionCToAttach : asignacionCListNew) {
                asignacionCListNewAsignacionCToAttach = em.getReference(asignacionCListNewAsignacionCToAttach.getClass(), asignacionCListNewAsignacionCToAttach.getIdAsig());
                attachedAsignacionCListNew.add(asignacionCListNewAsignacionCToAttach);
            }
            asignacionCListNew = attachedAsignacionCListNew;
            contrato.setAsignacionCList(asignacionCListNew);
            contrato = em.merge(contrato);
            if (cedulaeOld != null && !cedulaeOld.equals(cedulaeNew)) {
                cedulaeOld.getContratoList().remove(contrato);
                cedulaeOld = em.merge(cedulaeOld);
            }
            if (cedulaeNew != null && !cedulaeNew.equals(cedulaeOld)) {
                cedulaeNew.getContratoList().add(contrato);
                cedulaeNew = em.merge(cedulaeNew);
            }
            if (idclOld != null && !idclOld.equals(idclNew)) {
                idclOld.getContratoList().remove(contrato);
                idclOld = em.merge(idclOld);
            }
            if (idclNew != null && !idclNew.equals(idclOld)) {
                idclNew.getContratoList().add(contrato);
                idclNew = em.merge(idclNew);
            }
            for (AsignacionC asignacionCListNewAsignacionC : asignacionCListNew) {
                if (!asignacionCListOld.contains(asignacionCListNewAsignacionC)) {
                    Contrato oldIdContratoOfAsignacionCListNewAsignacionC = asignacionCListNewAsignacionC.getIdContrato();
                    asignacionCListNewAsignacionC.setIdContrato(contrato);
                    asignacionCListNewAsignacionC = em.merge(asignacionCListNewAsignacionC);
                    if (oldIdContratoOfAsignacionCListNewAsignacionC != null && !oldIdContratoOfAsignacionCListNewAsignacionC.equals(contrato)) {
                        oldIdContratoOfAsignacionCListNewAsignacionC.getAsignacionCList().remove(asignacionCListNewAsignacionC);
                        oldIdContratoOfAsignacionCListNewAsignacionC = em.merge(oldIdContratoOfAsignacionCListNewAsignacionC);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = contrato.getIdContrato();
                if (findContrato(id) == null) {
                    throw new NonexistentEntityException("The contrato with id " + id + " no longer exists.");
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
            Contrato contrato;
            try {
                contrato = em.getReference(Contrato.class, id);
                contrato.getIdContrato();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contrato with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<AsignacionC> asignacionCListOrphanCheck = contrato.getAsignacionCList();
            for (AsignacionC asignacionCListOrphanCheckAsignacionC : asignacionCListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Contrato (" + contrato + ") cannot be destroyed since the AsignacionC " + asignacionCListOrphanCheckAsignacionC + " in its asignacionCList field has a non-nullable idContrato field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            DirComercial cedulae = contrato.getCedulae();
            if (cedulae != null) {
                cedulae.getContratoList().remove(contrato);
                cedulae = em.merge(cedulae);
            }
            Cliente idcl = contrato.getIdcl();
            if (idcl != null) {
                idcl.getContratoList().remove(contrato);
                idcl = em.merge(idcl);
            }
            em.remove(contrato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contrato> findContratoEntities() {
        return findContratoEntities(true, -1, -1);
    }

    public List<Contrato> findContratoEntities(int maxResults, int firstResult) {
        return findContratoEntities(false, maxResults, firstResult);
    }

    private List<Contrato> findContratoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contrato.class));
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

    public Contrato findContrato(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contrato.class, id);
        } finally {
            em.close();
        }
    }

    public int getContratoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contrato> rt = cq.from(Contrato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
