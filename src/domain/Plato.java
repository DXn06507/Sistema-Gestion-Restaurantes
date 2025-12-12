import java.util.List;
import java.util.Objects;

public final class Plato {
    private final int idPlato;
    private final String nombre;
    private final String descripcion;
    private double precio;
    private final List<Ingrediente> ingredientes;

    public Plato(int idPlato, String nombre, String descripcion, double precio, List<Ingrediente> ingredientes) {
        if (idPlato <= 0) throw new IllegalArgumentException("ID invalido");
        if (nombre == null || !nombre.matches("[a-zA-Z0-9\\s\\-]+")) throw new IllegalArgumentException("Nombre invalido");
        if (precio <= 0) throw new IllegalArgumentException("Precio debe ser mayor a 0");
        this.idPlato = idPlato;
        this.nombre = nombre.trim();
        this.descripcion = (descripcion == null) ? "" : descripcion.trim();
        this.precio = precio;
        this.ingredientes = (ingredientes == null) ? List.of() : List.copyOf(ingredientes);
    }

    public void actualizarPrecio(double nuevoPrecio) {
        if (nuevoPrecio <= 0) throw new IllegalArgumentException("Precio invalido");
        this.precio = nuevoPrecio;
    }

    public int getIdPlato() { return idPlato; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public List<Ingrediente> getIngredientes() { return ingredientes; }
}