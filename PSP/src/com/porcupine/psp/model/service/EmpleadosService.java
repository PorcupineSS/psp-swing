/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.service;

import com.porcupine.psp.model.vo.EmpPlantaVO;
import com.porcupine.psp.model.dao.exceptions.*;
import com.porcupine.psp.model.dao.DAOFactory;
import com.porcupine.psp.model.entity.*;
import com.porcupine.psp.model.vo.EmpleadosVO;
import com.porcupine.psp.util.Hash;
import com.porcupine.psp.util.TipoEmpleado;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityNotFoundException;

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
    public void create(EmpleadosVO vo) throws NonexistentEntityException {
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

        if (vo.getCedulaDirector() != null) {
            DirGestionHum temp = (DirGestionHum) DAOFactory.getInstance().getEmpleadosDAO().findSpecific(vo.getCedulaDirector(), TipoEmpleado.DIRECTOR_GESTION_HUMANA);
            entity.setDirCedulae(temp);
        }
        try {
            DAOFactory.getInstance().getEmpleadosDAO().create(entity);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(EmpleadosService.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (vo.getRol().equals(TipoEmpleado.TEMPORAL_ESCOLTA) || vo.getRol().equals(TipoEmpleado.TEMPORAL_GUARDA)) {
            EmpTemp tempEntity = new EmpTemp();
            tempEntity.setCedulae(vo.getCedulaEmpleado());
            tempEntity.setEmpleados(entity);
            tempEntity.setTieneContrato(false);
            tempEntity.setTipoTemp(vo.getRol());
            tempEntity.setAsigImplList(new ArrayList<AsigImpl>());
            tempEntity.setComunicadoList(new ArrayList<Comunicado>());
            try {
                DAOFactory.getInstance().getEmpTempDAO().create(tempEntity);
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(EmpleadosService.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            entity.setEmpPlanta(null);
        }
    }

    @Override
    public EmpleadosVO find(Integer id) throws EntityNotFoundException {

        Empleados empleado = DAOFactory.getInstance().getEmpleadosDAO().find(id);
        if (empleado != null) {
            return empleado.toVO();
        } else {
            return null;
        }
    }

    @Override
    public void update(EmpleadosVO vo) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
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
        if (temp.getRol() != TipoEmpleado.TEMPORAL) {
            EmpPlantaVO empPlanta = DAOFactory.getInstance().getEmpPlantaDAO().find(temp.getCedulaEmpleado()).toVO();
            temp.setRol(empPlanta.getRol());
        }

        return empleado != null ? temp : null;

    }

    private String getPrefix(String rol) {
        return "A";
    }
}
