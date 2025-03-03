package Persona;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Paciente extends Persona{

    private int numHistoriaClinica;
    private String sexo;
    private String GrupSangineo;
    private String alergias;
    private ArrayList<String> medicamentos;

    public Paciente(){

    }

    public Paciente(int numHistoriaClinica, String sexo, String grupSangineo, String alergias, ArrayList<String> medicamentos) {
        this.numHistoriaClinica = numHistoriaClinica;
        this.sexo = sexo;
        GrupSangineo = grupSangineo;
        this.alergias = alergias;
        this.medicamentos = medicamentos;
    }

    @Override
    public void registrarDatos() {
        super.registrarDatos();
        numHistoriaClinica = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de historia clinica:"));
        sexo = JOptionPane.showInputDialog("Ingrese el sexo del paciente");
        GrupSangineo = JOptionPane.showInputDialog("Ingrese el grupo sangineo del paciente");

        // Ingreso de alergias como una cadena de texto
        alergias = JOptionPane.showInputDialog("Ingrese las alergias del paciente (separe las alergias por espacio)");
        // Convertimos las alergias en un ArrayList y las asignamos al ArrayList 'medicamentos'
        medicamentos = new ArrayList<>(Arrays.asList(alergias.split(" ")));
    }

    public int getNumHistoriaClinica() {
        return numHistoriaClinica;
    }

    public void setNumHistoriaClinica(int numHistoriaClinica) {
        this.numHistoriaClinica = numHistoriaClinica;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGrupSangineo() {
        return GrupSangineo;
    }

    public void setGrupSangineo(String grupSangineo) {
        GrupSangineo = grupSangineo;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
        // Aquí se llena el ArrayList medicamentos con las alergias, pero no hace falta separar nuevamente.
        this.medicamentos = new ArrayList<>(Arrays.asList(alergias.split(" ")));
    }

    @Override
    public String toString() {
        return super.toString()+
                "Paciente{" +
                "numHistoriaClinica=" + numHistoriaClinica +
                ", sexo='" + sexo + '\'' +
                ", GrupSangineo='" + GrupSangineo + '\'' +
                ", alergias='" + alergias + '\'' +
                ", medicamentos=" + medicamentos +
                '}';
    }
}
