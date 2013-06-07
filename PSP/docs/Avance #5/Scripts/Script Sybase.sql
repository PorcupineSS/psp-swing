/*==============================================================*/
/* DBMS name:      Sybase AS Enterprise 15.0                    */
/* Created on:     27/05/2013 09:40:56 a.m.                     */
/*==============================================================*/


if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('ACTUALIZACION'))
            where name = 'FK_ACTUALIZ_ACTUALIZA_DIR_GEST' and type = 'RI')
   alter table ACTUALIZACION
      drop constraint FK_ACTUALIZ_ACTUALIZA_DIR_GEST
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('ACTUALIZACION'))
            where name = 'FK_ACTUALIZ_ACTUALIZA_SUBGEREN' and type = 'RI')
   alter table ACTUALIZACION
      drop constraint FK_ACTUALIZ_ACTUALIZA_SUBGEREN
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('ACTU_IMPL'))
            where name = 'FK_ACTU_IMP_ACTUALIZA_COORD_T_' and type = 'RI')
   alter table ACTU_IMPL
      drop constraint FK_ACTU_IMP_ACTUALIZA_COORD_T_
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('ACTU_IMPL'))
            where name = 'FK_ACTU_IMP_LO_ACTUAL_IMPL_SEG' and type = 'RI')
   alter table ACTU_IMPL
      drop constraint FK_ACTU_IMP_LO_ACTUAL_IMPL_SEG
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('ASIGNACION_C'))
            where name = 'FK_ASIGNACI_REALIZA_A_COORD_CO' and type = 'RI')
   alter table ASIGNACION_C
      drop constraint FK_ASIGNACI_REALIZA_A_COORD_CO
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('ASIGNACION_C'))
            where name = 'FK_ASIGNACI_SE_ASIGNA_CONTRATO' and type = 'RI')
   alter table ASIGNACION_C
      drop constraint FK_ASIGNACI_SE_ASIGNA_CONTRATO
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('ASIG_IMPL'))
            where name = 'FK_ASIG_IMP_ASIGNA_I_COORD_T_' and type = 'RI')
   alter table ASIG_IMPL
      drop constraint FK_ASIG_IMP_ASIGNA_I_COORD_T_
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('ASIG_IMPL'))
            where name = 'FK_ASIG_IMP_LO_ASIGNA_IMPL_SEG' and type = 'RI')
   alter table ASIG_IMPL
      drop constraint FK_ASIG_IMP_LO_ASIGNA_IMPL_SEG
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('ASIG_IMPL'))
            where name = 'FK_ASIG_IMP_RELATIONS_EM_TEMP' and type = 'RI')
   alter table ASIG_IMPL
      drop constraint FK_ASIG_IMP_RELATIONS_EM_TEMP
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('BITACORA_SEG'))
            where name = 'FK_BITACORA_SIGUE_EMPLEADO' and type = 'RI')
   alter table BITACORA_SEG
      drop constraint FK_BITACORA_SIGUE_EMPLEADO
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('CLIENTE'))
            where name = 'FK_CLIENTE_REG_CLI_DIR_COME' and type = 'RI')
   alter table CLIENTE
      drop constraint FK_CLIENTE_REG_CLI_DIR_COME
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('CL_TIENE_TELS'))
            where name = 'FK_CL_TIENE_CL_TIENE__TELS_CLI' and type = 'RI')
   alter table CL_TIENE_TELS
      drop constraint FK_CL_TIENE_CL_TIENE__TELS_CLI
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('CL_TIENE_TELS'))
            where name = 'FK_CL_TIENE_CL_TIENE__CLIENTE' and type = 'RI')
   alter table CL_TIENE_TELS
      drop constraint FK_CL_TIENE_CL_TIENE__CLIENTE
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('COMUNICADO'))
            where name = 'FK_COMUNICA_REDACTA_EM_TEMP' and type = 'RI')
   alter table COMUNICADO
      drop constraint FK_COMUNICA_REDACTA_EM_TEMP
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('COMUNICADO'))
            where name = 'FK_COMUNICA_RESPONDE_DIR_OPER' and type = 'RI')
   alter table COMUNICADO
      drop constraint FK_COMUNICA_RESPONDE_DIR_OPER
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('CONTRATO'))
            where name = 'FK_CONTRATO_REG_CONT_DIR_COME' and type = 'RI')
   alter table CONTRATO
      drop constraint FK_CONTRATO_REG_CONT_DIR_COME
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('CONTRATO'))
            where name = 'FK_CONTRATO_SOLICITA_CLIENTE' and type = 'RI')
   alter table CONTRATO
      drop constraint FK_CONTRATO_SOLICITA_CLIENTE
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('COORD_CONTRATO'))
            where name = 'FK_COORD_CO_SON3_EMP_PLAN' and type = 'RI')
   alter table COORD_CONTRATO
      drop constraint FK_COORD_CO_SON3_EMP_PLAN
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('COORD_T_Y_Y'))
            where name = 'FK_COORD_T__SON_EMP_PLAN' and type = 'RI')
   alter table COORD_T_Y_Y
      drop constraint FK_COORD_T__SON_EMP_PLAN
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('DIR_COMERCIAL'))
            where name = 'FK_DIR_COME_SON2_EMP_PLAN' and type = 'RI')
   alter table DIR_COMERCIAL
      drop constraint FK_DIR_COME_SON2_EMP_PLAN
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('DIR_GESTION_HUM'))
            where name = 'FK_DIR_GEST_SON5_EMP_PLAN' and type = 'RI')
   alter table DIR_GESTION_HUM
      drop constraint FK_DIR_GEST_SON5_EMP_PLAN
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('DIR_OPERACIONES'))
            where name = 'FK_DIR_OPER_SON4_EMP_PLAN' and type = 'RI')
   alter table DIR_OPERACIONES
      drop constraint FK_DIR_OPER_SON4_EMP_PLAN
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('EMPLEADOS'))
            where name = 'FK_EMPLEADO_REGISTRA_DIR_GEST' and type = 'RI')
   alter table EMPLEADOS
      drop constraint FK_EMPLEADO_REGISTRA_DIR_GEST
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('EMP_PLANTA'))
            where name = 'FK_EMP_PLAN_SON_E_EMPLEADO' and type = 'RI')
   alter table EMP_PLANTA
      drop constraint FK_EMP_PLAN_SON_E_EMPLEADO
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('EM_TEMP'))
            where name = 'FK_EM_TEMP_ASIGNAN_A_ASIGNACI' and type = 'RI')
   alter table EM_TEMP
      drop constraint FK_EM_TEMP_ASIGNAN_A_ASIGNACI
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('EM_TEMP'))
            where name = 'FK_EM_TEMP_SON_E2_EMPLEADO' and type = 'RI')
   alter table EM_TEMP
      drop constraint FK_EM_TEMP_SON_E2_EMPLEADO
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('EM_TIENE_TELS'))
            where name = 'FK_EM_TIENE_EM_TIENE__TELS_EMP' and type = 'RI')
   alter table EM_TIENE_TELS
      drop constraint FK_EM_TIENE_EM_TIENE__TELS_EMP
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('EM_TIENE_TELS'))
            where name = 'FK_EM_TIENE_EM_TIENE__EMPLEADO' and type = 'RI')
   alter table EM_TIENE_TELS
      drop constraint FK_EM_TIENE_EM_TIENE__EMPLEADO
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('IMPL_SEGURIDAD'))
            where name = 'FK_IMPL_SEG_REG_IMPL_COORD_T_' and type = 'RI')
   alter table IMPL_SEGURIDAD
      drop constraint FK_IMPL_SEG_REG_IMPL_COORD_T_
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('IMPL_SEGURIDAD'))
            where name = 'FK_IMPL_SEG_SUMINISTR_PROVEEDO' and type = 'RI')
   alter table IMPL_SEGURIDAD
      drop constraint FK_IMPL_SEG_SUMINISTR_PROVEEDO
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PROVEEDOR'))
            where name = 'FK_PROVEEDO_REG_PROV_COORD_T_' and type = 'RI')
   alter table PROVEEDOR
      drop constraint FK_PROVEEDO_REG_PROV_COORD_T_
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('SUBGERENTE'))
            where name = 'FK_SUBGEREN_SON6_EMP_PLAN' and type = 'RI')
   alter table SUBGERENTE
      drop constraint FK_SUBGEREN_SON6_EMP_PLAN
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('TELS_PROV'))
            where name = 'FK_TELS_PRO_PR_TIENE__PROVEEDO' and type = 'RI')
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
            where id = object_id('ACTUALIZACION')
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
            where id = object_id('ACTU_IMPL')
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
            where id = object_id('ASIGNACION_C')
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
            where id = object_id('ASIG_IMPL')
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
            where id = object_id('BITACORA_SEG')
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
            where id = object_id('CLIENTE')
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
            where id = object_id('CL_TIENE_TELS')
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
            and   name  = 'REG_CONT_FK'
            and   indid > 0
            and   indid < 255)
   drop index CONTRATO.REG_CONT_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('CONTRATO')
            and   type = 'U')
   drop table CONTRATO
