/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Zergio
 */
public class EmpleadosVO implements IValueObject, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    Integer cedulaEmpleado;
    Integer cedulaDirector;
    String nombreEmpleado;
    String apellidoEmpleado;
    String contraseniaEmpleado;
    String codigoDocumento;
    Date fechaRegistro;
    
    //Inexistente en modelo, pero averiguable
    String rol;
    
    private List<TelefonosVO> telsEmpList;

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public int getCedulaDirector() {
        return cedulaDirector;
    }

    public void setCedulaDirector(int cedulaDirector) {
        this.cedulaDirector = cedulaDirector;
    }

    public int getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(int cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    public void setCodigoDocumento(String codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public String getContraseniaEmpleado() {
        return contraseniaEmpleado;
    }

    public void setContraseniaEmpleado(String contraseniaEmpleado) {
        this.contraseniaEmpleado = contraseniaEmpleado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<TelefonosVO> getTelsEmpList() {
        return telsEmpList;
    }

    public void setTelsEmpList(List<TelefonosVO> telsEmpList) {
        this.telsEmpList = telsEmpList;
    }
    
    
    
}
