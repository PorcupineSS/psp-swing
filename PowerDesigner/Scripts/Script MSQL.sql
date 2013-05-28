/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     27/05/2013 09:42:47 a.m.                     */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ACTUALIZACION') and o.name = 'FK_ACTUALIZ_ACTUALIZA_DIR_GEST')
alter table ACTUALIZACION
   drop constraint FK_ACTUALIZ_ACTUALIZA_DIR_GEST
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ACTUALIZACION') and o.name = 'FK_ACTUALIZ_ACTUALIZA_SUBGEREN')
alter table ACTUALIZACION
   drop constraint FK_ACTUALIZ_ACTUALIZA_SUBGEREN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ACTU_IMPL') and o.name = 'FK_ACTU_IMP_ACTUALIZA_COORD_T_')
alter table ACTU_IMPL
   drop constraint FK_ACTU_IMP_ACTUALIZA_COORD_T_
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ACTU_IMPL') and o.name = 'FK_ACTU_IMP_LO_ACTUAL_IMPL_SEG')
alter table ACTU_IMPL
   drop constraint FK_ACTU_IMP_LO_ACTUAL_IMPL_SEG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASIGNACION_C') and o.name = 'FK_ASIGNACI_REALIZA_A_COORD_CO')
alter table ASIGNACION_C
   drop constraint FK_ASIGNACI_REALIZA_A_COORD_CO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASIGNACION_C') and o.name = 'FK_ASIGNACI_SE_ASIGNA_CONTRATO')
alter table ASIGNACION_C
   drop constraint FK_ASIGNACI_SE_ASIGNA_CONTRATO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASIG_IMPL') and o.name = 'FK_ASIG_IMP_ASIGNA_I_COORD_T_')
alter table ASIG_IMPL
   drop constraint FK_ASIG_IMP_ASIGNA_I_COORD_T_
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASIG_IMPL') and o.name = 'FK_ASIG_IMP_LO_ASIGNA_IMPL_SEG')
alter table ASIG_IMPL
   drop constraint FK_ASIG_IMP_LO_ASIGNA_IMPL_SEG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASIG_IMPL') and o.name = 'FK_ASIG_IMP_RELATIONS_EM_TEMP')
alter table ASIG_IMPL
   drop constraint FK_ASIG_IMP_RELATIONS_EM_TEMP
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('BITACORA_SEG') and o.name = 'FK_BITACORA_SIGUE_EMPLEADO')
alter table BITACORA_SEG
   drop constraint FK_BITACORA_SIGUE_EMPLEADO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CLIENTE') and o.name = 'FK_CLIENTE_REG_CLI_DIR_COME')
alter table CLIENTE
   drop constraint FK_CLIENTE_REG_CLI_DIR_COME
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CL_TIENE_TELS') and o.name = 'FK_CL_TIENE_CL_TIENE__TELS_CLI')
alter table CL_TIENE_TELS
   drop constraint FK_CL_TIENE_CL_TIENE__TELS_CLI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CL_TIENE_TELS') and o.name = 'FK_CL_TIENE_CL_TIENE__CLIENTE')
alter table CL_TIENE_TELS
   drop constraint FK_CL_TIENE_CL_TIENE__CLIENTE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('COMUNICADO') and o.name = 'FK_COMUNICA_REDACTA_EM_TEMP')
alter table COMUNICADO
   drop constraint FK_COMUNICA_REDACTA_EM_TEMP
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('COMUNICADO') and o.name = 'FK_COMUNICA_RESPONDE_DIR_OPER')
alter table COMUNICADO
   drop constraint FK_COMUNICA_RESPONDE_DIR_OPER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CONTRATO') and o.name = 'FK_CONTRATO_REG_CONT_DIR_COME')
alter table CONTRATO
   drop constraint FK_CONTRATO_REG_CONT_DIR_COME
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CONTRATO') and o.name = 'FK_CONTRATO_SOLICITA_CLIENTE')
alter table CONTRATO
   drop constraint FK_CONTRATO_SOLICITA_CLIENTE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('COORD_CONTRATO') and o.name = 'FK_COORD_CO_SON3_EMP_PLAN')
alter table COORD_CONTRATO
   drop constraint FK_COORD_CO_SON3_EMP_PLAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('COORD_T_Y_Y') and o.name = 'FK_COORD_T__SON_EMP_PLAN')
alter table COORD_T_Y_Y
   drop constraint FK_COORD_T__SON_EMP_PLAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('DIR_COMERCIAL') and o.name = 'FK_DIR_COME_SON2_EMP_PLAN')
alter table DIR_COMERCIAL
   drop constraint FK_DIR_COME_SON2_EMP_PLAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('DIR_GESTION_HUM') and o.name = 'FK_DIR_GEST_SON5_EMP_PLAN')
alter table DIR_GESTION_HUM
   drop constraint FK_DIR_GEST_SON5_EMP_PLAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('DIR_OPERACIONES') and o.name = 'FK_DIR_OPER_SON4_EMP_PLAN')
alter table DIR_OPERACIONES
   drop constraint FK_DIR_OPER_SON4_EMP_PLAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('EMPLEADOS') and o.name = 'FK_EMPLEADO_REGISTRA_DIR_GEST')
alter table EMPLEADOS
   drop constraint FK_EMPLEADO_REGISTRA_DIR_GEST
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('EMP_PLANTA') and o.name = 'FK_EMP_PLAN_SON_E_EMPLEADO')
alter table EMP_PLANTA
   drop constraint FK_EMP_PLAN_SON_E_EMPLEADO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('EM_TEMP') and o.name = 'FK_EM_TEMP_ASIGNAN_A_ASIGNACI')
alter table EM_TEMP
   drop constraint FK_EM_TEMP_ASIGNAN_A_ASIGNACI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('EM_TEMP') and o.name = 'FK_EM_TEMP_SON_E2_EMPLEADO')
alter table EM_TEMP
   drop constraint FK_EM_TEMP_SON_E2_EMPLEADO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('EM_TIENE_TELS') and o.name = 'FK_EM_TIENE_EM_TIENE__TELS_EMP')
