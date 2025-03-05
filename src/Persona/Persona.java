package Persona;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {

    private String DNI;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String direccion;
    private String ciudadProcedencia;

    public Persona(){

    }

    public Persona(String DNI, String nombre, String apellido, Date fechaNacimiento, String direccion, String ciudadProcedencia) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.ciudadProcedencia = ciudadProcedencia;
    }

    protected static Date convertirFechaADate(String fechaString) {
        Date fecha = null;
        try {
            // Usar SimpleDateFormat para parsear la cadena a un objeto Date
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            fecha = formatoFecha.parse(fechaString);  // Parseamos la cadena a un Date
        } catch (Exception e) {
            // Manejar cualquier error que ocurra durante el parseo
            JOptionPane.showMessageDialog(null, "Error al ingresar la fecha. Asegúrese de usar el formato dd/MM/yyyy.");
        }
        return fecha;
    }

    public void imprimirDatosPersona(String datos) {
        datos += "Nombre: " + nombre + "\n";
        datos += "Apellido: " + apellido + "\n";
        datos += "Fecha de Nacimiento: " + fechaNacimiento + "\n";
        datos += "Dirección: " + direccion + "\n";
        datos += "Ciudad de Procedencia: " + ciudadProcedencia + "\n";

        System.out.println(datos);
    }


    public void registrarDatos(){
        DNI =JOptionPane.showInputDialog("Ingrese el DNI:");
        nombre =JOptionPane.showInputDialog("Ingrese el nombre:");
        apellido =JOptionPane.showInputDialog("ingrese el apellido:");

        String fechaString = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (dd/MM/yyyy):");
        fechaNacimiento = convertirFechaADate(fechaString);

        direccion =JOptionPane.showInputDialog("Ingrese la direccion:");
        ciudadProcedencia =JOptionPane.showInputDialog("Ingrese la ciedad de procedencia:");
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudadProcedencia() {
        return ciudadProcedencia;
    }

    public void setCiudadProcedencia(String ciudadProcedencia) {
        this.ciudadProcedencia = ciudadProcedencia;
    }

}
