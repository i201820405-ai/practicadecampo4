package practicadecampo4;

import java.time.LocalDate;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private LocalDate fechaLimite;
    private boolean devuelto;

    public Prestamo(Libro libro, Usuario usuario, int diasPrestamo) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.fechaLimite = fechaPrestamo.plusDays(diasPrestamo);
        this.devuelto = false;
    }

    public void devolver() {
        this.fechaDevolucion = LocalDate.now();
        this.devuelto = true;
        libro.devolver();
    }

    public boolean renovar(int dias) {
        if (!devuelto) {
            this.fechaLimite = this.fechaLimite.plusDays(dias);
            return true;
        }
        return false;
    }

    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }
    public boolean isDevuelto() { return devuelto; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public LocalDate getFechaLimite() { return fechaLimite; }

    @Override
    public String toString() {
        return "Libro: " + libro.getTitulo() +
               ", Usuario: " + usuario.getNombre() +
               ", Prestado: " + fechaPrestamo +
               ", Límite: " + fechaLimite +
               (devuelto ? ", Devuelto: " + fechaDevolucion : ", No devuelto aún");
    }
}
