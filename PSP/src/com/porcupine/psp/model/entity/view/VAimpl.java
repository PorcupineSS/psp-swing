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
@Table(name = "V_AIMPL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VAimpl.findAll", query = "SELECT v FROM VAimpl v"),
    @NamedQuery(name = "VAimpl.findByIdImplemento", query = "SELECT v FROM VAimpl v WHERE v.idImplemento = :idImplemento"),
    @NamedQuery(name = "VAimpl.findByCedulae", query = "SELECT v FROM VAimpl v WHERE v.cedulae = :cedulae"),
    @NamedQuery(name = "VAimpl.findByCooCedulae", query = "SELECT v FROM VAimpl v WHERE v.cooCedulae = :cooCedulae"),
    @NamedQuery(name = "VAimpl.findByCantidadAsignada", query = "SELECT v FROM VAimpl v WHERE v.cantidadAsignada = :cantidadAsignada"),
    @NamedQuery(name = "VAimpl.findByEstadoAsignacion", query = "SELECT v FROM VAimpl v WHERE v.estadoAsignacion = :estadoAsignacion"),
    @NamedQuery(name = "VAimpl.findByFechaAsignacionI", query = "SELECT v FROM VAimpl v WHERE v.fechaAsignacionI = :fechaAsignacionI")})
public class VAimpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID_IMPLEMENTO")
    private short idImplemento;
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private int cedulae;
    @Basic(optional = false)
    @Column(name = "COO_CEDULAE")
    private int cooCedulae;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_ASIGNADA")
    private short cantidadAsignada;
    @Basic(optional = false)
    @Column(name = "ESTADO_ASIGNACION")
    private boolean estadoAsignacion;
    @Basic(optional = false)
    @Column(name = "FECHA_ASIGNACION_I")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacionI;

    public VAimpl() {
    }

    public short getIdImplemento() {
        return idImplemento;
    }

    public void setIdImplemento(short idImplemento) {
        this.idImplemento = idImplemento;
    }

    public int getCedulae() {
        return cedulae;
    }

    public void setCedulae(int cedulae) {
        this.cedulae = cedulae;
    }

    public int getCooCedulae() {
        return cooCedulae;
    }

    public void setCooCedulae(int cooCedulae) {
        this.cooCedulae = cooCedulae;
    }

    public short getCantidadAsignada() {
        return cantidadAsignada;
    }

    public void setCantidadAsignada(short cantidadAsignada) {
        this.cantidadAsignada = cantidadAsignada;
    }

    public boolean getEstadoAsignacion() {
        return estadoAsignacion;
    }

    public void setEstadoAsignacion(boolean estadoAsignacion) {
        this.estadoAsignacion = estadoAsignacion;
    }

    public Date getFechaAsignacionI() {
        return fechaAsignacionI;
    }

    public void setFechaAsignacionI(Date fechaAsignacionI) {
        this.fechaAsignacionI = fechaAsignacionI;
    }
    
}
