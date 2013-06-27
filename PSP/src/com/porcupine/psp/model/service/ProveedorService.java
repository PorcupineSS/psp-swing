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
import com.porcupine.psp.model.entity.view.VProv;
import com.porcupine.psp.model.vo.ProveedorVO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author andres
 */
public class ProveedorService implements IService<ProveedorVO, Short> {
    
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
    public ProveedorVO find(Short id) throws EntityNotFoundException, InsufficientPermissionsException {
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
    public void delete(Short id) throws NonexistentEntityException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProveedorVO> getList() {
        List<ProveedorVO> listaVO = new ArrayList<ProveedorVO>();
        List<Proveedor> lista = DAOFactory.getInstance().getProveedorDAO().getList();
        for (Proveedor proveedor : lista) {
            ProveedorVO proo = proveedor.toVO();
            listaVO.add(proo);
        }
        return listaVO;
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<ProveedorVO> findByName(String name) throws EntityNotFoundException {
        //TODO validar permisos
        List<ProveedorVO> list = new ArrayList<>();
        for (Proveedor proveedor : DAOFactory.getInstance().getProveedorDAO().findByName(name)) {
            list.add((proveedor).toVO());
        }
        Collections.sort(list, getComparatorProveedor());
        return list;
    }
    
    public Short findName(String name) {
        return DAOFactory.getInstance().getProveedorDAO().findName(name);
    }
    
    private Comparator getComparatorProveedor(){
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                ProveedorVO p1 = (ProveedorVO) o1;
                ProveedorVO p2 = (ProveedorVO) o2;
                return p1.getIdPro().compareTo(p2.getIdPro());
            }
        };
    }
    
}
