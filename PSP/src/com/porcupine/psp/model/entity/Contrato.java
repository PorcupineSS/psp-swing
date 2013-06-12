/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "CONTRATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c"),
    @NamedQuery(name = "Contrato.findByIdContrato", query = "SELECT c FROM Contrato c WHERE c.idContrato = :idContrato"),
    @NamedQuery(name = "Contrato.findByUbicacionC", query = "SELECT c FROM Contrato c WHERE c.ubicacionC = :ubicacionC"),
    @NamedQuery(name = "Contrato.findByTelefonoC", query = "SELECT c FROM Contrato c WHERE c.telefonoC = :telefonoC"),
    @NamedQuery(name = "Contrato.findByCelularC", query = "SELECT c FROM Contrato c WHERE c.celularC = :celularC"),
    @NamedQuery(name = "Contrato.findByTipoC", query = "SELECT c FROM Contrato c WHERE c.tipoC = :tipoC"),
    @NamedQuery(name = "Contrato.findByFechaInicioC", query = "SELECT c FROM Contrato c WHERE c.fechaInicioC = :fechaInicioC"),
    @NamedQuery(name = "Contrato.findByTipoPersonalC", query = "SELECT c FROM Contrato c WHERE c.tipoPersonalC = :tipoPersonalC"),
    @NamedQuery(name = "Contrato.findByCantidadPersonalC", query = "SELECT c FROM Contrato c WHERE c.cantidadPersonalC = :cantidadPersonalC"),
    @NamedQuery(name = "Contrato.findByCostoMensualC", query = "SELECT c FROM Contrato c WHERE c.costoMensualC = :costoMensualC"),
    @NamedQuery(name = "Contrato.findByHorarioC", query = "SELECT c FROM Contrato c WHERE c.horarioC = :horarioC"),
    @NamedQuery(name = "Contrato.findByTiempoC", query = "SELECT c FROM Contrato c WHERE c.tiempoC = :tiempoC"),
    @NamedQuery(name = "Contrato.findByFechaRegCon", query = "SELECT c FROM Contrato c WHERE c.fechaRegCon = :fechaRegCon")})
public class Contrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONTRATO")
    private Short idContrato;
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
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE")
    @ManyToOne(optional = false)
    private DirComercial cedulae;
    @JoinColumn(name = "IDCL", referencedColumnName = "IDCL")
    @ManyToOne(optional = false)
    private Cliente idcl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContrato")
    private List<AsignacionC> asignacionCList;

    public Contrato() {
    }

    public Contrato(Short idContrato) {
        this.idContrato = idContrato;
    }

    public Contrato(Short idContrato, String ubicacionC, String telefonoC, String celularC, String tipoC, Date fechaInicioC, String tipoPersonalC, short cantidadPersonalC, BigDecimal costoMensualC, String horarioC, Date fechaRegCon) {
        this.idContrato = idContrato;
        this.ubicacionC = ubicacionC;
        this.telefonoC = telefonoC;
        this.celularC = celularC;
        this.tipoC = tipoC;
        this.fechaInicioC = fechaInicioC;
        this.tipoPersonalC = tipoPersonalC;
        this.cantidadPersonalC = cantidadPersonalC;
        this.costoMensualC = costoMensualC;
        this.horarioC = horarioC;
        this.fechaRegCon = fechaRegCon;
    }

    public Short getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Short idContrato) {
        this.idContrato = idContrato;
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

    public DirComercial getCedulae() {
        return cedulae;
    }

    public void setCedulae(DirComercial cedulae) {
        this.cedulae = cedulae;
    }

    public Cliente getIdcl() {
        return idcl;
    }

    public void setIdcl(Cliente idcl) {
        this.idcl = idcl;
    }

    @XmlTransient
    public List<AsignacionC> getAsignacionCList() {
        return asignacionCList;
    }

    public void setAsignacionCList(List<AsignacionC> asignacionCList) {
        this.asignacionCList = asignacionCList;
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
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.idContrato == null && other.idContrato != null) || (this.idContrato != null && !this.idContrato.equals(other.idContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.Contrato[ idContrato=" + idContrato + " ]";
    }
    
}
