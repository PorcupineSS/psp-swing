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
@Table(name = "TELEFONOS_PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefonosProveedor.findAll", query = "SELECT t FROM TelefonosProveedor t"),
    @NamedQuery(name = "TelefonosProveedor.findByIdTelefonoProveedor", query = "SELECT t FROM TelefonosProveedor t WHERE t.idTelefonoProveedor = :idTelefonoProveedor"),
    @NamedQuery(name = "TelefonosProveedor.findByIdProveedor", query = "SELECT t FROM TelefonosProveedor t WHERE t.idProveedor = :idProveedor"),
    @NamedQuery(name = "TelefonosProveedor.findByNumeroTelefonoProveedor", query = "SELECT t FROM TelefonosProveedor t WHERE t.numeroTelefonoProveedor = :numeroTelefonoProveedor")})
public class TelefonosProveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TELEFONO_PROVEEDOR")
    private BigDecimal idTelefonoProveedor;
    @Column(name = "ID_PROVEEDOR")
    private BigInteger idProveedor;
    @Basic(optional = false)
    @Column(name = "NUMERO_TELEFONO_PROVEEDOR")
    private BigInteger numeroTelefonoProveedor;

    public TelefonosProveedor() {
    }

    public TelefonosProveedor(BigDecimal idTelefonoProveedor) {
        this.idTelefonoProveedor = idTelefonoProveedor;
    }

    public TelefonosProveedor(BigDecimal idTelefonoProveedor, BigInteger numeroTelefonoProveedor) {
        this.idTelefonoProveedor = idTelefonoProveedor;
        this.numeroTelefonoProveedor = numeroTelefonoProveedor;
    }

    public BigDecimal getIdTelefonoProveedor() {
        return idTelefonoProveedor;
    }

    public void setIdTelefonoProveedor(BigDecimal idTelefonoProveedor) {
        this.idTelefonoProveedor = idTelefonoProveedor;
    }

    public BigInteger getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(BigInteger idProveedor) {
        this.idProveedor = idProveedor;
    }

    public BigInteger getNumeroTelefonoProveedor() {
        return numeroTelefonoProveedor;
    }

    public void setNumeroTelefonoProveedor(BigInteger numeroTelefonoProveedor) {
        this.numeroTelefonoProveedor = numeroTelefonoProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefonoProveedor != null ? idTelefonoProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonosProveedor)) {
            return false;
        }
        TelefonosProveedor other = (TelefonosProveedor) object;
        if ((this.idTelefonoProveedor == null && other.idTelefonoProveedor != null) || (this.idTelefonoProveedor != null && !this.idTelefonoProveedor.equals(other.idTelefonoProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.TelefonosProveedor[ idTelefonoProveedor=" + idTelefonoProveedor + " ]";
    }
    
}
