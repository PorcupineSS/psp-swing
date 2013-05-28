/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     27/05/2013 09:41:54 a.m.                     */
/*==============================================================*/


alter table ACTUALIZACION
   drop constraint FK_ACTUALIZ_ACTUALIZA_DIR_GEST;

alter table ACTUALIZACION
   drop constraint FK_ACTUALIZ_ACTUALIZA_SUBGEREN;

alter table ACTU_IMPL
   drop constraint FK_ACTU_IMP_ACTUALIZA_COORD_T_;

alter table ACTU_IMPL
   drop constraint FK_ACTU_IMP_LO_ACTUAL_IMPL_SEG;

alter table ASIGNACION_C
   drop constraint FK_ASIGNACI_REALIZA_A_COORD_CO;

alter table ASIGNACION_C
   drop constraint FK_ASIGNACI_SE_ASIGNA_CONTRATO;

alter table ASIG_IMPL
   drop constraint FK_ASIG_IMP_ASIGNA_I_COORD_T_;

alter table ASIG_IMPL
   drop constraint FK_ASIG_IMP_LO_ASIGNA_IMPL_SEG;

alter table ASIG_IMPL
   drop constraint FK_ASIG_IMP_RELATIONS_EM_TEMP;

alter table BITACORA_SEG
   drop constraint FK_BITACORA_SIGUE_EMPLEADO;

alter table CLIENTE
   drop constraint FK_CLIENTE_REG_CLI_DIR_COME;

alter table CL_TIENE_TELS
   drop constraint FK_CL_TIENE_CL_TIENE__TELS_CLI;

alter table CL_TIENE_TELS
   drop constraint FK_CL_TIENE_CL_TIENE__CLIENTE;

alter table COMUNICADO
   drop constraint FK_COMUNICA_REDACTA_EM_TEMP;

alter table COMUNICADO
   drop constraint FK_COMUNICA_RESPONDE_DIR_OPER;

alter table CONTRATO
   drop constraint FK_CONTRATO_REG_CONT_DIR_COME;

alter table CONTRATO
   drop constraint FK_CONTRATO_SOLICITA_CLIENTE;

alter table COORD_CONTRATO
   drop constraint FK_COORD_CO_SON3_EMP_PLAN;

alter table COORD_T_Y_Y
   drop constraint FK_COORD_T__SON_EMP_PLAN;

alter table DIR_COMERCIAL
   drop constraint FK_DIR_COME_SON2_EMP_PLAN;

alter table DIR_GESTION_HUM
   drop constraint FK_DIR_GEST_SON5_EMP_PLAN;

alter table DIR_OPERACIONES
   drop constraint FK_DIR_OPER_SON4_EMP_PLAN;

alter table EMPLEADOS
   drop constraint FK_EMPLEADO_REGISTRA_DIR_GEST;

alter table EMP_PLANTA
   drop constraint FK_EMP_PLAN_SON_E_EMPLEADO;

alter table EM_TEMP
   drop constraint FK_EM_TEMP_ASIGNAN_A_ASIGNACI;

alter table EM_TEMP
   drop constraint FK_EM_TEMP_SON_E2_EMPLEADO;

alter table EM_TIENE_TELS
   drop constraint FK_EM_TIENE_EM_TIENE__TELS_EMP;

alter table EM_TIENE_TELS
   drop constraint FK_EM_TIENE_EM_TIENE__EMPLEADO;

alter table IMPL_SEGURIDAD
   drop constraint FK_IMPL_SEG_REG_IMPL_COORD_T_;

alter table IMPL_SEGURIDAD
   drop constraint FK_IMPL_SEG_SUMINISTR_PROVEEDO;

alter table PROVEEDOR
   drop constraint FK_PROVEEDO_REG_PROV_COORD_T_;

alter table SUBGERENTE
   drop constraint FK_SUBGEREN_SON6_EMP_PLAN;

alter table TELS_PROV
   drop constraint FK_TELS_PRO_PR_TIENE__PROVEEDO;

drop index ACTUALIZACION_FK;

drop index ACTUALIZACION2_FK;

drop table ACTUALIZACION cascade constraints;

drop index LO_ACTUALIZAN_FK;

drop index ACTUALIZA_FK;

drop table ACTU_IMPL cascade constraints;

drop index REALIZA_ASIGNACION_FK;

drop index SE_ASIGNA_C_FK;

drop table ASIGNACION_C cascade constraints;

drop index LO_ASIGNAN_FK;

drop index RELATIONSHIP_4_FK;

drop index ASIGNA_I_FK;

drop table ASIG_IMPL cascade constraints;

drop index SIGUE_FK;

drop table BITACORA_SEG cascade constraints;

drop index REG_CLI_FK;

drop table CLIENTE cascade constraints;

