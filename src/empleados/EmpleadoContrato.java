package empleados;

/**
 *
 * @author PERSONAL
 */
public class EmpleadoContrato extends Empleado {

    private double mensualidad;

    public EmpleadoContrato(String nombre, String identificacion,
            double salarioBase, double mensualidad) {
        super(nombre, identificacion, salarioBase);
        this.mensualidad = mensualidad;
    }

    @Override
    public double calcularSalarioNeto() {
        double salarioBruto = salarioBase + mensualidad;
        return (salarioBruto * PORCENTAJE_IVA);
    }

    //setter y getter
    public void setMensualidad(double mensualidad) {
        this.mensualidad = mensualidad;
    }

    public double getMensualidad() {
        return mensualidad;
    }
}
