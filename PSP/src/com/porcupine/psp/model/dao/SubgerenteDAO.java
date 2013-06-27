/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.Subgerente;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Zergio
 */
public class SubgerenteDAO implements ICrudDAO<Subgerente, Integer> {

    SubgerenteDAO(String PU, Map propierties) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void create(Subgerente entity) throws PreexistingEntityException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Subgerente find(Integer id) throws EntityNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Subgerente entity) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Subgerente> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
