package SISTEMCITASMEDICAS;

//Main.java
import java.util.List;
import java.util.Scanner;

public class Main {
 private static SistemaCitas sistema = new SistemaCitas();
 private static Scanner sc = new Scanner(System.in);

 public static void main(String[] args) {
     sistema.cargarDatos();
     System.out.println("=== Sistema de Gestión de Citas Médicas ===");
     boolean salir = false;
     while (!salir) {
         mostrarMenu();
         String opt = sc.nextLine().trim();
         switch (opt) {
             case "1": registrarPaciente(); break;
             case "2": registrarMedico(); break;
             case "3": programarCita(); break;
             case "4": mostrarCitas(); break;
             case "5": buscarPaciente(); break;
             case "6": cancelarCita(); break;
             case "7": exportarCSV(); break;
             case "8": listarMedicosPorEspecialidad(); break;
             case "9": historialPaciente(); break;
             case "0": 
                 sistema.guardarDatos();
                 System.out.println("Datos guardados. Saliendo...");
                 salir = true; break;
             default: System.out.println("Opción inválida."); 
         }
     }
 }

 private static void mostrarMenu() {
     System.out.println("\nOpciones:");
     System.out.println("1. Registrar paciente");
     System.out.println("2. Registrar médico");
     System.out.println("3. Programar cita");
     System.out.println("4. Listar todas las citas");
     System.out.println("5. Buscar paciente por DNI");
     System.out.println("6. Cancelar cita (por paciente, fecha, hora)");
     System.out.println("7. Exportar citas a CSV");
     System.out.println("8. Listar médicos por especialidad");
     System.out.println("9. Historial de paciente (citas)");
     System.out.println("0. Guardar y salir");
     System.out.print("Elige opción: ");
 }

 private static void registrarPaciente() {
     System.out.print("Nombre: ");
     String nombre = sc.nextLine().trim();
     System.out.print("DNI: ");
     String dni = sc.nextLine().trim();
     System.out.print("Edad: ");
     int edad = Integer.parseInt(sc.nextLine().trim());
     System.out.print("Teléfono: ");
     String tel = sc.nextLine().trim();

     if (nombre.isEmpty() || dni.isEmpty()) {
         System.out.println("Nombre y DNI son obligatorios.");
         return;
     }
     Paciente p = new Paciente(nombre, dni, edad, tel);
     if (sistema.agregarPaciente(p)) System.out.println("Paciente registrado.");
     else System.out.println("Ya existe paciente con ese DNI.");
 }

 private static void registrarMedico() {
     System.out.print("Nombre: ");
     String nombre = sc.nextLine().trim();
     System.out.print("DNI: ");
     String dni = sc.nextLine().trim();
     System.out.print("Especialidad: ");
     String esp = sc.nextLine().trim();
     System.out.print("Teléfono: ");
     String tel = sc.nextLine().trim();

     if (nombre.isEmpty() || dni.isEmpty()) {
         System.out.println("Nombre y DNI son obligatorios.");
         return;
     }
     Medico m = new Medico(nombre, dni, esp, tel);
     if (sistema.agregarMedico(m)) System.out.println("Médico registrado.");
     else System.out.println("Ya existe médico con ese DNI.");
 }

 private static void programarCita() {
     System.out.print("DNI paciente: "); String dniP = sc.nextLine().trim();
     Paciente p = sistema.buscarPacientePorDNI(dniP);
     if (p == null) { System.out.println("Paciente no encontrado."); return; }

     System.out.print("DNI médico: "); String dniM = sc.nextLine().trim();
     Medico m = sistema.buscarMedicoPorDNI(dniM);
     if (m == null) { System.out.println("Médico no encontrado."); return; }

     System.out.print("Fecha (YYYY-MM-DD): "); String fecha = sc.nextLine().trim();
     System.out.print("Hora (HH:MM): "); String hora = sc.nextLine().trim();

     Cita c = new Cita(p, m, fecha, hora);
     if (sistema.programarCita(c)) System.out.println("Cita programada.");
     else System.out.println("Conflicto: ya existe una cita para ese médico en la misma fecha/hora.");
 }

 private static void mostrarCitas() {
     List<Cita> list = sistema.listarCitas();
     if (list.isEmpty()) { System.out.println("No hay citas registradas."); return; }
     System.out.println("Citas:");
     for (Cita c : list) System.out.println(c);
 }

 private static void buscarPaciente() {
     System.out.print("DNI paciente: "); String dni = sc.nextLine().trim();
     Paciente p = sistema.buscarPacientePorDNI(dni);
     if (p == null) System.out.println("No encontrado.");
     else System.out.println("Paciente: " + p);
 }

 private static void cancelarCita() {
     System.out.print("DNI paciente: "); String dni = sc.nextLine().trim();
     System.out.print("Fecha (YYYY-MM-DD): "); String fecha = sc.nextLine().trim();
     System.out.print("Hora (HH:MM): "); String hora = sc.nextLine().trim();
     if (sistema.cancelarCita(dni, fecha, hora)) System.out.println("Cita cancelada.");
     else System.out.println("No se encontró esa cita.");
 }

 private static void exportarCSV() {
     System.out.print("Nombre archivo CSV (ej: citas_export.csv): ");
     String n = sc.nextLine().trim();
     if (n.isEmpty()) n = "citas_export.csv";
     sistema.exportarCitasCSV(n);
 }

 private static void listarMedicosPorEspecialidad() {
     System.out.print("Especialidad: ");
     String esp = sc.nextLine().trim();
     List<Medico> res = sistema.listarMedicosPorEspecialidad(esp);
     if (res.isEmpty()) System.out.println("No hay médicos con esa especialidad.");
     else {
         System.out.println("Médicos:");
         for (Medico m : res) System.out.println(m);
     }
 }

 private static void historialPaciente() {
     System.out.print("DNI paciente: "); String dni = sc.nextLine().trim();
     List<Cita> res = sistema.historialPaciente(dni);
     if (res.isEmpty()) System.out.println("No hay citas para ese paciente.");
     else {
         System.out.println("Historial de citas:");
         for (Cita c : res) System.out.println(c);
     }
 }
}

