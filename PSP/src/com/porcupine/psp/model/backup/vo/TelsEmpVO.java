/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import java.util.List;

/**
 *
 * @author Zergio
 */
public class TelsEmpVO implements IValueObject {
    
    private Short idTelefono;
    private int numTelefonoE;
    private List<EmpleadosVO> empleadosList;

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

    public int getNumTelefonoE() {
        return numTelefonoE;
    }

    public void setNumTelefonoE(int numTelefonoE) {
        this.numTelefonoE = numTelefonoE;
    }
    
}
