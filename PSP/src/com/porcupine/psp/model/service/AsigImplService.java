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
import com.porcupine.psp.model.entity.CoordTYT;
import com.porcupine.psp.model.entity.EmpTemp;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.vo.AsigImplVO;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author User
 */
public class AsigImplService implements IService<AsigImplVO, Short> {

    @Override
    public void create(AsigImplVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        AsigImpl asignacion = new AsigImpl();
        asignacion.setCantidadAsignada(vo.getCantidadAsignada());
        asignacion.setEstadoAsignacion(vo.isEstadoAsignacion());
        asignacion.setFechaAsignacionI(vo.getFechaAsignacionI());
        asignacion.setIdAsignacionI(vo.getIdAsignacionI());

        if (vo.getCedulaCoordTyT() != null) {
            CoordTYT coordinador = DAOFactory.getInstance().getCoordTYTDAO().find(vo.getCedulaCoordTyT());
            asignacion.setCooCedulae(coordinador);
        }

        if (vo.getCedulaEmpTemp() != null) {
            EmpTemp empleado = DAOFactory.getInstance().getEmpTempDAO().find(vo.getCedulaEmpTemp());
            asignacion.setCedulae(empleado);
        }
        if (vo.getIdImplemento() != null) {
            ImplSeguridad implemento = DAOFactory.getInstance().getImplSeguridadDAO().find((int) vo.getIdImplemento());
            asignacion.setIdImplemento(implemento);
        }
    }

    @Override
    public AsigImplVO find(Short id) throws EntityNotFoundException, InsufficientPermissionsException {
        AsigImpl asignacion = DAOFactory.getInstance().getAsigImplDAO().find(id);
        if (asignacion != null) {
            return asignacion.toVO();
        } else {
            return null;
        }
    }

    @Override
    public void update(AsigImplVO vo) throws NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        AsigImpl asignacion = new AsigImpl();
        asignacion.setCantidadAsignada(vo.getCantidadAsignada());
        asignacion.setEstadoAsignacion(vo.isEstadoAsignacion());
        asignacion.setFechaAsignacionI(vo.getFechaAsignacionI());
        asignacion.setIdAsignacionI(vo.getIdAsignacionI());

        if (vo.getCedulaCoordTyT() != null) {
            CoordTYT coordinador = DAOFactory.getInstance().getCoordTYTDAO().find(vo.getCedulaCoordTyT());
            asignacion.setCooCedulae(coordinador);
        }

        if (vo.getCedulaEmpTemp() != null) {
            EmpTemp empleado = DAOFactory.getInstance().getEmpTempDAO().find(vo.getCedulaEmpTemp());
            asignacion.setCedulae(empleado);
        }
        if (vo.getIdImplemento() != null) {
            ImplSeguridad implemento = DAOFactory.getInstance().getImplSeguridadDAO().find((int) vo.getIdImplemento());
            asignacion.setIdImplemento(implemento);
        }
        DAOFactory.getInstance().getAsigImplDAO().update(asignacion);
    }

    @Override
    public void delete(Short id) throws NonexistentEntityException, InsufficientPermissionsException {
        AsigImpl asignacion = DAOFactory.getInstance().getAsigImplDAO().find(id);
        if (asignacion != null) {
            DAOFactory.getInstance().getAsigImplDAO().delete(id);
        }
    }

    @Override
    public List<AsigImplVO> getList() {
        List<AsigImplVO> listaVO = new ArrayList<AsigImplVO>();
        List<AsigImpl> ListaAsignacion = DAOFactory.getInstance().getAsigImplDAO().getList();
        for (AsigImpl implemento : ListaAsignacion) {
            listaVO.add(implemento.toVO());
        }
        return listaVO;
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        ;
    }
}
