package practicadecampo4;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private Categoria categoria;
    private boolean disponible;

    public Libro(int id, String titulo, String autor, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponible = true;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoriaTexto() { return categoria.toString(); }
    public Categoria getCategoria() { return categoria; }
    public boolean isDisponible() { return disponible; }

    public void prestar() { disponible = false; }
    public void devolver() { disponible = true; }

    @Override
    public String toString() {
        return id + " - " + titulo + " (" + (disponible ? "Disponible" : "Prestado") + ")";
    }
}