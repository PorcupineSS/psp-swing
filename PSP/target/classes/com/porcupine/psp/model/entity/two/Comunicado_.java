package com.porcupine.psp.model.entity.two;

import com.porcupine.psp.model.entity.Comunicado;
import com.porcupine.psp.model.entity.DirOperaciones;
import com.porcupine.psp.model.entity.EmTemp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(Comunicado.class)
public class Comunicado_ { 

    public static volatile SingularAttribute<Comunicado, String> contenidoCo;
    public static volatile SingularAttribute<Comunicado, EmTemp> cedulae;
    public static volatile SingularAttribute<Comunicado, String> respuestaCo;
    public static volatile SingularAttribute<Comunicado, String> tipoCo;
    public static volatile SingularAttribute<Comunicado, Date> fechaCo;
    public static volatile SingularAttribute<Comunicado, DirOperaciones> dirCedulae;
    public static volatile SingularAttribute<Comunicado, Short> idComunicado;
    public static volatile SingularAttribute<Comunicado, Boolean> urgente;

}