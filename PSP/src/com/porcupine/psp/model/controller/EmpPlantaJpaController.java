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
public class EmpPlantaJpaController implements Serializable {

    public EmpPlantaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EmpPlanta empPlanta) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Empleados empleadosOrphanCheck = empPlanta.getEmpleados();
        if (empleadosOrphanCheck != null) {
            EmpPlanta oldEmpPlantaOfEmpleados = empleadosOrphanCheck.getEmpPlanta();
            if (oldEmpPlantaOfEmpleados != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Empleados " + empleadosOrphanCheck + " already has an item of type EmpPlanta whose empleados column cannot be null. Please make another selection for the empleados field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DirGestionHum dirGestionHum = empPlanta.getDirGestionHum();
            if (dirGestionHum != null) {
                dirGestionHum = em.getReference(dirGestionHum.getClass(), dirGestionHum.getCedulae());
                empPlanta.setDirGestionHum(dirGestionHum);
            }
            CoordContrato coordContrato = empPlanta.getCoordContrato();
            if (coordContrato != null) {
                coordContrato = em.getReference(coordContrato.getClass(), coordContrato.getCedulae());
                empPlanta.setCoordContrato(coordContrato);
            }
            Subgerente subgerente = empPlanta.getSubgerente();
            if (subgerente != null) {
                subgerente = em.getReference(subgerente.getClass(), subgerente.getCedulae());
                empPlanta.setSubgerente(subgerente);
            }
            DirOperaciones dirOperaciones = empPlanta.getDirOperaciones();
            if (dirOperaciones != null) {
                dirOperaciones = em.getReference(dirOperaciones.getClass(), dirOperaciones.getCedulae());
                empPlanta.setDirOperaciones(dirOperaciones);
            }
            Empleados empleados = empPlanta.getEmpleados();
            if (empleados != null) {
                empleados = em.getReference(empleados.getClass(), empleados.getCedulae());
                empPlanta.setEmpleados(empleados);
            }
            CoordTYT coordTYT = empPlanta.getCoordTYT();
            if (coordTYT != null) {
                coordTYT = em.getReference(coordTYT.getClass(), coordTYT.getCedulae());
                empPlanta.setCoordTYT(coordTYT);
            }
            DirComercial dirComercial = empPlanta.getDirComercial();
            if (dirComercial != null) {
                dirComercial = em.getReference(dirComercial.getClass(), dirComercial.getCedulae());
                empPlanta.setDirComercial(dirComercial);
            }
            em.persist(empPlanta);
            if (dirGestionHum != null) {
                EmpPlanta oldEmpPlantaOfDirGestionHum = dirGestionHum.getEmpPlanta();
                if (oldEmpPlantaOfDirGestionHum != null) {
                    oldEmpPlantaOfDirGestionHum.setDirGestionHum(null);
                    oldEmpPlantaOfDirGestionHum = em.merge(oldEmpPlantaOfDirGestionHum);
                }
                dirGestionHum.setEmpPlanta(empPlanta);
                dirGestionHum = em.merge(dirGestionHum);
            }
            if (coordContrato != null) {
                EmpPlanta oldEmpPlantaOfCoordContrato = coordContrato.getEmpPlanta();
                if (oldEmpPlantaOfCoordContrato != null) {
                    oldEmpPlantaOfCoordContrato.setCoordContrato(null);
                    oldEmpPlantaOfCoordContrato = em.merge(oldEmpPlantaOfCoordContrato);
                }
                coordContrato.setEmpPlanta(empPlanta);
                coordContrato = em.merge(coordContrato);
            }
            if (subgerente != null) {
                EmpPlanta oldEmpPlantaOfSubgerente = subgerente.getEmpPlanta();
                if (oldEmpPlantaOfSubgerente != null) {
                    oldEmpPlantaOfSubgerente.setSubgerente(null);
                    oldEmpPlantaOfSubgerente = em.merge(oldEmpPlantaOfSubgerente);
                }
                subgerente.setEmpPlanta(empPlanta);
                subgerente = em.merge(subgerente);
            }
            if (dirOperaciones != null) {
                EmpPlanta oldEmpPlantaOfDirOperaciones = dirOperaciones.getEmpPlanta();
                if (oldEmpPlantaOfDirOperaciones != null) {
                    oldEmpPlantaOfDirOperaciones.setDirOperaciones(null);
                    oldEmpPlantaOfDirOperaciones = em.merge(oldEmpPlantaOfDirOperaciones);
                }
                dirOperaciones.setEmpPlanta(empPlanta);
                dirOperaciones = em.merge(dirOperaciones);
            }
            if (empleados != null) {
                empleados.setEmpPlanta(empPlanta);
                empleados = em.merge(empleados);
            }
            if (coordTYT != null) {
                EmpPlanta oldEmpPlantaOfCoordTYT = coordTYT.getEmpPlanta();
                if (oldEmpPlantaOfCoordTYT != null) {
                    oldEmpPlantaOfCoordTYT.setCoordTYT(null);
                    oldEmpPlantaOfCoordTYT = em.merge(oldEmpPlantaOfCoordTYT);
                }
                coordTYT.setEmpPlanta(empPlanta);
                coordTYT = em.merge(coordTYT);
            }
            if (dirComercial != null) {
                EmpPlanta oldEmpPlantaOfDirComercial = dirComercial.getEmpPlanta();
                if (oldEmpPlantaOfDirComercial != null) {
                    oldEmpPlantaOfDirComercial.setDirComercial(null);
                    oldEmpPlantaOfDirComercial = em.merge(oldEmpPlantaOfDirComercial);
                }
                dirComercial.setEmpPlanta(empPlanta);
                dirComercial = em.merge(dirComercial);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpPlanta(empPlanta.getCedulae()) != null) {
                throw new PreexistingEntityException("EmpPlanta " + empPlanta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EmpPlanta empPlanta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmpPlanta persistentEmpPlanta = em.find(EmpPlanta.class, empPlanta.getCedulae());
            DirGestionHum dirGestionHumOld = persistentEmpPlanta.getDirGestionHum();
            DirGestionHum dirGestionHumNew = empPlanta.getDirGestionHum();
            CoordContrato coordContratoOld = persistentEmpPlanta.getCoordContrato();
            CoordContrato coordContratoNew = empPlanta.getCoordContrato();
            Subgerente subgerenteOld = persistentEmpPlanta.getSubgerente();
            Subgerente subgerenteNew = empPlanta.getSubgerente();
            DirOperaciones dirOperacionesOld = persistentEmpPlanta.getDirOperaciones();
            DirOperaciones dirOperacionesNew = empPlanta.getDirOperaciones();
            Empleados empleadosOld = persistentEmpPlanta.getEmpleados();
            Empleados empleadosNew = empPlanta.getEmpleados();
            CoordTYT coordTYTOld = persistentEmpPlanta.getCoordTYT();
            CoordTYT coordTYTNew = empPlanta.getCoordTYT();
            DirComercial dirComercialOld = persistentEmpPlanta.getDirComercial();
            DirComercial dirComercialNew = empPlanta.getDirComercial();
            List<String> illegalOrphanMessages = null;
            if (dirGestionHumOld != null && !dirGestionHumOld.equals(dirGestionHumNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain DirGestionHum " + dirGestionHumOld + " since its empPlanta field is not nullable.");
            }
            if (coordContratoOld != null && !coordContratoOld.equals(coordContratoNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain CoordContrato " + coordContratoOld + " since its empPlanta field is not nullable.");
            }
            if (subgerenteOld != null && !subgerenteOld.equals(subgerenteNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Subgerente " + subgerenteOld + " since its empPlanta field is not nullable.");
            }
            if (dirOperacionesOld != null && !dirOperacionesOld.equals(dirOperacionesNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain DirOperaciones " + dirOperacionesOld + " since its empPlanta field is not nullable.");
            }
            if (empleadosNew != null && !empleadosNew.equals(empleadosOld)) {
                EmpPlanta oldEmpPlantaOfEmpleados = empleadosNew.getEmpPlanta();
                if (oldEmpPlantaOfEmpleados != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Empleados " + empleadosNew + " already has an item of type EmpPlanta whose empleados column cannot be null. Please make another selection for the empleados field.");
                }
            }
            if (coordTYTOld != null && !coordTYTOld.equals(coordTYTNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain CoordTYT " + coordTYTOld + " since its empPlanta field is not nullable.");
            }
            if (dirComercialOld != null && !dirComercialOld.equals(dirComercialNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain DirComercial " + dirComercialOld + " since its empPlanta field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (dirGestionHumNew != null) {
                dirGestionHumNew = em.getReference(dirGestionHumNew.getClass(), dirGestionHumNew.getCedulae());
                empPlanta.setDirGestionHum(dirGestionHumNew);
            }
            if (coordContratoNew != null) {
                coordContratoNew = em.getReference(coordContratoNew.getClass(), coordContratoNew.getCedulae());
                empPlanta.setCoordContrato(coordContratoNew);
            }
            if (subgerenteNew != null) {
                subgerenteNew = em.getReference(subgerenteNew.getClass(), subgerenteNew.getCedulae());
                empPlanta.setSubgerente(subgerenteNew);
            }
            if (dirOperacionesNew != null) {
                dirOperacionesNew = em.getReference(dirOperacionesNew.getClass(), dirOperacionesNew.getCedulae());
                empPlanta.setDirOperaciones(dirOperacionesNew);
            }
            if (empleadosNew != null) {
                empleadosNew = em.getReference(empleadosNew.getClass(), empleadosNew.getCedulae());
                empPlanta.setEmpleados(empleadosNew);
            }
            if (coordTYTNew != null) {
                coordTYTNew = em.getReference(coordTYTNew.getClass(), coordTYTNew.getCedulae());
                empPlanta.setCoordTYT(coordTYTNew);
            }
            if (dirComercialNew != null) {
                dirComercialNew = em.getReference(dirComercialNew.getClass(), dirComercialNew.getCedulae());
                empPlanta.setDirComercial(dirComercialNew);
            }
            empPlanta = em.merge(empPlanta);
            if (dirGestionHumNew != null && !dirGestionHumNew.equals(dirGestionHumOld)) {
                EmpPlanta oldEmpPlantaOfDirGestionHum = dirGestionHumNew.getEmpPlanta();
                if (oldEmpPlantaOfDirGestionHum != null) {
                    oldEmpPlantaOfDirGestionHum.setDirGestionHum(null);
                    oldEmpPlantaOfDirGestionHum = em.merge(oldEmpPlantaOfDirGestionHum);
                }
                dirGestionHumNew.setEmpPlanta(empPlanta);
                dirGestionHumNew = em.merge(dirGestionHumNew);
            }
            if (coordContratoNew != null && !coordContratoNew.equals(coordContratoOld)) {
                EmpPlanta oldEmpPlantaOfCoordContrato = coordContratoNew.getEmpPlanta();
                if (oldEmpPlantaOfCoordContrato != null) {
                    oldEmpPlantaOfCoordContrato.setCoordContrato(null);
                    oldEmpPlantaOfCoordContrato = em.merge(oldEmpPlantaOfCoordContrato);
                }
                coordContratoNew.setEmpPlanta(empPlanta);
                coordContratoNew = em.merge(coordContratoNew);
            }
            if (subgerenteNew != null && !subgerenteNew.equals(subgerenteOld)) {
                EmpPlanta oldEmpPlantaOfSubgerente = subgerenteNew.getEmpPlanta();
                if (oldEmpPlantaOfSubgerente != null) {
                    oldEmpPlantaOfSubgerente.setSubgerente(null);
                    oldEmpPlantaOfSubgerente = em.merge(oldEmpPlantaOfSubgerente);
                }
                subgerenteNew.setEmpPlanta(empPlanta);
                subgerenteNew = em.merge(subgerenteNew);
            }
            if (dirOperacionesNew != null && !dirOperacionesNew.equals(dirOperacionesOld)) {
                EmpPlanta oldEmpPlantaOfDirOperaciones = dirOperacionesNew.getEmpPlanta();
                if (oldEmpPlantaOfDirOperaciones != null) {
                    oldEmpPlantaOfDirOperaciones.setDirOperaciones(null);
                    oldEmpPlantaOfDirOperaciones = em.merge(oldEmpPlantaOfDirOperaciones);
                }
                dirOperacionesNew.setEmpPlanta(empPlanta);
                dirOperacionesNew = em.merge(dirOperacionesNew);
            }
            if (empleadosOld != null && !empleadosOld.equals(empleadosNew)) {
                empleadosOld.setEmpPlanta(null);
                empleadosOld = em.merge(empleadosOld);
            }
            if (empleadosNew != null && !empleadosNew.equals(empleadosOld)) {
                empleadosNew.setEmpPlanta(empPlanta);
                empleadosNew = em.merge(empleadosNew);
            }
            if (coordTYTNew != null && !coordTYTNew.equals(coordTYTOld)) {
                EmpPlanta oldEmpPlantaOfCoordTYT = coordTYTNew.getEmpPlanta();
                if (oldEmpPlantaOfCoordTYT != null) {
                    oldEmpPlantaOfCoordTYT.setCoordTYT(null);
                    oldEmpPlantaOfCoordTYT = em.merge(oldEmpPlantaOfCoordTYT);
                }
                coordTYTNew.setEmpPlanta(empPlanta);
                coordTYTNew = em.merge(coordTYTNew);
            }
            if (dirComercialNew != null && !dirComercialNew.equals(dirComercialOld)) {
                EmpPlanta oldEmpPlantaOfDirComercial = dirComercialNew.getEmpPlanta();
                if (oldEmpPlantaOfDirComercial != null) {
                    oldEmpPlantaOfDirComercial.setDirComercial(null);
                    oldEmpPlantaOfDirComercial = em.merge(oldEmpPlantaOfDirComercial);
                }
                dirComercialNew.setEmpPlanta(empPlanta);
                dirComercialNew = em.merge(dirComercialNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empPlanta.getCedulae();
                if (findEmpPlanta(id) == null) {
                    throw new NonexistentEntityException("The empPlanta with id " + id + " no longer exists.");
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
            EmpPlanta empPlanta;
            try {
                empPlanta = em.getReference(EmpPlanta.class, id);
                empPlanta.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empPlanta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            DirGestionHum dirGestionHumOrphanCheck = empPlanta.getDirGestionHum();
            if (dirGestionHumOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This EmpPlanta (" + empPlanta + ") cannot be destroyed since the DirGestionHum " + dirGestionHumOrphanCheck + " in its dirGestionHum field has a non-nullable empPlanta field.");
            }
            CoordContrato coordContratoOrphanCheck = empPlanta.getCoordContrato();
            if (coordContratoOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This EmpPlanta (" + empPlanta + ") cannot be destroyed since the CoordContrato " + coordContratoOrphanCheck + " in its coordContrato field has a non-nullable empPlanta field.");
            }
            Subgerente subgerenteOrphanCheck = empPlanta.getSubgerente();
            if (subgerenteOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This EmpPlanta (" + empPlanta + ") cannot be destroyed since the Subgerente " + subgerenteOrphanCheck + " in its subgerente field has a non-nullable empPlanta field.");
            }
            DirOperaciones dirOperacionesOrphanCheck = empPlanta.getDirOperaciones();
            if (dirOperacionesOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This EmpPlanta (" + empPlanta + ") cannot be destroyed since the DirOperaciones " + dirOperacionesOrphanCheck + " in its dirOperaciones field has a non-nullable empPlanta field.");
            }
            CoordTYT coordTYTOrphanCheck = empPlanta.getCoordTYT();
            if (coordTYTOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This EmpPlanta (" + empPlanta + ") cannot be destroyed since the CoordTYT " + coordTYTOrphanCheck + " in its coordTYT field has a non-nullable empPlanta field.");
            }
            DirComercial dirComercialOrphanCheck = empPlanta.getDirComercial();
            if (dirComercialOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This EmpPlanta (" + empPlanta + ") cannot be destroyed since the DirComercial " + dirComercialOrphanCheck + " in its dirComercial field has a non-nullable empPlanta field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empleados empleados = empPlanta.getEmpleados();
            if (empleados != null) {
                empleados.setEmpPlanta(null);
                empleados = em.merge(empleados);
            }
            em.remove(empPlanta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EmpPlanta> findEmpPlantaEntities() {
        return findEmpPlantaEntities(true, -1, -1);
    }

    public List<EmpPlanta> findEmpPlantaEntities(int maxResults, int firstResult) {
        return findEmpPlantaEntities(false, maxResults, firstResult);
    }

    private List<EmpPlanta> findEmpPlantaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EmpPlanta.class));
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

    public EmpPlanta findEmpPlanta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmpPlanta.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpPlantaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EmpPlanta> rt = cq.from(EmpPlanta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
