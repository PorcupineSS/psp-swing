--TRIGGERS SYBASE
if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_EM_TEMP')
            and   type = 'TR')
   drop trigger TR_DEL_EM_TEMP
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_EM_TEMP')
            and   type = 'TR')
   drop trigger TR_INS_EM_TEMP
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_EM_TEMP')
            and   type = 'TR')
   drop trigger TR_UPD_EM_TEMP
go


if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_EMPLANTA')
            and   type = 'TR')
   drop trigger TR_DEL_EMPLANTA
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_EMPLANTA')
            and   type = 'TR')
   drop trigger TR_INS_EMPLANTA
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_EMPLANTA')
            and   type = 'TR')
   drop trigger TR_UPD_EMPLANTA
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_ACTUAL')
            and   type = 'TR')
   drop trigger TR_DEL_ACTUAL
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_ACTUAL')
            and   type = 'TR')
   drop trigger TR_INS_ACTUAL
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_ACTUAL')
            and   type = 'TR')
   drop trigger TR_UPD_ACTUAL
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_ACIMP')
            and   type = 'TR')
   drop trigger TR_DEL_ACIMP
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_ACIMP')
            and   type = 'TR')
   drop trigger TR_INS_ACIMP
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_ACIMP')
            and   type = 'TR')
   drop trigger TR_UPD_ACIMP
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_ASIGC')
            and   type = 'TR')
   drop trigger TR_DEL_ASIGC
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_ASIGC')
            and   type = 'TR')
   drop trigger TR_INS_ASIGC
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_ASIGC')
            and   type = 'TR')
   drop trigger TR_UPD_ASIGC
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_ASMP')
            and   type = 'TR')
   drop trigger TR_DEL_ASMP
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_ASMP')
            and   type = 'TR')
   drop trigger TR_INS_ASMP
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_ASMP')
            and   type = 'TR')
   drop trigger TR_UPD_ASMP
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_CLIEN')
            and   type = 'TR')
   drop trigger TR_DEL_CLIEN
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_CLIEN')
            and   type = 'TR')
   drop trigger TR_INS_CLIEN
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_CLIEN')
            and   type = 'TR')
   drop trigger TR_UPD_CLIEN
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_COMUN')
            and   type = 'TR')
   drop trigger TR_DEL_COMUN
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_COMUN')
            and   type = 'TR')
   drop trigger TR_INS_COMUN
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_COMUN')
            and   type = 'TR')
   drop trigger TR_UPD_COMUN
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_CONT')
            and   type = 'TR')
   drop trigger TR_DEL_CONT
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_CONT')
            and   type = 'TR')
   drop trigger TR_INS_CONT
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_CONT')
            and   type = 'TR')
   drop trigger TR_UPD_CONT
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_EMPLEADOS')
            and   type = 'TR')
   drop trigger TR_DEL_EMPLEADOS
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_EMPLEADOS')
            and   type = 'TR')
   drop trigger TR_INS_EMPLEADOS
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_EMPLEADOS')
            and   type = 'TR')
   drop trigger TR_UPD_EMPLEADOS
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_EMTELS')
            and   type = 'TR')
   drop trigger TR_DEL_EMTELS
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_EMTELS')
            and   type = 'TR')
   drop trigger TR_INS_EMTELS
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_EMTELS')
            and   type = 'TR')
   drop trigger TR_UPD_EMTELS
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_IMSEG')
            and   type = 'TR')
   drop trigger TR_DEL_IMSEG
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_IMSEG')
            and   type = 'TR')
   drop trigger TR_INS_IMSEG
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_IMSEG')
            and   type = 'TR')
   drop trigger TR_UPD_IMSEG
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_PROV')
            and   type = 'TR')
   drop trigger TR_DEL_PROV
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_PROV')
            and   type = 'TR')
   drop trigger TR_INS_PROV
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_PROV')
            and   type = 'TR')
   drop trigger TR_UPD_PROV
go

create trigger TR_DEL_ACTUAL on ACTUALIZACION for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ACTUALIZACION",
            "DELETE")
end
go


create trigger TR_INS_ACTUAL on ACTUALIZACION for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ACTUALIZACION",
            "INSERT")
end
go


create trigger TR_UPD_ACTUAL on ACTUALIZACION for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ACTUALIZACION",
            "UPDATE")
end
go


create trigger TR_DEL_ACIMP on ACTU_IMPL for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ACTU IMPL",
            "DELETE")
