package com.porcupine.psp.model.entity.three;

import com.porcupine.psp.model.entity.Actualizacion;
import com.porcupine.psp.model.entity.DirGestionHum;
import com.porcupine.psp.model.entity.EmpPlanta;
import com.porcupine.psp.model.entity.Empleados;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(DirGestionHum.class)
public class DirGestionHum_ { 

    public static volatile SingularAttribute<DirGestionHum, Long> cedulae;
    public static volatile SingularAttribute<DirGestionHum, EmpPlanta> empPlanta;
    public static volatile ListAttribute<DirGestionHum, Empleados> empleadosList;
    public static volatile ListAttribute<DirGestionHum, Actualizacion> actualizacionList;

}