package com.porcupine.psp.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import com.porcupine.psp.model.dao.exceptions.*;


/**
 *
 * @author Alexander
 */
public interface ICrudDAO<E, ID extends Serializable> {
    
    void create(E entity) throws PreexistingEntityException, NonexistentEntityException;

    E find(ID id) throws EntityNotFoundException;

    void update(E entity) throws NonexistentEntityException;

    void delete(ID id) throws NonexistentEntityException;

    List<E> getList();
}
