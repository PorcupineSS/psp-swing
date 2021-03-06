--VISTAS SYBASE

if exists (select 1
            from  sysobjects
            where  id = object_id('V_ACIMPL')
            and   type = 'V')
   drop view V_ACIMPL
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_AIMPL')
            and   type = 'V')
   drop view V_AIMPL
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_ASIGC')
            and   type = 'V')
   drop view V_ASIGC
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_BITACORA')
            and   type = 'V')
   drop view V_BITACORA
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_CLIENTE')
            and   type = 'V')
   drop view V_CLIENTE
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_COMUN')
            and   type = 'V')
   drop view V_COMUN
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_CONT')
            and   type = 'V')
   drop view V_CONT
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_EMPL')
            and   type = 'V')
   drop view V_EMPL
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_IMSEG')
            and   type = 'V')
   drop view V_IMSEG
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_PROV')
            and   type = 'V')
   drop view V_PROV
go

/*==============================================================*/
/* View: V_BITACORA                                               */
/*==============================================================*/
create view V_BITACORA as
select
   BITACORA_SEG.CEDULAE,
   BITACORA_SEG.FECHA_OPER,
   BITACORA_SEG.USU_OPER,
   BITACORA_SEG.MAQ_OPER,
   BITACORA_SEG.TABLA_MOD,
   BITACORA_SEG.TIPO_OPER
from
   BITACORA_SEG
go

/*==============================================================*/
/* View: V_EMPL     EMPLEADOS                                   */
/*==============================================================*/
create view V_EMPL as
select
   EMPLEADOS.CEDULAE,
   EMPLEADOS.DIR_CEDULAE,
   EMPLEADOS.NOMBREE,
   EMPLEADOS.APELLIDOE,
   EMPLEADOS.CONTRASENAE,
   EMPLEADOS.CODDOCUME,
   EMPLEADOS.FECHAREG
from
   EMPLEADOS
go

/*==============================================================*/
/* View: V_COMUN         COMUNICADO                             */
/*==============================================================*/
create view V_COMUN as
select
   COMUNICADO.CEDULAE,
   COMUNICADO.DIR_CEDULAE,
   COMUNICADO.TIPO_CO,
   COMUNICADO.FECHA_CO,
   COMUNICADO.CONTENIDO_CO,
   COMUNICADO.URGENTE,
   COMUNICADO.RESPUESTA_CO
from
   COMUNICADO
go

/*==============================================================*/
/* View: V_ASIGC     ASIGNACION DE CONTRATO                     */
/*==============================================================*/
create view V_ASIGC as
select
   ASIGNACION_C.ID_CONTRATO,
   ASIGNACION_C.COO_CEDULAE,
   ASIGNACION_C.EMP_TEMP_CEDULAE,
   ASIGNACION_C.FECHA_ASIGNACION_C,
   ASIGNACION_C.HORARIO_ASIGNADO
from
   ASIGNACION_C
go

/*==============================================================*/
/* View: V_CLIENTE                                              */
/*==============================================================*/
create view V_CLIENTE as
select
   CLIENTE.CEDULAE,
   CLIENTE.NOMBRECL,
   CLIENTE.DIRECCIONCL,
   CLIENTE.FECHA_REG_CL
from
   CLIENTE
go

/*==============================================================*/
/* View: V_CONT      CONTRATO                                   */
/*==============================================================*/
create view V_CONT as
select
   CONTRATO.IDCL,
   CONTRATO.CEDULAE,
   CONTRATO.UBICACION_C,
   CONTRATO.TELEFONO_C,
   CONTRATO.CELULAR_C,
   CONTRATO.TIPO_C,
   CONTRATO.FECHA_INICIO_C,
   CONTRATO.TIPO_PERSONAL_C,
   CONTRATO.CANTIDAD_PERSONAL_C,
   CONTRATO.COSTO_MENSUAL_C,
   CONTRATO.HORARIO_C,
   CONTRATO.TIEMPO_C,
   CONTRATO.FECHA_REG_CON
from
   CONTRATO
go

/*==============================================================*/
/* View: V_IMSEG          IMPLEMENTO DE SEGURIDAD               */
/*==============================================================*/
create view V_IMSEG as
select
   IMPL_SEGURIDAD.CEDULAE,
   IMPL_SEGURIDAD.NOMBRE_I,
   IMPL_SEGURIDAD.PRECIO_UNITARIO_I,
   IMPL_SEGURIDAD.CANTIDAD,
   IMPL_SEGURIDAD.DESCRIPCION_I,
   IMPL_SEGURIDAD.ESTADO_I,
   IMPL_SEGURIDAD.FECHA_REG_IM
from
   IMPL_SEGURIDAD
go

/*==============================================================*/
/* View: V_PROV            PROVEEDOR                            */
/*==============================================================*/
create view V_PROV as
select
   PROVEEDOR.CEDULAE,
   PROVEEDOR.NOMBRE,
   PROVEEDOR.DIRECCION,
   PROVEEDOR.FECHA_REG_PROV
from
   PROVEEDOR
go

/*==============================================================*/
/* View: V_AIMPL         ASGINACION IMPLEMENTO                  */
/*==============================================================*/
create view V_AIMPL as
select
   ASIG_IMPL.ID_IMPLEMENTO,
   ASIG_IMPL.CEDULAE,
   ASIG_IMPL.COO_CEDULAE,
   ASIG_IMPL.CANTIDAD_ASIGNADA,
   ASIG_IMPL.ESTADO_ASIGNACION,
   ASIG_IMPL.FECHA_ASIGNACION_I
from
   ASIG_IMPL
go

/*==============================================================*/
/* View: V_ACIMPL       ACTUALIZACION IMPLEMENTO                */
/*==============================================================*/
create view V_ACIMPL as
select
   ACTU_IMPL.ID_IMPLEMENTO,
   ACTU_IMPL.CEDULAE,
   ACTU_IMPL.FECHA_ACTUALIZACION_I,
   ACTU_IMPL.CANTIDAD_AGREGADA,
   ACTU_IMPL.DESCRIPCION_ACTUALIZACION
from
   ACTU_IMPL
go