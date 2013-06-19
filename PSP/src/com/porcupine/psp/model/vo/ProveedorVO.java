/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porcupine.psp.model.vo;

import com.porcupine.psp.model.entity.CoordTYT;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.entity.TelsProv;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Johan
 */
public class ProveedorVO {
        private static final long serialVersionUID = 1L;

    private Short idPro;
    private String nombre;
    private String direccion;
    private Date fechaRegProv;
    private List<ImplSeguridadVO> implSeguridadList;
    private Integer cedulae;
    private List<TelefonosVO> telsProvList;

    public Short getIdPro() {
        return idPro;
    }

    public void setIdPro(Short idPro) {
        this.idPro = idPro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaRegProv() {
        return fechaRegProv;
    }

    public void setFechaRegProv(Date fechaRegProv) {
        this.fechaRegProv = fechaRegProv;
    }

    public List<ImplSeguridadVO> getImplSeguridadList() {
        return implSeguridadList;
    }

    public void setImplSeguridadList(List<ImplSeguridadVO> implSeguridadList) {
        this.implSeguridadList = implSeguridadList;
    }

    public Integer getCedulae() {
        return cedulae;
    }

    public void setCedulae(Integer cedulae) {
        this.cedulae = cedulae;
    }

    public List<TelefonosVO> getTelsProvList() {
        return telsProvList;
    }

    public void setTelsProvList(List<TelefonosVO> telsProvList) {
        this.telsProvList = telsProvList;
    }
    
}
