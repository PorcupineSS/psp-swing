/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.service;

import com.porcupine.psp.model.dao.DAOFactory;
import com.porcupine.psp.model.dao.exceptions.InsufficientPermissionsException;
import com.porcupine.psp.model.dao.exceptions.InvalidAttributeException;
import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.dao.exceptions.RequiredAttributeException;
import com.porcupine.psp.model.entity.AsignacionC;
import com.porcupine.psp.model.entity.Contrato;
import com.porcupine.psp.model.entity.CoordContrato;
import com.porcupine.psp.model.entity.EmpTemp;
import com.porcupine.psp.model.vo.AsignacionCVO;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author TOSHIBA
 */
public class AsignacionCService implements IService<AsignacionCVO, Short>{

    @Override
    public void create(AsignacionCVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        AsignacionC asignacionC = new AsignacionC();
        
        asignacionC.setFechaAsignacionC(vo.getFechaAsignacionC());
        asignacionC.setHorarioAsignado(vo.getHorarioAsignado());
        asignacionC.setIdAsig(vo.getIdAsig());
        
        if (vo.getIdContrato() != null) {
            Contrato contrato = DAOFactory.getInstance().getContratoDAO().find(new Short(vo.getIdContrato()));
            asignacionC.setIdContrato(contrato);
        }
        
        if (vo.getCedulaCoordCont() != null) {
            CoordContrato coordinador = DAOFactory.getInstance().getCoordContratoDAO().find(vo.getCedulaCoordCont());
            asignacionC.setCooCedulae(coordinador);
        }
        
        /*if (vo.getCedulaEmpTemp() != null) {
            EmpTemp empleado = DAOFactory.getInstance().getEmpTempDAO().find(vo.getCedulaEmpTemp());
            asignacionC.setEmpTempCedulae(empleado);
        }*/
        
    }

    @Override
    public AsignacionCVO find(Short id) throws EntityNotFoundException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(AsignacionCVO vo) throws NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Short id) throws NonexistentEntityException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AsignacionCVO> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
