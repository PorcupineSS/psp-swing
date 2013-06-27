/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.DirGestionHum;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Zergio
 */
public class DirGestionHumDAO implements ICrudDAO<DirGestionHum, Integer>{

    DirGestionHumDAO(String PU, Map propierties) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void create(DirGestionHum entity) throws PreexistingEntityException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DirGestionHum find(Integer id) throws EntityNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(DirGestionHum entity) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<DirGestionHum> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
