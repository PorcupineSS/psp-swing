/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ASIGNACION_C")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionC.findAll", query = "SELECT a FROM AsignacionC a"),
    @NamedQuery(name = "AsignacionC.findByIdAsig", query = "SELECT a FROM AsignacionC a WHERE a.idAsig = :idAsig"),
    @NamedQuery(name = "AsignacionC.findByCedulae", query = "SELECT a FROM AsignacionC a WHERE a.cedulae = :cedulae"),
    @NamedQuery(name = "AsignacionC.findByFechaAsignacionC", query = "SELECT a FROM AsignacionC a WHERE a.fechaAsignacionC = :fechaAsignacionC"),
    @NamedQuery(name = "AsignacionC.findByHorarioAsignado", query = "SELECT a FROM AsignacionC a WHERE a.horarioAsignado = :horarioAsignado")})
public class AsignacionC implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "ID_ASIG")
    private Short idAsig;
    @Column(name = "CEDULAE")
    private BigInteger cedulae;
    @Basic(optional = false)
    @Column(name = "FECHA_ASIGNACION_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacionC;
    @Basic(optional = false)
    @Column(name = "HORARIO_ASIGNADO")
    private String horarioAsignado;
    @OneToMany(mappedBy = "idAsig")
    private List<EmTemp> emTempList;
    @JoinColumn(name = "COO_CEDULAE", referencedColumnName = "CEDULAE")
    @ManyToOne
    private CoordContrato cooCedulae;
    @JoinColumn(name = "ID_CONTRATO", referencedColumnName = "ID_CONTRATO")
    @ManyToOne
    private Contrato idContrato;

    public AsignacionC() {
    }

    public AsignacionC(Short idAsig) {
        this.idAsig = idAsig;
    }

    public AsignacionC(Short idAsig, Date fechaAsignacionC, String horarioAsignado) {
        this.idAsig = idAsig;
        this.fechaAsignacionC = fechaAsignacionC;
        this.horarioAsignado = horarioAsignado;
    }

    public Short getIdAsig() {
        return idAsig;
    }

    public void setIdAsig(Short idAsig) {
        this.idAsig = idAsig;
    }

    public BigInteger getCedulae() {
        return cedulae;
    }

    public void setCedulae(BigInteger cedulae) {
        this.cedulae = cedulae;
    }

    public Date getFechaAsignacionC() {
        return fechaAsignacionC;
    }

    public void setFechaAsignacionC(Date fechaAsignacionC) {
        this.fechaAsignacionC = fechaAsignacionC;
    }

    public String getHorarioAsignado() {
        return horarioAsignado;
    }

    public void setHorarioAsignado(String horarioAsignado) {
        this.horarioAsignado = horarioAsignado;
    }

    @XmlTransient
    public List<EmTemp> getEmTempList() {
        return emTempList;
    }

    public void setEmTempList(List<EmTemp> emTempList) {
        this.emTempList = emTempList;
    }

    public CoordContrato getCooCedulae() {
        return cooCedulae;
    }

    public void setCooCedulae(CoordContrato cooCedulae) {
        this.cooCedulae = cooCedulae;
    }

    public Contrato getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Contrato idContrato) {
        this.idContrato = idContrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsig != null ? idAsig.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionC)) {
            return false;
        }
        AsignacionC other = (AsignacionC) object;
        if ((this.idAsig == null && other.idAsig != null) || (this.idAsig != null && !this.idAsig.equals(other.idAsig))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.AsignacionC[ idAsig=" + idAsig + " ]";
    }
    
}