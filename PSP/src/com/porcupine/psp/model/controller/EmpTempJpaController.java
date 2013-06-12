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
public class EmpTempJpaController implements Serializable {

    public EmpTempJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EmpTemp empTemp) throws IllegalOrphanException, PreexistingEntityException, Exception {
        if (empTemp.getComunicadoList() == null) {
            empTemp.setComunicadoList(new ArrayList<Comunicado>());
        }
        if (empTemp.getAsigImplList() == null) {
            empTemp.setAsigImplList(new ArrayList<AsigImpl>());
        }
        List<String> illegalOrphanMessages = null;
        Empleados empleadosOrphanCheck = empTemp.getEmpleados();
        if (empleadosOrphanCheck != null) {
            EmpTemp oldEmpTempOfEmpleados = empleadosOrphanCheck.getEmpTemp();
            if (oldEmpTempOfEmpleados != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Empleados " + empleadosOrphanCheck + " already has an item of type EmpTemp whose empleados column cannot be null. Please make another selection for the empleados field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados empleados = empTemp.getEmpleados();
            if (empleados != null) {
                empleados = em.getReference(empleados.getClass(), empleados.getCedulae());
                empTemp.setEmpleados(empleados);
            }
            AsignacionC idAsig = empTemp.getIdAsig();
            if (idAsig != null) {
                idAsig = em.getReference(idAsig.getClass(), idAsig.getIdAsig());
                empTemp.setIdAsig(idAsig);
            }
            List<Comunicado> attachedComunicadoList = new ArrayList<Comunicado>();
            for (Comunicado comunicadoListComunicadoToAttach : empTemp.getComunicadoList()) {
                comunicadoListComunicadoToAttach = em.getReference(comunicadoListComunicadoToAttach.getClass(), comunicadoListComunicadoToAttach.getIdComunicado());
                attachedComunicadoList.add(comunicadoListComunicadoToAttach);
            }
            empTemp.setComunicadoList(attachedComunicadoList);
            List<AsigImpl> attachedAsigImplList = new ArrayList<AsigImpl>();
            for (AsigImpl asigImplListAsigImplToAttach : empTemp.getAsigImplList()) {
                asigImplListAsigImplToAttach = em.getReference(asigImplListAsigImplToAttach.getClass(), asigImplListAsigImplToAttach.getIdAsignacionI());
                attachedAsigImplList.add(asigImplListAsigImplToAttach);
            }
            empTemp.setAsigImplList(attachedAsigImplList);
            em.persist(empTemp);
            if (empleados != null) {
                empleados.setEmpTemp(empTemp);
                empleados = em.merge(empleados);
            }
            if (idAsig != null) {
                idAsig.getEmpTempList().add(empTemp);
                idAsig = em.merge(idAsig);
            }
            for (Comunicado comunicadoListComunicado : empTemp.getComunicadoList()) {
                EmpTemp oldCedulaeOfComunicadoListComunicado = comunicadoListComunicado.getCedulae();
                comunicadoListComunicado.setCedulae(empTemp);
                comunicadoListComunicado = em.merge(comunicadoListComunicado);
                if (oldCedulaeOfComunicadoListComunicado != null) {
                    oldCedulaeOfComunicadoListComunicado.getComunicadoList().remove(comunicadoListComunicado);
                    oldCedulaeOfComunicadoListComunicado = em.merge(oldCedulaeOfComunicadoListComunicado);
                }
            }
            for (AsigImpl asigImplListAsigImpl : empTemp.getAsigImplList()) {
                EmpTemp oldCedulaeOfAsigImplListAsigImpl = asigImplListAsigImpl.getCedulae();
                asigImplListAsigImpl.setCedulae(empTemp);
                asigImplListAsigImpl = em.merge(asigImplListAsigImpl);
                if (oldCedulaeOfAsigImplListAsigImpl != null) {
                    oldCedulaeOfAsigImplListAsigImpl.getAsigImplList().remove(asigImplListAsigImpl);
                    oldCedulaeOfAsigImplListAsigImpl = em.merge(oldCedulaeOfAsigImplListAsigImpl);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpTemp(empTemp.getCedulae()) != null) {
                throw new PreexistingEntityException("EmpTemp " + empTemp + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EmpTemp empTemp) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmpTemp persistentEmpTemp = em.find(EmpTemp.class, empTemp.getCedulae());
            Empleados empleadosOld = persistentEmpTemp.getEmpleados();
            Empleados empleadosNew = empTemp.getEmpleados();
            AsignacionC idAsigOld = persistentEmpTemp.getIdAsig();
            AsignacionC idAsigNew = empTemp.getIdAsig();
            List<Comunicado> comunicadoListOld = persistentEmpTemp.getComunicadoList();
            List<Comunicado> comunicadoListNew = empTemp.getComunicadoList();
            List<AsigImpl> asigImplListOld = persistentEmpTemp.getAsigImplList();
            List<AsigImpl> asigImplListNew = empTemp.getAsigImplList();
            List<String> illegalOrphanMessages = null;
            if (empleadosNew != null && !empleadosNew.equals(empleadosOld)) {
                EmpTemp oldEmpTempOfEmpleados = empleadosNew.getEmpTemp();
                if (oldEmpTempOfEmpleados != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Empleados " + empleadosNew + " already has an item of type EmpTemp whose empleados column cannot be null. Please make another selection for the empleados field.");
                }
            }
            for (AsigImpl asigImplListOldAsigImpl : asigImplListOld) {
                if (!asigImplListNew.contains(asigImplListOldAsigImpl)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AsigImpl " + asigImplListOldAsigImpl + " since its cedulae field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empleadosNew != null) {
                empleadosNew = em.getReference(empleadosNew.getClass(), empleadosNew.getCedulae());
                empTemp.setEmpleados(empleadosNew);
            }
            if (idAsigNew != null) {
                idAsigNew = em.getReference(idAsigNew.getClass(), idAsigNew.getIdAsig());
                empTemp.setIdAsig(idAsigNew);
            }
            List<Comunicado> attachedComunicadoListNew = new ArrayList<Comunicado>();
            for (Comunicado comunicadoListNewComunicadoToAttach : comunicadoListNew) {
                comunicadoListNewComunicadoToAttach = em.getReference(comunicadoListNewComunicadoToAttach.getClass(), comunicadoListNewComunicadoToAttach.getIdComunicado());
                attachedComunicadoListNew.add(comunicadoListNewComunicadoToAttach);
            }
            comunicadoListNew = attachedComunicadoListNew;
            empTemp.setComunicadoList(comunicadoListNew);
            List<AsigImpl> attachedAsigImplListNew = new ArrayList<AsigImpl>();
            for (AsigImpl asigImplListNewAsigImplToAttach : asigImplListNew) {
                asigImplListNewAsigImplToAttach = em.getReference(asigImplListNewAsigImplToAttach.getClass(), asigImplListNewAsigImplToAttach.getIdAsignacionI());
                attachedAsigImplListNew.add(asigImplListNewAsigImplToAttach);
            }
            asigImplListNew = attachedAsigImplListNew;
            empTemp.setAsigImplList(asigImplListNew);
            empTemp = em.merge(empTemp);
            if (empleadosOld != null && !empleadosOld.equals(empleadosNew)) {
                empleadosOld.setEmpTemp(null);
                empleadosOld = em.merge(empleadosOld);
            }
            if (empleadosNew != null && !empleadosNew.equals(empleadosOld)) {
                empleadosNew.setEmpTemp(empTemp);
                empleadosNew = em.merge(empleadosNew);
            }
            if (idAsigOld != null && !idAsigOld.equals(idAsigNew)) {
                idAsigOld.getEmpTempList().remove(empTemp);
                idAsigOld = em.merge(idAsigOld);
            }
            if (idAsigNew != null && !idAsigNew.equals(idAsigOld)) {
                idAsigNew.getEmpTempList().add(empTemp);
                idAsigNew = em.merge(idAsigNew);
            }
            for (Comunicado comunicadoListOldComunicado : comunicadoListOld) {
                if (!comunicadoListNew.contains(comunicadoListOldComunicado)) {
                    comunicadoListOldComunicado.setCedulae(null);
                    comunicadoListOldComunicado = em.merge(comunicadoListOldComunicado);
                }
            }
            for (Comunicado comunicadoListNewComunicado : comunicadoListNew) {
                if (!comunicadoListOld.contains(comunicadoListNewComunicado)) {
                    EmpTemp oldCedulaeOfComunicadoListNewComunicado = comunicadoListNewComunicado.getCedulae();
                    comunicadoListNewComunicado.setCedulae(empTemp);
                    comunicadoListNewComunicado = em.merge(comunicadoListNewComunicado);
                    if (oldCedulaeOfComunicadoListNewComunicado != null && !oldCedulaeOfComunicadoListNewComunicado.equals(empTemp)) {
                        oldCedulaeOfComunicadoListNewComunicado.getComunicadoList().remove(comunicadoListNewComunicado);
                        oldCedulaeOfComunicadoListNewComunicado = em.merge(oldCedulaeOfComunicadoListNewComunicado);
                    }
                }
            }
            for (AsigImpl asigImplListNewAsigImpl : asigImplListNew) {
                if (!asigImplListOld.contains(asigImplListNewAsigImpl)) {
                    EmpTemp oldCedulaeOfAsigImplListNewAsigImpl = asigImplListNewAsigImpl.getCedulae();
                    asigImplListNewAsigImpl.setCedulae(empTemp);
                    asigImplListNewAsigImpl = em.merge(asigImplListNewAsigImpl);
                    if (oldCedulaeOfAsigImplListNewAsigImpl != null && !oldCedulaeOfAsigImplListNewAsigImpl.equals(empTemp)) {
                        oldCedulaeOfAsigImplListNewAsigImpl.getAsigImplList().remove(asigImplListNewAsigImpl);
                        oldCedulaeOfAsigImplListNewAsigImpl = em.merge(oldCedulaeOfAsigImplListNewAsigImpl);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empTemp.getCedulae();
                if (findEmpTemp(id) == null) {
                    throw new NonexistentEntityException("The empTemp with id " + id + " no longer exists.");
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
            EmpTemp empTemp;
            try {
                empTemp = em.getReference(EmpTemp.class, id);
                empTemp.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empTemp with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<AsigImpl> asigImplListOrphanCheck = empTemp.getAsigImplList();
            for (AsigImpl asigImplListOrphanCheckAsigImpl : asigImplListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This EmpTemp (" + empTemp + ") cannot be destroyed since the AsigImpl " + asigImplListOrphanCheckAsigImpl + " in its asigImplList field has a non-nullable cedulae field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empleados empleados = empTemp.getEmpleados();
            if (empleados != null) {
                empleados.setEmpTemp(null);
                empleados = em.merge(empleados);
            }
            AsignacionC idAsig = empTemp.getIdAsig();
            if (idAsig != null) {
                idAsig.getEmpTempList().remove(empTemp);
                idAsig = em.merge(idAsig);
            }
            List<Comunicado> comunicadoList = empTemp.getComunicadoList();
            for (Comunicado comunicadoListComunicado : comunicadoList) {
                comunicadoListComunicado.setCedulae(null);
                comunicadoListComunicado = em.merge(comunicadoListComunicado);
            }
            em.remove(empTemp);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EmpTemp> findEmpTempEntities() {
        return findEmpTempEntities(true, -1, -1);
    }

    public List<EmpTemp> findEmpTempEntities(int maxResults, int firstResult) {
        return findEmpTempEntities(false, maxResults, firstResult);
    }

    private List<EmpTemp> findEmpTempEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EmpTemp.class));
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

    public EmpTemp findEmpTemp(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmpTemp.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpTempCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EmpTemp> rt = cq.from(EmpTemp.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
