package com.porcupine.psp.model.entity.one;

import com.porcupine.psp.model.entity.ActuImpl;
import com.porcupine.psp.model.entity.AsigImpl;
import com.porcupine.psp.model.entity.CoordTYY;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.entity.Proveedor;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(ImplSeguridad.class)
public class ImplSeguridad_ { 

    public static volatile SingularAttribute<ImplSeguridad, Short> idImplemento;
    public static volatile ListAttribute<ImplSeguridad, AsigImpl> asigImplList;
    public static volatile SingularAttribute<ImplSeguridad, String> estadoI;
    public static volatile SingularAttribute<ImplSeguridad, CoordTYY> cedulae;
    public static volatile SingularAttribute<ImplSeguridad, BigDecimal> precioUnitarioI;
    public static volatile SingularAttribute<ImplSeguridad, Short> cantidad;
    public static volatile SingularAttribute<ImplSeguridad, Date> fechaRegIm;
    public static volatile SingularAttribute<ImplSeguridad, Proveedor> idPro;
    public static volatile SingularAttribute<ImplSeguridad, String> descripcionI;
    public static volatile SingularAttribute<ImplSeguridad, String> nombreI;
    public static volatile ListAttribute<ImplSeguridad, ActuImpl> actuImplList;

}