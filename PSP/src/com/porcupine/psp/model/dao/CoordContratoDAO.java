/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.entity.CoordContrato;
import com.porcupine.psp.model.entity.CoordTYT;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Zergio
 */
public class CoordContratoDAO implements ICrudDAO<CoordContrato, Integer> {

    public CoordContratoDAO(String PU, Map propierties) {
    }

    @Override
    public void create(CoordContrato entity) throws PreexistingEntityException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CoordContrato find(Integer id) throws EntityNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(CoordContrato entity) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<CoordContrato> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
}
