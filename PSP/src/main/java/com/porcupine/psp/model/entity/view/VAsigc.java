/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity.view;

import java.io.Serializable;
import java.math.BigInteger;
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
    @NamedQuery(name = "VAsigc.findByCedulae", query = "SELECT v FROM VAsigc v WHERE v.cedulae = :cedulae"),
    @NamedQuery(name = "VAsigc.findByCooCedulae", query = "SELECT v FROM VAsigc v WHERE v.cooCedulae = :cooCedulae"),
    @NamedQuery(name = "VAsigc.findByFechaAsignacionC", query = "SELECT v FROM VAsigc v WHERE v.fechaAsignacionC = :fechaAsignacionC"),
    @NamedQuery(name = "VAsigc.findByHorarioAsignado", query = "SELECT v FROM VAsigc v WHERE v.horarioAsignado = :horarioAsignado")})
public class VAsigc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ID_CONTRATO")
    private Short idContrato;
    @Column(name = "CEDULAE")
    private BigInteger cedulae;
    @Column(name = "COO_CEDULAE")
    private BigInteger cooCedulae;
    @Basic(optional = false)
    @Column(name = "FECHA_ASIGNACION_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacionC;
    @Basic(optional = false)
    @Column(name = "HORARIO_ASIGNADO")
    private String horarioAsignado;

    public VAsigc() {
    }

    public Short getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Short idContrato) {
        this.idContrato = idContrato;
    }

    public BigInteger getCedulae() {
        return cedulae;
    }

    public void setCedulae(BigInteger cedulae) {
        this.cedulae = cedulae;
    }

    public BigInteger getCooCedulae() {
        return cooCedulae;
    }

    public void setCooCedulae(BigInteger cooCedulae) {
        this.cooCedulae = cooCedulae;
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
