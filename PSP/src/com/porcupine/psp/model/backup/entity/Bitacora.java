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
@Table(name = "BITACORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bitacora.findAll", query = "SELECT b FROM Bitacora b"),
    @NamedQuery(name = "Bitacora.findByIdOperacion", query = "SELECT b FROM Bitacora b WHERE b.idOperacion = :idOperacion"),
    @NamedQuery(name = "Bitacora.findByCedula", query = "SELECT b FROM Bitacora b WHERE b.cedula = :cedula"),
    @NamedQuery(name = "Bitacora.findByFechaOperacion", query = "SELECT b FROM Bitacora b WHERE b.fechaOperacion = :fechaOperacion"),
    @NamedQuery(name = "Bitacora.findByUsuarioOperacion", query = "SELECT b FROM Bitacora b WHERE b.usuarioOperacion = :usuarioOperacion"),
    @NamedQuery(name = "Bitacora.findByMaquinaOperacion", query = "SELECT b FROM Bitacora b WHERE b.maquinaOperacion = :maquinaOperacion"),
    @NamedQuery(name = "Bitacora.findByTablaModificada", query = "SELECT b FROM Bitacora b WHERE b.tablaModificada = :tablaModificada"),
    @NamedQuery(name = "Bitacora.findByTipoOperacion", query = "SELECT b FROM Bitacora b WHERE b.tipoOperacion = :tipoOperacion")})
public class Bitacora implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_OPERACION")
    private BigDecimal idOperacion;
    @Column(name = "CEDULA")
    private BigInteger cedula;
    @Basic(optional = false)
    @Column(name = "FECHA_OPERACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOperacion;
    @Column(name = "USUARIO_OPERACION")
    private String usuarioOperacion;
    @Column(name = "MAQUINA_OPERACION")
    private String maquinaOperacion;
    @Basic(optional = false)
    @Column(name = "TABLA_MODIFICADA")
    private String tablaModificada;
    @Basic(optional = false)
    @Column(name = "TIPO_OPERACION")
    private String tipoOperacion;

    public Bitacora() {
    }

    public Bitacora(BigDecimal idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Bitacora(BigDecimal idOperacion, Date fechaOperacion, String tablaModificada, String tipoOperacion) {
        this.idOperacion = idOperacion;
        this.fechaOperacion = fechaOperacion;
        this.tablaModificada = tablaModificada;
        this.tipoOperacion = tipoOperacion;
    }

    public BigDecimal getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(BigDecimal idOperacion) {
        this.idOperacion = idOperacion;
    }

    public BigInteger getCedula() {
        return cedula;
    }

    public void setCedula(BigInteger cedula) {
        this.cedula = cedula;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public String getUsuarioOperacion() {
        return usuarioOperacion;
    }

    public void setUsuarioOperacion(String usuarioOperacion) {
        this.usuarioOperacion = usuarioOperacion;
    }

    public String getMaquinaOperacion() {
        return maquinaOperacion;
    }

    public void setMaquinaOperacion(String maquinaOperacion) {
        this.maquinaOperacion = maquinaOperacion;
    }

    public String getTablaModificada() {
        return tablaModificada;
    }

    public void setTablaModificada(String tablaModificada) {
        this.tablaModificada = tablaModificada;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacion != null ? idOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacora)) {
            return false;
        }
        Bitacora other = (Bitacora) object;
        if ((this.idOperacion == null && other.idOperacion != null) || (this.idOperacion != null && !this.idOperacion.equals(other.idOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.Bitacora[ idOperacion=" + idOperacion + " ]";
    }
    
}
