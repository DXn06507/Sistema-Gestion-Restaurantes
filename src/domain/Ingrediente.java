public final class Ingrediente {
    private final int idIngrediente;
    private final String nombre;
    private final String unidadMedida;

    public Ingrediente(int idIngrediente, String nombre, String unidadMedida) {
        if (idIngrediente <= 0) throw new IllegalArgumentException("ID invalido");
        if (nombre == null || !nombre.matches("[a-zA-Z0-9\\s\\-]+")) throw new IllegalArgumentException("Nombre invalido");
        this.idIngrediente = idIngrediente;
        this.nombre = nombre.trim();
        this.unidadMedida = (unidadMedida == null || unidadMedida.isBlank()) ? "unidad" : unidadMedida.trim();
    }

    public int getIdIngrediente() { return idIngrediente; }
    public String getNombre() { return nombre; }
    public String getUnidadMedida() { return unidadMedida; }
}