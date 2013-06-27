package com.porcupine.psp.model.entity.two;

import com.porcupine.psp.model.entity.CoordTYY;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.entity.Proveedor;
import com.porcupine.psp.model.entity.TelsProv;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, String> nombre;
    public static volatile SingularAttribute<Proveedor, String> direccion;
    public static volatile ListAttribute<Proveedor, ImplSeguridad> implSeguridadList;
    public static volatile SingularAttribute<Proveedor, CoordTYY> cedulae;
    public static volatile SingularAttribute<Proveedor, Date> fechaRegProv;
    public static volatile SingularAttribute<Proveedor, Short> idPro;
    public static volatile ListAttribute<Proveedor, TelsProv> telsProvList;

}