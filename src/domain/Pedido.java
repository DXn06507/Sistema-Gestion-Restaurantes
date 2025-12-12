import java.util.*;
import java.util.Date;

public final class Pedido {
    private final int idPedido;
    private final Date fechaHora;
    private final List<Plato> platos;
    private final Mesa mesa;
    private final Empleado mesero;
    private boolean pagado;
    private double costo;

    public Pedido(int idPedido, Date fechaHora, Mesa mesa, Empleado mesero) {
        if (idPedido <= 0) throw new IllegalArgumentException("ID inválido");
        this.idPedido = idPedido;
        this.fechaHora = (fechaHora == null) ? new Date() : fechaHora;
        this.mesa = mesa;
        this.mesero = mesero;
        this.platos = new ArrayList<>();
        this.costo = 0.0;
    }

    public void agregarPlato(Plato plato) {
        if (plato == null) throw new IllegalArgumentException("Plato no puede ser nulo");
        platos.add(plato);
        costo += plato.getPrecio();
    }

    public double calcularTotal() {
        return costo;
    }

    public int getIdPedido() { return idPedido; }
    public Date getFechaHora() { return fechaHora; }
    public List<Plato> getPlatos() { return Collections.unmodifiableList(platos); }
    public Mesa getMesa() { return mesa; }
    public Empleado getMesero() { return mesero; }
    public boolean isPagado() { return pagado; }
    public double getCosto() { return costo; }
}