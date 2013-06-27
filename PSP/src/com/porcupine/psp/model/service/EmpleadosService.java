/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.service;

import com.porcupine.psp.model.vo.EmpPlantaVO;
import com.porcupine.psp.model.dao.exceptions.*;
import com.porcupine.psp.model.dao.DAOFactory;
import com.porcupine.psp.model.entity.*;
import com.porcupine.psp.model.vo.EmpTempVO;
import com.porcupine.psp.model.vo.EmpleadosVO;
import com.porcupine.psp.model.vo.TelefonosVO;
import com.porcupine.psp.util.Hash;
import com.porcupine.psp.util.TipoEmpleado;
import com.porcupine.psp.util.TipoTelefono;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Zergio
 */
public class EmpleadosService implements IService<EmpleadosVO, Integer> {

    private static EmpleadosService instance;

    public static synchronized EmpleadosService getInstance() {
        if (instance == null) {
            instance = new EmpleadosService();
        }
        return instance;
    }

    @Override
    public void create(EmpleadosVO vo) throws NonexistentEntityException, PreexistingEntityException {
        Empleados entity = new Empleados();
        entity.setCedulae(vo.getCedulaEmpleado());
        entity.setNombree(vo.getNombreEmpleado());
        entity.setApellidoe(vo.getApellidoEmpleado());
        entity.setContrasenae((vo.getContraseniaEmpleado()));
        entity.setFechareg(new Date());

        entity.setCoddocume(getPrefix(vo.getRol()) + vo.getCedulaEmpleado().toString());


        //En teoria se esta creando entonces no es necesario
        entity.setBitacoraSegList(null);


//        for (TelefonosVO each : vo.getTelsEmpList()) {
//            TelefonosVO r = (TelefonosVO) DAOFactory.getInstance().getTelefonosDAO().findSpecific(each.getNumeroTelefonoEmpleado(), TipoTelefono.EMPLEADO);
//            if (r == null) {
//                TelsEmp telemp = new TelsEmp();
//                List<Empleados> empllist= new ArrayList<Empleados>();
//                empllist.add(entity);
//                telemp.setNumTelefonoE(each.getNumeroTelefonoEmpleado());
//                telemp.setEmpleadosList(empllist);
//                //TODO Commit
//            } else {
//                TelsEmp telemp = new TelsEmp();
//                List<Empleados> empllist = (List<Empleados>)r.getUsersList();
//                empllist.add(entity);
//                telemp.setNumTelefonoE(r.getNumeroTelefonoEmpleado());
//                telemp.setEmpleadosList(empllist);
//                telemp.setIdTe(r.getIdTelefono());
//                //TODO update
//            }
//        }

        entity.setTelsEmpList(null);

        if (vo.getCedulaDirector() != null) {
            DirGestionHum temp = (DirGestionHum) DAOFactory.getInstance().getEmpleadosDAO().findSpecific(vo.getCedulaDirector(), TipoEmpleado.DIRECTOR_GESTION_HUMANA);
            entity.setDirCedulae(temp);
        }
        try {
            DAOFactory.getInstance().getEmpleadosDAO().create(entity);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(EmpleadosService.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Commit de los telefonos

        if (vo.getRol().equals(TipoEmpleado.TEMPORAL_ESCOLTA) || vo.getRol().equals(TipoEmpleado.TEMPORAL_GUARDA)) {
            EmpTemp tempEntity = new EmpTemp();
            tempEntity.setCedulae(vo.getCedulaEmpleado());
            tempEntity.setEmpleados(entity);
            tempEntity.setTieneContrato(false);
            tempEntity.setTipoTemp(vo.getRol());
            tempEntity.setAsigImplList(new ArrayList<AsigImpl>());
            tempEntity.setComunicadoList(new ArrayList<Comunicado>());
            try {
                DAOFactory.getInstance().getEmpTempDAO().create(tempEntity);
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(EmpleadosService.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            EmpPlanta tempEntity = new EmpPlanta();
            tempEntity.setCedulae(vo.getCedulaEmpleado());
            tempEntity.setEmpleados(entity);
            //TODO implementar sueldo en vista
            tempEntity.setSueldoe(new BigDecimal(200000));
            try {
                DAOFactory.getInstance().getEmpPlantaDAO().create(tempEntity);
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(EmpleadosService.class.getName()).log(Level.SEVERE, null, ex);
            }

            switch (vo.getRol()) {
                case TipoEmpleado.COORDINADOR_CONTRATO:
                    CoordContrato tempEntity1 = new CoordContrato();
                    tempEntity1.setCedulae(entity.getCedulae());
                    DAOFactory.getInstance().getCoordContratoDAO().create(tempEntity1);
                    break;
                case TipoEmpleado.COORDINADOR_TECNICO_TECNOLOGICO:
                    CoordTYT tempEntity2 = new CoordTYT();
                    tempEntity2.setCedulae(entity.getCedulae());
                    DAOFactory.getInstance().getCoordTYTDAO().create(tempEntity2);
                    break;
                case TipoEmpleado.DIRECTOR_COMERCIAL:
                    DirComercial tempEntity3 = new DirComercial();
                    tempEntity3.setCedulae(entity.getCedulae());
                    DAOFactory.getInstance().getDirComercialDAO().create(tempEntity3);
                    break;
                case TipoEmpleado.DIRECTOR_GESTION_HUMANA:
                    DirGestionHum tempEntity4 = new DirGestionHum();
                    tempEntity4.setCedulae(entity.getCedulae());
                    DAOFactory.getInstance().getDirGestionHumDAO().create(tempEntity4);
                    break;
                case TipoEmpleado.DIRECTOR_OPERACIONES:
                    DirOperaciones tempEntity5 = new DirOperaciones();
                    tempEntity5.setCedulae(entity.getCedulae());
                    DAOFactory.getInstance().getDirOperacionesDAO().create(tempEntity5);
                    break;
                case TipoEmpleado.SUBGERENTE:
                    Subgerente tempEntity6 = new Subgerente();
                    tempEntity6.setCedulae(entity.getCedulae());
                    DAOFactory.getInstance().getSubgerenteDAO().create(tempEntity6);
                    break;

            }

        }
    }

    @Override
    public EmpleadosVO find(Integer id) throws EntityNotFoundException {

        Empleados empleado = DAOFactory.getInstance().getEmpleadosDAO().find(id);
        if (empleado != null) {
            return empleado.toVO();
        } else {
            return null;
        }
    }

    @Override
    public void update(EmpleadosVO vo) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<EmpleadosVO> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public EmpleadosVO login(EmpleadosVO vo) throws DataBaseException {
        Empleados entity = new Empleados();
        entity.setCedulae(vo.getCedulaEmpleado());
        entity.setContrasenae(((vo.getContraseniaEmpleado())));

        Empleados empleado = DAOFactory.getInstance().getEmpleadosDAO().login(entity);
        EmpleadosVO temp = new EmpleadosVO();
        if (empleado != null) {
            temp = empleado.toVO();
            System.out.println(temp.getRol() + "Congrats");


            if (temp.getRol() != TipoEmpleado.TEMPORAL) {
                EmpPlantaVO empPlanta = DAOFactory.getInstance().getEmpPlantaDAO().find(temp.getCedulaEmpleado()).toVO();
                temp.setRol(empPlanta.getRol());
            } else {
                EmpTempVO empTemp = DAOFactory.getInstance().getEmpTempDAO().find(temp.getCedulaEmpleado()).toVO();
                temp.setRol(empTemp.getTipoTemp());
            }
        }
        return empleado != null ? temp : null;

    }

    private String getPrefix(String rol) {
        return "T";
    }
}
