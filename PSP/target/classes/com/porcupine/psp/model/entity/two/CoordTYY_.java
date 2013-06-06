package com.porcupine.psp.model.entity.two;

import com.porcupine.psp.model.entity.ActuImpl;
import com.porcupine.psp.model.entity.AsigImpl;
import com.porcupine.psp.model.entity.CoordTYY;
import com.porcupine.psp.model.entity.EmpPlanta;
import com.porcupine.psp.model.entity.ImplSeguridad;
import com.porcupine.psp.model.entity.Proveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(CoordTYY.class)
public class CoordTYY_ { 

    public static volatile ListAttribute<CoordTYY, AsigImpl> asigImplList;
    public static volatile ListAttribute<CoordTYY, ImplSeguridad> implSeguridadList;
    public static volatile SingularAttribute<CoordTYY, Long> cedulae;
    public static volatile SingularAttribute<CoordTYY, EmpPlanta> empPlanta;
    public static volatile ListAttribute<CoordTYY, Proveedor> proveedorList;
    public static volatile ListAttribute<CoordTYY, ActuImpl> actuImplList;

}