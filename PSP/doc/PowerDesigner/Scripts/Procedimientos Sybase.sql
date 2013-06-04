--Tabla BITACORA_SEG

drop procedure P1_BITACORA
go
drop procedure P2_BITACORA
go
drop procedure P3_BITACORA
go

CREATE PROCEDURE P1_BITACORA (@tabla VARCHAR(20), @respuesta INT)
AS
BEGIN
if exists (select 1 from BITACORA_SEG where BITACORA_SEG.TABLA_MOD = @tabla)
	BEGIN
		select
			BITACORA_SEG.CEDULAE,
			BITACORA_SEG.FECHA_OPER,
			BITACORA_SEG.USU_OPER,
			BITACORA_SEG.MAQ_OPER,
			BITACORA_SEG.TABLA_MOD,
			BITACORA_SEG.TIPO_OPER
		from
			BITACORA_SEG
		where
			BITACORA_SEG.TABLA_MOD = @tabla
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
if exists (select 1 from BITACORA_SEG where BITACORA_SEG.FECHA_OPER = @fecha)
	BEGIN
		select
			BITACORA_SEG.CEDULAE,
			BITACORA_SEG.FECHA_OPER,
			BITACORA_SEG.USU_OPER,
			BITACORA_SEG.MAQ_OPER,
			BITACORA_SEG.TABLA_MOD,
			BITACORA_SEG.TIPO_OPER
		from
			BITACORA_SEG
		where
			BITACORA_SEG.FECHA_OPER = @fecha
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
if exists (select 1 from BITACORA_SEG where BITACORA_SEG.TIPO_OPER = @operacion)
	BEGIN
		select
			BITACORA_SEG.CEDULAE,
			BITACORA_SEG.FECHA_OPER,
			BITACORA_SEG.USU_OPER,
			BITACORA_SEG.MAQ_OPER,
			BITACORA_SEG.TABLA_MOD,
			BITACORA_SEG.TIPO_OPER
		from
			BITACORA_SEG
		where
			BITACORA_SEG.FECHA_OPER = @operacion
	END
else
	BEGIN
		select @respuesta = 0
	END
END
go
