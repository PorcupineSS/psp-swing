/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author javergarav
 */
public class EmpleadosVO implements IValueObject {
    //Atributos nativos

    private Long cedulaE;
    private String nombreE;
    private String apellidoE;
    private String contrasenaE;
    private String codDocumE;
    private Date fechareg;
    private List<TelsEmpVO> telsEmpList;
    private List<BitacoraSegVO> bitacoraSegList;
    private Long empTemp;
    private Long empPlanta;
    private Long dirCedulaE;
    private String rol;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    

    /**
     * @return the cedulaE
     */
    public Long getCedulaE() {
        return cedulaE;
    }

    /**
     * @param cedulaE the cedulaE to set
     */
    public void setCedulaE(Long cedulaE) {
        this.cedulaE = cedulaE;
    }

    /**
     * @return the nombreE
     */
    public String getNombreE() {
        return nombreE;
    }

    /**
     * @param nombreE the nombreE to set
     */
    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    /**
     * @return the apellidoE
     */
    public String getApellidoE() {
        return apellidoE;
    }

    /**
     * @param apellidoE the apellidoE to set
     */
    public void setApellidoE(String apellidoE) {
        this.apellidoE = apellidoE;
    }

    /**
     * @return the contrasenaE
     */
    public String getContrasenaE() {
        return contrasenaE;
    }

    /**
     * @param contrasenaE the contrasenaE to set
     */
    public void setContrasenaE(String contrasenaE) {
        this.contrasenaE = contrasenaE;
    }

    /**
     * @return the codDocumE
     */
    public String getCodDocumE() {
        return codDocumE;
    }

    /**
     * @param codDocumE the codDocumE to set
     */
    public void setCodDocumE(String codDocumE) {
        this.codDocumE = codDocumE;
    }

    /**
     * @return the fechareg
     */
    public Date getFechareg() {
        return fechareg;
    }

    /**
     * @param fechareg the fechareg to set
     */
    public void setFechareg(Date fechareg) {
        this.fechareg = fechareg;
    }

    /**
     * @return the telsEmpList
     */
    public List<TelsEmpVO> getTelsEmpList() {
        return telsEmpList;
    }

    /**
     * @param telsEmpList the telsEmpList to set
     */
    public void setTelsEmpList(List<TelsEmpVO> telsEmpList) {
        this.telsEmpList = telsEmpList;
    }

    /**
     * @return the bitacoraSegList
     */
    public List<BitacoraSegVO> getBitacoraSegList() {
        return bitacoraSegList;
    }

    /**
     * @param bitacoraSegList the bitacoraSegList to set
     */
    public void setBitacoraSegList(List<BitacoraSegVO> bitacoraSegList) {
        this.bitacoraSegList = bitacoraSegList;
    }

    /**
     * @return the empTemp
     */
    public Long getEmpTemp() {
        return empTemp;
    }

    /**
     * @param empTemp the empTemp to set
     */
    public void setEmpTemp(Long empTemp) {
        this.empTemp = empTemp;
    }

    /**
     * @return the empPlanta
     */
    public Long getEmpPlanta() {
        return empPlanta;
    }

    /**
     * @param empPlanta the empPlanta to set
     */
    public void setEmpPlanta(Long empPlanta) {
        this.empPlanta = empPlanta;
    }

    /**
     * @return the dirCedulaE
     */
    public Long getDirCedulaE() {
        return dirCedulaE;
    }

    /**
     * @param dirCedulaE the dirCedulaE to set
     */
    public void setDirCedulaE(Long dirCedulaE) {
        this.dirCedulaE = dirCedulaE;
    }
    
}
