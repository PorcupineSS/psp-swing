/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.*;
import com.porcupine.psp.model.entity.Cliente;
import com.porcupine.psp.model.entity.Contrato;
import com.porcupine.psp.model.entity.DirComercial;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;


/**
 *
 * @author Feanor
 */
public class ContratoDAO implements ICrudDAO<Contrato, Short> {
    
    private EntityManagerFactory entityManagerFactory;
    
    ContratoDAO(String PU, Map propierties) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU, propierties);
    }
    
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
    @Override
    public void create(Contrato entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            
            Cliente cliente = entity.getIdcl();
            DirComercial dirComercial = entity.getCedulae();
            
            if (cliente != null) {
                Short idCliente = cliente.getIdcl();
                try {
                    cliente = entityManager.getReference(cliente.getClass(), cliente.getIdcl());
                } catch (EntityNotFoundException e) {
                    throw new NonexistentEntityException("¡El cliente con id: " + idCliente + ", asociado al contrato que intenta crear, no existe!", e);
                }
                entity.setIdcl(cliente);
            }
            if (dirComercial != null) {
                Integer cedulaDirComercial = dirComercial.getCedulae();
                try {
                    dirComercial = entityManager.getReference(dirComercial.getClass(), dirComercial.getCedulae());
                } catch (EntityNotFoundException e) {
                    throw new NonexistentEntityException("¡El director comercial con cédula: " + cedulaDirComercial + ", asociado al contrato que intenta crear, no existe!", e);
                }
                entity.setCedulae(dirComercial);
            }
            
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (find(new Short(entity.getIdContrato())) != null) {
                throw new PreexistingEntityException("¡El contrato" + entity.getIdContrato() + " ya existe!", ex);
            }
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    @Override
    public Contrato find(Short id) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(Contrato.class, id);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("El contrato con id " + id + " no existe.");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
    
    @Override
    public void update(Contrato entity) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entity = entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
    
    @Override
    public void delete(Short id) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Contrato contrato = null;
            try {
                contrato = entityManager.getReference(Contrato.class, id);
            } catch (EntityNotFoundException e) {
                throw new NonexistentEntityException("El contrato con id: " + id + ", no existe!", e);
            }

            entityManager.remove(contrato);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
    
    @Override
    public List<Contrato> getList() {
         EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contrato.class));
            Query q = entityManager.createQuery(cq);
            return q.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public Iterable<Contrato> findByName(String name) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            List<Contrato> contratos;
            Query q = entityManager.createQuery("SELECT u FROM Contrato u "
                    + "WHERE u.nombreC LIKE :name ").setParameter("name", "%" + name + "%");
            //Query q = entityManager.createNamedQuery("ImplSeguridad.findByNombreI").setParameter("nombreI", name);
            contratos = q.getResultList();
            return contratos;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("¡No existen contratos con nombre: " + name + "!");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
        
    
}
