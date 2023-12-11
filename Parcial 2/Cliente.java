import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private Medidor medidor;
    private List<Lectura>lecturas;
    
    /**
     * Constructor
     * @param nombre Nombre del cliente. El nombre debe persistirse en
     * minusculas y sin espacios al principio o fin de la cadena.
     */
    public Cliente (String nombre){
        this.nombre = nombre.trim().toLowerCase();
        lecturas = new ArrayList<>();
        this.medidor = null;
    }
    
    /**
     * Retorna el nombre del cliente
     * @return
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * 
     * @return el Medidor asociado al cliente (Null si no tiene)
     */
    public Medidor getMedidorAsociado(){
        return medidor;
    }
    
    /**
     * 
     * @return la lista de Lecturas realizadas sobre el medidor del cliente
     */
    public List<Lectura> getLecturas(){
        return lecturas;
    }
    
    /**
     * Agrega una lectura a la lista de lecturas del medidor. La fecha tiene que ser posterior a la
     * a la ultima lectura realizada.
     * 
     * @param lectura La lectura a agregar
     * @throws IllegalStateException cuando el cliente no tiene medidor asociado.
     * @throws LecturaInconsistenteException cuando la lectura es anterior a la ultima lectura de la lista
     * o cuando el valor leido es inferior al valor de la ultima lectura
     * 
     */
    public void agregarLectura (Lectura lectura) throws LecturaInconsistenteException{
        // Done Implementar el metodo
        Lectura ultimaLectura = lecturas.get(lecturas.size() - 1);
        
        if(this.getMedidorAsociado() == null) {
            throw new IllegalStateException();
        }
        if(lectura.getFechaDeLectura().compareTo(ultimaLectura.getFechaDeLectura()) < 0 || lectura.getValorDeLectura() < ultimaLectura.getValorDeLectura()) {
            throw new LecturaInconsistenteException("La lectura es inconsistente");
        }
        /* No habia visto el metodo validarLectura(lectura, lista). La de abajo es la solucion reutilizando codigo (validarLectura())
        if(!validarLectura(lectura, lecturas)) {
            throw new LecturaInconsistenteException("La lectura es inconsistente");
        } */
        if(lectura.getFechaDeLectura().compareTo(ultimaLectura.getFechaDeLectura()) > 0) {
            lecturas.add(lectura);    
        }
        
    }
    
    
    /**
     * Asocia un medidor a este cliente, si es que no tiene ningun medidor asociado. Si el 
     * cliente ya tiene un medidor asociado, ignora esta nueva asociacion.
     * @param m el Medidor a asociar
     * @return true si se pudo asociar el medidor, false si el cliente ya tiene un medidor asociado.
     */
    public boolean asociarMedidor(Medidor m){
        // Done Implementar el metodo
        if(this.getMedidorAsociado() == null) {
            this.medidor = m;
            return true;
        }
        return false;
    }
    
    /**
     *     Remueve el medidor asociado a este cliente, y la lista de lecturas asociadas
     */
    public void removerMedidor() {
        // Done Implementar el metodo
        for(Lectura lectura : lecturas) {
            if(lectura.getMedidorId().equals(this.medidor.getId())) {
                lecturas.remove(lectura);
            }
        }
        this.medidor = null;
    }
    
    
    
    private boolean validarLectura(Lectura lectura, List<Lectura> lista) {
        if (! lista.isEmpty()){
            Lectura ultima = lista.get(lista.size()-1);
            if (lectura.getFechaDeLectura().compareTo(ultima.getFechaDeLectura()) < 0 
                    || lectura.getValorDeLectura() < ultima.getValorDeLectura()) 
                return false;
        }    
        return true;
    }
    
    /**
     * Retorna un string con el siguiente formato:
     * "Cliente: <nombre_del_cliente> - Medidor: <medidor_id>" cuando tiene un medidor asociado
     * "Cliente: <nombre_del_cliente> - Medidor: N/A" cuando no tienen un medidor asociado
     *
     */
    public String toString() {
        if(medidor.getId().isEmpty()) {
            return "Cliente: " + nombre + " - Medidor: N/A\n";
        } else {
            return "Cliente: " + nombre + " - Medidor: " + medidor.getId() + "\n";
        }
    }
}