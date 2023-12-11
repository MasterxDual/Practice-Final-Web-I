public class Rectangulo extends FiguraGeometrica {
    // La constante se usa para BASE y ALTURA
    private static final Integer MAX_LADO = 500;
    // El numero de serie del primer objeto es 1
    // No se puede repetir el numero para dos rectangulos
    private static Integer nroSerie = 1;
    private Integer base;
    private Integer altura;

    /**
     * Constructor que utiliza el mismo valor de la base
     * para la altura.
     * Debe generar el ID con la forma
     *    "RectanguloX"
     * siendo X el numero de serie correspondiente.
     * Configurarlo con setId() de la superclase.
     */
    public Rectangulo(Integer base) {
        // Done - Implementar el metodo
        this.base = base;
        this.altura = base;
        setId("Rectangulo" +  Rectangulo.nroSerie);
        Rectangulo.nroSerie++;
    }

    /**
     * Constructor que recibe los valores de la base
     * y de la altura.
     * Debe generar el ID con la forma
     *    "RectanguloX"
     * siendo X el numero de serie correspondiente.
     * Configurarlo con setId() de la superclase.
     */
    public Rectangulo(Integer base, Integer altura) {
        // Done - Implementar el metodo
        this.base = base;
        this.altura = altura;
        setId("Rectangulo" + Rectangulo.nroSerie);
        Rectangulo.nroSerie++;
    }

    /**
     * Calcula el perimetro de la figura.
     * @return El perimetro.
     */
    public Double getPerimetro () {
        // Done - Implementar el metodo
        return ((this.base.doubleValue())*2) + ((this.altura.doubleValue())*2);
    }

    /**
     * Calcula la superficie de la figura.
     * @return La superficie.
     */
    public Double getSuperficie () {
        // Done - Implementar el metodo
        return ((this.base.doubleValue())*(this.altura.doubleValue()));
    }

    public Integer getBase() {
        return base;
    }

    /**
     * Configura la base controlando que sea mayor que cero
     * y menor que MAX_LADO.
     * @param altura La base a configurar.
     */
    public void setBase(Integer base) {
        // Done - Implementar el metodo
        if(base>0 && base<MAX_LADO) {
            this.base = base;
        } else {
            System.err.println("Esta estableciendo una base invalida, vuelva a intentarlo");
        }
    }

    public Integer getAltura() {
        return altura;
    }

    /**
     * Configura la altura controlando que sea mayor que cero
     * y menor que MAX_LADO.
     * @param altura La altura a configurar.
     */
    public void setAltura(Integer altura) {
        // Done - Implementar el metodo
        if(altura>0 && altura<MAX_LADO) {
            this.altura = altura;
        } else {
            System.err.println("Esta estableciendo una altura invalida, vuelva a intentarlo");
        }
    }

    /**
     * Compara el rectangulo con cualquier otra figura geometrica
     * devolviendo -1, 0 o 1 segun sea menor, igual o mayor.
     * La comparacion se hace primero por superficie y luego por ID
     * de los objetos. En ambos casos en el orden natural.
     * @return El entero indicando la comparacion.
     */
    @Override
    public int compareTo(FiguraGeometrica f) {
        // Done - Implementar el metodo
        if(this.getSuperficie() < f.getSuperficie()) {
            return -1;
        } else if(this.getSuperficie() > f.getSuperficie()) {
            return 1;
        } else {
            if(this.getId().compareTo(f.getId()) < 0) {
                return -1;
            } else if(this.getId().compareTo(f.getId()) > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Genera un numero unico para cada objeto creado.
     * @return El numero de serie a usar.
     */
    public Integer getNroSerie() {
        // Done - Implementar el metodo
        return nroSerie;
    }

    /**
     * Devuelve lo reportado en el toString() de la superclase
     * y le agrega la base y altura del rectangulo con el formato
     *   " ++ Altura=x, Base=y"
     * siendo x e y los valores de los campos.
     * @return El texto asociado.
     */
    @Override
    public String toString() {
        // Done - Implementar el metodo
        return super.toString() + " ++ Altura=" + this.altura + ", Base=" + this.base;
    }

}