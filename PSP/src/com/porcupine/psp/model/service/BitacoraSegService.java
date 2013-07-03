/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.service;

import com.porcupine.psp.model.dao.DAOFactory;
import com.porcupine.psp.model.dao.exceptions.*;
import com.porcupine.psp.model.entity.BitacoraSeg;
import com.porcupine.psp.model.vo.BitacoraSegVO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Zergio
 */
public class BitacoraSegService implements IService<BitacoraSegVO, Integer> {
    
    private static BitacoraSegService instance;

    public static synchronized BitacoraSegService getInstance() {
        if (instance == null) {
            instance = new BitacoraSegService();
        }
        return instance;
    }

   

    @Override
    public void delete(Integer id) throws NonexistentEntityException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<BitacoraSegVO> getList() {
        List<BitacoraSegVO> listaVO = new ArrayList<BitacoraSegVO>();
        List<BitacoraSeg> lista = DAOFactory.getInstance().getBitacoraSegDAO().getList();
        for (BitacoraSeg cliente : lista) {
            BitacoraSegVO client = cliente.toVO();
            listaVO.add(client);
        }
        return listaVO;
    }

    @Override
    public void create(BitacoraSegVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BitacoraSegVO find(Integer id) throws EntityNotFoundException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(BitacoraSegVO vo) throws NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
}
