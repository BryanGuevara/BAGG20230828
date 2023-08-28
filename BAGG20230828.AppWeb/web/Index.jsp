<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Empleados</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        h1 {
            background-color: #333;
            color: white;
            padding: 10px;
            margin: 0;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            border: 1px solid #ddd;
            background-color: white;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        tr:hover {
            background-color: #f2f2f2;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h1>Lista de Empleados</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Correo Electrónico</th>
            <th>Puesto del Empleado</th>
        </tr>
        <c:forEach var="empleado" items="${empleados}">
            <tr>
                <td>${empleado.id}</td>
                <td>${empleado.nombre}</td>
                <td>${empleado.apellido}</td>
                <td>${empleado.correoElectronico}</td>
                <td>${empleado.puestoDelEmpleado}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="EmpleadoServlet?action=create">Crear Nuevo Empleado</a>
</body>
</html>
