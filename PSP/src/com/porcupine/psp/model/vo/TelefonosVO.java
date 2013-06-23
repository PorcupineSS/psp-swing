/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Zergio
 */
public class TelefonosVO implements IValueObject, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Short idTelefono;
    private String numeroTelefonoEmpleado;
    
    
    private List<Object> usersList;
    
    //Tipo de telefono
    private String tipoTelefono;

    public List<Object> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Object> usersList) {
        this.usersList = usersList;
    }

    public Short getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Short idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getNumeroTelefonoEmpleado() {
        return numeroTelefonoEmpleado;
    }

    public void setNumeroTelefonoEmpleado(String numeroTelefonoEmpleado) {
        this.numeroTelefonoEmpleado = numeroTelefonoEmpleado;
    }

    public String getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(String tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }
    
    
    
    
    
    
}
