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
import com.porcupine.psp.model.entity.Actualizacion;
import com.porcupine.psp.model.entity.Subgerente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class SubgerenteJpaController implements Serializable {

    public SubgerenteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Subgerente subgerente) throws IllegalOrphanException, PreexistingEntityException, Exception {
        if (subgerente.getActualizacionList() == null) {
            subgerente.setActualizacionList(new ArrayList<Actualizacion>());
        }
        List<String> illegalOrphanMessages = null;
        EmpPlanta empPlantaOrphanCheck = subgerente.getEmpPlanta();
        if (empPlantaOrphanCheck != null) {
            Subgerente oldSubgerenteOfEmpPlanta = empPlantaOrphanCheck.getSubgerente();
            if (oldSubgerenteOfEmpPlanta != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The EmpPlanta " + empPlantaOrphanCheck + " already has an item of type Subgerente whose empPlanta column cannot be null. Please make another selection for the empPlanta field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmpPlanta empPlanta = subgerente.getEmpPlanta();
            if (empPlanta != null) {
                empPlanta = em.getReference(empPlanta.getClass(), empPlanta.getCedulae());
                subgerente.setEmpPlanta(empPlanta);
            }
            List<Actualizacion> attachedActualizacionList = new ArrayList<Actualizacion>();
            for (Actualizacion actualizacionListActualizacionToAttach : subgerente.getActualizacionList()) {
                actualizacionListActualizacionToAttach = em.getReference(actualizacionListActualizacionToAttach.getClass(), actualizacionListActualizacionToAttach.getActualizacionPK());
                attachedActualizacionList.add(actualizacionListActualizacionToAttach);
            }
            subgerente.setActualizacionList(attachedActualizacionList);
            em.persist(subgerente);
            if (empPlanta != null) {
                empPlanta.setSubgerente(subgerente);
                empPlanta = em.merge(empPlanta);
            }
            for (Actualizacion actualizacionListActualizacion : subgerente.getActualizacionList()) {
                Subgerente oldSubgerenteOfActualizacionListActualizacion = actualizacionListActualizacion.getSubgerente();
                actualizacionListActualizacion.setSubgerente(subgerente);
                actualizacionListActualizacion = em.merge(actualizacionListActualizacion);
                if (oldSubgerenteOfActualizacionListActualizacion != null) {
                    oldSubgerenteOfActualizacionListActualizacion.getActualizacionList().remove(actualizacionListActualizacion);
                    oldSubgerenteOfActualizacionListActualizacion = em.merge(oldSubgerenteOfActualizacionListActualizacion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSubgerente(subgerente.getCedulae()) != null) {
                throw new PreexistingEntityException("Subgerente " + subgerente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Subgerente subgerente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Subgerente persistentSubgerente = em.find(Subgerente.class, subgerente.getCedulae());
            EmpPlanta empPlantaOld = persistentSubgerente.getEmpPlanta();
            EmpPlanta empPlantaNew = subgerente.getEmpPlanta();
            List<Actualizacion> actualizacionListOld = persistentSubgerente.getActualizacionList();
            List<Actualizacion> actualizacionListNew = subgerente.getActualizacionList();
            List<String> illegalOrphanMessages = null;
            if (empPlantaNew != null && !empPlantaNew.equals(empPlantaOld)) {
                Subgerente oldSubgerenteOfEmpPlanta = empPlantaNew.getSubgerente();
                if (oldSubgerenteOfEmpPlanta != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The EmpPlanta " + empPlantaNew + " already has an item of type Subgerente whose empPlanta column cannot be null. Please make another selection for the empPlanta field.");
                }
            }
            for (Actualizacion actualizacionListOldActualizacion : actualizacionListOld) {
                if (!actualizacionListNew.contains(actualizacionListOldActualizacion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Actualizacion " + actualizacionListOldActualizacion + " since its subgerente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empPlantaNew != null) {
                empPlantaNew = em.getReference(empPlantaNew.getClass(), empPlantaNew.getCedulae());
                subgerente.setEmpPlanta(empPlantaNew);
            }
            List<Actualizacion> attachedActualizacionListNew = new ArrayList<Actualizacion>();
            for (Actualizacion actualizacionListNewActualizacionToAttach : actualizacionListNew) {
                actualizacionListNewActualizacionToAttach = em.getReference(actualizacionListNewActualizacionToAttach.getClass(), actualizacionListNewActualizacionToAttach.getActualizacionPK());
                attachedActualizacionListNew.add(actualizacionListNewActualizacionToAttach);
            }
            actualizacionListNew = attachedActualizacionListNew;
            subgerente.setActualizacionList(actualizacionListNew);
            subgerente = em.merge(subgerente);
            if (empPlantaOld != null && !empPlantaOld.equals(empPlantaNew)) {
                empPlantaOld.setSubgerente(null);
                empPlantaOld = em.merge(empPlantaOld);
            }
            if (empPlantaNew != null && !empPlantaNew.equals(empPlantaOld)) {
                empPlantaNew.setSubgerente(subgerente);
                empPlantaNew = em.merge(empPlantaNew);
            }
            for (Actualizacion actualizacionListNewActualizacion : actualizacionListNew) {
                if (!actualizacionListOld.contains(actualizacionListNewActualizacion)) {
                    Subgerente oldSubgerenteOfActualizacionListNewActualizacion = actualizacionListNewActualizacion.getSubgerente();
                    actualizacionListNewActualizacion.setSubgerente(subgerente);
                    actualizacionListNewActualizacion = em.merge(actualizacionListNewActualizacion);
                    if (oldSubgerenteOfActualizacionListNewActualizacion != null && !oldSubgerenteOfActualizacionListNewActualizacion.equals(subgerente)) {
                        oldSubgerenteOfActualizacionListNewActualizacion.getActualizacionList().remove(actualizacionListNewActualizacion);
                        oldSubgerenteOfActualizacionListNewActualizacion = em.merge(oldSubgerenteOfActualizacionListNewActualizacion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = subgerente.getCedulae();
                if (findSubgerente(id) == null) {
                    throw new NonexistentEntityException("The subgerente with id " + id + " no longer exists.");
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
            Subgerente subgerente;
            try {
                subgerente = em.getReference(Subgerente.class, id);
                subgerente.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The subgerente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Actualizacion> actualizacionListOrphanCheck = subgerente.getActualizacionList();
            for (Actualizacion actualizacionListOrphanCheckActualizacion : actualizacionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Subgerente (" + subgerente + ") cannot be destroyed since the Actualizacion " + actualizacionListOrphanCheckActualizacion + " in its actualizacionList field has a non-nullable subgerente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            EmpPlanta empPlanta = subgerente.getEmpPlanta();
            if (empPlanta != null) {
                empPlanta.setSubgerente(null);
                empPlanta = em.merge(empPlanta);
            }
            em.remove(subgerente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Subgerente> findSubgerenteEntities() {
        return findSubgerenteEntities(true, -1, -1);
    }

    public List<Subgerente> findSubgerenteEntities(int maxResults, int firstResult) {
        return findSubgerenteEntities(false, maxResults, firstResult);
    }

    private List<Subgerente> findSubgerenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Subgerente.class));
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

    public Subgerente findSubgerente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Subgerente.class, id);
        } finally {
            em.close();
        }
    }

    public int getSubgerenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Subgerente> rt = cq.from(Subgerente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
