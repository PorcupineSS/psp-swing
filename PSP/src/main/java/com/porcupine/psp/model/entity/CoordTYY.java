/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "COORD_T_Y_Y")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoordTYY.findAll", query = "SELECT c FROM CoordTYY c"),
    @NamedQuery(name = "CoordTYY.findByCedulae", query = "SELECT c FROM CoordTYY c WHERE c.cedulae = :cedulae")})
public class CoordTYY implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private Long cedulae;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulae")
    private List<ImplSeguridad> implSeguridadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulae")
    private List<Proveedor> proveedorList;
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private EmpPlanta empPlanta;
    @OneToMany(mappedBy = "cooCedulae")
    private List<AsigImpl> asigImplList;
    @OneToMany(mappedBy = "cedulae")
    private List<ActuImpl> actuImplList;

    public CoordTYY() {
    }

    public CoordTYY(Long cedulae) {
        this.cedulae = cedulae;
    }

    public Long getCedulae() {
        return cedulae;
    }

    public void setCedulae(Long cedulae) {
        this.cedulae = cedulae;
    }

    @XmlTransient
    public List<ImplSeguridad> getImplSeguridadList() {
        return implSeguridadList;
    }

    public void setImplSeguridadList(List<ImplSeguridad> implSeguridadList) {
        this.implSeguridadList = implSeguridadList;
    }

    @XmlTransient
    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    public EmpPlanta getEmpPlanta() {
        return empPlanta;
    }

    public void setEmpPlanta(EmpPlanta empPlanta) {
        this.empPlanta = empPlanta;
    }

    @XmlTransient
    public List<AsigImpl> getAsigImplList() {
        return asigImplList;
    }

    public void setAsigImplList(List<AsigImpl> asigImplList) {
        this.asigImplList = asigImplList;
    }

    @XmlTransient
    public List<ActuImpl> getActuImplList() {
        return actuImplList;
    }

    public void setActuImplList(List<ActuImpl> actuImplList) {
        this.actuImplList = actuImplList;
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
        if (!(object instanceof CoordTYY)) {
            return false;
        }
        CoordTYY other = (CoordTYY) object;
        if ((this.cedulae == null && other.cedulae != null) || (this.cedulae != null && !this.cedulae.equals(other.cedulae))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.CoordTYY[ cedulae=" + cedulae + " ]";
    }
    
}
