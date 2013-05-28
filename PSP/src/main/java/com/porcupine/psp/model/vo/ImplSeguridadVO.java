/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import com.porcupine.psp.model.entity.ActuImpl;
import com.porcupine.psp.model.entity.AsigImpl;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author javergarav
 */
public class ImplSeguridadVO implements IValueObject {
    
    private Short idImplemento;
    private String nombreI;
    private BigDecimal precioUnitarioI;
    private short cantidadI;
    private String descripcionI;
    private String estadoI;
    private Date fechaRegI;
    private int idPro;
    private Long cedulaE;
    private List<AsigImplVO> asigImplList;
    private List<ActuImplVO> actuImplList;

    /**
     * @return the idImplemento
     */
    public Short getIdImplemento() {
        return idImplemento;
    }

    /**
     * @param idImplemento the idImplemento to set
     */
    public void setIdImplemento(Short idImplemento) {
        this.idImplemento = idImplemento;
    }

    /**
     * @return the nombreI
     */
    public String getNombreI() {
        return nombreI;
    }

    /**
     * @param nombreI the nombreI to set
     */
    public void setNombreI(String nombreI) {
        this.nombreI = nombreI;
    }

    /**
     * @return the precioUnitarioI
     */
    public BigDecimal getPrecioUnitarioI() {
        return precioUnitarioI;
    }

    /**
     * @param precioUnitarioI the precioUnitarioI to set
     */
    public void setPrecioUnitarioI(BigDecimal precioUnitarioI) {
        this.precioUnitarioI = precioUnitarioI;
    }

    /**
     * @return the cantidadI
     */
    public short getCantidadI() {
        return cantidadI;
    }

    /**
     * @param cantidadI the cantidadI to set
     */
    public void setCantidadI(short cantidadI) {
        this.cantidadI = cantidadI;
    }

    /**
     * @return the descripcionI
     */
    public String getDescripcionI() {
        return descripcionI;
    }

    /**
     * @param descripcionI the descripcionI to set
     */
    public void setDescripcionI(String descripcionI) {
        this.descripcionI = descripcionI;
    }

    /**
     * @return the estadoI
     */
    public String getEstadoI() {
        return estadoI;
    }

    /**
     * @param estadoI the estadoI to set
     */
    public void setEstadoI(String estadoI) {
        this.estadoI = estadoI;
    }

    /**
     * @return the fechaRegI
     */
    public Date getFechaRegI() {
        return fechaRegI;
    }

    /**
     * @param fechaRegI the fechaRegI to set
     */
    public void setFechaRegI(Date fechaRegI) {
        this.fechaRegI = fechaRegI;
    }

    /**
     * @return the idPro
     */
    public int getIdPro() {
        return idPro;
    }

    /**
     * @param idPro the idPro to set
     */
    public void setIdPro(int idPro) {
        this.idPro = idPro;
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
     * @return the asigImplList
     */
    public List<AsigImplVO> getAsigImplList() {
        return asigImplList;
    }

    /**
     * @param asigImplList the asigImplList to set
     */
    public void setAsigImplList(List<AsigImplVO> asigImplList) {
        this.asigImplList = asigImplList;
    }

    /**
     * @return the actuImplList
     */
    public List<ActuImplVO> getActuImplList() {
        return actuImplList;
    }

    /**
     * @param actuImplList the actuImplList to set
     */
    public void setActuImplList(List<ActuImplVO> actuImplList) {
        this.actuImplList = actuImplList;
    }

    
    
}
