/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Feanor
 */
public class ContratoVO implements IValueObject, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Short idContrato;
    private Short idCliente;
    private Integer cedulaDirComer; //Cedula del director comercial
    private String ubicacionCont; //Ubicacion Contrato
    private String telefonoCont;
    private String celularCont; 
    private String tipoCont;
    private Date fechaInicioCont;
    private String tipoPersonalCont;
    private Short cantPersonalCont;
    private BigDecimal costoMensual;
    private String horarioCont;
    private Integer tiempoCont;
    private Date fechaRegCont; //fecha registro contrato
    
    private List<AsignacionCVO> asigContlList;

    public Short getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Short idContrato) {
        this.idContrato = idContrato;
    }

    public Short getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Short idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getCedulaDirComer() {
        return cedulaDirComer;
    }

    public void setCedulaDirComer(Integer cedulaDirComer) {
        this.cedulaDirComer = cedulaDirComer;
    }

    public String getUbicacionCont() {
        return ubicacionCont;
    }

    public void setUbicacionCont(String ubicacionCont) {
        this.ubicacionCont = ubicacionCont;
    }

    public String getTelefonoCont() {
        return telefonoCont;
    }

    public void setTelefonoCont(String telefonoCont) {
        this.telefonoCont = telefonoCont;
    }

    public String getCelularCont() {
        return celularCont;
    }

    public void setCelularCont(String celularCont) {
        this.celularCont = celularCont;
    }

    public String getTipoCont() {
        return tipoCont;
    }

    public void setTipoCont(String tipoCont) {
        this.tipoCont = tipoCont;
    }

    public Date getFechaInicioCont() {
        return fechaInicioCont;
    }

    public void setFechaInicioCont(Date fechaInicioCont) {
        this.fechaInicioCont = fechaInicioCont;
    }

    public String getTipoPersonalCont() {
        return tipoPersonalCont;
    }

    public void setTipoPersonalCont(String tipoPersonalCont) {
        this.tipoPersonalCont = tipoPersonalCont;
    }

    public Short getCantPersonalCont() {
        return cantPersonalCont;
    }

    public void setCantPersonalCont(Short cantPersonalCont) {
        this.cantPersonalCont = cantPersonalCont;
    }

    public BigDecimal getCostoMensual() {
        return costoMensual;
    }

    public void setCostoMensual(BigDecimal costoMensual) {
        this.costoMensual = costoMensual;
    }

    public String getHorarioCont() {
        return horarioCont;
    }

    public void setHorarioCont(String horarioCont) {
        this.horarioCont = horarioCont;
    }

    public Integer getTiempoCont() {
        return tiempoCont;
    }

    public void setTiempoCont(Integer tiempoCont) {
        this.tiempoCont = tiempoCont;
    }

    public Date getFechaRegCont() {
        return fechaRegCont;
    }

    public void setFechaRegCont(Date fechaRegCont) {
        this.fechaRegCont = fechaRegCont;
    }

    public List<AsignacionCVO> getAsigContlList() {
        return asigContlList;
    }

    public void setAsigContlList(List<AsignacionCVO> asigContlList) {
        this.asigContlList = asigContlList;
    }
        
}
