/*==============================================================*/
/* DBMS name:      Sybase AS Enterprise 15.0                    */
/* Created on:     03/06/2013 10:16:00 p.m.                     */
/*==============================================================*/


if exists (select 1
            from  sysobjects
            where  id = object_id('V_ACTUALIZACION')
            and   type = 'V')
   drop view V_ACTUALIZACION
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_ACTUALIZACION_IMPLEMENTO')
            and   type = 'V')
   drop view V_ACTUALIZACION_IMPLEMENTO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_ASIGNACION_CONTRATO')
            and   type = 'V')
   drop view V_ASIGNACION_CONTRATO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_ASIGNACION_IMPLEMENTO')
            and   type = 'V')
   drop view V_ASIGNACION_IMPLEMENTO
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
            where  id = object_id('V_CLIENTE_R_TELEFONO')
            and   type = 'V')
   drop view V_CLIENTE_R_TELEFONO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_COMUNICADO')
            and   type = 'V')
   drop view V_COMUNICADO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_CONTRATO')
            and   type = 'V')
   drop view V_CONTRATO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_COORDINADOR_CONTRATO')
            and   type = 'V')
   drop view V_COORDINADOR_CONTRATO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_COORDINADOR_T_T')
            and   type = 'V')
   drop view V_COORDINADOR_T_T
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_DIRECTOR_COMERCIAL')
            and   type = 'V')
   drop view V_DIRECTOR_COMERCIAL
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_DIRECTOR_G_H')
            and   type = 'V')
   drop view V_DIRECTOR_G_H
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_DIRECTOR_OPERACIONES')
            and   type = 'V')
   drop view V_DIRECTOR_OPERACIONES
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_EMPLEADO')
            and   type = 'V')
   drop view V_EMPLEADO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_EMPLEADO_PLANTA')
            and   type = 'V')
   drop view V_EMPLEADO_PLANTA
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_EMPLEADO_R_TELEFONO')
            and   type = 'V')
   drop view V_EMPLEADO_R_TELEFONO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_EMPLEADO_TEMPORAL')
            and   type = 'V')
   drop view V_EMPLEADO_TEMPORAL
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_IMPLEMENTO_SEGURIDAD')
            and   type = 'V')
   drop view V_IMPLEMENTO_SEGURIDAD
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_PROVEEDOR')
            and   type = 'V')
   drop view V_PROVEEDOR
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_SUBGERENTE')
            and   type = 'V')
   drop view V_SUBGERENTE
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_TELEFONOS_CLIENTE')
            and   type = 'V')
   drop view V_TELEFONOS_CLIENTE
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_TELEFONOS_EMPLEADO')
            and   type = 'V')
   drop view V_TELEFONOS_EMPLEADO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('V_TELEFONOS_PROVEEDOR')
            and   type = 'V')
   drop view V_TELEFONOS_PROVEEDOR
go

if exists (select 1
            from  sysobjects
            where id = object_id('ACTUALIZACION')
            and   type = 'U')
   drop table ACTUALIZACION
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ACTUALIZACION_IMPLEMENTO')
            and   name  = 'LO_ACTUALIZAN_FK'
            and   indid > 0
            and   indid < 255)
   drop index ACTUALIZACION_IMPLEMENTO.LO_ACTUALIZAN_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ACTUALIZACION_IMPLEMENTO')
            and   name  = 'ACTUALIZA_FK'
            and   indid > 0
            and   indid < 255)
   drop index ACTUALIZACION_IMPLEMENTO.ACTUALIZA_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('ACTUALIZACION_IMPLEMENTO')
            and   type = 'U')
   drop table ACTUALIZACION_IMPLEMENTO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ASIGNACION_CONTRATO')
            and   name  = 'REALIZA_ASIGNACION_FK'
            and   indid > 0
            and   indid < 255)
   drop index ASIGNACION_CONTRATO.REALIZA_ASIGNACION_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ASIGNACION_CONTRATO')
            and   name  = 'SE_ASIGNA_CONTRATO_FK'
            and   indid > 0
            and   indid < 255)
   drop index ASIGNACION_CONTRATO.SE_ASIGNA_CONTRATO_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('ASIGNACION_CONTRATO')
            and   type = 'U')
   drop table ASIGNACION_CONTRATO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ASIGNACION_IMPLEMENTO')
            and   name  = 'LO_ASIGNAN_FK'
            and   indid > 0
            and   indid < 255)
   drop index ASIGNACION_IMPLEMENTO.LO_ASIGNAN_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ASIGNACION_IMPLEMENTO')
            and   name  = 'RELATIONSHIP_4_FK'
            and   indid > 0
            and   indid < 255)
   drop index ASIGNACION_IMPLEMENTO.RELATIONSHIP_4_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ASIGNACION_IMPLEMENTO')
            and   name  = 'ASIGNA_IMPLEMENTO_FK'
            and   indid > 0
            and   indid < 255)
   drop index ASIGNACION_IMPLEMENTO.ASIGNA_IMPLEMENTO_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('ASIGNACION_IMPLEMENTO')
            and   type = 'U')
   drop table ASIGNACION_IMPLEMENTO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('BITACORA')
            and   name  = 'SIGUE_FK'
            and   indid > 0
            and   indid < 255)
   drop index BITACORA.SIGUE_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('BITACORA')
            and   type = 'U')
   drop table BITACORA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CLIENTE')
            and   name  = 'REGISTRO_CLIENTE_FK'
            and   indid > 0
            and   indid < 255)
   drop index CLIENTE.REGISTRO_CLIENTE_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('CLIENTE')
            and   type = 'U')
   drop table CLIENTE