alter table EM_TIENE_TELS
   drop constraint FK_EM_TIENE_EM_TIENE__TELS_EMP
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('EM_TIENE_TELS') and o.name = 'FK_EM_TIENE_EM_TIENE__EMPLEADO')
alter table EM_TIENE_TELS
   drop constraint FK_EM_TIENE_EM_TIENE__EMPLEADO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('IMPL_SEGURIDAD') and o.name = 'FK_IMPL_SEG_REG_IMPL_COORD_T_')
alter table IMPL_SEGURIDAD
   drop constraint FK_IMPL_SEG_REG_IMPL_COORD_T_
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('IMPL_SEGURIDAD') and o.name = 'FK_IMPL_SEG_SUMINISTR_PROVEEDO')
alter table IMPL_SEGURIDAD
   drop constraint FK_IMPL_SEG_SUMINISTR_PROVEEDO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PROVEEDOR') and o.name = 'FK_PROVEEDO_REG_PROV_COORD_T_')
alter table PROVEEDOR
   drop constraint FK_PROVEEDO_REG_PROV_COORD_T_
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SUBGERENTE') and o.name = 'FK_SUBGEREN_SON6_EMP_PLAN')
alter table SUBGERENTE
   drop constraint FK_SUBGEREN_SON6_EMP_PLAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TELS_PROV') and o.name = 'FK_TELS_PRO_PR_TIENE__PROVEEDO')
alter table TELS_PROV
   drop constraint FK_TELS_PRO_PR_TIENE__PROVEEDO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ACTUALIZACION')
            and   name  = 'ACTUALIZACION_FK'
            and   indid > 0
            and   indid < 255)
   drop index ACTUALIZACION.ACTUALIZACION_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ACTUALIZACION')
            and   name  = 'ACTUALIZACION2_FK'
            and   indid > 0
            and   indid < 255)
   drop index ACTUALIZACION.ACTUALIZACION2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ACTUALIZACION')
            and   type = 'U')
   drop table ACTUALIZACION
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ACTU_IMPL')
            and   name  = 'LO_ACTUALIZAN_FK'
            and   indid > 0
            and   indid < 255)
   drop index ACTU_IMPL.LO_ACTUALIZAN_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ACTU_IMPL')
            and   name  = 'ACTUALIZA_FK'
            and   indid > 0
            and   indid < 255)
   drop index ACTU_IMPL.ACTUALIZA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ACTU_IMPL')
            and   type = 'U')
   drop table ACTU_IMPL
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ASIGNACION_C')
            and   name  = 'REALIZA_ASIGNACION_FK'
            and   indid > 0
            and   indid < 255)
   drop index ASIGNACION_C.REALIZA_ASIGNACION_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ASIGNACION_C')
            and   name  = 'SE_ASIGNA_C_FK'
            and   indid > 0
            and   indid < 255)
   drop index ASIGNACION_C.SE_ASIGNA_C_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASIGNACION_C')
            and   type = 'U')
   drop table ASIGNACION_C
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ASIG_IMPL')
            and   name  = 'LO_ASIGNAN_FK'
            and   indid > 0
            and   indid < 255)
   drop index ASIG_IMPL.LO_ASIGNAN_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ASIG_IMPL')
            and   name  = 'RELATIONSHIP_4_FK'
            and   indid > 0
            and   indid < 255)
   drop index ASIG_IMPL.RELATIONSHIP_4_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ASIG_IMPL')
            and   name  = 'ASIGNA_I_FK'
            and   indid > 0
            and   indid < 255)
   drop index ASIG_IMPL.ASIGNA_I_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASIG_IMPL')
            and   type = 'U')
   drop table ASIG_IMPL
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('BITACORA_SEG')
            and   name  = 'SIGUE_FK'
            and   indid > 0
            and   indid < 255)
   drop index BITACORA_SEG.SIGUE_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('BITACORA_SEG')
            and   type = 'U')
   drop table BITACORA_SEG
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CLIENTE')
            and   name  = 'REG_CLI_FK'
            and   indid > 0
            and   indid < 255)
   drop index CLIENTE.REG_CLI_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CLIENTE')
            and   type = 'U')
   drop table CLIENTE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CL_TIENE_TELS')
            and   name  = 'CL_TIENE_TELS_FK'
            and   indid > 0
            and   indid < 255)
   drop index CL_TIENE_TELS.CL_TIENE_TELS_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CL_TIENE_TELS')
            and   name  = 'CL_TIENE_TELS2_FK'
            and   indid > 0
            and   indid < 255)
   drop index CL_TIENE_TELS.CL_TIENE_TELS2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CL_TIENE_TELS')
            and   type = 'U')
   drop table CL_TIENE_TELS
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
           where  id = object_id('COMUNICADO')
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
            and   name  = 'REG_CONT_FK'
            and   indid > 0
            and   indid < 255)
   drop index CONTRATO.REG_CONT_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CONTRATO')
            and   type = 'U')
   drop table CONTRATO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('COORD_CONTRATO')
            and   type = 'U')
   drop table COORD_CONTRATO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('COORD_T_Y_Y')
            and   type = 'U')
   drop table COORD_T_Y_Y
go

if exists (select 1
            from  sysobjects
           where  id = object_id('DIR_COMERCIAL')
            and   type = 'U')
   drop table DIR_COMERCIAL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('DIR_GESTION_HUM')
            and   type = 'U')
   drop table DIR_GESTION_HUM
go

