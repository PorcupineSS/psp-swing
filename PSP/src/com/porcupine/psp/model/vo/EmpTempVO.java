/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import com.porcupine.psp.model.entity.AsigImpl;
import com.porcupine.psp.model.entity.Comunicado;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Feanor
 */
public class EmpTempVO implements IValueObject, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Integer cedulaEmpleado;
    private Short idAsig;
    private Boolean tieneContrato;
    private String tipoTemp;
    private List<Short> comunicadoList;
    private List<Short> asigImplList;

    public List<Short> getAsigImplList() {
        return asigImplList;
    }

    public void setAsigImplList(List<Short> asigImplList) {
        this.asigImplList = asigImplList;
    }

    public List<Short> getComunicadoList() {
        return comunicadoList;
    }

    public void setComunicadoList(List<Short> comunicadoList) {
        this.comunicadoList = comunicadoList;
    }
    
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

    public Boolean getTieneContrato() {
        return tieneContrato;
    }

    public void setTieneContrato(Boolean tieneContrato) {
        this.tieneContrato = tieneContrato;
    }

    public String getTipoTemp() {
        return tipoTemp;
    }

    public void setTipoTemp(String tipoTemp) {
        this.tipoTemp = tipoTemp;
    }
    
    
}
