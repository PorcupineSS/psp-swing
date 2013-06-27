package com.porcupine.psp.model.entity.one;

import com.porcupine.psp.model.entity.Cliente;
import com.porcupine.psp.model.entity.Contrato;
import com.porcupine.psp.model.entity.DirComercial;
import com.porcupine.psp.model.entity.TelsCli;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-05-29T00:14:58")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Short> idcl;
    public static volatile SingularAttribute<Cliente, String> direccioncl;
    public static volatile SingularAttribute<Cliente, DirComercial> cedulae;
    public static volatile ListAttribute<Cliente, Contrato> contratoList;
    public static volatile SingularAttribute<Cliente, Date> fechaRegCl;
    public static volatile ListAttribute<Cliente, TelsCli> telsCliList;
    public static volatile SingularAttribute<Cliente, String> nombrecl;

}