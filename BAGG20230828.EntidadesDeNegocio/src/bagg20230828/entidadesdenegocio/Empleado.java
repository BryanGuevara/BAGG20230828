package bagg20230828.entidadesdenegocio;

public class Empleado {

    private int id;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String puestoDelEmpleado;

    // Constructor, getters y setters

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String correoElectronico, String puestoDelEmpleado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.puestoDelEmpleado = puestoDelEmpleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPuestoDelEmpleado() {
        return puestoDelEmpleado;
    }

    public void setPuestoDelEmpleado(String puestoDelEmpleado) {
        this.puestoDelEmpleado = puestoDelEmpleado;
    }
}

