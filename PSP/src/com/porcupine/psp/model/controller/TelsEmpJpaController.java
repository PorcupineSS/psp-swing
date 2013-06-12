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
import com.porcupine.psp.model.entity.Empleados;
import com.porcupine.psp.model.entity.TelsEmp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class TelsEmpJpaController implements Serializable {

    public TelsEmpJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TelsEmp telsEmp) {
        if (telsEmp.getEmpleadosList() == null) {
            telsEmp.setEmpleadosList(new ArrayList<Empleados>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Empleados> attachedEmpleadosList = new ArrayList<Empleados>();
            for (Empleados empleadosListEmpleadosToAttach : telsEmp.getEmpleadosList()) {
                empleadosListEmpleadosToAttach = em.getReference(empleadosListEmpleadosToAttach.getClass(), empleadosListEmpleadosToAttach.getCedulae());
                attachedEmpleadosList.add(empleadosListEmpleadosToAttach);
            }
            telsEmp.setEmpleadosList(attachedEmpleadosList);
            em.persist(telsEmp);
            for (Empleados empleadosListEmpleados : telsEmp.getEmpleadosList()) {
                empleadosListEmpleados.getTelsEmpList().add(telsEmp);
                empleadosListEmpleados = em.merge(empleadosListEmpleados);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TelsEmp telsEmp) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TelsEmp persistentTelsEmp = em.find(TelsEmp.class, telsEmp.getIdTe());
            List<Empleados> empleadosListOld = persistentTelsEmp.getEmpleadosList();
            List<Empleados> empleadosListNew = telsEmp.getEmpleadosList();
            List<Empleados> attachedEmpleadosListNew = new ArrayList<Empleados>();
            for (Empleados empleadosListNewEmpleadosToAttach : empleadosListNew) {
                empleadosListNewEmpleadosToAttach = em.getReference(empleadosListNewEmpleadosToAttach.getClass(), empleadosListNewEmpleadosToAttach.getCedulae());
                attachedEmpleadosListNew.add(empleadosListNewEmpleadosToAttach);
            }
            empleadosListNew = attachedEmpleadosListNew;
            telsEmp.setEmpleadosList(empleadosListNew);
            telsEmp = em.merge(telsEmp);
            for (Empleados empleadosListOldEmpleados : empleadosListOld) {
                if (!empleadosListNew.contains(empleadosListOldEmpleados)) {
                    empleadosListOldEmpleados.getTelsEmpList().remove(telsEmp);
                    empleadosListOldEmpleados = em.merge(empleadosListOldEmpleados);
                }
            }
            for (Empleados empleadosListNewEmpleados : empleadosListNew) {
                if (!empleadosListOld.contains(empleadosListNewEmpleados)) {
                    empleadosListNewEmpleados.getTelsEmpList().add(telsEmp);
                    empleadosListNewEmpleados = em.merge(empleadosListNewEmpleados);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = telsEmp.getIdTe();
                if (findTelsEmp(id) == null) {
                    throw new NonexistentEntityException("The telsEmp with id " + id + " no longer exists.");
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
            TelsEmp telsEmp;
            try {
                telsEmp = em.getReference(TelsEmp.class, id);
                telsEmp.getIdTe();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The telsEmp with id " + id + " no longer exists.", enfe);
            }
            List<Empleados> empleadosList = telsEmp.getEmpleadosList();
            for (Empleados empleadosListEmpleados : empleadosList) {
                empleadosListEmpleados.getTelsEmpList().remove(telsEmp);
                empleadosListEmpleados = em.merge(empleadosListEmpleados);
            }
            em.remove(telsEmp);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TelsEmp> findTelsEmpEntities() {
        return findTelsEmpEntities(true, -1, -1);
    }

    public List<TelsEmp> findTelsEmpEntities(int maxResults, int firstResult) {
        return findTelsEmpEntities(false, maxResults, firstResult);
    }

    private List<TelsEmp> findTelsEmpEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TelsEmp.class));
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

    public TelsEmp findTelsEmp(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TelsEmp.class, id);
        } finally {
            em.close();
        }
    }

    public int getTelsEmpCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TelsEmp> rt = cq.from(TelsEmp.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
