/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "V_CONT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VCont.findAll", query = "SELECT v FROM VCont v"),
    @NamedQuery(name = "VCont.findByIdcl", query = "SELECT v FROM VCont v WHERE v.idcl = :idcl"),
    @NamedQuery(name = "VCont.findByCedulae", query = "SELECT v FROM VCont v WHERE v.cedulae = :cedulae"),
    @NamedQuery(name = "VCont.findByUbicacionC", query = "SELECT v FROM VCont v WHERE v.ubicacionC = :ubicacionC"),
    @NamedQuery(name = "VCont.findByTelefonoC", query = "SELECT v FROM VCont v WHERE v.telefonoC = :telefonoC"),
    @NamedQuery(name = "VCont.findByCelularC", query = "SELECT v FROM VCont v WHERE v.celularC = :celularC"),
    @NamedQuery(name = "VCont.findByTipoC", query = "SELECT v FROM VCont v WHERE v.tipoC = :tipoC"),
    @NamedQuery(name = "VCont.findByFechaInicioC", query = "SELECT v FROM VCont v WHERE v.fechaInicioC = :fechaInicioC"),
    @NamedQuery(name = "VCont.findByTipoPersonalC", query = "SELECT v FROM VCont v WHERE v.tipoPersonalC = :tipoPersonalC"),
    @NamedQuery(name = "VCont.findByCantidadPersonalC", query = "SELECT v FROM VCont v WHERE v.cantidadPersonalC = :cantidadPersonalC"),
    @NamedQuery(name = "VCont.findByCostoMensualC", query = "SELECT v FROM VCont v WHERE v.costoMensualC = :costoMensualC"),
    @NamedQuery(name = "VCont.findByHorarioC", query = "SELECT v FROM VCont v WHERE v.horarioC = :horarioC"),
    @NamedQuery(name = "VCont.findByTiempoC", query = "SELECT v FROM VCont v WHERE v.tiempoC = :tiempoC"),
    @NamedQuery(name = "VCont.findByFechaRegCon", query = "SELECT v FROM VCont v WHERE v.fechaRegCon = :fechaRegCon")})
public class VCont implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDCL")
    private short idcl;
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private int cedulae;
    @Basic(optional = false)
    @Column(name = "UBICACION_C")
    private String ubicacionC;
    @Basic(optional = false)
    @Column(name = "TELEFONO_C")
    private String telefonoC;
    @Basic(optional = false)
    @Column(name = "CELULAR_C")
    private String celularC;
    @Basic(optional = false)
    @Column(name = "TIPO_C")
    private String tipoC;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioC;
    @Basic(optional = false)
    @Column(name = "TIPO_PERSONAL_C")
    private String tipoPersonalC;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_PERSONAL_C")
    private short cantidadPersonalC;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "COSTO_MENSUAL_C")
    private BigDecimal costoMensualC;
    @Basic(optional = false)
    @Column(name = "HORARIO_C")
    private String horarioC;
    @Column(name = "TIEMPO_C")
    private Integer tiempoC;
    @Basic(optional = false)
    @Column(name = "FECHA_REG_CON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegCon;

    public VCont() {
    }

    public short getIdcl() {
        return idcl;
    }

    public void setIdcl(short idcl) {
        this.idcl = idcl;
    }

    public int getCedulae() {
        return cedulae;
    }

    public void setCedulae(int cedulae) {
        this.cedulae = cedulae;
    }

    public String getUbicacionC() {
        return ubicacionC;
    }

    public void setUbicacionC(String ubicacionC) {
        this.ubicacionC = ubicacionC;
    }

    public String getTelefonoC() {
        return telefonoC;
    }

    public void setTelefonoC(String telefonoC) {
        this.telefonoC = telefonoC;
    }

    public String getCelularC() {
        return celularC;
    }

    public void setCelularC(String celularC) {
        this.celularC = celularC;
    }

    public String getTipoC() {
        return tipoC;
    }

    public void setTipoC(String tipoC) {
        this.tipoC = tipoC;
    }

    public Date getFechaInicioC() {
        return fechaInicioC;
    }

    public void setFechaInicioC(Date fechaInicioC) {
        this.fechaInicioC = fechaInicioC;
    }

    public String getTipoPersonalC() {
        return tipoPersonalC;
    }

    public void setTipoPersonalC(String tipoPersonalC) {
        this.tipoPersonalC = tipoPersonalC;
    }

    public short getCantidadPersonalC() {
        return cantidadPersonalC;
    }

    public void setCantidadPersonalC(short cantidadPersonalC) {
        this.cantidadPersonalC = cantidadPersonalC;
    }

    public BigDecimal getCostoMensualC() {
        return costoMensualC;
    }

    public void setCostoMensualC(BigDecimal costoMensualC) {
        this.costoMensualC = costoMensualC;
    }

    public String getHorarioC() {
        return horarioC;
    }

    public void setHorarioC(String horarioC) {
        this.horarioC = horarioC;
    }

    public Integer getTiempoC() {
        return tiempoC;
    }

    public void setTiempoC(Integer tiempoC) {
        this.tiempoC = tiempoC;
    }

    public Date getFechaRegCon() {
        return fechaRegCon;
    }

    public void setFechaRegCon(Date fechaRegCon) {
        this.fechaRegCon = fechaRegCon;
    }
    
}
