
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agust
 */
public class Cliente extends Persona {
    private long dni;
    
    public Cliente() {
        super();
    }
    
    public Cliente(String apellido, String nombre, long dni) {
        super(apellido, nombre);
        this.dni = dni;
    }
    
    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }
    
    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
