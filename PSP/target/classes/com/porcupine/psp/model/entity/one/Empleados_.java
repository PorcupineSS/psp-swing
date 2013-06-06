package com.porcupine.psp.model.entity.one;

import com.porcupine.psp.model.entity.BitacoraSeg;
import com.porcupine.psp.model.entity.DirGestionHum;
import com.porcupine.psp.model.entity.EmTemp;
import com.porcupine.psp.model.entity.EmpPlanta;
import com.porcupine.psp.model.entity.Empleados;
import com.porcupine.psp.model.entity.TelsEmp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(Empleados.class)
public class Empleados_ { 

    public static volatile SingularAttribute<Empleados, String> coddocume;
    public static volatile SingularAttribute<Empleados, String> nombree;
    public static volatile SingularAttribute<Empleados, Long> cedulae;
    public static volatile SingularAttribute<Empleados, EmpPlanta> empPlanta;
    public static volatile ListAttribute<Empleados, TelsEmp> telsEmpList;
    public static volatile SingularAttribute<Empleados, String> apellidoe;
    public static volatile ListAttribute<Empleados, BitacoraSeg> bitacoraSegList;
    public static volatile SingularAttribute<Empleados, Date> fechareg;
    public static volatile SingularAttribute<Empleados, EmTemp> emTemp;
    public static volatile SingularAttribute<Empleados, String> contrasenae;
    public static volatile SingularAttribute<Empleados, DirGestionHum> dirCedulae;

}