if exists (select 1
            from  sysobjects
           where  id = object_id('DIR_OPERACIONES')
            and   type = 'U')
   drop table DIR_OPERACIONES
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('EMPLEADOS')
            and   name  = 'REGISTRA_FK'
            and   indid > 0
            and   indid < 255)
   drop index EMPLEADOS.REGISTRA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('EMPLEADOS')
            and   type = 'U')
   drop table EMPLEADOS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('EMP_PLANTA')
            and   type = 'U')
   drop table EMP_PLANTA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('EM_TEMP')
            and   name  = 'ASIGNAN_A_E_FK'
            and   indid > 0
            and   indid < 255)
   drop index EM_TEMP.ASIGNAN_A_E_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('EM_TEMP')
            and   type = 'U')
   drop table EM_TEMP
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('EM_TIENE_TELS')
            and   name  = 'EM_TIENE_TELS_FK'
            and   indid > 0
            and   indid < 255)
   drop index EM_TIENE_TELS.EM_TIENE_TELS_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('EM_TIENE_TELS')
            and   name  = 'EM_TIENE_TELS2_FK'
            and   indid > 0
            and   indid < 255)
   drop index EM_TIENE_TELS.EM_TIENE_TELS2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('EM_TIENE_TELS')
            and   type = 'U')
   drop table EM_TIENE_TELS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('IMPL_SEGURIDAD')
            and   name  = 'SUMINISTRA_FK'
            and   indid > 0
            and   indid < 255)
   drop index IMPL_SEGURIDAD.SUMINISTRA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('IMPL_SEGURIDAD')
            and   name  = 'REG_IMPL_FK'
            and   indid > 0
            and   indid < 255)
   drop index IMPL_SEGURIDAD.REG_IMPL_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('IMPL_SEGURIDAD')
            and   type = 'U')
   drop table IMPL_SEGURIDAD
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PROVEEDOR')
            and   name  = 'REG_PROV_FK'
            and   indid > 0
            and   indid < 255)
   drop index PROVEEDOR.REG_PROV_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PROVEEDOR')
            and   type = 'U')
   drop table PROVEEDOR
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SUBGERENTE')
            and   type = 'U')
   drop table SUBGERENTE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TELS_CLI')
            and   type = 'U')
   drop table TELS_CLI
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TELS_EMP')
            and   type = 'U')
   drop table TELS_EMP
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TELS_PROV')
            and   name  = 'PR_TIENE_TELS_FK'
            and   indid > 0
            and   indid < 255)
   drop index TELS_PROV.PR_TIENE_TELS_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TELS_PROV')
            and   type = 'U')
   drop table TELS_PROV
go

