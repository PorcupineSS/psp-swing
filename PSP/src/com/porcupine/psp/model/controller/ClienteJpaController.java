/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.IllegalOrphanException;
import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.entity.Cliente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.porcupine.psp.model.entity.DirComercial;
import com.porcupine.psp.model.entity.TelsCli;
import java.util.ArrayList;
import java.util.List;
import com.porcupine.psp.model.entity.Contrato;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        if (cliente.getTelsCliList() == null) {
            cliente.setTelsCliList(new ArrayList<TelsCli>());
        }
        if (cliente.getContratoList() == null) {
            cliente.setContratoList(new ArrayList<Contrato>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DirComercial cedulae = cliente.getCedulae();
            if (cedulae != null) {
                cedulae = em.getReference(cedulae.getClass(), cedulae.getCedulae());
                cliente.setCedulae(cedulae);
            }
            List<TelsCli> attachedTelsCliList = new ArrayList<TelsCli>();
            for (TelsCli telsCliListTelsCliToAttach : cliente.getTelsCliList()) {
                telsCliListTelsCliToAttach = em.getReference(telsCliListTelsCliToAttach.getClass(), telsCliListTelsCliToAttach.getIdTc());
                attachedTelsCliList.add(telsCliListTelsCliToAttach);
            }
            cliente.setTelsCliList(attachedTelsCliList);
            List<Contrato> attachedContratoList = new ArrayList<Contrato>();
            for (Contrato contratoListContratoToAttach : cliente.getContratoList()) {
                contratoListContratoToAttach = em.getReference(contratoListContratoToAttach.getClass(), contratoListContratoToAttach.getIdContrato());
                attachedContratoList.add(contratoListContratoToAttach);
            }
            cliente.setContratoList(attachedContratoList);
            em.persist(cliente);
            if (cedulae != null) {
                cedulae.getClienteList().add(cliente);
                cedulae = em.merge(cedulae);
            }
            for (TelsCli telsCliListTelsCli : cliente.getTelsCliList()) {
                telsCliListTelsCli.getClienteList().add(cliente);
                telsCliListTelsCli = em.merge(telsCliListTelsCli);
            }
            for (Contrato contratoListContrato : cliente.getContratoList()) {
                Cliente oldIdclOfContratoListContrato = contratoListContrato.getIdcl();
                contratoListContrato.setIdcl(cliente);
                contratoListContrato = em.merge(contratoListContrato);
                if (oldIdclOfContratoListContrato != null) {
                    oldIdclOfContratoListContrato.getContratoList().remove(contratoListContrato);
                    oldIdclOfContratoListContrato = em.merge(oldIdclOfContratoListContrato);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdcl());
            DirComercial cedulaeOld = persistentCliente.getCedulae();
            DirComercial cedulaeNew = cliente.getCedulae();
            List<TelsCli> telsCliListOld = persistentCliente.getTelsCliList();
            List<TelsCli> telsCliListNew = cliente.getTelsCliList();
            List<Contrato> contratoListOld = persistentCliente.getContratoList();
            List<Contrato> contratoListNew = cliente.getContratoList();
            List<String> illegalOrphanMessages = null;
            for (Contrato contratoListOldContrato : contratoListOld) {
                if (!contratoListNew.contains(contratoListOldContrato)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Contrato " + contratoListOldContrato + " since its idcl field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (cedulaeNew != null) {
                cedulaeNew = em.getReference(cedulaeNew.getClass(), cedulaeNew.getCedulae());
                cliente.setCedulae(cedulaeNew);
            }
            List<TelsCli> attachedTelsCliListNew = new ArrayList<TelsCli>();
            for (TelsCli telsCliListNewTelsCliToAttach : telsCliListNew) {
                telsCliListNewTelsCliToAttach = em.getReference(telsCliListNewTelsCliToAttach.getClass(), telsCliListNewTelsCliToAttach.getIdTc());
                attachedTelsCliListNew.add(telsCliListNewTelsCliToAttach);
            }
            telsCliListNew = attachedTelsCliListNew;
            cliente.setTelsCliList(telsCliListNew);
            List<Contrato> attachedContratoListNew = new ArrayList<Contrato>();
            for (Contrato contratoListNewContratoToAttach : contratoListNew) {
                contratoListNewContratoToAttach = em.getReference(contratoListNewContratoToAttach.getClass(), contratoListNewContratoToAttach.getIdContrato());
                attachedContratoListNew.add(contratoListNewContratoToAttach);
            }
            contratoListNew = attachedContratoListNew;
            cliente.setContratoList(contratoListNew);
            cliente = em.merge(cliente);
            if (cedulaeOld != null && !cedulaeOld.equals(cedulaeNew)) {
                cedulaeOld.getClienteList().remove(cliente);
                cedulaeOld = em.merge(cedulaeOld);
            }
            if (cedulaeNew != null && !cedulaeNew.equals(cedulaeOld)) {
                cedulaeNew.getClienteList().add(cliente);
                cedulaeNew = em.merge(cedulaeNew);
            }
            for (TelsCli telsCliListOldTelsCli : telsCliListOld) {
                if (!telsCliListNew.contains(telsCliListOldTelsCli)) {
                    telsCliListOldTelsCli.getClienteList().remove(cliente);
                    telsCliListOldTelsCli = em.merge(telsCliListOldTelsCli);
                }
            }
            for (TelsCli telsCliListNewTelsCli : telsCliListNew) {
                if (!telsCliListOld.contains(telsCliListNewTelsCli)) {
                    telsCliListNewTelsCli.getClienteList().add(cliente);
                    telsCliListNewTelsCli = em.merge(telsCliListNewTelsCli);
                }
            }
            for (Contrato contratoListNewContrato : contratoListNew) {
                if (!contratoListOld.contains(contratoListNewContrato)) {
                    Cliente oldIdclOfContratoListNewContrato = contratoListNewContrato.getIdcl();
                    contratoListNewContrato.setIdcl(cliente);
                    contratoListNewContrato = em.merge(contratoListNewContrato);
                    if (oldIdclOfContratoListNewContrato != null && !oldIdclOfContratoListNewContrato.equals(cliente)) {
                        oldIdclOfContratoListNewContrato.getContratoList().remove(contratoListNewContrato);
                        oldIdclOfContratoListNewContrato = em.merge(oldIdclOfContratoListNewContrato);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = cliente.getIdcl();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdcl();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Contrato> contratoListOrphanCheck = cliente.getContratoList();
            for (Contrato contratoListOrphanCheckContrato : contratoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Contrato " + contratoListOrphanCheckContrato + " in its contratoList field has a non-nullable idcl field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            DirComercial cedulae = cliente.getCedulae();
            if (cedulae != null) {
                cedulae.getClienteList().remove(cliente);
                cedulae = em.merge(cedulae);
            }
            List<TelsCli> telsCliList = cliente.getTelsCliList();
            for (TelsCli telsCliListTelsCli : telsCliList) {
                telsCliListTelsCli.getClienteList().remove(cliente);
                telsCliListTelsCli = em.merge(telsCliListTelsCli);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
