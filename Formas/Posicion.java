public class Posicion implements Comparable<Posicion> {
    private Integer x;
    private Integer y;

    /**
     * Calcula la distancia entre la posicion y el origen (0,0).
     * @return La distancia al origen.
     */
    public Double distanciaAlOrigen () {
        // Done - Implementar el metodo
        return Math.sqrt(Math.pow(this.getX().doubleValue(), 2) + Math.pow(this.getY().doubleValue(), 2));
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * Devuelve la posicion como un par ordenado, sin espacios en blanco.
     * @return El par ordenado.
     */
    public String toString() {
        // Done - Implementar el metodo
        return "(x = " + this.getX() + " , y = " + this.getY() + ")";
    }

    /**
     * Compara la posicion con cualquier otra posicion
     * devolviendo -1, 0 o 1 segun sea menor, igual o mayor la distancia al origen.0
     * @return El entero indicando la comparacion.
     */
    @Override
    public int compareTo(Posicion otherPosition) {
        // Done - Implementar el metodo
        if(this.distanciaAlOrigen() < otherPosition.distanciaAlOrigen()) {
            return -1;
        } else if(this.distanciaAlOrigen() > otherPosition.distanciaAlOrigen()) {
            return 1;
        } else {
            return 0;
        }
    }
}
