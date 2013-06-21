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
@Table(name = "V_ACIMPL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VAcimpl.findAll", query = "SELECT v FROM VAcimpl v"),
    @NamedQuery(name = "VAcimpl.findByIdImplemento", query = "SELECT v FROM VAcimpl v WHERE v.idImplemento = :idImplemento"),
    @NamedQuery(name = "VAcimpl.findByCedulae", query = "SELECT v FROM VAcimpl v WHERE v.cedulae = :cedulae"),
    @NamedQuery(name = "VAcimpl.findByFechaActualizacionI", query = "SELECT v FROM VAcimpl v WHERE v.fechaActualizacionI = :fechaActualizacionI"),
    @NamedQuery(name = "VAcimpl.findByCantidadAgregada", query = "SELECT v FROM VAcimpl v WHERE v.cantidadAgregada = :cantidadAgregada"),
    @NamedQuery(name = "VAcimpl.findByDescripcionActualizacion", query = "SELECT v FROM VAcimpl v WHERE v.descripcionActualizacion = :descripcionActualizacion")})
public class VAcimpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_IMPLEMENTO")
    private Short idImplemento;
    @Column(name = "CEDULAE")
    private Integer cedulae;
    @Basic(optional = false)
    @Column(name = "FECHA_ACTUALIZACION_I")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacionI;
    @Column(name = "CANTIDAD_AGREGADA")
    private Short cantidadAgregada;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_ACTUALIZACION")
    private String descripcionActualizacion;

    public VAcimpl() {
    }

    public Short getIdImplemento() {
        return idImplemento;
    }

    public void setIdImplemento(Short idImplemento) {
        this.idImplemento = idImplemento;
    }

    public Integer getCedulae() {
        return cedulae;
    }

    public void setCedulae(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public Date getFechaActualizacionI() {
        return fechaActualizacionI;
    }

    public void setFechaActualizacionI(Date fechaActualizacionI) {
        this.fechaActualizacionI = fechaActualizacionI;
    }

    public Short getCantidadAgregada() {
        return cantidadAgregada;
    }

    public void setCantidadAgregada(Short cantidadAgregada) {
        this.cantidadAgregada = cantidadAgregada;
    }

    public String getDescripcionActualizacion() {
        return descripcionActualizacion;
    }

    public void setDescripcionActualizacion(String descripcionActualizacion) {
        this.descripcionActualizacion = descripcionActualizacion;
    }
    
}
