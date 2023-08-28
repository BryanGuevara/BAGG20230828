<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Empleado</title>
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
        form {
            width: 50%;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            border: 1px solid #ddd;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }
        label, input {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
        }
        button {
            background-color: #333;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <h1>Crear Empleado</h1>
    <form action="EmpleadoServlet?action=create" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido" required>
        <label for="correoElectronico">Correo Electrónico:</label>
        <input type="text" id="correoElectronico" name="correoElectronico" required>
        <label for="puestoDelEmpleado">Puesto del Empleado:</label>
        <input type="text" id="puestoDelEmpleado" name="puestoDelEmpleado" required>
        <button type="submit">Crear Empleado</button>
    </form>
</body>
</html>
