import java.util.*;

public final class Mesa {
    private final int numero;
    private final int capacidad;
    private EstadoMesa estado;
    private final List<Pedido> pedidosPendientes;
    private final List<Pedido> pedidosListos;
    private final List<Pedido> historialPedidos;

    public Mesa(int numero, int capacidad) {
        if (numero <= 0) throw new IllegalArgumentException("Numero de mesa invalido");
        if (capacidad <= 0) throw new IllegalArgumentException("Capacidad invalida");
        this.numero = numero;
        this.capacidad = capacidad;
        this.estado = EstadoMesa.LIBRE;
        this.pedidosPendientes = new ArrayList<>();
        this.pedidosListos = new ArrayList<>();
        this.historialPedidos = new ArrayList<>();
    }

    public void ocupar() { this.estado = EstadoMesa.OCUPADA; }
    public void liberar() { this.estado = EstadoMesa.LIBRE; }

    public void notificarListo(Pedido pedido) {
        if (pedidosPendientes.remove(pedido)) {
            pedidosListos.add(pedido);
            historialPedidos.add(pedido);
        }
    }

    public int getNumero() { return numero; }
    public int getCapacidad() { return capacidad; }
    public EstadoMesa getEstado() { return estado; }
    public List<Pedido> getPedidosPendientes() { return Collections.unmodifiableList(pedidosPendientes); }
    public List<Pedido> getPedidosListos() { return Collections.unmodifiableList(pedidosListos); }
    public List<Pedido> getHistorialPedidos() { return Collections.unmodifiableList(historialPedidos); }
}