go

if exists (select 1
            from  sysobjects
            where id = object_id('CLIENTE_TELEFONO')
            and   type = 'U')
   drop table CLIENTE_TELEFONO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('COMUNICADO')
            and   name  = 'RESPONDE_FK'
            and   indid > 0
            and   indid < 255)
   drop index COMUNICADO.RESPONDE_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('COMUNICADO')
            and   name  = 'REDACTA_FK'
            and   indid > 0
            and   indid < 255)
   drop index COMUNICADO.REDACTA_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('COMUNICADO')
            and   type = 'U')
   drop table COMUNICADO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CONTRATO')
            and   name  = 'SOLICITA_FK'
            and   indid > 0
            and   indid < 255)
   drop index CONTRATO.SOLICITA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CONTRATO')
            and   name  = 'REGISTRO_CONTRATO_FK'
            and   indid > 0
            and   indid < 255)
   drop index CONTRATO.REGISTRO_CONTRATO_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('CONTRATO')
            and   type = 'U')
   drop table CONTRATO
go

if exists (select 1
            from  sysobjects
            where id = object_id('COORDINADOR_CONTRATO')
            and   type = 'U')
   drop table COORDINADOR_CONTRATO
go

if exists (select 1
            from  sysobjects
            where id = object_id('COORDINADOR_T_T')
            and   type = 'U')
   drop table COORDINADOR_T_T
go

if exists (select 1
            from  sysobjects
            where id = object_id('DIRECTOR_COMERCIAL')
            and   type = 'U')
   drop table DIRECTOR_COMERCIAL
go

if exists (select 1
            from  sysobjects
            where id = object_id('DIRECTOR_GESTION_HUMANA')
            and   type = 'U')
   drop table DIRECTOR_GESTION_HUMANA
go

if exists (select 1
            from  sysobjects
            where id = object_id('DIRECTOR_OPERACIONES')
            and   type = 'U')
   drop table DIRECTOR_OPERACIONES
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('EMPLEADO')
            and   name  = 'REGISTRA_FK'
            and   indid > 0
            and   indid < 255)
   drop index EMPLEADO.REGISTRA_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('EMPLEADO')
            and   type = 'U')
   drop table EMPLEADO
go

if exists (select 1
            from  sysobjects
            where id = object_id('EMPLEADO_PLANTA')
            and   type = 'U')
   drop table EMPLEADO_PLANTA
go

