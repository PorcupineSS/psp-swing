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
@Table(name = "ASIG_IMPL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsigImpl.findAll", query = "SELECT a FROM AsigImpl a"),
    @NamedQuery(name = "AsigImpl.findByIdAsignacionI", query = "SELECT a FROM AsigImpl a WHERE a.idAsignacionI = :idAsignacionI"),
    @NamedQuery(name = "AsigImpl.findByCantidadAsignada", query = "SELECT a FROM AsigImpl a WHERE a.cantidadAsignada = :cantidadAsignada"),
    @NamedQuery(name = "AsigImpl.findByEstadoAsignacion", query = "SELECT a FROM AsigImpl a WHERE a.estadoAsignacion = :estadoAsignacion"),
    @NamedQuery(name = "AsigImpl.findByFechaAsignacionI", query = "SELECT a FROM AsigImpl a WHERE a.fechaAsignacionI = :fechaAsignacionI")})
public class AsigImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ASIGNACION_I")
    private Short idAsignacionI;
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
    @JoinColumn(name = "ID_IMPLEMENTO", referencedColumnName = "ID_IMPLEMENTO")
    @ManyToOne
    private ImplSeguridad idImplemento;
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE")
    @ManyToOne
    private EmTemp cedulae;
    @JoinColumn(name = "COO_CEDULAE", referencedColumnName = "CEDULAE")
    @ManyToOne
    private CoordTYY cooCedulae;

    public AsigImpl() {
    }

    public AsigImpl(Short idAsignacionI) {
        this.idAsignacionI = idAsignacionI;
    }

    public AsigImpl(Short idAsignacionI, short cantidadAsignada, boolean estadoAsignacion, Date fechaAsignacionI) {
        this.idAsignacionI = idAsignacionI;
        this.cantidadAsignada = cantidadAsignada;
        this.estadoAsignacion = estadoAsignacion;
        this.fechaAsignacionI = fechaAsignacionI;
    }

    public Short getIdAsignacionI() {
        return idAsignacionI;
    }

    public void setIdAsignacionI(Short idAsignacionI) {
        this.idAsignacionI = idAsignacionI;
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

    public ImplSeguridad getIdImplemento() {
        return idImplemento;
    }

    public void setIdImplemento(ImplSeguridad idImplemento) {
        this.idImplemento = idImplemento;
    }

    public EmTemp getCedulae() {
        return cedulae;
    }

    public void setCedulae(EmTemp cedulae) {
        this.cedulae = cedulae;
    }

    public CoordTYY getCooCedulae() {
        return cooCedulae;
    }

    public void setCooCedulae(CoordTYY cooCedulae) {
        this.cooCedulae = cooCedulae;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacionI != null ? idAsignacionI.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsigImpl)) {
            return false;
        }
        AsigImpl other = (AsigImpl) object;
        if ((this.idAsignacionI == null && other.idAsignacionI != null) || (this.idAsignacionI != null && !this.idAsignacionI.equals(other.idAsignacionI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.AsigImpl[ idAsignacionI=" + idAsignacionI + " ]";
    }
    
}
