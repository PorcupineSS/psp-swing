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
import com.porcupine.psp.model.entity.Cliente;
import com.porcupine.psp.model.entity.Contrato;
import com.porcupine.psp.model.entity.DirComercial;
import com.porcupine.psp.model.entity.TelsCli;
import com.porcupine.psp.model.vo.ClienteVO;
import com.porcupine.psp.model.vo.ContratoVO;
import com.porcupine.psp.model.vo.EmpleadosVO;
import com.porcupine.psp.model.vo.TelefonosVO;
import com.porcupine.psp.util.TipoTelefono;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Johan
 */
public class ClienteService implements IService<ClienteVO, Integer> {

    private static ClienteService instance;

    public static synchronized ClienteService getInstance() {
        if (instance == null) {
            instance = new ClienteService();
        }
        return instance;
    }

    //sin terminar
    @Override
    public void create(ClienteVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        Cliente entity = new Cliente();

        entity.setDireccioncl(vo.getDireccionCliente());
        entity.setFechaRegCl(vo.getFechaRegCliente());
        entity.setIdcl(vo.getIdCliente());
        entity.setNombrecl(vo.getNombreCliente());


        DirComercial director = DAOFactory.getInstance().getDirComercialDAO().find(vo.getCedulaDirector());
        entity.setCedulae(director);


        List<TelsCli> tels = new ArrayList<TelsCli>();


        for (TelefonosVO each : vo.getTelsCliList()) {
            TelsCli emp = (TelsCli) DAOFactory.getInstance().getTelefonosDAO().findSpecific(each.getNumeroTelefonoEmpleado(), TipoTelefono.CLIENTE);
            if (emp != null) {
                tels.add(emp);
            } else {
                emp = new TelsCli();
                emp.setNumTelefonoC(each.getNumeroTelefonoEmpleado());
                DAOFactory.getInstance().getTelefonosDAO().create(emp);
                emp = (TelsCli) DAOFactory.getInstance().getTelefonosDAO().findSpecific(each.getNumeroTelefonoEmpleado(), TipoTelefono.CLIENTE);
                tels.add(emp);
            }

        }

        entity.setTelsCliList(new ArrayList<TelsCli>());
        DAOFactory.getInstance().getClienteDAO().create(entity);
    }

    @Override
    public ClienteVO find(Integer id) throws EntityNotFoundException, InsufficientPermissionsException {
        Cliente cliente = DAOFactory.getInstance().getClienteDAO().find(id);
        if (cliente != null) {
            return cliente.toVO();
        } else {
            return null;
        }
    }

    @Override
    public void update(ClienteVO vo) throws NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException, InsufficientPermissionsException {
        Cliente cliente = DAOFactory.getInstance().getClienteDAO().find(id);
        if (cliente != null) {
            DAOFactory.getInstance().getClienteDAO().delete(id);
        }
    }

    @Override
    public List<ClienteVO> getList() {
        List<ClienteVO> listaVO = new ArrayList<ClienteVO>();
        List<Cliente> lista = DAOFactory.getInstance().getClienteDAO().getList();;
        for (Cliente cliente : lista) {
            ClienteVO client = cliente.toVO();
            listaVO.add(client);
        }
        return listaVO;
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Short findName(String nombreCliente) {
        return DAOFactory.getInstance().getClienteDAO().findName(nombreCliente);
    }
}
