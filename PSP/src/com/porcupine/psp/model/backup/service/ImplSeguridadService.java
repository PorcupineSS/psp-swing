/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.service;

import com.porcupine.psp.model.dao.DAOFactory;
import com.porcupine.psp.model.dao.exceptions.InsufficientPermissionsException;
import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.dao.exceptions.RequiredAttributeException;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.vo.ImplSeguridadVO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author javergarav
 */
public class ImplSeguridadService implements IService<ImplSeguridadVO, Long> {
    
    private static ImplSeguridadService instance;

    private ImplSeguridadService() {
    }

    public static synchronized ImplSeguridadService getInstance() {
        if (instance == null) {
            instance = new ImplSeguridadService();
        }
        return instance;
    }

    @Override
    public void create(ImplSeguridadVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InsufficientPermissionsException {
        if (validarCampos(vo)) {
            if (havePermissions(vo)) {
                ImplSeguridad entity = new ImplSeguridad ();
                entity.setIdImplemento(vo.getIdImplemento());
                entity.setNombreI(vo.getNombreI());
                entity.setEstadoI(vo.getEstadoI());
                entity.setPrecioUnitarioI(vo.getPrecioUnitarioI());
                entity.setDescripcionI(vo.getDescripcionI());
                entity.setCantidad(vo.getCantidadI());
                //entity.setIdPro(vo.getIdPro());
                entity.setFechaRegIm(vo.getFechaRegI());
                entity.setActuImplList((List) vo.getActuImplList());
                entity.setAsigImplList((List) vo.getAsigImplList());
                

                DAOFactory.getInstance().getImplSeguridadDAO().create(entity);
            } else {
                throw new InsufficientPermissionsException("¡El usuario no posee los permisos suficientes para realizar esta operación!");
            }
        }
    }

    @Override
    public ImplSeguridadVO find(Long id) throws EntityNotFoundException {
        ImplSeguridad implemento = DAOFactory.getInstance().getImplSeguridadDAO().find(id);
        if (implemento != null) {
            return implemento.toVO();
        } else {
            return null;
        }
    }

    @Override
    public void update(ImplSeguridadVO vo) throws NonexistentEntityException {
        ImplSeguridad entity = DAOFactory.getInstance().getImplSeguridadDAO().find(vo.getIdImplemento().longValue());
        entity.setIdImplemento(vo.getIdImplemento());
        entity.setNombreI(vo.getNombreI());
        entity.setCantidad(vo.getCantidadI());
        entity.setDescripcionI(vo.getDescripcionI());
        entity.setEstadoI(vo.getEstadoI());
        entity.setFechaRegIm(vo.getFechaRegI());
        entity.setPrecioUnitarioI(vo.getPrecioUnitarioI());
        entity.setActuImplList((List) vo.getActuImplList());
        entity.setAsigImplList((List) vo.getAsigImplList());

        DAOFactory.getInstance().getImplSeguridadDAO().update(entity);
    }

    @Override
    public void delete(Long cedulae) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ImplSeguridadVO> getList() {
        List<ImplSeguridadVO> list = new ArrayList<ImplSeguridadVO>();
        for (ImplSeguridad implemento : DAOFactory.getInstance().getImplSeguridadDAO().getList()) {
            list.add((implemento).toVO());
        }
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                ImplSeguridadVO p1 = (ImplSeguridadVO) o1;
                ImplSeguridadVO p2 = (ImplSeguridadVO) o2;
                return p1.getIdImplemento().compareTo(p2.getIdImplemento());
            }
        });
        return list;
    }

    public boolean validarCampos(ImplSeguridadVO vo) throws RequiredAttributeException {
        if (vo.getIdImplemento() == null) {
            throw new RequiredAttributeException("¡El atributo 'id' es requerido!");
        }
        if (vo.getNombreI() == null) {
            throw new RequiredAttributeException("¡El atributo 'Nombre' es requerido!");
        }
        if (vo.getDescripcionI() == null) {
            throw new RequiredAttributeException("¡El atributo 'Descripción' es requerido!");
        }
        if (vo.getEstadoI() == null) {
            throw new RequiredAttributeException("¡El atributo 'Estado' es requerido!");
        }
        if (vo.getFechaRegI() == null) {
            throw new RequiredAttributeException("¡El atributo 'Fecha de registro' es requerido!");
        }
        if (vo.getPrecioUnitarioI() == null) {
            throw new RequiredAttributeException("¡El atributo 'Precio unitario' es requerido!");
        }
        
        return true;
    }
    
    private boolean havePermissions(ImplSeguridadVO vo) {
        return true;
    }
}
