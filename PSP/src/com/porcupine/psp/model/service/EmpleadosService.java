/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.service;

import com.porcupine.psp.model.vo.EmpPlantaVO;
import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.DataBaseException;
import com.porcupine.psp.model.dao.DAOFactory;
import com.porcupine.psp.model.entity.DirGestionHum;
import com.porcupine.psp.model.entity.EmpPlanta;
import com.porcupine.psp.model.entity.Empleados;
import com.porcupine.psp.model.vo.EmpleadosVO;
import com.porcupine.psp.util.Hash;
import com.porcupine.psp.util.TipoEmpleado;
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
        entity.setContrasenae((vo.getContraseniaEmpleado()));
        entity.setFechareg(new Date());
        
        
        entity.setCoddocume(getPrefix(vo.getRol()) + vo.getCodigoDocumento());
        
        
        //TODO find
        entity.setBitacoraSegList(null);
        entity.setTelsEmpList(null);

        DirGestionHum temp = (DirGestionHum) DAOFactory.getInstance().getEmpleadosDAO().findSpecific(vo.getCedulaDirector(),TipoEmpleado.DIRECTOR_GESTION_HUMANA);
        entity.setDirCedulae(temp);

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
        entity.setCedulae(vo.getCedulaEmpleado());
        entity.setContrasenae(((vo.getContraseniaEmpleado())));
        
        Empleados empleado = DAOFactory.getInstance().getEmpleadosDAO().login(entity);
        EmpleadosVO temp = empleado.toVO();
        if (temp.getRol() != TipoEmpleado.TEMPORAL){
            EmpPlantaVO empPlanta = DAOFactory.getInstance().getEmpPlantaDAO().find(temp.getCedulaEmpleado()).toVO();
            temp.setRol(empPlanta.getRol());            
        }
                
        return empleado != null ? temp : null;
        
    }

    private String getPrefix(String rol) {
        return "A";
    }
    
   }
