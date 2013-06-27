/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import java.util.Date;

/**
 *
 * @author sparrow
 */
public class BitacoraSegVO {

    //No es una variable Opcional
    private Integer idOper;
    //No es una variable Opcional
    private Date fechaOper;
    private String usuOper;
    private String maqOper;
    //No es una variable Opcional
    private String tablaMod;
    //No es una variable Opcional
    private String tipoOper;
    private Integer cedulae;

    public Integer getCedulae() {
        return cedulae;
    }

    public void setCedulae(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public Date getFechaOper() {
        return fechaOper;
    }

    public void setFechaOper(Date fechaOper) {
        this.fechaOper = fechaOper;
    }

    public Integer getIdOper() {
        return idOper;
    }

    public void setIdOper(Integer idOper) {
        this.idOper = idOper;
    }

    public String getMaqOper() {
        return maqOper;
    }

    public void setMaqOper(String maqOper) {
        this.maqOper = maqOper;
    }

    public String getTablaMod() {
        return tablaMod;
    }

    public void setTablaMod(String tablaMod) {
        this.tablaMod = tablaMod;
    }

    public String getTipoOper() {
        return tipoOper;
    }

    public void setTipoOper(String tipoOper) {
        this.tipoOper = tipoOper;
    }

    public String getUsuOper() {
        return usuOper;
    }

    public void setUsuOper(String usuOper) {
        this.usuOper = usuOper;
    }
    
        
    
}
