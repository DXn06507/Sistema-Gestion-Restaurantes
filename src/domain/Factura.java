import java.util.Date;
import java.util.Objects;

public final class Factura {
    private final int idFactura;
    private final Date fecha;
    private final double total;
    private final Pedido pedido;

    public Factura(int idFactura, Date fecha, Pedido pedido) {
        if (idFactura <= 0) throw new IllegalArgumentException("ID invalido");
        this.idFactura = idFactura;
        this.fecha = (fecha == null) ? new Date() : fecha;
        this.pedido = Objects.requireNonNull(pedido, "Pedido no puede ser nulo");
        this.total = pedido.calcularTotal();
    }

    public void imprimir() {
        System.out.println("=== FACTURA ===");
        System.out.println("ID: " + idFactura);
        System.out.println("Fecha: " + fecha);
        System.out.println("Total: $" + total);
        System.out.println("Pedido ID: " + pedido.getIdPedido());
        System.out.println("===============");
    }

    public int getIdFactura() { return idFactura; }
    public Date getFecha() { return fecha; }
    public double getTotal() { return total; }
    public Pedido getPedido() { return pedido; }
}