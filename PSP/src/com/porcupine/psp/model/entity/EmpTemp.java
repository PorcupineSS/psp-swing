/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import com.porcupine.psp.model.vo.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "EMP_TEMP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpTemp.findAll", query = "SELECT e FROM EmpTemp e"),
    @NamedQuery(name = "EmpTemp.findByCedulae", query = "SELECT e FROM EmpTemp e WHERE e.cedulae = :cedulae"),
    @NamedQuery(name = "EmpTemp.findByTieneContrato", query = "SELECT e FROM EmpTemp e WHERE e.tieneContrato = :tieneContrato"),
    @NamedQuery(name = "EmpTemp.findByTipoTemp", query = "SELECT e FROM EmpTemp e WHERE e.tipoTemp = :tipoTemp")})
public class EmpTemp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private Integer cedulae;
    @Basic(optional = false)
    @Column(name = "TIENE_CONTRATO")
    private boolean tieneContrato;
    @Basic(optional = false)
    @Column(name = "TIPO_TEMP")
    private String tipoTemp;
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empleados empleados;
    @JoinColumn(name = "ID_ASIG", referencedColumnName = "ID_ASIG")
    @ManyToOne
    private AsignacionC idAsig;
    @OneToMany(mappedBy = "cedulae")
    private List<Comunicado> comunicadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulae")
    private List<AsigImpl> asigImplList;

    public EmpTemp() {
    }

    public EmpTemp(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public EmpTemp(Integer cedulae, boolean tieneContrato, String tipoTemp) {
        this.cedulae = cedulae;
        this.tieneContrato = tieneContrato;
        this.tipoTemp = tipoTemp;
    }

    public Integer getCedulae() {
        return cedulae;
    }

    public void setCedulae(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public boolean getTieneContrato() {
        return tieneContrato;
    }

    public void setTieneContrato(boolean tieneContrato) {
        this.tieneContrato = tieneContrato;
    }

    public String getTipoTemp() {
        return tipoTemp;
    }

    public void setTipoTemp(String tipoTemp) {
        this.tipoTemp = tipoTemp;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public AsignacionC getIdAsig() {
        return idAsig;
    }

    public void setIdAsig(AsignacionC idAsig) {
        this.idAsig = idAsig;
    }

    @XmlTransient
    public List<Comunicado> getComunicadoList() {
        return comunicadoList;
    }

    public void setComunicadoList(List<Comunicado> comunicadoList) {
        this.comunicadoList = comunicadoList;
    }

    @XmlTransient
    public List<AsigImpl> getAsigImplList() {
        return asigImplList;
    }

    public void setAsigImplList(List<AsigImpl> asigImplList) {
        this.asigImplList = asigImplList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulae != null ? cedulae.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpTemp)) {
            return false;
        }
        EmpTemp other = (EmpTemp) object;
        if ((this.cedulae == null && other.cedulae != null) || (this.cedulae != null && !this.cedulae.equals(other.cedulae))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.EmpTemp[ cedulae=" + cedulae + " ]";
    }

    public EmpTempVO toVO() {
        EmpTempVO empleado = new EmpTempVO();
        empleado.setCedulaEmpleado(this.getCedulae());
        empleado.setIdAsig(this.getIdAsig().getIdAsig());
        empleado.setTieneContrato(this.getTieneContrato());
        empleado.setTipoTemp(this.getTipoTemp());

        List<Short> asigImplList = new ArrayList<Short>();
        for (AsigImpl each : getAsigImplList()) {
            asigImplList.add(each.getIdAsignacionI());
        }
        empleado.setAsigImplList(asigImplList);

        
        List<Short> comunicadoList = new ArrayList<Short>();
        for (Comunicado each : getComunicadoList()) {
            comunicadoList.add(each.getIdComunicado());
        }
        empleado.setComunicadoList(comunicadoList);
        return empleado;
    }
}
