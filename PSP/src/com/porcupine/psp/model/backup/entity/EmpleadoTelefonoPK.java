/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jeisson Andrés Vergara
 */
@Embeddable
public class EmpleadoTelefonoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private BigInteger cedula;
    @Basic(optional = false)
    @Column(name = "ID_TELEFONO_EMPLEADO")
    private BigInteger idTelefonoEmpleado;

    public EmpleadoTelefonoPK() {
    }

    public EmpleadoTelefonoPK(BigInteger cedula, BigInteger idTelefonoEmpleado) {
        this.cedula = cedula;
        this.idTelefonoEmpleado = idTelefonoEmpleado;
    }

    public BigInteger getCedula() {
        return cedula;
    }

    public void setCedula(BigInteger cedula) {
        this.cedula = cedula;
    }

    public BigInteger getIdTelefonoEmpleado() {
        return idTelefonoEmpleado;
    }

    public void setIdTelefonoEmpleado(BigInteger idTelefonoEmpleado) {
        this.idTelefonoEmpleado = idTelefonoEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        hash += (idTelefonoEmpleado != null ? idTelefonoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoTelefonoPK)) {
            return false;
        }
        EmpleadoTelefonoPK other = (EmpleadoTelefonoPK) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        if ((this.idTelefonoEmpleado == null && other.idTelefonoEmpleado != null) || (this.idTelefonoEmpleado != null && !this.idTelefonoEmpleado.equals(other.idTelefonoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.EmpleadoTelefonoPK[ cedula=" + cedula + ", idTelefonoEmpleado=" + idTelefonoEmpleado + " ]";
    }
    
}
