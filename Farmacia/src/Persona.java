/**
 *
 * @author agust
 */
public abstract class Persona {
    String apellido;
    String nombre;
    
    public Persona() {
        this.apellido = "";
        this.nombre = "";
    }
    
    public Persona(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public abstract String getApellido();

    public abstract void setApellido(String apellido);

    public abstract String getNombre();

    public abstract void setNombre(String nombre);
    
}
