/*
 * Excepcion para falla en capacidad del recipiente
 */
public class CapacidadExcedidaException extends Exception {
    //Agregado este metodo por mi
    public CapacidadExcedidaException(String s) {
        super(s);
    }
}
