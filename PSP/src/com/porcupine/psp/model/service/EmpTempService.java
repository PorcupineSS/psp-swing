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
import com.porcupine.psp.model.entity.AsigImpl;
import com.porcupine.psp.model.entity.AsignacionC;
import com.porcupine.psp.model.entity.EmpTemp;
import com.porcupine.psp.model.vo.EmpTempVO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Jeisson Andrés Vergara Vargas
 */
public class EmpTempService implements IService<EmpTempVO, Integer> {
    
    private static EmpTempService instance;

    public static synchronized EmpTempService getInstance() {
        if (instance == null) {
            instance = new EmpTempService();
        }
        return instance;
    }
    
    @Override
    public void create(EmpTempVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        EmpTemp entity = new EmpTemp();
        entity.setCedulae(vo.getCedulaEmpleado());
        //AsignacionC asignacionC = DAOFactory.getInstance().getAsignacionCDAO.find(vo.getIdAsig());
        //entity.setIdAsig(asignacionC);
        entity.setTieneContrato(vo.getTieneContrato());
        entity.setTipoTemp(vo.getTipoTemp());
        
        DAOFactory.getInstance().getEmpTempDAO().create(entity);  
    }

    @Override
    public EmpTempVO find(Integer id) throws EntityNotFoundException, InsufficientPermissionsException {
        EmpTemp empTemp = DAOFactory.getInstance().getEmpTempDAO().find(id);
        if (empTemp != null) {
            return empTemp.toVO();
        } else {
            return null;
        }
    }

    @Override
    public void update(EmpTempVO vo) throws NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmpTempVO> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
