package bagg20230828.accesoadatos;
import bagg20230828.entidadesdenegocio.Empleado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComunDB {
      private Connection connection;

    public ComunDB() {
        // Inicializa la conexión a la base de datos
        try {
            String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=Empresa;";
            String username = "";
            String password = "";
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearEmpleado(Empleado empleado) {
        try {
            String sql = "INSERT INTO Empleados (Nombre, Apellido, CorreoElectronico, PuestoDelEmpleado) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getApellido());
            statement.setString(3, empleado.getCorreoElectronico());
            statement.setString(4, empleado.getPuestoDelEmpleado());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarEmpleado(Empleado empleado) {
        try {
            String sql = "UPDATE Empleados SET Nombre = ?, Apellido = ?, CorreoElectronico = ?, PuestoDelEmpleado = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getApellido());
            statement.setString(3, empleado.getCorreoElectronico());
            statement.setString(4, empleado.getPuestoDelEmpleado());
            statement.setInt(5, empleado.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Empleado> obtenerListaEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Empleados";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(resultSet.getInt("Id"));
                empleado.setNombre(resultSet.getString("Nombre"));
                empleado.setApellido(resultSet.getString("Apellido"));
                empleado.setCorreoElectronico(resultSet.getString("CorreoElectronico"));
                empleado.setPuestoDelEmpleado(resultSet.getString("PuestoDelEmpleado"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }
     public Empleado obtenerEmpleadoPorId(int id) {
        Empleado empleado = null;
        try {
            String sql = "SELECT * FROM Empleados WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                empleado = new Empleado();
                empleado.setId(resultSet.getInt("Id"));
                empleado.setNombre(resultSet.getString("Nombre"));
                empleado.setApellido(resultSet.getString("Apellido"));
                empleado.setCorreoElectronico(resultSet.getString("CorreoElectronico"));
                empleado.setPuestoDelEmpleado(resultSet.getString("PuestoDelEmpleado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleado;
    }
}
