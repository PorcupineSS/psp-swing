--TRIGGERS SYBASE

---------------------------------------------------------------------------------------------
if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_EMPLANTA')
            and   type = 'TR')
   drop trigger TR_INS_EMPLANTA
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_EMPLANTA')
            and   type = 'TR')
   drop trigger TR_DEL_EMPLANTA
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_EMPLANTA')
            and   type = 'TR')
   drop trigger TR_UPD_EMPLANTA
go

---------
if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_EM_TEMP')
            and   type = 'TR')
   drop trigger TR_INS_EM_TEMP
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_EM_TEMP')
            and   type = 'TR')
   drop trigger TR_DEL_EM_TEMP
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_EM_TEMP')
            and   type = 'TR')
   drop trigger TR_UPD_EM_TEMP
go
----------

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_CCONTRATO')
            and   type = 'TR')
   drop trigger TR_INS_CCONTRATO
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_CCONTRATO')
            and   type = 'TR')
   drop trigger TR_DEL_CCONTRATO
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_CCONTRATO')
            and   type = 'TR')
   drop trigger TR_UPD_CCONTRATO
go
----------

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_DIRCMCIAL')
            and   type = 'TR')
   drop trigger TR_INS_DIRCMCIAL
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_DIRCMCIAL')
            and   type = 'TR')
   drop trigger TR_DEL_DIRCMCIAL
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_DIRCMCIAL')
            and   type = 'TR')
   drop trigger TR_UPD_DIRCMCIAL
go
----------

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_DIRGESHUM')
            and   type = 'TR')
   drop trigger TR_INS_DIRGESHUM
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_DIRGESHUM')
            and   type = 'TR')
   drop trigger TR_DEL_DIRGESHUM
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_DIRGESHUM')
            and   type = 'TR')
   drop trigger TR_UPD_DIRGESHUM
go
----------

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_SUBGERENT')
            and   type = 'TR')
   drop trigger TR_INS_SUBGERENT
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_SUBGERENT')
            and   type = 'TR')
   drop trigger TR_DEL_SUBGERENT
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_SUBGERENT')
            and   type = 'TR')
   drop trigger TR_UPD_SUBGERENT
go
----------

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_COORDTYY')
            and   type = 'TR')
   drop trigger TR_INS_COORDTYY
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_COORDTYY')
            and   type = 'TR')
   drop trigger TR_DEL_COORDTYY
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_COORDTYY')
            and   type = 'TR')
   drop trigger TR_UPD_COORDTYY
go
----------

if exists (select 1
            from  sysobjects
            where id = object_id('TR_INS_DOPERAC')
            and   type = 'TR')
   drop trigger TR_INS_DOPERAC
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_DEL_DOPERAC')
            and   type = 'TR')
   drop trigger TR_DEL_DOPERAC
go

if exists (select 1
            from  sysobjects
            where id = object_id('TR_UPD_DOPERAC')
            and   type = 'TR')
   drop trigger TR_UPD_DOPERAC
go
----------

---------------------------------------------------------------------------------------------

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
----------------------------------------------------------------------------------------------------

--TRIGGERS EMP_PLANTA 

create trigger TR_INS_EMPLANTA on EMP_PLANTA for insert as
begin
    declare @varid INTEGER
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

create trigger TR_DEL_EMPLANTA on EMP_PLANTA for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMP PLANTA",
            "DELETE")
end
go

create trigger TR_UPD_EMPLANTA on EMP_PLANTA for update as
begin
    declare @varid INTEGER
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

--TRIGGERS EM_TEMP 

create trigger TR_INS_EM_TEMP on EMP_TEMP for insert as
begin
    declare @varid INTEGER
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

create trigger TR_DEL_EM_TEMP on EMP_TEMP for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EM TEMP",
            "DELETE")
end
go

create trigger TR_UPD_EM_TEMP on EMP_TEMP for update as
begin
    declare @varid INTEGER
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

--TRIGGERS COORD_CONTRATO 

create trigger TR_INS_CCONTRATO on COORD_CONTRATO for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "COORD CONTRATO",
            "INSERT")
end
go

create trigger TR_DEL_CCONTRATO on COORD_CONTRATO for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "COORD CONTRATO",
            "DELETE")
end
go

create trigger TR_UPD_CCONTRATO on COORD_CONTRATO for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "COORD CONTRATO",
            "UPDATE")
end
go

--TRIGGERS DIR_COMERCIAL 

create trigger TR_INS_DIRCMCIAL on DIR_COMERCIAL for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "DIR COMERCIAL",
            "INSERT")
end
go

create trigger TR_DEL_DIRCMCIAL on DIR_COMERCIAL for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "DIR COMERCIAL",
            "DELETE")
end
go

create trigger TR_UPD_DIRCMCIAL on DIR_COMERCIAL for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "DIR COMERCIAL",
            "UPDATE")
end
go

--TRIGGERS DIR_GESTION_HUM  

create trigger TR_INS_DIRGESHUM on DIR_GESTION_HUM for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "DIR GESTION HUM",
            "INSERT")
end
go

create trigger TR_DEL_DIRGESHUM on DIR_GESTION_HUM for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "DIR GESTION HUM",
            "DELETE")
end
go

create trigger TR_UPD_DIRGESHUM on DIR_GESTION_HUM for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "DIR GESTION HUM",
            "UPDATE")
end
go

--TRIGGERS SUBGERENTE 

create trigger TR_INS_SUBGERENT on SUBGERENTE for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "SUBGERENTE",
            "INSERT")
