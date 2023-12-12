import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Un supermercado formado por un conjunto de gondolas
 * 
 * @author Informatica Avanzada 2014
 * @version 1.0
 */
public class Supermercado
{
    private ArrayList<Gondola> gondolas;
    private String nombre;

    /**
     * Constructor de la clase Supermercado
     */
    public Supermercado(String nombre)
    {
        gondolas = new ArrayList<>();
        this.nombre = nombre;
    }
    
    
    /**
     * Agrega gondolas al supermercado
     * 
     * @param   gondola    la gondola a agregar
     */
    public void agregarGondola(Gondola gondola)
    {
        gondolas.add(gondola);
    }
    
    
    /**
     * Devuelve la cantidad de gondolas que posee 
     * un supermercado
     * 
     * @return La cantidad de gondolas
     */

    public int getCantidadDeGondolas()
    {
        return gondolas.size();
    }
    
    
    /**
     * Devuelve el nombre del supermercado
     * 
     * @return El nombre del supermercado
     */
    public String getNombre()
    {
        return nombre;
    }
    
    
    /**
     * Obtiene los distintos productos que se venden
     * en el supermercado
     * 
     * @return Los productos que se venden
     */
    public HashSet<Producto> getConjuntoDeProductos() {
        HashSet<Producto> conjuntoProductos = new HashSet<>();

        for (Gondola gondola: gondolas) {
            conjuntoProductos.addAll(gondola.getProductos());
        }
        return conjuntoProductos;
    }
    
    
    /**
     * Devuelve los detalles de todos los productos
     * que se venden en el supermercado como un String
     * 
     * @return String Los productos en venta
     */
    public String getProductosEnVenta() {
        StringBuilder productos = new StringBuilder();

        for (Producto producto: getConjuntoDeProductos()) {
            productos.append(producto.getDetalles());
        }
        return productos.toString();
    }    
    
    /**
     * Imprime los detalles de los distintos productos que se venden en el supermercado
     */
    public void imprimirProductosEnVenta() {
        System.out.println(getProductosEnVenta());
    }    
}


