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
@Table(name = "V_CONTRATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VContrato.findAll", query = "SELECT v FROM VContrato v"),
    @NamedQuery(name = "VContrato.findByIdContrato", query = "SELECT v FROM VContrato v WHERE v.idContrato = :idContrato"),
    @NamedQuery(name = "VContrato.findByIdCliente", query = "SELECT v FROM VContrato v WHERE v.idCliente = :idCliente"),
    @NamedQuery(name = "VContrato.findByCedula", query = "SELECT v FROM VContrato v WHERE v.cedula = :cedula"),
    @NamedQuery(name = "VContrato.findByUbicacion", query = "SELECT v FROM VContrato v WHERE v.ubicacion = :ubicacion"),
    @NamedQuery(name = "VContrato.findByTelefono", query = "SELECT v FROM VContrato v WHERE v.telefono = :telefono"),
    @NamedQuery(name = "VContrato.findByCelular", query = "SELECT v FROM VContrato v WHERE v.celular = :celular"),
    @NamedQuery(name = "VContrato.findByTipoContrato", query = "SELECT v FROM VContrato v WHERE v.tipoContrato = :tipoContrato"),
    @NamedQuery(name = "VContrato.findByFechaInicio", query = "SELECT v FROM VContrato v WHERE v.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "VContrato.findByTipoPersonal", query = "SELECT v FROM VContrato v WHERE v.tipoPersonal = :tipoPersonal"),
    @NamedQuery(name = "VContrato.findByCantidadPersonal", query = "SELECT v FROM VContrato v WHERE v.cantidadPersonal = :cantidadPersonal"),
    @NamedQuery(name = "VContrato.findByCostoMensual", query = "SELECT v FROM VContrato v WHERE v.costoMensual = :costoMensual"),
    @NamedQuery(name = "VContrato.findByHorarioContrato", query = "SELECT v FROM VContrato v WHERE v.horarioContrato = :horarioContrato"),
    @NamedQuery(name = "VContrato.findByTiempo", query = "SELECT v FROM VContrato v WHERE v.tiempo = :tiempo"),
    @NamedQuery(name = "VContrato.findByFechaRegistroContrato", query = "SELECT v FROM VContrato v WHERE v.fechaRegistroContrato = :fechaRegistroContrato")})
public class VContrato implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONTRATO")
    private BigDecimal idContrato;
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private BigInteger cedula;
    @Basic(optional = false)
    @Column(name = "UBICACION")
    private String ubicacion;
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    private BigInteger telefono;
    @Basic(optional = false)
    @Column(name = "CELULAR")
    private BigInteger celular;
    @Basic(optional = false)
    @Column(name = "TIPO_CONTRATO")
    private String tipoContrato;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "TIPO_PERSONAL")
    private String tipoPersonal;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_PERSONAL")
    private BigInteger cantidadPersonal;
    @Basic(optional = false)
    @Column(name = "COSTO_MENSUAL")
    private BigDecimal costoMensual;
    @Basic(optional = false)
    @Column(name = "HORARIO_CONTRATO")
    private String horarioContrato;
    @Column(name = "TIEMPO")
    private BigInteger tiempo;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO_CONTRATO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistroContrato;

    public VContrato() {
    }

    public VContrato(BigDecimal idContrato) {
        this.idContrato = idContrato;
    }

    public VContrato(BigDecimal idContrato, BigInteger idCliente, BigInteger cedula, String ubicacion, BigInteger telefono, BigInteger celular, String tipoContrato, Date fechaInicio, String tipoPersonal, BigInteger cantidadPersonal, BigDecimal costoMensual, String horarioContrato, Date fechaRegistroContrato) {
        this.idContrato = idContrato;
        this.idCliente = idCliente;
        this.cedula = cedula;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.celular = celular;
        this.tipoContrato = tipoContrato;
        this.fechaInicio = fechaInicio;
        this.tipoPersonal = tipoPersonal;
        this.cantidadPersonal = cantidadPersonal;
        this.costoMensual = costoMensual;
        this.horarioContrato = horarioContrato;
        this.fechaRegistroContrato = fechaRegistroContrato;
    }

    public BigDecimal getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(BigDecimal idContrato) {
        this.idContrato = idContrato;
    }

    public BigInteger getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigInteger idCliente) {
        this.idCliente = idCliente;
    }

    public BigInteger getCedula() {
        return cedula;
    }

    public void setCedula(BigInteger cedula) {
        this.cedula = cedula;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public BigInteger getCelular() {
        return celular;
    }

    public void setCelular(BigInteger celular) {
        this.celular = celular;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTipoPersonal() {
        return tipoPersonal;
    }

    public void setTipoPersonal(String tipoPersonal) {
        this.tipoPersonal = tipoPersonal;
    }

    public BigInteger getCantidadPersonal() {
        return cantidadPersonal;
    }

    public void setCantidadPersonal(BigInteger cantidadPersonal) {
        this.cantidadPersonal = cantidadPersonal;
    }

    public BigDecimal getCostoMensual() {
        return costoMensual;
    }

    public void setCostoMensual(BigDecimal costoMensual) {
        this.costoMensual = costoMensual;
    }

    public String getHorarioContrato() {
        return horarioContrato;
    }

    public void setHorarioContrato(String horarioContrato) {
        this.horarioContrato = horarioContrato;
    }

    public BigInteger getTiempo() {
        return tiempo;
    }

    public void setTiempo(BigInteger tiempo) {
        this.tiempo = tiempo;
    }

    public Date getFechaRegistroContrato() {
        return fechaRegistroContrato;
    }

    public void setFechaRegistroContrato(Date fechaRegistroContrato) {
        this.fechaRegistroContrato = fechaRegistroContrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContrato != null ? idContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VContrato)) {
            return false;
        }
        VContrato other = (VContrato) object;
        if ((this.idContrato == null && other.idContrato != null) || (this.idContrato != null && !this.idContrato.equals(other.idContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.VContrato[ idContrato=" + idContrato + " ]";
    }
    
}
