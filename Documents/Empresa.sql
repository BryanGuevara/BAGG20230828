CREATE DATABASE Empresa;

use Empresa;

CREATE TABLE Empleados(
Id int Identity (1,1) Primary key,
Nombre Varchar,
Apellido Varchar,
CorreoElectronico Varchar,
PuestoDelEmpleado Varchar
);
