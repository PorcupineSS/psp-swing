/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.controller.MainController;
import com.porcupine.psp.model.entity.Empleados;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import com.porcupine.psp.model.dao.exceptions.*;
import com.porcupine.psp.model.entity.*;
import com.porcupine.psp.util.TipoEmpleado;
import java.util.Map;

/**
 *
 * @author Zergio
 */
public class EmpleadosDAO implements ICrudDAO<Empleados, Integer> {

    private EntityManagerFactory entityManagerFactory;

    EmpleadosDAO(String PU, Map propierties) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU, propierties);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(Empleados entity) throws PreexistingEntityException, NonexistentEntityException {
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

    @Override
    public Empleados find(Integer id) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(Empleados.class, id);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("El empleado con id " + id + " no existe.");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public Object findSpecific(Integer id, String rol) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            if (rol == TipoEmpleado.COORDINADOR_CONTRATO) {
                entityManager = getEntityManager();
                return entityManager.find(CoordContrato.class, id);
            } else if (rol == TipoEmpleado.COORDINADOR_TECNICO_TECNOLOGICO) {
                entityManager = getEntityManager();
                return entityManager.find(CoordTYT.class, id);
            } else if (rol == TipoEmpleado.DIRECTOR_COMERCIAL) {
                entityManager = getEntityManager();
                return entityManager.find(DirComercial.class, id);
            } else if (rol == TipoEmpleado.DIRECTOR_GESTION_HUMANA) {
                entityManager = getEntityManager();
                return entityManager.find(DirGestionHum.class, id);
            } else if (rol == TipoEmpleado.DIRECTOR_OPERACIONES) {
                entityManager = getEntityManager();
                return entityManager.find(DirOperaciones.class, id);
            } else if (rol == TipoEmpleado.SUBGERENTE) {
                entityManager = getEntityManager();
                return entityManager.find(Subgerente.class, id);
            } else if (rol == TipoEmpleado.TEMPORAL) {
                entityManager = getEntityManager();
                return entityManager.find(EmpTemp.class, id);
            }

            return null;


        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("El empleado con id " + id + " no existe.");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    @Override
    public void update(Empleados entity) throws NonexistentEntityException {
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
    public void delete(Integer id) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Empleados empleado = null;




            try {
                empleado = entityManager.getReference(Empleados.class, id);
            } catch (EntityNotFoundException e) {
                throw new NonexistentEntityException("El usuario con id " + id + " no existe.", e);
            }

            entityManager.remove(empleado);
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
    public List<Empleados> getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleados.class));
            Query q = entityManager.createQuery(cq);

            return q.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public Empleados login(Empleados entity) throws DataBaseException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            Empleados empleado;
            Query q = entityManager.createQuery("SELECT u FROM Empleados u "
                    + "WHERE u.cedulae =:username "
                    + "AND u.contrasenae =:password ")
                    .setParameter("username", entity.getCedulae())
                    .setParameter("password", entity.getContrasenae());
            try {
                empleado = (Empleados) q.getSingleResult();
            } catch (NoResultException e) {
                empleado = null;
            }
            return empleado;
        } catch (Exception e) {
            throw new DataBaseException("Error de Conexion a la Base de Datos", e);
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
}
