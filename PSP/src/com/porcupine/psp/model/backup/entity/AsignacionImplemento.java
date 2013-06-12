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
@Table(name = "ASIGNACION_IMPLEMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionImplemento.findAll", query = "SELECT a FROM AsignacionImplemento a"),
    @NamedQuery(name = "AsignacionImplemento.findByIdAsignacionImplemento", query = "SELECT a FROM AsignacionImplemento a WHERE a.idAsignacionImplemento = :idAsignacionImplemento"),
    @NamedQuery(name = "AsignacionImplemento.findByIdImplemento", query = "SELECT a FROM AsignacionImplemento a WHERE a.idImplemento = :idImplemento"),
    @NamedQuery(name = "AsignacionImplemento.findByCedulaet", query = "SELECT a FROM AsignacionImplemento a WHERE a.cedulaet = :cedulaet"),
    @NamedQuery(name = "AsignacionImplemento.findByCedulactt", query = "SELECT a FROM AsignacionImplemento a WHERE a.cedulactt = :cedulactt"),
    @NamedQuery(name = "AsignacionImplemento.findByCantidadAsignada", query = "SELECT a FROM AsignacionImplemento a WHERE a.cantidadAsignada = :cantidadAsignada"),
    @NamedQuery(name = "AsignacionImplemento.findByEstadoAsignacion", query = "SELECT a FROM AsignacionImplemento a WHERE a.estadoAsignacion = :estadoAsignacion"),
    @NamedQuery(name = "AsignacionImplemento.findByFechaAsignacion", query = "SELECT a FROM AsignacionImplemento a WHERE a.fechaAsignacion = :fechaAsignacion")})
public class AsignacionImplemento implements Serializable {
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

    public AsignacionImplemento() {
    }

    public AsignacionImplemento(BigDecimal idAsignacionImplemento) {
        this.idAsignacionImplemento = idAsignacionImplemento;
    }

    public AsignacionImplemento(BigDecimal idAsignacionImplemento, BigInteger cantidadAsignada, String estadoAsignacion, Date fechaAsignacion) {
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
        if (!(object instanceof AsignacionImplemento)) {
            return false;
        }
        AsignacionImplemento other = (AsignacionImplemento) object;
        if ((this.idAsignacionImplemento == null && other.idAsignacionImplemento != null) || (this.idAsignacionImplemento != null && !this.idAsignacionImplemento.equals(other.idAsignacionImplemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.AsignacionImplemento[ idAsignacionImplemento=" + idAsignacionImplemento + " ]";
    }
    
}
