package com.porcupine.psp.model.entity.three;

import com.porcupine.psp.model.entity.AsigImpl;
import com.porcupine.psp.model.entity.CoordTYY;
import com.porcupine.psp.model.entity.EmTemp;
import com.porcupine.psp.model.entity.ImplSeguridad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(AsigImpl.class)
public class AsigImpl_ { 

    public static volatile SingularAttribute<AsigImpl, ImplSeguridad> idImplemento;
    public static volatile SingularAttribute<AsigImpl, EmTemp> cedulae;
    public static volatile SingularAttribute<AsigImpl, CoordTYY> cooCedulae;
    public static volatile SingularAttribute<AsigImpl, Short> idAsignacionI;
    public static volatile SingularAttribute<AsigImpl, Short> cantidadAsignada;
    public static volatile SingularAttribute<AsigImpl, Date> fechaAsignacionI;
    public static volatile SingularAttribute<AsigImpl, Boolean> estadoAsignacion;

}