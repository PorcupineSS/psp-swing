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
import com.porcupine.psp.model.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import com.porcupine.psp.model.entity.Contrato;
import com.porcupine.psp.model.entity.DirComercial;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class DirComercialJpaController implements Serializable {

    public DirComercialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DirComercial dirComercial) throws IllegalOrphanException, PreexistingEntityException, Exception {
        if (dirComercial.getClienteList() == null) {
            dirComercial.setClienteList(new ArrayList<Cliente>());
        }
        if (dirComercial.getContratoList() == null) {
            dirComercial.setContratoList(new ArrayList<Contrato>());
        }
        List<String> illegalOrphanMessages = null;
        EmpPlanta empPlantaOrphanCheck = dirComercial.getEmpPlanta();
        if (empPlantaOrphanCheck != null) {
            DirComercial oldDirComercialOfEmpPlanta = empPlantaOrphanCheck.getDirComercial();
            if (oldDirComercialOfEmpPlanta != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The EmpPlanta " + empPlantaOrphanCheck + " already has an item of type DirComercial whose empPlanta column cannot be null. Please make another selection for the empPlanta field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmpPlanta empPlanta = dirComercial.getEmpPlanta();
            if (empPlanta != null) {
                empPlanta = em.getReference(empPlanta.getClass(), empPlanta.getCedulae());
                dirComercial.setEmpPlanta(empPlanta);
            }
            List<Cliente> attachedClienteList = new ArrayList<Cliente>();
            for (Cliente clienteListClienteToAttach : dirComercial.getClienteList()) {
                clienteListClienteToAttach = em.getReference(clienteListClienteToAttach.getClass(), clienteListClienteToAttach.getIdcl());
                attachedClienteList.add(clienteListClienteToAttach);
            }
            dirComercial.setClienteList(attachedClienteList);
            List<Contrato> attachedContratoList = new ArrayList<Contrato>();
            for (Contrato contratoListContratoToAttach : dirComercial.getContratoList()) {
                contratoListContratoToAttach = em.getReference(contratoListContratoToAttach.getClass(), contratoListContratoToAttach.getIdContrato());
                attachedContratoList.add(contratoListContratoToAttach);
            }
            dirComercial.setContratoList(attachedContratoList);
            em.persist(dirComercial);
            if (empPlanta != null) {
                empPlanta.setDirComercial(dirComercial);
                empPlanta = em.merge(empPlanta);
            }
            for (Cliente clienteListCliente : dirComercial.getClienteList()) {
                DirComercial oldCedulaeOfClienteListCliente = clienteListCliente.getCedulae();
                clienteListCliente.setCedulae(dirComercial);
                clienteListCliente = em.merge(clienteListCliente);
                if (oldCedulaeOfClienteListCliente != null) {
                    oldCedulaeOfClienteListCliente.getClienteList().remove(clienteListCliente);
                    oldCedulaeOfClienteListCliente = em.merge(oldCedulaeOfClienteListCliente);
                }
            }
            for (Contrato contratoListContrato : dirComercial.getContratoList()) {
                DirComercial oldCedulaeOfContratoListContrato = contratoListContrato.getCedulae();
                contratoListContrato.setCedulae(dirComercial);
                contratoListContrato = em.merge(contratoListContrato);
                if (oldCedulaeOfContratoListContrato != null) {
                    oldCedulaeOfContratoListContrato.getContratoList().remove(contratoListContrato);
                    oldCedulaeOfContratoListContrato = em.merge(oldCedulaeOfContratoListContrato);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDirComercial(dirComercial.getCedulae()) != null) {
                throw new PreexistingEntityException("DirComercial " + dirComercial + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DirComercial dirComercial) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DirComercial persistentDirComercial = em.find(DirComercial.class, dirComercial.getCedulae());
            EmpPlanta empPlantaOld = persistentDirComercial.getEmpPlanta();
            EmpPlanta empPlantaNew = dirComercial.getEmpPlanta();
            List<Cliente> clienteListOld = persistentDirComercial.getClienteList();
            List<Cliente> clienteListNew = dirComercial.getClienteList();
            List<Contrato> contratoListOld = persistentDirComercial.getContratoList();
            List<Contrato> contratoListNew = dirComercial.getContratoList();
            List<String> illegalOrphanMessages = null;
            if (empPlantaNew != null && !empPlantaNew.equals(empPlantaOld)) {
                DirComercial oldDirComercialOfEmpPlanta = empPlantaNew.getDirComercial();
                if (oldDirComercialOfEmpPlanta != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The EmpPlanta " + empPlantaNew + " already has an item of type DirComercial whose empPlanta column cannot be null. Please make another selection for the empPlanta field.");
                }
            }
            for (Cliente clienteListOldCliente : clienteListOld) {
                if (!clienteListNew.contains(clienteListOldCliente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cliente " + clienteListOldCliente + " since its cedulae field is not nullable.");
                }
            }
            for (Contrato contratoListOldContrato : contratoListOld) {
                if (!contratoListNew.contains(contratoListOldContrato)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Contrato " + contratoListOldContrato + " since its cedulae field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empPlantaNew != null) {
                empPlantaNew = em.getReference(empPlantaNew.getClass(), empPlantaNew.getCedulae());
                dirComercial.setEmpPlanta(empPlantaNew);
            }
            List<Cliente> attachedClienteListNew = new ArrayList<Cliente>();
            for (Cliente clienteListNewClienteToAttach : clienteListNew) {
                clienteListNewClienteToAttach = em.getReference(clienteListNewClienteToAttach.getClass(), clienteListNewClienteToAttach.getIdcl());
                attachedClienteListNew.add(clienteListNewClienteToAttach);
            }
            clienteListNew = attachedClienteListNew;
            dirComercial.setClienteList(clienteListNew);
            List<Contrato> attachedContratoListNew = new ArrayList<Contrato>();
            for (Contrato contratoListNewContratoToAttach : contratoListNew) {
                contratoListNewContratoToAttach = em.getReference(contratoListNewContratoToAttach.getClass(), contratoListNewContratoToAttach.getIdContrato());
                attachedContratoListNew.add(contratoListNewContratoToAttach);
            }
            contratoListNew = attachedContratoListNew;
            dirComercial.setContratoList(contratoListNew);
            dirComercial = em.merge(dirComercial);
            if (empPlantaOld != null && !empPlantaOld.equals(empPlantaNew)) {
                empPlantaOld.setDirComercial(null);
                empPlantaOld = em.merge(empPlantaOld);
            }
            if (empPlantaNew != null && !empPlantaNew.equals(empPlantaOld)) {
                empPlantaNew.setDirComercial(dirComercial);
                empPlantaNew = em.merge(empPlantaNew);
            }
            for (Cliente clienteListNewCliente : clienteListNew) {
                if (!clienteListOld.contains(clienteListNewCliente)) {
                    DirComercial oldCedulaeOfClienteListNewCliente = clienteListNewCliente.getCedulae();
                    clienteListNewCliente.setCedulae(dirComercial);
                    clienteListNewCliente = em.merge(clienteListNewCliente);
                    if (oldCedulaeOfClienteListNewCliente != null && !oldCedulaeOfClienteListNewCliente.equals(dirComercial)) {
                        oldCedulaeOfClienteListNewCliente.getClienteList().remove(clienteListNewCliente);
                        oldCedulaeOfClienteListNewCliente = em.merge(oldCedulaeOfClienteListNewCliente);
                    }
                }
            }
            for (Contrato contratoListNewContrato : contratoListNew) {
                if (!contratoListOld.contains(contratoListNewContrato)) {
                    DirComercial oldCedulaeOfContratoListNewContrato = contratoListNewContrato.getCedulae();
                    contratoListNewContrato.setCedulae(dirComercial);
                    contratoListNewContrato = em.merge(contratoListNewContrato);
                    if (oldCedulaeOfContratoListNewContrato != null && !oldCedulaeOfContratoListNewContrato.equals(dirComercial)) {
                        oldCedulaeOfContratoListNewContrato.getContratoList().remove(contratoListNewContrato);
                        oldCedulaeOfContratoListNewContrato = em.merge(oldCedulaeOfContratoListNewContrato);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dirComercial.getCedulae();
                if (findDirComercial(id) == null) {
                    throw new NonexistentEntityException("The dirComercial with id " + id + " no longer exists.");
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
            DirComercial dirComercial;
            try {
                dirComercial = em.getReference(DirComercial.class, id);
                dirComercial.getCedulae();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dirComercial with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Cliente> clienteListOrphanCheck = dirComercial.getClienteList();
            for (Cliente clienteListOrphanCheckCliente : clienteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DirComercial (" + dirComercial + ") cannot be destroyed since the Cliente " + clienteListOrphanCheckCliente + " in its clienteList field has a non-nullable cedulae field.");
            }
            List<Contrato> contratoListOrphanCheck = dirComercial.getContratoList();
            for (Contrato contratoListOrphanCheckContrato : contratoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DirComercial (" + dirComercial + ") cannot be destroyed since the Contrato " + contratoListOrphanCheckContrato + " in its contratoList field has a non-nullable cedulae field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            EmpPlanta empPlanta = dirComercial.getEmpPlanta();
            if (empPlanta != null) {
                empPlanta.setDirComercial(null);
                empPlanta = em.merge(empPlanta);
            }
            em.remove(dirComercial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DirComercial> findDirComercialEntities() {
        return findDirComercialEntities(true, -1, -1);
    }

    public List<DirComercial> findDirComercialEntities(int maxResults, int firstResult) {
        return findDirComercialEntities(false, maxResults, firstResult);
    }

    private List<DirComercial> findDirComercialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DirComercial.class));
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

    public DirComercial findDirComercial(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DirComercial.class, id);
        } finally {
            em.close();
        }
    }

    public int getDirComercialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DirComercial> rt = cq.from(DirComercial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
