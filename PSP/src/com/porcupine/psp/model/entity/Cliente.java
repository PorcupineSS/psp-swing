/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity;

import com.porcupine.psp.model.vo.ClienteVO;
import com.porcupine.psp.model.vo.ContratoVO;
import com.porcupine.psp.model.vo.TelefonosVO;
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
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdcl", query = "SELECT c FROM Cliente c WHERE c.idcl = :idcl"),
    @NamedQuery(name = "Cliente.findByNombrecl", query = "SELECT c FROM Cliente c WHERE c.nombrecl = :nombrecl"),
    @NamedQuery(name = "Cliente.findByDireccioncl", query = "SELECT c FROM Cliente c WHERE c.direccioncl = :direccioncl"),
    @NamedQuery(name = "Cliente.findByFechaRegCl", query = "SELECT c FROM Cliente c WHERE c.fechaRegCl = :fechaRegCl")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCL")
    private Short idcl;
    @Basic(optional = false)
    @Column(name = "NOMBRECL")
    private String nombrecl;
    @Basic(optional = false)
    @Column(name = "DIRECCIONCL")
    private String direccioncl;
    @Basic(optional = false)
    @Column(name = "FECHA_REG_CL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegCl;
    @JoinTable(name = "CL_TIENE_TELS", joinColumns = {
        @JoinColumn(name = "IDCL", referencedColumnName = "IDCL")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_TC", referencedColumnName = "ID_TC")})
    @ManyToMany
    private List<TelsCli> telsCliList;
    @JoinColumn(name = "CEDULAE", referencedColumnName = "CEDULAE")
    @ManyToOne(optional = false)
    private DirComercial cedulae;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcl")
    private List<Contrato> contratoList;

    public Cliente() {
    }

    public Cliente(Short idcl) {
        this.idcl = idcl;
    }

    public Cliente(Short idcl, String nombrecl, String direccioncl, Date fechaRegCl) {
        this.idcl = idcl;
        this.nombrecl = nombrecl;
        this.direccioncl = direccioncl;
        this.fechaRegCl = fechaRegCl;
    }

    public Short getIdcl() {
        return idcl;
    }

    public void setIdcl(Short idcl) {
        this.idcl = idcl;
    }

    public String getNombrecl() {
        return nombrecl;
    }

    public void setNombrecl(String nombrecl) {
        this.nombrecl = nombrecl;
    }

    public String getDireccioncl() {
        return direccioncl;
    }

    public void setDireccioncl(String direccioncl) {
        this.direccioncl = direccioncl;
    }

    public Date getFechaRegCl() {
        return fechaRegCl;
    }

    public void setFechaRegCl(Date fechaRegCl) {
        this.fechaRegCl = fechaRegCl;
    }

    @XmlTransient
    public List<TelsCli> getTelsCliList() {
        return telsCliList;
    }

    public void setTelsCliList(List<TelsCli> telsCliList) {
        this.telsCliList = telsCliList;
    }

    public DirComercial getCedulae() {
        return cedulae;
    }

    public void setCedulae(DirComercial cedulae) {
        this.cedulae = cedulae;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcl != null ? idcl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcl == null && other.idcl != null) || (this.idcl != null && !this.idcl.equals(other.idcl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.Cliente[ idcl=" + idcl + " ]";
    }
    
    public ClienteVO toVO(){
        ClienteVO cliente = new ClienteVO();
        cliente.setCedulaDirector(this.getCedulae().getCedulae());
        cliente.setDireccionCliente(this.getDireccioncl());
        cliente.setFechaRegCliente(this.getFechaRegCl());
        cliente.setIdCliente(this.getIdcl());
        cliente.setNombreCliente(this.getNombrecl());
        

        List<TelefonosVO> telefonos = new ArrayList<TelefonosVO>();
        for(TelsCli each : this.getTelsCliList()){
            telefonos.add(each.toVO());
        }
        cliente.setTelsCliList(telefonos);
        
        List<ContratoVO> contratos = new ArrayList<ContratoVO>();
        for(Contrato each : this.getContratoList()){
            contratos.add(each.toVO());
        }
        cliente.setContratoList(contratos);
        
        return cliente;
    }
    
}
