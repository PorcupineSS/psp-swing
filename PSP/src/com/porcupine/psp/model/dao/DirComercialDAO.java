/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.DirComercial;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

/**
 *
 * @author Feanor
 */
public class DirComercialDAO implements ICrudDAO<DirComercial, Integer>{
    
    private EntityManagerFactory entityManagerFactory;
    
    DirComercialDAO(String PU, Map propierties) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU, propierties);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(DirComercial entity) throws PreexistingEntityException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DirComercial find(Integer id) throws EntityNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DirComercial entity) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DirComercial> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
