import java.util.*;

public final class Menu {
    private final List<Plato> platosDisponibles;

    public Menu() {
        this.platosDisponibles = new ArrayList<>();
    }

    public void agregarPlato(Plato plato) {
        if (plato == null) throw new IllegalArgumentException("Plato no puede ser nulo");
        platosDisponibles.add(plato);
    }

    public void eliminarPlato(int idPlato) {
        platosDisponibles.removeIf(p -> p.getIdPlato() == idPlato);
    }

    public List<Plato> obtenerPlatos() {
        return Collections.unmodifiableList(platosDisponibles);
    }

    public List<Plato> getPlatosDisponibles() {
        return Collections.unmodifiableList(platosDisponibles);
    }
}