-- 1. Aguinaldo de un empleado

SELECT a.aguinaldo_empleado
FROM EMPLEADO e
inner join Aguinaldo a on e.codigo_empleado = a.codigo_empleado
WHERE DATEDIFF(MONTH, a.anno_pagado, SYSDATETIME()) <= 12
GROUP BY e.codigo_empleado, a.aguinaldo_empleado

-- Funcion
CREATE FUNCTION [dbo].[obtenerAguinaldo] ( @id int)
RETURNS float(10)
AS
BEGIN 
DECLARE @result float(10)
SELECT @result = Tabla.aguinaldo_empleado
FROM( SELECT a.aguinaldo_empleado
		FROM EMPLEADO e
		inner join Aguinaldo a on e.codigo_empleado = a.codigo_empleado
		WHERE (DATEDIFF(MONTH, a.anno_pagado, SYSDATETIME()) <= 12 AND
			@id = e.codigo_empleado)
		GROUP BY e.codigo_empleado, a.aguinaldo_empleado) Tabla
RETURN @result END

-- SELECT [dbo].[obtenerAguinaldo] (1)

-- 2. Monto total pagado en salarios por un periodo de tiempo

SELECT SUM(cp.salario_bruto) "Monto_Total"
FROM EMPLEADO e
inner join CONTENIDO_PLANILLA cp on e.codigo_empleado = cp.codigo_empleado
inner join HISTORICO_PLANILLA hp on cp.id_planilla = hp.id_planilla
WHERE hp.fecha_generada BETWEEN @fechaInicio AND @fechaFinal

-- Funcion
CREATE FUNCTION [dbo].[totalSalarios] ( @fechaInicio date, @fechaFinal date)
RETURNS float(10)
AS
BEGIN 
DECLARE @result float(10)
SELECT @result = Tabla.Monto_Total
FROM( SELECT SUM(cp.salario_bruto) "Monto_Total"
		FROM EMPLEADO e
		inner join CONTENIDO_PLANILLA cp on e.codigo_empleado = cp.codigo_empleado
		inner join HISTORICO_PLANILLA hp on cp.id_planilla = hp.id_planilla
		WHERE hp.fecha_generada BETWEEN @fechaInicio AND @fechaFinal) Tabla
RETURN @result END

-- SELECT [dbo].[totalSalarios] ()

-- 3. Monto total en netos y obligaciones en un periodo de tiempo

SELECT SUM(cp.salario_neto) "Total_Neto", (SUM(cp.salario_bruto) * 0.917) "Total_Obligaciones"
FROM EMPLEADO e
inner join CONTENIDO_PLANILLA cp on e.codigo_empleado = cp.codigo_empleado
inner join HISTORICO_PLANILLA hp on cp.id_planilla = hp.id_planilla
WHERE hp.fecha_generada BETWEEN @fechaInicio AND @fechaFinal

-- Funcion
CREATE FUNCTION [dbo].[totalNetoObligaciones] ( @fechaInicio date, @fechaFinal date)
RETURNS TABLE
AS
RETURN (
SELECT SUM(cp.salario_neto) "Total_Neto", (SUM(cp.salario_bruto) * 0.917) "Total_Obligaciones"
FROM EMPLEADO e
inner join CONTENIDO_PLANILLA cp on e.codigo_empleado = cp.codigo_empleado
inner join HISTORICO_PLANILLA hp on cp.id_planilla = hp.id_planilla
WHERE hp.fecha_generada BETWEEN @fechaInicio AND @fechaFinal);

-- SELECT [dbo].[totalNetoObligaciones] ()


-- 4. Lista de los 10 empleados mejor pagados en un periodo de tiempo

SELECT TOP 10 e.nombre, SUM(cp.salario_neto) "Salario Total"
FROM EMPLEADO e
inner join CONTENIDO_PLANILLA cp on e.codigo_empleado = cp.codigo_empleado
WHERE hp.fecha_generada BETWEEN @fechaInicio AND @fechaFinal
GROUP BY e.nombre