go

if exists (select 1
            from  sysobjects
            where id = object_id('COORD_CONTRATO')
            and   type = 'U')
   drop table COORD_CONTRATO
go

if exists (select 1
            from  sysobjects
            where id = object_id('COORD_T_Y_Y')
            and   type = 'U')
   drop table COORD_T_Y_Y
go

if exists (select 1
            from  sysobjects
            where id = object_id('DIR_COMERCIAL')
            and   type = 'U')
   drop table DIR_COMERCIAL
go

if exists (select 1
            from  sysobjects
            where id = object_id('DIR_GESTION_HUM')
            and   type = 'U')
   drop table DIR_GESTION_HUM
go

if exists (select 1
            from  sysobjects
            where id = object_id('DIR_OPERACIONES')
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
            where id = object_id('EMPLEADOS')
            and   type = 'U')
   drop table EMPLEADOS
go

if exists (select 1
            from  sysobjects
            where id = object_id('EMP_PLANTA')
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
            where id = object_id('EM_TEMP')
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
            where id = object_id('EM_TIENE_TELS')
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
            where id = object_id('IMPL_SEGURIDAD')
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
            where id = object_id('TELS_CLI')
            and   type = 'U')
   drop table TELS_CLI
go

if exists (select 1
            from  sysobjects
            where id = object_id('TELS_EMP')
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
            where id = object_id('TELS_PROV')
            and   type = 'U')
   drop table TELS_PROV
