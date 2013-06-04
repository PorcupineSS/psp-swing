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
@Table(name = "V_ACTUALIZACION_IMPLEMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VActualizacionImplemento.findAll", query = "SELECT v FROM VActualizacionImplemento v"),
    @NamedQuery(name = "VActualizacionImplemento.findByIdActualizacion", query = "SELECT v FROM VActualizacionImplemento v WHERE v.idActualizacion = :idActualizacion"),
    @NamedQuery(name = "VActualizacionImplemento.findByIdImplemento", query = "SELECT v FROM VActualizacionImplemento v WHERE v.idImplemento = :idImplemento"),
    @NamedQuery(name = "VActualizacionImplemento.findByCedula", query = "SELECT v FROM VActualizacionImplemento v WHERE v.cedula = :cedula"),
    @NamedQuery(name = "VActualizacionImplemento.findByFechaActualizacion", query = "SELECT v FROM VActualizacionImplemento v WHERE v.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "VActualizacionImplemento.findByCantidadAgregada", query = "SELECT v FROM VActualizacionImplemento v WHERE v.cantidadAgregada = :cantidadAgregada"),
    @NamedQuery(name = "VActualizacionImplemento.findByDescripcionActualizacion", query = "SELECT v FROM VActualizacionImplemento v WHERE v.descripcionActualizacion = :descripcionActualizacion")})
public class VActualizacionImplemento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ACTUALIZACION")
    private BigDecimal idActualizacion;
    @Column(name = "ID_IMPLEMENTO")
    private BigInteger idImplemento;
    @Column(name = "CEDULA")
    private BigInteger cedula;
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Column(name = "CANTIDAD_AGREGADA")
    private BigInteger cantidadAgregada;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_ACTUALIZACION")
    private String descripcionActualizacion;

    public VActualizacionImplemento() {
    }

    public VActualizacionImplemento(BigDecimal idActualizacion) {
        this.idActualizacion = idActualizacion;
    }

    public VActualizacionImplemento(BigDecimal idActualizacion, String descripcionActualizacion) {
        this.idActualizacion = idActualizacion;
        this.descripcionActualizacion = descripcionActualizacion;
    }

    public BigDecimal getIdActualizacion() {
        return idActualizacion;
    }

    public void setIdActualizacion(BigDecimal idActualizacion) {
        this.idActualizacion = idActualizacion;
    }

    public BigInteger getIdImplemento() {
        return idImplemento;
    }

    public void setIdImplemento(BigInteger idImplemento) {
        this.idImplemento = idImplemento;
    }

    public BigInteger getCedula() {
        return cedula;
    }

    public void setCedula(BigInteger cedula) {
        this.cedula = cedula;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public BigInteger getCantidadAgregada() {
        return cantidadAgregada;
    }

    public void setCantidadAgregada(BigInteger cantidadAgregada) {
        this.cantidadAgregada = cantidadAgregada;
    }

    public String getDescripcionActualizacion() {
        return descripcionActualizacion;
    }

    public void setDescripcionActualizacion(String descripcionActualizacion) {
        this.descripcionActualizacion = descripcionActualizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActualizacion != null ? idActualizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VActualizacionImplemento)) {
            return false;
        }
        VActualizacionImplemento other = (VActualizacionImplemento) object;
        if ((this.idActualizacion == null && other.idActualizacion != null) || (this.idActualizacion != null && !this.idActualizacion.equals(other.idActualizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VActualizacionImplemento[ idActualizacion=" + idActualizacion + " ]";
    }
    
}
