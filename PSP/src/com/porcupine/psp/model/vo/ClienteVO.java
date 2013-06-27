/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author sparrow
 */
public class ClienteVO implements IValueObject {

    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    //No es opcional
    private Short idCliente;
    //No es opcional
    private String nombreCliente;
    //No es opcional
    private String direccionCliente;
    
    
    private Date fechaRegCliente;
    
    //Como mapear los muchos a muchos
    private List<TelefonosVO> telsCliList;
    
    //external
    private Integer cedulaDirector;
    private List<ContratoVO> contratoList;

    /**
     * @return the idCliente
     */
    public Short getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Short idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the direccionCliente
     */
    public String getDireccionCliente() {
        return direccionCliente;
    }

    /**
     * @param direccionCliente the direccionCliente to set
     */
    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    /**
     * @return the fechaRegCl
     */
    public Date getFechaRegCliente() {
        return fechaRegCliente;
    }

    /**
     * @param fechaRegCl the fechaRegCl to set
     */
    public void setFechaRegCliente(Date fechaRegCl) {
        this.fechaRegCliente = fechaRegCl;
    }

    /**
     * @return the telsCliList
     */
    public List<TelefonosVO> getTelsCliList() {
        return telsCliList;
    }

    /**
     * @param telsCliList the telsCliList to set
     */
    public void setTelsCliList(List<TelefonosVO> telsCliList) {
        this.telsCliList = telsCliList;
    }

    /**
     * @return the cedulae
     */
    public Integer getCedulaDirector() {
        return cedulaDirector;
    }

    /**
     * @param cedulae the cedulae to set
     */
    public void setCedulaDirector(Integer cedulae) {
        this.cedulaDirector = cedulae;
    }

    /**
     * @return the contratoList
     */
    public List<ContratoVO> getContratoList() {
        return contratoList;
    }

    /**
     * @param contratoList the contratoList to set
     */
    public void setContratoList(List<ContratoVO> contratoList) {
        this.contratoList = contratoList;
    }
    
    
    
}
