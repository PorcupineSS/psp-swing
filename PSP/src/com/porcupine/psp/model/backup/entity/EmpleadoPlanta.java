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
@Table(name = "EMPLEADO_PLANTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoPlanta.findAll", query = "SELECT e FROM EmpleadoPlanta e"),
    @NamedQuery(name = "EmpleadoPlanta.findByCedula", query = "SELECT e FROM EmpleadoPlanta e WHERE e.cedula = :cedula"),
    @NamedQuery(name = "EmpleadoPlanta.findBySueldo", query = "SELECT e FROM EmpleadoPlanta e WHERE e.sueldo = :sueldo")})
public class EmpleadoPlanta implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private BigDecimal cedula;
    @Basic(optional = false)
    @Column(name = "SUELDO")
    private BigDecimal sueldo;

    public EmpleadoPlanta() {
    }

    public EmpleadoPlanta(BigDecimal cedula) {
        this.cedula = cedula;
    }

    public EmpleadoPlanta(BigDecimal cedula, BigDecimal sueldo) {
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
        if (!(object instanceof EmpleadoPlanta)) {
            return false;
        }
        EmpleadoPlanta other = (EmpleadoPlanta) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.EmpleadoPlanta[ cedula=" + cedula + " ]";
    }
    
}
