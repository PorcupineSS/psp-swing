--Tabla BITACORA

drop procedure P1_BITACORA
go
drop procedure P2_BITACORA
go
drop procedure P3_BITACORA
go

CREATE PROCEDURE P1_BITACORA (@tabla VARCHAR(20), @respuesta INT)
AS
BEGIN
if exists (select 1 from BITACORA where BITACORA.TABLA_MODIFICADA = @tabla)
	BEGIN
		select
			BITACORA.CEDULA,
			BITACORA.FECHA_OPERACION,
			BITACORA.USUARIO_OPERACION,
			BITACORA.MAQUINA_OPERACION,
			BITACORA.TABLA_MODIFICADA,
			BITACORA.TIPO_OPERACION
		from
			BITACORA
		where
			BITACORA.TABLA_MODIFICADA = @tabla
	END
else
	BEGIN
		select @respuesta = 0
	END
END 
go

CREATE PROCEDURE P2_BITACORA (@fecha DATE, @respuesta INT)
AS
BEGIN
if exists (select 1 from BITACORA where BITACORA.FECHA_OPERACION = @fecha)
	BEGIN
		select
			BITACORA.CEDULA,
			BITACORA.FECHA_OPERACION,
			BITACORA.USUARIO_OPERACION,
			BITACORA.MAQUINA_OPERACION,
			BITACORA.TABLA_MODIFICADA,
			BITACORA.TIPO_OPERACION
		from
			BITACORA
		where
			BITACORA.FECHA_OPERACION = @fecha
	END
else
	BEGIN
		select @respuesta = 0
	END
END
go

CREATE PROCEDURE P3_BITACORA (@operacion VARCHAR(6), @respuesta INT)
AS
BEGIN
if exists (select 1 from BITACORA where BITACORA.TIPO_OPERACION = @operacion)
	BEGIN
		select
			BITACORA.CEDULA,
			BITACORA.FECHA_OPERACION,
			BITACORA.USUARIO_OPERACION,
			BITACORA.MAQUINA_OPERACION,
			BITACORA.TABLA_MODIFICADA,
			BITACORA.TIPO_OPERACION
		from
			BITACORA
		where
			BITACORA.TIPO_OPERACION = @operacion
	END
else
	BEGIN
		select @respuesta = 0
	END
END
go