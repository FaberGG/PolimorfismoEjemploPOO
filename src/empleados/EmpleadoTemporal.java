package empleados;

/**
 *
 * @author John Faber Navia Narvaez
 */
public class EmpleadoTemporal extends Empleado {

    private int horasTrabajadas;
    private double tarifaHora;

    public EmpleadoTemporal(String nombre, String identificacion,
            double salarioBase, int horasTrabajadas, double tarifaHora) {
        super(nombre, identificacion, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
    }

    @Override
    public double calcularSalarioNeto() {
        double salarioBruto = salarioBase + (horasTrabajadas * tarifaHora);
        return salarioBruto - (salarioBruto*PORCENTAJE_IVA );
    }

    //setters y getters
    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public void setTarifaHora(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getTarifaHora() {
        return tarifaHora;
    }
}
