package com.porcupine.psp.model.entity.three;

import com.porcupine.psp.model.entity.CoordContrato;
import com.porcupine.psp.model.entity.CoordTYY;
import com.porcupine.psp.model.entity.DirComercial;
import com.porcupine.psp.model.entity.DirGestionHum;
import com.porcupine.psp.model.entity.DirOperaciones;
import com.porcupine.psp.model.entity.EmpPlanta;
import com.porcupine.psp.model.entity.Empleados;
import com.porcupine.psp.model.entity.Subgerente;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(EmpPlanta.class)
public class EmpPlanta_ { 

    public static volatile SingularAttribute<EmpPlanta, DirOperaciones> dirOperaciones;
    public static volatile SingularAttribute<EmpPlanta, Long> cedulae;
    public static volatile SingularAttribute<EmpPlanta, CoordContrato> coordContrato;
    public static volatile SingularAttribute<EmpPlanta, Subgerente> subgerente;
    public static volatile SingularAttribute<EmpPlanta, Empleados> empleados;
    public static volatile SingularAttribute<EmpPlanta, CoordTYY> coordTYY;
    public static volatile SingularAttribute<EmpPlanta, DirComercial> dirComercial;
    public static volatile SingularAttribute<EmpPlanta, BigDecimal> sueldoe;
    public static volatile SingularAttribute<EmpPlanta, DirGestionHum> dirGestionHum;

}