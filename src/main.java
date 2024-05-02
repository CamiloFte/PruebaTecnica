import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Libro libro1 = new Libro("El señor de los anillos", "J.R.R. Tolkien", "1954-07-29");
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", "1967-05-30");
        Libro libro3 = new Libro("1984", "George Orwell", "1949-06-08");

        List<Libro> librosDisponibles = new ArrayList<>();
        librosDisponibles.add(libro1);
        librosDisponibles.add(libro2);
        librosDisponibles.add(libro3);
        List<Libro> librosPrestados = new ArrayList<>();

        Biblioteca biblioteca =new Biblioteca(librosDisponibles, librosPrestados);


        while (true) {
            System.out.println("\nBienvenido a la biblioteca.");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar un libro nuevo");
            System.out.println("2. Prestar un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Mostrar catálogo completo");
            System.out.println("5. Mostrar libros prestados");
            System.out.println("6. Salir");

            int seleccion = scanner.nextInt();
            scanner.nextLine();

            switch (seleccion) {
                case 1:
                    System.out.println("Ingrese el título del libro:");
                    String tituloLibro = scanner.nextLine();
                    System.out.println("Ingrese el autor del libro:");
                    String autorLibro = scanner.nextLine();
                    System.out.println("Ingrese la fecha de publicación del libro (YYYY):");
                    String fechaPublicacionLibro = scanner.nextLine();

                    Libro nuevoLibro = new Libro(tituloLibro, autorLibro, fechaPublicacionLibro);
                    biblioteca.getLibrosDisponibles().add(nuevoLibro);

                    System.out.println("Libro agregado con éxito.");
                    break;
                case 2:
                    // Prestar un libro
                    System.out.println("Ingrese su nombre:");
                    String nombreUsuario = scanner.nextLine();
                    System.out.println("Ingrese el título del libro que desea prestar:");
                    String tituloLibroPrestar = scanner.nextLine();

                    Usuario usuario = new Usuario(nombreUsuario);

                    try {
                        biblioteca.prestar(usuario, tituloLibroPrestar);
                        System.out.println("Libro prestado con éxito.");
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    // Devolver un libro
                    System.out.println("Ingrese el título del libro que desea devolver:");
                    String tituloLibroDevolver = scanner.nextLine();

                    Libro libroDevuelto = biblioteca.getLibrosPrestados().stream()
                            .filter(libro -> libro.getTitulo().equals(tituloLibroDevolver))
                            .findFirst()
                            .orElse(null);

                    if (libroDevuelto != null) {
                        biblioteca.resivirDevolucion(libroDevuelto);
                        System.out.println("Libro devuelto con éxito.");
                    } else {
                        System.out.println("No se encontró ningún libro prestado con ese título.");
                    }
                    break;
                case 4:
                    // Mostrar catálogo completo
                    System.out.println("\nCatálogo completo de la biblioteca:");
                    for (Libro libro : biblioteca.getAllBooks()) {
                        System.out.println(libro.getTitulo() + " - " + libro.getAutor());
                    }
                    break;
                case 5:
                    // Mostrar libros prestados
                    System.out.println("\nLibros prestados:");
                    for (Libro libro : biblioteca.getLibrosPrestados()) {
                        System.out.println(libro.getTitulo() + " - " + libro.getAutor());
                    }
                    break;
                case 6:
                    // Salir
                    System.out.println("Gracias por utilizar la biblioteca. ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
