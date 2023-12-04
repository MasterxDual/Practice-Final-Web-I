import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class Receta {
    protected Map<Ingrediente, Integer> ingredientes;
    
    public Receta (){
        ingredientes = new TreeMap<Ingrediente,Integer>();
    }
    
    /**
     * Devuelve el mapa de ingredientes de la receta
     *
     * @return
     */
    public Map<Ingrediente, Integer> getMapaDeIngredientes(){
        return ingredientes;
    }
    
    /**
     * Agrega un ingrediente a la receta
     *
     * @param ing el Ingrediente a agregar a la receta
     * @param cantidad la cantidad de ingrediente a agregar a la receta
     * @throws IllegalArgumentException cuando el ingrediente o la
     * cantidad de ingredinte a agregar no es valida (ej. negativa)
     */
    public void agregarIngrediente(Ingrediente ing, Integer cantidad) {
        //Done: Implementar metodo
        if(cantidad < 0 || (ingredientes.get(ing) == null)) {
            throw new IllegalArgumentException();
        }
        ingredientes.put(ing, cantidad); //Devuelve un Integer, que hago con ese valor?
    }
    
    /**
     * Obtiene la lista de ingredientes de esta receta
     *
     * @return la lista de ingredientes de la receta
     */
    public List<Ingrediente> getIngredientes(){
        //Done: Implementar metodo
        return new ArrayList<Ingrediente> (ingredientes.keySet()); //Porque le puedo pasar como argumento al objeto creado? (lo vi en internet a la solucion)
    }
    
    /**
     * Retorna la cantidad del ingrediente solicitado para esta
     * receta. Si la receta no requiere este ingrediente, retorna 0
     *
     * @param ingrediente el ingrediente solicitado
     * @return la cantidad de ingrediente requerida por la receta.
     */
    public int getCantidadDeIngredienteRequerida (Ingrediente ingrediente){
        //Done: Implementar metodo
        /* Va este o el otro?
        if(!ingrediente.equals(Ingrediente.CAFE) && !ingrediente.equals(Ingrediente.LECHE) && !ingrediente.equals(Ingrediente.AZUCAR) && !ingrediente.equals(Ingrediente.CACAO) && !ingrediente.equals(Ingrediente.AGUA)) {
            return 0;
        }*/
        if(ingredientes.get(ingrediente) == null) {
            return 0;
        }
        return ingredientes.get(ingrediente);
    }
    
    /**
     * Retorna el peso total de la receta (sumatoria de las
     * cantidades de todos los ingredientes de la receta)
     *
     * @return el peso total de la receta
     */
    public int volumenTotalReceta(){
        //Done: Implementar metodo
        ArrayList<Integer> cantidadesIngredientes = new ArrayList<Integer> (ingredientes.values());
        int sumaTotal = 0;
        
        for(Integer lista: cantidadesIngredientes) {
            sumaTotal += lista;    
        }
        
        return sumaTotal;
    }
    
    /**
     * Retorna un String con el siguiente formato:
     * 
     *  "Receta: <Ingrediente1>[<Cantidad1>];<Ingrediente2>[<Cantidad2>];...;<<IngredienteN>[<CantidadN>];"
     *  
     *  Ej.: "Receta: AZUCAR[5];CAFE[15];AGUA[150];"
     *    
     */
    public String toString(){
        //Done: Implementar metodo
        StringBuilder cadena = new StringBuilder("Receta: ");
    
        for (int x = 0; x < ingredientes.size(); x++) {
            cadena.append(getIngredientes().get(x)).append("[").append(ingredientes.get(getIngredientes().get(x))).append("];");
        }
    
        return cadena.toString();
    }
}
