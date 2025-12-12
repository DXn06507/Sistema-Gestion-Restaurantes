import java.util.*;

public final class Empleado {
    private final int idEmpleado;
    private final String nombre;
    private final String dni;
    private final Rol rol;
    private final List<Turno> turnos;

    public Empleado(int idEmpleado, String nombre, String dni, Rol rol) {
        if (idEmpleado <= 0) throw new IllegalArgumentException("ID invalido");
        if (nombre == null || !nombre.matches("[a-zA-Z\\s]+")) throw new IllegalArgumentException("Nombre invalido");
        if (dni == null || !dni.matches("\\d+")) throw new IllegalArgumentException("DNI invalido");
        this.idEmpleado = idEmpleado;
        this.nombre = nombre.trim();
        this.dni = dni;
        this.rol = Objects.requireNonNull(rol, "Rol no puede ser nulo");
        this.turnos = new ArrayList<>();
    }

    public void registrarDesempeno(String observacion) {
        System.out.println("Desempeno registrado para " + nombre + ": " + observacion);
    }

    public void agregarTurno(Turno turno) {
        if (turno == null) throw new IllegalArgumentException("Turno no puede ser nulo");
        turnos.add(turno);
    }

    public int getIdEmpleado() { return idEmpleado; }
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public Rol getRol() { return rol; }
    public List<Turno> getTurnos() { return Collections.unmodifiableList(turnos); }
}