drop index CL_TIENE_TELS_FK;

drop index CL_TIENE_TELS2_FK;

drop table CL_TIENE_TELS cascade constraints;

drop index RESPONDE_FK;

drop index REDACTA_FK;

drop table COMUNICADO cascade constraints;

drop index SOLICITA_FK;

drop index REG_CONT_FK;

drop table CONTRATO cascade constraints;

drop table COORD_CONTRATO cascade constraints;

drop table COORD_T_Y_Y cascade constraints;

drop table DIR_COMERCIAL cascade constraints;

drop table DIR_GESTION_HUM cascade constraints;

drop table DIR_OPERACIONES cascade constraints;

drop index REGISTRA_FK;

drop table EMPLEADOS cascade constraints;

drop table EMP_PLANTA cascade constraints;

drop index ASIGNAN_A_E_FK;

drop table EM_TEMP cascade constraints;

drop index EM_TIENE_TELS_FK;

drop index EM_TIENE_TELS2_FK;

drop table EM_TIENE_TELS cascade constraints;

drop index SUMINISTRA_FK;

drop index REG_IMPL_FK;

drop table IMPL_SEGURIDAD cascade constraints;

drop index REG_PROV_FK;

drop table PROVEEDOR cascade constraints;

drop table SUBGERENTE cascade constraints;

drop table TELS_CLI cascade constraints;

drop table TELS_EMP cascade constraints;

drop index PR_TIENE_TELS_FK;

drop table TELS_PROV cascade constraints;

/*==============================================================*/
/* Table: ACTUALIZACION                                         */
/*==============================================================*/
create table ACTUALIZACION  (
   SUB_CEDULAE          INTEGER                         not null,
   CEDULAE              INTEGER                         not null,
   FECHA_ACTUAL_DGH     DATE                            not null,
   constraint PK_ACTUALIZACION primary key (SUB_CEDULAE, CEDULAE)
);

comment on table ACTUALIZACION is
'Asociaci�n que permite que el SUBGERENTE actualice la informaci�n de un DIRECTOR DE GESTI�N HUMANA.';

/*==============================================================*/
/* Index: ACTUALIZACION2_FK                                     */
/*==============================================================*/
create index ACTUALIZACION2_FK on ACTUALIZACION (
   SUB_CEDULAE ASC
);

/*==============================================================*/
/* Index: ACTUALIZACION_FK                                      */
/*==============================================================*/
create index ACTUALIZACION_FK on ACTUALIZACION (
   CEDULAE ASC
);

/*==============================================================*/
/* Table: ACTU_IMPL                                             */
/*==============================================================*/
create table ACTU_IMPL  (
   ID_ACTUALIZACION_I   SMALLINT                        not null,
   ID_IMPLEMENTO        SMALLINT,
   CEDULAE              INTEGER,
   FECHA_ACTUALIZACION_I DATE                            not null,
   CANTIDAD_AGREGADA    SMALLINT,
   DESCRIPCION_ACTUALIZACION VARCHAR2(30)                    not null,
   constraint PK_ACTU_IMPL primary key (ID_ACTUALIZACION_I)
);

comment on table ACTU_IMPL is
'Posee los datos pertenecientes a la actualizacion de un implemento, por parte de un empleado: COORDINADOR TECNICO Y TECNOLOGICO.';

comment on column ACTU_IMPL.ID_ACTUALIZACION_I is
'Identificador de la actualizaci�n.';

comment on column ACTU_IMPL.ID_IMPLEMENTO is
'Identificador del implemento.';

comment on column ACTU_IMPL.FECHA_ACTUALIZACION_I is
'Fecha en que se realiza la actualizaci�n.';

comment on column ACTU_IMPL.CANTIDAD_AGREGADA is
'Cantidad de implementos agregados al inventario.';

comment on column ACTU_IMPL.DESCRIPCION_ACTUALIZACION is
'Descripci�n de la actualizacion (Agregar, borrar o actualizar datos).';

/*==============================================================*/
/* Index: ACTUALIZA_FK                                          */
/*==============================================================*/
create index ACTUALIZA_FK on ACTU_IMPL (
   CEDULAE ASC
);

/*==============================================================*/
/* Index: LO_ACTUALIZAN_FK                                      */
/*==============================================================*/
create index LO_ACTUALIZAN_FK on ACTU_IMPL (
   ID_IMPLEMENTO ASC
);

/*==============================================================*/
/* Table: ASIGNACION_C                                          */
/*==============================================================*/
create table ASIGNACION_C  (
   ID_ASIG              SMALLINT                        not null,
   ID_CONTRATO          SMALLINT,
   CEDULAE              INTEGER,
   COO_CEDULAE          INTEGER,
   FECHA_ASIGNACION_C   DATE                            not null,
   HORARIO_ASIGNADO     VARCHAR2(20)                    not null,
   constraint PK_ASIGNACION_C primary key (ID_ASIG)
);

