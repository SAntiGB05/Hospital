package Empleado;

import javax.swing.*;
import java.util.Date;

public class EmpleadoEventual extends Empleado {
    private double honorariosPorHora;
    private String fechaTerminoContrato;

    public EmpleadoEventual(){

    }

    public EmpleadoEventual(double honorariosPorHora, String fechaTerminoContrato) {
        this.honorariosPorHora = honorariosPorHora;
        this.fechaTerminoContrato = fechaTerminoContrato;
    }

    public EmpleadoEventual(int codEmpleado, int horasExtra, Date fechaIngreso, String area, String cargo, double honorariosPorHora, String fechaTerminoContrato) {
        super(codEmpleado, horasExtra, fechaIngreso, area, cargo);
        this.honorariosPorHora = honorariosPorHora;
        this.fechaTerminoContrato = fechaTerminoContrato;
    }

    @Override
    public void registrarDatos() {
        super.registrarDatos();
        honorariosPorHora = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el honorario por hora del empleado"));
        fechaTerminoContrato = JOptionPane.showInputDialog("Ingrese la fecha del final de contrato del empleado");
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);

        datos = "Honorarios por Hora: " + honorariosPorHora + "\n";
        datos += "Fecha Término del Contrato: " + fechaTerminoContrato + "\n";

        System.out.println(datos);
    }


    public double getHonorariosPorHora() {
        return honorariosPorHora;
    }

    public void setHonorariosPorHora(double honorariosPorHora) {
        this.honorariosPorHora = honorariosPorHora;
    }

    public String getFechaTerminoContrato() {
        return fechaTerminoContrato;
    }

    public void setFechaTerminoContrato(String fechaTerminoContrato) {
        this.fechaTerminoContrato = fechaTerminoContrato;
    }

    @Override
    public String toString() {
        return super.toString()+
                "EmpleadoEventual{" +
                "DNI='" + getDNI() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", fechaNacimiento=" + getFechaNacimiento() +
                "honorariosPorHora=" + honorariosPorHora +
                ", fechaTerminoContrato='" + fechaTerminoContrato + '\'' +
                '}';
    }
}