if exists (select 1
            from  sysobjects
            where id = object_id('EMPLEADO_TELEFONO')
            and   type = 'U')
   drop table EMPLEADO_TELEFONO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('EMPLEADO_TEMPORAL')
            and   name  = 'ASIGNAN_A_EMPLEADO_FK'
            and   indid > 0
            and   indid < 255)
   drop index EMPLEADO_TEMPORAL.ASIGNAN_A_EMPLEADO_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('EMPLEADO_TEMPORAL')
            and   type = 'U')
   drop table EMPLEADO_TEMPORAL
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('IMPLEMENTO_SEGURIDAD')
            and   name  = 'SUMINISTRA_FK'
            and   indid > 0
            and   indid < 255)
   drop index IMPLEMENTO_SEGURIDAD.SUMINISTRA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('IMPLEMENTO_SEGURIDAD')
            and   name  = 'REGISTRO_IMPLEMENTO_FK'
            and   indid > 0
            and   indid < 255)
   drop index IMPLEMENTO_SEGURIDAD.REGISTRO_IMPLEMENTO_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('IMPLEMENTO_SEGURIDAD')
            and   type = 'U')
   drop table IMPLEMENTO_SEGURIDAD
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PROVEEDOR')
            and   name  = 'REGISTRO_PROVEEDOR_FK'
            and   indid > 0
            and   indid < 255)
   drop index PROVEEDOR.REGISTRO_PROVEEDOR_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('PROVEEDOR')
            and   type = 'U')
   drop table PROVEEDOR
go

if exists (select 1
            from  sysobjects
            where id = object_id('SUBGERENTE')
            and   type = 'U')
   drop table SUBGERENTE
go

if exists (select 1
            from  sysobjects
            where id = object_id('TELEFONOS_CLIENTE')
            and   type = 'U')
   drop table TELEFONOS_CLIENTE
go

if exists (select 1
            from  sysobjects
            where id = object_id('TELEFONOS_EMPLEADO')
            and   type = 'U')
   drop table TELEFONOS_EMPLEADO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TELEFONOS_PROVEEDOR')
            and   name  = 'PROVEEDOR_TELEFONO_FK'
            and   indid > 0
            and   indid < 255)
   drop index TELEFONOS_PROVEEDOR.PROVEEDOR_TELEFONO_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('TELEFONOS_PROVEEDOR')
            and   type = 'U')
   drop table TELEFONOS_PROVEEDOR
go

/*==============================================================*/
/* Table: ACTUALIZACION                                         */
/*==============================================================*/
create table ACTUALIZACION (
   CEDULADIR            bigint                         not null,
   CEDULASG             bigint                         not null,
   FECHA_ACTUAL_DGH     datetime                       not null,
   constraint PK_ACTUALIZACION primary key (CEDULADIR, CEDULASG)
)
go

/*==============================================================*/
/* Table: ACTUALIZACION_IMPLEMENTO                              */
/*==============================================================*/
create table ACTUALIZACION_IMPLEMENTO (
   ID_ACTUALIZACION     smallint                       not null,
   ID_IMPLEMENTO        smallint                       null,
   CEDULA               bigint                         null,
   FECHA_ACTUALIZACION  datetime                       null,
   CANTIDAD_AGREGADA    smallint                       null,
   DESCRIPCION_ACTUALIZACION varchar(100)                   not null,
   constraint PK_ACTUALIZACION_IMPLEMENTO primary key nonclustered (ID_ACTUALIZACION)
)
go

/*==============================================================*/
/* Index: ACTUALIZA_FK                                          */
/*==============================================================*/
create index ACTUALIZA_FK on ACTUALIZACION_IMPLEMENTO (
CEDULA ASC
)
go

/*==============================================================*/
/* Index: LO_ACTUALIZAN_FK                                      */
/*==============================================================*/
create index LO_ACTUALIZAN_FK on ACTUALIZACION_IMPLEMENTO (
ID_IMPLEMENTO ASC
)
go

/*==============================================================*/
/* Table: ASIGNACION_CONTRATO                                   */
/*==============================================================*/
create table ASIGNACION_CONTRATO (
   ID_ASIGNACION_CONTRATO smallint                       not null,
   ID_CONTRATO          smallint                       null,
   CEDULA               bigint                         null,
   FECHA_ASIGNACION_CONTRATO datetime                       not null,
   HORARIO_ASIGNADO_CONTRATO varchar(20)                    not null,
   constraint PK_ASIGNACION_CONTRATO primary key nonclustered (ID_ASIGNACION_CONTRATO)
)
go

/*==============================================================*/
/* Index: SE_ASIGNA_CONTRATO_FK                                 */
/*==============================================================*/
create index SE_ASIGNA_CONTRATO_FK on ASIGNACION_CONTRATO (
ID_CONTRATO ASC
)
go

/*==============================================================*/
/* Index: REALIZA_ASIGNACION_FK                                 */
/*==============================================================*/
create index REALIZA_ASIGNACION_FK on ASIGNACION_CONTRATO (
CEDULA ASC
)
go

