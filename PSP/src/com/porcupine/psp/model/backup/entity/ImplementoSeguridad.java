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
@Table(name = "IMPLEMENTO_SEGURIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImplementoSeguridad.findAll", query = "SELECT i FROM ImplementoSeguridad i"),
    @NamedQuery(name = "ImplementoSeguridad.findByIdImplemento", query = "SELECT i FROM ImplementoSeguridad i WHERE i.idImplemento = :idImplemento"),
    @NamedQuery(name = "ImplementoSeguridad.findByIdProveedor", query = "SELECT i FROM ImplementoSeguridad i WHERE i.idProveedor = :idProveedor"),
    @NamedQuery(name = "ImplementoSeguridad.findByCedula", query = "SELECT i FROM ImplementoSeguridad i WHERE i.cedula = :cedula"),
    @NamedQuery(name = "ImplementoSeguridad.findByNombreImplemento", query = "SELECT i FROM ImplementoSeguridad i WHERE i.nombreImplemento = :nombreImplemento"),
    @NamedQuery(name = "ImplementoSeguridad.findByPrecioUnitarioImplemento", query = "SELECT i FROM ImplementoSeguridad i WHERE i.precioUnitarioImplemento = :precioUnitarioImplemento"),
    @NamedQuery(name = "ImplementoSeguridad.findByCantidadImplementos", query = "SELECT i FROM ImplementoSeguridad i WHERE i.cantidadImplementos = :cantidadImplementos"),
    @NamedQuery(name = "ImplementoSeguridad.findByDescripcionImplemento", query = "SELECT i FROM ImplementoSeguridad i WHERE i.descripcionImplemento = :descripcionImplemento"),
    @NamedQuery(name = "ImplementoSeguridad.findByEstadoImplemento", query = "SELECT i FROM ImplementoSeguridad i WHERE i.estadoImplemento = :estadoImplemento"),
    @NamedQuery(name = "ImplementoSeguridad.findByFechaRegistroImplemento", query = "SELECT i FROM ImplementoSeguridad i WHERE i.fechaRegistroImplemento = :fechaRegistroImplemento")})
public class ImplementoSeguridad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_IMPLEMENTO")
    private BigDecimal idImplemento;
    @Column(name = "ID_PROVEEDOR")
    private BigInteger idProveedor;
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private BigInteger cedula;
    @Basic(optional = false)
    @Column(name = "NOMBRE_IMPLEMENTO")
    private String nombreImplemento;
    @Basic(optional = false)
    @Column(name = "PRECIO_UNITARIO_IMPLEMENTO")
    private BigDecimal precioUnitarioImplemento;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_IMPLEMENTOS")
    private BigInteger cantidadImplementos;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_IMPLEMENTO")
    private String descripcionImplemento;
    @Basic(optional = false)
    @Column(name = "ESTADO_IMPLEMENTO")
    private String estadoImplemento;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO_IMPLEMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistroImplemento;

    public ImplementoSeguridad() {
    }

    public ImplementoSeguridad(BigDecimal idImplemento) {
        this.idImplemento = idImplemento;
    }

    public ImplementoSeguridad(BigDecimal idImplemento, BigInteger cedula, String nombreImplemento, BigDecimal precioUnitarioImplemento, BigInteger cantidadImplementos, String descripcionImplemento, String estadoImplemento, Date fechaRegistroImplemento) {
        this.idImplemento = idImplemento;
        this.cedula = cedula;
        this.nombreImplemento = nombreImplemento;
        this.precioUnitarioImplemento = precioUnitarioImplemento;
        this.cantidadImplementos = cantidadImplementos;
        this.descripcionImplemento = descripcionImplemento;
        this.estadoImplemento = estadoImplemento;
        this.fechaRegistroImplemento = fechaRegistroImplemento;
    }

    public BigDecimal getIdImplemento() {
        return idImplemento;
    }

    public void setIdImplemento(BigDecimal idImplemento) {
        this.idImplemento = idImplemento;
    }

    public BigInteger getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(BigInteger idProveedor) {
        this.idProveedor = idProveedor;
    }

    public BigInteger getCedula() {
        return cedula;
    }

    public void setCedula(BigInteger cedula) {
        this.cedula = cedula;
    }

    public String getNombreImplemento() {
        return nombreImplemento;
    }

    public void setNombreImplemento(String nombreImplemento) {
        this.nombreImplemento = nombreImplemento;
    }

    public BigDecimal getPrecioUnitarioImplemento() {
        return precioUnitarioImplemento;
    }

    public void setPrecioUnitarioImplemento(BigDecimal precioUnitarioImplemento) {
        this.precioUnitarioImplemento = precioUnitarioImplemento;
    }

    public BigInteger getCantidadImplementos() {
        return cantidadImplementos;
    }

    public void setCantidadImplementos(BigInteger cantidadImplementos) {
        this.cantidadImplementos = cantidadImplementos;
    }

    public String getDescripcionImplemento() {
        return descripcionImplemento;
    }

    public void setDescripcionImplemento(String descripcionImplemento) {
        this.descripcionImplemento = descripcionImplemento;
    }

    public String getEstadoImplemento() {
        return estadoImplemento;
    }

    public void setEstadoImplemento(String estadoImplemento) {
        this.estadoImplemento = estadoImplemento;
    }

    public Date getFechaRegistroImplemento() {
        return fechaRegistroImplemento;
    }

    public void setFechaRegistroImplemento(Date fechaRegistroImplemento) {
        this.fechaRegistroImplemento = fechaRegistroImplemento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImplemento != null ? idImplemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImplementoSeguridad)) {
            return false;
        }
        ImplementoSeguridad other = (ImplementoSeguridad) object;
        if ((this.idImplemento == null && other.idImplemento != null) || (this.idImplemento != null && !this.idImplemento.equals(other.idImplemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.ImplementoSeguridad[ idImplemento=" + idImplemento + " ]";
    }
    
}
