import java.util.ArrayList;
import java.util.List;

public class Arma extends Elemento {
    List<Municion> municiones;
    TipoMunicion tipoMunicion;

    /**
     * Constructor de Arma
     * @param nombre
     * @param tipoMunicion
     */
    public Arma (String nombre, TipoMunicion tipoMunicion) {
        // Done - Implementar el constructor
        super(nombre);
        this.tipoMunicion = tipoMunicion;
        this.municiones = new ArrayList<>();
    }

    /**
     * Agrega la municion a la lista de municiones.
     * Lanza MunicionNoValidaException si la municion no coincide con el tipo
     * de municion del arma.
     * @param m la municion a cargar
     * @throws MunicionNoValidaException si la municion no coincide con el
     *           tipo de municion del arma.
     */
    public void cargar (Municion m) throws MunicionNoValidaException {
        // Done - Implementar el metodo
        if(!tipoMunicion.equals(m.getTipo())) {
            throw new MunicionNoValidaException("Tipo de municion incompatible");
        }
        municiones.add(m);
    }

    /**
     * Remueve la primera municion de la lista y retorna el danio
     * de la misma.
     * Arroja ArmaDescargadaException si no hay municiones
     * @return el valor de danio de la municion removida
     * @throws ArmaDescargadaException si no hay municiones disponibles
     */
    public Integer disparar () throws ArmaDescargadaException {
        // Done - Implementar el metodo
        if(!this.isCargada()) {
            throw new ArmaDescargadaException("El arma no contiene municiones");
        }
        
        return municiones.remove(0).getDanio();
    }

    /**
     * Verifica si existen municiones cargadas en la lista.
     * @return true si hay municiones cargadas, false de lo contrario
     */
    public Boolean isCargada() {
        // Done - Implementar el metodo
        return !municiones.isEmpty();
    }
}
