/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.service;

import com.porcupine.psp.model.dao.DAOFactory;
import com.porcupine.psp.model.dao.exceptions.*;
import com.porcupine.psp.model.entity.CoordTYT;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.entity.Proveedor;
import com.porcupine.psp.model.vo.ImplSeguridadVO;
import com.porcupine.psp.model.vo.ProveedorVO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityNotFoundException;

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
        
        Proveedor proveedor = DAOFactory.getInstance().getProveedorDAO().find(new Integer(vo.getIdPro()));
        entity.setIdPro(proveedor);
        
        CoordTYT coordinadorTyT = DAOFactory.getInstance().getCoordTYTDAO().find(vo.getCedulaCoordTyT());
        entity.setCedulae(coordinadorTyT);

        /*if (vo.getIdPro() != null) {
            Proveedor proveedor = DAOFactory.getInstance().getProveedorDAO().find((int) vo.getIdPro());
            entity.setIdPro(proveedor);
            proveedor.getImplSeguridadList().add(entity);
        }
        if (vo.getCedulaCoordTyT() != 0) {
            CoordTYT coordTyT = DAOFactory.getInstance().getCoordTYTDAO().find(vo.getCedulaCoordTyT());
            entity.setCedulae(coordTyT);
            coordTyT.getImplSeguridadList().add(entity);
        }*/

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
            proveedor.getImplSeguridadList().set(proveedor.getImplSeguridadList().get(entity.getIdImplemento()).getIdImplemento(), entity);
        }
        if (vo.getCedulaCoordTyT() != 0) {
            CoordTYT coordTyT = DAOFactory.getInstance().getCoordTYTDAO().find(vo.getCedulaCoordTyT());
            entity.setCedulae(coordTyT);
            coordTyT.getImplSeguridadList().set(coordTyT.getImplSeguridadList().get(entity.getIdImplemento()).getIdImplemento(), entity);
        }

        DAOFactory.getInstance().getImplSeguridadDAO().update(entity);
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException, InsufficientPermissionsException {
        ImplSeguridad implSeguridad = DAOFactory.getInstance().getImplSeguridadDAO().find(id);
        if (implSeguridad != null) {
            DAOFactory.getInstance().getImplSeguridadDAO().delete(id);
        } 
    }

    @Override
    public List<ImplSeguridadVO> getList() {
        List<ImplSeguridadVO> listaVO = new ArrayList<ImplSeguridadVO>();
        List<ImplSeguridad> lista = DAOFactory.getInstance().getImplSeguridadDAO().getList();;
        for (ImplSeguridad implemento : lista) {
            ImplSeguridadVO impl = implemento.toVO();
            listaVO.add(impl);
        }
        return listaVO;
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<ImplSeguridadVO> findByName(String name) throws EntityNotFoundException {
        //TODO validar permisos
        List<ImplSeguridadVO> list = new ArrayList<>();
        for (ImplSeguridad implemento : DAOFactory.getInstance().getImplSeguridadDAO().findByName(name)) {
            list.add((implemento).toVO());
        }
        Collections.sort(list, getComparatorUsuario());
        return list;
    }
    
    private Comparator getComparatorImplSeguridad(){
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                ImplSeguridadVO i1 = (ImplSeguridadVO) o1;
                ImplSeguridadVO i2 = (ImplSeguridadVO) o2;
                return i1.getIdImplemento().compareTo(i2.getIdImplemento());
            }
        };
    }
}
