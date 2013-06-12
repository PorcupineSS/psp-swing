/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.entity.Empleados;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;

/**
 *
 * @author Zergio
 */
public class EmpleadosDAO implements ICrudDAO<Empleados, Long>{

    EmpleadosDAO(String PU) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void create(Empleados entity) throws PreexistingEntityException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Empleados find(Long id) throws EntityNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Empleados entity) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Long id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Empleados> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
