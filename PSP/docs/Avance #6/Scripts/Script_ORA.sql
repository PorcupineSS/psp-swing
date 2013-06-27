/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     03/06/2013 10:17:06 p.m.                     */
/*==============================================================*/


drop view V_ACTUALIZACION;

drop view V_ACTUALIZACION_IMPLEMENTO;

drop view V_ASIGNACION_CONTRATO;

drop view V_ASIGNACION_IMPLEMENTO;

drop view V_BITACORA;

drop view V_CLIENTE;

drop view V_CLIENTE_R_TELEFONO;

drop view V_COMUNICADO;

drop view V_CONTRATO;

drop view V_COORDINADOR_CONTRATO;

drop view V_COORDINADOR_T_T;

drop view V_DIRECTOR_COMERCIAL;

drop view V_DIRECTOR_G_H;

drop view V_DIRECTOR_OPERACIONES;

drop view V_EMPLEADO;

drop view V_EMPLEADO_PLANTA;

drop view V_EMPLEADO_R_TELEFONO;

drop view V_EMPLEADO_TEMPORAL;

drop view V_IMPLEMENTO_SEGURIDAD;

drop view V_PROVEEDOR;

drop view V_SUBGERENTE;

drop view V_TELEFONOS_CLIENTE;

drop view V_TELEFONOS_EMPLEADO;

drop view V_TELEFONOS_PROVEEDOR;

drop table ACTUALIZACION cascade constraints;

drop index LO_ACTUALIZAN_FK;

drop index ACTUALIZA_FK;

drop table ACTUALIZACION_IMPLEMENTO cascade constraints;

drop index REALIZA_ASIGNACION_FK;

drop index SE_ASIGNA_CONTRATO_FK;

drop table ASIGNACION_CONTRATO cascade constraints;

drop index LO_ASIGNAN_FK;

drop index RELATIONSHIP_4_FK;

drop index ASIGNA_IMPLEMENTO_FK;

drop table ASIGNACION_IMPLEMENTO cascade constraints;

drop index SIGUE_FK;

drop table BITACORA cascade constraints;

drop index REGISTRO_CLIENTE_FK;

drop table CLIENTE cascade constraints;

drop table CLIENTE_TELEFONO cascade constraints;

drop index RESPONDE_FK;

drop index REDACTA_FK;

drop table COMUNICADO cascade constraints;

drop index SOLICITA_FK;

drop index REGISTRO_CONTRATO_FK;

drop table CONTRATO cascade constraints;

drop table COORDINADOR_CONTRATO cascade constraints;

drop table COORDINADOR_T_T cascade constraints;

drop table DIRECTOR_COMERCIAL cascade constraints;

drop table DIRECTOR_GESTION_HUMANA cascade constraints;

drop table DIRECTOR_OPERACIONES cascade constraints;

drop index REGISTRA_FK;

drop table EMPLEADO cascade constraints;

drop table EMPLEADO_PLANTA cascade constraints;

drop table EMPLEADO_TELEFONO cascade constraints;

drop index ASIGNAN_A_EMPLEADO_FK;

drop table EMPLEADO_TEMPORAL cascade constraints;

drop index SUMINISTRA_FK;

drop index REGISTRO_IMPLEMENTO_FK;

drop table IMPLEMENTO_SEGURIDAD cascade constraints;

drop index REGISTRO_PROVEEDOR_FK;

drop table PROVEEDOR cascade constraints;

drop table SUBGERENTE cascade constraints;

drop table TELEFONOS_CLIENTE cascade constraints;

drop table TELEFONOS_EMPLEADO cascade constraints;

drop index PROVEEDOR_TELEFONO_FK;

drop table TELEFONOS_PROVEEDOR cascade constraints;

/*==============================================================*/
/* Table: ACTUALIZACION                                         */
/*==============================================================*/
create table ACTUALIZACION 
(
   CEDULADIR            INTEGER              not null,
   CEDULASG             INTEGER              not null,
   FECHA_ACTUAL_DGH     DATE                 not null,
   constraint PK_ACTUALIZACION primary key (CEDULADIR, CEDULASG)
);

comment on table ACTUALIZACION is
'Asociación que permite que el SUBGERENTE actualice la información de un DIRECTOR DE GESTIÓN HUMANA.';

/*==============================================================*/
/* Table: ACTUALIZACION_IMPLEMENTO                              */
/*==============================================================*/
create table ACTUALIZACION_IMPLEMENTO 
(
   ID_ACTUALIZACION     SMALLINT             not null,
   ID_IMPLEMENTO        SMALLINT,
   CEDULA               INTEGER,
   FECHA_ACTUALIZACION  DATE,
   CANTIDAD_AGREGADA    SMALLINT,
   DESCRIPCION_ACTUALIZACION VARCHAR2(100)        not null,
   constraint PK_ACTUALIZACION_IMPLEMENTO primary key (ID_ACTUALIZACION)
);

comment on table ACTUALIZACION_IMPLEMENTO is
'Posee los datos pertenecientes a la actualizacion de un implemento, por parte de un empleado: COORDINADOR TECNICO Y TECNOLOGICO.';

comment on column ACTUALIZACION_IMPLEMENTO.ID_ACTUALIZACION is
'Identificador de la actualización.';

comment on column ACTUALIZACION_IMPLEMENTO.ID_IMPLEMENTO is
'Identificador del implemento.';

comment on column ACTUALIZACION_IMPLEMENTO.CANTIDAD_AGREGADA is
'Cantidad de implementos agregados al inventario.';

/*==============================================================*/
/* Index: ACTUALIZA_FK                                          */
/*==============================================================*/
create index ACTUALIZA_FK on ACTUALIZACION_IMPLEMENTO (
   CEDULA ASC
);

