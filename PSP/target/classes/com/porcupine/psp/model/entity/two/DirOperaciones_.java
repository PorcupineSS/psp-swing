package com.porcupine.psp.model.entity.two;

import com.porcupine.psp.model.entity.Comunicado;
import com.porcupine.psp.model.entity.DirOperaciones;
import com.porcupine.psp.model.entity.EmpPlanta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(DirOperaciones.class)
public class DirOperaciones_ { 

    public static volatile SingularAttribute<DirOperaciones, Long> cedulae;
    public static volatile SingularAttribute<DirOperaciones, EmpPlanta> empPlanta;
    public static volatile ListAttribute<DirOperaciones, Comunicado> comunicadoList;

}