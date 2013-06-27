package com.porcupine.psp.model.service;

/**
 *
 * @author Zergio
 */
public class ServiceFactory {

    private ServiceFactory() {
    }
    private static ServiceFactory instance;

    public static synchronized ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

  
    public EmpleadosService getEmpleadosService() {
        return EmpleadosService.getInstance();
    }
    
    public ImplSeguridadService getImplSeguridadService() {
        return ImplSeguridadService.getInstance();
    }
    
    public ContratoService getContratoService() {
        return ContratoService.getInstance();
    }
    
    public ComunicadoService getComunicadoService() {
        return ComunicadoService.getInstance();
    }
    
    public ProveedorService getProveedorService() {
        return ProveedorService.getInstance();
    }

}
