package Caso2;

public class EstudianteRegular extends Estudiante {
    private double costoBase;

    public EstudianteRegular(String nombre, int edad, Curso curso, double costoBase) {
        super(nombre, edad, curso);
        this.costoBase = costoBase;
    }

    @Override
    public double calcularMensualidad() {
        return costoBase;
    }
}
