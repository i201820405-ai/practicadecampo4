package practicadecampo4;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BibliotecaApp {
    private static ArrayList<Libro> libros = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Prestamo> prestamos = new ArrayList<>();
    private static Map<Integer, Double> multas = new HashMap<>();
    private static ArrayList<Categoria> categorias = new ArrayList<>();
    private static final double TARIFA_POR_DIA = 1.0;
    public int variablePrueba;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Datos iniciales
        categorias.add(new Categoria("Terror"));
        categorias.add(new Categoria("Aventura"));
        categorias.add(new Categoria("Religion"));
        categorias.add(new Categoria("Drama"));
        libros.add(new Libro(1, "El Quijote", "Cervantes", categorias.get(1)));
        libros.add(new Libro(2, "Cien años de soledad", "García Márquez", categorias.get(3)));
        libros.add(new Libro(3, "La Sagrada Biblia", "Anónimo", categorias.get(2)));
        libros.add(new Libro(3, "La Sagrada Familia", "Anónimo", categorias.get(0)));
        usuarios.add(new Usuario(1, "Miguel"));
        usuarios.add(new Usuario(2, "Enrique"));
        usuarios.add(new Usuario(3, "Juan"));
        do {
            System.out.println("\n--- MENÚ BIBLIOTECA ---");
            System.out.println("1. Ver libros");
            System.out.println("2. Registrar préstamo");
            System.out.println("3. Registrar devolución");
            System.out.println("4. Ver préstamos");
            System.out.println("5. Buscar libro por título");
            System.out.println("6. Ver historial de un usuario");
            System.out.println("7. Ver libros prestados");
            System.out.println("8. Registrar libro");
            System.out.println("9. Editar libro");
            System.out.println("10. Eliminar libro");
            System.out.println("11. Buscar por autor");
            System.out.println("12. Buscar por categoría");
            System.out.println("13. Ver detalles de libro");
            System.out.println("14. Contar por categoría");
            System.out.println("15. Registrar usuario");
            System.out.println("16. Editar usuario");
            System.out.println("17. Eliminar usuario");
            System.out.println("18. Renovar préstamo");
            System.out.println("19. Mostrar multas usuario");
            System.out.println("20. Pagar multa");
            System.out.println("21. Registrar categoria");
            System.out.println("22. Ver usuarios registrados");
            System.out.println("23. Ver libros disponibles");
            System.out.println("24. Ver libros no disponibles");
            System.out.println("25. Buscar usuario por nombre");
            System.out.println("26. Contar total de libros");
            System.out.println("27. Contar total de usuarios");
            System.out.println("28. Buscar préstamo por libro");
            System.out.println("29. Ver préstamos vencidos");
            System.out.println("30. Ver préstamos activos");
            System.out.println("31. Ver categorias");
            System.out.println("32. Ordenar libros por título");
            System.out.println("33. Ordenar libros por autor");
            System.out.println("34. Ordenar libros por categoría");
            System.out.println("35. Ordenar usuarios por nombre");
            System.out.println("36. Contar préstamos de un usuario");
            System.out.println("37. Contar préstamos de un libro");
            System.out.println("38. Bloquear usuario con muchas multas");
            System.out.println("39. Ver top 3 libros más prestados");
            System.out.println("40. Ver top 3 usuarios con más préstamos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
            case 1:
                mostrarLibros();
                break;
            case 2:
                registrarPrestamo(sc);
                break;
            case 3:
                registrarDevolucion(sc);
                break;
            case 4:
                mostrarPrestamos();
                break;
            case 5:
                buscarLibroPorTitulo(sc);
                break;
            case 6:
                verHistorialUsuario(sc);
                break;
            case 7:
                verLibrosPrestados();
                break;
            case 8:
                registrarLibro(sc);
                break;
            case 9:
                editarLibro(sc);
                break;
            case 10:
                eliminarLibro(sc);
                break;
            case 11:
                buscarLibroPorAutor(sc);
                break;
            case 12:
                buscarLibroPorCategoria(sc);
                break;
            case 13:
                verDetallesLibro(sc);
                break;
            case 14:
                contarPorCategoria();
                break;
            case 15:
                registrarUsuario(sc);
                break;
            case 16:
                editarUsuario(sc);
                break;
            case 17:
                eliminarUsuario(sc);
                break;
            case 18:
                renovarPrestamo(sc);
                break;
            case 19:
                mostrarMultasUsuario(sc);
                break;
            case 20:
                pagarMulta(sc);
                break;
            case 21:
                registrarCategoria(sc);
                break;
            case 22:
                verUsuarios();
                break;
            case 23:
                verLibrosDisponibles();
                break;
            case 24:
                verLibrosNoDisponibles();
                break;
            case 25:
                buscarUsuarioPorNombre(sc);
                break;
            case 26:
                contarLibros();
                break;
            case 27:
                contarUsuarios();
                break;
            case 28:
                buscarPrestamoPorLibro(sc);
                break;
            case 29:
                verPrestamosVencidos();
                break;
            case 30:
                verPrestamosActivos();
                break;
            case 31:
            	verCategorias(sc);
                break;
            case 32:
                ordenarLibrosPorTitulo();
                break;
            case 33:
                ordenarLibrosPorAutor();
                break;
            case 34:
                ordenarLibrosPorCategoria();
                break;
            case 35:
                ordenarUsuariosPorNombre();
                break;
            case 36:
                contarPrestamosUsuario(sc);
                break;
            case 37:
                contarPrestamosLibro(sc);
                break;
            case 38:
                bloquearUsuario(sc);
                break;
            case 39:
                top3Libros();
                break;
            case 40:
                top3Usuarios();
                break;

            case 0:
                System.out.println("¡Hasta pronto!");
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
            
            System.out.println("Presiona enter para continuar ...");
            sc.nextLine();

        } while (opcion != 0);

        sc.close();
    }

    // ---------------- MÉTODOS ----------------
    private static void mostrarLibros() {
        for (Libro l : libros) System.out.println(l);
    }

    private static void registrarPrestamo(Scanner sc) {
        System.out.print("ID libro: ");
        int idLibro = sc.nextInt();
        System.out.print("ID usuario: ");
        int idUsuario = sc.nextInt();

        Libro libro = buscarLibro(idLibro);
        Usuario usuario = buscarUsuario(idUsuario);

        if (libro != null && usuario != null && libro.isDisponible()) {
            libro.prestar();
            prestamos.add(new Prestamo(libro, usuario, 7)); // 7 días préstamo
            System.out.println("Préstamo registrado.");
        } else {
            System.out.println("No se pudo registrar préstamo.");
        }
    }

    private static void registrarDevolucion(Scanner sc) {
        System.out.print("ID libro a devolver: ");
        int idLibro = sc.nextInt();
        Libro libro = buscarLibro(idLibro);
        if (libro == null) { System.out.println("No existe libro."); return; }

        for (Prestamo p : prestamos) {
            if (p.getLibro().getId() == idLibro && !p.isDevuelto()) {
                p.devolver();
                long diasRetraso = calcularDiasRetraso(p);
                if (diasRetraso > 0) {
                    double multa = diasRetraso * TARIFA_POR_DIA;
                    int idU = p.getUsuario().getId();
                    multas.put(idU, multas.getOrDefault(idU, 0.0) + multa);
                    System.out.println("Devuelto con retraso. Multa: " + multa);
                } else {
                    System.out.println("Devolución sin multa.");
                }
                return;
            }
        }
        System.out.println("No había préstamo activo.");
    }

    private static void mostrarPrestamos() {
        for (Prestamo p : prestamos) System.out.println(p);
    }

    private static void buscarLibroPorTitulo(Scanner sc) {
        sc.nextLine();
        System.out.print("Título: ");
        String t = sc.nextLine();
        for (Libro l : libros) if (l.getTitulo().toLowerCase().contains(t.toLowerCase())) System.out.println(l);
    }

    private static void verHistorialUsuario(Scanner sc) {
        System.out.print("ID usuario: ");
        int id = sc.nextInt();
        for (Prestamo p : prestamos) if (p.getUsuario().getId() == id) System.out.println(p);
    }

    private static void verLibrosPrestados() {
        for (Prestamo p : prestamos) if (!p.isDevuelto()) System.out.println(p);
    }

    private static void registrarLibro(Scanner sc) {
        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Título: "); String t = sc.nextLine();
        System.out.print("Autor: "); String a = sc.nextLine();
        System.out.print("ID de Categoría: "); int c = sc.nextInt();
        libros.add(new Libro(id, t, a, categorias.get(c)));
        System.out.println("Libro agregado.");
    }

    private static void editarLibro(Scanner sc) {
        System.out.print("ID libro: "); int id = sc.nextInt(); sc.nextLine();
        Libro l = buscarLibro(id);
        if (l == null) { System.out.println("No existe."); return; }
        System.out.print("Nuevo título: "); String t = sc.nextLine();
        if (!t.isBlank()) {
            libros.remove(l);
            libros.add(new Libro(id, t, l.getAutor(), l.getCategoria()));
            System.out.println("Título cambiado.");
        }
    }

    private static void eliminarLibro(Scanner sc) {
        System.out.print("ID: "); int id = sc.nextInt();
        Libro l = buscarLibro(id);
        if (l != null && l.isDisponible()) { libros.remove(l); System.out.println("Eliminado."); }
        else System.out.println("No se pudo eliminar.");
    }

    private static void buscarLibroPorAutor(Scanner sc) {
        sc.nextLine();
        System.out.print("Autor: "); String a = sc.nextLine();
        for (Libro l : libros) if (l.getAutor().toLowerCase().contains(a.toLowerCase())) System.out.println(l);
    }

    private static void buscarLibroPorCategoria(Scanner sc) {
        sc.nextLine();
        System.out.print("Categoría: "); String c = sc.nextLine();
        for (Libro l : libros) if (l.getCategoriaTexto().equalsIgnoreCase(c)) System.out.println(l);
    }

    private static void verDetallesLibro(Scanner sc) {
        System.out.print("ID: "); int id = sc.nextInt();
        Libro l = buscarLibro(id);
        if (l != null) {
            System.out.println("Título: " + l.getTitulo());
            System.out.println("Autor: " + l.getAutor());
            System.out.println("Categoría: " + l.getCategoriaTexto());
            System.out.println("Estado: " + (l.isDisponible() ? "Disponible" : "Prestado"));
        }
    }

    private static void contarPorCategoria() {
        Map<String,Integer> mapa = new HashMap<>();
        for (Libro l : libros) mapa.put(l.getCategoriaTexto(), mapa.getOrDefault(l.getCategoriaTexto(),0)+1);
        System.out.println("Conteo por categoría: " + mapa);
    }

    private static void registrarUsuario(Scanner sc) {
        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Nombre: "); String n = sc.nextLine();
        usuarios.add(new Usuario(id,n));
        System.out.println("Usuario agregado.");
    }

    private static void editarUsuario(Scanner sc) {
        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
        Usuario u = buscarUsuario(id);
        if (u==null){System.out.println("No existe."); return;}
        System.out.print("Nuevo nombre: "); String n=sc.nextLine();
        usuarios.remove(u); usuarios.add(new Usuario(id,n));
        System.out.println("Usuario actualizado.");
    }

    private static void eliminarUsuario(Scanner sc) {
        System.out.print("ID: "); int id=sc.nextInt();
        Usuario u=buscarUsuario(id);
        if(u==null){System.out.println("No existe."); return;}
        for(Prestamo p:prestamos) if(p.getUsuario().getId()==id && !p.isDevuelto()){System.out.println("Tiene préstamo activo."); return;}
        usuarios.remove(u);
        System.out.println("Usuario eliminado.");
    }

    private static void renovarPrestamo(Scanner sc) {
        System.out.print("ID libro: "); int id=sc.nextInt();
        for(Prestamo p:prestamos){
            if(p.getLibro().getId()==id && !p.isDevuelto()){
                System.out.print("Días extra: "); int d=sc.nextInt();
                if(p.renovar(d)) System.out.println("Renovado hasta "+p.getFechaLimite());
                return;
            }
        }
        System.out.println("No se encontró préstamo activo.");
    }

    private static void mostrarMultasUsuario(Scanner sc){
        System.out.print("ID usuario: "); int id=sc.nextInt();
        System.out.println("Multa: "+multas.getOrDefault(id,0.0));
    }

    private static void pagarMulta(Scanner sc){
        System.out.print("ID usuario: "); int id=sc.nextInt();
        double m=multas.getOrDefault(id,0.0);
        if(m<=0){System.out.println("No tiene multas."); return;}
        System.out.println("Pendiente: "+m);
        System.out.print("Monto pago: "); double p=sc.nextDouble();
        double rest=m-p;
        if(rest<=0){multas.remove(id);System.out.println("Multa pagada. Cambio:"+(-rest));}
        else {multas.put(id,rest);System.out.println("Restante: "+rest);}
    }
    private static void verUsuarios() {
        for (Usuario u : usuarios) System.out.println(u);
    }

    private static void verLibrosDisponibles() {
        for (Libro l : libros) if (l.isDisponible()) System.out.println(l);
    }

    private static void verLibrosNoDisponibles() {
        for (Libro l : libros) if (!l.isDisponible()) System.out.println(l);
    }

    private static void buscarUsuarioPorNombre(Scanner sc) {
        sc.nextLine();
        System.out.print("Nombre: ");
        String n = sc.nextLine();
        for (Usuario u : usuarios) if (u.getNombre().toLowerCase().contains(n.toLowerCase())) System.out.println(u);
    }

    private static void contarLibros() {
        System.out.println("Total de libros: " + libros.size());
    }

    private static void contarUsuarios() {
        System.out.println("Total de usuarios: " + usuarios.size());
    }

    private static void buscarPrestamoPorLibro(Scanner sc) {
        System.out.print("ID libro: "); int id = sc.nextInt();
        for (Prestamo p : prestamos) if (p.getLibro().getId() == id) System.out.println(p);
    }

    private static void verPrestamosVencidos() {
        LocalDate hoy = LocalDate.now();
        for (Prestamo p : prestamos) if (!p.isDevuelto() && hoy.isAfter(p.getFechaLimite())) System.out.println(p);
    }

    private static void verPrestamosActivos() {
        for (Prestamo p : prestamos) if (!p.isDevuelto()) System.out.println(p);
    }

    private static void exportarPrestamosTXT() {
        try (FileWriter fw = new FileWriter("prestamos_export.txt")) {
            for (Prestamo p : prestamos) fw.write(p.toString() + "\n");
            System.out.println("Exportado a prestamos_export.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void ordenarLibrosPorTitulo() {
        libros.sort((a,b)->a.getTitulo().compareToIgnoreCase(b.getTitulo()));
        mostrarLibros();
    }

    private static void ordenarLibrosPorAutor() {
        libros.sort((a,b)->a.getAutor().compareToIgnoreCase(b.getAutor()));
        mostrarLibros();
    }

    private static void ordenarLibrosPorCategoria() {
        libros.sort((a,b)->a.getCategoriaTexto().compareToIgnoreCase(b.getCategoriaTexto()));
        mostrarLibros();
    }

    private static void ordenarUsuariosPorNombre() {
        usuarios.sort((a,b)->a.getNombre().compareToIgnoreCase(b.getNombre()));
        verUsuarios();
    }

    private static void contarPrestamosUsuario(Scanner sc) {
        System.out.print("ID usuario: "); int id = sc.nextInt();
        long total = prestamos.stream().filter(p -> p.getUsuario().getId()==id).count();
        System.out.println("Total préstamos: " + total);
    }

    private static void contarPrestamosLibro(Scanner sc) {
        System.out.print("ID libro: "); int id = sc.nextInt();
        long total = prestamos.stream().filter(p -> p.getLibro().getId()==id).count();
        System.out.println("Total veces prestado: " + total);
    }

    private static void bloquearUsuario(Scanner sc) {
        System.out.print("ID usuario: "); int id = sc.nextInt();
        double deuda = multas.getOrDefault(id, 0.0);
        if (deuda > 10) {
            System.out.println("Usuario bloqueado por deuda mayor a 10.");
        } else {
            System.out.println("Usuario activo.");
        }
    }

    private static void top3Libros() {
        Map<Integer,Long> conteo = new HashMap<>();
        for (Prestamo p : prestamos)
            conteo.put(p.getLibro().getId(), conteo.getOrDefault(p.getLibro().getId(),0L)+1);

        conteo.entrySet().stream()
            .sorted((a,b)->Long.compare(b.getValue(),a.getValue()))
            .limit(3)
            .forEach(e -> {
                Libro l = buscarLibro(e.getKey());
                System.out.println(l.getTitulo() + " - " + e.getValue() + " préstamos");
            });
    }

    private static void top3Usuarios() {
        Map<Integer,Long> conteo = new HashMap<>();
        for (Prestamo p : prestamos)
            conteo.put(p.getUsuario().getId(), conteo.getOrDefault(p.getUsuario().getId(),0L)+1);

        conteo.entrySet().stream()
            .sorted((a,b)->Long.compare(b.getValue(),a.getValue()))
            .limit(3)
            .forEach(e -> {
                Usuario u = buscarUsuario(e.getKey());
                System.out.println(u.getNombre() + " - " + e.getValue() + " préstamos");
            });
    }


    private static Libro buscarLibro(int id) {
        for (Libro l : libros) if (l.getId() == id) return l;
        return null;
    }

    private static Usuario buscarUsuario(int id) {
        for (Usuario u : usuarios) if (u.getId() == id) return u;
        return null;
    }

    private static long calcularDiasRetraso(Prestamo p) {
        LocalDate hoy=LocalDate.now();
        if(p.isDevuelto()){
            if(p.getFechaDevolucion().isAfter(p.getFechaLimite()))
                return ChronoUnit.DAYS.between(p.getFechaLimite(),p.getFechaDevolucion());
        } else {
            if(hoy.isAfter(p.getFechaLimite()))
                return ChronoUnit.DAYS.between(p.getFechaLimite(),hoy);
        }
        return 0;
        
    }
    
    private static void registrarCategoria(Scanner sc) {
        System.out.print("Nombre de la categoría: ");
        String c = sc.nextLine();
        
        for (Categoria m : categorias) {
        	if(m.getNombre() == c) {
        		System.out.println("Categoría agregada.");
        		return;
        	}
        }

        System.out.println("La categoría ya existe.");

    }

    private static void verCategorias(Scanner sc) {
    	for (Categoria c : categorias) System.out.println(c.getNombre());
    }
    
}

