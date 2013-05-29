/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity.view;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "V_COMUN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VComun.findAll", query = "SELECT v FROM VComun v"),
    @NamedQuery(name = "VComun.findByCedulae", query = "SELECT v FROM VComun v WHERE v.cedulae = :cedulae"),
    @NamedQuery(name = "VComun.findByDirCedulae", query = "SELECT v FROM VComun v WHERE v.dirCedulae = :dirCedulae"),
    @NamedQuery(name = "VComun.findByTipoCo", query = "SELECT v FROM VComun v WHERE v.tipoCo = :tipoCo"),
    @NamedQuery(name = "VComun.findByFechaCo", query = "SELECT v FROM VComun v WHERE v.fechaCo = :fechaCo"),
    @NamedQuery(name = "VComun.findByContenidoCo", query = "SELECT v FROM VComun v WHERE v.contenidoCo = :contenidoCo"),
    @NamedQuery(name = "VComun.findByUrgente", query = "SELECT v FROM VComun v WHERE v.urgente = :urgente"),
    @NamedQuery(name = "VComun.findByRespuestaCo", query = "SELECT v FROM VComun v WHERE v.respuestaCo = :respuestaCo")})
public class VComun implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "CEDULAE")
    private BigInteger cedulae;
    @Column(name = "DIR_CEDULAE")
    private BigInteger dirCedulae;
    @Basic(optional = false)
    @Column(name = "TIPO_CO")
    private String tipoCo;
    @Basic(optional = false)
    @Column(name = "FECHA_CO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCo;
    @Basic(optional = false)
    @Column(name = "CONTENIDO_CO")
    private String contenidoCo;
    @Basic(optional = false)
    @Column(name = "URGENTE")
    private boolean urgente;
    @Column(name = "RESPUESTA_CO")
    private String respuestaCo;

    public VComun() {
    }

    public BigInteger getCedulae() {
        return cedulae;
    }

    public void setCedulae(BigInteger cedulae) {
        this.cedulae = cedulae;
    }

    public BigInteger getDirCedulae() {
        return dirCedulae;
    }

    public void setDirCedulae(BigInteger dirCedulae) {
        this.dirCedulae = dirCedulae;
    }

    public String getTipoCo() {
        return tipoCo;
    }

    public void setTipoCo(String tipoCo) {
        this.tipoCo = tipoCo;
    }

    public Date getFechaCo() {
        return fechaCo;
    }

    public void setFechaCo(Date fechaCo) {
        this.fechaCo = fechaCo;
    }

    public String getContenidoCo() {
        return contenidoCo;
    }

    public void setContenidoCo(String contenidoCo) {
        this.contenidoCo = contenidoCo;
    }

    public boolean getUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public String getRespuestaCo() {
        return respuestaCo;
    }

    public void setRespuestaCo(String respuestaCo) {
        this.respuestaCo = respuestaCo;
    }
    
}
