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
@Table(name = "DIR_COMERCIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DirComercial.findAll", query = "SELECT d FROM DirComercial d"),
    @NamedQuery(name = "DirComercial.findByCedulae", query = "SELECT d FROM DirComercial d WHERE d.cedulae = :cedulae")})
public class DirComercial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private Integer cedulae;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulae")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulae")
    private Collection<Contrato> contratoCollection;
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private EmpPlanta empPlanta;

    public DirComercial() {
    }

    public DirComercial(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public Integer getCedulae() {
        return cedulae;
    }

    public void setCedulae(Integer cedulae) {
        this.cedulae = cedulae;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Contrato> getContratoCollection() {
        return contratoCollection;
    }

    public void setContratoCollection(Collection<Contrato> contratoCollection) {
        this.contratoCollection = contratoCollection;
    }

    public EmpPlanta getEmpPlanta() {
        return empPlanta;
    }

    public void setEmpPlanta(EmpPlanta empPlanta) {
        this.empPlanta = empPlanta;
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
        if (!(object instanceof DirComercial)) {
            return false;
        }
        DirComercial other = (DirComercial) object;
        if ((this.cedulae == null && other.cedulae != null) || (this.cedulae != null && !this.cedulae.equals(other.cedulae))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.DirComercial[ cedulae=" + cedulae + " ]";
    }
    
}
