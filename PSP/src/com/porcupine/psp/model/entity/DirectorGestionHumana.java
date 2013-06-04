/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jeisson Andrés Vergara
 */
@Entity
@Table(name = "DIRECTOR_GESTION_HUMANA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DirectorGestionHumana.findAll", query = "SELECT d FROM DirectorGestionHumana d"),
    @NamedQuery(name = "DirectorGestionHumana.findByCedula", query = "SELECT d FROM DirectorGestionHumana d WHERE d.cedula = :cedula")})
public class DirectorGestionHumana implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private BigDecimal cedula;

    public DirectorGestionHumana() {
    }

    public DirectorGestionHumana(BigDecimal cedula) {
        this.cedula = cedula;
    }

    public BigDecimal getCedula() {
        return cedula;
    }

    public void setCedula(BigDecimal cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DirectorGestionHumana)) {
            return false;
        }
        DirectorGestionHumana other = (DirectorGestionHumana) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.DirectorGestionHumana[ cedula=" + cedula + " ]";
    }
    
}
