/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.service;

import com.porcupine.psp.model.vo.EmpleadosVO;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import model.dao.exceptions.*;

/**
 *
 * @author Zergio
 */
public class EmpleadosService implements IService<EmpleadosVO, Integer>{
    
    private static EmpleadosService instance;
    
    
    public static synchronized EmpleadosService getInstance() {
        if (instance == null) {
            instance = new EmpleadosService();
        }
        return instance;
    }

    @Override
    public void create(EmpleadosVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public EmpleadosVO find(Integer id) throws EntityNotFoundException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(EmpleadosVO vo) throws NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<EmpleadosVO> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