/*==============================================================*/
/* Table: ASIGNACION_IMPLEMENTO                                 */
/*==============================================================*/
create table ASIGNACION_IMPLEMENTO (
   ID_ASIGNACION_IMPLEMENTO smallint                       not null,
   ID_IMPLEMENTO        smallint                       null,
   CEDULAET             bigint                         null,
   CEDULACTT            bigint                         null,
   CANTIDAD_ASIGNADA    smallint                       not null,
   ESTADO_ASIGNACION    varchar(20)                    not null,
   FECHA_ASIGNACION     datetime                       not null,
   constraint PK_ASIGNACION_IMPLEMENTO primary key nonclustered (ID_ASIGNACION_IMPLEMENTO)
)
go

/*==============================================================*/
/* Index: ASIGNA_IMPLEMENTO_FK                                  */
/*==============================================================*/
create index ASIGNA_IMPLEMENTO_FK on ASIGNACION_IMPLEMENTO (
CEDULACTT ASC
)
go

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_4_FK on ASIGNACION_IMPLEMENTO (
CEDULAET ASC
)
go

/*==============================================================*/
/* Index: LO_ASIGNAN_FK                                         */
/*==============================================================*/
create index LO_ASIGNAN_FK on ASIGNACION_IMPLEMENTO (
ID_IMPLEMENTO ASC
)
go

/*==============================================================*/
/* Table: BITACORA                                              */
/*==============================================================*/
create table BITACORA (
   ID_OPERACION         int                            not null,
   CEDULA               bigint                         null,
   FECHA_OPERACION      datetime                       not null,
   USUARIO_OPERACION    varchar(20)                    null,
   MAQUINA_OPERACION    varchar(20)                    null,
   TABLA_MODIFICADA     varchar(20)                    not null,
   TIPO_OPERACION       varchar(6)                     not null,
   constraint PK_BITACORA primary key nonclustered (ID_OPERACION)
)
go

/*==============================================================*/
/* Index: SIGUE_FK                                              */
/*==============================================================*/
create index SIGUE_FK on BITACORA (
CEDULA ASC
)
go

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   ID_CLIENTE           smallint                       not null,
   CEDULA               bigint                         not null,
   NOMBRE_CLIENTE       varchar(30)                    not null,
   DIRECCION_CLIENTE    varchar(20)                    not null,
   FECHA_REGISTRO_CLIENTE datetime                       null,
   constraint PK_CLIENTE primary key nonclustered (ID_CLIENTE)
)
go

/*==============================================================*/
/* Index: REGISTRO_CLIENTE_FK                                   */
/*==============================================================*/
create index REGISTRO_CLIENTE_FK on CLIENTE (
CEDULA ASC
)
go

/*==============================================================*/
/* Table: CLIENTE_TELEFONO                                      */
/*==============================================================*/
create table CLIENTE_TELEFONO (
   ID_CLIENTE           smallint                       not null,
   ID_TELEFONO_CLIENTE  smallint                       not null,
   constraint PK_CLIENTE_TELEFONO primary key (ID_CLIENTE, ID_TELEFONO_CLIENTE)
)
go

/*==============================================================*/
/* Table: COMUNICADO                                            */
/*==============================================================*/
create table COMUNICADO (
   ID_COMUNICADO        smallint                       not null,
   CEDULAET             bigint                         null,
   CEDULADO             bigint                         null,
   TIPO_COMUNICADO      varchar(20)                    not null,
   FECHA_COMUNICADO     datetime                       not null,
   CONTENIDO_COMUNICADO varchar(100)                   not null,
   URGENTE              bit                            not null,
   RESPUESTA_COMUNICADO varchar(100)                   null,
   constraint PK_COMUNICADO primary key nonclustered (ID_COMUNICADO)
)
go

/*==============================================================*/
/* Index: REDACTA_FK                                            */
/*==============================================================*/
create index REDACTA_FK on COMUNICADO (
CEDULAET ASC
)
go

/*==============================================================*/
/* Index: RESPONDE_FK                                           */
/*==============================================================*/
create index RESPONDE_FK on COMUNICADO (
CEDULADO ASC
)
go

