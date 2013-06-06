package com.porcupine.psp.model.entity.one;

import com.porcupine.psp.model.entity.ActuImpl;
import com.porcupine.psp.model.entity.CoordTYY;
import com.porcupine.psp.model.entity.ImplSeguridad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(ActuImpl.class)
public class ActuImpl_ { 

    public static volatile SingularAttribute<ActuImpl, String> descripcionActualizacion;
    public static volatile SingularAttribute<ActuImpl, ImplSeguridad> idImplemento;
    public static volatile SingularAttribute<ActuImpl, CoordTYY> cedulae;
    public static volatile SingularAttribute<ActuImpl, Short> cantidadAgregada;
    public static volatile SingularAttribute<ActuImpl, Short> idActualizacionI;
    public static volatile SingularAttribute<ActuImpl, Date> fechaActualizacionI;

}