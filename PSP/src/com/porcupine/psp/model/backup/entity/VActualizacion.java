/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
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
@Table(name = "V_ACTUALIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VActualizacion.findAll", query = "SELECT v FROM VActualizacion v"),
    @NamedQuery(name = "VActualizacion.findByCeduladir", query = "SELECT v FROM VActualizacion v WHERE v.ceduladir = :ceduladir"),
    @NamedQuery(name = "VActualizacion.findByCedulasg", query = "SELECT v FROM VActualizacion v WHERE v.cedulasg = :cedulasg"),
    @NamedQuery(name = "VActualizacion.findByFechaActualDgh", query = "SELECT v FROM VActualizacion v WHERE v.fechaActualDgh = :fechaActualDgh")})
public class VActualizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULADIR")
    private BigInteger ceduladir;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULASG")
    private BigInteger cedulasg;
    @Basic(optional = false)
    @Column(name = "FECHA_ACTUAL_DGH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualDgh;

    public VActualizacion() {
    }

    public VActualizacion(BigInteger cedulasg) {
        this.cedulasg = cedulasg;
    }

    public VActualizacion(BigInteger cedulasg, Date fechaActualDgh) {
        this.cedulasg = cedulasg;
        this.fechaActualDgh = fechaActualDgh;
    }

    public BigInteger getCeduladir() {
        return ceduladir;
    }

    public void setCeduladir(BigInteger ceduladir) {
        this.ceduladir = ceduladir;
    }

    public BigInteger getCedulasg() {
        return cedulasg;
    }

    public void setCedulasg(BigInteger cedulasg) {
        this.cedulasg = cedulasg;
    }

    public Date getFechaActualDgh() {
        return fechaActualDgh;
    }

    public void setFechaActualDgh(Date fechaActualDgh) {
        this.fechaActualDgh = fechaActualDgh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulasg != null ? cedulasg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VActualizacion)) {
            return false;
        }
        VActualizacion other = (VActualizacion) object;
        if ((this.cedulasg == null && other.cedulasg != null) || (this.cedulasg != null && !this.cedulasg.equals(other.cedulasg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VActualizacion[ cedulasg=" + cedulasg + " ]";
    }
    
}
