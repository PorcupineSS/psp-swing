/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jeisson Andrés Vergara
 */
public class AsigImplVO implements IValueObject, Serializable {
    
    private static final long serialVersionUID = 1L;

    private Short idAsignacionI;
    private short cantidadAsignada;
    private boolean estadoAsignacion;
    private Date fechaAsignacionI;
    private Short idImplemento;
    private Integer cedulaEmpTemp;
    private Integer cedulaCoordTyT;

    public Short getIdAsignacionI() {
        return idAsignacionI;
    }

    public void setIdAsignacionI(Short idAsignacionI) {
        this.idAsignacionI = idAsignacionI;
    }

    public short getCantidadAsignada() {
        return cantidadAsignada;
    }

    public void setCantidadAsignada(short cantidadAsignada) {
        this.cantidadAsignada = cantidadAsignada;
    }

    public boolean isEstadoAsignacion() {
        return estadoAsignacion;
    }

    public void setEstadoAsignacion(boolean estadoAsignacion) {
        this.estadoAsignacion = estadoAsignacion;
    }

    public Date getFechaAsignacionI() {
        return fechaAsignacionI;
    }

    public void setFechaAsignacionI(Date fechaAsignacionI) {
        this.fechaAsignacionI = fechaAsignacionI;
    }

    public Short getIdImplemento() {
        return idImplemento;
    }

    public void setIdImplemento(Short idImplemento) {
        this.idImplemento = idImplemento;
    }

    public Integer getCedulaEmpTemp() {
        return cedulaEmpTemp;
    }

    public void setCedulaEmpTemp(Integer cedulaEmpTemp) {
        this.cedulaEmpTemp = cedulaEmpTemp;
    }

    public Integer getCedulaCoordTyT() {
        return cedulaCoordTyT;
    }

    public void setCedulaCoordTyT(Integer cedulaCoordTyT) {
        this.cedulaCoordTyT = cedulaCoordTyT;
    }   
}
