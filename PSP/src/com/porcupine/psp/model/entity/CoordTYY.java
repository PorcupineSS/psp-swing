/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

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
    private Integer cedulae;

    public CoordTYY() {
    }

    public CoordTYY(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public Integer getCedulae() {
        return cedulae;
    }

    public void setCedulae(Integer cedulae) {
        this.cedulae = cedulae;
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