go

/*==============================================================*/
/* Table: ACTUALIZACION                                         */
/*==============================================================*/
create table ACTUALIZACION (
   SUB_CEDULAE          bigint                         not null,
   CEDULAE              bigint                         not null,
   FECHA_ACTUAL_DGH     datetime                       not null,
   constraint PK_ACTUALIZACION primary key nonclustered (SUB_CEDULAE, CEDULAE)
)
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
   ID_ACTUALIZACION_I   smallint                       not null,
   ID_IMPLEMENTO        smallint                       null,
   CEDULAE              bigint                         null,
   FECHA_ACTUALIZACION_I datetime                       not null,
   CANTIDAD_AGREGADA    smallint                       null,
   DESCRIPCION_ACTUALIZACION varchar(30)                    not null,
   constraint PK_ACTU_IMPL primary key nonclustered (ID_ACTUALIZACION_I)
)
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
   ID_ASIG              smallint                       not null,
   ID_CONTRATO          smallint                       null,
   CEDULAE              bigint                         null,
   COO_CEDULAE          bigint                         null,
   FECHA_ASIGNACION_C   datetime                       not null,
   HORARIO_ASIGNADO     varchar(20)                    not null,
   constraint PK_ASIGNACION_C primary key nonclustered (ID_ASIG)
)
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
   ID_ASIGNACION_I      smallint                       not null,
   ID_IMPLEMENTO        smallint                       null,
   CEDULAE              bigint                         null,
   COO_CEDULAE          bigint                         null,
   CANTIDAD_ASIGNADA    smallint                       not null,
   ESTADO_ASIGNACION    bit                            not null,
   FECHA_ASIGNACION_I   datetime                       not null,
   constraint PK_ASIG_IMPL primary key nonclustered (ID_ASIGNACION_I)
)
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
   ID_OPER              int                            not null,
   CEDULAE              bigint                         null,
   FECHA_OPER           datetime                       not null,
   USU_OPER             varchar(20)                    null,
   MAQ_OPER             varchar(20)                    null,
   TABLA_MOD            varchar(20)                    not null,
   TIPO_OPER            varchar(6)                     not null,
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
   IDCL                 smallint                       not null,
   CEDULAE              bigint                         not null,
   NOMBRECL             varchar(20)                    not null,
   DIRECCIONCL          varchar(20)                    not null,
   FECHA_REG_CL         datetime                       not null,
   constraint PK_CLIENTE primary key nonclustered (IDCL)
)
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
   ID_TC                smallint                       not null,
   IDCL                 smallint                       not null,
   constraint PK_CL_TIENE_TELS primary key nonclustered (ID_TC, IDCL)
)
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
   ID_COMUNICADO        smallint                       not null,
   CEDULAE              bigint                         null,
   DIR_CEDULAE          bigint                         null,
   TIPO_CO              varchar(20)                    not null,
   FECHA_CO             datetime                       not null,
   CONTENIDO_CO         varchar(100)                   not null,
   URGENTE              bit                            not null,
   RESPUESTA_CO         varchar(100)                   null,
   constraint PK_COMUNICADO primary key nonclustered (ID_COMUNICADO)
)
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
   ID_CONTRATO          smallint                       not null,
   IDCL                 smallint                       not null,
   CEDULAE              bigint                         not null,
   UBICACION_C          varchar(20)                    not null,
   TELEFONO_C           int                            not null,
   CELULAR_C            int                            not null,
   TIPO_C               varchar(50)                    not null
         constraint CKC_TIPO_C_CONTRATO check (TIPO_C in ('<Val0>','<Val1>')),
   FECHA_INICIO_C       datetime                       not null,
   TIPO_PERSONAL_C      varchar(20)                    not null,
   CANTIDAD_PERSONAL_C  smallint                       not null,
   COSTO_MENSUAL_C      money                          not null,
   HORARIO_C            varchar(20)                    not null,
   TIEMPO_C             int                            null,
   FECHA_REG_CON        datetime                       not null,
   constraint PK_CONTRATO primary key nonclustered (ID_CONTRATO),
   constraint AK_ID_UBI_CONTRATO_CONTRATO unique (UBICACION_C)
)
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
   CEDULAE              bigint                         not null,
   constraint PK_COORD_CONTRATO primary key nonclustered (CEDULAE)
)
go

