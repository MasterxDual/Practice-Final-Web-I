import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Equipo boca = new Equipo("Boca");
        Equipo river = new Equipo("River");
        
        //Testeando Equipos
        System.out.println(boca.toString());
        System.out.println(river.toString());
        
        boca.addGol();
        boca.addPuntaje(15);
        boca.addPartidosDisputados();
        System.out.println("-----");
        System.out.println(boca.toString());
        
        pausaYLimpiezaConsola();

        //Testeando Partidos
        Partido partido1 = new Partido(boca, river);
        System.out.println(partido1.toString()); 
        partido1.addGol(boca);
        partido1.setEnJuego();
        partido1.addGol(boca);
        System.out.println(partido1.toString()); 
        partido1.setFinalizado();
        System.out.println(partido1.toString()); 
        System.out.println(partido1.isFinalizado()); 
        System.out.println(boca.toString());

        //Testeando Torneo por Puntos
        pausaYLimpiezaConsola();
        TorneoPorPuntos torneo = new TorneoPorPuntos();
        //De esta forma podes agregar equipos indefinidamente, cuando quieras
        List <Equipo> equipos = new ArrayList<>();
        equipos.add(river);
        equipos.add(boca);
        //Esta forma es mas concisa pero no se pueden agregar mas elementos
        List<Equipo> equiposv2 = Arrays.asList(boca, river);
        torneo.InicializarTorneo(equiposv2);
        torneo.imprimirEncuentros();
        Partido miProximaFecha = torneo.obtenerProximaFecha();
        System.out.println("Proxima fecha: " + miProximaFecha);

        //Testeando Tabla de Resultados
        TablaResultados tabla = new TablaResultados(equiposv2);
        tabla.CalcularPosiciones();
        torneo.setTablaPosiciones(tabla);
        torneo.imprimirTablaPosiciones();
    }

    public static void pausaYLimpiezaConsola() {
        Scanner s = new Scanner(System.in);
        s.next();
        System.out.print("\033\143");
    }
}
