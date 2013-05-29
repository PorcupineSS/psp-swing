package com.porcupine.psp.model.dao;

/**
 *
 * @author javergarav
 */
public class DAOFactory {
    
    //temporalmente, solo un servidor
    private String PU = "com.porcupine.psp.pu.sqlserver";

    private DAOFactory() {
    }

    public EmpleadosDAO getEmpleadosDAO() {
        return new EmpleadosDAO(PU);
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
