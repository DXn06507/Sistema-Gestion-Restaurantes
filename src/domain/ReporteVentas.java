import java.util.*;
import java.util.stream.Collectors;
import java.util.Date;

public final class ReporteVentas {

    public Map<Plato, Integer> obtenerPlatosMasVendidos(int topN, List<Pedido> pedidos) {
        if (topN <= 0) throw new IllegalArgumentException("topN debe ser mayor a 0");
        if (pedidos == null) return Collections.emptyMap();

        Map<Plato, Long> conteo = pedidos.stream()
            .flatMap(p -> p.getPlatos().stream())
            .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        return conteo.entrySet().stream()
            .sorted(Map.Entry.<Plato, Long>comparingByValue().reversed())
            .limit(topN)
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> e.getValue().intValue(),
                (a, b) -> a,
                LinkedHashMap::new
            ));
    }

    public double calcularIngresosPorPeriodo(Date inicio, Date fin, List<Pedido> pedidos) {
        if (inicio == null || fin == null) throw new IllegalArgumentException("Fechas no pueden ser nulas");
        return pedidos.stream()
            .filter(p -> !p.getFechaHora().before(inicio) && !p.getFechaHora().after(fin))
            .mapToDouble(Pedido::calcularTotal)
            .sum();
    }
}