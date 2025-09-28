package SISTEMCITASMEDICAS;

//SistemaCitas.java
import java.io.*;
import java.util.*;

public class SistemaCitas {
 private List<Paciente> pacientes;
 private List<Medico> medicos;
 private List<Cita> citas;

 private final String FILE_PAC = "pacientes.dat";
 private final String FILE_MED = "medicos.dat";
 private final String FILE_CIT = "citas.dat";

 public SistemaCitas() {
     pacientes = new ArrayList<>();
     medicos = new ArrayList<>();
     citas = new ArrayList<>();
 }

 // CARGA y GUARDADO
 public void cargarDatos() {
     pacientes = (List<Paciente>) leerObjeto(FILE_PAC, new ArrayList<Paciente>());
     medicos = (List<Medico>) leerObjeto(FILE_MED, new ArrayList<Medico>());
     citas = (List<Cita>) leerObjeto(FILE_CIT, new ArrayList<Cita>());
 }

 public void guardarDatos() {
     escribirObjeto(FILE_PAC, pacientes);
     escribirObjeto(FILE_MED, medicos);
     escribirObjeto(FILE_CIT, citas);
 }

 private void escribirObjeto(String filename, Object obj) {
     try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
         oos.writeObject(obj);
     } catch (IOException e) {
         System.out.println("Error guardando " + filename + ": " + e.getMessage());
     }
 }

 private Object leerObjeto(String filename, Object defaultObj) {
     File f = new File(filename);
     if (!f.exists()) return defaultObj;
     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
         return ois.readObject();
     } catch (Exception e) {
         System.out.println("Error cargando " + filename + ": " + e.getMessage());
         return defaultObj;
     }
 }

 // PACIENTES
 public boolean agregarPaciente(Paciente p) {
     if (buscarPacientePorDNI(p.getDni()) != null) return false;
     pacientes.add(p);
     return true;
 }

 public Paciente buscarPacientePorDNI(String dni) {
     for (Paciente p : pacientes) if (p.getDni().equalsIgnoreCase(dni)) return p;
     return null;
 }

 // MEDICOS
 public boolean agregarMedico(Medico m) {
     if (buscarMedicoPorDNI(m.getDni()) != null) return false;
     medicos.add(m);
     return true;
 }

 public Medico buscarMedicoPorDNI(String dni) {
     for (Medico m : medicos) if (m.getDni().equalsIgnoreCase(dni)) return m;
     return null;
 }

 public List<Medico> listarMedicosPorEspecialidad(String esp) {
     List<Medico> res = new ArrayList<>();
     for (Medico m : medicos) if (m.getEspecialidad().equalsIgnoreCase(esp)) res.add(m);
     return res;
 }

 // CITAS
 public boolean programarCita(Cita c) {
     // validar que no haya conflicto para el mismo medico en fecha/hora
     for (Cita x : citas) {
         if (x.getMedico().getDni().equalsIgnoreCase(c.getMedico().getDni())
             && x.getFecha().equals(c.getFecha())
             && x.getHora().equals(c.getHora())) {
             return false; // conflicto
         }
     }
     citas.add(c);
     return true;
 }

 public List<Cita> listarCitas() { return new ArrayList<>(citas); }

 public boolean cancelarCita(String dniPaciente, String fecha, String hora) {
     Iterator<Cita> it = citas.iterator();
     while (it.hasNext()) {
         Cita c = it.next();
         if (c.getPaciente().getDni().equalsIgnoreCase(dniPaciente)
             && c.getFecha().equals(fecha)
             && c.getHora().equals(hora)) {
             it.remove();
             return true;
         }
     }
     return false;
 }

 public List<Cita> buscarCitasPorFecha(String fecha) {
     List<Cita> res = new ArrayList<>();
     for (Cita c : citas) if (c.getFecha().equals(fecha)) res.add(c);
     return res;
 }

 public List<Cita> historialPaciente(String dniPaciente) {
     List<Cita> res = new ArrayList<>();
     for (Cita c : citas) if (c.getPaciente().getDni().equalsIgnoreCase(dniPaciente)) res.add(c);
     return res;
 }

 // EXPORT CSV
 public void exportarCitasCSV(String filename) {
     try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
         pw.println("fecha,hora,paciente_dni,paciente_nombre,medico_dni,medico_nombre,medico_especialidad");
         for (Cita c : citas) {
             pw.printf("%s,%s,%s,%s,%s,%s,%s%n",
                 c.getFecha(), c.getHora(),
                 c.getPaciente().getDni(), c.getPaciente().getNombre(),
                 c.getMedico().getDni(), c.getMedico().getNombre(),
                 c.getMedico().getEspecialidad());
         }
         System.out.println("Exportado OK a " + filename);
     } catch (IOException e) {
         System.out.println("Error exportando CSV: " + e.getMessage());
     }
 }
}
