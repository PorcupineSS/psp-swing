/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import com.porcupine.psp.model.vo.TelefonosVO;
import com.porcupine.psp.util.TipoTelefono;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "TELS_PROV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelsProv.findAll", query = "SELECT t FROM TelsProv t"),
    @NamedQuery(name = "TelsProv.findByIdTp", query = "SELECT t FROM TelsProv t WHERE t.idTp = :idTp"),
    @NamedQuery(name = "TelsProv.findByNumTelefonoP", query = "SELECT t FROM TelsProv t WHERE t.numTelefonoP = :numTelefonoP")})
public class TelsProv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TP")
    private Short idTp;
    @Basic(optional = false)
    @Column(name = "NUM_TELEFONO_P")
    private String numTelefonoP;
    @JoinColumn(name = "ID_PRO", referencedColumnName = "ID_PRO")
    @ManyToOne
    private Proveedor idPro;

    public TelsProv() {
    }

    public TelsProv(Short idTp) {
        this.idTp = idTp;
    }

    public TelsProv(Short idTp, String numTelefonoP) {
        this.idTp = idTp;
        this.numTelefonoP = numTelefonoP;
    }

    public Short getIdTp() {
        return idTp;
    }

    public void setIdTp(Short idTp) {
        this.idTp = idTp;
    }

    public String getNumTelefonoP() {
        return numTelefonoP;
    }

    public void setNumTelefonoP(String numTelefonoP) {
        this.numTelefonoP = numTelefonoP;
    }

    public Proveedor getIdPro() {
        return idPro;
    }

    public void setIdPro(Proveedor idPro) {
        this.idPro = idPro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTp != null ? idTp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelsProv)) {
            return false;
        }
        TelsProv other = (TelsProv) object;
        if ((this.idTp == null && other.idTp != null) || (this.idTp != null && !this.idTp.equals(other.idTp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.TelsProv[ idTp=" + idTp + " ]";
    }

    public TelefonosVO toVO() {
        TelefonosVO telefono = new TelefonosVO();

        telefono.setIdTelefono(this.getIdTp());
        telefono.setNumeroTelefonoEmpleado(this.getNumTelefonoP());
        telefono.setTipoTelefono(TipoTelefono.PROVEEDOR.toString());

        List proveedores = new ArrayList<Integer>();

        proveedores.add(getIdPro());

        telefono.setUsersList(proveedores);
        return telefono;
    }
}
