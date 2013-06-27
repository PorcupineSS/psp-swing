/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import java.math.BigDecimal;

/**
 *
 * @author sparrow
 */
public class EmpPlantaVO {

    private Integer cedulae;
    private BigDecimal sueldoe;
    private Integer dirGestionHum;
    private Integer coordContrato;
    private Integer subgerente;
    private Integer dirOperaciones;
    private Integer empleados;
    private Integer coordTYT;
    private Integer dirComercial;
    
    private String rol;

    public Integer getCedulae() {
        return cedulae;
    }

    public void setCedulae(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public Integer getCoordContrato() {
        return coordContrato;
    }

    public void setCoordContrato(Integer coordContrato) {
        this.coordContrato = coordContrato;
    }

    public Integer getCoordTYT() {
        return coordTYT;
    }

    public void setCoordTYT(Integer coordTYT) {
        this.coordTYT = coordTYT;
    }

    public Integer getDirComercial() {
        return dirComercial;
    }

    public void setDirComercial(Integer dirComercial) {
        this.dirComercial = dirComercial;
    }

    public Integer getDirGestionHum() {
        return dirGestionHum;
    }

    public void setDirGestionHum(Integer dirGestionHum) {
        this.dirGestionHum = dirGestionHum;
    }

    public Integer getDirOperaciones() {
        return dirOperaciones;
    }

    public void setDirOperaciones(Integer dirOperaciones) {
        this.dirOperaciones = dirOperaciones;
    }

    public Integer getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Integer empleados) {
        this.empleados = empleados;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getSubgerente() {
        return subgerente;
    }

    public void setSubgerente(Integer subgerente) {
        this.subgerente = subgerente;
    }

    public BigDecimal getSueldoe() {
        return sueldoe;
    }

    public void setSueldoe(BigDecimal sueldoe) {
        this.sueldoe = sueldoe;
    }
    
    
    
    
}
