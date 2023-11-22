package parcialpoo;

import empleados.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author John Faber Navia Narvaez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //creo la lista de objetos empleado
        LinkedList<Empleado> objetos = new LinkedList<>();
        //se crean los objetos empleados
        EmpleadoRegular empleado1 = new EmpleadoRegular("Juan", "10453", 800, 50, 120);
        EmpleadoRegular empleado2 = new EmpleadoRegular("Alberto", "10232", 1000, 250, 100);
        EmpleadoTemporal empleado3 = new EmpleadoTemporal("Luis", "10643", 900, 35, 30);
        EmpleadoTemporal empleado4 = new EmpleadoTemporal("Marcos", "10998", 600, 40, 20);
        EmpleadoContrato empleado5 = new EmpleadoContrato("Marcos", "10676", 800, 400);

        //se añaden los objetos a la lista
        objetos.add(empleado1);
        objetos.add(empleado2);
        objetos.add(empleado3);
        objetos.add(empleado4);
        objetos.add(empleado5);

        //se imprimen los empleados en la lista
        imprimirEmpleados(objetos);

        // calcular el salario para un empleado especifico
        System.out.println("\n--------------------------------");
        System.out.println("CALCULAR SALARIO DE UN TRABAJADOR:");
        System.out.println("--------------------------------");

        System.out.println("\nTotal descontado por la empresa " + Empleado.PORCENTAJE_IVA);
        System.out.println("De cual trabajador desea calcular su salario neto? ");
        System.out.print("  Ingese el numero (indice) de trabajador: ");
        int opcion = input.nextInt();

        if (opcion < 0 || opcion >= objetos.size()) {
            System.out.println("Número de trabajador fuera de rango. Por favor, ingrese un número válido.");
        } else {
            System.out.println("\nEl salario del trabajador " + objetos.get(opcion).getNombre() + " es:");
            System.out.println("Salario Base:       " + objetos.get(opcion).getSalarioBase());
            System.out.println("Salario Neto:       " + objetos.get(opcion).calcularSalarioNeto());
        }

        // agregar tareas a un empleado especifico
        LinkedList<String> tareas = new LinkedList<>();
        //se añade a la lista las tareas por defecto para un trabajador
        tareas.add("Documentar");
        tareas.add("Generar informe");
        tareas.add("Enviar reporte");
        tareas.add("Crear presentacion");

        //se añaden las tareas a un trabajador usando polimorfismo
        objetos.get(opcion).asignarTarea(tareas);

        //agregar una unica tarea:

        String tarea = "Cambiar Entorno de Desarrollo";
        //asigna la unica tarea al trabajador
        objetos.get(opcion).asignarTarea(tarea);
        
        
        //FIN DEL MAIN
    }

    
    // metodo que imprime todos los empleados
    public static void imprimirEmpleados(LinkedList<Empleado> objetos) {
        //obtener empleados por hora
        System.out.println("\n--------------------------------");
        System.out.println("LOS EMPLEADOS TEMPORALES:");
        System.out.println("--------------------------------");

        for (Empleado empleado : objetos) {
            if (empleado instanceof EmpleadoTemporal empleadoPorHoras) {
                System.out.println("\n---Trabajador temporal---");
                System.out.println(" Nombre:               " + empleadoPorHoras.getNombre());
                System.out.println(" Salario:              " + empleadoPorHoras.getSalarioBase());
                System.out.println(" Horas trabajadas:     " + empleadoPorHoras.getHorasTrabajadas());
                System.out.println(" Tarifa por hora:      " + empleadoPorHoras.getTarifaHora());
            }
        }
        // obtener empleados regulares        
        System.out.println("\n--------------------------------");
        System.out.println("LOS EMPLEADOS REGULARES:");
        System.out.println("--------------------------------");
        for (Empleado empleado : objetos) {
            if (empleado instanceof EmpleadoRegular empleadoRegular) {
                System.out.println("\n---Trabajador con salario fijo---");
                System.out.println(" Nombre:               " + empleadoRegular.getNombre());
                System.out.println("Salario:               " + empleadoRegular.getSalarioBase());
                System.out.println("Deducciones:           " + empleadoRegular.getDeducciones());
            }
        }

        // obtener empleados por contrato       
        System.out.println("\n--------------------------------");
        System.out.println("LOS EMPLEADOS POR CONTRATO:");
        System.out.println("--------------------------------");
        for (Empleado empleado : objetos) {
            if (empleado instanceof EmpleadoContrato empleadoContrato) {
                System.out.println("\n---Trabajador con salario fijo---");
                System.out.println(" Nombre:               " + empleadoContrato.getNombre());
                System.out.println("Salario base:          " + empleadoContrato.getSalarioBase());
                System.out.println("Mensualidad:           " + empleadoContrato.getMensualidad());

            }
        }
    }
}
