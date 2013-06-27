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
import com.porcupine.psp.model.entity.Proveedor;
import com.porcupine.psp.model.vo.ProveedorVO;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author andres
 */
public class ProveedorService implements IService<ProveedorVO, Integer> {
    
    private static ProveedorService instance;

    public static synchronized ProveedorService getInstance() {
        if (instance == null) {
            instance = new ProveedorService();
        }
        return instance;
    }
    
    @Override
    public void create(ProveedorVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProveedorVO find(Integer id) throws EntityNotFoundException, InsufficientPermissionsException {
        Proveedor proveedor = DAOFactory.getInstance().getProveedorDAO().find(id);
        if (proveedor != null) {
            return proveedor.toVO();
        } else {
            return null;
        }
    }

    @Override
    public void update(ProveedorVO vo) throws NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProveedorVO> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
