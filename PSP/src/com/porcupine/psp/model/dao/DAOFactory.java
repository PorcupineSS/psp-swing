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
    private static String PU = "com.porcupine.psp.pu.database";
    private Map propierties = MainController.getConnectionPropierties();

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

    public EmpTempDAO getEmpTempDAO() {
        return new EmpTempDAO(PU, propierties);
    }

    public DirComercialDAO getDirComercialDAO() {
        return new DirComercialDAO(PU, propierties);
    }

    public ContratoDAO getContratoDAO() {
        return new ContratoDAO(PU, propierties);
    }
    
    public ClienteDAO getClienteDAO(){
        return new ClienteDAO(PU, propierties);
    }
    
    public DirOperacionesDAO getDirOperacionesDAO(){
        return new DirOperacionesDAO(PU, propierties);
    }
    
    public ComunicadoDAO getComunicadoDAO(){
        return new ComunicadoDAO(PU, propierties);
    }
}
