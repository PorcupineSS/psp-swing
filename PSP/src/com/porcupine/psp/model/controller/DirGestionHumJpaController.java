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
import com.porcupine.psp.model.entity.Empleados;
import java.util.ArrayList;
import java.util.List;
import com.porcupine.psp.model.entity.Actualizacion;
import com.porcupine.psp.model.entity.DirGestionHum;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class DirGestionHumJpaController implements Serializable {

    public DirGestionHumJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DirGestionHum dirGestionHum) throws IllegalOrphanException, PreexistingEntityException, Exception {
        if (dirGestionHum.getEmpleadosList() == null) {
            dirGestionHum.setEmpleadosList(new ArrayList<Empleados>());
        }
        if (dirGestionHum.getActualizacionList() == null) {
            dirGestionHum.setActualizacionList(new ArrayList<Actualizacion>());
        }
        List<String> illegalOrphanMessages = null;
        EmpPlanta empPlantaOrphanCheck = dirGestionHum.getEmpPlanta();
        if (empPlantaOrphanCheck != null) {
            DirGestionHum oldDirGestionHumOfEmpPlanta = empPlantaOrphanCheck.getDirGestionHum();
            if (oldDirGestionHumOfEmpPlanta != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The EmpPlanta " + empPlantaOrphanCheck + " already has an item of type DirGestionHum whose empPlanta column cannot be null. Please make another selection for the empPlanta field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmpPlanta empPlanta = dirGestionHum.getEmpPlanta();
            if (empPlanta != null) {
                empPlanta = em.getReference(empPlanta.getClass(), empPlanta.getCedulae());
                dirGestionHum.setEmpPlanta(empPlanta);
            }
            List<Empleados> attachedEmpleadosList = new ArrayList<Empleados>();
            for (Empleados empleadosListEmpleadosToAttach : dirGestionHum.getEmpleadosList()) {
                empleadosListEmpleadosToAttach = em.getReference(empleadosListEmpleadosToAttach.getClass(), empleadosListEmpleadosToAttach.getCedulae());
                attachedEmpleadosList.add(empleadosListEmpleadosToAttach);
            }
            dirGestionHum.setEmpleadosList(attachedEmpleadosList);
            List<Actualizacion> attachedActualizacionList = new ArrayList<Actualizacion>();
            for (Actualizacion actualizacionListActualizacionToAttach : dirGestionHum.getActualizacionList()) {
                actualizacionListActualizacionToAttach = em.getReference(actualizacionListActualizacionToAttach.getClass(), actualizacionListActualizacionToAttach.getActualizacionPK());
                attachedActualizacionList.add(actualizacionListActualizacionToAttach);
            }
            dirGestionHum.setActualizacionList(attachedActualizacionList);
            em.persist(dirGestionHum);
            if (empPlanta != null) {
                empPlanta.setDirGestionHum(dirGestionHum);
                empPlanta = em.merge(empPlanta);
            }
            for (Empleados empleadosListEmpleados : dirGestionHum.getEmpleadosList()) {
                DirGestionHum oldDirCedulaeOfEmpleadosListEmpleados = empleadosListEmpleados.getDirCedulae();
                empleadosListEmpleados.setDirCedulae(dirGestionHum);
                empleadosListEmpleados = em.merge(empleadosListEmpleados);
                if (oldDirCedulaeOfEmpleadosListEmpleados != null) {
                    oldDirCedulaeOfEmpleadosListEmpleados.getEmpleadosList().remove(empleadosListEmpleados);
                    oldDirCedulaeOfEmpleadosListEmpleados = em.merge(oldDirCedulaeOfEmpleadosListEmpleados);
                }
            }
            for (Actualizacion actualizacionListActualizacion : dirGestionHum.getActualizacionList()) {
                DirGestionHum oldDirGestionHumOfActualizacionListActualizacion = actualizacionListActualizacion.getDirGestionHum();
                actualizacionListActualizacion.setDirGestionHum(dirGestionHum);
                actualizacionListActualizacion = em.merge(actualizacionListActualizacion);
                if (oldDirGestionHumOfActualizacionListActualizacion != null) {
                    oldDirGestionHumOfActualizacionListActualizacion.getActualizacionList().remove(actualizacionListActualizacion);
                    oldDirGestionHumOfActualizacionListActualizacion = em.merge(oldDirGestionHumOfActualizacionListActualizacion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDirGestionHum(dirGestionHum.getCedulae()) != null) {
                throw new PreexistingEntityException("DirGestionHum " + dirGestionHum + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DirGestionHum dirGestionHum) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DirGestionHum persistentDirGestionHum = em.find(DirGestionHum.class, dirGestionHum.getCedulae());
            EmpPlanta empPlantaOld = persistentDirGestionHum.getEmpPlanta();
            EmpPlanta empPlantaNew = dirGestionHum.getEmpPlanta();
            List<Empleados> empleadosListOld = persistentDirGestionHum.getEmpleadosList();
            List<Empleados> empleadosListNew = dirGestionHum.getEmpleadosList();
            List<Actualizacion> actualizacionListOld = persistentDirGestionHum.getActualizacionList();
            List<Actualizacion> actualizacionListNew = dirGestionHum.getActualizacionList();
            List<String> illegalOrphanMessages = null;
            if (empPlantaNew != null && !empPlantaNew.equals(empPlantaOld)) {
                DirGestionHum oldDirGestionHumOfEmpPlanta = empPlantaNew.getDirGestionHum();
                if (oldDirGestionHumOfEmpPlanta != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The EmpPlanta " + empPlantaNew + " already has an item of type DirGestionHum whose empPlanta column cannot be null. Please make another selection for the empPlanta field.");
                }
            }
            for (Actualizacion actualizacionListOldActualizacion : actualizacionListOld) {
                if (!actualizacionListNew.contains(actualizacionListOldActualizacion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Actualizacion " + actualizacionListOldActualizacion + " since its dirGestionHum field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empPlantaNew != null) {
                empPlantaNew = em.getReference(empPlantaNew.getClass(), empPlantaNew.getCedulae());
                dirGestionHum.setEmpPlanta(empPlantaNew);
            }
            List<Empleados> attachedEmpleadosListNew = new ArrayList<Empleados>();
            for (Empleados empleadosListNewEmpleadosToAttach : empleadosListNew) {
                empleadosListNewEmpleadosToAttach = em.getReference(empleadosListNewEmpleadosToAttach.getClass(), empleadosListNewEmpleadosToAttach.getCedulae());
                attachedEmpleadosListNew.add(empleadosListNewEmpleadosToAttach);
            }
            empleadosListNew = attachedEmpleadosListNew;
            dirGestionHum.setEmpleadosList(empleadosListNew);
            List<Actualizacion> attachedActualizacionListNew = new ArrayList<Actualizacion>();
            for (Actualizacion actualizacionListNewActualizacionToAttach : actualizacionListNew) {
                actualizacionListNewActualizacionToAttach = em.getReference(actualizacionListNewActualizacionToAttach.getClass(), actualizacionListNewActualizacionToAttach.getActualizacionPK());
                attachedActualizacionListNew.add(actualizacionListNewActualizacionToAttach);
            }
            actualizacionListNew = attachedActualizacionListNew;
            dirGestionHum.setActualizacionList(actualizacionListNew);
            dirGestionHum = em.merge(dirGestionHum);
            if (empPlantaOld != null && !empPlantaOld.equals(empPlantaNew)) {
                empPlantaOld.setDirGestionHum(null);
                empPlantaOld = em.merge(empPlantaOld);
            }
            if (empPlantaNew != null && !empPlantaNew.equals(empPlantaOld)) {
                empPlantaNew.setDirGestionHum(dirGestionHum);
                empPlantaNew = em.merge(empPlantaNew);
            }
            for (Empleados empleadosListOldEmpleados : empleadosListOld) {
                if (!empleadosListNew.contains(empleadosListOldEmpleados)) {
                    empleadosListOldEmpleados.setDirCedulae(null);
                    empleadosListOldEmpleados = em.merge(empleadosListOldEmpleados);
                }
            }
            for (Empleados empleadosListNewEmpleados : empleadosListNew) {
                if (!empleadosListOld.contains(empleadosListNewEmpleados)) {
                    DirGestionHum oldDirCedulaeOfEmpleadosListNewEmpleados = empleadosListNewEmpleados.getDirCedulae();
                    empleadosListNewEmpleados.setDirCedulae(dirGestionHum);
                    empleadosListNewEmpleados = em.merge(empleadosListNewEmpleados);
                    if (oldDirCedulaeOfEmpleadosListNewEmpleados != null && !oldDirCedulaeOfEmpleadosListNewEmpleados.equals(dirGestionHum)) {
                        oldDirCedulaeOfEmpleadosListNewEmpleados.getEmpleadosList().remove(empleadosListNewEmpleados);
                        oldDirCedulaeOfEmpleadosListNewEmpleados = em.merge(oldDirCedulaeOfEmpleadosListNewEmpleados);
                    }
                }
            }
            for (Actualizacion actualizacionListNewActualizacion : actualizacionListNew) {
                if (!actualizacionListOld.contains(actualizacionListNewActualizacion)) {
                    DirGestionHum oldDirGestionHumOfActualizacionListNewActualizacion = actualizacionListNewActualizacion.getDirGestionHum();
                    actualizacionListNewActualizacion.setDirGestionHum(dirGestionHum);
                    actualizacionListNewActualizacion = em.merge(actualizacionListNewActualizacion);
                    if (oldDirGestionHumOfActualizacionListNewActualizacion != null && !oldDirGestionHumOfActualizacionListNewActualizacion.equals(dirGestionHum)) {
                        oldDirGestionHumOfActualizacionListNewActualizacion.getActualizacionList().remove(actualizacionListNewActualizacion);
                        oldDirGestionHumOfActualizacionListNewActualizacion = em.merge(oldDirGestionHumOfActualizacionListNewActualizacion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dirGestionHum.getCedulae();
                if (findDirGestionHum(id) == null) {
                    throw new NonexistentEntityException("The dirGestionHum with id " + id + " no longer exists.");
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
            DirGestionHum dirGestionHum;
            try {
                dirGestionHum = em.getReference(DirGestionHum.class, id);
                dirGestionHum.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dirGestionHum with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Actualizacion> actualizacionListOrphanCheck = dirGestionHum.getActualizacionList();
            for (Actualizacion actualizacionListOrphanCheckActualizacion : actualizacionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DirGestionHum (" + dirGestionHum + ") cannot be destroyed since the Actualizacion " + actualizacionListOrphanCheckActualizacion + " in its actualizacionList field has a non-nullable dirGestionHum field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            EmpPlanta empPlanta = dirGestionHum.getEmpPlanta();
            if (empPlanta != null) {
                empPlanta.setDirGestionHum(null);
                empPlanta = em.merge(empPlanta);
            }
            List<Empleados> empleadosList = dirGestionHum.getEmpleadosList();
            for (Empleados empleadosListEmpleados : empleadosList) {
                empleadosListEmpleados.setDirCedulae(null);
                empleadosListEmpleados = em.merge(empleadosListEmpleados);
            }
            em.remove(dirGestionHum);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DirGestionHum> findDirGestionHumEntities() {
        return findDirGestionHumEntities(true, -1, -1);
    }

    public List<DirGestionHum> findDirGestionHumEntities(int maxResults, int firstResult) {
        return findDirGestionHumEntities(false, maxResults, firstResult);
    }

    private List<DirGestionHum> findDirGestionHumEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DirGestionHum.class));
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

    public DirGestionHum findDirGestionHum(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DirGestionHum.class, id);
        } finally {
            em.close();
        }
    }

    public int getDirGestionHumCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DirGestionHum> rt = cq.from(DirGestionHum.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
