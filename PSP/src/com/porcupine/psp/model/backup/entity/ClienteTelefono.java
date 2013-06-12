/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jeisson Andrés Vergara
 */
@Entity
@Table(name = "CLIENTE_TELEFONO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteTelefono.findAll", query = "SELECT c FROM ClienteTelefono c"),
    @NamedQuery(name = "ClienteTelefono.findByIdCliente", query = "SELECT c FROM ClienteTelefono c WHERE c.clienteTelefonoPK.idCliente = :idCliente"),
    @NamedQuery(name = "ClienteTelefono.findByIdTelefonoCliente", query = "SELECT c FROM ClienteTelefono c WHERE c.clienteTelefonoPK.idTelefonoCliente = :idTelefonoCliente")})
public class ClienteTelefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClienteTelefonoPK clienteTelefonoPK;

    public ClienteTelefono() {
    }

    public ClienteTelefono(ClienteTelefonoPK clienteTelefonoPK) {
        this.clienteTelefonoPK = clienteTelefonoPK;
    }

    public ClienteTelefono(BigInteger idCliente, BigInteger idTelefonoCliente) {
        this.clienteTelefonoPK = new ClienteTelefonoPK(idCliente, idTelefonoCliente);
    }

    public ClienteTelefonoPK getClienteTelefonoPK() {
        return clienteTelefonoPK;
    }

    public void setClienteTelefonoPK(ClienteTelefonoPK clienteTelefonoPK) {
        this.clienteTelefonoPK = clienteTelefonoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteTelefonoPK != null ? clienteTelefonoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteTelefono)) {
            return false;
        }
        ClienteTelefono other = (ClienteTelefono) object;
        if ((this.clienteTelefonoPK == null && other.clienteTelefonoPK != null) || (this.clienteTelefonoPK != null && !this.clienteTelefonoPK.equals(other.clienteTelefonoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.ClienteTelefono[ clienteTelefonoPK=" + clienteTelefonoPK + " ]";
    }
    
}
