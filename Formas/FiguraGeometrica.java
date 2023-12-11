// Clase abstracta -> no se puede instanciar
//                    si puedo heredar de ella
public abstract class FiguraGeometrica implements Comparable<FiguraGeometrica> {
    private String id;
    private Posicion posicion;

    protected FiguraGeometrica () {
        posicion = new Posicion();
    }

    // Metodo compareTo() -> debe implementarse en las subclases

    // Metodos abstractos -> deben implementarse en las subclases
    public abstract Double getSuperficie ();
    public abstract Double getPerimetro ();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public String toString () {
        return "Figura " + id + " " + posicion.toString() + " -- Distancia=" + posicion.distanciaAlOrigen();
    }
}
