/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Feanor
 */
public class ComunicadoVO implements IValueObject, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Short idComunicado;
    private Integer cedulaEmpTemp;
    private Integer cedulaDirOper;//DIrector de Operaciones
    private String tipoCom;
    private Date fechaCom;
    private String contenidoCom;
    private boolean urgente;
    private String respuestaCom;

    public Short getIdComunicado() {
        return idComunicado;
    }

    public void setIdComunicado(Short idComunicado) {
        this.idComunicado = idComunicado;
    }

    public Integer getCedulaEmpTemp() {
        return cedulaEmpTemp;
    }

    public void setCedulaEmpTemp(Integer cedulaEmpTemp) {
        this.cedulaEmpTemp = cedulaEmpTemp;
    }

    public Integer getCedulaDirOper() {
        return cedulaDirOper;
    }

    public void setCedulaDirOper(Integer cedulaDirOper) {
        this.cedulaDirOper = cedulaDirOper;
    }

    public String getTipoCom() {
        return tipoCom;
    }

    public void setTipoCom(String tipoCom) {
        this.tipoCom = tipoCom;
    }

    public Date getFechaCom() {
        return fechaCom;
    }

    public void setFechaCom(Date fechaCom) {
        this.fechaCom = fechaCom;
    }

    public String getContenidoCom() {
        return contenidoCom;
    }

    public void setContenidoCom(String contenidoCom) {
        this.contenidoCom = contenidoCom;
    }

    public boolean getUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public String getRespuestaCom() {
        return respuestaCom;
    }

    public void setRespuestaCom(String respuestaCom) {
        this.respuestaCom = respuestaCom;
    }
    
}
