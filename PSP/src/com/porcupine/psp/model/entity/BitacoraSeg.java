/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import com.porcupine.psp.model.vo.BitacoraSegVO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "BITACORA_SEG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BitacoraSeg.findAll", query = "SELECT b FROM BitacoraSeg b"),
    @NamedQuery(name = "BitacoraSeg.findByIdOper", query = "SELECT b FROM BitacoraSeg b WHERE b.idOper = :idOper"),
    @NamedQuery(name = "BitacoraSeg.findByFechaOper", query = "SELECT b FROM BitacoraSeg b WHERE b.fechaOper = :fechaOper"),
    @NamedQuery(name = "BitacoraSeg.findByUsuOper", query = "SELECT b FROM BitacoraSeg b WHERE b.usuOper = :usuOper"),
    @NamedQuery(name = "BitacoraSeg.findByMaqOper", query = "SELECT b FROM BitacoraSeg b WHERE b.maqOper = :maqOper"),
    @NamedQuery(name = "BitacoraSeg.findByTablaMod", query = "SELECT b FROM BitacoraSeg b WHERE b.tablaMod = :tablaMod"),
    @NamedQuery(name = "BitacoraSeg.findByTipoOper", query = "SELECT b FROM BitacoraSeg b WHERE b.tipoOper = :tipoOper")})
public class BitacoraSeg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_OPER")
    private Integer idOper;
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
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE")
    @ManyToOne
    private Empleados cedulae;

    public BitacoraSeg() {
    }

    public BitacoraSeg(Integer idOper) {
        this.idOper = idOper;
    }

    public BitacoraSeg(Integer idOper, Date fechaOper, String tablaMod, String tipoOper) {
        this.idOper = idOper;
        this.fechaOper = fechaOper;
        this.tablaMod = tablaMod;
        this.tipoOper = tipoOper;
    }

    public Integer getIdOper() {
        return idOper;
    }

    public void setIdOper(Integer idOper) {
        this.idOper = idOper;
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

    public Empleados getCedulae() {
        return cedulae;
    }

    public void setCedulae(Empleados cedulae) {
        this.cedulae = cedulae;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOper != null ? idOper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitacoraSeg)) {
            return false;
        }
        BitacoraSeg other = (BitacoraSeg) object;
        if ((this.idOper == null && other.idOper != null) || (this.idOper != null && !this.idOper.equals(other.idOper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.BitacoraSeg[ idOper=" + idOper + " ]";
    }

    public BitacoraSegVO toVO() {
        BitacoraSegVO bitacora = new BitacoraSegVO();
        bitacora.setCedulae(this.getCedulae().getCedulae());
        bitacora.setFechaOper(this.getFechaOper());
        bitacora.setIdOper(this.getIdOper());
        bitacora.setMaqOper(this.getMaqOper());
        bitacora.setTablaMod(this.getTablaMod());
        bitacora.setTipoOper(this.getTipoOper());
        bitacora.setUsuOper(this.getUsuOper());
        return bitacora;
    }
    
}
