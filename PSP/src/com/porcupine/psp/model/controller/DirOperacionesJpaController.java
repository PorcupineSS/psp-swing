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
import com.porcupine.psp.model.entity.Comunicado;
import com.porcupine.psp.model.entity.DirOperaciones;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class DirOperacionesJpaController implements Serializable {

    public DirOperacionesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DirOperaciones dirOperaciones) throws IllegalOrphanException, PreexistingEntityException, Exception {
        if (dirOperaciones.getComunicadoList() == null) {
            dirOperaciones.setComunicadoList(new ArrayList<Comunicado>());
        }
        List<String> illegalOrphanMessages = null;
        EmpPlanta empPlantaOrphanCheck = dirOperaciones.getEmpPlanta();
        if (empPlantaOrphanCheck != null) {
            DirOperaciones oldDirOperacionesOfEmpPlanta = empPlantaOrphanCheck.getDirOperaciones();
            if (oldDirOperacionesOfEmpPlanta != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The EmpPlanta " + empPlantaOrphanCheck + " already has an item of type DirOperaciones whose empPlanta column cannot be null. Please make another selection for the empPlanta field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmpPlanta empPlanta = dirOperaciones.getEmpPlanta();
            if (empPlanta != null) {
                empPlanta = em.getReference(empPlanta.getClass(), empPlanta.getCedulae());
                dirOperaciones.setEmpPlanta(empPlanta);
            }
            List<Comunicado> attachedComunicadoList = new ArrayList<Comunicado>();
            for (Comunicado comunicadoListComunicadoToAttach : dirOperaciones.getComunicadoList()) {
                comunicadoListComunicadoToAttach = em.getReference(comunicadoListComunicadoToAttach.getClass(), comunicadoListComunicadoToAttach.getIdComunicado());
                attachedComunicadoList.add(comunicadoListComunicadoToAttach);
            }
            dirOperaciones.setComunicadoList(attachedComunicadoList);
            em.persist(dirOperaciones);
            if (empPlanta != null) {
                empPlanta.setDirOperaciones(dirOperaciones);
                empPlanta = em.merge(empPlanta);
            }
            for (Comunicado comunicadoListComunicado : dirOperaciones.getComunicadoList()) {
                DirOperaciones oldDirCedulaeOfComunicadoListComunicado = comunicadoListComunicado.getDirCedulae();
                comunicadoListComunicado.setDirCedulae(dirOperaciones);
                comunicadoListComunicado = em.merge(comunicadoListComunicado);
                if (oldDirCedulaeOfComunicadoListComunicado != null) {
                    oldDirCedulaeOfComunicadoListComunicado.getComunicadoList().remove(comunicadoListComunicado);
                    oldDirCedulaeOfComunicadoListComunicado = em.merge(oldDirCedulaeOfComunicadoListComunicado);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDirOperaciones(dirOperaciones.getCedulae()) != null) {
                throw new PreexistingEntityException("DirOperaciones " + dirOperaciones + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DirOperaciones dirOperaciones) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DirOperaciones persistentDirOperaciones = em.find(DirOperaciones.class, dirOperaciones.getCedulae());
            EmpPlanta empPlantaOld = persistentDirOperaciones.getEmpPlanta();
            EmpPlanta empPlantaNew = dirOperaciones.getEmpPlanta();
            List<Comunicado> comunicadoListOld = persistentDirOperaciones.getComunicadoList();
            List<Comunicado> comunicadoListNew = dirOperaciones.getComunicadoList();
            List<String> illegalOrphanMessages = null;
            if (empPlantaNew != null && !empPlantaNew.equals(empPlantaOld)) {
                DirOperaciones oldDirOperacionesOfEmpPlanta = empPlantaNew.getDirOperaciones();
                if (oldDirOperacionesOfEmpPlanta != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The EmpPlanta " + empPlantaNew + " already has an item of type DirOperaciones whose empPlanta column cannot be null. Please make another selection for the empPlanta field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empPlantaNew != null) {
                empPlantaNew = em.getReference(empPlantaNew.getClass(), empPlantaNew.getCedulae());
                dirOperaciones.setEmpPlanta(empPlantaNew);
            }
            List<Comunicado> attachedComunicadoListNew = new ArrayList<Comunicado>();
            for (Comunicado comunicadoListNewComunicadoToAttach : comunicadoListNew) {
                comunicadoListNewComunicadoToAttach = em.getReference(comunicadoListNewComunicadoToAttach.getClass(), comunicadoListNewComunicadoToAttach.getIdComunicado());
                attachedComunicadoListNew.add(comunicadoListNewComunicadoToAttach);
            }
            comunicadoListNew = attachedComunicadoListNew;
            dirOperaciones.setComunicadoList(comunicadoListNew);
            dirOperaciones = em.merge(dirOperaciones);
            if (empPlantaOld != null && !empPlantaOld.equals(empPlantaNew)) {
                empPlantaOld.setDirOperaciones(null);
                empPlantaOld = em.merge(empPlantaOld);
            }
            if (empPlantaNew != null && !empPlantaNew.equals(empPlantaOld)) {
                empPlantaNew.setDirOperaciones(dirOperaciones);
                empPlantaNew = em.merge(empPlantaNew);
            }
            for (Comunicado comunicadoListOldComunicado : comunicadoListOld) {
                if (!comunicadoListNew.contains(comunicadoListOldComunicado)) {
                    comunicadoListOldComunicado.setDirCedulae(null);
                    comunicadoListOldComunicado = em.merge(comunicadoListOldComunicado);
                }
            }
            for (Comunicado comunicadoListNewComunicado : comunicadoListNew) {
                if (!comunicadoListOld.contains(comunicadoListNewComunicado)) {
                    DirOperaciones oldDirCedulaeOfComunicadoListNewComunicado = comunicadoListNewComunicado.getDirCedulae();
                    comunicadoListNewComunicado.setDirCedulae(dirOperaciones);
                    comunicadoListNewComunicado = em.merge(comunicadoListNewComunicado);
                    if (oldDirCedulaeOfComunicadoListNewComunicado != null && !oldDirCedulaeOfComunicadoListNewComunicado.equals(dirOperaciones)) {
                        oldDirCedulaeOfComunicadoListNewComunicado.getComunicadoList().remove(comunicadoListNewComunicado);
                        oldDirCedulaeOfComunicadoListNewComunicado = em.merge(oldDirCedulaeOfComunicadoListNewComunicado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dirOperaciones.getCedulae();
                if (findDirOperaciones(id) == null) {
                    throw new NonexistentEntityException("The dirOperaciones with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DirOperaciones dirOperaciones;
            try {
                dirOperaciones = em.getReference(DirOperaciones.class, id);
                dirOperaciones.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dirOperaciones with id " + id + " no longer exists.", enfe);
            }
            EmpPlanta empPlanta = dirOperaciones.getEmpPlanta();
            if (empPlanta != null) {
                empPlanta.setDirOperaciones(null);
                empPlanta = em.merge(empPlanta);
            }
            List<Comunicado> comunicadoList = dirOperaciones.getComunicadoList();
            for (Comunicado comunicadoListComunicado : comunicadoList) {
                comunicadoListComunicado.setDirCedulae(null);
                comunicadoListComunicado = em.merge(comunicadoListComunicado);
            }
            em.remove(dirOperaciones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DirOperaciones> findDirOperacionesEntities() {
        return findDirOperacionesEntities(true, -1, -1);
    }

    public List<DirOperaciones> findDirOperacionesEntities(int maxResults, int firstResult) {
        return findDirOperacionesEntities(false, maxResults, firstResult);
    }

    private List<DirOperaciones> findDirOperacionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DirOperaciones.class));
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

    public DirOperaciones findDirOperaciones(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DirOperaciones.class, id);
        } finally {
            em.close();
        }
    }

    public int getDirOperacionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DirOperaciones> rt = cq.from(DirOperaciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
