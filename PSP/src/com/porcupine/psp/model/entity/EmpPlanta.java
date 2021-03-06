/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import com.porcupine.psp.model.vo.EmpPlantaVO;
import com.porcupine.psp.util.TipoEmpleado;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "EMP_PLANTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpPlanta.findAll", query = "SELECT e FROM EmpPlanta e"),
    @NamedQuery(name = "EmpPlanta.findByCedulae", query = "SELECT e FROM EmpPlanta e WHERE e.cedulae = :cedulae"),
    @NamedQuery(name = "EmpPlanta.findBySueldoe", query = "SELECT e FROM EmpPlanta e WHERE e.sueldoe = :sueldoe")})
public class EmpPlanta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private Integer cedulae;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SUELDOE")
    private BigDecimal sueldoe;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empPlanta")
    private DirGestionHum dirGestionHum;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empPlanta")
    private CoordContrato coordContrato;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empPlanta")
    private Subgerente subgerente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empPlanta")
    private DirOperaciones dirOperaciones;
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empleados empleados;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empPlanta")
    private CoordTYT coordTYT;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empPlanta")
    private DirComercial dirComercial;

    public EmpPlanta() {
    }

    public EmpPlanta(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public EmpPlanta(Integer cedulae, BigDecimal sueldoe) {
        this.cedulae = cedulae;
        this.sueldoe = sueldoe;
    }

    public Integer getCedulae() {
        return cedulae;
    }

    public void setCedulae(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public BigDecimal getSueldoe() {
        return sueldoe;
    }

    public void setSueldoe(BigDecimal sueldoe) {
        this.sueldoe = sueldoe;
    }

    public DirGestionHum getDirGestionHum() {
        return dirGestionHum;
    }

    public void setDirGestionHum(DirGestionHum dirGestionHum) {
        this.dirGestionHum = dirGestionHum;
    }

    public CoordContrato getCoordContrato() {
        return coordContrato;
    }

    public void setCoordContrato(CoordContrato coordContrato) {
        this.coordContrato = coordContrato;
    }

    public Subgerente getSubgerente() {
        return subgerente;
    }

    public void setSubgerente(Subgerente subgerente) {
        this.subgerente = subgerente;
    }

    public DirOperaciones getDirOperaciones() {
        return dirOperaciones;
    }

    public void setDirOperaciones(DirOperaciones dirOperaciones) {
        this.dirOperaciones = dirOperaciones;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public CoordTYT getCoordTYT() {
        return coordTYT;
    }

    public void setCoordTYT(CoordTYT coordTYT) {
        this.coordTYT = coordTYT;
    }

    public DirComercial getDirComercial() {
        return dirComercial;
    }

    public void setDirComercial(DirComercial dirComercial) {
        this.dirComercial = dirComercial;
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
        if (!(object instanceof EmpPlanta)) {
            return false;
        }
        EmpPlanta other = (EmpPlanta) object;
        if ((this.cedulae == null && other.cedulae != null) || (this.cedulae != null && !this.cedulae.equals(other.cedulae))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.EmpPlanta[ cedulae=" + cedulae + " ]";
    }

    public EmpPlantaVO toVO() {
        EmpPlantaVO empleado = new EmpPlantaVO();
        empleado.setCedulae(this.getCedulae());
        empleado.setSueldoe(this.getSueldoe());
        if (this.getEmpleados().getCedulae() != null) {
            empleado.setEmpleados(this.getEmpleados().getCedulae());
        }

        if (this.getCoordContrato() != null) {
            empleado.setCoordContrato(this.getCoordContrato().getCedulae());
            empleado.setRol(TipoEmpleado.COORDINADOR_CONTRATO);
        }
        if (this.getCoordTYT() != null) {
            empleado.setCoordTYT(this.getCoordTYT().getCedulae());
            empleado.setRol(TipoEmpleado.COORDINADOR_TECNICO_TECNOLOGICO);
        }
        if (this.getDirComercial() != null) {
            empleado.setDirComercial(this.getDirComercial().getCedulae());
            empleado.setRol(TipoEmpleado.DIRECTOR_COMERCIAL);
        }
        if (this.getDirGestionHum() != null) {
            empleado.setDirGestionHum(this.getDirGestionHum().getCedulae());
            empleado.setRol(TipoEmpleado.DIRECTOR_GESTION_HUMANA);
        }
        if (this.getDirOperaciones() != null) {
            empleado.setDirOperaciones(this.getDirOperaciones().getCedulae());
            empleado.setRol(TipoEmpleado.DIRECTOR_OPERACIONES);
        }
        if (this.getSubgerente() != null) {
            empleado.setSubgerente(this.getSubgerente().getCedulae());
            empleado.setRol(TipoEmpleado.SUBGERENTE);
        }
        return empleado;

    }
}
