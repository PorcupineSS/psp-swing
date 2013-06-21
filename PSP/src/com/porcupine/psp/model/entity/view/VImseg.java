/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "V_IMSEG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VImseg.findAll", query = "SELECT v FROM VImseg v"),
    @NamedQuery(name = "VImseg.findByCedulae", query = "SELECT v FROM VImseg v WHERE v.cedulae = :cedulae"),
    @NamedQuery(name = "VImseg.findByNombreI", query = "SELECT v FROM VImseg v WHERE v.nombreI = :nombreI"),
    @NamedQuery(name = "VImseg.findByPrecioUnitarioI", query = "SELECT v FROM VImseg v WHERE v.precioUnitarioI = :precioUnitarioI"),
    @NamedQuery(name = "VImseg.findByCantidad", query = "SELECT v FROM VImseg v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "VImseg.findByDescripcionI", query = "SELECT v FROM VImseg v WHERE v.descripcionI = :descripcionI"),
    @NamedQuery(name = "VImseg.findByEstadoI", query = "SELECT v FROM VImseg v WHERE v.estadoI = :estadoI"),
    @NamedQuery(name = "VImseg.findByFechaRegIm", query = "SELECT v FROM VImseg v WHERE v.fechaRegIm = :fechaRegIm")})
public class VImseg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private int cedulae;
    @Basic(optional = false)
    @Column(name = "NOMBRE_I")
    private String nombreI;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRECIO_UNITARIO_I")
    private BigDecimal precioUnitarioI;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private short cantidad;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_I")
    private String descripcionI;
    @Basic(optional = false)
    @Column(name = "ESTADO_I")
    private String estadoI;
    @Basic(optional = false)
    @Column(name = "FECHA_REG_IM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegIm;

    public VImseg() {
    }

    public int getCedulae() {
        return cedulae;
    }

    public void setCedulae(int cedulae) {
        this.cedulae = cedulae;
    }

    public String getNombreI() {
        return nombreI;
    }

    public void setNombreI(String nombreI) {
        this.nombreI = nombreI;
    }

    public BigDecimal getPrecioUnitarioI() {
        return precioUnitarioI;
    }

    public void setPrecioUnitarioI(BigDecimal precioUnitarioI) {
        this.precioUnitarioI = precioUnitarioI;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcionI() {
        return descripcionI;
    }

    public void setDescripcionI(String descripcionI) {
        this.descripcionI = descripcionI;
    }

    public String getEstadoI() {
        return estadoI;
    }

    public void setEstadoI(String estadoI) {
        this.estadoI = estadoI;
    }

    public Date getFechaRegIm() {
        return fechaRegIm;
    }

    public void setFechaRegIm(Date fechaRegIm) {
        this.fechaRegIm = fechaRegIm;
    }
    
}
