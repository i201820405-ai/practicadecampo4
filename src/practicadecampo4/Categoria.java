package practicadecampo4;

public class Categoria {
    private String nombre;
    private int id; 
    private static int contador = 1;

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Categoria(String nombre) {
        this.id = contador;
        this.nombre = nombre;
        contador++;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria c = (Categoria) o;
        return id == c.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}