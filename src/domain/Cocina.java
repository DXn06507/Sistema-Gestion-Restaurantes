import java.util.*;

public final class Cocina {
    private final List<Pedido> pedidosPendientes;
    private final List<Pedido> pedidosListos;

    public Cocina() {
        this.pedidosPendientes = new ArrayList<>();
        this.pedidosListos = new ArrayList<>();
    }

    public void prepararPedido(Pedido pedido) {
        if (pedido == null) throw new IllegalArgumentException("Pedido no puede ser nulo");
        pedidosPendientes.add(pedido);
        System.out.println("Preparando pedido #" + pedido.getIdPedido());
        try { Thread.sleep(300); } catch (InterruptedException ignored) {}
        pedidosPendientes.remove(pedido);
        pedidosListos.add(pedido);
        pedido.getMesa().notificarListo(pedido);
        System.out.println("Pedido #" + pedido.getIdPedido() + " listo.");
    }

    public List<Pedido> getPedidosPendientes() { return Collections.unmodifiableList(pedidosPendientes); }
    public List<Pedido> getPedidosListos() { return Collections.unmodifiableList(pedidosListos); }
}