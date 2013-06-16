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
 * @author andres
 */
public class ImplSeguridadVO implements IValueObject, Serializable {
    
    private static final long serialVersionUID = 1L;

    Short idImplemento;
    String nombreI;
    BigDecimal precioUnitarioI;
    short cantidad;
    String descripcionI;
    String estadoI;
    Date fechaRegIm;
    Proveedor idPro;
    CoordTYT cedulae;
    List<AsigImplVO> asigImplList;
    List<ActuImplVO> actuImplList;
    
}