/*==============================================================*/
/* Table: CONTRATO                                              */
/*==============================================================*/
create table CONTRATO (
   ID_CONTRATO          smallint                       not null,
   ID_CLIENTE           smallint                       not null,
   CEDULA               bigint                         not null,
   UBICACION            varchar(20)                    not null,
   TELEFONO             int                            not null,
   CELULAR              int                            not null,
   TIPO_CONTRATO        varchar(20)                    not null,
   FECHA_INICIO         datetime                       not null,
   TIPO_PERSONAL        varchar(20)                    not null,
   CANTIDAD_PERSONAL    smallint                       not null,
   COSTO_MENSUAL        money                          not null,
   HORARIO_CONTRATO     varchar(20)                    not null,
   TIEMPO               int                            null,
   FECHA_REGISTRO_CONTRATO datetime                       not null,
   constraint PK_CONTRATO primary key nonclustered (ID_CONTRATO),
   constraint AK_UBICACION_CONTRATO unique (UBICACION)
)
go

/*==============================================================*/
/* Index: REGISTRO_CONTRATO_FK                                  */
/*==============================================================*/
create index REGISTRO_CONTRATO_FK on CONTRATO (
CEDULA ASC
)
go

/*==============================================================*/
/* Index: SOLICITA_FK                                           */
/*==============================================================*/
create index SOLICITA_FK on CONTRATO (
ID_CLIENTE ASC
)
go

/*==============================================================*/
/* Table: COORDINADOR_CONTRATO                                  */
/*==============================================================*/
create table COORDINADOR_CONTRATO (
   CEDULA               bigint                         not null,
   constraint PK_COORDINADOR_CONTRATO primary key (CEDULA)
)
go

/*==============================================================*/
/* Table: COORDINADOR_T_T                                       */
/*==============================================================*/
create table COORDINADOR_T_T (
   CEDULA               bigint                         not null,
   constraint PK_COORDINADOR_T_T primary key (CEDULA)
)
go

/*==============================================================*/
/* Table: DIRECTOR_COMERCIAL                                    */
/*==============================================================*/
create table DIRECTOR_COMERCIAL (
   CEDULA               bigint                         not null,
   constraint PK_DIRECTOR_COMERCIAL primary key (CEDULA)
)
go

/*==============================================================*/
/* Table: DIRECTOR_GESTION_HUMANA                               */
/*==============================================================*/
create table DIRECTOR_GESTION_HUMANA (
   CEDULA               bigint                         not null,
   constraint PK_DIRECTOR_GESTION_HUMANA primary key (CEDULA)
)
go

/*==============================================================*/
/* Table: DIRECTOR_OPERACIONES                                  */
/*==============================================================*/
create table DIRECTOR_OPERACIONES (
   CEDULA               bigint                         not null,
   constraint PK_DIRECTOR_OPERACIONES primary key (CEDULA)
)
go

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table EMPLEADO (
   CEDULA               bigint                         not null,
   CEDULADIR            bigint                         null,
   NOMBRE_EMPLEADO      varchar(20)                    not null,
   APELLIDO_EMPLEADO    varchar(20)                    not null,
   CONTRASENIA_EMPLEADO char(10)                       not null,
   CODIGO_EMPLEADO      varchar(20)                    not null,
   FECHA_REGISTRO       datetime                       not null,
   constraint PK_EMPLEADO primary key nonclustered (CEDULA),
   constraint AK_CODIGO_EMPLEADO unique (CODIGO_EMPLEADO)
)
go

/*==============================================================*/
/* Index: REGISTRA_FK                                           */
/*==============================================================*/
create index REGISTRA_FK on EMPLEADO (
CEDULADIR ASC
)
go

/*==============================================================*/
/* Table: EMPLEADO_PLANTA                                       */
/*==============================================================*/
create table EMPLEADO_PLANTA (
   CEDULA               bigint                         not null,
   SUELDO               money                          not null,
   constraint PK_EMPLEADO_PLANTA primary key (CEDULA)
)
go

/*==============================================================*/
/* Table: EMPLEADO_TELEFONO                                     */
/*==============================================================*/
create table EMPLEADO_TELEFONO (
   CEDULA               bigint                         not null,
   ID_TELEFONO_EMPLEADO smallint                       not null,
   constraint PK_EMPLEADO_TELEFONO primary key (CEDULA, ID_TELEFONO_EMPLEADO)
)
go