comment on table ASIGNACION_C is
'Asignacion de un CONTRATO por parte de un empleado: COORDINADOR DE CONTRATO a un EMPLEADO TEMPORAL.';

comment on column ASIGNACION_C.ID_ASIG is
'Identificador de la asignaci�n.';

comment on column ASIGNACION_C.ID_CONTRATO is
'Identificador del contrato.';

comment on column ASIGNACION_C.FECHA_ASIGNACION_C is
'Fecha de la asignaci�n del contrato.';

comment on column ASIGNACION_C.HORARIO_ASIGNADO is
'Horario asignado en el contrato.';

/*==============================================================*/
/* Index: SE_ASIGNA_C_FK                                        */
/*==============================================================*/
create index SE_ASIGNA_C_FK on ASIGNACION_C (
   ID_CONTRATO ASC
);

/*==============================================================*/
/* Index: REALIZA_ASIGNACION_FK                                 */
/*==============================================================*/
create index REALIZA_ASIGNACION_FK on ASIGNACION_C (
   COO_CEDULAE ASC
);

/*==============================================================*/
/* Table: ASIG_IMPL                                             */
/*==============================================================*/
create table ASIG_IMPL  (
   ID_ASIGNACION_I      SMALLINT                        not null,
   ID_IMPLEMENTO        SMALLINT,
   CEDULAE              INTEGER,
   COO_CEDULAE          INTEGER,
   CANTIDAD_ASIGNADA    SMALLINT                        not null,
   ESTADO_ASIGNACION    SMALLINT                        not null,
   FECHA_ASIGNACION_I   DATE                            not null,
   constraint PK_ASIG_IMPL primary key (ID_ASIGNACION_I)
);

comment on table ASIG_IMPL is
'Posee los datos de una asignacion de un implemento por parte de un empleado: COORDINADOR TECNICO Y TECNOLOGICO a un EMPLEADO TEMPORAL.';

comment on column ASIG_IMPL.ID_ASIGNACION_I is
'Identificador de la asignaci�n.';

comment on column ASIG_IMPL.ID_IMPLEMENTO is
'Identificador del implemento.';

comment on column ASIG_IMPL.CANTIDAD_ASIGNADA is
'Cantidad de implementos asignados.';

comment on column ASIG_IMPL.ESTADO_ASIGNACION is
'Estado de la asignacion del implemento (activa o desactiva).';

comment on column ASIG_IMPL.FECHA_ASIGNACION_I is
'Fecha en que se realiza la asignaci�n del implemento.';