end
go


create trigger TR_INS_ACIMP on ACTU_IMPL for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ACTU IMPL",
            "INSERT")
end
go


create trigger TR_UPD_ACIMP on ACTU_IMPL for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ACTU IMPL",
            "UPDATE")
end
go


create trigger TR_DEL_ASIGC on ASIGNACION_C for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIGNACION C",
            "DELETE")
end
go


create trigger TR_INS_ASIGC on ASIGNACION_C for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIGNACION C",
            "INSERT")
end
go


create trigger TR_UPD_ASIGC on ASIGNACION_C for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIGNACION C",
            "UPDATE")
end
go


create trigger TR_DEL_ASMP on ASIG_IMPL for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIG IMPL",
            "DELETE")
end
go


create trigger TR_INS_ASMP on ASIG_IMPL for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIG IMPL",
            "INSERT")
end
go


create trigger TR_UPD_ASMP on ASIG_IMPL for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIG IMPL",
            "UPDATE")
end
go


create trigger TR_DEL_CLIEN on CLIENTE for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "CLIENTE",
            "DELETE")
end
go


create trigger TR_INS_CLIEN on CLIENTE for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "CLIENTE",
            "INSERT")
end
go


create trigger TR_UPD_CLIEN on CLIENTE for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "CLIENTE",
            "UPDATE")
end
go


create trigger TR_DEL_COMUN on COMUNICADO for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "COMUNICADO",
            "DELETE")
end
go


create trigger TR_INS_COMUN on COMUNICADO for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "COMUNICADO",
            "INSERT")
end
go


create trigger TR_UPD_COMUN on COMUNICADO for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "COMUNICADO",
            "UPDATE")
end
go


create trigger TR_DEL_CONT on CONTRATO for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "CONTRATO",
            "DELETE")
end
go


create trigger TR_INS_CONT on CONTRATO for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "CONTRATO",
            "INSERT")
end
go


create trigger TR_UPD_CONT on CONTRATO for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "CONTRATO",
            "UPDATE")
end
go


create trigger TR_DEL_EMPLEADOS on EMPLEADOS for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPELADOS",
            "DELETE")
end
go


create trigger TR_INS_EMPLEADOS on EMPLEADOS for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPELADOS",
            "INSERT")
end
go


create trigger TR_UPD_EMPLEADOS on EMPLEADOS for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPELADOS",
            "UPDATE")
end
go


create trigger TR_DEL_EMTELS on EM_TIENE_TELS for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EM TIENE TELS",
            "DELETE")
end
go


create trigger TR_INS_EMTELS on EM_TIENE_TELS for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EM TIENE TELS",
            "INSERT")
end
go


create trigger TR_UPD_EMTELS on EM_TIENE_TELS for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EM TIENE TELS",
            "UPDATE")
end
go


create trigger TR_DEL_IMSEG on IMPL_SEGURIDAD for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "IMPL SEGURIDAD",
            "DELETE")
end
go


create trigger TR_INS_IMSEG on IMPL_SEGURIDAD for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "IMPL SEGURIDAD",
            "INSERT")
end
go


create trigger TR_UPD_IMSEG on IMPL_SEGURIDAD for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "IMPL SEGURIDAD",
            "UPDATE")
end
go


create trigger TR_DEL_PROV on PROVEEDOR for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "PROVEEDOR",
            "DELETE")
end
go


create trigger TR_INS_PROV on PROVEEDOR for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "PROVEEDOR",
            "INSERT")
end
go


create trigger TR_UPD_PROV on PROVEEDOR for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "PROVEEDOR",
            "UPDATE")
end
go


create trigger TR_DEL_EMPLANTA on EMP_PLANTA for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMP PLANTA",
            "DELETE")
end
go


create trigger TR_INS_EMPLANTA on EMP_PLANTA for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMP PLANTA",
            "INSERT")
end
go


create trigger TR_UPD_EMPLANTA on EMP_PLANTA for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMP PLANTA",
            "UPDATE")
end
go


create trigger TR_DEL_EM_TEMP on EM_TEMP for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EM TEMP",
            "DELETE")
end
go


create trigger TR_INS_EM_TEMP on EM_TEMP for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EM TEMP",
            "INSERT")
end
go


create trigger TR_UPD_EM_TEMP on EM_TEMP for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EM TEMP",
            "UPDATE")
end
go