/*==============================================================*/
/* Table: EMPLEADO_TEMPORAL                                     */
/*==============================================================*/
create table EMPLEADO_TEMPORAL (
   CEDULA               bigint                         not null,
   ID_ASIGNACION_CONTRATO smallint                       null,
   TIENE_CONTRATO       bit                            not null,
   TIPO_TEMPORAL        varchar(20)                    not null,
   constraint PK_EMPLEADO_TEMPORAL primary key (CEDULA)
)
go

/*==============================================================*/
/* Index: ASIGNAN_A_EMPLEADO_FK                                 */
/*==============================================================*/
create index ASIGNAN_A_EMPLEADO_FK on EMPLEADO_TEMPORAL (
ID_ASIGNACION_CONTRATO ASC
)
go

/*==============================================================*/
/* Table: IMPLEMENTO_SEGURIDAD                                  */
/*==============================================================*/
create table IMPLEMENTO_SEGURIDAD (
   ID_IMPLEMENTO        smallint                       not null,
   ID_PROVEEDOR         smallint                       null,
   CEDULA               bigint                         not null,
   NOMBRE_IMPLEMENTO    varchar(30)                    not null,
   PRECIO_UNITARIO_IMPLEMENTO money                          not null,
   CANTIDAD_IMPLEMENTOS smallint                       not null,
   DESCRIPCION_IMPLEMENTO varchar(100)                   not null,
   ESTADO_IMPLEMENTO    varchar(20)                    not null,
   FECHA_REGISTRO_IMPLEMENTO datetime                       not null,
   constraint PK_IMPLEMENTO_SEGURIDAD primary key nonclustered (ID_IMPLEMENTO),
   constraint AK_NOMBREIMPLEMENTO_IMPLEMEN unique (NOMBRE_IMPLEMENTO)
)
go

/*==============================================================*/
/* Index: REGISTRO_IMPLEMENTO_FK                                */
/*==============================================================*/
create index REGISTRO_IMPLEMENTO_FK on IMPLEMENTO_SEGURIDAD (
CEDULA ASC
)
go

/*==============================================================*/
/* Index: SUMINISTRA_FK                                         */
/*==============================================================*/
create index SUMINISTRA_FK on IMPLEMENTO_SEGURIDAD (
ID_PROVEEDOR ASC
)
go

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR (
   ID_PROVEEDOR         smallint                       not null,
   CEDULA               bigint                         not null,
   NOMBRE_PROVEEDOR     varchar(20)                    not null,
   DIRECCION_PROVEEDOR  varchar(20)                    not null,
   FECHA_REGISTRO_PROVEEDOR datetime                       not null,
   constraint PK_PROVEEDOR primary key nonclustered (ID_PROVEEDOR),
   constraint AK_NOMBREPROVEEDOR_PROVEEDO unique (NOMBRE_PROVEEDOR)
)
go

/*==============================================================*/
/* Index: REGISTRO_PROVEEDOR_FK                                 */
/*==============================================================*/
create index REGISTRO_PROVEEDOR_FK on PROVEEDOR (
CEDULA ASC
)
go

/*==============================================================*/
/* Table: SUBGERENTE                                            */
/*==============================================================*/
create table SUBGERENTE (
   CEDULA               bigint                         not null,
   constraint PK_SUBGERENTE primary key (CEDULA)
)
go

/*==============================================================*/
/* Table: TELEFONOS_CLIENTE                                     */
/*==============================================================*/
create table TELEFONOS_CLIENTE (
   ID_TELEFONO_CLIENTE  smallint                       not null,
   NUM_TELEFONO_CLIENTE bigint                         not null,
   constraint PK_TELEFONOS_CLIENTE primary key nonclustered (ID_TELEFONO_CLIENTE)
)
go

/*==============================================================*/
/* Table: TELEFONOS_EMPLEADO                                    */
/*==============================================================*/
create table TELEFONOS_EMPLEADO (
   ID_TELEFONO_EMPLEADO smallint                       not null,
   NUMERO_TELEFONO_EMPLEADO bigint                         not null,
   constraint PK_TELEFONOS_EMPLEADO primary key nonclustered (ID_TELEFONO_EMPLEADO)
)
go

