package Persona;
import Empleado.EmpleadoEventual;
import Empleado.EmpleadoPlanilla;
import Empleado.Medico;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ModeloDatos {

    HashMap<String, Paciente> pacientesMap;
    HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
    HashMap<String, EmpleadoEventual> empleadosEventualMap;
    HashMap<String, Medico> medicosMap;
    ArrayList<CitaMedica> citasList;


    public ModeloDatos(){
        pacientesMap = new HashMap<String, Paciente>();
        empleadosPlanillaMap = new HashMap<String,EmpleadoPlanilla>();
        empleadosEventualMap = new HashMap<String, EmpleadoEventual>();
        medicosMap = new HashMap<String, Medico>();
        citasList = new ArrayList<CitaMedica>();
    }

    public void registrarPersona(Paciente miPaciente){
        pacientesMap.put(miPaciente.getDNI(), miPaciente);
        System.out.println("Se ha registrado el paciente"+miPaciente.getNombre()+" Satisfactoriamente");
    }

    public void registrarPersona(EmpleadoPlanilla miEmpleadoPlanilla){
        empleadosPlanillaMap.put(miEmpleadoPlanilla.getDNI(), miEmpleadoPlanilla);
        System.out.println("Se ha registrado el empleado por planilla"+miEmpleadoPlanilla.getNombre()+" Satisfactoriamente");
    }

    public void registrarPersona(EmpleadoEventual miEmpleadoEventual){
        empleadosEventualMap.put(miEmpleadoEventual.getDNI(), miEmpleadoEventual);
        System.out.println("Se ha registrado el empleado eventual "+miEmpleadoEventual.getNombre()+" Satisfactoriamente");
    }

    public void registrarPersona(Medico miMedico){
        medicosMap.put(miMedico.getDNI(), miMedico);
        System.out.println("Se ha registrado el medico "+miMedico.getNombre()+" Satisfactoriamente");
    }

    public void registrarCitaMedica(CitaMedica miCita) {
        citasList.add(miCita);
        System.out.println("Se ha registrado la cita exitosamente\n");
        System.out.println(miCita.informacionCitaMedica());
    }


    public void imprimirPacientes() {
        String msj = "PACIENTES REGISTRADOS\n";
        Iterator<String> iterador = pacientesMap.keySet().iterator();

        while (iterador.hasNext()) {
            String clave = iterador.next();
            pacientesMap.get(clave).imprimirDatosPersona(msj);
        }
    }

    public void imprimirEmpleadosEventuales() {
        String msj = "EMPLEADOS EVENTUALES REGISTRADOS\n";

        for (String clave : empleadosEventualMap.keySet()) {
            empleadosEventualMap.get(clave).imprimirDatosPersona(msj);
        }
    }

    public void imprimirEmpleadosPorPlanilla() {
        String msj = "EMPLEADOS POR PLANILLA REGISTRADOS\n";

        for (EmpleadoPlanilla empleadoPlanilla : empleadosPlanillaMap.values()) {
            empleadoPlanilla.imprimirDatosPersona(msj);
        }
    }

    public void imprimirMedicos() {
        String msj = "MEDICOS REGISTRADOS\n";

        for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
            System.out.println("Key = " + elemento.getKey() + ", Value = " + elemento.getValue());
            medicosMap.get(elemento.getKey()).imprimirDatosPersona(msj);
            elemento.getValue().imprimirDatosPersona(msj);
        }
    }

    public void imprimirCitasMedicasProgramadas() {
        String msj = "CITAS MEDICAS PROGRAMADAS\n";
        CitaMedica miCita = null;

        System.out.println(msj + "\n");

        if (citasList.size() > 0) {
            for (int i = 0; i < citasList.size(); i++) {
                miCita = citasList.get(i);
                System.out.println(miCita.informacionCitaMedica());
            }
        } else {
            System.out.println("No existen citas programadas");
        }
    }


    public Paciente consultarPacientePorDocumento(String documentoPaciente) {
        Paciente miPaciente = null;

        if (pacientesMap.containsKey(documentoPaciente)) {
            miPaciente = pacientesMap.get(documentoPaciente);
        }

        // Si el paciente existe lo retorna, sino retorna null
        return miPaciente;
    }

    public Medico consultarMedicoPorNombre(String nombreMedico) {
        for (Medico medico : medicosMap.values()) {
            if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
                return medico; // Al retornar, automáticamente termina el ciclo
            }
        }

        // En caso de no encontrar ningún médico, retorna null
        return null;
    }

}
