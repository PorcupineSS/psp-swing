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
    
    private List<EmpleadosVO> empleadosList;
    
    //Tipo de telefono
    private int tipoTelefono;

    public List<EmpleadosVO> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<EmpleadosVO> empleadosList) {
        this.empleadosList = empleadosList;
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

    public int getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(int tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }
    
    
    
    
    
    
}
