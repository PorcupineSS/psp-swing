--TRIGGERS SYBASE
if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_EMPLEADO_TEMPORAL')
            and   type = 'TR')
   drop trigger TR_DEL_EMPLEADO_TEMPORAL
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_EMPLEADO_TEMPORAL')
            and   type = 'TR')
   drop trigger TR_INS_EMPLEADO_TEMPORAL
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_EMPLEADO_TEMPORAL')
            and   type = 'TR')
   drop trigger TR_UPD_EMPLEADO_TEMPORAL
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
            where id = object_id('TR_DEL_EMPLEADO')
            and   type = 'TR')
   drop trigger TR_DEL_EMPLEADO
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_EMPLEADO')
            and   type = 'TR')
   drop trigger TR_INS_EMPLEADO
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_EMPLEADO')
            and   type = 'TR')
   drop trigger TR_UPD_EMPLEADO
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
    declare @varid INTEGER
    select @varid = (select CEDULADIR from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
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
    declare @varid INTEGER
    select @varid = (select CEDULADIR from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
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
    declare @varid INTEGER
    select @varid = (select CEDULADIR from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ACTUALIZACION",
            "UPDATE")
end
go


create trigger TR_DEL_ACIMP on ACTUALIZACION_IMPLEMENTO for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ACTUALIZACION_IMPLEMENTO",
            "DELETE")
end
go


create trigger TR_INS_ACIMP on ACTUALIZACION_IMPLEMENTO for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ACTUALIZACION_IMPLEMENTO",
            "INSERT")
end
go


create trigger TR_UPD_ACIMP on ACTUALIZACION_IMPLEMENTO for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ACTUALIZACION_IMPLEMENTO",
            "UPDATE")
end
go


create trigger TR_DEL_ASIGC on ASIGNACION_CONTRATO for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIGNACION_CONTRATO",
            "DELETE")
end
go


create trigger TR_INS_ASIGC on ASIGNACION_CONTRATO for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIGNACION_CONTRATO",
            "INSERT")
end
go


create trigger TR_UPD_ASIGC on ASIGNACION_CONTRATO for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIGNACION_CONTRATO",
            "UPDATE")
end
go


create trigger TR_DEL_ASMP on ASIGNACION_IMPLEMENTO for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAET from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIGNACION_IMPLEMENTO",
            "DELETE")
end
go


create trigger TR_INS_ASMP on ASIGNACION_IMPLEMENTO for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAET from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIGNACION_IMPLEMENTO",
            "INSERT")
end
go


create trigger TR_UPD_ASMP on ASIGNACION_IMPLEMENTO for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAET from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIGNACION_IMPLEMENTO",
            "UPDATE")
end
go


create trigger TR_DEL_CLIEN on CLIENTE for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
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
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
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
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
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
    declare @varid INTEGER
    select @varid = (select CEDULAET from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
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
    declare @varid INTEGER
    select @varid = (select CEDULAET from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
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
    declare @varid INTEGER
    select @varid = (select CEDULAET from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
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
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
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
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
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
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "CONTRATO",
            "UPDATE")
end
go


create trigger TR_DEL_EMPLEADO on EMPLEADO for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADO",
            "DELETE")
end
go


create trigger TR_INS_EMPLEADO on EMPLEADO for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADO",
            "INSERT")
end
go


create trigger TR_UPD_EMPLEADO on EMPLEADO for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADO",
            "UPDATE")
end
go


create trigger TR_DEL_EMTELS on EMPLEADO_TELEFONO for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADO_TELEFONO",
            "DELETE")
end
go


create trigger TR_INS_EMTELS on EMPLEADO_TELEFONO for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADO_TELEFONO",
            "INSERT")
end
go


create trigger TR_UPD_EMTELS on EMPLEADO_TELEFONO for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADO_TELEFONO",
            "UPDATE")
end
go


create trigger TR_DEL_IMSEG on IMPLEMENTO_SEGURIDAD for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "IMPLEMENTO_SEGURIDAD",
            "DELETE")
end
go


create trigger TR_INS_IMSEG on IMPLEMENTO_SEGURIDAD for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "IMPLEMENTO_SEGURIDAD",
            "INSERT")
end
go


create trigger TR_UPD_IMSEG on IMPLEMENTO_SEGURIDAD for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "IMPLEMENTO_SEGURIDAD",
            "UPDATE")
end
go


create trigger TR_DEL_PROV on PROVEEDOR for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
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
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
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
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "PROVEEDOR",
            "UPDATE")
end
go


create trigger TR_DEL_EMPLANTA on EMPLEADO_PLANTA for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADO_PLANTA",
            "DELETE")
end
go


create trigger TR_INS_EMPLANTA on EMPLEADO_PLANTA for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADO_PLANTA",
            "INSERT")
end
go


create trigger TR_UPD_EMPLANTA on EMPLEADO_PLANTA for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADO_PLANTA",
            "UPDATE")
end
go


create trigger TR_DEL_EMPLEADO_TEMPORAL on EMPLEADO_TEMPORAL for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADO_TEMPORAL",
            "DELETE")
end
go


create trigger TR_INS_EMPLEADO_TEMPORAL on EMPLEADO_TEMPORAL for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADO_TEMPORAL",
            "INSERT")
end
go


create trigger TR_UPD_EMPLEADO_TEMPORAL on EMPLEADO_TEMPORAL for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULA from inserted)
    insert into BITACORA (CEDULA, FECHA_OPERACION, USUARIO_OPERACION, MAQUINA_OPERACION, TABLA_MODIFICADA, TIPO_OPERACION)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADO_TEMPORAL",
            "UPDATE")
end
go