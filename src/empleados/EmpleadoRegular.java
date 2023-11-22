package empleados;

/**
 *
 * @author John Faber Navia Narvaez
 */
public class EmpleadoRegular extends Empleado {

    private double deducciones;
    private double bonificacion;

    public EmpleadoRegular(String nombre, String identificacion,
            double salarioBase, double deducciones, double bonificacion) {
        super(nombre, identificacion, salarioBase);
        this.deducciones = deducciones;
        this.bonificacion = bonificacion;
    }

    @Override
    public double calcularSalarioNeto() {
        double salarioBruto = (salarioBase - deducciones);
        salarioBruto += bonificacion;
        return salarioBruto * PORCENTAJE_IVA;
    }

    //setter y getter
    public void setBonificacion(double bonificacion) {
        this.bonificacion = bonificacion;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public double getDeducciones() {
        return deducciones;
    }

    public void setDeducciones(double deducciones) {
        this.deducciones = deducciones;
    }
}
