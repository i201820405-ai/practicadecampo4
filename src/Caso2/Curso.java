package Caso2;


public class Curso {
    private String nombre;
    private int duracionMeses;

    public Curso(String nombre, int duracionMeses) {
        this.nombre = nombre;
        this.duracionMeses = duracionMeses;
    }

    public String getNombre() {
        return nombre;
    }
}