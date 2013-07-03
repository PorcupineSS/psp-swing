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
import com.porcupine.psp.model.entity.Comunicado;
import com.porcupine.psp.model.entity.DirOperaciones;
import com.porcupine.psp.model.entity.EmpTemp;
import com.porcupine.psp.model.vo.ComunicadoVO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Feanor
 */
public class ComunicadoService implements IService<ComunicadoVO, Integer>{
    
    private static ComunicadoService instance;
    
    public static synchronized ComunicadoService getInstance() {
        if (instance == null) {
            instance = new ComunicadoService();
        }
        return instance;
    }

    @Override
    public void create(ComunicadoVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        Comunicado entity = new Comunicado();
        
        entity.setContenidoCo(vo.getContenidoCom());
        entity.setIdComunicado(vo.getIdComunicado());
        entity.setFechaCo(vo.getFechaCom());
        entity.setRespuestaCo(vo.getRespuestaCom());
        entity.setTipoCo(vo.getTipoCom());
        entity.setUrgente(vo.getUrgente());
        
        //en este metodo salta la excepcion
        if(vo.getCedulaDirOper() != 0){
            DirOperaciones dirOperaciones = DAOFactory.getInstance().getDirOperacionesDAO().find(vo.getCedulaDirOper());
            entity.setDirCedulae(dirOperaciones);
            dirOperaciones.getComunicadoList().add(entity);        
        }
        
        if(vo.getCedulaEmpTemp() != 0){
            EmpTemp empTemp = DAOFactory.getInstance().getEmpTempDAO().find(vo.getCedulaEmpTemp());
            entity.setCedulae(empTemp);
            empTemp.getComunicadoList().add(entity);
        }
        
        DAOFactory.getInstance().getComunicadoDAO().create(entity);
    }

    @Override
    public ComunicadoVO find(Integer id) throws EntityNotFoundException, InsufficientPermissionsException {
        Comunicado comunicado = DAOFactory.getInstance().getComunicadoDAO().find(id);
        if (comunicado != null) {
            return comunicado.toVO();
        } else {
            return null;
        }
    }

    @Override
    public void update(ComunicadoVO vo) throws NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        Comunicado entity = new Comunicado();
        
        entity.setContenidoCo(vo.getContenidoCom());
        entity.setIdComunicado(vo.getIdComunicado());
        entity.setFechaCo(vo.getFechaCom());
        entity.setRespuestaCo(vo.getRespuestaCom());
        entity.setTipoCo(vo.getTipoCom());
        entity.setUrgente(vo.getUrgente());
        
        if(vo.getCedulaDirOper() != 0){
            DirOperaciones dirOperaciones = DAOFactory.getInstance().getDirOperacionesDAO().find(vo.getCedulaDirOper());
            entity.setDirCedulae(dirOperaciones);
            dirOperaciones.getComunicadoList().set(dirOperaciones.getComunicadoList().get(entity.getIdComunicado()).getIdComunicado(), entity);        
        }
        
        if(vo.getCedulaEmpTemp() != 0){
            EmpTemp empTemp = DAOFactory.getInstance().getEmpTempDAO().find(vo.getCedulaEmpTemp());
            entity.setCedulae(empTemp);
            empTemp.getComunicadoList().set(empTemp.getComunicadoList().get(entity.getIdComunicado()).getIdComunicado(), entity);
        }
        
        DAOFactory.getInstance().getComunicadoDAO().update(entity);
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException, InsufficientPermissionsException {
        Comunicado comunicado = DAOFactory.getInstance().getComunicadoDAO().find(id);
        if (comunicado != null) {
            DAOFactory.getInstance().getComunicadoDAO().delete(id);
        }
    }

    @Override
    public List<ComunicadoVO> getList() {
        List<ComunicadoVO> listaVO = new ArrayList<ComunicadoVO>();
        List<Comunicado> lista = DAOFactory.getInstance().getComunicadoDAO().getList();;
        for (Comunicado comunicado : lista) {
            ComunicadoVO comun = comunicado.toVO();
            listaVO.add(comun);
        }
        return listaVO;
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
