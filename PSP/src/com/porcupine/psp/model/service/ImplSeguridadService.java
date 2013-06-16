/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.service;

import com.porcupine.psp.model.dao.DAOFactory;
import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.entity.CoordTYT;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.entity.Proveedor;
import com.porcupine.psp.model.vo.ImplSeguridadVO;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import model.dao.exceptions.InsufficientPermissionsException;
import model.dao.exceptions.InvalidAttributeException;
import model.dao.exceptions.PreexistingEntityException;
import model.dao.exceptions.RequiredAttributeException;

/**
 *
 * @author Jeisson Andrés Vergara
 */
public class ImplSeguridadService implements IService<ImplSeguridadVO, Integer> {
    
    private static ImplSeguridadService instance;

    public static synchronized ImplSeguridadService getInstance() {
        if (instance == null) {
            instance = new ImplSeguridadService();
        }
        return instance;
    }

    @Override
    public void create(ImplSeguridadVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {            
        ImplSeguridad entity = new ImplSeguridad();
        entity.setIdImplemento(vo.getIdImplemento());
        entity.setNombreI(vo.getNombreI());
        entity.setPrecioUnitarioI(vo.getPrecioUnitarioI());
        entity.setCantidad(vo.getCantidad());
        entity.setDescripcionI(vo.getDescripcionI());
        entity.setEstadoI(vo.getEstadoI());
        entity.setFechaRegIm(vo.getFechaRegIm());
        
        if (vo.getIdPro() != 0) {
            Proveedor proveedor = DAOFactory.getInstance().getProveedorDAO().find((int) vo.getIdPro());
            entity.setIdPro(proveedor);
            proveedor.getImplSeguridadList().add(entity);
        }
        if (vo.getCedulaCoordTyT() != 0) {
            CoordTYT coordTyT = DAOFactory.getInstance().getCoordTYTDAO().find(vo.getCedulaCoordTyT());
            entity.setCedulae(coordTyT);
            coordTyT.getImplSeguridadList().add(entity);
        } 
        
        DAOFactory.getInstance().getImplSeguridadDAO().create(entity);   
    }

    @Override
    public ImplSeguridadVO find(Integer id) throws EntityNotFoundException, InsufficientPermissionsException {     
        ImplSeguridad implSeguridad = DAOFactory.getInstance().getImplSeguridadDAO().find(id);
        if (implSeguridad != null) {
            return implSeguridad.toVO();
        } else {
            return null;
        }
    }

    @Override
    public void update(ImplSeguridadVO vo) throws NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ImplSeguridadVO> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
