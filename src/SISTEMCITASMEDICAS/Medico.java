package SISTEMCITASMEDICAS;

//Medico.java
import java.io.Serializable;

public class Medico implements Serializable {
 private String nombre;
 private String dni;
 private String especialidad;
 private String telefono;

 public Medico(String nombre, String dni, String especialidad, String telefono) {
     this.nombre = nombre;
     this.dni = dni;
     this.especialidad = especialidad;
     this.telefono = telefono;
 }

 public String getNombre() { return nombre; }
 public String getDni() { return dni; }
 public String getEspecialidad() { return especialidad; }
 public String getTelefono() { return telefono; }

 @Override
 public String toString() {
     return nombre + " (DNI: " + dni + ", esp: " + especialidad + ", telf: " + telefono + ")";
 }
}
