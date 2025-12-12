import java.util.Date;
import java.util.Objects;

public final class Turno {
    private final Date inicio;
    private Date fin;
    private final Empleado empleado;
    private boolean cerrado;
    private double ventas;

    public Turno(Date inicio, Empleado empleado) {
        this.inicio = (inicio == null) ? new Date() : inicio;
        this.empleado = Objects.requireNonNull(empleado, "Empleado no puede ser nulo");
        this.cerrado = false;
        this.ventas = 0.0;
    }

    public void cerrarTurno() {
        this.fin = new Date();
        this.cerrado = true;
    }

    public double calcularVentasTurno() {
        return ventas;
    }

    public void agregarVenta(double monto) {
        if (monto < 0) throw new IllegalArgumentException("Monto de venta no puede ser negativo");
        this.ventas += monto;
    }

    public boolean isCerrado() { return cerrado; }
    public Empleado getEmpleado() { return empleado; }
    public Date getInicio() { return inicio; }
    public Date getFin() { return fin; }
}