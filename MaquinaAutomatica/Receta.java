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
	public void agregarIngrediente(Ingrediente ing, Integer cantidad){
		//TODO: Implementar metodo
	}
	
	/**
	 * Obtiene la lista de ingredientes de esta receta
	 *
	 * @return la lista de ingredientes de la receta
	 */
	public List<Ingrediente> getIngredientes(){
		//TODO: Implementar metodo
		return null;
	}
	
	/**
	 * Retorna la cantidad del ingrediente solicitado para esta
	 * receta. Si la receta no requiere este ingrediente, retorna 0
	 *
	 * @param ingrediente el ingrediente solicitado
	 * @return la cantidad de ingrediente requerida por la receta.
	 */
	public int getCantidadDeIngredienteRequerida (Ingrediente ingrediente){
		//TODO: Implementar metodo
		return -1;
	}
	
	/**
	 * Retorna el peso total de la receta (sumatoria de las
	 * cantidades de todos los ingredientes de la receta)
	 *
	 * @return el peso total de la receta
	 */
	public int volumenTotalReceta(){
		//TODO: Implementar metodo
		return -1;
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
		//TODO: Implementar metodo
		return "";
	}
}
