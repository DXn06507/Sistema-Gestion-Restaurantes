- $" + platos.get(i).getPrecio());
        }
        System.out.println("Ingrese numero de plato (0 para terminar): ");
        String sel = leerLinea();
        while (!"0".equals(sel)) {
            try {
                int pi = Integer.parseInt(sel) - 1;
                if (pi >= 0 && pi < platos.size()) {
                    pedido.agregarPlato(platos.get(pi));
                    System.out.println(" Plato agregado.");
                }
            } catch (Exception ignored) {}
            System.out.print("Plato (0 para terminar): ");
            sel = leerLinea();
        }

        if (pedido.getPlatos().isEmpty()) {
            System.out.println("Pedido vacio.");
            return;
        }

        pedidos.add(pedido);
        restaurante.registrarPedido(pedido);
        System.out.println(" Pedido registrado.");
    }

    // === 6. COCINA ===
    private static void verCocina() {
        Cocina c = restaurante.getCocina();
        System.out.println("\n--- COCINA ---");
        System.out.println("Pendientes: " + c.getPedidosPendientes().size());
        System.out.println("Listos: " + c.getPedidosListos().size());
    }

    // === 7. FACTURA ===
    private static void generarFactura() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos.");
            return;
        }
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println((i + 1) + ". " + pedidos.get(i));
        }
        System.out.print("Seleccione pedido: ");
        int idx = leerEntero() - 1;
        if (idx < 0 || idx >= pedidos.size()) return;
        Factura f = restaurante.generarFactura(pedidos.get(idx));
        f.imprimir();
    }

    // === 8. REPORTE ===
    private static void generarReporte() {
        ReporteVentas r = restaurante.generarReporte();
        Map<Plato, Integer> top = r.obtenerPlatosMasVendidos(5, pedidos);
        if (top.isEmpty()) {
            System.out.println("No hay datos para reporte.");
        } else {
            System.out.println("\n--- PLATOS MAS VENDIDOS ---");
            for (var entry : top.entrySet()) {
                System.out.println("- " + entry.getKey().getNombre() + ": " + entry.getValue());
            }
        }
    }
}
