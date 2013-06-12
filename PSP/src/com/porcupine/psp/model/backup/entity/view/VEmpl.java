/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.entity.view;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zergio
 */
@Entity
@Table(name = "V_EMPL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VEmpl.findAll", query = "SELECT v FROM VEmpl v"),
    @NamedQuery(name = "VEmpl.findByCedulae", query = "SELECT v FROM VEmpl v WHERE v.cedulae = :cedulae"),
    @NamedQuery(name = "VEmpl.findByDirCedulae", query = "SELECT v FROM VEmpl v WHERE v.dirCedulae = :dirCedulae"),
    @NamedQuery(name = "VEmpl.findByNombree", query = "SELECT v FROM VEmpl v WHERE v.nombree = :nombree"),
    @NamedQuery(name = "VEmpl.findByApellidoe", query = "SELECT v FROM VEmpl v WHERE v.apellidoe = :apellidoe"),
    @NamedQuery(name = "VEmpl.findByContrasenae", query = "SELECT v FROM VEmpl v WHERE v.contrasenae = :contrasenae"),
    @NamedQuery(name = "VEmpl.findByCoddocume", query = "SELECT v FROM VEmpl v WHERE v.coddocume = :coddocume"),
    @NamedQuery(name = "VEmpl.findByFechareg", query = "SELECT v FROM VEmpl v WHERE v.fechareg = :fechareg")})
public class VEmpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "CEDULAE")
    @Id
    private long cedulae;
    @Column(name = "DIR_CEDULAE")
    private BigInteger dirCedulae;
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

    public VEmpl() {
    }

    public long getCedulae() {
        return cedulae;
    }

    public void setCedulae(long cedulae) {
        this.cedulae = cedulae;
    }

    public BigInteger getDirCedulae() {
        return dirCedulae;
    }

    public void setDirCedulae(BigInteger dirCedulae) {
        this.dirCedulae = dirCedulae;
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
    
}
