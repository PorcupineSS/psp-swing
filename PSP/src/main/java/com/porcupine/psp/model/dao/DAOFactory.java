package com.porcupine.psp.model.dao;

/**
 *
 * @author javergarav
 */
public class DAOFactory {
    
    private String PU = "PSPPU";

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
