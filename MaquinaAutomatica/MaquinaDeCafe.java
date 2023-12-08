import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaquinaDeCafe implements MaquinaDeEstados {
    protected Producto seleccion;
    protected Estado estado = Estado.APAGADO;
    protected List <Recipiente> recipientes;
    protected int totalProductosServidos;
    protected Caja caja;
    protected List <Producto> productosDisponibles;
    
    /**
     * Constructor sin parametros.
     */
    public MaquinaDeCafe(){
        recipientes = new ArrayList<Recipiente>();
        productosDisponibles = new ArrayList<Producto>();
        totalProductosServidos = 0;
        caja = new Caja();
    }
    
    /**
     * Retorna la cantidad total de productos servidos por esta
     * maquina.
     * 
     * @return cantidad total de productos servidos
     */
    public int getTotalProductosServidos() {
        return totalProductosServidos;
    }
    
    /**
     * Retorna el total de dinero recaudado por esta maquina
     * 
     * @return total de dinero recaudado
     */
    public int getTotalRecaudacion(){
        return caja.getTotalRecaudado();
    }
    
    /**
     * Retorna el producto seleccionado
     *
     * @return el producto seleccionada en la maquina
     */
    public Producto getSeleccion() {
        return seleccion;
    }

    /**
     * Verifica si existe suficiente cantidad de un ingrediente
     *
     * @param ingrediente el ingrediente requerido
     * @param cantidadRequerida la cantidad requerida
     * @return true si existe suficiente ingrediente, false en
     * caso contrario
     */
    public boolean hayIngredienteDisponible (Ingrediente ingrediente, int cantidadRequerida){
        for (Recipiente r: recipientes){
            if (ingrediente == r.getTipoIngredienteAlmacenado()){
                if (r.getCantidadIngredienteDisponible()>=cantidadRequerida){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Verifica si es posible despachar el producto especificado
     * 
     * @param p el producto a despachar
     * @throws ProductoException si el producto especificado es
     * null, o no esta configurado en esta maquina, o existen
     * ingredientes faltantes en la receta.
     */
    public boolean validarProducto(Producto p) {
        if (p==null || p.getReceta()==null )
            return false;    
        Receta r =  p.getReceta();
        for (Ingrediente ing: r.getIngredientes()){
            if (!hayIngredienteDisponible(ing, r.getCantidadDeIngredienteRequerida(ing)))
                return false;
        }
        return true;
    }
    
    @Override
    public Estado getEstado() {
        return estado;
    }
    
    @Override
    public void operar() {
        //Done: Implementar metodo 
        if(!getEstado().equals(Estado.LISTO)) {
            throw new IllegalStateException();
        }
        estado = Estado.OPERANDO;
    }

    @Override
    public void restablecer() {
        //Done: Implementar metodo    
        if(estado.equals(Estado.APAGADO)) {
            throw new IllegalStateException();
        }
        estado = Estado.APAGADO;
    }

    @Override
    public void encender() {
        //Done: Implementar metodo   
        if(!estado.equals(Estado.APAGADO)) {
            throw new IllegalStateException();
        }
        estado = Estado.LISTO;
    }

    @Override
    public void apagar() {
        //Done: Implementar metodo 
        if(!estado.equals(Estado.LISTO)) {
            throw new IllegalStateException();
        }
        estado = Estado.APAGADO;
    }

    @Override
    public void mantener() {
        //Done: Implementar metodo   
        if(!getEstado().equals(Estado.LISTO)) {
            throw new IllegalStateException();
        }
        estado = Estado.LISTO;
    }
    
    /**
     * Programa el precio a un producto. Solo es posible programar
     * el precio en modo MANTENIMIENTO
     *
     * @param producto el producto al cual definir el precio
     * @param precio el precio del producto
     * @throws IllegalStateException cuando no esta en modo
     * MANTENIMIENTO
     */
    public void programarPrecioDeProducto(Producto producto, int precio){
        //Done: Implementar metodo
        if(!estado.equals(Estado.MANTENIMIENTO)) {
            throw new IllegalStateException();
        }
        producto.setPrecio(precio);
    }
    
    /**
     * Agrega una receta para un producto de la maquina de
     * cafe. Solo es valido en modo mantenimiento
     * 
     * @param p el Producto a configurar en la maquina
     * @param r la Receta correspondiente al producto a agregar
     * @throws IllegalStateException si la maquina no esta en modo
     * MANTENIMIENTO
     */
    public void programarRecetaDeProducto (Producto p, Receta r){
        //Done: Implementar metodo
        if(!estado.equals(Estado.MANTENIMIENTO)) {
            throw new IllegalStateException();
        }
        p.setReceta(r);
    }
    
    /**
     * Retorna una lista de ingredientes faltantes para las
     * recetas cargadas en la maquina
     * 
     * @return Lista de ingredientes faltantes.
     */
    public List<Ingrediente> getFaltantes(){
        //Done: Implementar metodo
        Map<Ingrediente, Integer> mapaIngredientesNecesarios = new TreeMap<>();
        Map<Ingrediente, Integer> mapaIngredientesActuales = new TreeMap<>();
        Ingrediente[] ingredientes = Ingrediente.values();
        List<Ingrediente> listaIngredientesFaltantes = new ArrayList<>();
        
        for(Producto producto : productosDisponibles) {
            mapaIngredientesActuales = producto.getReceta().getMapaDeIngredientes();

            for(Ingrediente ingrediente : ingredientes) {
                if(producto.getReceta().getCantidadDeIngredienteRequerida(ingrediente) != 0) {
                   mapaIngredientesNecesarios.put(ingrediente, producto.getReceta().getCantidadDeIngredienteRequerida(ingrediente));
                }
            }
            for(Ingrediente ingredienteNecesario : mapaIngredientesNecesarios.keySet()) {
                for(Ingrediente ingredienteActual : mapaIngredientesActuales.keySet()) {
                    if(ingredienteNecesario.equals(ingredienteActual) && mapaIngredientesNecesarios.get(ingredienteNecesario) > mapaIngredientesActuales.get(ingredienteActual)) {
                        listaIngredientesFaltantes.add(ingredienteNecesario);
                    }
                    if(!ingredienteNecesario.equals(ingredienteActual)) {
                        listaIngredientesFaltantes.add(ingredienteNecesario);
                    }
                }
            }
                        
        }
        
        return listaIngredientesFaltantes;
        
    }
    
    
    /**
     * Ejecuta la receta para el producto especificado, extrayendo
     * de cada recipiente la cantidad necesaria de ingredientes
     * para preparar la receta.
     * 
     * @param seleccion el producto seleccionado 
     * @throws ProductoException si por algun motivo no se puede
     * extraer la cantidad requerida de cada ingrediente.
     */
    public void prepararProducto(Producto seleccion) throws ProductoException {
        //Done: Implementar metodo
        try {
            Receta recetaDelProducto = seleccion.getReceta();
            int cantidadIngredientesRequeridos;

            for(Ingrediente ingrediente: recetaDelProducto.getIngredientes()) {
                cantidadIngredientesRequeridos = recetaDelProducto.getCantidadDeIngredienteRequerida(ingrediente);    
                for(Recipiente recipiente: recipientes) {
                    recipiente.extraer(cantidadIngredientesRequeridos);
                }
            }
        } catch (CapacidadExcedidaException | IllegalArgumentException e) {
            throw new ProductoException("No se puede extraer contenido del recipiente.");
        }
    
    }
    
    /**
     * Retorna el recipiente para el producto especificado
     *
     * @param ingrediente el ingrediente requerido
     * @return el recipiente que contiene el ingrediente
     * requerido, o null si no existe un recipiente para ese
     * ingrediente.
     */
    public Recipiente getRecipiente (Ingrediente ingrediente){
        //Done: Implementar metodo
        for(Recipiente recipiente: recipientes) {
            if(recipiente.getTipoIngredienteAlmacenado().equals(ingrediente)) {
                return recipiente;
            }
        }
        return null;
    }
    
    /**
     * Selecciona un producto para despachar. Solo es posible si
     * la maquina esta lista para despachar producto.  Configura
     * el precio del producto como precio a cobrar en la Caja, o 0
     * si la seleccion es null
     *
     * @param seleccion el producto a despachar
     * @throws IllegalStateException si la maquina no esta lista
     */
    public void setSeleccion(Producto seleccion) {
        //Done: Implementar metodo        
        if(!validarProducto(seleccion)) {
            throw new IllegalStateException();
        }
        if(seleccion == null) {
            caja.setPrecioACobrar(0);
        } else {
            caja.setPrecioACobrar(seleccion.getPrecio());
        }
        
    }
}
