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
@Table(name = "V_PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VProveedor.findAll", query = "SELECT v FROM VProveedor v"),
    @NamedQuery(name = "VProveedor.findByIdProveedor", query = "SELECT v FROM VProveedor v WHERE v.idProveedor = :idProveedor"),
    @NamedQuery(name = "VProveedor.findByCedula", query = "SELECT v FROM VProveedor v WHERE v.cedula = :cedula"),
    @NamedQuery(name = "VProveedor.findByNombreProveedor", query = "SELECT v FROM VProveedor v WHERE v.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "VProveedor.findByDireccionProveedor", query = "SELECT v FROM VProveedor v WHERE v.direccionProveedor = :direccionProveedor"),
    @NamedQuery(name = "VProveedor.findByFechaRegistroProveedor", query = "SELECT v FROM VProveedor v WHERE v.fechaRegistroProveedor = :fechaRegistroProveedor")})
public class VProveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PROVEEDOR")
    private BigDecimal idProveedor;
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private BigInteger cedula;
    @Basic(optional = false)
    @Column(name = "NOMBRE_PROVEEDOR")
    private String nombreProveedor;
    @Basic(optional = false)
    @Column(name = "DIRECCION_PROVEEDOR")
    private String direccionProveedor;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO_PROVEEDOR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistroProveedor;

    public VProveedor() {
    }

    public VProveedor(BigDecimal idProveedor) {
        this.idProveedor = idProveedor;
    }

    public VProveedor(BigDecimal idProveedor, BigInteger cedula, String nombreProveedor, String direccionProveedor, Date fechaRegistroProveedor) {
        this.idProveedor = idProveedor;
        this.cedula = cedula;
        this.nombreProveedor = nombreProveedor;
        this.direccionProveedor = direccionProveedor;
        this.fechaRegistroProveedor = fechaRegistroProveedor;
    }

    public BigDecimal getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(BigDecimal idProveedor) {
        this.idProveedor = idProveedor;
    }

    public BigInteger getCedula() {
        return cedula;
    }

    public void setCedula(BigInteger cedula) {
        this.cedula = cedula;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public Date getFechaRegistroProveedor() {
        return fechaRegistroProveedor;
    }

    public void setFechaRegistroProveedor(Date fechaRegistroProveedor) {
        this.fechaRegistroProveedor = fechaRegistroProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VProveedor)) {
            return false;
        }
        VProveedor other = (VProveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VProveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}
