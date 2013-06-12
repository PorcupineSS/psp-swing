/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.controller;

import com.porcupine.psp.controller.exceptions.NonexistentEntityException;
import com.porcupine.psp.controller.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.Actualizacion;
import com.porcupine.psp.model.entity.ActualizacionPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.porcupine.psp.model.entity.Subgerente;
import com.porcupine.psp.model.entity.DirGestionHum;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zergio
 */
public class ActualizacionJpaController implements Serializable {

    public ActualizacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Actualizacion actualizacion) throws PreexistingEntityException, Exception {
        if (actualizacion.getActualizacionPK() == null) {
            actualizacion.setActualizacionPK(new ActualizacionPK());
        }
        actualizacion.getActualizacionPK().setSubCedulae(actualizacion.getSubgerente().getCedulae());
        actualizacion.getActualizacionPK().setCedulae(actualizacion.getDirGestionHum().getCedulae());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Subgerente subgerente = actualizacion.getSubgerente();
            if (subgerente != null) {
                subgerente = em.getReference(subgerente.getClass(), subgerente.getCedulae());
                actualizacion.setSubgerente(subgerente);
            }
            DirGestionHum dirGestionHum = actualizacion.getDirGestionHum();
            if (dirGestionHum != null) {
                dirGestionHum = em.getReference(dirGestionHum.getClass(), dirGestionHum.getCedulae());
                actualizacion.setDirGestionHum(dirGestionHum);
            }
            em.persist(actualizacion);
            if (subgerente != null) {
                subgerente.getActualizacionList().add(actualizacion);
                subgerente = em.merge(subgerente);
            }
            if (dirGestionHum != null) {
                dirGestionHum.getActualizacionList().add(actualizacion);
                dirGestionHum = em.merge(dirGestionHum);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findActualizacion(actualizacion.getActualizacionPK()) != null) {
                throw new PreexistingEntityException("Actualizacion " + actualizacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Actualizacion actualizacion) throws NonexistentEntityException, Exception {
        actualizacion.getActualizacionPK().setSubCedulae(actualizacion.getSubgerente().getCedulae());
        actualizacion.getActualizacionPK().setCedulae(actualizacion.getDirGestionHum().getCedulae());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actualizacion persistentActualizacion = em.find(Actualizacion.class, actualizacion.getActualizacionPK());
            Subgerente subgerenteOld = persistentActualizacion.getSubgerente();
            Subgerente subgerenteNew = actualizacion.getSubgerente();
            DirGestionHum dirGestionHumOld = persistentActualizacion.getDirGestionHum();
            DirGestionHum dirGestionHumNew = actualizacion.getDirGestionHum();
            if (subgerenteNew != null) {
                subgerenteNew = em.getReference(subgerenteNew.getClass(), subgerenteNew.getCedulae());
                actualizacion.setSubgerente(subgerenteNew);
            }
            if (dirGestionHumNew != null) {
                dirGestionHumNew = em.getReference(dirGestionHumNew.getClass(), dirGestionHumNew.getCedulae());
                actualizacion.setDirGestionHum(dirGestionHumNew);
            }
            actualizacion = em.merge(actualizacion);
            if (subgerenteOld != null && !subgerenteOld.equals(subgerenteNew)) {
                subgerenteOld.getActualizacionList().remove(actualizacion);
                subgerenteOld = em.merge(subgerenteOld);
            }
            if (subgerenteNew != null && !subgerenteNew.equals(subgerenteOld)) {
                subgerenteNew.getActualizacionList().add(actualizacion);
                subgerenteNew = em.merge(subgerenteNew);
            }
            if (dirGestionHumOld != null && !dirGestionHumOld.equals(dirGestionHumNew)) {
                dirGestionHumOld.getActualizacionList().remove(actualizacion);
                dirGestionHumOld = em.merge(dirGestionHumOld);
            }
            if (dirGestionHumNew != null && !dirGestionHumNew.equals(dirGestionHumOld)) {
                dirGestionHumNew.getActualizacionList().add(actualizacion);
                dirGestionHumNew = em.merge(dirGestionHumNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ActualizacionPK id = actualizacion.getActualizacionPK();
                if (findActualizacion(id) == null) {
                    throw new NonexistentEntityException("The actualizacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ActualizacionPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actualizacion actualizacion;
            try {
                actualizacion = em.getReference(Actualizacion.class, id);
                actualizacion.getActualizacionPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The actualizacion with id " + id + " no longer exists.", enfe);
            }
            Subgerente subgerente = actualizacion.getSubgerente();
            if (subgerente != null) {
                subgerente.getActualizacionList().remove(actualizacion);
                subgerente = em.merge(subgerente);
            }
            DirGestionHum dirGestionHum = actualizacion.getDirGestionHum();
            if (dirGestionHum != null) {
                dirGestionHum.getActualizacionList().remove(actualizacion);
                dirGestionHum = em.merge(dirGestionHum);
            }
            em.remove(actualizacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Actualizacion> findActualizacionEntities() {
        return findActualizacionEntities(true, -1, -1);
    }

    public List<Actualizacion> findActualizacionEntities(int maxResults, int firstResult) {
        return findActualizacionEntities(false, maxResults, firstResult);
    }

    private List<Actualizacion> findActualizacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Actualizacion.class));
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

    public Actualizacion findActualizacion(ActualizacionPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Actualizacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getActualizacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Actualizacion> rt = cq.from(Actualizacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
