public class App {
    /**
     * Esta clase es de utilidad para ejecutar el programa como
     * un todo. No se la utiliza dentro de BlueJ.
     */
    public static void main(String[] args) throws Exception {
        GestorFiguras g = new GestorFiguras();

        g.crearFigurasAleatoriamente(3);

        System.out.println("Lista sin Ordenar:");
        g.listarFigurasColeccionadas();
        System.out.println("-------");

        System.out.println("Lista Ordenada segun Superficie y luego segun Id:");
        g.listarFigurasOrdenadas();
        System.out.println("-------");

        System.out.println("Lista Segun Distancia al Origen:");
        g.listarFigurasSegunDistanciaAlOrigen();
    }
}
