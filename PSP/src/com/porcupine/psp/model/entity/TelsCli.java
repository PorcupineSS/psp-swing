/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "TELS_CLI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelsCli.findAll", query = "SELECT t FROM TelsCli t"),
    @NamedQuery(name = "TelsCli.findByIdTc", query = "SELECT t FROM TelsCli t WHERE t.idTc = :idTc"),
    @NamedQuery(name = "TelsCli.findByNumTelefonoC", query = "SELECT t FROM TelsCli t WHERE t.numTelefonoC = :numTelefonoC")})
public class TelsCli implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TC")
    private Short idTc;
    @Basic(optional = false)
    @Column(name = "NUM_TELEFONO_C")
    private String numTelefonoC;
    @ManyToMany(mappedBy = "telsCliList")
    private List<Cliente> clienteList;

    public TelsCli() {
    }

    public TelsCli(Short idTc) {
        this.idTc = idTc;
    }

    public TelsCli(Short idTc, String numTelefonoC) {
        this.idTc = idTc;
        this.numTelefonoC = numTelefonoC;
    }

    public Short getIdTc() {
        return idTc;
    }

    public void setIdTc(Short idTc) {
        this.idTc = idTc;
    }

    public String getNumTelefonoC() {
        return numTelefonoC;
    }

    public void setNumTelefonoC(String numTelefonoC) {
        this.numTelefonoC = numTelefonoC;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTc != null ? idTc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelsCli)) {
            return false;
        }
        TelsCli other = (TelsCli) object;
        if ((this.idTc == null && other.idTc != null) || (this.idTc != null && !this.idTc.equals(other.idTc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.TelsCli[ idTc=" + idTc + " ]";
    }
    
}
