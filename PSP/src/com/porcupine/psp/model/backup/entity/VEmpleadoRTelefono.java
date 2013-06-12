/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "V_EMPLEADO_R_TELEFONO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VEmpleadoRTelefono.findAll", query = "SELECT v FROM VEmpleadoRTelefono v"),
    @NamedQuery(name = "VEmpleadoRTelefono.findByCedula", query = "SELECT v FROM VEmpleadoRTelefono v WHERE v.cedula = :cedula"),
    @NamedQuery(name = "VEmpleadoRTelefono.findByIdTelefonoEmpleado", query = "SELECT v FROM VEmpleadoRTelefono v WHERE v.idTelefonoEmpleado = :idTelefonoEmpleado")})
public class VEmpleadoRTelefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private BigInteger cedula;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TELEFONO_EMPLEADO")
    private BigInteger idTelefonoEmpleado;

    public VEmpleadoRTelefono() {
    }

    public VEmpleadoRTelefono(BigInteger idTelefonoEmpleado) {
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
        hash += (idTelefonoEmpleado != null ? idTelefonoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VEmpleadoRTelefono)) {
            return false;
        }
        VEmpleadoRTelefono other = (VEmpleadoRTelefono) object;
        if ((this.idTelefonoEmpleado == null && other.idTelefonoEmpleado != null) || (this.idTelefonoEmpleado != null && !this.idTelefonoEmpleado.equals(other.idTelefonoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VEmpleadoRTelefono[ idTelefonoEmpleado=" + idTelefonoEmpleado + " ]";
    }
    
}
