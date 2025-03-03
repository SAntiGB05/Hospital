import Empleado.EmpleadoEventual;
import Empleado.EmpleadoPlanilla;
import Empleado.Medico;
import Persona.ModeloDatos;
import Persona.Paciente;

import javax.swing.*;

public class Procesos {

    ModeloDatos miModeloDatos;

    public Procesos(){
        miModeloDatos = new ModeloDatos();
        precentarMenuOpciones();
    }

    private void precentarMenuOpciones(){

        String menu="MENU HOSPITAL\n\n";
        menu+="1. Registrar Paciente\n";
        menu+="2. Registrar Empleado\n";
        menu+="3. Registrar cita medica\n";
        menu+="4. Imprimir informacon\n";
        menu+="5. Salir\n\n";
        menu+="Ingrese una opcion.";

        int opcion = 0;

        do {
            opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion){
                case 1: registrarPaciente(); break;
                case 2: registrarEmpleado(); break;
                case 3: registrarCitaMedica(); break;
                case 4: imprimirInformacion(); break;
                case 5: System.out.println("El sistema ha terminado!!"); break;
                default: System.out.println("No existe el codigo, verifique de nuevo"); break;
            }
        }while ( opcion!=5);

    }

    private void registrarPaciente(){

        Paciente miPaciente = new Paciente();
        miPaciente.registrarDatos();

        miModeloDatos.registrarPersona(miPaciente);

    }

    private void registrarEmpleado(){

        String menuTipoEmpleado = "Registro de empleado\n";
        menuTipoEmpleado+="1. Empleado eventual\n";
        menuTipoEmpleado+="2. Empleado por planilla\n\n";
        menuTipoEmpleado+="Seleccione el tipo de empleado a registrar\n";

        int tipoEmpleado=Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));

        switch (tipoEmpleado){
            case 1:
                EmpleadoEventual miEmpleadoEventual = new EmpleadoEventual();
                miEmpleadoEventual.registrarDatos();
                miModeloDatos.registrarPersona(miEmpleadoEventual);
                break;
            case 2:
                String resp=JOptionPane.showInputDialog("Ingrese si, si es un medico, de lo contrario es otro tipo de trabajador");
                if (resp.equalsIgnoreCase("si")){
                    Medico miMedico=new Medico();
                    miMedico.registrarDatos();
                    miModeloDatos.registrarPersona(miMedico);
                }else {
                    EmpleadoPlanilla miEmpleadoPlanilla=new EmpleadoPlanilla();
                    miEmpleadoPlanilla.registrarDatos();
                    miModeloDatos.registrarPersona(miEmpleadoPlanilla);
                }
                break;
            default:System.out.println("El tipo de empleado no es valido, intentelo nuevamente");
            break;
        }
    }

    private void registrarCitaMedica(){

    }

    private void imprimirInformacion(){

    }

}