-- Funcion
CREATE FUNCTION [dbo].[top10Empleados] ( @fechaInicio date, @fechaFinal date)
RETURNS TABLE
AS
RETURN (
SELECT TOP 10 e.nombre, SUM(cp.salario_neto) "Salario Total"
FROM EMPLEADO e
inner join CONTENIDO_PLANILLA cp on e.codigo_empleado = cp.codigo_empleado
inner join HISTORICO_PLANILLA hp on cp.Id_Planilla = hp.Id_Planilla
WHERE hp.fecha_generada BETWEEN @fechaInicio AND @fechaFinal
GROUP BY e.nombre); 
GO

-- Select [dbo].[top10Empleados] ()

-- 5. Planta, cantidad de empleados, monto total de salarios brutos pagados,
-- promedio de salarios brutos. Puede ser ordenado por 
-- 1. Planta
-- 2. Cantidad de empleados 
--		2.1 Ascendente
--		2.2 Descendente

SELECT p.id_planta, COUNT(e.codigo_empleado) "Total Empleados",
SUM(cp.salario_bruto) "Total salarios brutos", AVG(cp.salario_bruto) "Promedio salarios brutos"
FROM PLANTA p
inner join HISTORICO_PLANILLA hp on p.id_planta = hp.id_planta
inner join CONTENIDO_PLANILLA cp on hp.id_planilla = cp.id_planilla
GROUP BY p.id_planta
ORDER BY p.id_planta,
		 COUNT(e.codigo_empleado),
		 	ASC
		 COUNT(e.codigo_empleado)
		 	DESC

-- Funcion
CREATE FUNCTION [dbo].[infoPlantas] ( @orden int)
RETURNS TABLE
AS
BEGIN
-- Ordenado por planta
IF @orden = 1
BEGIN
RETURN (
SELECT TOP * p.id_planta, COUNT(e.codigo_empleado) "Total Empleados",
SUM(cp.salario_bruto) "Total salarios brutos", AVG(cp.salario_bruto) "Promedio salarios brutos"
FROM PLANTA p
inner join HISTORICO_PLANILLA hp on p.id_planta = hp.id_planta
inner join CONTENIDO_PLANILLA cp on hp.id_planilla = cp.id_planilla
GROUP BY p.id_planta
ORDER BY p.id_planta);
END
-- Ordenado por cantidad ascendende
IF @orden = 2
BEGIN
RETURN (
SELECT TOP * p.id_planta, COUNT(e.codigo_empleado) "Total Empleados",
SUM(cp.salario_bruto) "Total salarios brutos", AVG(cp.salario_bruto) "Promedio salarios brutos"
FROM PLANTA p
inner join HISTORICO_PLANILLA hp on p.id_planta = hp.id_planta
inner join CONTENIDO_PLANILLA cp on hp.id_planilla = cp.id_planilla
GROUP BY p.id_planta
ORDER BY COUNT(e.codigo_empleado) ASC);
END
-- Ordenado por cantidad descendente
IF @orden = 3
BEGIN
RETURN (
SELECT TOP all p.id_planta, COUNT(e.codigo_empleado) "Total Empleados",
SUM(cp.salario_bruto) "Total salarios brutos", AVG(cp.salario_bruto) "Promedio salarios brutos"
FROM PLANTA p
inner join HISTORICO_PLANILLA hp on p.id_planta = hp.id_planta
inner join CONTENIDO_PLANILLA cp on hp.id_planilla = cp.id_planilla
GROUP BY p.id_planta
ORDER BY COUNT(e.codigo_empleado) DESC);
END
END

-- 6. Consulta de todo el histórico de un empleado, de todos los pagos que se le han realizado.

SELECT e.nombre, cp.salario_neto
FROM EMPLEADO e
inner join CONTENIDO_PLANILLA cp on e.codigo_empleado = cp.codigo_empleado
GROUP BY e.nombre, cp.salario_neto

-- Funcion
CREATE FUNCTION [dbo].[historicoEmpleado] ( @id int)
RETURNS TABLE
AS
RETURN (
SELECT e.nombre, cp.salario_neto
FROM EMPLEADO e
inner join CONTENIDO_PLANILLA cp on e.codigo_empleado = cp.codigo_empleado
WHERE @id = e.codigo_empleado
GROUP BY e.nombre, cp.salario_neto);

-- SELECT [dbo].[historicoEmpleado] ()