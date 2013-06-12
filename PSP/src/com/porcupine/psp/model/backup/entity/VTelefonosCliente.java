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
@Table(name = "V_TELEFONOS_CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VTelefonosCliente.findAll", query = "SELECT v FROM VTelefonosCliente v"),
    @NamedQuery(name = "VTelefonosCliente.findByIdTelefonoCliente", query = "SELECT v FROM VTelefonosCliente v WHERE v.idTelefonoCliente = :idTelefonoCliente"),
    @NamedQuery(name = "VTelefonosCliente.findByNumTelefonoCliente", query = "SELECT v FROM VTelefonosCliente v WHERE v.numTelefonoCliente = :numTelefonoCliente")})
public class VTelefonosCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TELEFONO_CLIENTE")
    private BigDecimal idTelefonoCliente;
    @Basic(optional = false)
    @Column(name = "NUM_TELEFONO_CLIENTE")
    private BigInteger numTelefonoCliente;

    public VTelefonosCliente() {
    }

    public VTelefonosCliente(BigDecimal idTelefonoCliente) {
        this.idTelefonoCliente = idTelefonoCliente;
    }

    public VTelefonosCliente(BigDecimal idTelefonoCliente, BigInteger numTelefonoCliente) {
        this.idTelefonoCliente = idTelefonoCliente;
        this.numTelefonoCliente = numTelefonoCliente;
    }

    public BigDecimal getIdTelefonoCliente() {
        return idTelefonoCliente;
    }

    public void setIdTelefonoCliente(BigDecimal idTelefonoCliente) {
        this.idTelefonoCliente = idTelefonoCliente;
    }

    public BigInteger getNumTelefonoCliente() {
        return numTelefonoCliente;
    }

    public void setNumTelefonoCliente(BigInteger numTelefonoCliente) {
        this.numTelefonoCliente = numTelefonoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefonoCliente != null ? idTelefonoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VTelefonosCliente)) {
            return false;
        }
        VTelefonosCliente other = (VTelefonosCliente) object;
        if ((this.idTelefonoCliente == null && other.idTelefonoCliente != null) || (this.idTelefonoCliente != null && !this.idTelefonoCliente.equals(other.idTelefonoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VTelefonosCliente[ idTelefonoCliente=" + idTelefonoCliente + " ]";
    }
    
}
