import Empleado.EmpleadoEventual;
import Empleado.EmpleadoPlanilla;
import Empleado.Medico;
import Persona.CitaMedica;
import Persona.ModeloDatos;
import Persona.Paciente;

import javax.swing.*;

public class Procesos {

    private ModeloDatos miModeloDatos;

    public Procesos() {
        miModeloDatos = new ModeloDatos();
        precentarMenuOpciones();
    }

    private void precentarMenuOpciones() {
        String menu = "MENU HOSPITAL\n\n";
        menu += "1. Registrar Paciente\n";
        menu += "2. Registrar Empleado\n";
        menu += "3. Registrar cita medica\n";
        menu += "4. Imprimir informacion\n";
        menu += "5. Consultar persona por documento\n";
        menu += "6. Salir\n\n";
        menu += "Ingrese una opcion.";

        int opcion = 0;

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcion) {
                    case 1:
                        registrarPaciente();
                        break;
                    case 2:
                        registrarEmpleado();
                        break;
                    case 3:
                        registrarCitaMedica();
                        break;
                    case 4:
                        imprimirInformacion();
                        break;
                    case 5:
                        consultarPersonaPorDocumento();
                        break;
                    case 6:
                        System.out.println("El sistema ha terminado!!");
                        break;
                    default:
                        System.out.println("No existe el codigo, verifique de nuevo");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
            }
        } while (opcion != 6);
    }

    private void registrarPaciente() {
        Paciente miPaciente = new Paciente();
        miPaciente.registrarDatos();
        miModeloDatos.registrarPersona(miPaciente);
    }

    private void registrarEmpleado() {
        String menuTipoEmpleado = "Registro de Empleado\n";
        menuTipoEmpleado += "1. Empleado Eventual\n";
        menuTipoEmpleado += "2. Empleado por Planilla\n";
        menuTipoEmpleado += "Seleccione el tipo de empleado a registrar\n";

        int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));

        switch (tipoEmpleado) {
            case 1:
                EmpleadoEventual miEmpleadoEventual = new EmpleadoEventual();
                miEmpleadoEventual.registrarDatos();
                miModeloDatos.registrarPersona(miEmpleadoEventual);
                break;
            case 2:
                String respuesta = JOptionPane.showInputDialog("Ingrese 'sí' si es un médico, de lo contrario es otro tipo de empleado");

                if (respuesta.equalsIgnoreCase("sí")) {
                    Medico miMedico = new Medico();
                    miMedico.registrarDatos();
                    miModeloDatos.registrarPersona(miMedico);
                } else {
                    EmpleadoPlanilla miEmpleadoPlanilla = new EmpleadoPlanilla();
                    miEmpleadoPlanilla.registrarDatos();
                    miModeloDatos.registrarPersona(miEmpleadoPlanilla);
                }
                break;
            default:
                System.out.println("El tipo de empleado no es válido, inténtelo nuevamente.");
                break;
        }
    }

    private void registrarCitaMedica() {
        String documentoPaciente = JOptionPane.showInputDialog("Ingrese el documento del paciente");
        Paciente pacienteEncontrado = miModeloDatos.consultarPacientePorDocumento(documentoPaciente);

        if (pacienteEncontrado != null) {
            String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del médico");
            Medico medicoEncontrado = miModeloDatos.consultarMedicoPorNombre(nombreMedico);

            if (medicoEncontrado != null) {
                String servicio = JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");
                String fechaConsulta = JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
                String horaConsulta = JOptionPane.showInputDialog("Ingrese la hora de la consulta");

                String lugar = "La cita será en el consultorio " + medicoEncontrado.getNumeroConsultorio();

                CitaMedica miCita = new CitaMedica(pacienteEncontrado, medicoEncontrado, servicio, fechaConsulta, horaConsulta, lugar);
                miModeloDatos.registrarCitaMedica(miCita);
            } else {
                System.out.println("El médico no se encuentra registrado en el sistema");
            }
        } else {
            System.out.println("El paciente no se encuentra registrado en el sistema");
        }
    }

    private void imprimirInformacion() {
        String menuImprimir = "MENU IMPRESIONES\n";
        menuImprimir += "1. Listar Pacientes\n";
        menuImprimir += "2. Listar Empleados Eventuales\n";
        menuImprimir += "3. Listar Empleados Por Planilla\n";
        menuImprimir += "4. Listar Medicos\n";
        menuImprimir += "5. Listar citas programadas\n";
        menuImprimir += "Ingrese una opción\n";

        System.out.println("**********************************************************");

        int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));

        switch (opcion) {
            case 1:
                if (miModeloDatos.hayPacientesRegistrados()) {
                    miModeloDatos.imprimirPacientes();
                } else {
                    System.out.println("No hay pacientes registrados.");
                }
                break;
            case 2:
                if (miModeloDatos.hayEmpleadosEventualesRegistrados()) {
                    miModeloDatos.imprimirEmpleadosEventuales();
                } else {
                    System.out.println("No hay empleados eventuales registrados.");
                }
                break;
            case 3:
                if (miModeloDatos.hayEmpleadosPorPlanillaRegistrados() || miModeloDatos.hayMedicosRegistrados()) {
                    miModeloDatos.imprimirEmpleadosPorPlanilla();
                } else {
                    System.out.println("No hay empleados por planilla ni médicos registrados.");
                }
                break;
            case 4:
                if (miModeloDatos.hayMedicosRegistrados()) {
                    miModeloDatos.imprimirMedicos();
                } else {
                    System.out.println("No hay médicos registrados.");
                }
                break;
            case 5:
                if (miModeloDatos.hayCitasRegistradas()) {
                    miModeloDatos.imprimirCitasMedicasProgramadas();
                } else {
                    System.out.println("No hay citas médicas programadas.");
                }
                break;
            default:
                System.out.println("No existe esa opción");
                break;
        }
    }

    private void consultarPersonaPorDocumento() {
        String documento = JOptionPane.showInputDialog("Ingrese el documento de identidad:");

        Paciente paciente = miModeloDatos.consultarPacientePorDocumento(documento);
        if (paciente != null) {
            paciente.imprimirDatosPersona("Información del Paciente:\n");
            return;
        }

        EmpleadoEventual empleadoEventual = miModeloDatos.consultarEmpleadoEventualPorDocumento(documento);
        if (empleadoEventual != null) {
            empleadoEventual.imprimirDatosPersona("Información del Empleado Eventual:\n");
            return;
        }

        EmpleadoPlanilla empleadoPlanilla = miModeloDatos.consultarEmpleadoPlanillaPorDocumento(documento);
        if (empleadoPlanilla != null) {
            empleadoPlanilla.imprimirDatosPersona("Información del Empleado por Planilla:\n");
            return;
        }

        Medico medico = miModeloDatos.consultarMedicoPorDocumento(documento);
        if (medico != null) {
            medico.imprimirDatosPersona("Información del Médico:\n");
            return;
        }

        System.out.println("No se encontró ninguna persona con el documento ingresado.");
    }
}