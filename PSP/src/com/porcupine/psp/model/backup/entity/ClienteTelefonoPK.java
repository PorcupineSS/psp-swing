/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jeisson Andrés Vergara
 */
@Embeddable
public class ClienteTelefonoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;
    @Basic(optional = false)
    @Column(name = "ID_TELEFONO_CLIENTE")
    private BigInteger idTelefonoCliente;

    public ClienteTelefonoPK() {
    }

    public ClienteTelefonoPK(BigInteger idCliente, BigInteger idTelefonoCliente) {
        this.idCliente = idCliente;
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
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        hash += (idTelefonoCliente != null ? idTelefonoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteTelefonoPK)) {
            return false;
        }
        ClienteTelefonoPK other = (ClienteTelefonoPK) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        if ((this.idTelefonoCliente == null && other.idTelefonoCliente != null) || (this.idTelefonoCliente != null && !this.idTelefonoCliente.equals(other.idTelefonoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.ClienteTelefonoPK[ idCliente=" + idCliente + ", idTelefonoCliente=" + idTelefonoCliente + " ]";
    }
    
}
