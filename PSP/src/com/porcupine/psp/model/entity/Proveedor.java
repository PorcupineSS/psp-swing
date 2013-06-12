/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByIdPro", query = "SELECT p FROM Proveedor p WHERE p.idPro = :idPro"),
    @NamedQuery(name = "Proveedor.findByNombre", query = "SELECT p FROM Proveedor p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proveedor.findByDireccion", query = "SELECT p FROM Proveedor p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Proveedor.findByFechaRegProv", query = "SELECT p FROM Proveedor p WHERE p.fechaRegProv = :fechaRegProv")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRO")
    private Short idPro;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "FECHA_REG_PROV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegProv;
    @OneToMany(mappedBy = "idPro")
    private Collection<ImplSeguridad> implSeguridadCollection;
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE")
    @ManyToOne(optional = false)
    private CoordTYT cedulae;
    @OneToMany(mappedBy = "idPro")
    private Collection<TelsProv> telsProvCollection;

    public Proveedor() {
    }

    public Proveedor(Short idPro) {
        this.idPro = idPro;
    }

    public Proveedor(Short idPro, String nombre, String direccion, Date fechaRegProv) {
        this.idPro = idPro;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaRegProv = fechaRegProv;
    }

    public Short getIdPro() {
        return idPro;
    }

    public void setIdPro(Short idPro) {
        this.idPro = idPro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaRegProv() {
        return fechaRegProv;
    }

    public void setFechaRegProv(Date fechaRegProv) {
        this.fechaRegProv = fechaRegProv;
    }

    @XmlTransient
    public Collection<ImplSeguridad> getImplSeguridadCollection() {
        return implSeguridadCollection;
    }

    public void setImplSeguridadCollection(Collection<ImplSeguridad> implSeguridadCollection) {
        this.implSeguridadCollection = implSeguridadCollection;
    }

    public CoordTYT getCedulae() {
        return cedulae;
    }

    public void setCedulae(CoordTYT cedulae) {
        this.cedulae = cedulae;
    }

    @XmlTransient
    public Collection<TelsProv> getTelsProvCollection() {
        return telsProvCollection;
    }

    public void setTelsProvCollection(Collection<TelsProv> telsProvCollection) {
        this.telsProvCollection = telsProvCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPro != null ? idPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idPro == null && other.idPro != null) || (this.idPro != null && !this.idPro.equals(other.idPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.Proveedor[ idPro=" + idPro + " ]";
    }
    
}
