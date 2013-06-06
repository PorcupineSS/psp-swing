package com.porcupine.psp.model.entity.view.three;

import com.porcupine.psp.model.entity.view.VComun;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(VComun.class)
public class VComun_ { 

    public static volatile SingularAttribute<VComun, BigInteger> cedulae;
    public static volatile SingularAttribute<VComun, String> contenidoCo;
    public static volatile SingularAttribute<VComun, String> respuestaCo;
    public static volatile SingularAttribute<VComun, String> tipoCo;
    public static volatile SingularAttribute<VComun, Date> fechaCo;
    public static volatile SingularAttribute<VComun, BigInteger> dirCedulae;
    public static volatile SingularAttribute<VComun, Boolean> urgente;

}