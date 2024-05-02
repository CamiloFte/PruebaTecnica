import java.util.UUID;

public class Usuario {
    private UUID id;
    private String Nombre;

    public Usuario(String nombre) {
        Nombre = nombre;
        this.id=UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
