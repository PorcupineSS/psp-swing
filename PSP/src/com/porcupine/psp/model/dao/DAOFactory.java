package com.porcupine.psp.model.dao;

import com.porcupine.psp.controller.MainController;
import com.porcupine.psp.model.entity.EmpPlanta;
import java.util.Map;

/**
 *
 * @author Alexander
 */
public class DAOFactory {
    
    //Debe ser inicializado
    private String PU = MainController.getSelectedDB();
    private Map propierties = MainController.connectionPropierties;

    private DAOFactory() {
    }

    public EmpleadosDAO getEmpleadosDAO() {
        return new EmpleadosDAO(PU, propierties);
    }
    
    public ImplSeguridadDAO getImplSeguridadDAO() {
        return new ImplSeguridadDAO(PU, propierties);
    }
    
    public ProveedorDAO getProveedorDAO() {
        return new ProveedorDAO(PU, propierties);
    }
    
    public CoordTYTDAO getCoordTYTDAO() {
        return new CoordTYTDAO(PU, propierties);
    }
    
    private static DAOFactory instance;

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public EmpPlantaDAO getEmpPlantaDAO() {
        return new EmpPlantaDAO(PU, propierties);
    }
}
