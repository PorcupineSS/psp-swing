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
@Table(name = "V_COMUNICADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VComunicado.findAll", query = "SELECT v FROM VComunicado v"),
    @NamedQuery(name = "VComunicado.findByIdComunicado", query = "SELECT v FROM VComunicado v WHERE v.idComunicado = :idComunicado"),
    @NamedQuery(name = "VComunicado.findByCedulaet", query = "SELECT v FROM VComunicado v WHERE v.cedulaet = :cedulaet"),
    @NamedQuery(name = "VComunicado.findByCedulado", query = "SELECT v FROM VComunicado v WHERE v.cedulado = :cedulado"),
    @NamedQuery(name = "VComunicado.findByTipoComunicado", query = "SELECT v FROM VComunicado v WHERE v.tipoComunicado = :tipoComunicado"),
    @NamedQuery(name = "VComunicado.findByFechaComunicado", query = "SELECT v FROM VComunicado v WHERE v.fechaComunicado = :fechaComunicado"),
    @NamedQuery(name = "VComunicado.findByContenidoComunicado", query = "SELECT v FROM VComunicado v WHERE v.contenidoComunicado = :contenidoComunicado"),
    @NamedQuery(name = "VComunicado.findByUrgente", query = "SELECT v FROM VComunicado v WHERE v.urgente = :urgente"),
    @NamedQuery(name = "VComunicado.findByRespuestaComunicado", query = "SELECT v FROM VComunicado v WHERE v.respuestaComunicado = :respuestaComunicado")})
public class VComunicado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_COMUNICADO")
    private BigDecimal idComunicado;
    @Column(name = "CEDULAET")
    private BigInteger cedulaet;
    @Column(name = "CEDULADO")
    private BigInteger cedulado;
    @Basic(optional = false)
    @Column(name = "TIPO_COMUNICADO")
    private String tipoComunicado;
    @Basic(optional = false)
    @Column(name = "FECHA_COMUNICADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaComunicado;
    @Basic(optional = false)
    @Column(name = "CONTENIDO_COMUNICADO")
    private String contenidoComunicado;
    @Basic(optional = false)
    @Column(name = "URGENTE")
    private BigInteger urgente;
    @Column(name = "RESPUESTA_COMUNICADO")
    private String respuestaComunicado;

    public VComunicado() {
    }

    public VComunicado(BigDecimal idComunicado) {
        this.idComunicado = idComunicado;
    }

    public VComunicado(BigDecimal idComunicado, String tipoComunicado, Date fechaComunicado, String contenidoComunicado, BigInteger urgente) {
        this.idComunicado = idComunicado;
        this.tipoComunicado = tipoComunicado;
        this.fechaComunicado = fechaComunicado;
        this.contenidoComunicado = contenidoComunicado;
        this.urgente = urgente;
    }

    public BigDecimal getIdComunicado() {
        return idComunicado;
    }

    public void setIdComunicado(BigDecimal idComunicado) {
        this.idComunicado = idComunicado;
    }

    public BigInteger getCedulaet() {
        return cedulaet;
    }

    public void setCedulaet(BigInteger cedulaet) {
        this.cedulaet = cedulaet;
    }

    public BigInteger getCedulado() {
        return cedulado;
    }

    public void setCedulado(BigInteger cedulado) {
        this.cedulado = cedulado;
    }

    public String getTipoComunicado() {
        return tipoComunicado;
    }

    public void setTipoComunicado(String tipoComunicado) {
        this.tipoComunicado = tipoComunicado;
    }

    public Date getFechaComunicado() {
        return fechaComunicado;
    }

    public void setFechaComunicado(Date fechaComunicado) {
        this.fechaComunicado = fechaComunicado;
    }

    public String getContenidoComunicado() {
        return contenidoComunicado;
    }

    public void setContenidoComunicado(String contenidoComunicado) {
        this.contenidoComunicado = contenidoComunicado;
    }

    public BigInteger getUrgente() {
        return urgente;
    }

    public void setUrgente(BigInteger urgente) {
        this.urgente = urgente;
    }

    public String getRespuestaComunicado() {
        return respuestaComunicado;
    }

    public void setRespuestaComunicado(String respuestaComunicado) {
        this.respuestaComunicado = respuestaComunicado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComunicado != null ? idComunicado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VComunicado)) {
            return false;
        }
        VComunicado other = (VComunicado) object;
        if ((this.idComunicado == null && other.idComunicado != null) || (this.idComunicado != null && !this.idComunicado.equals(other.idComunicado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VComunicado[ idComunicado=" + idComunicado + " ]";
    }
    
}