/*==============================================================*/
/* Index: ASIGNA_I_FK                                           */
/*==============================================================*/
create index ASIGNA_I_FK on ASIG_IMPL (
   COO_CEDULAE ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_4_FK on ASIG_IMPL (
   CEDULAE ASC
);

/*==============================================================*/
/* Index: LO_ASIGNAN_FK                                         */
/*==============================================================*/
create index LO_ASIGNAN_FK on ASIG_IMPL (
   ID_IMPLEMENTO ASC
);

/*==============================================================*/
/* Table: BITACORA_SEG                                          */
/*==============================================================*/
create table BITACORA_SEG  (
   ID_OPER              INTEGER                         not null,
   CEDULAE              INTEGER,
   FECHA_OPER           DATE                            not null,
   USU_OPER             VARCHAR2(20),
   MAQ_OPER             VARCHAR2(20),
   TABLA_MOD            VARCHAR2(20)                    not null,
   TIPO_OPER            VARCHAR2(6)                     not null,
   constraint PK_BITACORA_SEG primary key (ID_OPER)
);

/*==============================================================*/
/* Index: SIGUE_FK                                              */
/*==============================================================*/
create index SIGUE_FK on BITACORA_SEG (
   CEDULAE ASC
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE  (
   IDCL                 SMALLINT                        not null,
   CEDULAE              INTEGER                         not null,
   NOMBRECL             VARCHAR2(20)                    not null,
   DIRECCIONCL          VARCHAR2(20)                    not null,
   FECHA_REG_CL         DATE                            not null,
   constraint PK_CLIENTE primary key (IDCL)
);

comment on table CLIENTE is
'Posee todos los atributos que se requieren acerca de un cliente de la empresa.';

comment on column CLIENTE.IDCL is
'Identificador del cliente.';

comment on column CLIENTE.NOMBRECL is
'Nombre del cliente.';

comment on column CLIENTE.DIRECCIONCL is
'Direcci�n del cliente.';

/*==============================================================*/
/* Index: REG_CLI_FK                                            */
/*==============================================================*/
create index REG_CLI_FK on CLIENTE (
   CEDULAE ASC
);

/*==============================================================*/
/* Table: CL_TIENE_TELS                                         */
/*==============================================================*/
create table CL_TIENE_TELS  (
   ID_TC                SMALLINT                        not null,
   IDCL                 SMALLINT                        not null,
   constraint PK_CL_TIENE_TELS primary key (ID_TC, IDCL)
);

comment on table CL_TIENE_TELS is
'Relaci�n que indica que un CLIENTE puede tener varios TEL�FONOS CL.';

comment on column CL_TIENE_TELS.ID_TC is
'Identificador del tel�fono.';

comment on column CL_TIENE_TELS.IDCL is
'Identificador del cliente.';

/*==============================================================*/
/* Index: CL_TIENE_TELS2_FK                                     */
/*==============================================================*/
create index CL_TIENE_TELS2_FK on CL_TIENE_TELS (
   IDCL ASC
);

/*==============================================================*/
/* Index: CL_TIENE_TELS_FK                                      */
/*==============================================================*/
create index CL_TIENE_TELS_FK on CL_TIENE_TELS (
   ID_TC ASC
);

/*==============================================================*/
/* Table: COMUNICADO                                            */
/*==============================================================*/
create table COMUNICADO  (
   ID_COMUNICADO        SMALLINT                        not null,
   CEDULAE              INTEGER,
   DIR_CEDULAE          INTEGER,
   TIPO_CO              VARCHAR2(20)                    not null,
   FECHA_CO             DATE                            not null,
   CONTENIDO_CO         VARCHAR2(100)                   not null,
   URGENTE              SMALLINT                        not null,
   RESPUESTA_CO         VARCHAR2(100),
   constraint PK_COMUNICADO primary key (ID_COMUNICADO)
);

comment on table COMUNICADO is
'Posee los atributos de un comunicado realizado por parte de un EMPLEADO TEMPORAL.';

comment on column COMUNICADO.ID_COMUNICADO is
'Identificador del comunicado.';

comment on column COMUNICADO.TIPO_CO is
'Tipo de comunicado (Reclamo, Queja o Sugerencia).';

comment on column COMUNICADO.FECHA_CO is
'Fecha en que se realiza el comunicado.';

comment on column COMUNICADO.CONTENIDO_CO is
'Contenido del comunicado.';

comment on column COMUNICADO.URGENTE is
'Es urgente o no el comunicado.';

comment on column COMUNICADO.RESPUESTA_CO is
'Respuesta al comunicado.';

/*==============================================================*/
/* Index: REDACTA_FK                                            */
/*==============================================================*/
create index REDACTA_FK on COMUNICADO (
   CEDULAE ASC
);

/*==============================================================*/
/* Index: RESPONDE_FK                                           */
/*==============================================================*/
create index RESPONDE_FK on COMUNICADO (
   DIR_CEDULAE ASC
);

/*==============================================================*/
/* Table: CONTRATO                                              */
/*==============================================================*/
create table CONTRATO  (
   ID_CONTRATO          SMALLINT                        not null,
   IDCL                 SMALLINT                        not null,
   CEDULAE              INTEGER                         not null,
   UBICACION_C          VARCHAR2(20)                    not null,
   TELEFONO_C           INTEGER                         not null,
   CELULAR_C            INTEGER                         not null,
   TIPO_C               VARCHAR2(50)                    not null
      constraint CKC_TIPO_C_CONTRATO check (TIPO_C in ('<Val0>','<Val1>')),
   FECHA_INICIO_C       DATE                            not null,
   TIPO_PERSONAL_C      VARCHAR2(20)                    not null,
   CANTIDAD_PERSONAL_C  SMALLINT                        not null,
   COSTO_MENSUAL_C      NUMBER(8,2)                     not null,
   HORARIO_C            VARCHAR2(20)                    not null,
   TIEMPO_C             INTEGER,
   FECHA_REG_CON        DATE                            not null,
   constraint PK_CONTRATO primary key (ID_CONTRATO),
   constraint AK_ID_UBI_CONTRATO_CONTRATO unique (UBICACION_C)
);

comment on table CONTRATO is
'Posee los atributos requeridos en el registro de un contrato.';

comment on column CONTRATO.ID_CONTRATO is
'Identificador del contrato.';

comment on column CONTRATO.IDCL is
'Identificador del cliente.';

comment on column CONTRATO.UBICACION_C is
'Ubicacion donde se cumplira el contrato.';

comment on column CONTRATO.TELEFONO_C is
'Telefono del lugar donde se cumplira el contrato.';

comment on column CONTRATO.CELULAR_C is
'Celular del lugar donde se cumplira el contrato.';

comment on column CONTRATO.TIPO_C is
'Tipo de contrato (Definido o Indefinido).';

comment on column CONTRATO.FECHA_INICIO_C is
'Fecha de inicio del contrato.';

comment on column CONTRATO.TIPO_PERSONAL_C is
'Tipo de personal solicitado en el contrato (Vigilantes y/o Escoltas).';

comment on column CONTRATO.CANTIDAD_PERSONAL_C is
'Cantidad de personal solicitado en el contrato.';

comment on column CONTRATO.COSTO_MENSUAL_C is
'Costo mensual total del contrato.';

comment on column CONTRATO.HORARIO_C is
'Horarios de personal solicitados en el contrato.';

comment on column CONTRATO.TIEMPO_C is
'Si en contrato es de tipo definido este campo tendra el tiempo total del contrato, si no lo es podra ser null.';

/*==============================================================*/
/* Index: REG_CONT_FK                                           */
/*==============================================================*/
create index REG_CONT_FK on CONTRATO (
   CEDULAE ASC
);

/*==============================================================*/
/* Index: SOLICITA_FK                                           */
/*==============================================================*/
create index SOLICITA_FK on CONTRATO (
   IDCL ASC
);

/*==============================================================*/
/* Table: COORD_CONTRATO                                        */
/*==============================================================*/
create table COORD_CONTRATO  (
   CEDULAE              INTEGER                         not null,
   constraint PK_COORD_CONTRATO primary key (CEDULAE)
);

comment on table COORD_CONTRATO is
'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: COORDINADOR DE CONTRATO con los procesos de la empresa.';

/*==============================================================*/
/* Table: COORD_T_Y_Y                                           */
/*==============================================================*/
create table COORD_T_Y_Y  (
   CEDULAE              INTEGER                         not null,
   constraint PK_COORD_T_Y_Y primary key (CEDULAE)
);

comment on table COORD_T_Y_Y is
'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: COORDINADOR T�CNICO Y TECNOL�GICO con los procesos de la empresa.';

/*==============================================================*/
/* Table: DIR_COMERCIAL                                         */
/*==============================================================*/
create table DIR_COMERCIAL  (
   CEDULAE              INTEGER                         not null,
   constraint PK_DIR_COMERCIAL primary key (CEDULAE)
);

comment on table DIR_COMERCIAL is
'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: DIRECTOR COMERCIAL con los procesos de la empresa.';

/*==============================================================*/
/* Table: DIR_GESTION_HUM                                       */
/*==============================================================*/
create table DIR_GESTION_HUM  (
   CEDULAE              INTEGER                         not null,
   constraint PK_DIR_GESTION_HUM primary key (CEDULAE)
);

comment on table DIR_GESTION_HUM is
'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: DIRECTOR DE GESTION HUMANA con los procesos de la empresa.';

/*==============================================================*/
/* Table: DIR_OPERACIONES                                       */
/*==============================================================*/
create table DIR_OPERACIONES  (
   CEDULAE              INTEGER                         not null,
   constraint PK_DIR_OPERACIONES primary key (CEDULAE)
);

comment on table DIR_OPERACIONES is
'Posee los atributos de un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: DIRECTOR DE OPERACIONES con los procesos de la empresa.';

/*==============================================================*/
/* Table: EMPLEADOS                                             */
/*==============================================================*/
create table EMPLEADOS  (
   CEDULAE              INTEGER                         not null,
   DIR_CEDULAE          INTEGER,
   NOMBREE              VARCHAR2(20)                    not null,
   APELLIDOE            VARCHAR2(20)                    not null,
   CONTRASENAE          CHAR(10)                        not null,
   CODDOCUME            VARCHAR2(20)                    not null,
   FECHAREG             DATE                            not null,
   constraint PK_EMPLEADOS primary key (CEDULAE),
   constraint AK_ID_COD_EMP_EMPLEADO unique (CODDOCUME)
);

/*==============================================================*/
/* Index: REGISTRA_FK                                           */
/*==============================================================*/
create index REGISTRA_FK on EMPLEADOS (
   DIR_CEDULAE ASC
);

/*==============================================================*/
/* Table: EMP_PLANTA                                            */
/*==============================================================*/
create table EMP_PLANTA  (
   CEDULAE              INTEGER                         not null,
   SUELDOE              NUMBER(8,2)                     not null,
   constraint PK_EMP_PLANTA primary key (CEDULAE)
);

comment on table EMP_PLANTA is
'Posee los atributos de un empleado normal de la empresa, pero a la vez se le asignan los atributos propios de un empleado de planta.';

comment on column EMP_PLANTA.SUELDOE is
'Sueldo del empleado de planta.';

/*==============================================================*/
/* Table: EM_TEMP                                               */
/*==============================================================*/
create table EM_TEMP  (
   CEDULAE              INTEGER                         not null,
   ID_ASIG              SMALLINT,
   TIENE_CONTRATO       SMALLINT                        not null,
   TIPO_TEMP            VARCHAR2(20)                    not null,
   constraint PK_EM_TEMP primary key (CEDULAE)
);

comment on table EM_TEMP is
'Posee los atributos de un empleado normal de la empresa, pero a la vez se le asignan los atributos propios de un empleado temporal.';

comment on column EM_TEMP.ID_ASIG is
'Identificador de la asignaci�n.';

comment on column EM_TEMP.TIENE_CONTRATO is
'El empleado temporal tiene o no contrato asignado.';

comment on column EM_TEMP.TIPO_TEMP is
'Tipo de empleado temporal (Vigilante o Escolta).';

/*==============================================================*/
/* Index: ASIGNAN_A_E_FK                                        */
/*==============================================================*/
create index ASIGNAN_A_E_FK on EM_TEMP (
   ID_ASIG ASC
);

/*==============================================================*/
/* Table: EM_TIENE_TELS                                         */
/*==============================================================*/
create table EM_TIENE_TELS  (
   ID_TE                SMALLINT                        not null,
   CEDULAE              INTEGER                         not null,
   constraint PK_EM_TIENE_TELS primary key (ID_TE, CEDULAE)
);

comment on table EM_TIENE_TELS is
'Esta relaci�n permite que un empleado de la empresa pueda poseer mas de un numero telefonico registrado en la empresa.';

comment on column EM_TIENE_TELS.ID_TE is
'Identificador del tel�fono.';

/*==============================================================*/
/* Index: EM_TIENE_TELS2_FK                                     */
/*==============================================================*/
create index EM_TIENE_TELS2_FK on EM_TIENE_TELS (
   CEDULAE ASC
);

/*==============================================================*/
/* Index: EM_TIENE_TELS_FK                                      */
/*==============================================================*/
create index EM_TIENE_TELS_FK on EM_TIENE_TELS (
   ID_TE ASC
);

/*==============================================================*/
/* Table: IMPL_SEGURIDAD                                        */
/*==============================================================*/
create table IMPL_SEGURIDAD  (
   ID_IMPLEMENTO        SMALLINT                        not null,
   ID_PRO               SMALLINT,
   CEDULAE              INTEGER                         not null,
   NOMBRE_I             VARCHAR2(20)                    not null,
   PRECIO_UNITARIO_I    NUMBER(8,2)                     not null,
   CANTIDAD             SMALLINT                        not null,
   DESCRIPCION_I        VARCHAR2(100)                   not null,
   ESTADO_I             VARCHAR2(20)                    not null,
   FECHA_REG_IM         DATE                            not null,
   constraint PK_IMPL_SEGURIDAD primary key (ID_IMPLEMENTO),
   constraint AK_ID_NOM_IMPLEMENT_IMPL_SEG unique (NOMBRE_I)
);

comment on table IMPL_SEGURIDAD is
'Posee los atributos que requiere el registro de un IMPLEMENTO DE SEGURIDAD por parte de un empleado: COORDINADOR TECNICO Y TECNOLOGICO.';

comment on column IMPL_SEGURIDAD.ID_IMPLEMENTO is
'Identificador del implemento.';

comment on column IMPL_SEGURIDAD.ID_PRO is
'Identificador del proveedor.';

comment on column IMPL_SEGURIDAD.NOMBRE_I is
'Nombre del implemento.';

comment on column IMPL_SEGURIDAD.PRECIO_UNITARIO_I is
'Precio unitario del implemento de seguridad.';

comment on column IMPL_SEGURIDAD.CANTIDAD is
'Catidad actual total del implemento.';

comment on column IMPL_SEGURIDAD.DESCRIPCION_I is
'Descripcion general del implemento.';

comment on column IMPL_SEGURIDAD.ESTADO_I is
'Estado actual del implemento (Optimo o en mantenimiento).';

/*==============================================================*/
/* Index: REG_IMPL_FK                                           */
/*==============================================================*/
create index REG_IMPL_FK on IMPL_SEGURIDAD (
   CEDULAE ASC
);

/*==============================================================*/
/* Index: SUMINISTRA_FK                                         */
/*==============================================================*/
create index SUMINISTRA_FK on IMPL_SEGURIDAD (
   ID_PRO ASC
);

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR  (
   ID_PRO               SMALLINT                        not null,
   CEDULAE              INTEGER                         not null,
   NOMBRE               VARCHAR2(20)                    not null,
   DIRECCION            VARCHAR2(20)                    not null,
   FECHA_REG_PROV       DATE                            not null,
   constraint PK_PROVEEDOR primary key (ID_PRO),
   constraint AK_ID_NOM_PROV_PROVEEDO unique (NOMBRE)
);

comment on table PROVEEDOR is
'Posee los atributos que se requieren en el registro de un PROVEEDOR por parte de un empleado: COORDINADOR TECNICO Y TECNOLOGICO.';

comment on column PROVEEDOR.ID_PRO is
'Identificador del proveedor.';

comment on column PROVEEDOR.NOMBRE is
'Nombre del proveedor.';

comment on column PROVEEDOR.DIRECCION is
'Direcci�n del proveedor.';

/*==============================================================*/
/* Index: REG_PROV_FK                                           */
/*==============================================================*/
create index REG_PROV_FK on PROVEEDOR (
   CEDULAE ASC
);

/*==============================================================*/
/* Table: SUBGERENTE                                            */
/*==============================================================*/
create table SUBGERENTE  (
   CEDULAE              INTEGER                         not null,
   constraint PK_SUBGERENTE primary key (CEDULAE)
);

comment on table SUBGERENTE is
'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: SUBGERENTE con los procesos de la empresa.';

/*==============================================================*/
/* Table: TELS_CLI                                              */
/*==============================================================*/
create table TELS_CLI  (
   ID_TC                SMALLINT                        not null,
   NUM_TELEFONO_C       INTEGER                         not null,
   constraint PK_TELS_CLI primary key (ID_TC)
);

comment on table TELS_CLI is
'Contiene el directorio telefonico de todos los clientes de la empresa.';

comment on column TELS_CLI.ID_TC is
'Identificador del tel�fono.';

comment on column TELS_CLI.NUM_TELEFONO_C is
'Numero telefonico del cliente.';

/*==============================================================*/
/* Table: TELS_EMP                                              */
/*==============================================================*/
create table TELS_EMP  (
   ID_TE                SMALLINT                        not null,
   NUM_TELEFONO_E       INTEGER                         not null,
   constraint PK_TELS_EMP primary key (ID_TE)
);

comment on table TELS_EMP is
'Contiene el directorio telefonico de todos los empleados de la empresa.';

comment on column TELS_EMP.ID_TE is
'Identificador del tel�fono.';

comment on column TELS_EMP.NUM_TELEFONO_E is
'Numero telefonico del empleado.';

/*==============================================================*/
/* Table: TELS_PROV                                             */
/*==============================================================*/
create table TELS_PROV  (
   ID_TP                SMALLINT                        not null,
   ID_PRO               SMALLINT,
   NUM_TELEFONO_P       INTEGER                         not null,
   constraint PK_TELS_PROV primary key (ID_TP)
);

comment on table TELS_PROV is
'Contiene el directorio telefonico de todos los proveedores de la empresa.';

comment on column TELS_PROV.ID_TP is
'Identificador del tel�fono.';

comment on column TELS_PROV.ID_PRO is
'Identificador del proveedor.';

comment on column TELS_PROV.NUM_TELEFONO_P is
'Numero telefonico del proveedor.';

/*==============================================================*/
/* Index: PR_TIENE_TELS_FK                                      */
/*==============================================================*/
create index PR_TIENE_TELS_FK on TELS_PROV (
   ID_PRO ASC
);

alter table ACTUALIZACION
   add constraint FK_ACTUALIZ_ACTUALIZA_DIR_GEST foreign key (CEDULAE)
      references DIR_GESTION_HUM (CEDULAE);

alter table ACTUALIZACION
   add constraint FK_ACTUALIZ_ACTUALIZA_SUBGEREN foreign key (SUB_CEDULAE)
      references SUBGERENTE (CEDULAE);

alter table ACTU_IMPL
   add constraint FK_ACTU_IMP_ACTUALIZA_COORD_T_ foreign key (CEDULAE)
      references COORD_T_Y_Y (CEDULAE);

alter table ACTU_IMPL
   add constraint FK_ACTU_IMP_LO_ACTUAL_IMPL_SEG foreign key (ID_IMPLEMENTO)
      references IMPL_SEGURIDAD (ID_IMPLEMENTO);

alter table ASIGNACION_C
   add constraint FK_ASIGNACI_REALIZA_A_COORD_CO foreign key (COO_CEDULAE)
      references COORD_CONTRATO (CEDULAE);

alter table ASIGNACION_C
   add constraint FK_ASIGNACI_SE_ASIGNA_CONTRATO foreign key (ID_CONTRATO)
      references CONTRATO (ID_CONTRATO);

alter table ASIG_IMPL
   add constraint FK_ASIG_IMP_ASIGNA_I_COORD_T_ foreign key (COO_CEDULAE)
      references COORD_T_Y_Y (CEDULAE);

alter table ASIG_IMPL
   add constraint FK_ASIG_IMP_LO_ASIGNA_IMPL_SEG foreign key (ID_IMPLEMENTO)
      references IMPL_SEGURIDAD (ID_IMPLEMENTO);

alter table ASIG_IMPL
   add constraint FK_ASIG_IMP_RELATIONS_EM_TEMP foreign key (CEDULAE)
      references EM_TEMP (CEDULAE);

alter table BITACORA_SEG
   add constraint FK_BITACORA_SIGUE_EMPLEADO foreign key (CEDULAE)
      references EMPLEADOS (CEDULAE);

alter table CLIENTE
   add constraint FK_CLIENTE_REG_CLI_DIR_COME foreign key (CEDULAE)
      references DIR_COMERCIAL (CEDULAE);

alter table CL_TIENE_TELS
   add constraint FK_CL_TIENE_CL_TIENE__TELS_CLI foreign key (ID_TC)
      references TELS_CLI (ID_TC);

alter table CL_TIENE_TELS
   add constraint FK_CL_TIENE_CL_TIENE__CLIENTE foreign key (IDCL)
      references CLIENTE (IDCL);

alter table COMUNICADO
   add constraint FK_COMUNICA_REDACTA_EM_TEMP foreign key (CEDULAE)
      references EM_TEMP (CEDULAE);

alter table COMUNICADO
   add constraint FK_COMUNICA_RESPONDE_DIR_OPER foreign key (DIR_CEDULAE)
      references DIR_OPERACIONES (CEDULAE);

alter table CONTRATO
   add constraint FK_CONTRATO_REG_CONT_DIR_COME foreign key (CEDULAE)
      references DIR_COMERCIAL (CEDULAE);

alter table CONTRATO
   add constraint FK_CONTRATO_SOLICITA_CLIENTE foreign key (IDCL)
      references CLIENTE (IDCL);

alter table COORD_CONTRATO
   add constraint FK_COORD_CO_SON3_EMP_PLAN foreign key (CEDULAE)
      references EMP_PLANTA (CEDULAE);

alter table COORD_T_Y_Y
   add constraint FK_COORD_T__SON_EMP_PLAN foreign key (CEDULAE)
      references EMP_PLANTA (CEDULAE);

alter table DIR_COMERCIAL
   add constraint FK_DIR_COME_SON2_EMP_PLAN foreign key (CEDULAE)
      references EMP_PLANTA (CEDULAE);

alter table DIR_GESTION_HUM
   add constraint FK_DIR_GEST_SON5_EMP_PLAN foreign key (CEDULAE)
      references EMP_PLANTA (CEDULAE);

alter table DIR_OPERACIONES
   add constraint FK_DIR_OPER_SON4_EMP_PLAN foreign key (CEDULAE)
      references EMP_PLANTA (CEDULAE);

alter table EMPLEADOS
   add constraint FK_EMPLEADO_REGISTRA_DIR_GEST foreign key (DIR_CEDULAE)
      references DIR_GESTION_HUM (CEDULAE);

alter table EMP_PLANTA
   add constraint FK_EMP_PLAN_SON_E_EMPLEADO foreign key (CEDULAE)
      references EMPLEADOS (CEDULAE);

alter table EM_TEMP
   add constraint FK_EM_TEMP_ASIGNAN_A_ASIGNACI foreign key (ID_ASIG)
      references ASIGNACION_C (ID_ASIG);

alter table EM_TEMP
   add constraint FK_EM_TEMP_SON_E2_EMPLEADO foreign key (CEDULAE)
      references EMPLEADOS (CEDULAE);

alter table EM_TIENE_TELS
   add constraint FK_EM_TIENE_EM_TIENE__TELS_EMP foreign key (ID_TE)
      references TELS_EMP (ID_TE);

alter table EM_TIENE_TELS
   add constraint FK_EM_TIENE_EM_TIENE__EMPLEADO foreign key (CEDULAE)
      references EMPLEADOS (CEDULAE);

alter table IMPL_SEGURIDAD
   add constraint FK_IMPL_SEG_REG_IMPL_COORD_T_ foreign key (CEDULAE)
      references COORD_T_Y_Y (CEDULAE);

alter table IMPL_SEGURIDAD
   add constraint FK_IMPL_SEG_SUMINISTR_PROVEEDO foreign key (ID_PRO)
      references PROVEEDOR (ID_PRO);

alter table PROVEEDOR
   add constraint FK_PROVEEDO_REG_PROV_COORD_T_ foreign key (CEDULAE)
      references COORD_T_Y_Y (CEDULAE);

alter table SUBGERENTE
   add constraint FK_SUBGEREN_SON6_EMP_PLAN foreign key (CEDULAE)
      references EMP_PLANTA (CEDULAE);

alter table TELS_PROV
   add constraint FK_TELS_PRO_PR_TIENE__PROVEEDO foreign key (ID_PRO)
      references PROVEEDOR (ID_PRO);
