import java.util.*;

public final class Inventario {
    private final Map<Ingrediente, Double> stock = new HashMap<>();

    public void registrarIngrediente(Ingrediente ing) {
        if (ing == null) throw new IllegalArgumentException("Ingrediente no puede ser nulo");
        stock.putIfAbsent(ing, 0.0);
    }

    public void actualizarStock(Ingrediente ing, double cantidad) {
        if (cantidad < 0) throw new IllegalArgumentException("Cantidad no puede ser negativa");
        stock.merge(ing, cantidad, Double::sum);
    }

    public boolean verificarDisponibilidad(Plato plato) {
        if (plato == null) return false;
        return plato.getIngredientes().stream().allMatch(ing -> stock.getOrDefault(ing, 0.0) > 0);
    }

    public void consumir(Ingrediente ing, double cantidad) {
        if (!stock.containsKey(ing) || stock.get(ing) < cantidad)
            throw new IllegalArgumentException("Stock insuficiente");
        stock.put(ing, stock.get(ing) - cantidad);
    }

    public void reponer(Ingrediente ing, double cantidad) {
        actualizarStock(ing, cantidad);
    }

    public Map<Ingrediente, Double> getStock() {
        return Collections.unmodifiableMap(stock);
    }
}