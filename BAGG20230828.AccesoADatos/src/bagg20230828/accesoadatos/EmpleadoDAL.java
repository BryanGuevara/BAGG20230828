package bagg20230828.accesoadatos;

import bagg20230828.entidadesdenegocio.Empleado;
import java.util.List;

public class EmpleadoDAL {

    private ComunDB comunDB;

    public EmpleadoDAL() {
        this.comunDB = new ComunDB();
    }

    public void crearEmpleado(Empleado empleado) {
        comunDB.crearEmpleado(empleado);
    }

    public void editarEmpleado(Empleado empleado) {
        comunDB.editarEmpleado(empleado);
    }

    public List<Empleado> obtenerListaEmpleados() {
        return comunDB.obtenerListaEmpleados();
    }
    
     public Empleado obtenerEmpleadoPorId(int id) {
        return comunDB.obtenerEmpleadoPorId(id);
    }
}
