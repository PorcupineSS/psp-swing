/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.dao.exceptions.NonexistentEntityException;
import com.porcupine.psp.model.dao.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityNotFoundException;


/**
 *
 * @author andres
 */
public interface ICrudDAO<E, ID extends Serializable> {
    
    void create(E entity) throws PreexistingEntityException, NonexistentEntityException;

    E find(ID id) throws EntityNotFoundException;

    void update(E entity) throws NonexistentEntityException;

    void delete(ID id) throws NonexistentEntityException;

    List<E> getList();
}
