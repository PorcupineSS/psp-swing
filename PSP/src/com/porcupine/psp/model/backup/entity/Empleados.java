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
    private Long cedulae;
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
    @OneToMany(mappedBy = "cedulae")
    private List<BitacoraSeg> bitacoraSegList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleados")
    private EmTemp emTemp;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleados")
    private EmpPlanta empPlanta;
    @JoinColumn(name = "DIR_CEDULAE", referencedColumnName = "CEDULAE")
    @ManyToOne
    private DirGestionHum dirCedulae;

    public Empleados() {
    }

    public Empleados(Long cedulae) {
        this.cedulae = cedulae;
    }

    public Empleados(Long cedulae, String nombree, String apellidoe, String contrasenae, String coddocume, Date fechareg) {
        this.cedulae = cedulae;
        this.nombree = nombree;
        this.apellidoe = apellidoe;
        this.contrasenae = contrasenae;
        this.coddocume = coddocume;
        this.fechareg = fechareg;
    }

    public Long getCedulae() {
        return cedulae;
    }

    public void setCedulae(Long cedulae) {
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

    @XmlTransient
    public List<BitacoraSeg> getBitacoraSegList() {
        return bitacoraSegList;
    }

    public void setBitacoraSegList(List<BitacoraSeg> bitacoraSegList) {
        this.bitacoraSegList = bitacoraSegList;
    }

    public EmTemp getEmTemp() {
        return emTemp;
    }

    public void setEmTemp(EmTemp emTemp) {
        this.emTemp = emTemp;
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
        EmpleadosVO empleados = new EmpleadosVO();

        empleados.setCedulaE(cedulae);
        empleados.setNombreE(nombree);
        empleados.setApellidoE(apellidoe);
        empleados.setFechareg(fechareg);

        if (getEmpPlanta() != null) {
            empleados.setEmpPlanta(empPlanta.getCedulae());
        }

        if (getEmTemp() != null) {
            empleados.setEmpTemp(emTemp.getCedulae());
        }

        empleados.setCodDocumE(coddocume);
        empleados.setContrasenaE(contrasenae);
        empleados.setDirCedulaE(dirCedulae.getCedulae());

        ArrayList<BitacoraSegVO> listBitacoraSegVO = new ArrayList<BitacoraSegVO>();
        for (BitacoraSeg entity : getBitacoraSegList()) {
            listBitacoraSegVO.add(entity.toVO());
        }

        empleados.setBitacoraSegList(listBitacoraSegVO);

        ArrayList<TelsEmpVO> listTelsEmpVO = new ArrayList<TelsEmpVO>();
        for (TelsEmp entity : getTelsEmpList()) {
            listTelsEmpVO.add(entity.toVO());
        }

        empleados.setTelsEmpList(listTelsEmpVO);

        return empleados;
    }
}