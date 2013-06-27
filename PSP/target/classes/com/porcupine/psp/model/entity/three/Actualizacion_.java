package com.porcupine.psp.model.entity.three;

import com.porcupine.psp.model.entity.Actualizacion;
import com.porcupine.psp.model.entity.ActualizacionPK;
import com.porcupine.psp.model.entity.DirGestionHum;
import com.porcupine.psp.model.entity.Subgerente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(Actualizacion.class)
public class Actualizacion_ { 

    public static volatile SingularAttribute<Actualizacion, Subgerente> subgerente;
    public static volatile SingularAttribute<Actualizacion, ActualizacionPK> actualizacionPK;
    public static volatile SingularAttribute<Actualizacion, DirGestionHum> dirGestionHum;
    public static volatile SingularAttribute<Actualizacion, Date> fechaActualDgh;

}