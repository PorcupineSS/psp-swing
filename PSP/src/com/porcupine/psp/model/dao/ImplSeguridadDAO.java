/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.*;
import com.porcupine.psp.model.entity.CoordTYT;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.entity.Proveedor;
import java.util.ArrayList;
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
 * @author Jeisson Andrés Vergara
 */
public class ImplSeguridadDAO implements ICrudDAO<ImplSeguridad, Short> {

    private EntityManagerFactory entityManagerFactory;

    ImplSeguridadDAO(String PU, Map propierties) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU, propierties);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(ImplSeguridad entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();

            Proveedor proveedor = entity.getIdPro();
            CoordTYT coordinadorTyT = entity.getCedulae();

            if (proveedor != null) {
                Short idProveedor = proveedor.getIdPro();
                try {
                    proveedor = entityManager.getReference(proveedor.getClass(), proveedor.getIdPro());
                } catch (EntityNotFoundException e) {
                    throw new NonexistentEntityException("¡El proveedor con id: " + idProveedor + ", asociado al implemento que intenta crear, no existe!", e);
                }
                entity.setIdPro(proveedor);
            }
            if (coordinadorTyT != null) {
                Integer cedulaCoordinadorTyT = coordinadorTyT.getCedulae();
                try {
                    coordinadorTyT = entityManager.getReference(coordinadorTyT.getClass(), coordinadorTyT.getCedulae());
                } catch (EntityNotFoundException e) {
                    throw new NonexistentEntityException("¡El coordinador técnico y tecnológico con cédula: " + cedulaCoordinadorTyT + ", asociado al implemento que intenta crear, no existe!", e);
                }
                entity.setCedulae(coordinadorTyT);
            }

            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (find(new Short(entity.getIdImplemento())) != null) {
                throw new PreexistingEntityException("¡El implemento" + entity.getNombreI() + " ya existe!", ex);
            }
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public ImplSeguridad find(Short id) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(ImplSeguridad.class, id);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("¡El implemento con id: " + id + ", no existe!");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    @Override
    public void update(ImplSeguridad entity) throws NonexistentEntityException {
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
        //"UPDATE ImplSeguridad u SET u.nombreI = :nombre, u.precioUnitarioI = :precioUnitario, u.cantidad = :cantidad, u.descripcionI = :descripcion, u.estadoI = :estado").setParameter(nombre, precioUnitario, cantidad, descripcion, estado);
        
    }

    @Override
    public void delete(Short id) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            ImplSeguridad implementoSeg = null;
            try {
                implementoSeg = entityManager.getReference(ImplSeguridad.class, id);
            } catch (EntityNotFoundException e) {
                throw new NonexistentEntityException("¡El implemento con id: " + id + ", no existe!", e);
            }

            entityManager.remove(implementoSeg);
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
    public List<ImplSeguridad> getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ImplSeguridad.class));
            Query q = entityManager.createQuery(cq);
            return q.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public Iterable<ImplSeguridad> findByName(String name) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            List<ImplSeguridad> implementos;
            Query q = entityManager.createQuery("SELECT u FROM ImplSeguridad u "
                    + "WHERE u.nombreI LIKE :name ").setParameter("name", "%" + name + "%");
            //Query q = entityManager.createNamedQuery("ImplSeguridad.findByNombreI").setParameter("nombreI", name);
            implementos = q.getResultList();
            return implementos;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("¡No existen implementos con nombre: " + name + "!");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public void adicionarImplemento(Short id, Integer cantidad) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            Query query = entityManager.createNativeQuery("{call ADICIONAR_IMPLEMENTO(?,?)}",
                    ImplSeguridad.class).setParameter(1, id).setParameter(2, cantidad);
            query.getSingleResult();
        } catch (Exception ex) {
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }

    }

    public void asignarImplemento(Short idImplemento, Integer idEmpleadoTemporal,
            Integer idCoordinador, Integer cantidadAsignada) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            Query query = entityManager.createNativeQuery("{call ASIGNAR_IMPLEMENTO"
                    + " (?, ?, ?, ?)}",
                    ImplSeguridad.class).setParameter(1, idImplemento).setParameter(2, idEmpleadoTemporal)
                    .setParameter(3, idCoordinador).setParameter(4, cantidadAsignada);
            query.getSingleResult();
        } catch (Exception ex) {
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
    
    public void despojarImplemento(Short idImplemento, Integer idEmpleadoTemporal,
            Integer idCoordinador, Integer cantidadDespojada) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            Query query = entityManager.createNativeQuery("{call DESPOJAR_IMPLEMENTO"
                    + " (?, ?, ?, ?)}",
                    ImplSeguridad.class).setParameter(1, idImplemento).setParameter(2, idEmpleadoTemporal)
                    .setParameter(3, idCoordinador).setParameter(4, cantidadDespojada);
            query.getSingleResult();
        } catch (Exception ex) {
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
}
