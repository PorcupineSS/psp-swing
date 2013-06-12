package com.porcupine.psp.model.dao;

/**
 *
 * @author Alexander
 */
public class DAOFactory {
    
    //Debe ser inicializado
    private String PU;

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
