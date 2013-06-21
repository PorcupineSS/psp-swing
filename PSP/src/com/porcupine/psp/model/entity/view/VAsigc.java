/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity.view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "V_ASIGC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VAsigc.findAll", query = "SELECT v FROM VAsigc v"),
    @NamedQuery(name = "VAsigc.findByIdContrato", query = "SELECT v FROM VAsigc v WHERE v.idContrato = :idContrato"),
    @NamedQuery(name = "VAsigc.findByCooCedulae", query = "SELECT v FROM VAsigc v WHERE v.cooCedulae = :cooCedulae"),
    @NamedQuery(name = "VAsigc.findByEmpTempCedulae", query = "SELECT v FROM VAsigc v WHERE v.empTempCedulae = :empTempCedulae"),
    @NamedQuery(name = "VAsigc.findByFechaAsignacionC", query = "SELECT v FROM VAsigc v WHERE v.fechaAsignacionC = :fechaAsignacionC"),
    @NamedQuery(name = "VAsigc.findByHorarioAsignado", query = "SELECT v FROM VAsigc v WHERE v.horarioAsignado = :horarioAsignado")})
public class VAsigc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONTRATO")
    private short idContrato;
    @Basic(optional = false)
    @Column(name = "COO_CEDULAE")
    private int cooCedulae;
    @Basic(optional = false)
    @Column(name = "EMP_TEMP_CEDULAE")
    private int empTempCedulae;
    @Basic(optional = false)
    @Column(name = "FECHA_ASIGNACION_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacionC;
    @Basic(optional = false)
    @Column(name = "HORARIO_ASIGNADO")
    private String horarioAsignado;

    public VAsigc() {
    }

    public short getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(short idContrato) {
        this.idContrato = idContrato;
    }

    public int getCooCedulae() {
        return cooCedulae;
    }

    public void setCooCedulae(int cooCedulae) {
        this.cooCedulae = cooCedulae;
    }

    public int getEmpTempCedulae() {
        return empTempCedulae;
    }

    public void setEmpTempCedulae(int empTempCedulae) {
        this.empTempCedulae = empTempCedulae;
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
    
}
