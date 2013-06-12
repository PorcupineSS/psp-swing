/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jeisson Andrés Vergara
 */
@Entity
@Table(name = "EMPLEADO_TELEFONO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoTelefono.findAll", query = "SELECT e FROM EmpleadoTelefono e"),
    @NamedQuery(name = "EmpleadoTelefono.findByCedula", query = "SELECT e FROM EmpleadoTelefono e WHERE e.empleadoTelefonoPK.cedula = :cedula"),
    @NamedQuery(name = "EmpleadoTelefono.findByIdTelefonoEmpleado", query = "SELECT e FROM EmpleadoTelefono e WHERE e.empleadoTelefonoPK.idTelefonoEmpleado = :idTelefonoEmpleado")})
public class EmpleadoTelefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoTelefonoPK empleadoTelefonoPK;

    public EmpleadoTelefono() {
    }

    public EmpleadoTelefono(EmpleadoTelefonoPK empleadoTelefonoPK) {
        this.empleadoTelefonoPK = empleadoTelefonoPK;
    }

    public EmpleadoTelefono(BigInteger cedula, BigInteger idTelefonoEmpleado) {
        this.empleadoTelefonoPK = new EmpleadoTelefonoPK(cedula, idTelefonoEmpleado);
    }

    public EmpleadoTelefonoPK getEmpleadoTelefonoPK() {
        return empleadoTelefonoPK;
    }

    public void setEmpleadoTelefonoPK(EmpleadoTelefonoPK empleadoTelefonoPK) {
        this.empleadoTelefonoPK = empleadoTelefonoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoTelefonoPK != null ? empleadoTelefonoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoTelefono)) {
            return false;
        }
        EmpleadoTelefono other = (EmpleadoTelefono) object;
        if ((this.empleadoTelefonoPK == null && other.empleadoTelefonoPK != null) || (this.empleadoTelefonoPK != null && !this.empleadoTelefonoPK.equals(other.empleadoTelefonoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.EmpleadoTelefono[ empleadoTelefonoPK=" + empleadoTelefonoPK + " ]";
    }
    
}
