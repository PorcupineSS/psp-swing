package com.porcupine.psp.model.entity.view.two;

import com.porcupine.psp.model.entity.view.VBitacora;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(VBitacora.class)
public class VBitacora_ { 

    public static volatile SingularAttribute<VBitacora, String> tablaMod;
    public static volatile SingularAttribute<VBitacora, BigInteger> cedulae;
    public static volatile SingularAttribute<VBitacora, String> tipoOper;
    public static volatile SingularAttribute<VBitacora, String> usuOper;
    public static volatile SingularAttribute<VBitacora, String> maqOper;
    public static volatile SingularAttribute<VBitacora, Date> fechaOper;

}