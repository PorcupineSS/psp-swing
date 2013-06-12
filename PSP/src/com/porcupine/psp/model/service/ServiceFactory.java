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

    public EmpleadosService getEmpresaService() {
        return EmpleadosService.getInstance();
    }

    
}
