/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import com.porcupine.psp.model.entity.CoordTYT;
import com.porcupine.psp.model.entity.Proveedor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jeisson Andrés Vergara
 */
public class ImplSeguridadVO implements IValueObject, Serializable {
    
    private static final long serialVersionUID = 1L;

    private Short idImplemento;
    private String nombreI;
    private BigDecimal precioUnitarioI;
    private short cantidad;
    private String descripcionI;
    private String estadoI;
    private Date fechaRegIm;
    //Proveedor idPro;
    private Short idPro;
    //CoordTYT cedulae;
    private int cedulaCoordTyT;
    private List<AsigImplVO> asigImplList;
    private List<ActuImplVO> actuImplList;

    public Short getIdImplemento() {
        return idImplemento;
    }

    public void setIdImplemento(Short idImplemento) {
        this.idImplemento = idImplemento;
    }

    public String getNombreI() {
        return nombreI;
    }

    public void setNombreI(String nombreI) {
        this.nombreI = nombreI;
    }

    public BigDecimal getPrecioUnitarioI() {
        return precioUnitarioI;
    }

    public void setPrecioUnitarioI(BigDecimal precioUnitarioI) {
        this.precioUnitarioI = precioUnitarioI;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcionI() {
        return descripcionI;
    }

    public void setDescripcionI(String descripcionI) {
        this.descripcionI = descripcionI;
    }

    public String getEstadoI() {
        return estadoI;
    }

    public void setEstadoI(String estadoI) {
        this.estadoI = estadoI;
    }

    public Date getFechaRegIm() {
        return fechaRegIm;
    }

    public void setFechaRegIm(Date fechaRegIm) {
        this.fechaRegIm = fechaRegIm;
    }

    public Short getIdPro() {
        return idPro;
    }

    public void setIdPro(Short idPro) {
        this.idPro = idPro;
    }

    public int getCedulaCoordTyT() {
        return cedulaCoordTyT;
    }

    public void setCedulaCoordTyT(int cedulaCoordTyT) {
        this.cedulaCoordTyT = cedulaCoordTyT;
    }

    public List<AsigImplVO> getAsigImplList() {
        return asigImplList;
    }

    public void setAsigImplList(List<AsigImplVO> asigImplList) {
        this.asigImplList = asigImplList;
    }

    public List<ActuImplVO> getActuImplList() {
        return actuImplList;
    }

    public void setActuImplList(List<ActuImplVO> actuImplList) {
        this.actuImplList = actuImplList;
    }
}
