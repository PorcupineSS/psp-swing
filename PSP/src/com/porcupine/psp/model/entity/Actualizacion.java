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
@Table(name = "ACTUALIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actualizacion.findAll", query = "SELECT a FROM Actualizacion a"),
    @NamedQuery(name = "Actualizacion.findBySubCedulae", query = "SELECT a FROM Actualizacion a WHERE a.actualizacionPK.subCedulae = :subCedulae"),
    @NamedQuery(name = "Actualizacion.findByCedulae", query = "SELECT a FROM Actualizacion a WHERE a.actualizacionPK.cedulae = :cedulae"),
    @NamedQuery(name = "Actualizacion.findByFechaActualDgh", query = "SELECT a FROM Actualizacion a WHERE a.fechaActualDgh = :fechaActualDgh")})
public class Actualizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActualizacionPK actualizacionPK;
    @Basic(optional = false)
    @Column(name = "FECHA_ACTUAL_DGH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualDgh;
    @JoinColumn(name = "SUB_CEDULAE", referencedColumnName = "CEDULAE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subgerente subgerente;
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DirGestionHum dirGestionHum;

    public Actualizacion() {
    }

    public Actualizacion(ActualizacionPK actualizacionPK) {
        this.actualizacionPK = actualizacionPK;
    }

    public Actualizacion(ActualizacionPK actualizacionPK, Date fechaActualDgh) {
        this.actualizacionPK = actualizacionPK;
        this.fechaActualDgh = fechaActualDgh;
    }

    public Actualizacion(int subCedulae, int cedulae) {
        this.actualizacionPK = new ActualizacionPK(subCedulae, cedulae);
    }

    public ActualizacionPK getActualizacionPK() {
        return actualizacionPK;
    }

    public void setActualizacionPK(ActualizacionPK actualizacionPK) {
        this.actualizacionPK = actualizacionPK;
    }

    public Date getFechaActualDgh() {
        return fechaActualDgh;
    }

    public void setFechaActualDgh(Date fechaActualDgh) {
        this.fechaActualDgh = fechaActualDgh;
    }

    public Subgerente getSubgerente() {
        return subgerente;
    }

    public void setSubgerente(Subgerente subgerente) {
        this.subgerente = subgerente;
    }

    public DirGestionHum getDirGestionHum() {
        return dirGestionHum;
    }

    public void setDirGestionHum(DirGestionHum dirGestionHum) {
        this.dirGestionHum = dirGestionHum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actualizacionPK != null ? actualizacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actualizacion)) {
            return false;
        }
        Actualizacion other = (Actualizacion) object;
        if ((this.actualizacionPK == null && other.actualizacionPK != null) || (this.actualizacionPK != null && !this.actualizacionPK.equals(other.actualizacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.Actualizacion[ actualizacionPK=" + actualizacionPK + " ]";
    }
    
}
