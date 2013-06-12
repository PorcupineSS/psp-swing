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
import com.porcupine.psp.model.entity.Cliente;
import com.porcupine.psp.model.entity.TelsCli;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class TelsCliJpaController implements Serializable {

    public TelsCliJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TelsCli telsCli) {
        if (telsCli.getClienteList() == null) {
            telsCli.setClienteList(new ArrayList<Cliente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Cliente> attachedClienteList = new ArrayList<Cliente>();
            for (Cliente clienteListClienteToAttach : telsCli.getClienteList()) {
                clienteListClienteToAttach = em.getReference(clienteListClienteToAttach.getClass(), clienteListClienteToAttach.getIdcl());
                attachedClienteList.add(clienteListClienteToAttach);
            }
            telsCli.setClienteList(attachedClienteList);
            em.persist(telsCli);
            for (Cliente clienteListCliente : telsCli.getClienteList()) {
                clienteListCliente.getTelsCliList().add(telsCli);
                clienteListCliente = em.merge(clienteListCliente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TelsCli telsCli) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TelsCli persistentTelsCli = em.find(TelsCli.class, telsCli.getIdTc());
            List<Cliente> clienteListOld = persistentTelsCli.getClienteList();
            List<Cliente> clienteListNew = telsCli.getClienteList();
            List<Cliente> attachedClienteListNew = new ArrayList<Cliente>();
            for (Cliente clienteListNewClienteToAttach : clienteListNew) {
                clienteListNewClienteToAttach = em.getReference(clienteListNewClienteToAttach.getClass(), clienteListNewClienteToAttach.getIdcl());
                attachedClienteListNew.add(clienteListNewClienteToAttach);
            }
            clienteListNew = attachedClienteListNew;
            telsCli.setClienteList(clienteListNew);
            telsCli = em.merge(telsCli);
            for (Cliente clienteListOldCliente : clienteListOld) {
                if (!clienteListNew.contains(clienteListOldCliente)) {
                    clienteListOldCliente.getTelsCliList().remove(telsCli);
                    clienteListOldCliente = em.merge(clienteListOldCliente);
                }
            }
            for (Cliente clienteListNewCliente : clienteListNew) {
                if (!clienteListOld.contains(clienteListNewCliente)) {
                    clienteListNewCliente.getTelsCliList().add(telsCli);
                    clienteListNewCliente = em.merge(clienteListNewCliente);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = telsCli.getIdTc();
                if (findTelsCli(id) == null) {
                    throw new NonexistentEntityException("The telsCli with id " + id + " no longer exists.");
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
            TelsCli telsCli;
            try {
                telsCli = em.getReference(TelsCli.class, id);
                telsCli.getIdTc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The telsCli with id " + id + " no longer exists.", enfe);
            }
            List<Cliente> clienteList = telsCli.getClienteList();
            for (Cliente clienteListCliente : clienteList) {
                clienteListCliente.getTelsCliList().remove(telsCli);
                clienteListCliente = em.merge(clienteListCliente);
            }
            em.remove(telsCli);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TelsCli> findTelsCliEntities() {
        return findTelsCliEntities(true, -1, -1);
    }

    public List<TelsCli> findTelsCliEntities(int maxResults, int firstResult) {
        return findTelsCliEntities(false, maxResults, firstResult);
    }

    private List<TelsCli> findTelsCliEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TelsCli.class));
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

    public TelsCli findTelsCli(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TelsCli.class, id);
        } finally {
            em.close();
        }
    }

    public int getTelsCliCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TelsCli> rt = cq.from(TelsCli.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
