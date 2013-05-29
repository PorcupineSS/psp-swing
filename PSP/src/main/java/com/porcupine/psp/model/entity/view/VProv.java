/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity.view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "V_PROV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VProv.findAll", query = "SELECT v FROM VProv v"),
    @NamedQuery(name = "VProv.findByCedulae", query = "SELECT v FROM VProv v WHERE v.cedulae = :cedulae"),
    @NamedQuery(name = "VProv.findByNombre", query = "SELECT v FROM VProv v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "VProv.findByDireccion", query = "SELECT v FROM VProv v WHERE v.direccion = :direccion"),
    @NamedQuery(name = "VProv.findByFechaRegProv", query = "SELECT v FROM VProv v WHERE v.fechaRegProv = :fechaRegProv")})
public class VProv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private long cedulae;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "FECHA_REG_PROV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegProv;

    public VProv() {
    }

    public long getCedulae() {
        return cedulae;
    }

    public void setCedulae(long cedulae) {
        this.cedulae = cedulae;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaRegProv() {
        return fechaRegProv;
    }

    public void setFechaRegProv(Date fechaRegProv) {
        this.fechaRegProv = fechaRegProv;
    }
    
}
