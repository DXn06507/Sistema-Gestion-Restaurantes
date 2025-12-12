import java.util.Objects;

public final class Desempeno {
    private final Empleado empleado;
    private final Turno turno;
    private int pedidosAtendidos;
    private double propinas;

    public Desempeno(Empleado empleado, Turno turno) {
        this.empleado = Objects.requireNonNull(empleado, "Empleado no puede ser nulo");
        this.turno = Objects.requireNonNull(turno, "Turno no puede ser nulo");
        this.pedidosAtendidos = 0;
        this.propinas = 0.0;
    }

    public void registrarPedidoAtendido() {
        this.pedidosAtendidos++;
    }

    public void registrarPropina(double monto) {
        if (monto < 0) throw new IllegalArgumentException("Propina no puede ser negativa");
        this.propinas += monto;
    }

    public int getPedidosAtendidos() { return pedidosAtendidos; }
    public double getPropinas() { return propinas; }
}