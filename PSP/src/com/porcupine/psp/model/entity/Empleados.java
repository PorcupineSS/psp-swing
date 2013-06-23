/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import com.porcupine.psp.model.vo.BitacoraSegVO;
import com.porcupine.psp.model.vo.EmpleadosVO;
import com.porcupine.psp.model.vo.TelefonosVO;
import com.porcupine.psp.util.TipoEmpleado;
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
@Table(name = "EMPLEADOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByCedulae", query = "SELECT e FROM Empleados e WHERE e.cedulae = :cedulae"),
    @NamedQuery(name = "Empleados.findByNombree", query = "SELECT e FROM Empleados e WHERE e.nombree = :nombree"),
    @NamedQuery(name = "Empleados.findByApellidoe", query = "SELECT e FROM Empleados e WHERE e.apellidoe = :apellidoe"),
    @NamedQuery(name = "Empleados.findByContrasenae", query = "SELECT e FROM Empleados e WHERE e.contrasenae = :contrasenae"),
    @NamedQuery(name = "Empleados.findByCoddocume", query = "SELECT e FROM Empleados e WHERE e.coddocume = :coddocume"),
    @NamedQuery(name = "Empleados.findByFechareg", query = "SELECT e FROM Empleados e WHERE e.fechareg = :fechareg")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    private Integer cedulae;
    @Basic(optional = false)
    @Column(name = "NOMBREE")
    private String nombree;
    @Basic(optional = false)
    @Column(name = "APELLIDOE")
    private String apellidoe;
    @Basic(optional = false)
    @Column(name = "CONTRASENAE")
    private String contrasenae;
    @Basic(optional = false)
    @Column(name = "CODDOCUME")
    private String coddocume;
    @Basic(optional = false)
    @Column(name = "FECHAREG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareg;
    @JoinTable(name = "EM_TIENE_TELS", joinColumns = {
        @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_TE", referencedColumnName = "ID_TE")})
    @ManyToMany
    private List<TelsEmp> telsEmpList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleados")
    private EmpTemp empTemp;
    @OneToMany(mappedBy = "cedulae")
    private List<BitacoraSeg> bitacoraSegList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleados")
    private EmpPlanta empPlanta;
    @JoinColumn(name = "DIR_CEDULAE", referencedColumnName = "CEDULAE")
    @ManyToOne
    private DirGestionHum dirCedulae;

    public Empleados() {
    }

    public Empleados(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public Empleados(Integer cedulae, String nombree, String apellidoe, String contrasenae, String coddocume, Date fechareg) {
        this.cedulae = cedulae;
        this.nombree = nombree;
        this.apellidoe = apellidoe;
        this.contrasenae = contrasenae;
        this.coddocume = coddocume;
        this.fechareg = fechareg;
    }

    public Integer getCedulae() {
        return cedulae;
    }

    public void setCedulae(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public String getNombree() {
        return nombree;
    }

    public void setNombree(String nombree) {
        this.nombree = nombree;
    }

    public String getApellidoe() {
        return apellidoe;
    }

    public void setApellidoe(String apellidoe) {
        this.apellidoe = apellidoe;
    }

    public String getContrasenae() {
        return contrasenae;
    }

    public void setContrasenae(String contrasenae) {
        this.contrasenae = contrasenae;
    }

    public String getCoddocume() {
        return coddocume;
    }

    public void setCoddocume(String coddocume) {
        this.coddocume = coddocume;
    }

    public Date getFechareg() {
        return fechareg;
    }

    public void setFechareg(Date fechareg) {
        this.fechareg = fechareg;
    }

    @XmlTransient
    public List<TelsEmp> getTelsEmpList() {
        return telsEmpList;
    }

    public void setTelsEmpList(List<TelsEmp> telsEmpList) {
        this.telsEmpList = telsEmpList;
    }

    public EmpTemp getEmpTemp() {
        return empTemp;
    }

    public void setEmpTemp(EmpTemp empTemp) {
        this.empTemp = empTemp;
    }

    @XmlTransient
    public List<BitacoraSeg> getBitacoraSegList() {
        return bitacoraSegList;
    }

    public void setBitacoraSegList(List<BitacoraSeg> bitacoraSegList) {
        this.bitacoraSegList = bitacoraSegList;
    }

    public EmpPlanta getEmpPlanta() {
        return empPlanta;
    }

    public void setEmpPlanta(EmpPlanta empPlanta) {
        this.empPlanta = empPlanta;
    }

    public DirGestionHum getDirCedulae() {
        return dirCedulae;
    }

    public void setDirCedulae(DirGestionHum dirCedulae) {
        this.dirCedulae = dirCedulae;
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
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.cedulae == null && other.cedulae != null) || (this.cedulae != null && !this.cedulae.equals(other.cedulae))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.Empleados[ cedulae=" + cedulae + " ]";
    }

    public EmpleadosVO toVO() {
        EmpleadosVO empleado = new EmpleadosVO();
        empleado.setCedulaEmpleado(cedulae);
        empleado.setNombreEmpleado(nombree);
        empleado.setApellidoEmpleado(apellidoe);
        empleado.setContraseniaEmpleado(contrasenae);
        empleado.setCodigoDocumento(coddocume);
        empleado.setFechaRegistro(fechareg);



        if (this.getDirCedulae() != null) {
            empleado.setCedulaDirector(dirCedulae.getCedulae());
        }

        List<TelefonosVO> telefonos = new ArrayList<TelefonosVO>();
        if (getTelsEmpList() != null) {
            for (TelsEmp each : getTelsEmpList()) {
                telefonos.add((each.toVO()));
            }
        }
        empleado.setTelsEmpList(telefonos);


        List<BitacoraSegVO> bitacoras = new ArrayList<BitacoraSegVO>();
        if (getTelsEmpList() != null) {
            for (BitacoraSeg each : getBitacoraSegList()) {
                bitacoras.add((each.toVO()));
            }
        }
        empleado.setBitacoraSegList(bitacoras);

        empleado.setRol(discoverRole());

        return empleado;
    }

    private String discoverRole() {
        //Se ofrecen dos enfoques... Utilizar el cogigo de la empresa o averiguarlo en la base de datos. Por ahora es mas facil averiguarlo en el string pero puede discutirse
        if (this.getEmpTemp() != null) {
            return TipoEmpleado.TEMPORAL;
        } else {
            //Desde esta capa no se puede saber que tipo de  Empleado es, solo que es de planta o no.
            return TipoEmpleado.PLANTA;
        }
    }
}
