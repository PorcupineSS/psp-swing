/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jeisson Andrés Vergara
 */
@Entity
@Table(name = "V_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VEmpleado.findAll", query = "SELECT v FROM VEmpleado v"),
    @NamedQuery(name = "VEmpleado.findByCedula", query = "SELECT v FROM VEmpleado v WHERE v.cedula = :cedula"),
    @NamedQuery(name = "VEmpleado.findByCeduladir", query = "SELECT v FROM VEmpleado v WHERE v.ceduladir = :ceduladir"),
    @NamedQuery(name = "VEmpleado.findByNombreEmpleado", query = "SELECT v FROM VEmpleado v WHERE v.nombreEmpleado = :nombreEmpleado"),
    @NamedQuery(name = "VEmpleado.findByApellidoEmpleado", query = "SELECT v FROM VEmpleado v WHERE v.apellidoEmpleado = :apellidoEmpleado"),
    @NamedQuery(name = "VEmpleado.findByContraseniaEmpleado", query = "SELECT v FROM VEmpleado v WHERE v.contraseniaEmpleado = :contraseniaEmpleado"),
    @NamedQuery(name = "VEmpleado.findByCodigoEmpleado", query = "SELECT v FROM VEmpleado v WHERE v.codigoEmpleado = :codigoEmpleado"),
    @NamedQuery(name = "VEmpleado.findByFechaRegistro", query = "SELECT v FROM VEmpleado v WHERE v.fechaRegistro = :fechaRegistro")})
public class VEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private BigDecimal cedula;
    @Column(name = "CEDULADIR")
    private BigInteger ceduladir;
    @Basic(optional = false)
    @Column(name = "NOMBRE_EMPLEADO")
    private String nombreEmpleado;
    @Basic(optional = false)
    @Column(name = "APELLIDO_EMPLEADO")
    private String apellidoEmpleado;
    @Basic(optional = false)
    @Column(name = "CONTRASENIA_EMPLEADO")
    private String contraseniaEmpleado;
    @Basic(optional = false)
    @Column(name = "CODIGO_EMPLEADO")
    private String codigoEmpleado;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public VEmpleado() {
    }

    public VEmpleado(BigDecimal cedula) {
        this.cedula = cedula;
    }

    public VEmpleado(BigDecimal cedula, String nombreEmpleado, String apellidoEmpleado, String contraseniaEmpleado, String codigoEmpleado, Date fechaRegistro) {
        this.cedula = cedula;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.contraseniaEmpleado = contraseniaEmpleado;
        this.codigoEmpleado = codigoEmpleado;
        this.fechaRegistro = fechaRegistro;
    }

    public BigDecimal getCedula() {
        return cedula;
    }

    public void setCedula(BigDecimal cedula) {
        this.cedula = cedula;
    }

    public BigInteger getCeduladir() {
        return ceduladir;
    }

    public void setCeduladir(BigInteger ceduladir) {
        this.ceduladir = ceduladir;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getContraseniaEmpleado() {
        return contraseniaEmpleado;
    }

    public void setContraseniaEmpleado(String contraseniaEmpleado) {
        this.contraseniaEmpleado = contraseniaEmpleado;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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
        if (!(object instanceof VEmpleado)) {
            return false;
        }
        VEmpleado other = (VEmpleado) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VEmpleado[ cedula=" + cedula + " ]";
    }
    
}
