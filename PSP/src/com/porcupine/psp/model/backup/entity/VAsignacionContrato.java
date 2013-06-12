/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jeisson Andrés Vergara
 */
@Entity
@Table(name = "V_ASIGNACION_CONTRATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VAsignacionContrato.findAll", query = "SELECT v FROM VAsignacionContrato v"),
    @NamedQuery(name = "VAsignacionContrato.findByIdAsignacionContrato", query = "SELECT v FROM VAsignacionContrato v WHERE v.idAsignacionContrato = :idAsignacionContrato"),
    @NamedQuery(name = "VAsignacionContrato.findByIdContrato", query = "SELECT v FROM VAsignacionContrato v WHERE v.idContrato = :idContrato"),
    @NamedQuery(name = "VAsignacionContrato.findByCedula", query = "SELECT v FROM VAsignacionContrato v WHERE v.cedula = :cedula"),
    @NamedQuery(name = "VAsignacionContrato.findByFechaAsignacionContrato", query = "SELECT v FROM VAsignacionContrato v WHERE v.fechaAsignacionContrato = :fechaAsignacionContrato"),
    @NamedQuery(name = "VAsignacionContrato.findByHorarioAsignadoContrato", query = "SELECT v FROM VAsignacionContrato v WHERE v.horarioAsignadoContrato = :horarioAsignadoContrato")})
public class VAsignacionContrato implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ASIGNACION_CONTRATO")
    private BigDecimal idAsignacionContrato;
    @Column(name = "ID_CONTRATO")
    private BigInteger idContrato;
    @Column(name = "CEDULA")
    private BigInteger cedula;
    @Basic(optional = false)
    @Column(name = "FECHA_ASIGNACION_CONTRATO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacionContrato;
    @Basic(optional = false)
    @Column(name = "HORARIO_ASIGNADO_CONTRATO")
    private String horarioAsignadoContrato;

    public VAsignacionContrato() {
    }

    public VAsignacionContrato(BigDecimal idAsignacionContrato) {
        this.idAsignacionContrato = idAsignacionContrato;
    }

    public VAsignacionContrato(BigDecimal idAsignacionContrato, Date fechaAsignacionContrato, String horarioAsignadoContrato) {
        this.idAsignacionContrato = idAsignacionContrato;
        this.fechaAsignacionContrato = fechaAsignacionContrato;
        this.horarioAsignadoContrato = horarioAsignadoContrato;
    }

    public BigDecimal getIdAsignacionContrato() {
        return idAsignacionContrato;
    }

    public void setIdAsignacionContrato(BigDecimal idAsignacionContrato) {
        this.idAsignacionContrato = idAsignacionContrato;
    }

    public BigInteger getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(BigInteger idContrato) {
        this.idContrato = idContrato;
    }

    public BigInteger getCedula() {
        return cedula;
    }

    public void setCedula(BigInteger cedula) {
        this.cedula = cedula;
    }

    public Date getFechaAsignacionContrato() {
        return fechaAsignacionContrato;
    }

    public void setFechaAsignacionContrato(Date fechaAsignacionContrato) {
        this.fechaAsignacionContrato = fechaAsignacionContrato;
    }

    public String getHorarioAsignadoContrato() {
        return horarioAsignadoContrato;
    }

    public void setHorarioAsignadoContrato(String horarioAsignadoContrato) {
        this.horarioAsignadoContrato = horarioAsignadoContrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacionContrato != null ? idAsignacionContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VAsignacionContrato)) {
            return false;
        }
        VAsignacionContrato other = (VAsignacionContrato) object;
        if ((this.idAsignacionContrato == null && other.idAsignacionContrato != null) || (this.idAsignacionContrato != null && !this.idAsignacionContrato.equals(other.idAsignacionContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VAsignacionContrato[ idAsignacionContrato=" + idAsignacionContrato + " ]";
    }
    
}
