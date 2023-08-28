package controller;

import bagg20230828.accesoadatos.EmpleadoDAL;
import bagg20230828.entidadesdenegocio.Empleado;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private EmpleadoDAL empleadoDAO;

    public EmpleadoServlet() {
        super();
        empleadoDAO = new EmpleadoDAL();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listarEmpleados(request, response);
                break;
            case "edit":
                mostrarFormularioEdicion(request, response);
                break;
            default:
                listarEmpleados(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                crearEmpleado(request, response);
                break;
            case "update":
                editarEmpleado(request, response);
                break;
            default:
                listarEmpleados(request, response);
        }
    }

    private void listarEmpleados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Empleado> empleados = empleadoDAO.obtenerListaEmpleados();
        request.setAttribute("empleados", empleados);
        request.getRequestDispatcher("lista_empleados.jsp").forward(request, response);
    }

    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int empleadoId = Integer.parseInt(request.getParameter("id"));
        Empleado empleado = empleadoDAO.obtenerEmpleadoPorId(empleadoId);
        request.setAttribute("empleado", empleado);
        request.getRequestDispatcher("editar_empleado.jsp").forward(request, response);
    }

    private void crearEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correoElectronico = request.getParameter("correoElectronico");
        String puestoDelEmpleado = request.getParameter("puestoDelEmpleado");

        Empleado nuevoEmpleado = new Empleado(nombre, apellido, correoElectronico, puestoDelEmpleado);
        empleadoDAO.crearEmpleado(nuevoEmpleado);

        response.sendRedirect("EmpleadoServlet");
    }

    private void editarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correoElectronico = request.getParameter("correoElectronico");
        String puestoDelEmpleado = request.getParameter("puestoDelEmpleado");

        Empleado empleadoActualizado = new Empleado(nombre, apellido, correoElectronico, puestoDelEmpleado);
        empleadoDAO.editarEmpleado(empleadoActualizado);

        response.sendRedirect("EmpleadoServlet");
    }
}
