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
@Table(name = "V_CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VCliente.findAll", query = "SELECT v FROM VCliente v"),
    @NamedQuery(name = "VCliente.findByCedulae", query = "SELECT v FROM VCliente v WHERE v.cedulae = :cedulae"),
    @NamedQuery(name = "VCliente.findByNombrecl", query = "SELECT v FROM VCliente v WHERE v.nombrecl = :nombrecl"),
    @NamedQuery(name = "VCliente.findByDireccioncl", query = "SELECT v FROM VCliente v WHERE v.direccioncl = :direccioncl"),
    @NamedQuery(name = "VCliente.findByFechaRegCl", query = "SELECT v FROM VCliente v WHERE v.fechaRegCl = :fechaRegCl")})
public class VCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private long cedulae;
    @Basic(optional = false)
    @Column(name = "NOMBRECL")
    private String nombrecl;
    @Basic(optional = false)
    @Column(name = "DIRECCIONCL")
    private String direccioncl;
    @Basic(optional = false)
    @Column(name = "FECHA_REG_CL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegCl;

    public VCliente() {
    }

    public long getCedulae() {
        return cedulae;
    }

    public void setCedulae(long cedulae) {
        this.cedulae = cedulae;
    }

    public String getNombrecl() {
        return nombrecl;
    }

    public void setNombrecl(String nombrecl) {
        this.nombrecl = nombrecl;
    }

    public String getDireccioncl() {
        return direccioncl;
    }

    public void setDireccioncl(String direccioncl) {
        this.direccioncl = direccioncl;
    }

    public Date getFechaRegCl() {
        return fechaRegCl;
    }

    public void setFechaRegCl(Date fechaRegCl) {
        this.fechaRegCl = fechaRegCl;
    }
    
}
