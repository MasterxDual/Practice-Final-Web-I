import java.util.List;
import java.util.Iterator;

public class Torneo {
    protected List<Equipo> clubes;
    private List<Partido> encuentros;
    private TablaResultados resultados;
    private Iterator<Partido> proximaFechaIterator;
    Partido proximaFecha;    

    /**
     * Inicializa el Torneo con los equipos indicados.
     * 
     * @param equipos Los equipos del torneo.
     */
    public void InicializarTorneo (List<Equipo> equipos) {
        // Ver subclase TorneoPorPuntos
    }

    /**
     * Espera una lista de equipos y la guarda.
     * 
     * @param equipos Los equipos a registrar.
     */
    public void setEquipos(List<Equipo> equipos){
        this.clubes = equipos;
    }

    /**
     * Espera la tabla de posiciones y la guarda.
     * 
     * @param tabla La tabla de posiciones.
     */
    public void setTablaPosiciones(TablaResultados tabla){
        this.resultados = tabla;
    }

    /**
     * Recibe todos los partidos a ser disputados en el torneo.
     * Debe además setear los valores iniciales del iterador 
     * y de la proxima fecha.
     * 
     * @param encuentros La lista de los partidos a disputar.
     */
    public void setEncuentros(List<Partido> encuentros){
        //Done
        this.encuentros = encuentros;
        proximaFechaIterator = encuentros.iterator();
        if(proximaFechaIterator.hasNext()) {
            proximaFecha = proximaFechaIterator.next();
        }
    }

    /**
     * Cambia a la proxima fecha. Para ello deben cumplirse dos condiciones
     * 1. Que el partido este finalizado, de lo contrario imprime el mensaje:
     *       ERROR: El resultado del partido no ha sido cargado
     * 2. Que haya una proxima fecha por jugar, de lo contrario imprime el
     *    mensaje:
     *       ERROR: El torneo ha finalizado
     * 
     * @return Partido El proximo partido a jugarse si se cumplen las
     *         condiciones, de lo contrario retorna null.
     */
    public Partido moverFecha(){
        //Done
        if(proximaFecha.isFinalizado()) {
            if(proximaFechaIterator.hasNext()) {
               proximaFecha = proximaFechaIterator.next();
                return proximaFecha;
                
            } else {
                System.err.println("El torneo ha finalizado");
            }
        } else {
            System.err.println("El resultado del partido no ha sido cargado");
        }
        return null;
    }

    public Partido obtenerProximaFecha(){
        return proximaFecha;
    }

    public boolean isFinalizado(){
        return !(this.proximaFechaIterator.hasNext());
    }

    public List<Partido> getPartidos(){
        return this.encuentros;
    } 

    /**
     * Imprime por pantalla los resultados de los encuentros.
     */
    public void imprimirEncuentros() {
        //Done
        System.out.println("-----Partidos-----");
        for (Partido partido: encuentros) {
            System.out.println(partido);
        }
        System.out.println("----------------");
    }

    /**
     * Imprime por pantalla la tabla de posiciones.
     */
    public void imprimirTablaPosiciones() {
        //Done
        System.out.println("-----Posiciones-----");
        System.out.println(resultados);
        System.out.println("----------------");
    }

}
