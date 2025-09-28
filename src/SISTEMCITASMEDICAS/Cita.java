package SISTEMCITASMEDICAS;

//Cita.java
import java.io.Serializable;

public class Cita implements Serializable {
 private Paciente paciente;
 private Medico medico;
 private String fecha; // formato simple: YYYY-MM-DD
 private String hora;  // formato simple: HH:MM

 public Cita(Paciente paciente, Medico medico, String fecha, String hora) {
     this.paciente = paciente;
     this.medico = medico;
     this.fecha = fecha;
     this.hora = hora;
 }

 public Paciente getPaciente() { return paciente; }
 public Medico getMedico() { return medico; }
 public String getFecha() { return fecha; }
 public String getHora() { return hora; }

 @Override
 public String toString() {
     return fecha + " " + hora + " - " + paciente.getNombre() + " con Dr(a). " + medico.getNombre() + " (" + medico.getEspecialidad() + ")";
 }
}