/*==============================================================*/
/* Index: LO_ACTUALIZAN_FK                                      */
/*==============================================================*/
create index LO_ACTUALIZAN_FK on ACTUALIZACION_IMPLEMENTO (
   ID_IMPLEMENTO ASC
);

/*==============================================================*/
/* Table: ASIGNACION_CONTRATO                                   */
/*==============================================================*/
create table ASIGNACION_CONTRATO 
(
   ID_ASIGNACION_CONTRATO SMALLINT             not null,
   ID_CONTRATO          SMALLINT,
   CEDULA               INTEGER,
   FECHA_ASIGNACION_CONTRATO DATE                 not null,
   HORARIO_ASIGNADO_CONTRATO VARCHAR2(20)         not null,
   constraint PK_ASIGNACION_CONTRATO primary key (ID_ASIGNACION_CONTRATO)
);

comment on table ASIGNACION_CONTRATO is
'Asignacion de un CONTRATO por parte de un empleado: COORDINADOR DE CONTRATO a un EMPLEADO TEMPORAL.';

comment on column ASIGNACION_CONTRATO.ID_ASIGNACION_CONTRATO is
'Identificador de la asignación.';

comment on column ASIGNACION_CONTRATO.ID_CONTRATO is
'Identificador del contrato.';

/*==============================================================*/
/* Index: SE_ASIGNA_CONTRATO_FK                                 */
/*==============================================================*/
create index SE_ASIGNA_CONTRATO_FK on ASIGNACION_CONTRATO (
   ID_CONTRATO ASC
);

/*==============================================================*/
/* Index: REALIZA_ASIGNACION_FK                                 */
/*==============================================================*/
create index REALIZA_ASIGNACION_FK on ASIGNACION_CONTRATO (
   CEDULA ASC
);

/*==============================================================*/
/* Table: ASIGNACION_IMPLEMENTO                                 */
/*==============================================================*/
create table ASIGNACION_IMPLEMENTO 
(
   ID_ASIGNACION_IMPLEMENTO SMALLINT             not null,
   ID_IMPLEMENTO        SMALLINT,
   CEDULAET             INTEGER,
   CEDULACTT            INTEGER,
   CANTIDAD_ASIGNADA    SMALLINT             not null,
   ESTADO_ASIGNACION    VARCHAR2(20)         not null,
   FECHA_ASIGNACION     DATE                 not null,
   constraint PK_ASIGNACION_IMPLEMENTO primary key (ID_ASIGNACION_IMPLEMENTO)
);

comment on table ASIGNACION_IMPLEMENTO is
'Posee los datos de una asignacion de un implemento por parte de un empleado: COORDINADOR TECNICO Y TECNOLOGICO a un EMPLEADO TEMPORAL.';

comment on column ASIGNACION_IMPLEMENTO.ID_ASIGNACION_IMPLEMENTO is
'Identificador de la asignación.';

comment on column ASIGNACION_IMPLEMENTO.ID_IMPLEMENTO is
'Identificador del implemento.';

comment on column ASIGNACION_IMPLEMENTO.ESTADO_ASIGNACION is
'Estado actual del implemento (Optimo o en mantenimiento).';

comment on column ASIGNACION_IMPLEMENTO.FECHA_ASIGNACION is
'Fecha en que se realiza el comunicado.';

