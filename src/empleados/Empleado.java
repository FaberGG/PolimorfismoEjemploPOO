package empleados;

import java.util.LinkedList;

/**
 *
 * @author John Faber Navia Narvaez
 */
public abstract class Empleado {

    private String nombre;
    private String identificacion;
    private LinkedList<String> tareas = new LinkedList<>();;
    protected double salarioBase;
    public static final double PORCENTAJE_IVA = 0.13;

    public Empleado(String nombre, String identificacion, double salarioBase) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.salarioBase = salarioBase;
    }

    //Declracion del metodo abstacto
    public abstract double calcularSalarioNeto();

    //metodo para asignar una tarea
    public void asignarTarea(String tarea) {
        System.out.println("\n----TAREA AGREGADA----");
        System.out.println("Al trabajador " + nombre);
        System.out.print("Se ha asignado una nueva tarea de: " + tarea);
        System.out.println("");
        tareas.add(tarea);
    }

    //metodo sobrecargado para asignar multiples tareas simultaneamente
    public void asignarTarea(LinkedList<String> tareas) {
        System.out.println("\n----TAREAs AGREGADAs----");
        System.out.println("Al trabajador " + nombre);
        System.out.print("Se han asignado las tareas de:");
        for (String tarea : tareas) {
            System.out.println("-" + tarea);
        }
    }

    //setters y getters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public LinkedList<String> getTareas() {
        return tareas;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

}
