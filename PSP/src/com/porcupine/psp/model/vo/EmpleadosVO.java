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

    //Variables no opcionales
    private Integer cedulaEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String contraseniaEmpleado;
    private String codigoDocumento;
    private Date fechaRegistro;
    //variables opcionales
    private Integer cedulaDirector;
    private Integer sueldoEmpleadoPlanta;
    //Colecciones
    private List<TelefonosVO> telsEmpList;
    private List<BitacoraSegVO> bitacoraSegList;
    //Inexistente en modelo, pero asignable a traves de pruebas y errores
    private String rol;

    public Integer getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(Integer cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public Integer getCedulaDirector() {
        return cedulaDirector;
    }

    public void setCedulaDirector(Integer cedulaDirector) {
        this.cedulaDirector = cedulaDirector;
    }

    public List<BitacoraSegVO> getBitacoraSegList() {
        return bitacoraSegList;
    }

    public void setBitacoraSegList(List<BitacoraSegVO> bitacoraSegList) {
        this.bitacoraSegList = bitacoraSegList;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public void setCedulaDirector(int cedulaDirector) {
        this.cedulaDirector = cedulaDirector;
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

    
    public Integer getSueldoEmpleadoPlanta() {
        return sueldoEmpleadoPlanta;
    }

    public void setSueldoEmpleadoPlanta(Integer sueldoEmpleadoPlanta) {
        this.sueldoEmpleadoPlanta = sueldoEmpleadoPlanta;
    }

    public String toCoolString() {
        return (this.getCedulaEmpleado() + " - " + this.getNombreEmpleado() + " " + this.getApellidoEmpleado());
    }
    
    
}
