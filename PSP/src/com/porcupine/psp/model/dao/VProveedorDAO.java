/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.controller.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.view.VProv;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Johan
 */


public class VProveedorDAO implements ICrudDAO<VProv, BigDecimal> {

    private EntityManagerFactory entityManagerFactory;

    public VProveedorDAO(String PU) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    /*
    //Este create funciona usando el nombre del proveedor
    @Override
    public void create(VProv entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {

                if (findByName(entity.getNombre()) != null) {
                    throw new PreexistingEntityException("¡El proveedor " + entity.getNombre()
                            + " ya existe!", ex);
                }
                throw ex;
            } catch (Exception ex1) {
                Logger.getLogger(VProveedorDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }*/

    //Encontrar  proveedor por nombre 
    public VProv findByName(String name) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            Query q = entityManager.createQuery("SELECT u FROM VProv u "
                    + "WHERE u.nombreProveedor LIKE :name ")
                    .setParameter("name", name);
            return (VProv) q.getSingleResult();
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("¡El proveedor con nombre " + name + " no existe!");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    //Encontrar  por id
    @Override
    public VProv find(BigDecimal id) throws EntityNotFoundException {

        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(VProv.class, id);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("¡El proveedor con id " + id + " no existe!");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    //Encontrar proveedor por cedula
    public VProv findByCedula(BigInteger cedula) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            Query q = entityManager.createQuery("SELECT u FROM VProv u "
                    + "WHERE u.cedula LIKE :cedula ")
                    .setParameter("cedula", cedula);
            return (VProv) q.getSingleResult();
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("¡El proveedor con cedula " + cedula + " no existe!");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
    
    /*
    //update por Proveedor
    @Override
    public void update(VProv entity) throws NonexistentEntityException {
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
            BigDecimal id = entity.getIdProveedor();
            if (find(id) == null) {
                throw new NonexistentEntityException("¡El proveedor con id " + id + " no existe!", e);
            }
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }*/
    
    /*
    //Delete por id de proveedor
    @Override
    public void delete(BigDecimal id) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            VProv proveedor = null;
            try {
                proveedor = entityManager.getReference(VProv.class, id);
            } catch (EntityNotFoundException e) {
                throw new NonexistentEntityException("¡El proveedor con id " + id + " no existe!", e);
            }

            entityManager.remove(proveedor);
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
    }*/

    public void deleteByNombre(String name) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            VProv proveedor = null;
            try {
                proveedor = findByName(name);
            } catch (Exception e) {
                throw new NonexistentEntityException("¡El proveedor con nombre " + name + " no existe!", e);
            }

            entityManager.remove(proveedor);
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
    public List<VProv> getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VProv.class));
            Query q = entityManager.createQuery(cq);
            return q.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    @Override
    public void create(VProv entity) throws model.dao.exceptions.PreexistingEntityException, com.porcupine.psp.model.dao.exceptions.NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(VProv entity) throws com.porcupine.psp.model.dao.exceptions.NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BigDecimal id) throws com.porcupine.psp.model.dao.exceptions.NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
