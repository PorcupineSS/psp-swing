package com.porcupine.psp.model.entity.two;

import com.porcupine.psp.model.entity.AsignacionC;
import com.porcupine.psp.model.entity.Contrato;
import com.porcupine.psp.model.entity.CoordContrato;
import com.porcupine.psp.model.entity.EmTemp;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(AsignacionC.class)
public class AsignacionC_ { 

    public static volatile SingularAttribute<AsignacionC, Short> idAsig;
    public static volatile SingularAttribute<AsignacionC, BigInteger> cedulae;
    public static volatile SingularAttribute<AsignacionC, CoordContrato> cooCedulae;
    public static volatile SingularAttribute<AsignacionC, Date> fechaAsignacionC;
    public static volatile SingularAttribute<AsignacionC, Contrato> idContrato;
    public static volatile SingularAttribute<AsignacionC, String> horarioAsignado;
    public static volatile ListAttribute<AsignacionC, EmTemp> emTempList;

}