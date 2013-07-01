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
 * @author Feanor
 */
public class AsignacionCVO implements IValueObject, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Short idAsig;
    private Short idContrato;
    private Integer cedulaEmpTemp;
    private Integer cedulaCoordCont;
    private Date fechaAsignacionC;
    private String horarioAsignado;
    
    private List<EmpTempVO> empTempList;

    public Short getIdAsig() {
        return idAsig;
    }

    public void setIdAsig(Short idAsig) {
        this.idAsig = idAsig;
    }

    public Short getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Short idContrato) {
        this.idContrato = idContrato;
    }

    public Integer getCedulaEmpTemp() {
        return cedulaEmpTemp;
    }

    public void setCedulaEmpTemp(Integer cedulaEmpTemp) {
        this.cedulaEmpTemp = cedulaEmpTemp;
    }

    public Integer getCedulaCoordCont() {
        return cedulaCoordCont;
    }

    public void setCedulaCoordCont(Integer cedulaCoordCont) {
        this.cedulaCoordCont = cedulaCoordCont;
    }

    public Date getFechaAsignacionC() {
        return fechaAsignacionC;
    }

    public void setFechaAsignacionC(Date fechaAsignacionC) {
        this.fechaAsignacionC = fechaAsignacionC;
    }

    public String getHorarioAsignado() {
        return horarioAsignado;
    }

    public void setHorarioAsignado(String horarioAsignado) {
        this.horarioAsignado = horarioAsignado;
    }

    public List<EmpTempVO> getEmpTempList() {
        return empTempList;
    }

    public void setEmpTempList(List<EmpTempVO> empTempList) {
        this.empTempList = empTempList;
    }
    
}
