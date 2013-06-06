package com.porcupine.psp.model.entity.two;

import com.porcupine.psp.model.entity.AsignacionC;
import com.porcupine.psp.model.entity.CoordContrato;
import com.porcupine.psp.model.entity.EmpPlanta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(CoordContrato.class)
public class CoordContrato_ { 

    public static volatile SingularAttribute<CoordContrato, Long> cedulae;
    public static volatile SingularAttribute<CoordContrato, EmpPlanta> empPlanta;
    public static volatile ListAttribute<CoordContrato, AsignacionC> asignacionCList;

}