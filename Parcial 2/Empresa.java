import java.util.ArrayList;
import java.util.List;


public class Empresa {
    private List<Cliente> clientes;
    private List<Medidor> medidores;
    
    /**
     * Constructor. Inicializa la lista de clientes y medidores administrados por la Empresa
     */
    public Empresa(){
        clientes = new ArrayList<Cliente>();
        medidores = new ArrayList<Medidor>();
    }
        
    /**
     * 
     * @return la lista de Clientes de la empresa
     */
    public List<Cliente> getClientes(){
        return clientes;
    }
    
    /**
     * 
     * @return la lista de medidores administrados por la empresa
     */
    public List<Medidor> getMedidoresAdministrados(){
        return medidores;
    }
    
    /**
     * Devuelve el cliente de la empresa con el nombre especificado. 
     * No se distingue mayusculas o minusculas, es indistinto especificar "JUAN PEREZ"
     * o "juan Perez" como argumento. Ademas, deben eliminarse los espacios prefijos o sufijos. 
     * @param nombre el nombre del cliente a buscar
     * @return el cliente encontrado, o null en caso de no existir el cliente entre los clientes de la empresa
     * 
     */
    public Cliente getCliente(String nombre) {
        for (Cliente cliente : clientes) {
            if(cliente.getNombre().equals(nombre.trim().toLowerCase())) {
                return cliente;
            }
        }
        return null;
    }
    
    /**
     * Crea un nuevo medidor del tipo y con la ubicacion especificada, y lo agrega
     * a la lista de medidores administrados por la Empresa
     * 
     * @param tipo el TipoMedidor (DOMICILIARIO/COMERCIAL)
     * @param pos las coordenadas donde se ubicara el nuevo medidor
     * @return el medidor creado
     */
    public Medidor nuevoMedidor(TipoMedidor tipo, CoordenadaGPS pos){
        if(tipo == TipoMedidor.COMERCIAL) {
            Medidor medidor = new MedidorComercial(pos);

            medidores.add(medidor);
            return medidor;
        }
        if(tipo == TipoMedidor.DOMICILIARIO) {
            Medidor medidor = new MedidorDomiciliario(pos);

            medidores.add(medidor);
            return medidor;
        }
        return null;
    }
    
    /**
     * Crea un nuevo cliente con el nombre especificado  y lo agrega a la lista de clientes de la empresa
     * @param nombre el nombre del nuevo cliente a crear
     * @return el Cliente creado
     * @throws IllegalStateException si ya existe un cliente con ese nombre en la empresa
     */
    public Cliente nuevoCliente (String nombre) {
        Cliente cliente = new Cliente(nombre);
        clientes.add(cliente);
        return cliente;
        
        /*Falta desarrollar excepcion (esta incompleta): 
        if(clientes.contains(cliente)) {
            throw new IllegalStateException();
        }*/
    }

    /**
     * Asocia un medidor a un cliente    
     * @param c el cliente al cual asociar el medidor
     * @param m el medidor 
     * @throws IllegalStateException si el medidor no puede asociarse al cliente (por ejemplo, si ya tiene un medidor asociado)
     */
    public void asociarMedidor(Cliente c, Medidor m){
        if(c.getMedidorAsociado() != null) {
            throw new IllegalStateException();
        } else {
            c.asociarMedidor(m);
        }
    }
    
    
    /**
     * Remueve el medidor a un cliente, y lo elimina de la lista de medidores
     * administrados por la empresa
     * @param c el cliente sobre el que desasociar
     */
    public void disociarMedidor (Cliente c){
        if(c.getMedidorAsociado() != null) {
            c.removerMedidor();
            medidores.remove(c.getMedidorAsociado());
        } else {
            System.err.println("El cliente pasado por parametro no existe");
        }
    }
    
    
    /**
     * Obtiene el consumo para un periodo determinado. Si hay varias lecturas dentro del periodo
     * indicado, retorna el consumo total entre el la primera y la ultima lectura dentro del
     * periodo.
     * Ej: Si las lecturas del cliente son
     * Fecha (dia-anio) | Consumo
     * 20-2015            | 200
     * 50-2015            | 350
     * 85-2015            | 470
     * 120-2015            | 610
     * 150-2015            | 770
     * 
     * Si se solicita el consumo del periodo 30-2015 al 130-2015, las lecturas del periodo seran
     * Fecha (dia-anio) | Consumo
     * 50-2015            | 350
     * 85-2015            | 470
     * 120-2015            | 610
     * 
     * y el consumo del periodo sera 260
     * 
     * Si se solicita el consumo del periodo 30-2015 al 40-2015 lanza IllegalStateException
     * Si se solicita el consumo del periodo 50-2015 al 40-2015 lanza IllegalArgumentException
     *  
     * @param c El cliente sobre el cual se quiere facturar el consumo
     * @param desde fecha inicial
     * @param hasta fecha final
     * @return el consumo 
     * @throws IllegalArgumentException si la fecha desde es posterior a la fecha hasta
     * @throws IllegalStateException si no hay lecturas en el periodo 
     */
    public int consumoPeriodo (Cliente c, Fecha desde, Fecha hasta){
        // TODO Implementar el metodo
        return -1;
    }
    
}
