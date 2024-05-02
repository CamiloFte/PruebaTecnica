import java.time.LocalDate;
import java.util.UUID;

public class Libro {
    private String Titulo;
    private String Autor;
    private String fechaPublicacion;
    private Usuario usuarioPrestamo;
    private Boolean prestamo;
    private UUID id;

    public Libro(String titulo, String autor, String fechaPublicacion) {
        Titulo = titulo;
        Autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.id= UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Libro() {
        this.id= UUID.randomUUID();
    }

    public Usuario getUsuarioPrestamo() {
        return usuarioPrestamo;
    }

    public void setUsuarioPrestamo(Usuario usuarioPrestamo) {
        this.usuarioPrestamo = usuarioPrestamo;
    }

    public Boolean getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Boolean prestamo) {
        this.prestamo = prestamo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
