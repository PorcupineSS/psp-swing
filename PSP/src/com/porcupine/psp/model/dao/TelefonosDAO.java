/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.dao;

import com.porcupine.psp.model.entity.TelsCli;
import com.porcupine.psp.model.entity.TelsEmp;
import com.porcupine.psp.model.entity.TelsProv;
import com.porcupine.psp.util.TipoTelefono;
import java.util.Map;
import javax.persistence.*;

/**
 *
 * @author Zergio
 */
public class TelefonosDAO {
    
    private EntityManagerFactory entityManagerFactory;

    TelefonosDAO(String PU, Map propierties) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PU, propierties);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
    
    public Object findSpecific(String telefono, TipoTelefono tipoTelefono) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            if (tipoTelefono == TipoTelefono.CLIENTE) {
                entityManager = getEntityManager();
                Query query = entityManager.createNamedQuery("TelsCli.findByNumTelefonoC", TelsCli.class)
                        .setParameter(1, telefono);
                TelsCli r = (TelsCli) query.getSingleResult();
                return r.toVO();
            } else if (tipoTelefono == TipoTelefono.EMPLEADO) {
                entityManager = getEntityManager();
                Query query = entityManager.createNamedQuery("TelsEmp.findByNumTelefonoE", TelsEmp.class)
                        .setParameter(1, telefono);
                TelsEmp r = (TelsEmp) query.getSingleResult();
                return r.toVO();
            } else if (tipoTelefono == TipoTelefono.PROVEEDOR) {
                entityManager = getEntityManager();
                Query query = entityManager.createNamedQuery("TelsProv.findByNumTelefonoP", TelsProv.class)
                        .setParameter(1, telefono);
                TelsProv r = (TelsProv) query.getSingleResult();
                return r.toVO();
            } 
            return null;


        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("El telefono " + telefono + " no existe.");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
    
}
