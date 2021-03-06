/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import com.porcupine.psp.model.vo.EmpleadosVO;
import com.porcupine.psp.model.vo.TelefonosVO;
import com.porcupine.psp.util.TipoTelefono;
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
@Table(name = "TELS_EMP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelsEmp.findAll", query = "SELECT t FROM TelsEmp t"),
    @NamedQuery(name = "TelsEmp.findByIdTe", query = "SELECT t FROM TelsEmp t WHERE t.idTe = :idTe"),
    @NamedQuery(name = "TelsEmp.findByNumTelefonoE", query = "SELECT t FROM TelsEmp t WHERE t.numTelefonoE = :numTelefonoE")})
public class TelsEmp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TE")
    private Short idTe;
    @Basic(optional = false)
    @Column(name = "NUM_TELEFONO_E")
    private String numTelefonoE;
    @ManyToMany(mappedBy = "telsEmpList")
    private List<Empleados> empleadosList;

    public TelsEmp() {
    }

    public TelsEmp(Short idTe) {
        this.idTe = idTe;
    }

    public TelsEmp(Short idTe, String numTelefonoE) {
        this.idTe = idTe;
        this.numTelefonoE = numTelefonoE;
    }

    public Short getIdTe() {
        return idTe;
    }

    public void setIdTe(Short idTe) {
        this.idTe = idTe;
    }

    public String getNumTelefonoE() {
        return numTelefonoE;
    }

    public void setNumTelefonoE(String numTelefonoE) {
        this.numTelefonoE = numTelefonoE;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTe != null ? idTe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelsEmp)) {
            return false;
        }
        TelsEmp other = (TelsEmp) object;
        if ((this.idTe == null && other.idTe != null) || (this.idTe != null && !this.idTe.equals(other.idTe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.TelsEmp[ idTe=" + idTe + " ]";
    }

    public TelefonosVO toVO() {
        TelefonosVO telefono = new TelefonosVO();

        telefono.setIdTelefono(this.getIdTe());
        telefono.setNumeroTelefonoEmpleado(this.getNumTelefonoE());
        telefono.setTipoTelefono(TipoTelefono.EMPLEADO.toString());

        List empleados = new ArrayList<Integer>();
        for(Empleados each : this.getEmpleadosList()){
            empleados.add(each.getCedulae());
        }
        telefono.setUsersList(empleados);

        return telefono;
    }
}
