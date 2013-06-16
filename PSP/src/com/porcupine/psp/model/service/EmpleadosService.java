/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.service;

import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.DataBaseException;
import com.porcupine.psp.model.dao.DAOFactory;
import com.porcupine.psp.model.entity.Empleados;
import com.porcupine.psp.model.vo.EmpleadosVO;
import com.porcupine.psp.util.Hash;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import model.dao.exceptions.*;

/**
 *
 * @author Zergio
 */
public class EmpleadosService implements IService<EmpleadosVO, Integer> {

    private static EmpleadosService instance;

    public static synchronized EmpleadosService getInstance() {
        if (instance == null) {
            instance = new EmpleadosService();
        }
        return instance;
    }

    @Override
    public void create(EmpleadosVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        Empleados entity = new Empleados();
        entity.setCedulae(vo.getCedulaEmpleado());
        entity.setNombree(vo.getNombreEmpleado());
        entity.setApellidoe(vo.getApellidoEmpleado());
        entity.setCoddocume(vo.getCodigoDocumento());

        entity.setFechareg(new Date());
        entity.setContrasenae((vo.getContraseniaEmpleado()));

        //entity.setDirCedulae(vo.getCedulaDirector());

        DAOFactory.getInstance().getEmpleadosDAO().create(entity);
    }

    @Override
    public EmpleadosVO find(Integer id) throws EntityNotFoundException, InsufficientPermissionsException {

        Empleados empleado = DAOFactory.getInstance().getEmpleadosDAO().find(id);
        if (empleado != null) {
            return empleado.toVO();
        } else {
            return null;
        }
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

    public EmpleadosVO login(EmpleadosVO vo) throws DataBaseException {
        Empleados entity = new Empleados();
        entity.setCoddocume(vo.getCodigoDocumento());
        entity.setContrasenae(((vo.getContraseniaEmpleado())));
        
        Empleados empleado = DAOFactory.getInstance().getEmpleadosDAO().login(entity);
        return empleado != null ? empleado.toVO() : null;
        
    }
}