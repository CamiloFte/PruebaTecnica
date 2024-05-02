import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Biblioteca {
    private List<Libro> librosDisponibles;
    private List<Libro> librosPrestados;

    public Biblioteca(List<Libro> librosDisponibles, List<Libro> librosPrestados) {
        this.librosDisponibles = librosDisponibles;
        this.librosPrestados = librosPrestados;
    }

    public Biblioteca() {
    }

    public List<Libro> getLibrosDisponibles() {
        return librosDisponibles;
    }

    public void setLibrosDisponibles(List<Libro> librosDisponibles) {
        this.librosDisponibles = librosDisponibles;
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(List<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }
    public Boolean prestar(Usuario usuario,String TituloLibro){
        List<Libro> libroPrestamo=librosDisponibles.stream().filter(libro->libro.getTitulo().equals(TituloLibro)).toList();
        libroPrestamo.get(0).setPrestamo(true);
        libroPrestamo.get(0).setUsuarioPrestamo(usuario);
        if(!libroPrestamo.isEmpty()) {
            this.librosDisponibles = librosDisponibles.stream().filter(libroEliminar -> !libroEliminar.getId().equals(libroPrestamo.get(0).getId())).toList();
            this.librosPrestados.add(libroPrestamo.get(0));
            return true;
        }else{
            throw new NoSuchElementException("Titulo "+TituloLibro+" no encontrado");
        }

    }
    public Boolean resivirDevolucion(Libro libro){
        this.librosPrestados = librosPrestados.stream().filter(libroEliminar -> !libroEliminar.getId().equals(libro.getId())).toList();
        List<Libro> nuevaListaDisponibles = new ArrayList<>(this.librosDisponibles);
        nuevaListaDisponibles.add(libro);
        this.librosDisponibles= nuevaListaDisponibles;
        return true;
    }

    public List<Libro> getAllBooks(){
        ArrayList<Libro> lista = new ArrayList<>();
        lista.addAll(this.librosDisponibles);
        lista.addAll(this.librosPrestados);
        return lista;
    }
}
