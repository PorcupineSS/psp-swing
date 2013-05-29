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
@Table(name = "V_BITACORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VBitacora.findAll", query = "SELECT v FROM VBitacora v"),
    @NamedQuery(name = "VBitacora.findByCedulae", query = "SELECT v FROM VBitacora v WHERE v.cedulae = :cedulae"),
    @NamedQuery(name = "VBitacora.findByFechaOper", query = "SELECT v FROM VBitacora v WHERE v.fechaOper = :fechaOper"),
    @NamedQuery(name = "VBitacora.findByUsuOper", query = "SELECT v FROM VBitacora v WHERE v.usuOper = :usuOper"),
    @NamedQuery(name = "VBitacora.findByMaqOper", query = "SELECT v FROM VBitacora v WHERE v.maqOper = :maqOper"),
    @NamedQuery(name = "VBitacora.findByTablaMod", query = "SELECT v FROM VBitacora v WHERE v.tablaMod = :tablaMod"),
    @NamedQuery(name = "VBitacora.findByTipoOper", query = "SELECT v FROM VBitacora v WHERE v.tipoOper = :tipoOper")})
public class VBitacora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "CEDULAE")
    private BigInteger cedulae;
    @Basic(optional = false)
    @Column(name = "FECHA_OPER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOper;
    @Column(name = "USU_OPER")
    private String usuOper;
    @Column(name = "MAQ_OPER")
    private String maqOper;
    @Basic(optional = false)
    @Column(name = "TABLA_MOD")
    private String tablaMod;
    @Basic(optional = false)
    @Column(name = "TIPO_OPER")
    private String tipoOper;

    public VBitacora() {
    }

    public BigInteger getCedulae() {
        return cedulae;
    }

    public void setCedulae(BigInteger cedulae) {
        this.cedulae = cedulae;
    }

    public Date getFechaOper() {
        return fechaOper;
    }

    public void setFechaOper(Date fechaOper) {
        this.fechaOper = fechaOper;
    }

    public String getUsuOper() {
        return usuOper;
    }

    public void setUsuOper(String usuOper) {
        this.usuOper = usuOper;
    }

    public String getMaqOper() {
        return maqOper;
    }

    public void setMaqOper(String maqOper) {
        this.maqOper = maqOper;
    }

    public String getTablaMod() {
        return tablaMod;
    }

    public void setTablaMod(String tablaMod) {
        this.tablaMod = tablaMod;
    }

    public String getTipoOper() {
        return tipoOper;
    }

    public void setTipoOper(String tipoOper) {
        this.tipoOper = tipoOper;
    }
    
}
