/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.Empleados;
import com.porcupine.psp.model.entity.TelsCli;
import com.porcupine.psp.model.entity.TelsEmp;
import com.porcupine.psp.model.entity.TelsProv;
import com.porcupine.psp.util.TipoTelefono;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Zergio
 */
public class TelefonosDAO {

    private EntityManagerFactory entityManagerFactory;

    TelefonosDAO(String PU, Map propierties) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU, propierties);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public Object findSpecific(String telefono, TipoTelefono tipoTelefono) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            if (tipoTelefono == TipoTelefono.CLIENTE) {
                entityManager = getEntityManager();
                Query query = entityManager.createNamedQuery("TelsCli.findByNumTelefonoC", TelsCli.class).setParameter(1, telefono);
                TelsCli r = (TelsCli) query.getSingleResult();
                return r;
            } else if (tipoTelefono == TipoTelefono.EMPLEADO) {
                entityManager = getEntityManager();
                Query query = entityManager.createNamedQuery("TelsEmp.findByNumTelefonoE", TelsEmp.class).setParameter("numTelefonoE", telefono);
                TelsEmp r = null;
                try {
                    r = (TelsEmp) query.getSingleResult();
                    return r;
                } catch (Exception e) {
                    return null;
                }

            } else if (tipoTelefono == TipoTelefono.PROVEEDOR) {
                entityManager = getEntityManager();
                Query query = entityManager.createNamedQuery("TelsProv.findByNumTelefonoP", TelsProv.class).setParameter(1, telefono);
                TelsProv r = (TelsProv) query.getSingleResult();
                return r;
            }
            return null;


        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("El telefono " + telefono + " no existe.");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public void create(TelsEmp entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void create(TelsCli entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void create(TelsProv entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void update(TelsEmp entity) throws NonexistentEntityException {
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

    public TelsEmp find(Short id) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(TelsEmp.class, id);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("El telefono con " + id + " no existe.");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public List<TelsEmp> getListEmp() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TelsEmp.class));
            Query q = entityManager.createQuery(cq);

            return q.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public Short getNewID(Integer count1) {
        Integer count = getListEmp().get(getListEmp().size()-1).getIdTe() + count1;
        return count.shortValue();
    }
}
