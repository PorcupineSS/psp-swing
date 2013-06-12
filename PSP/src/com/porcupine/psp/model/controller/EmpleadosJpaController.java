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
public class EmpleadosJpaController implements Serializable {

    public EmpleadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleados empleados) throws PreexistingEntityException, Exception {
        if (empleados.getTelsEmpList() == null) {
            empleados.setTelsEmpList(new ArrayList<TelsEmp>());
        }
        if (empleados.getBitacoraSegList() == null) {
            empleados.setBitacoraSegList(new ArrayList<BitacoraSeg>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmpTemp empTemp = empleados.getEmpTemp();
            if (empTemp != null) {
                empTemp = em.getReference(empTemp.getClass(), empTemp.getCedulae());
                empleados.setEmpTemp(empTemp);
            }
            EmpPlanta empPlanta = empleados.getEmpPlanta();
            if (empPlanta != null) {
                empPlanta = em.getReference(empPlanta.getClass(), empPlanta.getCedulae());
                empleados.setEmpPlanta(empPlanta);
            }
            DirGestionHum dirCedulae = empleados.getDirCedulae();
            if (dirCedulae != null) {
                dirCedulae = em.getReference(dirCedulae.getClass(), dirCedulae.getCedulae());
                empleados.setDirCedulae(dirCedulae);
            }
            List<TelsEmp> attachedTelsEmpList = new ArrayList<TelsEmp>();
            for (TelsEmp telsEmpListTelsEmpToAttach : empleados.getTelsEmpList()) {
                telsEmpListTelsEmpToAttach = em.getReference(telsEmpListTelsEmpToAttach.getClass(), telsEmpListTelsEmpToAttach.getIdTe());
                attachedTelsEmpList.add(telsEmpListTelsEmpToAttach);
            }
            empleados.setTelsEmpList(attachedTelsEmpList);
            List<BitacoraSeg> attachedBitacoraSegList = new ArrayList<BitacoraSeg>();
            for (BitacoraSeg bitacoraSegListBitacoraSegToAttach : empleados.getBitacoraSegList()) {
                bitacoraSegListBitacoraSegToAttach = em.getReference(bitacoraSegListBitacoraSegToAttach.getClass(), bitacoraSegListBitacoraSegToAttach.getIdOper());
                attachedBitacoraSegList.add(bitacoraSegListBitacoraSegToAttach);
            }
            empleados.setBitacoraSegList(attachedBitacoraSegList);
            em.persist(empleados);
            if (empTemp != null) {
                Empleados oldEmpleadosOfEmpTemp = empTemp.getEmpleados();
                if (oldEmpleadosOfEmpTemp != null) {
                    oldEmpleadosOfEmpTemp.setEmpTemp(null);
                    oldEmpleadosOfEmpTemp = em.merge(oldEmpleadosOfEmpTemp);
                }
                empTemp.setEmpleados(empleados);
                empTemp = em.merge(empTemp);
            }
            if (empPlanta != null) {
                Empleados oldEmpleadosOfEmpPlanta = empPlanta.getEmpleados();
                if (oldEmpleadosOfEmpPlanta != null) {
                    oldEmpleadosOfEmpPlanta.setEmpPlanta(null);
                    oldEmpleadosOfEmpPlanta = em.merge(oldEmpleadosOfEmpPlanta);
                }
                empPlanta.setEmpleados(empleados);
                empPlanta = em.merge(empPlanta);
            }
            if (dirCedulae != null) {
                dirCedulae.getEmpleadosList().add(empleados);
                dirCedulae = em.merge(dirCedulae);
            }
            for (TelsEmp telsEmpListTelsEmp : empleados.getTelsEmpList()) {
                telsEmpListTelsEmp.getEmpleadosList().add(empleados);
                telsEmpListTelsEmp = em.merge(telsEmpListTelsEmp);
            }
            for (BitacoraSeg bitacoraSegListBitacoraSeg : empleados.getBitacoraSegList()) {
                Empleados oldCedulaeOfBitacoraSegListBitacoraSeg = bitacoraSegListBitacoraSeg.getCedulae();
                bitacoraSegListBitacoraSeg.setCedulae(empleados);
                bitacoraSegListBitacoraSeg = em.merge(bitacoraSegListBitacoraSeg);
                if (oldCedulaeOfBitacoraSegListBitacoraSeg != null) {
                    oldCedulaeOfBitacoraSegListBitacoraSeg.getBitacoraSegList().remove(bitacoraSegListBitacoraSeg);
                    oldCedulaeOfBitacoraSegListBitacoraSeg = em.merge(oldCedulaeOfBitacoraSegListBitacoraSeg);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpleados(empleados.getCedulae()) != null) {
                throw new PreexistingEntityException("Empleados " + empleados + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleados empleados) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados persistentEmpleados = em.find(Empleados.class, empleados.getCedulae());
            EmpTemp empTempOld = persistentEmpleados.getEmpTemp();
            EmpTemp empTempNew = empleados.getEmpTemp();
            EmpPlanta empPlantaOld = persistentEmpleados.getEmpPlanta();
            EmpPlanta empPlantaNew = empleados.getEmpPlanta();
            DirGestionHum dirCedulaeOld = persistentEmpleados.getDirCedulae();
            DirGestionHum dirCedulaeNew = empleados.getDirCedulae();
            List<TelsEmp> telsEmpListOld = persistentEmpleados.getTelsEmpList();
            List<TelsEmp> telsEmpListNew = empleados.getTelsEmpList();
            List<BitacoraSeg> bitacoraSegListOld = persistentEmpleados.getBitacoraSegList();
            List<BitacoraSeg> bitacoraSegListNew = empleados.getBitacoraSegList();
            List<String> illegalOrphanMessages = null;
            if (empTempOld != null && !empTempOld.equals(empTempNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain EmpTemp " + empTempOld + " since its empleados field is not nullable.");
            }
            if (empPlantaOld != null && !empPlantaOld.equals(empPlantaNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain EmpPlanta " + empPlantaOld + " since its empleados field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empTempNew != null) {
                empTempNew = em.getReference(empTempNew.getClass(), empTempNew.getCedulae());
                empleados.setEmpTemp(empTempNew);
            }
            if (empPlantaNew != null) {
                empPlantaNew = em.getReference(empPlantaNew.getClass(), empPlantaNew.getCedulae());
                empleados.setEmpPlanta(empPlantaNew);
            }
            if (dirCedulaeNew != null) {
                dirCedulaeNew = em.getReference(dirCedulaeNew.getClass(), dirCedulaeNew.getCedulae());
                empleados.setDirCedulae(dirCedulaeNew);
            }
            List<TelsEmp> attachedTelsEmpListNew = new ArrayList<TelsEmp>();
            for (TelsEmp telsEmpListNewTelsEmpToAttach : telsEmpListNew) {
                telsEmpListNewTelsEmpToAttach = em.getReference(telsEmpListNewTelsEmpToAttach.getClass(), telsEmpListNewTelsEmpToAttach.getIdTe());
                attachedTelsEmpListNew.add(telsEmpListNewTelsEmpToAttach);
            }
            telsEmpListNew = attachedTelsEmpListNew;
            empleados.setTelsEmpList(telsEmpListNew);
            List<BitacoraSeg> attachedBitacoraSegListNew = new ArrayList<BitacoraSeg>();
            for (BitacoraSeg bitacoraSegListNewBitacoraSegToAttach : bitacoraSegListNew) {
                bitacoraSegListNewBitacoraSegToAttach = em.getReference(bitacoraSegListNewBitacoraSegToAttach.getClass(), bitacoraSegListNewBitacoraSegToAttach.getIdOper());
                attachedBitacoraSegListNew.add(bitacoraSegListNewBitacoraSegToAttach);
            }
            bitacoraSegListNew = attachedBitacoraSegListNew;
            empleados.setBitacoraSegList(bitacoraSegListNew);
            empleados = em.merge(empleados);
            if (empTempNew != null && !empTempNew.equals(empTempOld)) {
                Empleados oldEmpleadosOfEmpTemp = empTempNew.getEmpleados();
                if (oldEmpleadosOfEmpTemp != null) {
                    oldEmpleadosOfEmpTemp.setEmpTemp(null);
                    oldEmpleadosOfEmpTemp = em.merge(oldEmpleadosOfEmpTemp);
                }
                empTempNew.setEmpleados(empleados);
                empTempNew = em.merge(empTempNew);
            }
            if (empPlantaNew != null && !empPlantaNew.equals(empPlantaOld)) {
                Empleados oldEmpleadosOfEmpPlanta = empPlantaNew.getEmpleados();
                if (oldEmpleadosOfEmpPlanta != null) {
                    oldEmpleadosOfEmpPlanta.setEmpPlanta(null);
                    oldEmpleadosOfEmpPlanta = em.merge(oldEmpleadosOfEmpPlanta);
                }
                empPlantaNew.setEmpleados(empleados);
                empPlantaNew = em.merge(empPlantaNew);
            }
            if (dirCedulaeOld != null && !dirCedulaeOld.equals(dirCedulaeNew)) {
                dirCedulaeOld.getEmpleadosList().remove(empleados);
                dirCedulaeOld = em.merge(dirCedulaeOld);
            }
            if (dirCedulaeNew != null && !dirCedulaeNew.equals(dirCedulaeOld)) {
                dirCedulaeNew.getEmpleadosList().add(empleados);
                dirCedulaeNew = em.merge(dirCedulaeNew);
            }
            for (TelsEmp telsEmpListOldTelsEmp : telsEmpListOld) {
                if (!telsEmpListNew.contains(telsEmpListOldTelsEmp)) {
                    telsEmpListOldTelsEmp.getEmpleadosList().remove(empleados);
                    telsEmpListOldTelsEmp = em.merge(telsEmpListOldTelsEmp);
                }
            }
            for (TelsEmp telsEmpListNewTelsEmp : telsEmpListNew) {
                if (!telsEmpListOld.contains(telsEmpListNewTelsEmp)) {
                    telsEmpListNewTelsEmp.getEmpleadosList().add(empleados);
                    telsEmpListNewTelsEmp = em.merge(telsEmpListNewTelsEmp);
                }
            }
            for (BitacoraSeg bitacoraSegListOldBitacoraSeg : bitacoraSegListOld) {
                if (!bitacoraSegListNew.contains(bitacoraSegListOldBitacoraSeg)) {
                    bitacoraSegListOldBitacoraSeg.setCedulae(null);
                    bitacoraSegListOldBitacoraSeg = em.merge(bitacoraSegListOldBitacoraSeg);
                }
            }
            for (BitacoraSeg bitacoraSegListNewBitacoraSeg : bitacoraSegListNew) {
                if (!bitacoraSegListOld.contains(bitacoraSegListNewBitacoraSeg)) {
                    Empleados oldCedulaeOfBitacoraSegListNewBitacoraSeg = bitacoraSegListNewBitacoraSeg.getCedulae();
                    bitacoraSegListNewBitacoraSeg.setCedulae(empleados);
                    bitacoraSegListNewBitacoraSeg = em.merge(bitacoraSegListNewBitacoraSeg);
                    if (oldCedulaeOfBitacoraSegListNewBitacoraSeg != null && !oldCedulaeOfBitacoraSegListNewBitacoraSeg.equals(empleados)) {
                        oldCedulaeOfBitacoraSegListNewBitacoraSeg.getBitacoraSegList().remove(bitacoraSegListNewBitacoraSeg);
                        oldCedulaeOfBitacoraSegListNewBitacoraSeg = em.merge(oldCedulaeOfBitacoraSegListNewBitacoraSeg);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empleados.getCedulae();
                if (findEmpleados(id) == null) {
                    throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.");
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
            Empleados empleados;
            try {
                empleados = em.getReference(Empleados.class, id);
                empleados.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            EmpTemp empTempOrphanCheck = empleados.getEmpTemp();
            if (empTempOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empleados (" + empleados + ") cannot be destroyed since the EmpTemp " + empTempOrphanCheck + " in its empTemp field has a non-nullable empleados field.");
            }
            EmpPlanta empPlantaOrphanCheck = empleados.getEmpPlanta();
            if (empPlantaOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empleados (" + empleados + ") cannot be destroyed since the EmpPlanta " + empPlantaOrphanCheck + " in its empPlanta field has a non-nullable empleados field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            DirGestionHum dirCedulae = empleados.getDirCedulae();
            if (dirCedulae != null) {
                dirCedulae.getEmpleadosList().remove(empleados);
                dirCedulae = em.merge(dirCedulae);
            }
            List<TelsEmp> telsEmpList = empleados.getTelsEmpList();
            for (TelsEmp telsEmpListTelsEmp : telsEmpList) {
                telsEmpListTelsEmp.getEmpleadosList().remove(empleados);
                telsEmpListTelsEmp = em.merge(telsEmpListTelsEmp);
            }
            List<BitacoraSeg> bitacoraSegList = empleados.getBitacoraSegList();
            for (BitacoraSeg bitacoraSegListBitacoraSeg : bitacoraSegList) {
                bitacoraSegListBitacoraSeg.setCedulae(null);
                bitacoraSegListBitacoraSeg = em.merge(bitacoraSegListBitacoraSeg);
            }
            em.remove(empleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleados> findEmpleadosEntities() {
        return findEmpleadosEntities(true, -1, -1);
    }

    public List<Empleados> findEmpleadosEntities(int maxResults, int firstResult) {
        return findEmpleadosEntities(false, maxResults, firstResult);
    }

    private List<Empleados> findEmpleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleados.class));
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

    public Empleados findEmpleados(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleados.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleados> rt = cq.from(Empleados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
