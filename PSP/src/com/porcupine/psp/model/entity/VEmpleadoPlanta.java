/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "V_EMPLEADO_PLANTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VEmpleadoPlanta.findAll", query = "SELECT v FROM VEmpleadoPlanta v"),
    @NamedQuery(name = "VEmpleadoPlanta.findByCedula", query = "SELECT v FROM VEmpleadoPlanta v WHERE v.cedula = :cedula"),
    @NamedQuery(name = "VEmpleadoPlanta.findBySueldo", query = "SELECT v FROM VEmpleadoPlanta v WHERE v.sueldo = :sueldo")})
public class VEmpleadoPlanta implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private BigDecimal cedula;
    @Basic(optional = false)
    @Column(name = "SUELDO")
    private BigDecimal sueldo;

    public VEmpleadoPlanta() {
    }

    public VEmpleadoPlanta(BigDecimal cedula) {
        this.cedula = cedula;
    }

    public VEmpleadoPlanta(BigDecimal cedula, BigDecimal sueldo) {
        this.cedula = cedula;
        this.sueldo = sueldo;
    }

    public BigDecimal getCedula() {
        return cedula;
    }

    public void setCedula(BigDecimal cedula) {
        this.cedula = cedula;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
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
        if (!(object instanceof VEmpleadoPlanta)) {
            return false;
        }
        VEmpleadoPlanta other = (VEmpleadoPlanta) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VEmpleadoPlanta[ cedula=" + cedula + " ]";
    }
    
}