/*==============================================================*/
/* Index: ASIGNA_IMPLEMENTO_FK                                  */
/*==============================================================*/
create index ASIGNA_IMPLEMENTO_FK on ASIGNACION_IMPLEMENTO (
   CEDULACTT ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_4_FK on ASIGNACION_IMPLEMENTO (
   CEDULAET ASC
);

/*==============================================================*/
/* Index: LO_ASIGNAN_FK                                         */
/*==============================================================*/
create index LO_ASIGNAN_FK on ASIGNACION_IMPLEMENTO (
   ID_IMPLEMENTO ASC
);

/*==============================================================*/
/* Table: BITACORA                                              */
/*==============================================================*/
create table BITACORA 
(
   ID_OPERACION         INTEGER              not null,
   CEDULA               INTEGER,
   FECHA_OPERACION      DATE                 not null,
   USUARIO_OPERACION    VARCHAR2(20),
   MAQUINA_OPERACION    VARCHAR2(20),
   TABLA_MODIFICADA     VARCHAR2(20)         not null,
   TIPO_OPERACION       VARCHAR2(6)          not null,
   constraint PK_BITACORA primary key (ID_OPERACION)
);

/*==============================================================*/
/* Index: SIGUE_FK                                              */
/*==============================================================*/
create index SIGUE_FK on BITACORA (
   CEDULA ASC
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE 
(
   ID_CLIENTE           SMALLINT             not null,
   CEDULA               INTEGER              not null,
   NOMBRE_CLIENTE       VARCHAR2(30)         not null,
   DIRECCION_CLIENTE    VARCHAR2(20)         not null,
   FECHA_REGISTRO_CLIENTE DATE,
   constraint PK_CLIENTE primary key (ID_CLIENTE)
);

comment on table CLIENTE is
'Posee todos los atributos que se requieren acerca de un cliente de la empresa.';

comment on column CLIENTE.ID_CLIENTE is
'Identificador del cliente.';

/*==============================================================*/
/* Index: REGISTRO_CLIENTE_FK                                   */
/*==============================================================*/
create index REGISTRO_CLIENTE_FK on CLIENTE (
   CEDULA ASC
);

/*==============================================================*/
/* Table: CLIENTE_TELEFONO                                      */
/*==============================================================*/
create table CLIENTE_TELEFONO 
(
   ID_CLIENTE           SMALLINT             not null,
   ID_TELEFONO_CLIENTE  SMALLINT             not null,
   constraint PK_CLIENTE_TELEFONO primary key (ID_CLIENTE, ID_TELEFONO_CLIENTE)
);

comment on table CLIENTE_TELEFONO is
'Relación que indica que un CLIENTE puede tener varios TELÉFONOS CL.';

comment on column CLIENTE_TELEFONO.ID_CLIENTE is
'Identificador del cliente.';

comment on column CLIENTE_TELEFONO.ID_TELEFONO_CLIENTE is
'Identificador del teléfono.';

/*==============================================================*/
/* Table: COMUNICADO                                            */
/*==============================================================*/
create table COMUNICADO 
(
   ID_COMUNICADO        SMALLINT             not null,
   CEDULAET             INTEGER,
   CEDULADO             INTEGER,
   TIPO_COMUNICADO      VARCHAR2(20)         not null,
   FECHA_COMUNICADO     DATE                 not null,
   CONTENIDO_COMUNICADO VARCHAR2(100)        not null,
   URGENTE              SMALLINT             not null,
   RESPUESTA_COMUNICADO VARCHAR2(100),
   constraint PK_COMUNICADO primary key (ID_COMUNICADO)
);

comment on table COMUNICADO is
'Posee los atributos de un comunicado realizado por parte de un EMPLEADO TEMPORAL.';

comment on column COMUNICADO.ID_COMUNICADO is
'Identificador del comunicado.';

comment on column COMUNICADO.CONTENIDO_COMUNICADO is
'Contenido del comunicado.';

comment on column COMUNICADO.URGENTE is
'Es urgente o no el comunicado.';

comment on column COMUNICADO.RESPUESTA_COMUNICADO is
'Respuesta al comunicado.';

/*==============================================================*/
/* Index: REDACTA_FK                                            */
/*==============================================================*/
create index REDACTA_FK on COMUNICADO (
   CEDULAET ASC
);

/*==============================================================*/
/* Index: RESPONDE_FK                                           */
/*==============================================================*/
create index RESPONDE_FK on COMUNICADO (
   CEDULADO ASC
);

/*==============================================================*/
/* Table: CONTRATO                                              */
/*==============================================================*/
create table CONTRATO 
(
   ID_CONTRATO          SMALLINT             not null,
   ID_CLIENTE           SMALLINT             not null,
   CEDULA               INTEGER              not null,
   UBICACION            VARCHAR2(20)         not null,
   TELEFONO             INTEGER              not null,
   CELULAR              INTEGER              not null,
   TIPO_CONTRATO        VARCHAR2(20)         not null,
   FECHA_INICIO         DATE                 not null,
   TIPO_PERSONAL        VARCHAR2(20)         not null,
   CANTIDAD_PERSONAL    SMALLINT             not null,
   COSTO_MENSUAL        NUMBER(8,2)          not null,
   HORARIO_CONTRATO     VARCHAR2(20)         not null,
   TIEMPO               INTEGER,
   FECHA_REGISTRO_CONTRATO DATE                 not null,
   constraint PK_CONTRATO primary key (ID_CONTRATO),
   constraint AK_UBICACION_CONTRATO unique (UBICACION)
);

comment on table CONTRATO is
'Posee los atributos requeridos en el registro de un contrato.';

comment on column CONTRATO.ID_CONTRATO is
'Identificador del contrato.';

comment on column CONTRATO.ID_CLIENTE is
'Identificador del cliente.';

comment on column CONTRATO.UBICACION is
'Ubicacion donde se cumplira el contrato.';

comment on column CONTRATO.TELEFONO is
'Telefono del lugar donde se cumplira el contrato.';

comment on column CONTRATO.CELULAR is
'Celular del lugar donde se cumplira el contrato.';

comment on column CONTRATO.TIPO_CONTRATO is
'Tipo de comunicado (Reclamo, Queja o Sugerencia).';

comment on column CONTRATO.FECHA_INICIO is
'Fecha de inicio del contrato.';

comment on column CONTRATO.TIPO_PERSONAL is
'Tipo de personal solicitado en el contrato (Vigilantes y/o Escoltas).';

comment on column CONTRATO.CANTIDAD_PERSONAL is
'Cantidad de personal solicitado en el contrato.';

comment on column CONTRATO.COSTO_MENSUAL is
'Costo mensual total del contrato.';

comment on column CONTRATO.HORARIO_CONTRATO is
'Horario asignado en el contrato.';

comment on column CONTRATO.TIEMPO is
'Si en contrato es de tipo definido este campo tendra el tiempo total del contrato, si no lo es podra ser null.';

/*==============================================================*/
/* Index: REGISTRO_CONTRATO_FK                                  */
/*==============================================================*/
create index REGISTRO_CONTRATO_FK on CONTRATO (
   CEDULA ASC
);

/*==============================================================*/
/* Index: SOLICITA_FK                                           */
/*==============================================================*/
create index SOLICITA_FK on CONTRATO (
   ID_CLIENTE ASC
);

/*==============================================================*/
/* Table: COORDINADOR_CONTRATO                                  */
/*==============================================================*/
create table COORDINADOR_CONTRATO 
(
   CEDULA               INTEGER              not null,
   constraint PK_COORDINADOR_CONTRATO primary key (CEDULA)
);

comment on table COORDINADOR_CONTRATO is
'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: COORDINADOR DE CONTRATO con los procesos de la empresa.';

/*==============================================================*/
/* Table: COORDINADOR_T_T                                       */
/*==============================================================*/
create table COORDINADOR_T_T 
(
   CEDULA               INTEGER              not null,
   constraint PK_COORDINADOR_T_T primary key (CEDULA)
);

comment on table COORDINADOR_T_T is
'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: COORDINADOR TÉCNICO Y TECNOLÓGICO con los procesos de la empresa.';

/*==============================================================*/
/* Table: DIRECTOR_COMERCIAL                                    */
/*==============================================================*/
create table DIRECTOR_COMERCIAL 
(
   CEDULA               INTEGER              not null,
   constraint PK_DIRECTOR_COMERCIAL primary key (CEDULA)
);

comment on table DIRECTOR_COMERCIAL is
'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: DIRECTOR COMERCIAL con los procesos de la empresa.';

/*==============================================================*/
/* Table: DIRECTOR_GESTION_HUMANA                               */
/*==============================================================*/
create table DIRECTOR_GESTION_HUMANA 
(
   CEDULA               INTEGER              not null,
   constraint PK_DIRECTOR_GESTION_HUMANA primary key (CEDULA)
);

comment on table DIRECTOR_GESTION_HUMANA is
'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: DIRECTOR DE GESTION HUMANA con los procesos de la empresa.';

/*==============================================================*/
/* Table: DIRECTOR_OPERACIONES                                  */
/*==============================================================*/
create table DIRECTOR_OPERACIONES 
(
   CEDULA               INTEGER              not null,
   constraint PK_DIRECTOR_OPERACIONES primary key (CEDULA)
);

comment on table DIRECTOR_OPERACIONES is
'Posee los atributos de un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: DIRECTOR DE OPERACIONES con los procesos de la empresa.';

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table EMPLEADO 
(
   CEDULA               INTEGER              not null,
   CEDULADIR            INTEGER,
   NOMBRE_EMPLEADO      VARCHAR2(20)         not null,
   APELLIDO_EMPLEADO    VARCHAR2(20)         not null,
   CONTRASENIA_EMPLEADO CHAR(10)             not null,
   CODIGO_EMPLEADO      VARCHAR2(20)         not null,
   FECHA_REGISTRO       DATE                 not null,
   constraint PK_EMPLEADO primary key (CEDULA),
   constraint AK_CODIGO_EMPLEADO unique (CODIGO_EMPLEADO)
);

comment on table EMPLEADO is
'Posee los atributos comunes que son solicitados a cualquier empleado de la empresa.';

/*==============================================================*/
/* Index: REGISTRA_FK                                           */
/*==============================================================*/
create index REGISTRA_FK on EMPLEADO (
   CEDULADIR ASC
);

/*==============================================================*/
/* Table: EMPLEADO_PLANTA                                       */
/*==============================================================*/
create table EMPLEADO_PLANTA 
(
   CEDULA               INTEGER              not null,
   SUELDO               NUMBER(8,2)          not null,
   constraint PK_EMPLEADO_PLANTA primary key (CEDULA)
);

comment on table EMPLEADO_PLANTA is
'Posee los atributos de un empleado normal de la empresa, pero a la vez se le asignan los atributos propios de un empleado de planta.';

comment on column EMPLEADO_PLANTA.SUELDO is
'Sueldo del empleado de planta.';

/*==============================================================*/
/* Table: EMPLEADO_TELEFONO                                     */
/*==============================================================*/
create table EMPLEADO_TELEFONO 
(
   CEDULA               INTEGER              not null,
   ID_TELEFONO_EMPLEADO SMALLINT             not null,
   constraint PK_EMPLEADO_TELEFONO primary key (CEDULA, ID_TELEFONO_EMPLEADO)
);

comment on table EMPLEADO_TELEFONO is
'Esta relación permite que un empleado de la empresa pueda poseer mas de un numero telefonico registrado en la empresa.';

comment on column EMPLEADO_TELEFONO.ID_TELEFONO_EMPLEADO is
'Identificador del teléfono.';

/*==============================================================*/
/* Table: EMPLEADO_TEMPORAL                                     */
/*==============================================================*/
create table EMPLEADO_TEMPORAL 
(
   CEDULA               INTEGER              not null,
   ID_ASIGNACION_CONTRATO SMALLINT,
   TIENE_CONTRATO       SMALLINT             not null,
   TIPO_TEMPORAL        VARCHAR2(20)         not null,
   constraint PK_EMPLEADO_TEMPORAL primary key (CEDULA)
);

comment on table EMPLEADO_TEMPORAL is
'Posee los atributos de un empleado normal de la empresa, pero a la vez se le asignan los atributos propios de un empleado temporal.';

comment on column EMPLEADO_TEMPORAL.ID_ASIGNACION_CONTRATO is
'Identificador de la asignación.';

comment on column EMPLEADO_TEMPORAL.TIENE_CONTRATO is
'El empleado temporal tiene o no contrato asignado.';

comment on column EMPLEADO_TEMPORAL.TIPO_TEMPORAL is
'Tipo de empleado temporal (Vigilante o Escolta).';

/*==============================================================*/
/* Index: ASIGNAN_A_EMPLEADO_FK                                 */
/*==============================================================*/
create index ASIGNAN_A_EMPLEADO_FK on EMPLEADO_TEMPORAL (
   ID_ASIGNACION_CONTRATO ASC
);

/*==============================================================*/
/* Table: IMPLEMENTO_SEGURIDAD                                  */
/*==============================================================*/
create table IMPLEMENTO_SEGURIDAD 
(
   ID_IMPLEMENTO        SMALLINT             not null,
   ID_PROVEEDOR         SMALLINT,
   CEDULA               INTEGER              not null,
   NOMBRE_IMPLEMENTO    VARCHAR2(30)         not null,
   PRECIO_UNITARIO_IMPLEMENTO NUMBER(8,2)          not null,
   CANTIDAD_IMPLEMENTOS SMALLINT             not null,
   DESCRIPCION_IMPLEMENTO VARCHAR2(100)        not null,
   ESTADO_IMPLEMENTO    VARCHAR2(20)         not null,
   FECHA_REGISTRO_IMPLEMENTO DATE                 not null,
   constraint PK_IMPLEMENTO_SEGURIDAD primary key (ID_IMPLEMENTO),
   constraint AK_NOMBREIMPLEMENTO_IMPLEMEN unique (NOMBRE_IMPLEMENTO)
);

comment on table IMPLEMENTO_SEGURIDAD is
'Posee los atributos que requiere el registro de un IMPLEMENTO DE SEGURIDAD por parte de un empleado: COORDINADOR TECNICO Y TECNOLOGICO.';

comment on column IMPLEMENTO_SEGURIDAD.ID_IMPLEMENTO is
'Identificador del implemento.';

comment on column IMPLEMENTO_SEGURIDAD.ID_PROVEEDOR is
'Identificador del proveedor.';

comment on column IMPLEMENTO_SEGURIDAD.NOMBRE_IMPLEMENTO is
'Nombre del proveedor.';

comment on column IMPLEMENTO_SEGURIDAD.PRECIO_UNITARIO_IMPLEMENTO is
'Precio unitario del implemento de seguridad.';

comment on column IMPLEMENTO_SEGURIDAD.CANTIDAD_IMPLEMENTOS is
'Catidad actual total del implemento.';

comment on column IMPLEMENTO_SEGURIDAD.DESCRIPCION_IMPLEMENTO is
'Descripcion general del implemento.';

/*==============================================================*/
/* Index: REGISTRO_IMPLEMENTO_FK                                */
/*==============================================================*/
create index REGISTRO_IMPLEMENTO_FK on IMPLEMENTO_SEGURIDAD (
   CEDULA ASC
);

/*==============================================================*/
/* Index: SUMINISTRA_FK                                         */
/*==============================================================*/
create index SUMINISTRA_FK on IMPLEMENTO_SEGURIDAD (
   ID_PROVEEDOR ASC
);

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR 
(
   ID_PROVEEDOR         SMALLINT             not null,
   CEDULA               INTEGER              not null,
   NOMBRE_PROVEEDOR     VARCHAR2(20)         not null,
   DIRECCION_PROVEEDOR  VARCHAR2(20)         not null,
   FECHA_REGISTRO_PROVEEDOR DATE                 not null,
   constraint PK_PROVEEDOR primary key (ID_PROVEEDOR),
   constraint AK_NOMBREPROVEEDOR_PROVEEDO unique (NOMBRE_PROVEEDOR)
);

comment on table PROVEEDOR is
'Posee los atributos que se requieren en el registro de un PROVEEDOR por parte de un empleado: COORDINADOR TECNICO Y TECNOLOGICO.';

comment on column PROVEEDOR.ID_PROVEEDOR is
'Identificador del proveedor.';

comment on column PROVEEDOR.DIRECCION_PROVEEDOR is
'Dirección del proveedor.';

/*==============================================================*/
/* Index: REGISTRO_PROVEEDOR_FK                                 */
/*==============================================================*/
create index REGISTRO_PROVEEDOR_FK on PROVEEDOR (
   CEDULA ASC
);

/*==============================================================*/
/* Table: SUBGERENTE                                            */
/*==============================================================*/
create table SUBGERENTE 
(
   CEDULA               INTEGER              not null,
   constraint PK_SUBGERENTE primary key (CEDULA)
);

comment on table SUBGERENTE is
'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: SUBGERENTE con los procesos de la empresa.';

/*==============================================================*/
/* Table: TELEFONOS_CLIENTE                                     */
/*==============================================================*/
create table TELEFONOS_CLIENTE 
(
   ID_TELEFONO_CLIENTE  SMALLINT             not null,
   NUM_TELEFONO_CLIENTE INTEGER              not null,
   constraint PK_TELEFONOS_CLIENTE primary key (ID_TELEFONO_CLIENTE)
);

comment on table TELEFONOS_CLIENTE is
'Contiene el directorio telefonico de todos los clientes de la empresa.';

comment on column TELEFONOS_CLIENTE.ID_TELEFONO_CLIENTE is
'Identificador del teléfono.';

comment on column TELEFONOS_CLIENTE.NUM_TELEFONO_CLIENTE is
'Numero telefonico del cliente.';

/*==============================================================*/
/* Table: TELEFONOS_EMPLEADO                                    */
/*==============================================================*/
create table TELEFONOS_EMPLEADO 
(
   ID_TELEFONO_EMPLEADO SMALLINT             not null,
   NUMERO_TELEFONO_EMPLEADO INTEGER              not null,
   constraint PK_TELEFONOS_EMPLEADO primary key (ID_TELEFONO_EMPLEADO)
);

comment on table TELEFONOS_EMPLEADO is
'Contiene el directorio telefonico de todos los empleados de la empresa.';

comment on column TELEFONOS_EMPLEADO.ID_TELEFONO_EMPLEADO is
'Identificador del teléfono.';

comment on column TELEFONOS_EMPLEADO.NUMERO_TELEFONO_EMPLEADO is
'Numero telefonico del empleado.';

/*==============================================================*/
/* Table: TELEFONOS_PROVEEDOR                                   */
/*==============================================================*/
create table TELEFONOS_PROVEEDOR 
(
   ID_TELEFONO_PROVEEDOR SMALLINT             not null,
   ID_PROVEEDOR         SMALLINT,
   NUMERO_TELEFONO_PROVEEDOR INTEGER              not null,
   constraint PK_TELEFONOS_PROVEEDOR primary key (ID_TELEFONO_PROVEEDOR)
);

comment on table TELEFONOS_PROVEEDOR is
'Contiene el directorio telefonico de todos los proveedores de la empresa.';

comment on column TELEFONOS_PROVEEDOR.ID_TELEFONO_PROVEEDOR is
'Identificador del teléfono.';

comment on column TELEFONOS_PROVEEDOR.ID_PROVEEDOR is
'Identificador del proveedor.';

/*==============================================================*/
/* Index: PROVEEDOR_TELEFONO_FK                                 */
/*==============================================================*/
create index PROVEEDOR_TELEFONO_FK on TELEFONOS_PROVEEDOR (
   ID_PROVEEDOR ASC
);

/*==============================================================*/
/* View: V_ACTUALIZACION                                        */
/*==============================================================*/
create or replace view V_ACTUALIZACION as
select
   ACTUALIZACION.CEDULADIR,
   ACTUALIZACION.CEDULASG,
   ACTUALIZACION.FECHA_ACTUAL_DGH
from
   ACTUALIZACION
with read only;

/*==============================================================*/
/* View: V_ACTUALIZACION_IMPLEMENTO                             */
/*==============================================================*/
create or replace view V_ACTUALIZACION_IMPLEMENTO as
select
   ACTUALIZACION_IMPLEMENTO.ID_ACTUALIZACION,
   ACTUALIZACION_IMPLEMENTO.ID_IMPLEMENTO,
   ACTUALIZACION_IMPLEMENTO.CEDULA,
   ACTUALIZACION_IMPLEMENTO.FECHA_ACTUALIZACION,
   ACTUALIZACION_IMPLEMENTO.CANTIDAD_AGREGADA,
   ACTUALIZACION_IMPLEMENTO.DESCRIPCION_ACTUALIZACION
from
   ACTUALIZACION_IMPLEMENTO
with read only;

comment on column V_ACTUALIZACION_IMPLEMENTO.ID_ACTUALIZACION is
'Identificador de la actualización.';

comment on column V_ACTUALIZACION_IMPLEMENTO.ID_IMPLEMENTO is
'Identificador del implemento.';

comment on column V_ACTUALIZACION_IMPLEMENTO.CANTIDAD_AGREGADA is
'Cantidad de implementos agregados al inventario.';

/*==============================================================*/
/* View: V_ASIGNACION_CONTRATO                                  */
/*==============================================================*/
create or replace view V_ASIGNACION_CONTRATO as
select
   ASIGNACION_CONTRATO.ID_ASIGNACION_CONTRATO,
   ASIGNACION_CONTRATO.ID_CONTRATO,
   ASIGNACION_CONTRATO.CEDULA,
   ASIGNACION_CONTRATO.FECHA_ASIGNACION_CONTRATO,
   ASIGNACION_CONTRATO.HORARIO_ASIGNADO_CONTRATO
from
   ASIGNACION_CONTRATO
with read only;

comment on column V_ASIGNACION_CONTRATO.ID_ASIGNACION_CONTRATO is
'Identificador de la asignación.';

comment on column V_ASIGNACION_CONTRATO.ID_CONTRATO is
'Identificador del contrato.';

/*==============================================================*/
/* View: V_ASIGNACION_IMPLEMENTO                                */
/*==============================================================*/
create or replace view V_ASIGNACION_IMPLEMENTO as
select
   ASIGNACION_IMPLEMENTO.ID_ASIGNACION_IMPLEMENTO,
   ASIGNACION_IMPLEMENTO.ID_IMPLEMENTO,
   ASIGNACION_IMPLEMENTO.CEDULAET,
   ASIGNACION_IMPLEMENTO.CEDULACTT,
   ASIGNACION_IMPLEMENTO.CANTIDAD_ASIGNADA,
   ASIGNACION_IMPLEMENTO.ESTADO_ASIGNACION,
   ASIGNACION_IMPLEMENTO.FECHA_ASIGNACION
from
   ASIGNACION_IMPLEMENTO
with read only;

comment on column V_ASIGNACION_IMPLEMENTO.ID_ASIGNACION_IMPLEMENTO is
'Identificador de la asignación.';

comment on column V_ASIGNACION_IMPLEMENTO.ID_IMPLEMENTO is
'Identificador del implemento.';

comment on column V_ASIGNACION_IMPLEMENTO.ESTADO_ASIGNACION is
'Estado actual del implemento (Optimo o en mantenimiento).';

comment on column V_ASIGNACION_IMPLEMENTO.FECHA_ASIGNACION is
'Fecha en que se realiza el comunicado.';

/*==============================================================*/
/* View: V_BITACORA                                             */
/*==============================================================*/
create or replace view V_BITACORA as
select
   BITACORA.ID_OPERACION,
   BITACORA.CEDULA,
   BITACORA.FECHA_OPERACION,
   BITACORA.USUARIO_OPERACION,
   BITACORA.MAQUINA_OPERACION,
   BITACORA.TABLA_MODIFICADA,
   BITACORA.TIPO_OPERACION
from
   BITACORA
with read only;

/*==============================================================*/
/* View: V_CLIENTE                                              */
/*==============================================================*/
create or replace view V_CLIENTE as
select
   CLIENTE.ID_CLIENTE,
   CLIENTE.CEDULA,
   CLIENTE.NOMBRE_CLIENTE,
   CLIENTE.DIRECCION_CLIENTE,
   CLIENTE.FECHA_REGISTRO_CLIENTE
from
   CLIENTE
with read only;

comment on column V_CLIENTE.ID_CLIENTE is
'Identificador del cliente.';

/*==============================================================*/
/* View: V_CLIENTE_R_TELEFONO                                   */
/*==============================================================*/
create or replace view V_CLIENTE_R_TELEFONO as
select
   CLIENTE_TELEFONO.ID_CLIENTE,
   CLIENTE_TELEFONO.ID_TELEFONO_CLIENTE
from
   CLIENTE_TELEFONO
with read only;

comment on column V_CLIENTE_R_TELEFONO.ID_CLIENTE is
'Identificador del cliente.';

comment on column V_CLIENTE_R_TELEFONO.ID_TELEFONO_CLIENTE is
'Identificador del teléfono.';

/*==============================================================*/
/* View: V_COMUNICADO                                           */
/*==============================================================*/
create or replace view V_COMUNICADO as
select
   COMUNICADO.ID_COMUNICADO,
   COMUNICADO.CEDULAET,
   COMUNICADO.CEDULADO,
   COMUNICADO.TIPO_COMUNICADO,
   COMUNICADO.FECHA_COMUNICADO,
   COMUNICADO.CONTENIDO_COMUNICADO,
   COMUNICADO.URGENTE,
   COMUNICADO.RESPUESTA_COMUNICADO
from
   COMUNICADO
with read only;

comment on column V_COMUNICADO.ID_COMUNICADO is
'Identificador del comunicado.';

comment on column V_COMUNICADO.CONTENIDO_COMUNICADO is
'Contenido del comunicado.';

comment on column V_COMUNICADO.URGENTE is
'Es urgente o no el comunicado.';

comment on column V_COMUNICADO.RESPUESTA_COMUNICADO is
'Respuesta al comunicado.';

/*==============================================================*/
/* View: V_CONTRATO                                             */
/*==============================================================*/
create or replace view V_CONTRATO as
select
   CONTRATO.ID_CONTRATO,
   CONTRATO.ID_CLIENTE,
   CONTRATO.CEDULA,
   CONTRATO.UBICACION,
   CONTRATO.TELEFONO,
   CONTRATO.CELULAR,
   CONTRATO.TIPO_CONTRATO,
   CONTRATO.FECHA_INICIO,
   CONTRATO.TIPO_PERSONAL,
   CONTRATO.CANTIDAD_PERSONAL,
   CONTRATO.COSTO_MENSUAL,
   CONTRATO.HORARIO_CONTRATO,
   CONTRATO.TIEMPO,
   CONTRATO.FECHA_REGISTRO_CONTRATO
from
   CONTRATO
with read only;

comment on column V_CONTRATO.ID_CONTRATO is
'Identificador del contrato.';

comment on column V_CONTRATO.ID_CLIENTE is
'Identificador del cliente.';

comment on column V_CONTRATO.UBICACION is
'Ubicacion donde se cumplira el contrato.';

comment on column V_CONTRATO.TELEFONO is
'Telefono del lugar donde se cumplira el contrato.';

comment on column V_CONTRATO.CELULAR is
'Celular del lugar donde se cumplira el contrato.';

comment on column V_CONTRATO.TIPO_CONTRATO is
'Tipo de comunicado (Reclamo, Queja o Sugerencia).';

comment on column V_CONTRATO.FECHA_INICIO is
'Fecha de inicio del contrato.';

comment on column V_CONTRATO.TIPO_PERSONAL is
'Tipo de personal solicitado en el contrato (Vigilantes y/o Escoltas).';

comment on column V_CONTRATO.CANTIDAD_PERSONAL is
'Cantidad de personal solicitado en el contrato.';

comment on column V_CONTRATO.COSTO_MENSUAL is
'Costo mensual total del contrato.';

comment on column V_CONTRATO.HORARIO_CONTRATO is
'Horario asignado en el contrato.';

comment on column V_CONTRATO.TIEMPO is
'Si en contrato es de tipo definido este campo tendra el tiempo total del contrato, si no lo es podra ser null.';

/*==============================================================*/
/* View: V_COORDINADOR_CONTRATO                                 */
/*==============================================================*/
create or replace view V_COORDINADOR_CONTRATO as
select
   COORDINADOR_CONTRATO.CEDULA
from
   COORDINADOR_CONTRATO
with read only;

/*==============================================================*/
/* View: V_COORDINADOR_T_T                                      */
/*==============================================================*/
create or replace view V_COORDINADOR_T_T as
select
   COORDINADOR_T_T.CEDULA
from
   COORDINADOR_T_T
with read only;

/*==============================================================*/
/* View: V_DIRECTOR_COMERCIAL                                   */
/*==============================================================*/
create or replace view V_DIRECTOR_COMERCIAL as
select
   DIRECTOR_COMERCIAL.CEDULA
from
   DIRECTOR_COMERCIAL
with read only;

/*==============================================================*/
/* View: V_DIRECTOR_G_H                                         */
/*==============================================================*/
create or replace view V_DIRECTOR_G_H as
select
   DIRECTOR_GESTION_HUMANA.CEDULA
from
   DIRECTOR_GESTION_HUMANA
with read only;

/*==============================================================*/
/* View: V_DIRECTOR_OPERACIONES                                 */
/*==============================================================*/
create or replace view V_DIRECTOR_OPERACIONES as
select
   DIRECTOR_OPERACIONES.CEDULA
from
   DIRECTOR_OPERACIONES
with read only;

/*==============================================================*/
/* View: V_EMPLEADO                                             */
/*==============================================================*/
create or replace view V_EMPLEADO as
select
   EMPLEADO.CEDULA,
   EMPLEADO.CEDULADIR,
   EMPLEADO.NOMBRE_EMPLEADO,
   EMPLEADO.APELLIDO_EMPLEADO,
   EMPLEADO.CONTRASENIA_EMPLEADO,
   EMPLEADO.CODIGO_EMPLEADO,
   EMPLEADO.FECHA_REGISTRO
from
   EMPLEADO
with read only;

/*==============================================================*/
/* View: V_EMPLEADO_PLANTA                                      */
/*==============================================================*/
create or replace view V_EMPLEADO_PLANTA as
select
   EMPLEADO_PLANTA.CEDULA,
   EMPLEADO_PLANTA.SUELDO
from
   EMPLEADO_PLANTA
with read only;

comment on column V_EMPLEADO_PLANTA.SUELDO is
'Sueldo del empleado de planta.';

/*==============================================================*/
/* View: V_EMPLEADO_R_TELEFONO                                  */
/*==============================================================*/
create or replace view V_EMPLEADO_R_TELEFONO as
select
   EMPLEADO_TELEFONO.CEDULA,
   EMPLEADO_TELEFONO.ID_TELEFONO_EMPLEADO
from
   EMPLEADO_TELEFONO
with read only;

comment on column V_EMPLEADO_R_TELEFONO.ID_TELEFONO_EMPLEADO is
'Identificador del teléfono.';

/*==============================================================*/
/* View: V_EMPLEADO_TEMPORAL                                    */
/*==============================================================*/
create or replace view V_EMPLEADO_TEMPORAL as
select
   EMPLEADO_TEMPORAL.CEDULA,
   EMPLEADO_TEMPORAL.ID_ASIGNACION_CONTRATO,
   EMPLEADO_TEMPORAL.TIENE_CONTRATO,
   EMPLEADO_TEMPORAL.TIPO_TEMPORAL
from
   EMPLEADO_TEMPORAL
with read only;

comment on column V_EMPLEADO_TEMPORAL.ID_ASIGNACION_CONTRATO is
'Identificador de la asignación.';

comment on column V_EMPLEADO_TEMPORAL.TIENE_CONTRATO is
'El empleado temporal tiene o no contrato asignado.';

comment on column V_EMPLEADO_TEMPORAL.TIPO_TEMPORAL is
'Tipo de empleado temporal (Vigilante o Escolta).';

/*==============================================================*/
/* View: V_IMPLEMENTO_SEGURIDAD                                 */
/*==============================================================*/
create or replace view V_IMPLEMENTO_SEGURIDAD as
select
   IMPLEMENTO_SEGURIDAD.ID_IMPLEMENTO,
   IMPLEMENTO_SEGURIDAD.ID_PROVEEDOR,
   IMPLEMENTO_SEGURIDAD.CEDULA,
   IMPLEMENTO_SEGURIDAD.NOMBRE_IMPLEMENTO,
   IMPLEMENTO_SEGURIDAD.PRECIO_UNITARIO_IMPLEMENTO,
   IMPLEMENTO_SEGURIDAD.CANTIDAD_IMPLEMENTOS,
   IMPLEMENTO_SEGURIDAD.DESCRIPCION_IMPLEMENTO,
   IMPLEMENTO_SEGURIDAD.ESTADO_IMPLEMENTO,
   IMPLEMENTO_SEGURIDAD.FECHA_REGISTRO_IMPLEMENTO
from
   IMPLEMENTO_SEGURIDAD
with read only;

comment on column V_IMPLEMENTO_SEGURIDAD.ID_IMPLEMENTO is
'Identificador del implemento.';

comment on column V_IMPLEMENTO_SEGURIDAD.ID_PROVEEDOR is
'Identificador del proveedor.';

comment on column V_IMPLEMENTO_SEGURIDAD.NOMBRE_IMPLEMENTO is
'Nombre del proveedor.';

comment on column V_IMPLEMENTO_SEGURIDAD.PRECIO_UNITARIO_IMPLEMENTO is
'Precio unitario del implemento de seguridad.';

comment on column V_IMPLEMENTO_SEGURIDAD.CANTIDAD_IMPLEMENTOS is
'Catidad actual total del implemento.';

comment on column V_IMPLEMENTO_SEGURIDAD.DESCRIPCION_IMPLEMENTO is
'Descripcion general del implemento.';

/*==============================================================*/
/* View: V_PROVEEDOR                                            */
/*==============================================================*/
create or replace view V_PROVEEDOR as
select
   PROVEEDOR.ID_PROVEEDOR,
   PROVEEDOR.CEDULA,
   PROVEEDOR.NOMBRE_PROVEEDOR,
   PROVEEDOR.DIRECCION_PROVEEDOR,
   PROVEEDOR.FECHA_REGISTRO_PROVEEDOR
from
   PROVEEDOR
with read only;

comment on column V_PROVEEDOR.ID_PROVEEDOR is
'Identificador del proveedor.';

comment on column V_PROVEEDOR.DIRECCION_PROVEEDOR is
'Dirección del proveedor.';

/*==============================================================*/
/* View: V_SUBGERENTE                                           */
/*==============================================================*/
create or replace view V_SUBGERENTE as
select
   SUBGERENTE.CEDULA
from
   SUBGERENTE
with read only;

/*==============================================================*/
/* View: V_TELEFONOS_CLIENTE                                    */
/*==============================================================*/
create or replace view V_TELEFONOS_CLIENTE as
select
   TELEFONOS_CLIENTE.ID_TELEFONO_CLIENTE,
   TELEFONOS_CLIENTE.NUM_TELEFONO_CLIENTE
from
   TELEFONOS_CLIENTE
with read only;

comment on column V_TELEFONOS_CLIENTE.ID_TELEFONO_CLIENTE is
'Identificador del teléfono.';

comment on column V_TELEFONOS_CLIENTE.NUM_TELEFONO_CLIENTE is
'Numero telefonico del cliente.';

/*==============================================================*/
/* View: V_TELEFONOS_EMPLEADO                                   */
/*==============================================================*/
create or replace view V_TELEFONOS_EMPLEADO as
select
   TELEFONOS_EMPLEADO.ID_TELEFONO_EMPLEADO,
   TELEFONOS_EMPLEADO.NUMERO_TELEFONO_EMPLEADO
from
   TELEFONOS_EMPLEADO
with read only;

comment on column V_TELEFONOS_EMPLEADO.ID_TELEFONO_EMPLEADO is
'Identificador del teléfono.';

comment on column V_TELEFONOS_EMPLEADO.NUMERO_TELEFONO_EMPLEADO is
'Numero telefonico del empleado.';

/*==============================================================*/
/* View: V_TELEFONOS_PROVEEDOR                                  */
/*==============================================================*/
create or replace view V_TELEFONOS_PROVEEDOR as
select
   TELEFONOS_PROVEEDOR.ID_TELEFONO_PROVEEDOR,
   TELEFONOS_PROVEEDOR.ID_PROVEEDOR,
   TELEFONOS_PROVEEDOR.NUMERO_TELEFONO_PROVEEDOR
from
   TELEFONOS_PROVEEDOR
with read only;

comment on column V_TELEFONOS_PROVEEDOR.ID_TELEFONO_PROVEEDOR is
'Identificador del teléfono.';

comment on column V_TELEFONOS_PROVEEDOR.ID_PROVEEDOR is
'Identificador del proveedor.';