/*==============================================================*/
/* Table: TELEFONOS_PROVEEDOR                                   */
/*==============================================================*/
create table TELEFONOS_PROVEEDOR (
   ID_TELEFONO_PROVEEDOR smallint                       not null,
   ID_PROVEEDOR         smallint                       null,
   NUMERO_TELEFONO_PROVEEDOR bigint                         not null,
   constraint PK_TELEFONOS_PROVEEDOR primary key nonclustered (ID_TELEFONO_PROVEEDOR)
)
go

/*==============================================================*/
/* Index: PROVEEDOR_TELEFONO_FK                                 */
/*==============================================================*/
create index PROVEEDOR_TELEFONO_FK on TELEFONOS_PROVEEDOR (
ID_PROVEEDOR ASC
)
go

/*==============================================================*/
/* View: V_ACTUALIZACION                                        */
/*==============================================================*/
create view V_ACTUALIZACION as
select
   ACTUALIZACION.CEDULADIR,
   ACTUALIZACION.CEDULASG,
   ACTUALIZACION.FECHA_ACTUAL_DGH
from
   ACTUALIZACION
go

/*==============================================================*/
/* View: V_ACTUALIZACION_IMPLEMENTO                             */
/*==============================================================*/
create view V_ACTUALIZACION_IMPLEMENTO as
select
   ACTUALIZACION_IMPLEMENTO.ID_ACTUALIZACION,
   ACTUALIZACION_IMPLEMENTO.ID_IMPLEMENTO,
   ACTUALIZACION_IMPLEMENTO.CEDULA,
   ACTUALIZACION_IMPLEMENTO.FECHA_ACTUALIZACION,
   ACTUALIZACION_IMPLEMENTO.CANTIDAD_AGREGADA,
   ACTUALIZACION_IMPLEMENTO.DESCRIPCION_ACTUALIZACION
from
   ACTUALIZACION_IMPLEMENTO
go

/*==============================================================*/
/* View: V_ASIGNACION_CONTRATO                                  */
/*==============================================================*/
create view V_ASIGNACION_CONTRATO as
select
   ASIGNACION_CONTRATO.ID_ASIGNACION_CONTRATO,
   ASIGNACION_CONTRATO.ID_CONTRATO,
   ASIGNACION_CONTRATO.CEDULA,
   ASIGNACION_CONTRATO.FECHA_ASIGNACION_CONTRATO,
   ASIGNACION_CONTRATO.HORARIO_ASIGNADO_CONTRATO
from
   ASIGNACION_CONTRATO
go

/*==============================================================*/
/* View: V_ASIGNACION_IMPLEMENTO                                */
/*==============================================================*/
create view V_ASIGNACION_IMPLEMENTO as
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
go

/*==============================================================*/
/* View: V_BITACORA                                             */
/*==============================================================*/
create view V_BITACORA as
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
go

/*==============================================================*/
/* View: V_CLIENTE                                              */
/*==============================================================*/
create view V_CLIENTE as
select
   CLIENTE.ID_CLIENTE,
   CLIENTE.CEDULA,
   CLIENTE.NOMBRE_CLIENTE,
   CLIENTE.DIRECCION_CLIENTE,
   CLIENTE.FECHA_REGISTRO_CLIENTE
from
   CLIENTE
go

/*==============================================================*/
/* View: V_CLIENTE_R_TELEFONO                                   */
/*==============================================================*/
create view V_CLIENTE_R_TELEFONO as
select
   CLIENTE_TELEFONO.ID_CLIENTE,
   CLIENTE_TELEFONO.ID_TELEFONO_CLIENTE
from
   CLIENTE_TELEFONO
go

/*==============================================================*/
/* View: V_COMUNICADO                                           */
/*==============================================================*/
create view V_COMUNICADO as
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
go

/*==============================================================*/
/* View: V_CONTRATO                                             */
/*==============================================================*/
create view V_CONTRATO as
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
go

/*==============================================================*/
/* View: V_COORDINADOR_CONTRATO                                 */
/*==============================================================*/
create view V_COORDINADOR_CONTRATO as
select
   COORDINADOR_CONTRATO.CEDULA
from
   COORDINADOR_CONTRATO
go

/*==============================================================*/
/* View: V_COORDINADOR_T_T                                      */
/*==============================================================*/
create view V_COORDINADOR_T_T as
select
   COORDINADOR_T_T.CEDULA
from
   COORDINADOR_T_T
go

