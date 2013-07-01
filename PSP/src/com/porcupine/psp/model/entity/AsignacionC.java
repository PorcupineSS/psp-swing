/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import com.porcupine.psp.model.vo.*;
import java.io.Serializable;
import java.util.ArrayList;
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
    @NamedQuery(name = "AsignacionC.findByEmpTempCedulae", query = "SELECT a FROM AsignacionC a WHERE a.empTempCedulae = :empTempCedulae"),
    @NamedQuery(name = "AsignacionC.findByFechaAsignacionC", query = "SELECT a FROM AsignacionC a WHERE a.fechaAsignacionC = :fechaAsignacionC"),
    @NamedQuery(name = "AsignacionC.findByHorarioAsignado", query = "SELECT a FROM AsignacionC a WHERE a.horarioAsignado = :horarioAsignado")})
public class AsignacionC implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ASIG")
    private Short idAsig;
    @Basic(optional = false)
    @Column(name = "EMP_TEMP_CEDULAE")
    private int empTempCedulae;
    @Basic(optional = false)
    @Column(name = "FECHA_ASIGNACION_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacionC;
    @Basic(optional = false)
    @Column(name = "HORARIO_ASIGNADO")
    private String horarioAsignado;
    @OneToMany(mappedBy = "idAsig")
    private List<EmpTemp> empTempList;
    @JoinColumn(name = "COO_CEDULAE", referencedColumnName = "CEDULAE")
    @ManyToOne(optional = false)
    private CoordContrato cooCedulae;
    @JoinColumn(name = "ID_CONTRATO", referencedColumnName = "ID_CONTRATO")
    @ManyToOne(optional = false)
    private Contrato idContrato;

    public AsignacionC() {
    }

    public AsignacionC(Short idAsig) {
        this.idAsig = idAsig;
    }

    public AsignacionC(Short idAsig, int empTempCedulae, Date fechaAsignacionC, String horarioAsignado) {
        this.idAsig = idAsig;
        this.empTempCedulae = empTempCedulae;
        this.fechaAsignacionC = fechaAsignacionC;
        this.horarioAsignado = horarioAsignado;
    }

    public Short getIdAsig() {
        return idAsig;
    }

    public void setIdAsig(Short idAsig) {
        this.idAsig = idAsig;
    }

    public int getEmpTempCedulae() {
        return empTempCedulae;
    }

    public void setEmpTempCedulae(int empTempCedulae) {
        this.empTempCedulae = empTempCedulae;
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
    public List<EmpTemp> getEmpTempList() {
        return empTempList;
    }

    public void setEmpTempList(List<EmpTemp> empTempList) {
        this.empTempList = empTempList;
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

    public AsignacionCVO toVO() {
        
        AsignacionCVO asignacionC = new AsignacionCVO();
        
        asignacionC.setCedulaCoordCont(getCooCedulae().getCedulae());
        //asignacionC.setCedulaEmpTemp(empTempCedulae);//Revisar este
        asignacionC.setFechaAsignacionC(fechaAsignacionC);
        asignacionC.setHorarioAsignado(horarioAsignado);
        asignacionC.setIdAsig(idAsig);
        asignacionC.setIdContrato(getIdContrato().getIdContrato());
        
        //Revisar esto de abajo
        ArrayList<EmpTempVO> listAsigEmpTempVO = new ArrayList<EmpTempVO>();
        for(EmpTemp entity : getEmpTempList()){
           listAsigEmpTempVO.add(entity.toVO());            
        }
        
        return asignacionC;
        
    }
    
}
