import java.util.*;

public final class Restaurante {
    private final String nombre;
    private final String direccion;
    private final List<Mesa> mesas;
    private final List<Empleado> empleados;
    private final Menu menu;
    private final Inventario inventario;
    private final Cocina cocina;

    public Restaurante(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.mesas = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.menu = new Menu();
        this.inventario = new Inventario();
        this.cocina = new Cocina();
    }

    public void abrirRestaurante() {
        System.out.println("Restaurante abierto: " + nombre);
    }

    public void cerrarRestaurante() {
        System.out.println("Restaurante cerrado: " + nombre);
    }

    public void registrarPedido(Pedido pedido) {
        if (pedido == null) throw new IllegalArgumentException("Pedido no puede ser nulo");
        cocina.prepararPedido(pedido);
    }

    public Factura generarFactura(Pedido pedido) {
        if (pedido == null) throw new IllegalArgumentException("Pedido no puede ser nulo");
        return new Factura((int)(Math.random() * 10000), new Date(), pedido);
    }

    public ReporteVentas generarReporte() {
        return new ReporteVentas();
    }

    // ✅ MÉTODOS DE FACHADA (NO EXPONEN LISTAS MUTABLES)
    public void agregarMesa(Mesa mesa) {
        if (mesa == null) throw new IllegalArgumentException("Mesa no puede ser nula");
        mesas.add(mesa);
    }

    public void agregarEmpleado(Empleado empleado) {
        if (empleado == null) throw new IllegalArgumentException("Empleado no puede ser nulo");
        empleados.add(empleado);
    }

    public void agregarPlato(Plato plato) {
        if (plato == null) throw new IllegalArgumentException("Plato no puede ser nulo");
        menu.agregarPlato(plato);
    }

    public List<Mesa> getMesas() { return Collections.unmodifiableList(mesas); }
    public List<Empleado> getEmpleados() { return Collections.unmodifiableList(empleados); }
    public Menu getMenu() { return menu; }
    public Inventario getInventario() { return inventario; }
    public Cocina getCocina() { return cocina; }
}