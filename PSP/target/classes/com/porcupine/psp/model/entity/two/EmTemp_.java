package com.porcupine.psp.model.entity.two;

import com.porcupine.psp.model.entity.AsigImpl;
import com.porcupine.psp.model.entity.AsignacionC;
import com.porcupine.psp.model.entity.Comunicado;
import com.porcupine.psp.model.entity.EmTemp;
import com.porcupine.psp.model.entity.Empleados;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(EmTemp.class)
public class EmTemp_ { 

    public static volatile SingularAttribute<EmTemp, AsignacionC> idAsig;
    public static volatile ListAttribute<EmTemp, AsigImpl> asigImplList;
    public static volatile SingularAttribute<EmTemp, Long> cedulae;
    public static volatile SingularAttribute<EmTemp, Boolean> tieneContrato;
    public static volatile SingularAttribute<EmTemp, Empleados> empleados;
    public static volatile SingularAttribute<EmTemp, String> tipoTemp;
    public static volatile ListAttribute<EmTemp, Comunicado> comunicadoList;

}