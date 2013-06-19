/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import java.io.Serializable;

/**
 *
 * @author Feanor
 */
public class EmpTempVO implements IValueObject, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Integer cedulaEmpleado;
    private Short idAsig;
    private Short tieneContrato;
    private String tipoTemp;
    
    //AHI QUE TERMINAR ESTE VO
    public Integer getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(Integer cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public Short getIdAsig() {
        return idAsig;
    }

    public void setIdAsig(Short idAsig) {
        this.idAsig = idAsig;
    }

    public Short getTieneContrato() {
        return tieneContrato;
    }

    public void setTieneContrato(Short tieneContrato) {
        this.tieneContrato = tieneContrato;
    }

    public String getTipoTemp() {
        return tipoTemp;
    }

    public void setTipoTemp(String tipoTemp) {
        this.tipoTemp = tipoTemp;
    }
    
    
}
