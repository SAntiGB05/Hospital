package Empleado;

import javax.swing.*;
import java.util.Date;

public class EmpleadoPlanilla extends Empleado {
    private double salarioMensual;
    private double porcentajeAdicionalPorHoraExtra;

    public EmpleadoPlanilla(){

    }

    public EmpleadoPlanilla(double salarioMensual, double porcentajeAdicionalPorHoraExtra) {
        this.salarioMensual = salarioMensual;
        this.porcentajeAdicionalPorHoraExtra = porcentajeAdicionalPorHoraExtra;
    }

    public EmpleadoPlanilla(int codEmpleado, int horasExtra, Date fechaIngreso, String area, String cargo, double salarioMensual, double porcentajeAdicionalPorHoraExtra) {
        super(codEmpleado, horasExtra, fechaIngreso, area, cargo);
        this.salarioMensual = salarioMensual;
        this.porcentajeAdicionalPorHoraExtra = porcentajeAdicionalPorHoraExtra;
    }

    @Override
    public void registrarDatos() {
        super.registrarDatos();
        salarioMensual = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario mensual del empleado"));
        porcentajeAdicionalPorHoraExtra = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el porcentaje adicional por horas extra del empleado"));
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);

        datos = "Salario Mensual: " + salarioMensual + "\n";
        datos += "Porcentaje Adicional Por Hora Extra: " + porcentajeAdicionalPorHoraExtra + "\n";

        System.out.println(datos);
    }


    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public double getPorcentajeAdicionalPorHoraExtra() {
        return porcentajeAdicionalPorHoraExtra;
    }

    public void setPorcentajeAdicionalPorHoraExtra(double porcentajeAdicionalPorHoraExtra) {
        this.porcentajeAdicionalPorHoraExtra = porcentajeAdicionalPorHoraExtra;
    }

    @Override
    public String toString() {
        return super.toString()+
                "EmpleadoPlanilla{" +
                "salarioMensual=" + salarioMensual +
                ", porcentajeAdicionalPorHoraExtra=" + porcentajeAdicionalPorHoraExtra +
                '}';
    }

}
