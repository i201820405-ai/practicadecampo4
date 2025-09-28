package Caso2;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar curso");
            System.out.println("2. Registrar estudiante");
            System.out.println("3. Mostrar cursos");
            System.out.println("4. Mostrar estudiantes");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1: // Registrar curso
                    System.out.print("Ingrese nombre del curso: ");
                    String nombreCurso = sc.nextLine();
                    System.out.print("Ingrese duración en meses: ");
                    int duracion = sc.nextInt();
                    sc.nextLine();
                    cursos.add(new Curso(nombreCurso, duracion));
                    System.out.println("Curso registrado correctamente.");
                    break;

                case 2: // Registrar estudiante
                    if (cursos.isEmpty()) {
                        System.out.println("⚠ Debe registrar al menos un curso primero.");
                        break;
                    }

                    System.out.print("Ingrese nombre del estudiante: ");
                    String nombreEst = sc.nextLine();
                    System.out.print("Ingrese edad: ");
                    int edad = sc.nextInt();

                    // Mostrar cursos disponibles
                    System.out.println("Seleccione un curso:");
                    for (int i = 0; i < cursos.size(); i++) {
                        System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
                    }
                    int cursoIndex = sc.nextInt() - 1;
                    Curso cursoSel = cursos.get(cursoIndex);

                    System.out.print("¿El estudiante es Regular (1) o Becado (2)? ");
                    int tipo = sc.nextInt();

                    if (tipo == 1) {
                        System.out.print("Ingrese costo base de la mensualidad: ");
                        double costo = sc.nextDouble();
                        estudiantes.add(new EstudianteRegular(nombreEst, edad, cursoSel, costo));
                    } else {
                        System.out.print("Ingrese costo base de la mensualidad: ");
                        double costo = sc.nextDouble();
                        System.out.print("Ingrese porcentaje de beca (ej: 0.5 para 50%): ");
                        double beca = sc.nextDouble();
                        estudiantes.add(new EstudianteBecado(nombreEst, edad, cursoSel, costo, beca));
                    }

                    System.out.println("Estudiante registrado correctamente.");
                    break;

                case 3: // Mostrar cursos
                    if (cursos.isEmpty()) {
                        System.out.println("No hay cursos registrados.");
                    } else {
                        System.out.println("\n--- CURSOS REGISTRADOS ---");
                        for (Curso c : cursos) {
                            System.out.println("- " + c.getNombre());
                        }
                    }
                    break;

                case 4: // Mostrar estudiantes
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        System.out.println("\n--- ESTUDIANTES REGISTRADOS ---");
                        for (Estudiante e : estudiantes) {
                            System.out.println("Nombre: " + e.nombre +
                                               ", Curso: " + e.curso.getNombre() +
                                               ", Mensualidad: $" + e.calcularMensualidad());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}