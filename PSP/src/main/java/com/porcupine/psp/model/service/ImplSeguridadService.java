/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.service;

import com.porcupine.psp.model.dao.DAOFactory;
import com.porcupine.psp.model.dao.exceptions.DataBaseException;
import com.porcupine.psp.model.dao.exceptions.InsufficientPermissionsException;
import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.dao.exceptions.RequiredAttributeException;
import com.porcupine.psp.model.entity.Empleados;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.vo.EmpleadosVO;
import com.porcupine.psp.model.vo.ImplSeguridadVO;
import com.porcupine.psp.util.BCrypt;
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
    public void update(EmpleadosVO vo) throws NonexistentEntityException {
        Empleados entity = DAOFactory.getInstance().getEmpleadosDAO().find(vo.getCedulaE());
        entity.setApellidoe(vo.getApellidoE());
        entity.setBitacoraSegList((List) vo.getBitacoraSegList());
        entity.setCedulae(vo.getCedulaE());
        entity.setCoddocume(vo.getCodDocumE());
        entity.setContrasenae(BCrypt.hashpw(vo.getContrasenaE(), BCrypt.gensalt()));
        //entity.setDirCedulae(vo.getDirCedulaE());
        //entity.setEmTemp(vo.getEmpPlanta());
        //entity.setEmpPlanta(vo.getEmpPlanta());
        entity.setFechareg(vo.getFechareg());
        entity.setNombree(vo.getNombreE());
        entity.setTelsEmpList((List) vo.getTelsEmpList());

        DAOFactory.getInstance().getEmpleadosDAO().update(entity);
    }

    @Override
    public void delete(Long cedulae) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<EmpleadosVO> getList() {
        List<EmpleadosVO> list = new ArrayList<EmpleadosVO>();
        for (Empleados empleado : DAOFactory.getInstance().getEmpleadosDAO().getList()) {
            list.add((empleado).toVO());
        }
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                EmpleadosVO p1 = (EmpleadosVO) o1;
                EmpleadosVO p2 = (EmpleadosVO) o2;
                return p1.getCedulaE().compareTo(p2.getCedulaE());
            }
        });
        return list;
    }

    public EmpleadosVO login(EmpleadosVO vo) throws DataBaseException {
        Empleados entity = new Empleados();
        entity.setCedulae(vo.getCedulaE());
        entity.setContrasenae(vo.getContrasenaE());

        Empleados empleado = DAOFactory.getInstance().getEmpleadosDAO().login(entity);
        return empleado != null ? empleado.toVO() : null;

    }

    public boolean validarCampos(ImplSeguridadVO vo) throws RequiredAttributeException {
        if (vo.getApellidoE() == null) {
            throw new RequiredAttributeException("¡El atributo 'Apellido' es requerido!");
        }
        if (vo.getCedulaE() == null) {
            throw new RequiredAttributeException("¡El atributo 'Cédula' es requerido!");
        }
        if (vo.getNombreE() == null) {
            throw new RequiredAttributeException("¡El atributo 'Nombre' es requerido!");
        }
        if (vo.getContrasenaE() == null) {
            throw new RequiredAttributeException("¡El atributo 'Contraseña' es requerido!");
        }
        if (vo.getCodDocumE() == null) {
            throw new RequiredAttributeException("¡El atributo 'Código' es requerido!");
        }
        if (vo.getTelsEmpList()== null) {
            throw new RequiredAttributeException("¡El atributo 'Teléfono' es requerido!");
        }
        return true;
    }
    
    private boolean havePermissions(ImplSeguridadVO vo) {
        return true;
    }
}
