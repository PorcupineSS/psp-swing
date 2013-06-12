/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "DIR_GESTION_HUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DirGestionHum.findAll", query = "SELECT d FROM DirGestionHum d"),
    @NamedQuery(name = "DirGestionHum.findByCedulae", query = "SELECT d FROM DirGestionHum d WHERE d.cedulae = :cedulae")})
public class DirGestionHum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private Integer cedulae;
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private EmpPlanta empPlanta;
    @OneToMany(mappedBy = "dirCedulae")
    private Collection<Empleados> empleadosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dirGestionHum")
    private Collection<Actualizacion> actualizacionCollection;

    public DirGestionHum() {
    }

    public DirGestionHum(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public Integer getCedulae() {
        return cedulae;
    }

    public void setCedulae(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public EmpPlanta getEmpPlanta() {
        return empPlanta;
    }

    public void setEmpPlanta(EmpPlanta empPlanta) {
        this.empPlanta = empPlanta;
    }

    @XmlTransient
    public Collection<Empleados> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleados> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
    }

    @XmlTransient
    public Collection<Actualizacion> getActualizacionCollection() {
        return actualizacionCollection;
    }

    public void setActualizacionCollection(Collection<Actualizacion> actualizacionCollection) {
        this.actualizacionCollection = actualizacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulae != null ? cedulae.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DirGestionHum)) {
            return false;
        }
        DirGestionHum other = (DirGestionHum) object;
        if ((this.cedulae == null && other.cedulae != null) || (this.cedulae != null && !this.cedulae.equals(other.cedulae))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.DirGestionHum[ cedulae=" + cedulae + " ]";
    }
    
}
