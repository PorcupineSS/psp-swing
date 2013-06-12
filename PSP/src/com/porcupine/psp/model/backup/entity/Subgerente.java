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
@Table(name = "SUBGERENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subgerente.findAll", query = "SELECT s FROM Subgerente s"),
    @NamedQuery(name = "Subgerente.findByCedulae", query = "SELECT s FROM Subgerente s WHERE s.cedulae = :cedulae")})
public class Subgerente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private Long cedulae;
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private EmpPlanta empPlanta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subgerente")
    private List<Actualizacion> actualizacionList;

    public Subgerente() {
    }

    public Subgerente(Long cedulae) {
        this.cedulae = cedulae;
    }

    public Long getCedulae() {
        return cedulae;
    }

    public void setCedulae(Long cedulae) {
        this.cedulae = cedulae;
    }

    public EmpPlanta getEmpPlanta() {
        return empPlanta;
    }

    public void setEmpPlanta(EmpPlanta empPlanta) {
        this.empPlanta = empPlanta;
    }

    @XmlTransient
    public List<Actualizacion> getActualizacionList() {
        return actualizacionList;
    }

    public void setActualizacionList(List<Actualizacion> actualizacionList) {
        this.actualizacionList = actualizacionList;
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
        if (!(object instanceof Subgerente)) {
            return false;
        }
        Subgerente other = (Subgerente) object;
        if ((this.cedulae == null && other.cedulae != null) || (this.cedulae != null && !this.cedulae.equals(other.cedulae))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.Subgerente[ cedulae=" + cedulae + " ]";
    }
    
}