end
go

create trigger TR_DEL_SUBGERENT on SUBGERENTE for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "SUBGERENTE",
            "DELETE")
end
go

create trigger TR_UPD_SUBGERENT on SUBGERENTE for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "SUBGERENTE",
            "UPDATE")
end
go

--TRIGGERS COORD_T_Y_Y  

create trigger TR_INS_COORDTYY on COORD_T_Y_T for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "COORD T Y T",
            "INSERT")
end
go

create trigger TR_DEL_COORDTYY on COORD_T_Y_T for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "COORD T Y T",
            "DELETE")
end
go

create trigger TR_UPD_COORDTYY on COORD_T_Y_T for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "COORD T Y T",
            "UPDATE")
end
go

--TRIGGERS DIR_OPERACIONES 

create trigger TR_INS_DOPERAC on DIR_OPERACIONES for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "DIR OPERACIONES",
            "INSERT")
end
go

create trigger TR_DEL_DOPERAC on DIR_OPERACIONES for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "DIR OPERACIONES",
            "DELETE")
end
go

create trigger TR_UPD_DOPERAC on DIR_OPERACIONES for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "DIR OPERACIONES",
            "UPDATE")
end
go

----------------------------------------------------------------------------------------------------
create trigger TR_DEL_ACTUAL on ACTUALIZACION for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
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
    declare @varid INTEGER
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
    declare @varid INTEGER
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
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ACTU_IMPL",
            "DELETE")
end
go


create trigger TR_INS_ACIMP on ACTU_IMPL for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ACTU_IMPL",
            "INSERT")
end
go


create trigger TR_UPD_ACIMP on ACTU_IMPL for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ACTU_IMPL",
            "UPDATE")
end
go


create trigger TR_DEL_ASIGC on ASIGNACION_C for delete as
begin
    declare @varid INTEGER
    select @varid = (select EMP_TEMP_CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIGNACION_C",
            "DELETE")
end
go


create trigger TR_INS_ASIGC on ASIGNACION_C for insert as
begin
    declare @varid INTEGER
    select @varid = (select EMP_TEMP_CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIGNACION_C",
            "INSERT")
end
go


create trigger TR_UPD_ASIGC on ASIGNACION_C for update as
begin
    declare @varid INTEGER
    select @varid = (select EMP_TEMP_CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIGNACION_C",
            "UPDATE")
end
go


create trigger TR_DEL_ASMP on ASIG_IMPL for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIG_IMPL",
            "DELETE")
end
go


create trigger TR_INS_ASMP on ASIG_IMPL for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIG_IMPL",
            "INSERT")
end
go


create trigger TR_UPD_ASMP on ASIG_IMPL for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "ASIG_IMPL",
            "UPDATE")
end
go


create trigger TR_DEL_CLIEN on CLIENTE for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
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
    declare @varid INTEGER
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
    declare @varid INTEGER
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
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
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
    declare @varid INTEGER
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
    declare @varid INTEGER
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
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
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
    declare @varid INTEGER
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
    declare @varid INTEGER
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


create trigger TR_DEL_EMPLEADO on EMPLEADOS for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADOS",
            "DELETE")
end
go


create trigger TR_INS_EMPLEADO on EMPLEADOS for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADOS",
            "INSERT")
end
go


create trigger TR_UPD_EMPLEADO on EMPLEADOS for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMPLEADOS",
            "UPDATE")
end
go

/*
create trigger TR_DEL_EMTELS on TELS_EMP for delete as
begin
    declare @varid INTEGER
    select @varid = (select ID_TE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "TELS_EMP",
            "DELETE")
end
go


create trigger TR_INS_EMTELS on TELS_EMP for insert as
begin
    declare @varid INTEGER
    select @varid = (select ID_TE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "TELS_EMP",
            "INSERT")
end
go


create trigger TR_UPD_EMTELS on TELS_EMP for update as
begin
    declare @varid INTEGER
    select @varid = (select ID_TE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "TELS_EMP",
            "UPDATE")
end
go
*/

create trigger TR_DEL_IMSEG on IMPL_SEGURIDAD for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "IMPL_SEGURIDAD",
            "DELETE")
end
go


create trigger TR_INS_IMSEG on IMPL_SEGURIDAD for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "IMPL_SEGURIDAD",
            "INSERT")
end
go


create trigger TR_UPD_IMSEG on IMPL_SEGURIDAD for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "IIMPL_SEGURIDAD",
            "UPDATE")
end
go


create trigger TR_DEL_PROV on PROVEEDOR for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
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
    declare @varid INTEGER
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
    declare @varid INTEGER
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
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMP_PLANTA",
            "DELETE")
end
go


create trigger TR_INS_EMPLANTA on EMP_PLANTA for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMP_PLANTA",
            "INSERT")
end
go


create trigger TR_UPD_EMPLANTA on EMP_PLANTA for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMP_PLANTA",
            "UPDATE")
end
go


create trigger TR_DEL_EMPLEADO_TEMPORAL on EMP_TEMP for delete as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from deleted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMP_TEMP",
            "DELETE")
end
go


create trigger TR_INS_EMPLEADO_TEMPORAL on EMP_TEMP for insert as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMP_TEMP",
            "INSERT")
end
go


create trigger TR_UPD_EMPLEADO_TEMPORAL on EMP_TEMP for update as
begin
    declare @varid INTEGER
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            user_name(),
            host_name(),
            "EMP_TEMP",
            "UPDATE")
end
go