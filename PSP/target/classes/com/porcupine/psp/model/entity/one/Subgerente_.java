package com.porcupine.psp.model.entity.one;

import com.porcupine.psp.model.entity.Actualizacion;
import com.porcupine.psp.model.entity.EmpPlanta;
import com.porcupine.psp.model.entity.Subgerente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(Subgerente.class)
public class Subgerente_ { 

    public static volatile SingularAttribute<Subgerente, Long> cedulae;
    public static volatile SingularAttribute<Subgerente, EmpPlanta> empPlanta;
    public static volatile ListAttribute<Subgerente, Actualizacion> actualizacionList;

}