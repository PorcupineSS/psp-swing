/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "ACTU_IMPL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActuImpl.findAll", query = "SELECT a FROM ActuImpl a"),
    @NamedQuery(name = "ActuImpl.findByIdActualizacionI", query = "SELECT a FROM ActuImpl a WHERE a.idActualizacionI = :idActualizacionI"),
    @NamedQuery(name = "ActuImpl.findByFechaActualizacionI", query = "SELECT a FROM ActuImpl a WHERE a.fechaActualizacionI = :fechaActualizacionI"),
    @NamedQuery(name = "ActuImpl.findByCantidadAgregada", query = "SELECT a FROM ActuImpl a WHERE a.cantidadAgregada = :cantidadAgregada"),
    @NamedQuery(name = "ActuImpl.findByDescripcionActualizacion", query = "SELECT a FROM ActuImpl a WHERE a.descripcionActualizacion = :descripcionActualizacion")})
public class ActuImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ACTUALIZACION_I")
    private Short idActualizacionI;
    @Basic(optional = false)
    @Column(name = "FECHA_ACTUALIZACION_I")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacionI;
    @Column(name = "CANTIDAD_AGREGADA")
    private Short cantidadAgregada;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_ACTUALIZACION")
    private String descripcionActualizacion;
    @JoinColumn(name = "ID_IMPLEMENTO", referencedColumnName = "ID_IMPLEMENTO")
    @ManyToOne
    private ImplSeguridad idImplemento;
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE")
    @ManyToOne
    private CoordTYT cedulae;

    public ActuImpl() {
    }

    public ActuImpl(Short idActualizacionI) {
        this.idActualizacionI = idActualizacionI;
    }

    public ActuImpl(Short idActualizacionI, Date fechaActualizacionI, String descripcionActualizacion) {
        this.idActualizacionI = idActualizacionI;
        this.fechaActualizacionI = fechaActualizacionI;
        this.descripcionActualizacion = descripcionActualizacion;
    }

    public Short getIdActualizacionI() {
        return idActualizacionI;
    }

    public void setIdActualizacionI(Short idActualizacionI) {
        this.idActualizacionI = idActualizacionI;
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

    public ImplSeguridad getIdImplemento() {
        return idImplemento;
    }

    public void setIdImplemento(ImplSeguridad idImplemento) {
        this.idImplemento = idImplemento;
    }

    public CoordTYT getCedulae() {
        return cedulae;
    }

    public void setCedulae(CoordTYT cedulae) {
        this.cedulae = cedulae;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActualizacionI != null ? idActualizacionI.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActuImpl)) {
            return false;
        }
        ActuImpl other = (ActuImpl) object;
        if ((this.idActualizacionI == null && other.idActualizacionI != null) || (this.idActualizacionI != null && !this.idActualizacionI.equals(other.idActualizacionI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.ActuImpl[ idActualizacionI=" + idActualizacionI + " ]";
    }
    
}
