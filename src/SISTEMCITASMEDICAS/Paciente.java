package SISTEMCITASMEDICAS;

//Paciente.java
import java.io.Serializable;

public class Paciente implements Serializable {
 private String nombre;
 private String dni;
 private int edad;
 private String telefono;

 public Paciente(String nombre, String dni, int edad, String telefono) {
     this.nombre = nombre;
     this.dni = dni;
     this.edad = edad;
     this.telefono = telefono;
 }

 public String getNombre() { return nombre; }
 public String getDni() { return dni; }
 public int getEdad() { return edad; }
 public String getTelefono() { return telefono; }

 @Override
 public String toString() {
     return nombre + " (DNI: " + dni + ", edad: " + edad + ", telf: " + telefono + ")";
 }
}
