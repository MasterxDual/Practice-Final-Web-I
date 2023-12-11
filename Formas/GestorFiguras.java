import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorFiguras {
    // HerramientaDeAzar provee las funcionalidades para
    // la generacion de objetos aleatoriamente.
    private HerramientaDeAzar generador;
    // Coleccion para almacenar los objetos a usar
    private List<FiguraGeometrica> figuras;

    /**
     * Inicializa la aplicacion.
     * Debe construir los objetos HerramientaDeAzar y
     * la coleccion de figuras geometricas.
     */
    public GestorFiguras () {
        // Done - Implementar el metodo
        this.generador = new HerramientaDeAzar(System.currentTimeMillis());
        this.figuras = new ArrayList<>();
    }

    public List<FiguraGeometrica> getFiguras () {
        return figuras;
    }

    public HerramientaDeAzar getAzar () {
        return generador;
    }
    
    /**
     * Agrega una figura geometrica a la coleccion.
     * @param f La figura para agregar.
     */
    public void agregarFigura (FiguraGeometrica f) {
        figuras.add(f);
    }

    /**
     * Agrega una figura geometrica aleatoria a la coleccion.
     * Se solicita la figura a la clase HerramientaDeAzar.
     */
    public void agregarFiguraAleatoria () {
        // Done - Implementar el metodo
        figuras.add(generador.getFiguraAleatoria());
    }

    /**
     * Crea la cantidad de figuras indicadas y las incorpora
     * a la coleccion. Las figuras se generan aleatoriamente
     * mediante la clase HerramientaDeAzar.
     * @param cantidad La cantidad de figuras a crear.
     */
    public void crearFigurasAleatoriamente(Integer cantidad) {
        // Done - Implementar el metodo
        if(cantidad != 0) {
            while (cantidad != 0) {
                figuras.add(generador.getFiguraAleatoria());
                cantidad--;
            }
        } else {
            throw new IllegalArgumentException("La cantidad indicada debe ser distinta de cero, vuelva a intentarlo.");
        }
    }

    /**
     * Muestra por pantalla la informacion de todas las figuras
     * geometricas coleccionadas usando toString().
     */
    public void listarFigurasColeccionadas() {
        // Done - Implementar el metodo
        for (FiguraGeometrica figuraGeometrica : figuras) {
            System.out.println(figuraGeometrica.toString());
        }
    }

    /**
     * Muestra por pantalla la informacion de todas las figuras
     * geometricas coleccionadas usando toString() pero ordenadas
     * en su orden natural.
     */
    public void listarFigurasOrdenadas() {
        // Done - Implementar el metodo
        //Ordena segun el compareTo de cada figura que herede de FiguraGeometrica (Preguntar porque)
        Collections.sort(figuras);
        for (FiguraGeometrica figuraGeometrica : figuras) {
            System.out.println(figuraGeometrica.toString());
        }
    }

    /**
     * Muestra por pantalla la informacion de todas las figuras
     * geometricas coleccionadas usando toString() pero ordenadas
     * segun la distancia a la posicion indicada.
     * Agregar al toString() de las figuras geometricas una linea
     * con el formato
     *      " -- Distancia=X"
     * donde X es la distancia al origen.
     */
    public void listarFigurasSegunDistanciaAlOrigen() {
        // Done - Implementar el metodo
        /*Sin utilizar Lambda Function:
        Collections.sort(figuras, new SortByDistance());*/
        //Utilizando Lambda Function:
        Collections.sort(figuras, (a, b) -> {
            return a.getPosicion().distanciaAlOrigen().compareTo(b.getPosicion().distanciaAlOrigen());
        });
        for (FiguraGeometrica figuraGeometrica : figuras) {
            System.out.println(figuraGeometrica.toString());
        }
    }

}

/*Sin utilizar Lambda Function:
class SortByDistance implements Comparator<FiguraGeometrica> {
    @Override
    public int compare(FiguraGeometrica a, FiguraGeometrica b) {
        return a.getPosicion().distanciaAlOrigen().compareTo(b.getPosicion().distanciaAlOrigen());
    }
}
*/