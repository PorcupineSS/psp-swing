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
@Table(name = "V_TELEFONOS_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VTelefonosEmpleado.findAll", query = "SELECT v FROM VTelefonosEmpleado v"),
    @NamedQuery(name = "VTelefonosEmpleado.findByIdTelefonoEmpleado", query = "SELECT v FROM VTelefonosEmpleado v WHERE v.idTelefonoEmpleado = :idTelefonoEmpleado"),
    @NamedQuery(name = "VTelefonosEmpleado.findByNumeroTelefonoEmpleado", query = "SELECT v FROM VTelefonosEmpleado v WHERE v.numeroTelefonoEmpleado = :numeroTelefonoEmpleado")})
public class VTelefonosEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TELEFONO_EMPLEADO")
    private BigDecimal idTelefonoEmpleado;
    @Basic(optional = false)
    @Column(name = "NUMERO_TELEFONO_EMPLEADO")
    private BigInteger numeroTelefonoEmpleado;

    public VTelefonosEmpleado() {
    }

    public VTelefonosEmpleado(BigDecimal idTelefonoEmpleado) {
        this.idTelefonoEmpleado = idTelefonoEmpleado;
    }

    public VTelefonosEmpleado(BigDecimal idTelefonoEmpleado, BigInteger numeroTelefonoEmpleado) {
        this.idTelefonoEmpleado = idTelefonoEmpleado;
        this.numeroTelefonoEmpleado = numeroTelefonoEmpleado;
    }

    public BigDecimal getIdTelefonoEmpleado() {
        return idTelefonoEmpleado;
    }

    public void setIdTelefonoEmpleado(BigDecimal idTelefonoEmpleado) {
        this.idTelefonoEmpleado = idTelefonoEmpleado;
    }

    public BigInteger getNumeroTelefonoEmpleado() {
        return numeroTelefonoEmpleado;
    }

    public void setNumeroTelefonoEmpleado(BigInteger numeroTelefonoEmpleado) {
        this.numeroTelefonoEmpleado = numeroTelefonoEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefonoEmpleado != null ? idTelefonoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VTelefonosEmpleado)) {
            return false;
        }
        VTelefonosEmpleado other = (VTelefonosEmpleado) object;
        if ((this.idTelefonoEmpleado == null && other.idTelefonoEmpleado != null) || (this.idTelefonoEmpleado != null && !this.idTelefonoEmpleado.equals(other.idTelefonoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VTelefonosEmpleado[ idTelefonoEmpleado=" + idTelefonoEmpleado + " ]";
    }
    
}
