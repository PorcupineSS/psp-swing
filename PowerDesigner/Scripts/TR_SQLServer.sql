--TRIGGERS sqlServer

/*TABLA EMPLEADOS*/
create trigger TR_INS_EMPLEADOS on EMPLEADOS for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'EMPELADOS',
            'INSERT')
end

create trigger TR_DEL_EMPLEADOS on EMPLEADOS for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'EMPELADOS',
            'DELETE')
end

create trigger TR_UPD_EMPLEADOS on EMPLEADOS for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'EMPELADOS',
            'UPDATE')
end


/*TRIGGERS EMP_PLANTA */

create trigger TR_INS_EMPLANTA on EMP_PLANTA for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'EMP PLANTA',
            'INSERT')
end

create trigger TR_DEL_EMPLANTA on EMP_PLANTA for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'EMP PLANTA',
            'DELETE')
end

create trigger TR_UPD_EMPLANTA on EMP_PLANTA for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'EMP PLANTA',
            'UPDATE')
end

/*TRIGGERS EM_TEMP */

create trigger TR_INS_EM_TEMP on EM_TEMP for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'EM TEMP',
            'INSERT')
end

create trigger TR_DEL_EM_TEMP on EM_TEMP for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'EM TEMP',
            'DELETE')
end

create trigger TR_UPD_EM_TEMP on EM_TEMP for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'EM TEMP',
            'UPDATE')
end


/*TRIGGERS COORD_CONTRATO */

create trigger TR_INS_CCONTRATO on COORD_CONTRATO for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'COORD CONTRATO',
            'INSERT')
end

create trigger TR_DEL_CCONTRATO on COORD_CONTRATO for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'COORD CONTRATO',
            'DELETE')
end

create trigger TR_UPD_CCONTRATO on COORD_CONTRATO for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'COORD CONTRATO',
            'UPDATE')
end

/*TRIGGERS DIR_COMERCIAL */

create trigger TR_INS_DIRCMCIAL on DIR_COMERCIAL for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'DIR COMERCIAL',
            'INSERT')
end

create trigger TR_DEL_DIRCMCIAL on DIR_COMERCIAL for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'DIR COMERCIAL',
            'DELETE')
end

create trigger TR_UPD_DIRCMCIAL on DIR_COMERCIAL for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'DIR COMERCIAL',
            'UPDATE')
end


/*TRIGGERS DIR_GESTION_HUM  */

create trigger TR_INS_DIRGESHUM on DIR_GESTION_HUM for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'DIR GESTION HUM',
            'INSERT')
end

create trigger TR_DEL_DIRGESHUM on DIR_GESTION_HUM for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'DIR GESTION HUM',
            'DELETE')
end

create trigger TR_UPD_DIRGESHUM on DIR_GESTION_HUM for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'DIR GESTION HUM',
            'UPDATE')
end


/*TRIGGERS SUBGERENTE */

create trigger TR_INS_SUBGERENT on SUBGERENTE for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'SUBGERENTE',
            'INSERT')
end

create trigger TR_DEL_SUBGERENT on SUBGERENTE for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'SUBGERENTE',
            'DELETE')
end

create trigger TR_UPD_SUBGERENT on SUBGERENTE for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'SUBGERENTE',
            'UPDATE')
end

/*TRIGGERS COORD_T_Y_Y  */

create trigger TR_INS_COORDTYY on COORD_T_Y_Y for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'COORD T Y Y',
            'INSERT')
end

create trigger TR_DEL_COORDTYY on COORD_T_Y_Y for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'COORD T Y Y',
            'DELETE')
end

create trigger TR_UPD_COORDTYY on COORD_T_Y_Y for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'COORD T Y Y',
            'UPDATE')
end

/*TRIGGERS DIR_OPERACIONES  */

create trigger TR_INS_DOPERAC on DIR_OPERACIONES for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'DIR OPERACIONES',
            'INSERT')
end

create trigger TR_DEL_DOPERAC on DIR_OPERACIONES for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'DIR OPERACIONES',
            'DELETE')
end

create trigger TR_UPD_DOPERAC on DIR_OPERACIONES for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'DIR OPERACIONES',
            'UPDATE')
end

/*TRIGGERS EM_TIENE_TELS  */

create trigger TR_INS_EMTELS on EM_TIENE_TELS for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'EM TIENE TELS',
            'INSERT')
