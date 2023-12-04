/*
 * Implementa la facturacion de la maquina de cafe
 */

public class Caja {

    protected int precioACobrar;
    protected int saldoActual;
    protected int totalRecaudado;
    protected int operacionesRealizadas;
    public static final int [] BILLETES_ACEPTADOS = {2,5,10,20}; 
    
    /**
     * Constructor por defecto
     */
    public Caja (){
        precioACobrar = 0;
        saldoActual = 0;
        totalRecaudado = 0;
        operacionesRealizadas = 0;
    }

    /**
     * Retorna el precio a cobrar configurado
     *
     * @return el precio
     */
    public int getPrecioACobrar() {
        return precioACobrar;
    }
    
    /**
     * Retorna el saldo disponible para realizar una compra
     *
     * @return el saldo
     */
    public int getSaldoActual() {
        return saldoActual;
    }
    
    /**
     * Retorna el total recaudado en la caja
     *
     * @return el total recaudado
     */
    public int getTotalRecaudado() {
        return totalRecaudado;
    }
    
    /**
     * Retorna la cantidad de operaciones que se realizaron en la
     * caja
     *
     * @return cantidad de operaciones realizadas
     */
    public int getTotalOperacionesRealizadas() {
        return operacionesRealizadas; 
    }

    /**
     * Operacion que se ejecuta cuando se retira el dinero
     * cargado, resetando el saldo actual
     */
    public void devolverSaldo(){
        saldoActual=0;
    }
    
    /**
     * Configura el precio a cobrar en la proxima operacion
     *    
     * @param precioACobrar
     */
    public void setPrecioACobrar(int precioACobrar) {
        //Done: Implementar metodo
        this.precioACobrar = precioACobrar;
    }
    
    /**
     * Verifica si el saldo disponible es suficiente para realizar
     * una operacion
     *
     * @return true si el saldo es suficiente, false en caso
     * contrario
     */
    public boolean saldoSuficiente(){
        //Done: Implementar metodo
        return saldoActual > 0;
    }
    
    /**
     * Completa una operacion de venta, actualizando las
     * estadisticas de la caja, como el total recaudado,
     * operaciones realizadas, saldo disponible, etc.
     * 
     * @throws IllegalStateException cuando el saldo es
     * insuficiente para realizar la venta.
     */
    public void completarVenta(){
        //Done: Implementar metodo No se si esta bien
        if(!saldoSuficiente()) {
            throw new IllegalStateException();
        }
        operacionesRealizadas++;
        totalRecaudado += precioACobrar;
    }
    
    /**
     * Agrega dinero para realizar una operacion, actualizando el
     * saldo disponible.  Solo es posible agregar montos
     * correspondientes a BILLETES_ACEPTADOS.
     *  
     * @param monto el monto a agregar
     * @throws IllegalArgumentException cuando el monto no
     * corresponde con un BILLETE_ACEPTADOS
     */
    public void agregarSaldo (int monto){
        //Done: Implementar metodo
        int count = 0;
        for(int billete: BILLETES_ACEPTADOS) {
            if(monto % billete != 0) {
                count++;
            }
        }
        if(count == 4) {
            throw new IllegalArgumentException();
        }
        this.saldoActual += monto;
    }
}
