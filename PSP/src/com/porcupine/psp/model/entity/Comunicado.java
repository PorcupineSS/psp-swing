/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import com.porcupine.psp.model.vo.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "COMUNICADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunicado.findAll", query = "SELECT c FROM Comunicado c"),
    @NamedQuery(name = "Comunicado.findByIdComunicado", query = "SELECT c FROM Comunicado c WHERE c.idComunicado = :idComunicado"),
    @NamedQuery(name = "Comunicado.findByTipoCo", query = "SELECT c FROM Comunicado c WHERE c.tipoCo = :tipoCo"),
    @NamedQuery(name = "Comunicado.findByFechaCo", query = "SELECT c FROM Comunicado c WHERE c.fechaCo = :fechaCo"),
    @NamedQuery(name = "Comunicado.findByContenidoCo", query = "SELECT c FROM Comunicado c WHERE c.contenidoCo = :contenidoCo"),
    @NamedQuery(name = "Comunicado.findByUrgente", query = "SELECT c FROM Comunicado c WHERE c.urgente = :urgente"),
    @NamedQuery(name = "Comunicado.findByRespuestaCo", query = "SELECT c FROM Comunicado c WHERE c.respuestaCo = :respuestaCo")})
public class Comunicado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COMUNICADO")
    private Short idComunicado;
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
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE")
    @ManyToOne
    private EmpTemp cedulae;
    @JoinColumn(name = "DIR_CEDULAE", referencedColumnName = "CEDULAE")
    @ManyToOne
    private DirOperaciones dirCedulae;

    public Comunicado() {
    }

    public Comunicado(Short idComunicado) {
        this.idComunicado = idComunicado;
    }

    public Comunicado(Short idComunicado, String tipoCo, Date fechaCo, String contenidoCo, boolean urgente) {
        this.idComunicado = idComunicado;
        this.tipoCo = tipoCo;
        this.fechaCo = fechaCo;
        this.contenidoCo = contenidoCo;
        this.urgente = urgente;
    }

    public Short getIdComunicado() {
        return idComunicado;
    }

    public void setIdComunicado(Short idComunicado) {
        this.idComunicado = idComunicado;
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

    public EmpTemp getCedulae() {
        return cedulae;
    }

    public void setCedulae(EmpTemp cedulae) {
        this.cedulae = cedulae;
    }

    public DirOperaciones getDirCedulae() {
        return dirCedulae;
    }

    public void setDirCedulae(DirOperaciones dirCedulae) {
        this.dirCedulae = dirCedulae;
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
        if (!(object instanceof Comunicado)) {
            return false;
        }
        Comunicado other = (Comunicado) object;
        if ((this.idComunicado == null && other.idComunicado != null) || (this.idComunicado != null && !this.idComunicado.equals(other.idComunicado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.Comunicado[ idComunicado=" + idComunicado + " ]";
    }
    
    public ComunicadoVO toVO(){
        
        ComunicadoVO comunicado = new ComunicadoVO(); 
        
//        comunicado.setCedulaDirOper(this.getDirCedulae().getCedulae());//Dudo de este
//        comunicado.setCedulaEmpTemp(this.getCedulae().getCedulae());//Dudo de este
        
        comunicado.setContenidoCom(contenidoCo);
        comunicado.setFechaCom(fechaCo);
        comunicado.setIdComunicado(idComunicado);
        comunicado.setRespuestaCom(respuestaCo);
        comunicado.setTipoCom(tipoCo);
        comunicado.setUrgente(urgente);
        
        if (getCedulae() != null) {
            comunicado.setCedulaDirOper(getDirCedulae().getCedulae());
        }
        if (getCedulae() != null) {
            comunicado.setCedulaEmpTemp(getCedulae().getCedulae());
        }
        
        return comunicado;
    }
    
}
