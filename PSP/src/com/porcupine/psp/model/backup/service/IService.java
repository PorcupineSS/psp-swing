/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.service;

import com.porcupine.psp.model.dao.exceptions.InsufficientPermissionsException;
import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import com.porcupine.psp.model.dao.exceptions.RequiredAttributeException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityNotFoundException;


/**
 *
 * @author javergarav
 */
public interface IService<VO, ID extends Serializable> {

    void create(VO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InsufficientPermissionsException;

    VO find(ID id)  throws EntityNotFoundException;

    void update(VO vo) throws NonexistentEntityException;

    void delete(ID id) throws NonexistentEntityException;

    List<VO> getList();
}
