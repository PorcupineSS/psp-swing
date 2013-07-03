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

        List<TelsEmp> telslist = new ArrayList<TelsEmp>();
        Integer count = 1;
        for (TelefonosVO each : vo.getTelsEmpList()) {

            TelsEmp r = (TelsEmp) DAOFactory.getInstance().getTelefonosDAO().findSpecific(each.getNumeroTelefonoEmpleado(), TipoTelefono.EMPLEADO);
            TelsEmp telemp;
            if (r == null) {
                telemp = new TelsEmp();
//                List<Empleados> empllist = new ArrayList<Empleados>();
//                empllist.add(entity);
                telemp.setNumTelefonoE(each.getNumeroTelefonoEmpleado());
                telemp.setIdTe(DAOFactory.getInstance().getTelefonosDAO().getNewID(1));
                DAOFactory.getInstance().getTelefonosDAO().create(telemp);
                telemp = (TelsEmp) DAOFactory.getInstance().getTelefonosDAO().findSpecific(each.getNumeroTelefonoEmpleado(), TipoTelefono.EMPLEADO);
                //count++;
                //TODO Commit

            } else {
                telemp = DAOFactory.getInstance().getTelefonosDAO().find(r.getIdTe());
//                List<Empleados> empllist = telemp.getEmpleadosList();
//
//                empllist.add(entity);
//
//                telemp.setEmpleadosList(empllist);
//
//                DAOFactory.getInstance().getTelefonosDAO().update(telemp);
            }
            telslist.add(telemp);

        }

        entity.setTelsEmpList(telslist);

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
                    tempEntity.setCoordContrato(new CoordContrato(tempEntity.getCedulae()));
                    break;
                case TipoEmpleado.COORDINADOR_TECNICO_TECNOLOGICO:
                    tempEntity.setCoordTYT(new CoordTYT(tempEntity.getCedulae()));
                    break;
                case TipoEmpleado.DIRECTOR_COMERCIAL:
                    tempEntity.setDirComercial(new DirComercial(tempEntity.getCedulae()));
                    break;
                case TipoEmpleado.DIRECTOR_GESTION_HUMANA:
                    tempEntity.setDirGestionHum(new DirGestionHum(tempEntity.getCedulae()));
                    break;
                case TipoEmpleado.DIRECTOR_OPERACIONES:
                    tempEntity.setDirOperaciones(new DirOperaciones(tempEntity.getCedulae()));
                    break;
                case TipoEmpleado.SUBGERENTE:
                    tempEntity.setSubgerente(new Subgerente(tempEntity.getCedulae()));
                    break;

            }

            try {
                DAOFactory.getInstance().getEmpPlantaDAO().update(tempEntity);
            } catch (Exception ex) {
                Logger.getLogger(EmpleadosService.class.getName()).log(Level.SEVERE, null, ex);
            }



        }
    }

    @Override
    public EmpleadosVO find(Integer id) throws EntityNotFoundException {

        Empleados empleado = DAOFactory.getInstance().getEmpleadosDAO().find(id);
        if (empleado != null) {
            EmpleadosVO empleadoVO = empleado.toVO();
            if (empleadoVO.getRol() == TipoEmpleado.PLANTA) {//Cambió
                EmpPlantaVO empleadoPlanta = (DAOFactory.getInstance().getEmpPlantaDAO().find(empleado.getCedulae())).toVO();
                empleadoVO.setSueldoEmpleadoPlanta(Integer.parseInt(empleadoPlanta.getSueldoe().toString()));
            }
            return empleadoVO;
        } else {
            return null;
        }
    }

    @Override
    public void update(EmpleadosVO vo) throws NonexistentEntityException{
        Empleados entity = new Empleados();
        entity.setCedulae(vo.getCedulaEmpleado());
        entity.setNombree(vo.getNombreEmpleado());
        entity.setApellidoe(vo.getApellidoEmpleado());
        entity.setContrasenae((vo.getContraseniaEmpleado()));
        entity.setFechareg(new Date());

        entity.setCoddocume(getPrefix(vo.getRol()) + vo.getCedulaEmpleado().toString());

        List<TelsEmp> telslist = new ArrayList<TelsEmp>();
        Integer count = 1;
        for (TelefonosVO each : vo.getTelsEmpList()) {

            TelsEmp r = (TelsEmp) DAOFactory.getInstance().getTelefonosDAO().findSpecific(each.getNumeroTelefonoEmpleado(), TipoTelefono.EMPLEADO);
            TelsEmp telemp;
            if (r == null) {
                telemp = new TelsEmp();
//                List<Empleados> empllist = new ArrayList<Empleados>();
//                empllist.add(entity);
                telemp.setNumTelefonoE(each.getNumeroTelefonoEmpleado());
                telemp.setIdTe(DAOFactory.getInstance().getTelefonosDAO().getNewID(1));
                try {
                    DAOFactory.getInstance().getTelefonosDAO().create(telemp);
                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(EmpleadosService.class.getName()).log(Level.SEVERE, null, ex);
                }
                telemp = (TelsEmp) DAOFactory.getInstance().getTelefonosDAO().findSpecific(each.getNumeroTelefonoEmpleado(), TipoTelefono.EMPLEADO);
                //count++;
                //TODO Commit

            } else {
                telemp = DAOFactory.getInstance().getTelefonosDAO().find(r.getIdTe());
//                List<Empleados> empllist = telemp.getEmpleadosList();
//
//                empllist.add(entity);
//
//                telemp.setEmpleadosList(empllist);
//
//                DAOFactory.getInstance().getTelefonosDAO().update(telemp);
            }
            telslist.add(telemp);

        }

        entity.setTelsEmpList(telslist);

        if (vo.getCedulaDirector() != null) {
            DirGestionHum temp = (DirGestionHum) DAOFactory.getInstance().getEmpleadosDAO().findSpecific(vo.getCedulaDirector(), TipoEmpleado.DIRECTOR_GESTION_HUMANA);
            entity.setDirCedulae(temp);
        }
        try {
            DAOFactory.getInstance().getEmpleadosDAO().update(entity);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadosService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<EmpleadosVO> getList() {
        List<EmpleadosVO> listaVO = new ArrayList<EmpleadosVO>();
        List<Empleados> lista = DAOFactory.getInstance().getEmpleadosDAO().getList();
        for (Empleados empleados : lista) {
            EmpleadosVO empl = empleados.toVO();
            listaVO.add(empl);
        }
        return listaVO;
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
