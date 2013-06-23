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
import com.porcupine.psp.model.entity.Contrato;
import com.porcupine.psp.model.entity.DirComercial;
import com.porcupine.psp.model.vo.ContratoVO;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Feanor
 */
public class ContratoService implements IService<ContratoVO, Integer> {
    
    private static ContratoService instance;
    
    public static synchronized ContratoService getInstance() {
        if (instance == null) {
            instance = new ContratoService();
        }
        return instance;
    }

    @Override
    public void create(ContratoVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        Contrato entity = new Contrato();
        
        entity.setCantidadPersonalC(vo.getCantPersonalCont());
        entity.setCelularC(vo.getCelularCont());
        entity.setCostoMensualC(vo.getCostoMensual());
        entity.setFechaInicioC(vo.getFechaInicioCont());
        entity.setFechaRegCon(vo.getFechaRegCont());
        entity.setHorarioC(vo.getHorarioCont());
        // VAN LAS ID'S
        entity.setTelefonoC(vo.getTelefonoCont());
        entity.setTiempoC(vo.getTiempoCont());
        entity.setTipoC(vo.getTipoCont());
        entity.setTipoPersonalC(vo.getTipoPersonalCont());
        entity.setUbicacionC(vo.getUbicacionCont());
        
        if(vo.getCedulaDirComer() != 0){
            DirComercial dirComercial = DAOFactory.getInstance().getDirComercialDAO().find(vo.getCedulaDirComer());
            entity.setCedulae(dirComercial);
            dirComercial.getContratoList().add(entity);
        }
        
        DAOFactory.getInstance().getContratoDAO().create(entity);
    }

    @Override
    public ContratoVO find(Integer id) throws EntityNotFoundException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ContratoVO vo) throws NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ContratoVO> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
