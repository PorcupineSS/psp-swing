--Vistas Oracle

/*==========================================================*/
/* View: OPERACIONES CRUD BITACORA                         */
/*==========================================================*/

create or replace view V_BITACORA as
select
   BITACORA_SEG.FECHA_OPER,
   BITACORA_SEG.USU_OPER,
   BITACORA_SEG.MAQ_OPER,
   BITACORA_SEG.TABLA_MOD,
   BITACORA_SEG.TIPO_OPER
from
   BITACORA_SEG
with read only;

/*==============================================================*/
/* View: OPERACIONES CRUD EMPLEADOS                             */
/*==============================================================*/
create or replace view V_EMPL as
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
with read only;

/*==============================================================*/
/* View: OEPRACIONES CRUD COMUNICADOS                           */
/*==============================================================*/
create or replace view V_COMUN as
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
with read only;

comment on column V_COMUN.TIPO_CO is
'Tipo de comunicado (Reclamo, Queja o Sugerencia).';

comment on column V_COMUN.FECHA_CO is
'Fecha en que se realiza el comunicado.';

comment on column V_COMUN.CONTENIDO_CO is
'Contenido del comunicado.';

comment on column V_COMUN.URGENTE is
'Es urgente o no el comunicado.';

comment on column V_COMUN.RESPUESTA_CO is
'Respuesta al comunicado.';


/*==============================================================*/
/* View: OPERACIONES CRUD CLIENTE                               */
/*==============================================================*/
create or replace view V_CLIENTE as
select
   CLIENTE.CEDULAE,
   CLIENTE.NOMBRECL,
   CLIENTE.DIRECCIONCL,
   CLIENTE.FECHA_REG_CL
from
   CLIENTE
with read only;


comment on column V_CLIENTE.NOMBRECL is
'Nombre del cliente.';

comment on column V_CLIENTE.DIRECCIONCL is
'Direccion del cliente.';


/*==============================================================*/
/* View: OPERACIONES CRUD ASIGNACION DE CONTRATO                */
/*==============================================================*/
create or replace view V_ASIGC as
select
   ASIGNACION_C.ID_CONTRATO,
   ASIGNACION_C.COO_CEDULAE,
   ASIGNACION_C.EMP_TEMP_CEDULAE,
   ASIGNACION_C.FECHA_ASIGNACION_C,
   ASIGNACION_C.HORARIO_ASIGNADO
from
   ASIGNACION_C
with read only;


comment on column V_ASIGC.ID_CONTRATO is
'Identificador del contrato.';

comment on column V_ASIGC.FECHA_ASIGNACION_C is
'Fecha de la asignación del contrato.';

comment on column V_ASIGC.HORARIO_ASIGNADO is
'Horario asignado en el contrato.';


/*==============================================================*/
/* View: OPERACIONES CRUD CONTRATO                              */
/*==============================================================*/
create or replace view V_CONT as
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
with read only;

comment on column V_CONT.IDCL is
'Identificador del cliente.';

comment on column V_CONT.UBICACION_C is
'Ubicacion donde se cumplira el contrato.';

comment on column V_CONT.TELEFONO_C is
'Telefono del lugar donde se cumplira el contrato.';

comment on column V_CONT.CELULAR_C is
'Celular del lugar donde se cumplira el contrato.';

comment on column V_CONT.TIPO_C is
'Tipo de contrato (Definido o Indefinido).';

comment on column V_CONT.FECHA_INICIO_C is
'Fecha de inicio del contrato.';

comment on column V_CONT.TIPO_PERSONAL_C is
'Tipo de personal solicitado en el contrato (Vigilantes y/o Escoltas).';

comment on column V_CONT.CANTIDAD_PERSONAL_C is
'Cantidad de personal solicitado en el contrato.';

comment on column V_CONT.COSTO_MENSUAL_C is
'Costo mensual total del contrato.';

comment on column V_CONT.HORARIO_C is
'Horarios de personal solicitados en el contrato.';

comment on column V_CONT.TIEMPO_C is
'Si en contrato es de tipo definido este campo tendra el tiempo total del contrato, si no lo es podra ser null.';


/*==============================================================*/
/* View: OPERACIONES CRUD IMPLEMENTO DE SEGURIDAD          */
/*==============================================================*/
create or replace view V_IMPL as
select
   IMPL_SEGURIDAD.ID_PRO,
   IMPL_SEGURIDAD.CEDULAE,
   IMPL_SEGURIDAD.NOMBRE_I,
   IMPL_SEGURIDAD.PRECIO_UNITARIO_I,
   IMPL_SEGURIDAD.CANTIDAD,
   IMPL_SEGURIDAD.DESCRIPCION_I,
   IMPL_SEGURIDAD.ESTADO_I,
   IMPL_SEGURIDAD.FECHA_REG_IM
from
   IMPL_SEGURIDAD
with read only;

comment on column V_IMPL.ID_PRO is
'Identificador del proveedor.';

comment on column V_IMPL.NOMBRE_I is
'Nombre del implemento.';

comment on column V_IMPL.PRECIO_UNITARIO_I is
'Precio unitario del implemento de seguridad.';

comment on column V_IMPL.CANTIDAD is
'Catidad actual total del implemento.';

comment on column V_IMPL.DESCRIPCION_I is
'Descripcion general del implemento.';

comment on column V_IMPL.ESTADO_I is
'Estado actual del implemento (Optimo o en mantenimiento).';
