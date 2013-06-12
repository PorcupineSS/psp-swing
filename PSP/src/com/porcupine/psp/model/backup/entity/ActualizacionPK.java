/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Zergio
 */
@Embeddable
public class ActualizacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "SUB_CEDULAE")
    private long subCedulae;
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private long cedulae;

    public ActualizacionPK() {
    }

    public ActualizacionPK(long subCedulae, long cedulae) {
        this.subCedulae = subCedulae;
        this.cedulae = cedulae;
    }

    public long getSubCedulae() {
        return subCedulae;
    }

    public void setSubCedulae(long subCedulae) {
        this.subCedulae = subCedulae;
    }

    public long getCedulae() {
        return cedulae;
    }

    public void setCedulae(long cedulae) {
        this.cedulae = cedulae;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) subCedulae;
        hash += (int) cedulae;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActualizacionPK)) {
            return false;
        }
        ActualizacionPK other = (ActualizacionPK) object;
        if (this.subCedulae != other.subCedulae) {
            return false;
        }
        if (this.cedulae != other.cedulae) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.ActualizacionPK[ subCedulae=" + subCedulae + ", cedulae=" + cedulae + " ]";
    }
    
}
