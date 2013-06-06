package com.porcupine.psp.model.entity.one;

import com.porcupine.psp.model.entity.AsignacionC;
import com.porcupine.psp.model.entity.Cliente;
import com.porcupine.psp.model.entity.Contrato;
import com.porcupine.psp.model.entity.DirComercial;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(Contrato.class)
public class Contrato_ { 

    public static volatile SingularAttribute<Contrato, Integer> tiempoC;
    public static volatile SingularAttribute<Contrato, BigDecimal> costoMensualC;
    public static volatile SingularAttribute<Contrato, Integer> celularC;
    public static volatile ListAttribute<Contrato, AsignacionC> asignacionCList;
    public static volatile SingularAttribute<Contrato, String> horarioC;
    public static volatile SingularAttribute<Contrato, Short> idContrato;
    public static volatile SingularAttribute<Contrato, Short> cantidadPersonalC;
    public static volatile SingularAttribute<Contrato, Date> fechaRegCon;
    public static volatile SingularAttribute<Contrato, Cliente> idcl;
    public static volatile SingularAttribute<Contrato, Integer> telefonoC;
    public static volatile SingularAttribute<Contrato, DirComercial> cedulae;
    public static volatile SingularAttribute<Contrato, String> tipoC;
    public static volatile SingularAttribute<Contrato, String> ubicacionC;
    public static volatile SingularAttribute<Contrato, String> tipoPersonalC;
    public static volatile SingularAttribute<Contrato, Date> fechaInicioC;

}