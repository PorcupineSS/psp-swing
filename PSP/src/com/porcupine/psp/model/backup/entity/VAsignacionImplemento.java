/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "V_ASIGNACION_IMPLEMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VAsignacionImplemento.findAll", query = "SELECT v FROM VAsignacionImplemento v"),
    @NamedQuery(name = "VAsignacionImplemento.findByIdAsignacionImplemento", query = "SELECT v FROM VAsignacionImplemento v WHERE v.idAsignacionImplemento = :idAsignacionImplemento"),
    @NamedQuery(name = "VAsignacionImplemento.findByIdImplemento", query = "SELECT v FROM VAsignacionImplemento v WHERE v.idImplemento = :idImplemento"),
    @NamedQuery(name = "VAsignacionImplemento.findByCedulaet", query = "SELECT v FROM VAsignacionImplemento v WHERE v.cedulaet = :cedulaet"),
    @NamedQuery(name = "VAsignacionImplemento.findByCedulactt", query = "SELECT v FROM VAsignacionImplemento v WHERE v.cedulactt = :cedulactt"),
    @NamedQuery(name = "VAsignacionImplemento.findByCantidadAsignada", query = "SELECT v FROM VAsignacionImplemento v WHERE v.cantidadAsignada = :cantidadAsignada"),
    @NamedQuery(name = "VAsignacionImplemento.findByEstadoAsignacion", query = "SELECT v FROM VAsignacionImplemento v WHERE v.estadoAsignacion = :estadoAsignacion"),
    @NamedQuery(name = "VAsignacionImplemento.findByFechaAsignacion", query = "SELECT v FROM VAsignacionImplemento v WHERE v.fechaAsignacion = :fechaAsignacion")})
public class VAsignacionImplemento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ASIGNACION_IMPLEMENTO")
    private BigDecimal idAsignacionImplemento;
    @Column(name = "ID_IMPLEMENTO")
    private BigInteger idImplemento;
    @Column(name = "CEDULAET")
    private BigInteger cedulaet;
    @Column(name = "CEDULACTT")
    private BigInteger cedulactt;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_ASIGNADA")
    private BigInteger cantidadAsignada;
    @Basic(optional = false)
    @Column(name = "ESTADO_ASIGNACION")
    private String estadoAsignacion;
    @Basic(optional = false)
    @Column(name = "FECHA_ASIGNACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacion;

    public VAsignacionImplemento() {
    }

    public VAsignacionImplemento(BigDecimal idAsignacionImplemento) {
        this.idAsignacionImplemento = idAsignacionImplemento;
    }

    public VAsignacionImplemento(BigDecimal idAsignacionImplemento, BigInteger cantidadAsignada, String estadoAsignacion, Date fechaAsignacion) {
        this.idAsignacionImplemento = idAsignacionImplemento;
        this.cantidadAsignada = cantidadAsignada;
        this.estadoAsignacion = estadoAsignacion;
        this.fechaAsignacion = fechaAsignacion;
    }

    public BigDecimal getIdAsignacionImplemento() {
        return idAsignacionImplemento;
    }

    public void setIdAsignacionImplemento(BigDecimal idAsignacionImplemento) {
        this.idAsignacionImplemento = idAsignacionImplemento;
    }

    public BigInteger getIdImplemento() {
        return idImplemento;
    }

    public void setIdImplemento(BigInteger idImplemento) {
        this.idImplemento = idImplemento;
    }

    public BigInteger getCedulaet() {
        return cedulaet;
    }

    public void setCedulaet(BigInteger cedulaet) {
        this.cedulaet = cedulaet;
    }

    public BigInteger getCedulactt() {
        return cedulactt;
    }

    public void setCedulactt(BigInteger cedulactt) {
        this.cedulactt = cedulactt;
    }

    public BigInteger getCantidadAsignada() {
        return cantidadAsignada;
    }

    public void setCantidadAsignada(BigInteger cantidadAsignada) {
        this.cantidadAsignada = cantidadAsignada;
    }

    public String getEstadoAsignacion() {
        return estadoAsignacion;
    }

    public void setEstadoAsignacion(String estadoAsignacion) {
        this.estadoAsignacion = estadoAsignacion;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacionImplemento != null ? idAsignacionImplemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VAsignacionImplemento)) {
            return false;
        }
        VAsignacionImplemento other = (VAsignacionImplemento) object;
        if ((this.idAsignacionImplemento == null && other.idAsignacionImplemento != null) || (this.idAsignacionImplemento != null && !this.idAsignacionImplemento.equals(other.idAsignacionImplemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VAsignacionImplemento[ idAsignacionImplemento=" + idAsignacionImplemento + " ]";
    }
    
}