/*==============================================================*/
/* Table: COORD_T_Y_Y                                           */
/*==============================================================*/
create table COORD_T_Y_Y (
   CEDULAE              bigint                         not null,
   constraint PK_COORD_T_Y_Y primary key nonclustered (CEDULAE)
)
go

/*==============================================================*/
/* Table: DIR_COMERCIAL                                         */
/*==============================================================*/
create table DIR_COMERCIAL (
   CEDULAE              bigint                         not null,
   constraint PK_DIR_COMERCIAL primary key nonclustered (CEDULAE)
)
go

/*==============================================================*/
/* Table: DIR_GESTION_HUM                                       */
/*==============================================================*/
create table DIR_GESTION_HUM (
   CEDULAE              bigint                         not null,
   constraint PK_DIR_GESTION_HUM primary key nonclustered (CEDULAE)
)
go

/*==============================================================*/
/* Table: DIR_OPERACIONES                                       */
/*==============================================================*/
create table DIR_OPERACIONES (
   CEDULAE              bigint                         not null,
   constraint PK_DIR_OPERACIONES primary key nonclustered (CEDULAE)
)
go

/*==============================================================*/
/* Table: EMPLEADOS                                             */
/*==============================================================*/
create table EMPLEADOS (
   CEDULAE              bigint                         not null,
   DIR_CEDULAE          bigint                         null,
   NOMBREE              varchar(20)                    not null,
   APELLIDOE            varchar(20)                    not null,
   CONTRASENAE          char(10)                       not null,
   CODDOCUME            varchar(20)                    not null,
   FECHAREG             datetime                       not null,
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
   CEDULAE              bigint                         not null,
   SUELDOE              NUMBER(10,2)                   not null,
   constraint PK_EMP_PLANTA primary key nonclustered (CEDULAE)
)
go

/*==============================================================*/
/* Table: EMP_TEMP                                               */
/*==============================================================*/
create table EMP_TEMP (
   CEDULAE              bigint                         not null,
   ID_ASIG              smallint                       null,
   TIENE_CONTRATO       bit                            not null,
   TIPO_TEMP            varchar(20)                    not null,
   constraint PK_EMP_TEMP primary key nonclustered (CEDULAE)
)
go

/*==============================================================*/
/* Index: ASIGNAN_A_E_FK                                        */
/*==============================================================*/
create index ASIGNAN_A_E_FK on EMP_TEMP (
ID_ASIG ASC
)
go

