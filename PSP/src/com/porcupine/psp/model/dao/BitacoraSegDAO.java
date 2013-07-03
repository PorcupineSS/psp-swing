/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.BitacoraSeg;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Zergio
 */
public class BitacoraSegDAO implements ICrudDAO<BitacoraSeg, Integer> {
    
    private EntityManagerFactory entityManagerFactory;

    public BitacoraSegDAO(String PU, Map propierties) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU, propierties);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(BitacoraSeg entity) throws PreexistingEntityException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BitacoraSeg find(Integer id) throws EntityNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(BitacoraSeg entity) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<BitacoraSeg> getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BitacoraSeg.class));
            Query q = entityManager.createQuery(cq);

            return q.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
    
}
