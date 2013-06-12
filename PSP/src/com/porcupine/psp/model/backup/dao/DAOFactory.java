package com.porcupine.psp.model.dao;

import com.porcupine.psp.controller.MainController;

/**
 *
 * @author javergarav
 */
public class DAOFactory {
    
    
    private String PU = MainController.getSelectedDB();

    private DAOFactory() {
    }

    public VEmpleadoDAO getEmpleadosDAO() {
        return new VEmpleadoDAO(PU);
    }
    
    public ImplSeguridadDAO getImplSeguridadDAO() {
        return new ImplSeguridadDAO(PU);
    }

    private static DAOFactory instance;

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }
}
