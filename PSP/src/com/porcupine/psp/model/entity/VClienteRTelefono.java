/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
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
@Table(name = "V_CLIENTE_R_TELEFONO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VClienteRTelefono.findAll", query = "SELECT v FROM VClienteRTelefono v"),
    @NamedQuery(name = "VClienteRTelefono.findByIdCliente", query = "SELECT v FROM VClienteRTelefono v WHERE v.idCliente = :idCliente"),
    @NamedQuery(name = "VClienteRTelefono.findByIdTelefonoCliente", query = "SELECT v FROM VClienteRTelefono v WHERE v.idTelefonoCliente = :idTelefonoCliente")})
public class VClienteRTelefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TELEFONO_CLIENTE")
    private BigInteger idTelefonoCliente;

    public VClienteRTelefono() {
    }

    public VClienteRTelefono(BigInteger idTelefonoCliente) {
        this.idTelefonoCliente = idTelefonoCliente;
    }

    public BigInteger getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigInteger idCliente) {
        this.idCliente = idCliente;
    }

    public BigInteger getIdTelefonoCliente() {
        return idTelefonoCliente;
    }

    public void setIdTelefonoCliente(BigInteger idTelefonoCliente) {
        this.idTelefonoCliente = idTelefonoCliente;
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
        if (!(object instanceof VClienteRTelefono)) {
            return false;
        }
        VClienteRTelefono other = (VClienteRTelefono) object;
        if ((this.idTelefonoCliente == null && other.idTelefonoCliente != null) || (this.idTelefonoCliente != null && !this.idTelefonoCliente.equals(other.idTelefonoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VClienteRTelefono[ idTelefonoCliente=" + idTelefonoCliente + " ]";
    }
    
}
