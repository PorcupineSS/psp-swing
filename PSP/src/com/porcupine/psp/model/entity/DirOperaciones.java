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
@Table(name = "DIR_OPERACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DirOperaciones.findAll", query = "SELECT d FROM DirOperaciones d"),
    @NamedQuery(name = "DirOperaciones.findByCedulae", query = "SELECT d FROM DirOperaciones d WHERE d.cedulae = :cedulae")})
public class DirOperaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private Integer cedulae;
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private EmpPlanta empPlanta;
    @OneToMany(mappedBy = "dirCedulae")
    private Collection<Comunicado> comunicadoCollection;

    public DirOperaciones() {
    }

    public DirOperaciones(Integer cedulae) {
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
    public Collection<Comunicado> getComunicadoCollection() {
        return comunicadoCollection;
    }

    public void setComunicadoCollection(Collection<Comunicado> comunicadoCollection) {
        this.comunicadoCollection = comunicadoCollection;
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
        if (!(object instanceof DirOperaciones)) {
            return false;
        }
        DirOperaciones other = (DirOperaciones) object;
        if ((this.cedulae == null && other.cedulae != null) || (this.cedulae != null && !this.cedulae.equals(other.cedulae))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.DirOperaciones[ cedulae=" + cedulae + " ]";
    }
    
}
