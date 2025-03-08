package Persona;

import Empleado.EmpleadoEventual;
import Empleado.EmpleadoPlanilla;
import Empleado.Medico;

import java.util.ArrayList;
import java.util.HashMap;

public class ModeloDatos {

    // Atributos privados
    private HashMap<String, Paciente> pacientesMap;
    private HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
    private HashMap<String, EmpleadoEventual> empleadosEventualMap;
    private HashMap<String, Medico> medicosMap;
    private ArrayList<CitaMedica> citasList;

    public ModeloDatos() {
        pacientesMap = new HashMap<>();
        empleadosPlanillaMap = new HashMap<>();
        empleadosEventualMap = new HashMap<>();
        medicosMap = new HashMap<>();
        citasList = new ArrayList<>();
    }

    // Métodos para registrar personas
    public void registrarPersona(Paciente miPaciente) {
        if (pacientesMap.containsKey(miPaciente.getDNI())) {
            System.out.println("El paciente ya está registrado.");
        } else {
            pacientesMap.put(miPaciente.getDNI(), miPaciente);
            System.out.println("Se ha registrado el paciente " + miPaciente.getNombre() + " satisfactoriamente.");
        }
    }

    public void registrarPersona(EmpleadoPlanilla miEmpleadoPlanilla) {
        if (empleadosPlanillaMap.containsKey(miEmpleadoPlanilla.getDNI())) {
            System.out.println("El empleado por planilla ya está registrado.");
        } else {
            empleadosPlanillaMap.put(miEmpleadoPlanilla.getDNI(), miEmpleadoPlanilla);
            System.out.println("Se ha registrado el empleado por planilla " + miEmpleadoPlanilla.getNombre() + " satisfactoriamente.");
        }
    }

    public void registrarPersona(EmpleadoEventual miEmpleadoEventual) {
        if (empleadosEventualMap.containsKey(miEmpleadoEventual.getDNI())) {
            System.out.println("El empleado eventual ya está registrado.");
        } else {
            empleadosEventualMap.put(miEmpleadoEventual.getDNI(), miEmpleadoEventual);
            System.out.println("Se ha registrado el empleado eventual " + miEmpleadoEventual.getNombre() + " satisfactoriamente.");
        }
    }

    public void registrarPersona(Medico miMedico) {
        if (medicosMap.containsKey(miMedico.getDNI())) {
            System.out.println("El médico ya está registrado.");
        } else {
            medicosMap.put(miMedico.getDNI(), miMedico);
            System.out.println("Se ha registrado el médico " + miMedico.getNombre() + " satisfactoriamente.");
        }
    }

    // Método para registrar citas médicas
    public void registrarCitaMedica(CitaMedica miCita) {
        citasList.add(miCita);
        System.out.println("Se ha registrado la cita exitosamente\n");
        System.out.println(miCita.informacionCitaMedica());
    }

    // Métodos para verificar si hay datos registrados
    public boolean hayPacientesRegistrados() {
        return !pacientesMap.isEmpty();
    }

    public boolean hayEmpleadosEventualesRegistrados() {
        return !empleadosEventualMap.isEmpty();
    }

    public boolean hayEmpleadosPorPlanillaRegistrados() {
        return !empleadosPlanillaMap.isEmpty();
    }

    public boolean hayMedicosRegistrados() {
        return !medicosMap.isEmpty();
    }

    public boolean hayCitasRegistradas() {
        return !citasList.isEmpty();
    }

    // Métodos para imprimir información
    public void imprimirPacientes() {
        String msj = "PACIENTES REGISTRADOS\n";
        for (Paciente paciente : pacientesMap.values()) {
            paciente.imprimirDatosPersona(msj);
        }
    }

    public void imprimirEmpleadosEventuales() {
        String msj = "EMPLEADOS EVENTUALES REGISTRADOS\n";
        for (EmpleadoEventual empleadoEventual : empleadosEventualMap.values()) {
            empleadoEventual.imprimirDatosPersona(msj);
        }
    }

    public void imprimirEmpleadosPorPlanilla() {
        String msj = "EMPLEADOS POR PLANILLA REGISTRADOS\n";

        if (empleadosPlanillaMap.isEmpty() && medicosMap.isEmpty()) {
            System.out.println("No hay empleados por planilla ni médicos registrados.");
            return;
        }

        for (EmpleadoPlanilla empleadoPlanilla : empleadosPlanillaMap.values()) {
            empleadoPlanilla.imprimirDatosPersona(msj);
        }

        for (Medico medico : medicosMap.values()) {
            msj = "MÉDICO REGISTRADO\n";
            medico.imprimirDatosPersona(msj);
        }
    }

    public void imprimirMedicos() {
        String msj = "MÉDICOS REGISTRADOS\n";
        for (Medico medico : medicosMap.values()) {
            medico.imprimirDatosPersona(msj);
        }
    }

    public void imprimirCitasMedicasProgramadas() {
        String msj = "CITAS MÉDICAS PROGRAMADAS\n";
        if (citasList.isEmpty()) {
            System.out.println("No hay citas médicas programadas.");
        } else {
            for (CitaMedica cita : citasList) {
                System.out.println(cita.informacionCitaMedica());
            }
        }
    }

    // Métodos para consultar personas por documento
    public Paciente consultarPacientePorDocumento(String documentoPaciente) {
        return pacientesMap.get(documentoPaciente);
    }

    public EmpleadoEventual consultarEmpleadoEventualPorDocumento(String documentoEmpleado) {
        return empleadosEventualMap.get(documentoEmpleado);
    }

    public EmpleadoPlanilla consultarEmpleadoPlanillaPorDocumento(String documentoEmpleado) {
        return empleadosPlanillaMap.get(documentoEmpleado);
    }

    public Medico consultarMedicoPorDocumento(String documentoMedico) {
        return medicosMap.get(documentoMedico);
    }

    // Método para consultar médico por nombre
    public Medico consultarMedicoPorNombre(String nombreMedico) {
        for (Medico medico : medicosMap.values()) {
            if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
                return medico;
            }
        }
        return null;
    }
}