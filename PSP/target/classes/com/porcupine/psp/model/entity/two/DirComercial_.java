package com.porcupine.psp.model.entity.two;

import com.porcupine.psp.model.entity.Cliente;
import com.porcupine.psp.model.entity.Contrato;
import com.porcupine.psp.model.entity.DirComercial;
import com.porcupine.psp.model.entity.EmpPlanta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(DirComercial.class)
public class DirComercial_ { 

    public static volatile SingularAttribute<DirComercial, Long> cedulae;
    public static volatile SingularAttribute<DirComercial, EmpPlanta> empPlanta;
    public static volatile ListAttribute<DirComercial, Contrato> contratoList;
    public static volatile ListAttribute<DirComercial, Cliente> clienteList;

}