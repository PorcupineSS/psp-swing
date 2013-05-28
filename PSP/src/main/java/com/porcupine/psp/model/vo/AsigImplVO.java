/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import java.util.Date;

/**
 *
 * @author Zergio
 */
public class AsigImplVO {

    private Short idAsignacionI;
    private short cantidadAsignada;
    private boolean estadoAsignacion;
    private Date fechaAsignacionI;
    private int idImplemento;
    private int cedulaETemp;
    private Short cooCedula;

    /**
     * @return the idAsignacionI
     */
    public Short getIdAsignacionI() {
        return idAsignacionI;
    }

    /**
     * @param idAsignacionI the idAsignacionI to set
     */
    public void setIdAsignacionI(Short idAsignacionI) {
        this.idAsignacionI = idAsignacionI;
    }

    /**
     * @return the cantidadAsignada
     */
    public short getCantidadAsignada() {
        return cantidadAsignada;
    }

    /**
     * @param cantidadAsignada the cantidadAsignada to set
     */
    public void setCantidadAsignada(short cantidadAsignada) {
        this.cantidadAsignada = cantidadAsignada;
    }

    /**
     * @return the estadoAsignacion
     */
    public boolean isEstadoAsignacion() {
        return estadoAsignacion;
    }

    /**
     * @param estadoAsignacion the estadoAsignacion to set
     */
    public void setEstadoAsignacion(boolean estadoAsignacion) {
        this.estadoAsignacion = estadoAsignacion;
    }

    /**
     * @return the fechaAsignacionI
     */
    public Date getFechaAsignacionI() {
        return fechaAsignacionI;
    }

    /**
     * @param fechaAsignacionI the fechaAsignacionI to set
     */
    public void setFechaAsignacionI(Date fechaAsignacionI) {
        this.fechaAsignacionI = fechaAsignacionI;
    }

    /**
     * @return the idImplemento
     */
    public int getIdImplemento() {
        return idImplemento;
    }

    /**
     * @param idImplemento the idImplemento to set
     */
    public void setIdImplemento(int idImplemento) {
        this.idImplemento = idImplemento;
    }

    /**
     * @return the cedulaETemp
     */
    public int getCedulaETemp() {
        return cedulaETemp;
    }

    /**
     * @param cedulaETemp the cedulaETemp to set
     */
    public void setCedulaETemp(int cedulaETemp) {
        this.cedulaETemp = cedulaETemp;
    }

    /**
     * @return the cooCedula
     */
    public Short getCooCedula() {
        return cooCedula;
    }

    /**
     * @param cooCedula the cooCedula to set
     */
    public void setCooCedula(Short cooCedula) {
        this.cooCedula = cooCedula;
    }
    
    
}
