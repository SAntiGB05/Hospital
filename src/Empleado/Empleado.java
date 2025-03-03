package Empleado;

import Persona.Persona;

import javax.swing.*;
import java.util.Date;

public class Empleado extends Persona {

    private int codEmpleado;
    private int horasExtra;
    private Date fechaIngreso;
    private String area;
    private String cargo;

    public Empleado(){

    }

    public Empleado(int codEmpleado, int horasExtra, Date fechaIngreso, String area, String cargo) {
        this.codEmpleado = codEmpleado;
        this.horasExtra = horasExtra;
        this.fechaIngreso = fechaIngreso;
        this.area = area;
        this.cargo = cargo;
    }

    @Override
    public void registrarDatos() {
        super.registrarDatos();

        codEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo de empleado:"));
        horasExtra = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas extra del empleado:"));

        String fechaString = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (dd/MM/yyyy):");
        fechaIngreso = Persona.convertirFechaADate(fechaString);

        area = JOptionPane.showInputDialog("Ingrese el area del empleado:");
        cargo = JOptionPane.showInputDialog("Ingrese el cargo del empleado");
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Empleado{" +
                "codEmpleado=" + codEmpleado +
                ", horasExtra=" + horasExtra +
                ", fechaIngreso=" + fechaIngreso +
                ", area='" + area + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }


}