/*==============================================================*/
/* View: V_DIRECTOR_COMERCIAL                                   */
/*==============================================================*/
create view V_DIRECTOR_COMERCIAL as
select
   DIRECTOR_COMERCIAL.CEDULA
from
   DIRECTOR_COMERCIAL
go

/*==============================================================*/
/* View: V_DIRECTOR_G_H                                         */
/*==============================================================*/
create view V_DIRECTOR_G_H as
select
   DIRECTOR_GESTION_HUMANA.CEDULA
from
   DIRECTOR_GESTION_HUMANA
go

/*==============================================================*/
/* View: V_DIRECTOR_OPERACIONES                                 */
/*==============================================================*/
create view V_DIRECTOR_OPERACIONES as
select
   DIRECTOR_OPERACIONES.CEDULA
from
   DIRECTOR_OPERACIONES
go

/*==============================================================*/
/* View: V_EMPLEADO                                             */
/*==============================================================*/
create view V_EMPLEADO as
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
go

/*==============================================================*/
/* View: V_EMPLEADO_PLANTA                                      */
/*==============================================================*/
create view V_EMPLEADO_PLANTA as
select
   EMPLEADO_PLANTA.CEDULA,
   EMPLEADO_PLANTA.SUELDO
from
   EMPLEADO_PLANTA
go

/*==============================================================*/
/* View: V_EMPLEADO_R_TELEFONO                                  */
/*==============================================================*/
create view V_EMPLEADO_R_TELEFONO as
select
   EMPLEADO_TELEFONO.CEDULA,
   EMPLEADO_TELEFONO.ID_TELEFONO_EMPLEADO
from
   EMPLEADO_TELEFONO
go

/*==============================================================*/
/* View: V_EMPLEADO_TEMPORAL                                    */
/*==============================================================*/
create view V_EMPLEADO_TEMPORAL as
select
   EMPLEADO_TEMPORAL.CEDULA,
   EMPLEADO_TEMPORAL.ID_ASIGNACION_CONTRATO,
   EMPLEADO_TEMPORAL.TIENE_CONTRATO,
   EMPLEADO_TEMPORAL.TIPO_TEMPORAL
from
   EMPLEADO_TEMPORAL
go

/*==============================================================*/
/* View: V_IMPLEMENTO_SEGURIDAD                                 */
/*==============================================================*/
create view V_IMPLEMENTO_SEGURIDAD as
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
go

/*==============================================================*/
/* View: V_PROVEEDOR                                            */
/*==============================================================*/
create view V_PROVEEDOR as
select
   PROVEEDOR.ID_PROVEEDOR,
   PROVEEDOR.CEDULA,
   PROVEEDOR.NOMBRE_PROVEEDOR,
   PROVEEDOR.DIRECCION_PROVEEDOR,
   PROVEEDOR.FECHA_REGISTRO_PROVEEDOR
from
   PROVEEDOR
go

/*==============================================================*/
/* View: V_SUBGERENTE                                           */
/*==============================================================*/
create view V_SUBGERENTE as
select
   SUBGERENTE.CEDULA
from
   SUBGERENTE
go

/*==============================================================*/
/* View: V_TELEFONOS_CLIENTE                                    */
/*==============================================================*/
create view V_TELEFONOS_CLIENTE as
select
   TELEFONOS_CLIENTE.ID_TELEFONO_CLIENTE,
   TELEFONOS_CLIENTE.NUM_TELEFONO_CLIENTE
from
   TELEFONOS_CLIENTE
go

/*==============================================================*/
/* View: V_TELEFONOS_EMPLEADO                                   */
/*==============================================================*/
create view V_TELEFONOS_EMPLEADO as
select
   TELEFONOS_EMPLEADO.ID_TELEFONO_EMPLEADO,
   TELEFONOS_EMPLEADO.NUMERO_TELEFONO_EMPLEADO
from
   TELEFONOS_EMPLEADO
go

/*==============================================================*/
/* View: V_TELEFONOS_PROVEEDOR                                  */
/*==============================================================*/
create view V_TELEFONOS_PROVEEDOR as
select
   TELEFONOS_PROVEEDOR.ID_TELEFONO_PROVEEDOR,
   TELEFONOS_PROVEEDOR.ID_PROVEEDOR,
   TELEFONOS_PROVEEDOR.NUMERO_TELEFONO_PROVEEDOR
from
   TELEFONOS_PROVEEDOR
go

