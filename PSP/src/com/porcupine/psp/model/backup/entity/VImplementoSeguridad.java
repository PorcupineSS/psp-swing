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
@Table(name = "V_IMPLEMENTO_SEGURIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VImplementoSeguridad.findAll", query = "SELECT v FROM VImplementoSeguridad v"),
    @NamedQuery(name = "VImplementoSeguridad.findByIdImplemento", query = "SELECT v FROM VImplementoSeguridad v WHERE v.idImplemento = :idImplemento"),
    @NamedQuery(name = "VImplementoSeguridad.findByIdProveedor", query = "SELECT v FROM VImplementoSeguridad v WHERE v.idProveedor = :idProveedor"),
    @NamedQuery(name = "VImplementoSeguridad.findByCedula", query = "SELECT v FROM VImplementoSeguridad v WHERE v.cedula = :cedula"),
    @NamedQuery(name = "VImplementoSeguridad.findByNombreImplemento", query = "SELECT v FROM VImplementoSeguridad v WHERE v.nombreImplemento = :nombreImplemento"),
    @NamedQuery(name = "VImplementoSeguridad.findByPrecioUnitarioImplemento", query = "SELECT v FROM VImplementoSeguridad v WHERE v.precioUnitarioImplemento = :precioUnitarioImplemento"),
    @NamedQuery(name = "VImplementoSeguridad.findByCantidadImplementos", query = "SELECT v FROM VImplementoSeguridad v WHERE v.cantidadImplementos = :cantidadImplementos"),
    @NamedQuery(name = "VImplementoSeguridad.findByDescripcionImplemento", query = "SELECT v FROM VImplementoSeguridad v WHERE v.descripcionImplemento = :descripcionImplemento"),
    @NamedQuery(name = "VImplementoSeguridad.findByEstadoImplemento", query = "SELECT v FROM VImplementoSeguridad v WHERE v.estadoImplemento = :estadoImplemento"),
    @NamedQuery(name = "VImplementoSeguridad.findByFechaRegistroImplemento", query = "SELECT v FROM VImplementoSeguridad v WHERE v.fechaRegistroImplemento = :fechaRegistroImplemento")})
public class VImplementoSeguridad implements Serializable {
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

    public VImplementoSeguridad() {
    }

    public VImplementoSeguridad(BigDecimal idImplemento) {
        this.idImplemento = idImplemento;
    }

    public VImplementoSeguridad(BigDecimal idImplemento, BigInteger cedula, String nombreImplemento, BigDecimal precioUnitarioImplemento, BigInteger cantidadImplementos, String descripcionImplemento, String estadoImplemento, Date fechaRegistroImplemento) {
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
        if (!(object instanceof VImplementoSeguridad)) {
            return false;
        }
        VImplementoSeguridad other = (VImplementoSeguridad) object;
        if ((this.idImplemento == null && other.idImplemento != null) || (this.idImplemento != null && !this.idImplemento.equals(other.idImplemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VImplementoSeguridad[ idImplemento=" + idImplemento + " ]";
    }
    
}
