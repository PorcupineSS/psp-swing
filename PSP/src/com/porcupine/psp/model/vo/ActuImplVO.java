/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import java.util.Date;

/**
 *
 * @author Jeisson Andrés Vergara
 */
public class ActuImplVO {
    
    private static final long serialVersionUID = 1L;
    
    private Short idActualizacionI;
    private Date fechaActualizacionI;
    private Short cantidadAgregada;
    private String descripcionActualizacion;
    private Short idImplemento;
    private Integer cedulaCoordTyT;

    public Short getIdActualizacionI() {
        return idActualizacionI;
    }

    public void setIdActualizacionI(Short idActualizacionI) {
        this.idActualizacionI = idActualizacionI;
    }

    public Date getFechaActualizacionI() {
        return fechaActualizacionI;
    }

    public void setFechaActualizacionI(Date fechaActualizacionI) {
        this.fechaActualizacionI = fechaActualizacionI;
    }

    public Short getCantidadAgregada() {
        return cantidadAgregada;
    }

    public void setCantidadAgregada(Short cantidadAgregada) {
        this.cantidadAgregada = cantidadAgregada;
    }

    public String getDescripcionActualizacion() {
        return descripcionActualizacion;
    }

    public void setDescripcionActualizacion(String descripcionActualizacion) {
        this.descripcionActualizacion = descripcionActualizacion;
    }

    public Short getIdImplemento() {
        return idImplemento;
    }

    public void setIdImplemento(Short idImplemento) {
        this.idImplemento = idImplemento;
    }

    public Integer getCedulaCoordTyT() {
        return cedulaCoordTyT;
    }

    public void setCedulaCoordTyT(Integer cedulaCoordTyT) {
        this.cedulaCoordTyT = cedulaCoordTyT;
    }
}