/*==============================================================*/
/* Table: ACTUALIZACION                                         */
/*==============================================================*/
create table ACTUALIZACION (
   SUB_CEDULAE          bigint               not null,
   CEDULAE              bigint               not null,
   FECHA_ACTUAL_DGH     datetime             not null,
   constraint PK_ACTUALIZACION primary key nonclustered (SUB_CEDULAE, CEDULAE)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Asociación que permite que el SUBGERENTE actualice la información de un DIRECTOR DE GESTIÓN HUMANA.',
   'user', @CurrentUser, 'table', 'ACTUALIZACION'
go

/*==============================================================*/
/* Index: ACTUALIZACION2_FK                                     */
/*==============================================================*/
create index ACTUALIZACION2_FK on ACTUALIZACION (
SUB_CEDULAE ASC
)
go

/*==============================================================*/
/* Index: ACTUALIZACION_FK                                      */
/*==============================================================*/
create index ACTUALIZACION_FK on ACTUALIZACION (
CEDULAE ASC
)
go

/*==============================================================*/
/* Table: ACTU_IMPL                                             */
/*==============================================================*/
create table ACTU_IMPL (
   ID_ACTUALIZACION_I   smallint             not null,
   ID_IMPLEMENTO        smallint             null,
   CEDULAE              bigint               null,
   FECHA_ACTUALIZACION_I datetime             not null,
   CANTIDAD_AGREGADA    smallint             null,
   DESCRIPCION_ACTUALIZACION varchar(30)          not null,
   constraint PK_ACTU_IMPL primary key nonclustered (ID_ACTUALIZACION_I)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los datos pertenecientes a la actualizacion de un implemento, por parte de un empleado: COORDINADOR TECNICO Y TECNOLOGICO.',
   'user', @CurrentUser, 'table', 'ACTU_IMPL'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador de la actualización.',
   'user', @CurrentUser, 'table', 'ACTU_IMPL', 'column', 'ID_ACTUALIZACION_I'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del implemento.',
   'user', @CurrentUser, 'table', 'ACTU_IMPL', 'column', 'ID_IMPLEMENTO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Fecha en que se realiza la actualización.',
   'user', @CurrentUser, 'table', 'ACTU_IMPL', 'column', 'FECHA_ACTUALIZACION_I'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Cantidad de implementos agregados al inventario.',
   'user', @CurrentUser, 'table', 'ACTU_IMPL', 'column', 'CANTIDAD_AGREGADA'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Descripción de la actualizacion (Agregar, borrar o actualizar datos).',
   'user', @CurrentUser, 'table', 'ACTU_IMPL', 'column', 'DESCRIPCION_ACTUALIZACION'
go

/*==============================================================*/
/* Index: ACTUALIZA_FK                                          */
/*==============================================================*/
create index ACTUALIZA_FK on ACTU_IMPL (
CEDULAE ASC
)
go

/*==============================================================*/
/* Index: LO_ACTUALIZAN_FK                                      */
/*==============================================================*/
create index LO_ACTUALIZAN_FK on ACTU_IMPL (
ID_IMPLEMENTO ASC
)
go

/*==============================================================*/
/* Table: ASIGNACION_C                                          */
/*==============================================================*/
create table ASIGNACION_C (
   ID_ASIG              smallint             not null,
   ID_CONTRATO          smallint             null,
   CEDULAE              bigint               null,
   COO_CEDULAE          bigint               null,
   FECHA_ASIGNACION_C   datetime             not null,
   HORARIO_ASIGNADO     varchar(20)          not null,
   constraint PK_ASIGNACION_C primary key nonclustered (ID_ASIG)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Asignacion de un CONTRATO por parte de un empleado: COORDINADOR DE CONTRATO a un EMPLEADO TEMPORAL.',
   'user', @CurrentUser, 'table', 'ASIGNACION_C'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador de la asignación.',
   'user', @CurrentUser, 'table', 'ASIGNACION_C', 'column', 'ID_ASIG'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del contrato.',
   'user', @CurrentUser, 'table', 'ASIGNACION_C', 'column', 'ID_CONTRATO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Fecha de la asignación del contrato.',
   'user', @CurrentUser, 'table', 'ASIGNACION_C', 'column', 'FECHA_ASIGNACION_C'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Horario asignado en el contrato.',
   'user', @CurrentUser, 'table', 'ASIGNACION_C', 'column', 'HORARIO_ASIGNADO'
go

/*==============================================================*/
/* Index: SE_ASIGNA_C_FK                                        */
/*==============================================================*/
create index SE_ASIGNA_C_FK on ASIGNACION_C (
ID_CONTRATO ASC
)
go

/*==============================================================*/
/* Index: REALIZA_ASIGNACION_FK                                 */
/*==============================================================*/
create index REALIZA_ASIGNACION_FK on ASIGNACION_C (
COO_CEDULAE ASC
)
go

/*==============================================================*/
/* Table: ASIG_IMPL                                             */
/*==============================================================*/
create table ASIG_IMPL (
   ID_ASIGNACION_I      smallint             not null,
   ID_IMPLEMENTO        smallint             null,
   CEDULAE              bigint               null,
   COO_CEDULAE          bigint               null,
   CANTIDAD_ASIGNADA    smallint             not null,
   ESTADO_ASIGNACION    bit                  not null,
   FECHA_ASIGNACION_I   datetime             not null,
   constraint PK_ASIG_IMPL primary key nonclustered (ID_ASIGNACION_I)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los datos de una asignacion de un implemento por parte de un empleado: COORDINADOR TECNICO Y TECNOLOGICO a un EMPLEADO TEMPORAL.',
   'user', @CurrentUser, 'table', 'ASIG_IMPL'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador de la asignación.',
   'user', @CurrentUser, 'table', 'ASIG_IMPL', 'column', 'ID_ASIGNACION_I'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del implemento.',
   'user', @CurrentUser, 'table', 'ASIG_IMPL', 'column', 'ID_IMPLEMENTO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Cantidad de implementos asignados.',
   'user', @CurrentUser, 'table', 'ASIG_IMPL', 'column', 'CANTIDAD_ASIGNADA'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Estado de la asignacion del implemento (activa o desactiva).',
   'user', @CurrentUser, 'table', 'ASIG_IMPL', 'column', 'ESTADO_ASIGNACION'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Fecha en que se realiza la asignación del implemento.',
   'user', @CurrentUser, 'table', 'ASIG_IMPL', 'column', 'FECHA_ASIGNACION_I'
go

/*==============================================================*/
/* Index: ASIGNA_I_FK                                           */
/*==============================================================*/
create index ASIGNA_I_FK on ASIG_IMPL (
COO_CEDULAE ASC
)
go

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_4_FK on ASIG_IMPL (
CEDULAE ASC
)
go

/*==============================================================*/
/* Index: LO_ASIGNAN_FK                                         */
/*==============================================================*/
create index LO_ASIGNAN_FK on ASIG_IMPL (
ID_IMPLEMENTO ASC
)
go

/*==============================================================*/
/* Table: BITACORA_SEG                                          */
/*==============================================================*/
create table BITACORA_SEG (
   ID_OPER              int                  not null,
   CEDULAE              bigint               null,
   FECHA_OPER           datetime             not null,
   USU_OPER             varchar(20)          null,
   MAQ_OPER             varchar(20)          null,
   TABLA_MOD            varchar(20)          not null,
   TIPO_OPER            varchar(6)           not null,
   constraint PK_BITACORA_SEG primary key nonclustered (ID_OPER)
)
go

/*==============================================================*/
/* Index: SIGUE_FK                                              */
/*==============================================================*/
create index SIGUE_FK on BITACORA_SEG (
CEDULAE ASC
)
go

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   IDCL                 smallint             not null,
   CEDULAE              bigint               not null,
   NOMBRECL             varchar(20)          not null,
   DIRECCIONCL          varchar(20)          not null,
   FECHA_REG_CL         datetime             not null,
   constraint PK_CLIENTE primary key nonclustered (IDCL)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee todos los atributos que se requieren acerca de un cliente de la empresa.',
   'user', @CurrentUser, 'table', 'CLIENTE'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del cliente.',
   'user', @CurrentUser, 'table', 'CLIENTE', 'column', 'IDCL'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Nombre del cliente.',
   'user', @CurrentUser, 'table', 'CLIENTE', 'column', 'NOMBRECL'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Dirección del cliente.',
   'user', @CurrentUser, 'table', 'CLIENTE', 'column', 'DIRECCIONCL'
go

/*==============================================================*/
/* Index: REG_CLI_FK                                            */
/*==============================================================*/
create index REG_CLI_FK on CLIENTE (
CEDULAE ASC
)
go

/*==============================================================*/
/* Table: CL_TIENE_TELS                                         */
/*==============================================================*/
create table CL_TIENE_TELS (
   ID_TC                smallint             not null,
   IDCL                 smallint             not null,
   constraint PK_CL_TIENE_TELS primary key nonclustered (ID_TC, IDCL)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Relación que indica que un CLIENTE puede tener varios TELÉFONOS CL.',
   'user', @CurrentUser, 'table', 'CL_TIENE_TELS'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del teléfono.',
   'user', @CurrentUser, 'table', 'CL_TIENE_TELS', 'column', 'ID_TC'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del cliente.',
   'user', @CurrentUser, 'table', 'CL_TIENE_TELS', 'column', 'IDCL'
go

/*==============================================================*/
/* Index: CL_TIENE_TELS2_FK                                     */
/*==============================================================*/
create index CL_TIENE_TELS2_FK on CL_TIENE_TELS (
IDCL ASC
)
go

/*==============================================================*/
/* Index: CL_TIENE_TELS_FK                                      */
/*==============================================================*/
create index CL_TIENE_TELS_FK on CL_TIENE_TELS (
ID_TC ASC
)
go

/*==============================================================*/
/* Table: COMUNICADO                                            */
/*==============================================================*/
create table COMUNICADO (
   ID_COMUNICADO        smallint             not null,
   CEDULAE              bigint               null,
   DIR_CEDULAE          bigint               null,
   TIPO_CO              varchar(20)          not null,
   FECHA_CO             datetime             not null,
   CONTENIDO_CO         varchar(100)         not null,
   URGENTE              bit                  not null,
   RESPUESTA_CO         varchar(100)         null,
   constraint PK_COMUNICADO primary key nonclustered (ID_COMUNICADO)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los atributos de un comunicado realizado por parte de un EMPLEADO TEMPORAL.',
   'user', @CurrentUser, 'table', 'COMUNICADO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del comunicado.',
   'user', @CurrentUser, 'table', 'COMUNICADO', 'column', 'ID_COMUNICADO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Tipo de comunicado (Reclamo, Queja o Sugerencia).',
   'user', @CurrentUser, 'table', 'COMUNICADO', 'column', 'TIPO_CO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Fecha en que se realiza el comunicado.',
   'user', @CurrentUser, 'table', 'COMUNICADO', 'column', 'FECHA_CO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Contenido del comunicado.',
   'user', @CurrentUser, 'table', 'COMUNICADO', 'column', 'CONTENIDO_CO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Es urgente o no el comunicado.',
   'user', @CurrentUser, 'table', 'COMUNICADO', 'column', 'URGENTE'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Respuesta al comunicado.',
   'user', @CurrentUser, 'table', 'COMUNICADO', 'column', 'RESPUESTA_CO'
go

/*==============================================================*/
/* Index: REDACTA_FK                                            */
/*==============================================================*/
create index REDACTA_FK on COMUNICADO (
CEDULAE ASC
)
go

/*==============================================================*/
/* Index: RESPONDE_FK                                           */
/*==============================================================*/
create index RESPONDE_FK on COMUNICADO (
DIR_CEDULAE ASC
)
go

/*==============================================================*/
/* Table: CONTRATO                                              */
/*==============================================================*/
create table CONTRATO (
   ID_CONTRATO          smallint             not null,
   IDCL                 smallint             not null,
   CEDULAE              bigint               not null,
   UBICACION_C          varchar(20)          not null,
   TELEFONO_C           int                  not null,
   CELULAR_C            int                  not null,
   TIPO_C               varchar(50)          not null
      constraint CKC_TIPO_C_CONTRATO check (TIPO_C in ('<Val0>','<Val1>')),
   FECHA_INICIO_C       datetime             not null,
   TIPO_PERSONAL_C      varchar(20)          not null,
   CANTIDAD_PERSONAL_C  smallint             not null,
   COSTO_MENSUAL_C      money                not null,
   HORARIO_C            varchar(20)          not null,
   TIEMPO_C             int                  null,
   FECHA_REG_CON        datetime             not null,
   constraint PK_CONTRATO primary key nonclustered (ID_CONTRATO),
   constraint AK_ID_UBI_CONTRATO_CONTRATO unique (UBICACION_C)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los atributos requeridos en el registro de un contrato.',
   'user', @CurrentUser, 'table', 'CONTRATO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del contrato.',
   'user', @CurrentUser, 'table', 'CONTRATO', 'column', 'ID_CONTRATO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del cliente.',
   'user', @CurrentUser, 'table', 'CONTRATO', 'column', 'IDCL'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Ubicacion donde se cumplira el contrato.',
   'user', @CurrentUser, 'table', 'CONTRATO', 'column', 'UBICACION_C'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Telefono del lugar donde se cumplira el contrato.',
   'user', @CurrentUser, 'table', 'CONTRATO', 'column', 'TELEFONO_C'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Celular del lugar donde se cumplira el contrato.',
   'user', @CurrentUser, 'table', 'CONTRATO', 'column', 'CELULAR_C'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Tipo de contrato (Definido o Indefinido).',
   'user', @CurrentUser, 'table', 'CONTRATO', 'column', 'TIPO_C'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Fecha de inicio del contrato.',
   'user', @CurrentUser, 'table', 'CONTRATO', 'column', 'FECHA_INICIO_C'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Tipo de personal solicitado en el contrato (Vigilantes y/o Escoltas).',
   'user', @CurrentUser, 'table', 'CONTRATO', 'column', 'TIPO_PERSONAL_C'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Cantidad de personal solicitado en el contrato.',
   'user', @CurrentUser, 'table', 'CONTRATO', 'column', 'CANTIDAD_PERSONAL_C'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Costo mensual total del contrato.',
   'user', @CurrentUser, 'table', 'CONTRATO', 'column', 'COSTO_MENSUAL_C'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Horarios de personal solicitados en el contrato.',
   'user', @CurrentUser, 'table', 'CONTRATO', 'column', 'HORARIO_C'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Si en contrato es de tipo definido este campo tendra el tiempo total del contrato, si no lo es podra ser null.',
   'user', @CurrentUser, 'table', 'CONTRATO', 'column', 'TIEMPO_C'
go

/*==============================================================*/
/* Index: REG_CONT_FK                                           */
/*==============================================================*/
create index REG_CONT_FK on CONTRATO (
CEDULAE ASC
)
go

/*==============================================================*/
/* Index: SOLICITA_FK                                           */
/*==============================================================*/
create index SOLICITA_FK on CONTRATO (
IDCL ASC
)
go

/*==============================================================*/
/* Table: COORD_CONTRATO                                        */
/*==============================================================*/
create table COORD_CONTRATO (
   CEDULAE              bigint               not null,
   constraint PK_COORD_CONTRATO primary key nonclustered (CEDULAE)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: COORDINADOR DE CONTRATO con los procesos de la empresa.',
   'user', @CurrentUser, 'table', 'COORD_CONTRATO'
go

/*==============================================================*/
/* Table: COORD_T_Y_Y                                           */
/*==============================================================*/
create table COORD_T_Y_Y (
   CEDULAE              bigint               not null,
   constraint PK_COORD_T_Y_Y primary key nonclustered (CEDULAE)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: COORDINADOR TÉCNICO Y TECNOLÓGICO con los procesos de la empresa.',
   'user', @CurrentUser, 'table', 'COORD_T_Y_Y'
go

/*==============================================================*/
/* Table: DIR_COMERCIAL                                         */
/*==============================================================*/
create table DIR_COMERCIAL (
   CEDULAE              bigint               not null,
   constraint PK_DIR_COMERCIAL primary key nonclustered (CEDULAE)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: DIRECTOR COMERCIAL con los procesos de la empresa.',
   'user', @CurrentUser, 'table', 'DIR_COMERCIAL'
go

/*==============================================================*/
/* Table: DIR_GESTION_HUM                                       */
/*==============================================================*/
create table DIR_GESTION_HUM (
   CEDULAE              bigint               not null,
   constraint PK_DIR_GESTION_HUM primary key nonclustered (CEDULAE)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: DIRECTOR DE GESTION HUMANA con los procesos de la empresa.',
   'user', @CurrentUser, 'table', 'DIR_GESTION_HUM'
go

/*==============================================================*/
/* Table: DIR_OPERACIONES                                       */
/*==============================================================*/
create table DIR_OPERACIONES (
   CEDULAE              bigint               not null,
   constraint PK_DIR_OPERACIONES primary key nonclustered (CEDULAE)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los atributos de un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: DIRECTOR DE OPERACIONES con los procesos de la empresa.',
   'user', @CurrentUser, 'table', 'DIR_OPERACIONES'
go

/*==============================================================*/
/* Table: EMPLEADOS                                             */
/*==============================================================*/
create table EMPLEADOS (
   CEDULAE              bigint               not null,
   DIR_CEDULAE          bigint               null,
   NOMBREE              varchar(20)          not null,
   APELLIDOE            varchar(20)          not null,
   CONTRASENAE          char(10)             not null,
   CODDOCUME            varchar(20)          not null,
   FECHAREG             datetime             not null,
   constraint PK_EMPLEADOS primary key nonclustered (CEDULAE),
   constraint AK_ID_COD_EMP_EMPLEADO unique (CODDOCUME)
)
go

/*==============================================================*/
/* Index: REGISTRA_FK                                           */
/*==============================================================*/
create index REGISTRA_FK on EMPLEADOS (
DIR_CEDULAE ASC
)
go

/*==============================================================*/
/* Table: EMP_PLANTA                                            */
/*==============================================================*/
create table EMP_PLANTA (
   CEDULAE              bigint               not null,
   SUELDOE              money                not null,
   constraint PK_EMP_PLANTA primary key nonclustered (CEDULAE)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los atributos de un empleado normal de la empresa, pero a la vez se le asignan los atributos propios de un empleado de planta.',
   'user', @CurrentUser, 'table', 'EMP_PLANTA'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Sueldo del empleado de planta.',
   'user', @CurrentUser, 'table', 'EMP_PLANTA', 'column', 'SUELDOE'
go

/*==============================================================*/
/* Table: EM_TEMP                                               */
/*==============================================================*/
create table EM_TEMP (
   CEDULAE              bigint               not null,
   ID_ASIG              smallint             null,
   TIENE_CONTRATO       bit                  not null,
   TIPO_TEMP            varchar(20)          not null,
   constraint PK_EM_TEMP primary key nonclustered (CEDULAE)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los atributos de un empleado normal de la empresa, pero a la vez se le asignan los atributos propios de un empleado temporal.',
   'user', @CurrentUser, 'table', 'EM_TEMP'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador de la asignación.',
   'user', @CurrentUser, 'table', 'EM_TEMP', 'column', 'ID_ASIG'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'El empleado temporal tiene o no contrato asignado.',
   'user', @CurrentUser, 'table', 'EM_TEMP', 'column', 'TIENE_CONTRATO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Tipo de empleado temporal (Vigilante o Escolta).',
   'user', @CurrentUser, 'table', 'EM_TEMP', 'column', 'TIPO_TEMP'
go

/*==============================================================*/
/* Index: ASIGNAN_A_E_FK                                        */
/*==============================================================*/
create index ASIGNAN_A_E_FK on EM_TEMP (
ID_ASIG ASC
)
go

/*==============================================================*/
/* Table: EM_TIENE_TELS                                         */
/*==============================================================*/
create table EM_TIENE_TELS (
   ID_TE                smallint             not null,
   CEDULAE              bigint               not null,
   constraint PK_EM_TIENE_TELS primary key nonclustered (ID_TE, CEDULAE)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Esta relación permite que un empleado de la empresa pueda poseer mas de un numero telefonico registrado en la empresa.',
   'user', @CurrentUser, 'table', 'EM_TIENE_TELS'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del teléfono.',
   'user', @CurrentUser, 'table', 'EM_TIENE_TELS', 'column', 'ID_TE'
go

/*==============================================================*/
/* Index: EM_TIENE_TELS2_FK                                     */
/*==============================================================*/
create index EM_TIENE_TELS2_FK on EM_TIENE_TELS (
CEDULAE ASC
)
go

/*==============================================================*/
/* Index: EM_TIENE_TELS_FK                                      */
/*==============================================================*/
create index EM_TIENE_TELS_FK on EM_TIENE_TELS (
ID_TE ASC
)
go

/*==============================================================*/
/* Table: IMPL_SEGURIDAD                                        */
/*==============================================================*/
create table IMPL_SEGURIDAD (
   ID_IMPLEMENTO        smallint             not null,
   ID_PRO               smallint             null,
   CEDULAE              bigint               not null,
   NOMBRE_I             varchar(20)          not null,
   PRECIO_UNITARIO_I    money                not null,
   CANTIDAD             smallint             not null,
   DESCRIPCION_I        varchar(100)         not null,
   ESTADO_I             varchar(20)          not null,
   FECHA_REG_IM         datetime             not null,
   constraint PK_IMPL_SEGURIDAD primary key nonclustered (ID_IMPLEMENTO),
   constraint AK_ID_NOM_IMPLEMENT_IMPL_SEG unique (NOMBRE_I)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los atributos que requiere el registro de un IMPLEMENTO DE SEGURIDAD por parte de un empleado: COORDINADOR TECNICO Y TECNOLOGICO.',
   'user', @CurrentUser, 'table', 'IMPL_SEGURIDAD'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del implemento.',
   'user', @CurrentUser, 'table', 'IMPL_SEGURIDAD', 'column', 'ID_IMPLEMENTO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del proveedor.',
   'user', @CurrentUser, 'table', 'IMPL_SEGURIDAD', 'column', 'ID_PRO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Nombre del implemento.',
   'user', @CurrentUser, 'table', 'IMPL_SEGURIDAD', 'column', 'NOMBRE_I'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Precio unitario del implemento de seguridad.',
   'user', @CurrentUser, 'table', 'IMPL_SEGURIDAD', 'column', 'PRECIO_UNITARIO_I'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Catidad actual total del implemento.',
   'user', @CurrentUser, 'table', 'IMPL_SEGURIDAD', 'column', 'CANTIDAD'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Descripcion general del implemento.',
   'user', @CurrentUser, 'table', 'IMPL_SEGURIDAD', 'column', 'DESCRIPCION_I'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Estado actual del implemento (Optimo o en mantenimiento).',
   'user', @CurrentUser, 'table', 'IMPL_SEGURIDAD', 'column', 'ESTADO_I'
go

/*==============================================================*/
/* Index: REG_IMPL_FK                                           */
/*==============================================================*/
create index REG_IMPL_FK on IMPL_SEGURIDAD (
CEDULAE ASC
)
go

/*==============================================================*/
/* Index: SUMINISTRA_FK                                         */
/*==============================================================*/
create index SUMINISTRA_FK on IMPL_SEGURIDAD (
ID_PRO ASC
)
go

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR (
   ID_PRO               smallint             not null,
   CEDULAE              bigint               not null,
   NOMBRE               varchar(20)          not null,
   DIRECCION            varchar(20)          not null,
   FECHA_REG_PROV       datetime             not null,
   constraint PK_PROVEEDOR primary key nonclustered (ID_PRO),
   constraint AK_ID_NOM_PROV_PROVEEDO unique (NOMBRE)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los atributos que se requieren en el registro de un PROVEEDOR por parte de un empleado: COORDINADOR TECNICO Y TECNOLOGICO.',
   'user', @CurrentUser, 'table', 'PROVEEDOR'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del proveedor.',
   'user', @CurrentUser, 'table', 'PROVEEDOR', 'column', 'ID_PRO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Nombre del proveedor.',
   'user', @CurrentUser, 'table', 'PROVEEDOR', 'column', 'NOMBRE'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Dirección del proveedor.',
   'user', @CurrentUser, 'table', 'PROVEEDOR', 'column', 'DIRECCION'
go

/*==============================================================*/
/* Index: REG_PROV_FK                                           */
/*==============================================================*/
create index REG_PROV_FK on PROVEEDOR (
CEDULAE ASC
)
go

/*==============================================================*/
/* Table: SUBGERENTE                                            */
/*==============================================================*/
create table SUBGERENTE (
   CEDULAE              bigint               not null,
   constraint PK_SUBGERENTE primary key nonclustered (CEDULAE)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Posee los atributos de un un empleado normal, de un empleado planta y da claridad en las relaciones que tiene el empleado: SUBGERENTE con los procesos de la empresa.',
   'user', @CurrentUser, 'table', 'SUBGERENTE'
go

/*==============================================================*/
/* Table: TELS_CLI                                              */
/*==============================================================*/
create table TELS_CLI (
   ID_TC                smallint             not null,
   NUM_TELEFONO_C       int                  not null,
   constraint PK_TELS_CLI primary key nonclustered (ID_TC)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Contiene el directorio telefonico de todos los clientes de la empresa.',
   'user', @CurrentUser, 'table', 'TELS_CLI'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del teléfono.',
   'user', @CurrentUser, 'table', 'TELS_CLI', 'column', 'ID_TC'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Numero telefonico del cliente.',
   'user', @CurrentUser, 'table', 'TELS_CLI', 'column', 'NUM_TELEFONO_C'
go

/*==============================================================*/
/* Table: TELS_EMP                                              */
/*==============================================================*/
create table TELS_EMP (
   ID_TE                smallint             not null,
   NUM_TELEFONO_E       int                  not null,
   constraint PK_TELS_EMP primary key nonclustered (ID_TE)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Contiene el directorio telefonico de todos los empleados de la empresa.',
   'user', @CurrentUser, 'table', 'TELS_EMP'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del teléfono.',
   'user', @CurrentUser, 'table', 'TELS_EMP', 'column', 'ID_TE'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Numero telefonico del empleado.',
   'user', @CurrentUser, 'table', 'TELS_EMP', 'column', 'NUM_TELEFONO_E'
go

/*==============================================================*/
/* Table: TELS_PROV                                             */
/*==============================================================*/
create table TELS_PROV (
   ID_TP                smallint             not null,
   ID_PRO               smallint             null,
   NUM_TELEFONO_P       int                  not null,
   constraint PK_TELS_PROV primary key nonclustered (ID_TP)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sys.sp_addextendedproperty 'MS_Description', 
   'Contiene el directorio telefonico de todos los proveedores de la empresa.',
   'user', @CurrentUser, 'table', 'TELS_PROV'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del teléfono.',
   'user', @CurrentUser, 'table', 'TELS_PROV', 'column', 'ID_TP'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del proveedor.',
   'user', @CurrentUser, 'table', 'TELS_PROV', 'column', 'ID_PRO'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Numero telefonico del proveedor.',
   'user', @CurrentUser, 'table', 'TELS_PROV', 'column', 'NUM_TELEFONO_P'
go

/*==============================================================*/
/* Index: PR_TIENE_TELS_FK                                      */
/*==============================================================*/
create index PR_TIENE_TELS_FK on TELS_PROV (
ID_PRO ASC
)
go

alter table ACTUALIZACION
   add constraint FK_ACTUALIZ_ACTUALIZA_DIR_GEST foreign key (CEDULAE)
      references DIR_GESTION_HUM (CEDULAE)
go

alter table ACTUALIZACION
   add constraint FK_ACTUALIZ_ACTUALIZA_SUBGEREN foreign key (SUB_CEDULAE)
      references SUBGERENTE (CEDULAE)
go

alter table ACTU_IMPL
   add constraint FK_ACTU_IMP_ACTUALIZA_COORD_T_ foreign key (CEDULAE)
      references COORD_T_Y_Y (CEDULAE)
go

alter table ACTU_IMPL
   add constraint FK_ACTU_IMP_LO_ACTUAL_IMPL_SEG foreign key (ID_IMPLEMENTO)
      references IMPL_SEGURIDAD (ID_IMPLEMENTO)
go

alter table ASIGNACION_C
   add constraint FK_ASIGNACI_REALIZA_A_COORD_CO foreign key (COO_CEDULAE)
      references COORD_CONTRATO (CEDULAE)
go

alter table ASIGNACION_C
   add constraint FK_ASIGNACI_SE_ASIGNA_CONTRATO foreign key (ID_CONTRATO)
      references CONTRATO (ID_CONTRATO)
go

alter table ASIG_IMPL
   add constraint FK_ASIG_IMP_ASIGNA_I_COORD_T_ foreign key (COO_CEDULAE)
      references COORD_T_Y_Y (CEDULAE)
go

alter table ASIG_IMPL
   add constraint FK_ASIG_IMP_LO_ASIGNA_IMPL_SEG foreign key (ID_IMPLEMENTO)
      references IMPL_SEGURIDAD (ID_IMPLEMENTO)
go

alter table ASIG_IMPL
   add constraint FK_ASIG_IMP_RELATIONS_EM_TEMP foreign key (CEDULAE)
      references EM_TEMP (CEDULAE)
go

alter table BITACORA_SEG
   add constraint FK_BITACORA_SIGUE_EMPLEADO foreign key (CEDULAE)
      references EMPLEADOS (CEDULAE)
go

alter table CLIENTE
   add constraint FK_CLIENTE_REG_CLI_DIR_COME foreign key (CEDULAE)
      references DIR_COMERCIAL (CEDULAE)
go

alter table CL_TIENE_TELS
   add constraint FK_CL_TIENE_CL_TIENE__TELS_CLI foreign key (ID_TC)
      references TELS_CLI (ID_TC)
go

alter table CL_TIENE_TELS
   add constraint FK_CL_TIENE_CL_TIENE__CLIENTE foreign key (IDCL)
      references CLIENTE (IDCL)
go

alter table COMUNICADO
   add constraint FK_COMUNICA_REDACTA_EM_TEMP foreign key (CEDULAE)
      references EM_TEMP (CEDULAE)
go

alter table COMUNICADO
   add constraint FK_COMUNICA_RESPONDE_DIR_OPER foreign key (DIR_CEDULAE)
      references DIR_OPERACIONES (CEDULAE)
go

alter table CONTRATO
   add constraint FK_CONTRATO_REG_CONT_DIR_COME foreign key (CEDULAE)
      references DIR_COMERCIAL (CEDULAE)
go

alter table CONTRATO
   add constraint FK_CONTRATO_SOLICITA_CLIENTE foreign key (IDCL)
      references CLIENTE (IDCL)
go

alter table COORD_CONTRATO
   add constraint FK_COORD_CO_SON3_EMP_PLAN foreign key (CEDULAE)
      references EMP_PLANTA (CEDULAE)
go

alter table COORD_T_Y_Y
   add constraint FK_COORD_T__SON_EMP_PLAN foreign key (CEDULAE)
      references EMP_PLANTA (CEDULAE)
go

alter table DIR_COMERCIAL
   add constraint FK_DIR_COME_SON2_EMP_PLAN foreign key (CEDULAE)
      references EMP_PLANTA (CEDULAE)
go

alter table DIR_GESTION_HUM
   add constraint FK_DIR_GEST_SON5_EMP_PLAN foreign key (CEDULAE)
      references EMP_PLANTA (CEDULAE)
go

alter table DIR_OPERACIONES
   add constraint FK_DIR_OPER_SON4_EMP_PLAN foreign key (CEDULAE)
      references EMP_PLANTA (CEDULAE)
go

alter table EMPLEADOS
   add constraint FK_EMPLEADO_REGISTRA_DIR_GEST foreign key (DIR_CEDULAE)
      references DIR_GESTION_HUM (CEDULAE)
go

alter table EMP_PLANTA
   add constraint FK_EMP_PLAN_SON_E_EMPLEADO foreign key (CEDULAE)
      references EMPLEADOS (CEDULAE)
go

alter table EM_TEMP
   add constraint FK_EM_TEMP_ASIGNAN_A_ASIGNACI foreign key (ID_ASIG)
      references ASIGNACION_C (ID_ASIG)
go

alter table EM_TEMP
   add constraint FK_EM_TEMP_SON_E2_EMPLEADO foreign key (CEDULAE)
      references EMPLEADOS (CEDULAE)
go

alter table EM_TIENE_TELS
   add constraint FK_EM_TIENE_EM_TIENE__TELS_EMP foreign key (ID_TE)
      references TELS_EMP (ID_TE)
go

alter table EM_TIENE_TELS
   add constraint FK_EM_TIENE_EM_TIENE__EMPLEADO foreign key (CEDULAE)
      references EMPLEADOS (CEDULAE)
go

alter table IMPL_SEGURIDAD
   add constraint FK_IMPL_SEG_REG_IMPL_COORD_T_ foreign key (CEDULAE)
      references COORD_T_Y_Y (CEDULAE)
go

alter table IMPL_SEGURIDAD
   add constraint FK_IMPL_SEG_SUMINISTR_PROVEEDO foreign key (ID_PRO)
      references PROVEEDOR (ID_PRO)
go

alter table PROVEEDOR
   add constraint FK_PROVEEDO_REG_PROV_COORD_T_ foreign key (CEDULAE)
      references COORD_T_Y_Y (CEDULAE)
go

alter table SUBGERENTE
   add constraint FK_SUBGEREN_SON6_EMP_PLAN foreign key (CEDULAE)
      references EMP_PLANTA (CEDULAE)
go

alter table TELS_PROV
   add constraint FK_TELS_PRO_PR_TIENE__PROVEEDO foreign key (ID_PRO)
      references PROVEEDOR (ID_PRO)
go

