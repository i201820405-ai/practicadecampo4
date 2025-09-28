package Caso2;

public class EstudianteBecado extends Estudiante {
    private double costoBase;
    private double porcentajeBeca; // Ejemplo: 0.5 = 50% de descuento

    public EstudianteBecado(String nombre, int edad, Curso curso, double costoBase, double porcentajeBeca) {
        super(nombre, edad, curso);
        this.costoBase = costoBase;
        this.porcentajeBeca = porcentajeBeca;
    }

    @Override
    public double calcularMensualidad() {
        return costoBase * (1 - porcentajeBeca);
    }
}