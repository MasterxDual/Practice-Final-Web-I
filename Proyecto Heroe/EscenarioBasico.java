
import java.util.ArrayList;

public class EscenarioBasico extends Escenario {
    private ArrayList<PersonajeNoJugador> personajes;

    /**
     * Crea un escenario basico con nombre y capacidad de alojar
     * personajes no jugadores.
     *
     * @param nombre El nombre del escenario
     * @param capacidad La cantidad de Personajes no jugadores que pueden
     *                  agregarse
     */
    public EscenarioBasico(String nombre, Integer capacidad) {
        // TODO - Implementar el constructor
    }

    /**
     * Visita el escenario actualizando el escenarioActual del personaje
     * y agregandolo a la lista de visitantes.
     *
     * @param p el personaje jugador que visita el escenario
     * @throws IllegalStateException si el personaje jugador tiene un arma como elemento actual
     */
    @Override
    public void visitar(PersonajeJugador p) {
        // TODO - Implementar el metodo
    }

    /**
     * Agrega un personaje no jugador al escenario.
     *
     * @param p el personaje no jugador a agregar
     * @throws IllegalStateException si el escenario esta lleno y no puede agregar mas personajes
     */
    public void addPersonaje (PersonajeNoJugador p) {
        // TODO - Implementar el metodo
    }

    /**
     * Devuelve una lista de PersonajeNoJugador que representa los personajes
     * no jugadores actualmente en el escenario.
     *
     * @return la lista de personajes no jugadores en el escenario
     */
    public ArrayList<PersonajeNoJugador> getPersonajes() {
        // TODO - Implementar el metodo
    }
}
