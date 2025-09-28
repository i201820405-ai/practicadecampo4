package Caso2;

public abstract class Estudiante implements Evaluable {
    protected String nombre;
    protected int edad;
    protected Curso curso;

    public Estudiante(String nombre, int edad, Curso curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    // Método abstracto que será sobreescrito
    public abstract double calcularMensualidad();

    @Override
    public void evaluar() {
        System.out.println(nombre + " ha sido evaluado en el curso: " + curso.getNombre());
    }
}
