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
@Table(name = "STOCK_IMPL_SEGURIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockImplSeguridad.findAll", query = "SELECT s FROM StockImplSeguridad s"),
    @NamedQuery(name = "StockImplSeguridad.findByIdStock", query = "SELECT s FROM StockImplSeguridad s WHERE s.idStock = :idStock"),
    @NamedQuery(name = "StockImplSeguridad.findByIdImpl", query = "SELECT s FROM StockImplSeguridad s WHERE s.idImpl = :idImpl"),
    @NamedQuery(name = "StockImplSeguridad.findByFecha", query = "SELECT s FROM StockImplSeguridad s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "StockImplSeguridad.findByCantidad", query = "SELECT s FROM StockImplSeguridad s WHERE s.cantidad = :cantidad")})
public class StockImplSeguridad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_STOCK")
    private Long idStock;
    @Basic(optional = false)
    @Column(name = "ID_IMPL")
    private BigInteger idImpl;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;

    public StockImplSeguridad() {
    }

    public StockImplSeguridad(Long idStock) {
        this.idStock = idStock;
    }

    public StockImplSeguridad(Long idStock, BigInteger idImpl, Date fecha, BigInteger cantidad) {
        this.idStock = idStock;
        this.idImpl = idImpl;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public Long getIdStock() {
        return idStock;
    }

    public void setIdStock(Long idStock) {
        this.idStock = idStock;
    }

    public BigInteger getIdImpl() {
        return idImpl;
    }

    public void setIdImpl(BigInteger idImpl) {
        this.idImpl = idImpl;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStock != null ? idStock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockImplSeguridad)) {
            return false;
        }
        StockImplSeguridad other = (StockImplSeguridad) object;
        if ((this.idStock == null && other.idStock != null) || (this.idStock != null && !this.idStock.equals(other.idStock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.porcupine.psp.model.entity.view.StockImplSeguridad[ idStock=" + idStock + " ]";
    }
    
}
