package Empleado;

import javax.swing.*;
import java.util.Date;

public class Medico extends EmpleadoPlanilla{
    private String especialidad;
    private int numeroConsultorio;

    public Medico(){

    }

    public Medico(String especialidad, int numeroConsultorio) {
        this.especialidad = especialidad;
        this.numeroConsultorio = numeroConsultorio;
    }

    public Medico(double salarioMensual, double porcentajeAdicionalPorHoraExtra, String especialidad, int numeroConsultorio) {
        super(salarioMensual, porcentajeAdicionalPorHoraExtra);
        this.especialidad = especialidad;
        this.numeroConsultorio = numeroConsultorio;
    }

    public Medico(int codEmpleado, int horasExtra, Date fechaIngreso, String area, String cargo, double salarioMensual, double porcentajeAdicionalPorHoraExtra, String especialidad, int numeroConsultorio) {
        super(codEmpleado, horasExtra, fechaIngreso, area, cargo, salarioMensual, porcentajeAdicionalPorHoraExtra);
        this.especialidad = especialidad;
        this.numeroConsultorio = numeroConsultorio;
    }

    @Override
    public void registrarDatos() {
        super.registrarDatos();
        especialidad = JOptionPane.showInputDialog("Ingrese la especialidad del medico");
        numeroConsultorio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero del consultorio"));
    }

    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }

    public void setNumeroConsultorio(int numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Medico{" +
                "especialidad='" + especialidad + '\'' +
                ", numeroConsultorio=" + numeroConsultorio +
                '}';
    }
}
