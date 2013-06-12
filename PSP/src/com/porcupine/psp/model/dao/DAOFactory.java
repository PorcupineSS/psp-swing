package com.porcupine.psp.model.dao;

import com.porcupine.psp.controller.MainController;

/**
 *
 * @author Alexander
 */
public class DAOFactory {
    
    //Debe ser inicializado
    private String PU = MainController.getSelectedDB();

    private DAOFactory() {
    }

    public EmpleadosDAO getEmpleadosDAO() {
        return new EmpleadosDAO(PU);
    }

    
    private static DAOFactory instance;

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }
}
