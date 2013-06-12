/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jeisson Andrés Vergara
 */
@Entity
@Table(name = "V_EMPLEADO_TEMPORAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VEmpleadoTemporal.findAll", query = "SELECT v FROM VEmpleadoTemporal v"),
    @NamedQuery(name = "VEmpleadoTemporal.findByCedula", query = "SELECT v FROM VEmpleadoTemporal v WHERE v.cedula = :cedula"),
    @NamedQuery(name = "VEmpleadoTemporal.findByIdAsignacionContrato", query = "SELECT v FROM VEmpleadoTemporal v WHERE v.idAsignacionContrato = :idAsignacionContrato"),
    @NamedQuery(name = "VEmpleadoTemporal.findByTieneContrato", query = "SELECT v FROM VEmpleadoTemporal v WHERE v.tieneContrato = :tieneContrato"),
    @NamedQuery(name = "VEmpleadoTemporal.findByTipoTemporal", query = "SELECT v FROM VEmpleadoTemporal v WHERE v.tipoTemporal = :tipoTemporal")})
public class VEmpleadoTemporal implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private BigDecimal cedula;
    @Column(name = "ID_ASIGNACION_CONTRATO")
    private BigInteger idAsignacionContrato;
    @Basic(optional = false)
    @Column(name = "TIENE_CONTRATO")
    private BigInteger tieneContrato;
    @Basic(optional = false)
    @Column(name = "TIPO_TEMPORAL")
    private String tipoTemporal;

    public VEmpleadoTemporal() {
    }

    public VEmpleadoTemporal(BigDecimal cedula) {
        this.cedula = cedula;
    }

    public VEmpleadoTemporal(BigDecimal cedula, BigInteger tieneContrato, String tipoTemporal) {
        this.cedula = cedula;
        this.tieneContrato = tieneContrato;
        this.tipoTemporal = tipoTemporal;
    }

    public BigDecimal getCedula() {
        return cedula;
    }

    public void setCedula(BigDecimal cedula) {
        this.cedula = cedula;
    }

    public BigInteger getIdAsignacionContrato() {
        return idAsignacionContrato;
    }

    public void setIdAsignacionContrato(BigInteger idAsignacionContrato) {
        this.idAsignacionContrato = idAsignacionContrato;
    }

    public BigInteger getTieneContrato() {
        return tieneContrato;
    }

    public void setTieneContrato(BigInteger tieneContrato) {
        this.tieneContrato = tieneContrato;
    }

    public String getTipoTemporal() {
        return tipoTemporal;
    }

    public void setTipoTemporal(String tipoTemporal) {
        this.tipoTemporal = tipoTemporal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VEmpleadoTemporal)) {
            return false;
        }
        VEmpleadoTemporal other = (VEmpleadoTemporal) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VEmpleadoTemporal[ cedula=" + cedula + " ]";
    }
    
}