/*==============================================================*/
/* Table: EM_TIENE_TELS                                         */
/*==============================================================*/
create table EM_TIENE_TELS (
   ID_TE                smallint                       not null,
   CEDULAE              bigint                         not null,
   constraint PK_EM_TIENE_TELS primary key nonclustered (ID_TE, CEDULAE)
)
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
   ID_IMPLEMENTO        smallint                       not null,
   ID_PRO               smallint                       null,
   CEDULAE              bigint                         not null,
   NOMBRE_I             varchar(20)                    not null,
   PRECIO_UNITARIO_I    money                          not null,
   CANTIDAD             smallint                       not null,
   DESCRIPCION_I        varchar(100)                   not null,
   ESTADO_I             varchar(20)                    not null,
   FECHA_REG_IM         datetime                       not null,
   constraint PK_IMPL_SEGURIDAD primary key nonclustered (ID_IMPLEMENTO),
   constraint AK_ID_NOM_IMPLEMENT_IMPL_SEG unique (NOMBRE_I)
)
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
   ID_PRO               smallint                       not null,
   CEDULAE              bigint                         not null,
   NOMBRE               varchar(20)                    not null,
   DIRECCION            varchar(20)                    not null,
   FECHA_REG_PROV       datetime                       not null,
   constraint PK_PROVEEDOR primary key nonclustered (ID_PRO),
   constraint AK_ID_NOM_PROV_PROVEEDO unique (NOMBRE)
)
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
   CEDULAE              bigint                         not null,
   constraint PK_SUBGERENTE primary key nonclustered (CEDULAE)
)
go

/*==============================================================*/
/* Table: TELS_CLI                                              */
/*==============================================================*/
create table TELS_CLI (
   ID_TC                smallint                       not null,
   NUM_TELEFONO_C       int                            not null,
   constraint PK_TELS_CLI primary key nonclustered (ID_TC)
)
go

/*==============================================================*/
/* Table: TELS_EMP                                              */
/*==============================================================*/
create table TELS_EMP (
   ID_TE                smallint                       not null,
   NUM_TELEFONO_E       int                            not null,
   constraint PK_TELS_EMP primary key nonclustered (ID_TE)
)
go

/*==============================================================*/
/* Table: TELS_PROV                                             */
/*==============================================================*/
create table TELS_PROV (
   ID_TP                smallint                       not null,
   ID_PRO               smallint                       null,
   NUM_TELEFONO_P       int                            not null,
   constraint PK_TELS_PROV primary key nonclustered (ID_TP)
)
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
      references COORD_T_Y_T (CEDULAE)
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
      references COORD_T_Y_T (CEDULAE)
go

alter table ASIG_IMPL
   add constraint FK_ASIG_IMP_LO_ASIGNA_IMPL_SEG foreign key (ID_IMPLEMENTO)
      references IMPL_SEGURIDAD (ID_IMPLEMENTO)
go

alter table ASIG_IMPL
   add constraint FK_ASIG_IMP_RELATIONS_EMP_TEMP foreign key (CEDULAE)
      references EMP_TEMP (CEDULAE)
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
   add constraint FK_COMUNICA_REDACTA_EMP_TEMP foreign key (CEDULAE)
      references EMP_TEMP (CEDULAE)
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

alter table COORD_T_Y_T
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

alter table EMP_TEMP
   add constraint FK_EMP_TEMP_ASIGNAN_A_ASIGNACI foreign key (ID_ASIG)
      references ASIGNACION_C (ID_ASIG)
go

alter table EMP_TEMP
   add constraint FK_EMP_TEMP_SON_E2_EMPLEADO foreign key (CEDULAE)
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
      references COORD_T_Y_T (CEDULAE)
go

alter table IMPL_SEGURIDAD
   add constraint FK_IMPL_SEG_SUMINISTR_PROVEEDO foreign key (ID_PRO)
      references PROVEEDOR (ID_PRO)
go

alter table PROVEEDOR
   add constraint FK_PROVEEDO_REG_PROV_COORD_T_ foreign key (CEDULAE)
      references COORD_T_Y_T (CEDULAE)
go

alter table SUBGERENTE
   add constraint FK_SUBGEREN_SON6_EMP_PLAN foreign key (CEDULAE)
      references EMP_PLANTA (CEDULAE)
go

alter table TELS_PROV
   add constraint FK_TELS_PRO_PR_TIENE__PROVEEDO foreign key (ID_PRO)
      references PROVEEDOR (ID_PRO)
go