end

create trigger TR_DEL_EMTELS on EM_TIENE_TELS for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'EM TIENE TELS',
            'DELETE')
end

create trigger TR_UPD_EMTELS on EM_TIENE_TELS for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'EM TIENE TELS',
            'UPDATE')
end

/*TRIGGERS ACTUALIZACION  */

create trigger TR_INS_ACTUAL on ACTUALIZACION for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'ACTUALIZACION',
            'INSERT')
end

create trigger TR_DEL_ACTUAL on ACTUALIZACION for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'ACTUALIZACION',
            'DELETE')
end

create trigger TR_UPD_ACTUAL on ACTUALIZACION for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'ACTUALIZACION',
            'UPDATE')
end

/*TRIGGERS COMUNICADO */

create trigger TR_INS_COMUN on COMUNICADO for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'COMUNICADO',
            'INSERT')
end

create trigger TR_DEL_COMUN on COMUNICADO for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'COMUNICADO',
            'DELETE')
end

create trigger TR_UPD_COMUN on COMUNICADO for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'COMUNICADO',
            'UPDATE')
end

/*TRIGGERS ASIGNACION_C */

create trigger TR_INS_ASIGC on ASIGNACION_C for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'ASIGNACION C',
            'INSERT')
end

create trigger TR_DEL_ASIGC on ASIGNACION_C for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'ASIGNACION C',
            'DELETE')
end

create trigger TR_UPD_ASIGC on ASIGNACION_C for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'ASIGNACION C',
            'UPDATE')
end

/*TRIGGERS CLIENTE */

create trigger TR_INS_CLIEN on CLIENTE for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'CLIENTE',
            'INSERT')
end

create trigger TR_DEL_CLIEN on CLIENTE for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'CLIENTE',
            'DELETE')
end

create trigger TR_UPD_CLIEN on CLIENTE for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'CLIENTE',
            'UPDATE')
end

/*TRIGGERS CONTRATO */

create trigger TR_INS_CONT on CONTRATO for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'CONTRATO',
            'INSERT')
end

create trigger TR_DEL_CONT on CONTRATO for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'CONTRATO',
            'DELETE')
end

create trigger TR_UPD_CONT on CONTRATO for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'CONTRATO',
            'UPDATE')
end

/*TRIGGERS IMPL_SEGURIDAD */

create trigger TR_INS_IMSEG on IMPL_SEGURIDAD for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'IMPL SEGURIDAD',
            'INSERT')
end

create trigger TR_DEL_IMSEG on IMPL_SEGURIDAD for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'IMPL SEGURIDAD',
            'DELETE')
end

create trigger TR_UPD_IMSEG on IMPL_SEGURIDAD for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'IMPL SEGURIDAD',
            'UPDATE')
end

/*TRIGGERS PROVEEDOR */

create trigger TR_INS_PROV on PROVEEDOR for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'PROVEEDOR',
            'INSERT')
end

create trigger TR_DEL_PROV on PROVEEDOR for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'PROVEEDOR',
            'DELETE')
end

create trigger TR_UPD_PROV on PROVEEDOR for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'PROVEEDOR',
            'UPDATE')
end

/*TRIGGERS ASIG_IMPL */

create trigger TR_INS_ASMP on ASIG_IMPL for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'ASIG IMPL',
            'INSERT')
end

create trigger TR_DEL_ASMP on ASIG_IMPL for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'ASIG IMPL',
            'DELETE')
end

create trigger TR_UPD_ASMP on ASIG_IMPL for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'ASIG IMPL',
            'UPDATE')
end

/*TRIGGERS ACTU_IMPL */

create trigger TR_INS_ACIMP on ACTU_IMPL for insert as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'ACTU IMPL',
            'INSERT')
end

create trigger TR_DEL_ACIMP on ACTU_IMPL for delete as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'ACTU IMPL',
            'DELETE')
end

create trigger TR_UPD_ACIMP on ACTU_IMPL for update as
begin
    declare @varid bigint
    select @varid = (select CEDULAE from inserted)
    insert into BITACORA_SEG (CEDULAE, FECHA_OPER, USU_OPER, MAQ_OPER, TABLA_MOD, TIPO_OPER)
    values (@varid,
            getdate(),
            suser_name(),
            HOST_NAME(),
            'ACTU IMPL',
            'UPDATE')
end