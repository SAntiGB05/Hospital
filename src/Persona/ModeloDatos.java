package Persona;
import Empleado.EmpleadoEventual;
import Empleado.EmpleadoPlanilla;
import Empleado.Medico;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public class ModeloDatos {

    HashMap<String, Paciente> pacientesMap;
    HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
    HashMap<String, EmpleadoEventual> empleadosEventualMap;
    HashMap<String, Medico> medicosMap;



    public ModeloDatos(){
        pacientesMap = new HashMap<String, Paciente>();
        empleadosPlanillaMap = new HashMap<String,EmpleadoPlanilla>();
        empleadosEventualMap = new HashMap<String, EmpleadoEventual>();
        medicosMap = new HashMap<String, Medico>();
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

}
