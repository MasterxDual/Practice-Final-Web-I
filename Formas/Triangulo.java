public class Triangulo extends FiguraGeometrica {
    // La constante se usa para BASE y ALTURA
    private static final Integer MAX_ALTURA = 1000;
    // El numero de serie del primer objeto es 1
    // No se puede repetir el numero para dos triangulos
    private static Integer nroSerie = 1;
    private Integer base;
    private Integer altura;

    /**
     * Constructor que utiliza el mismo valor de la base
     * para la altura.
     * Debe generar el ID con la forma
     *    "TrianguloX"
     * siendo X el numero de serie correspondiente.
     * Configurarlo con setId() de la superclase.
     */
    public Triangulo (Integer base) {
        // Done - Implementar el metodo
        this.base = base;
        this.altura = base;
        setId("Triangulo" + nroSerie);
        nroSerie++;
    }

    /**
     * Constructor que recibe los valores de la base
     * y de la altura.
     * Debe generar el ID con la forma
     *    "TrianguloX"
     * siendo X el numero de serie correspondiente.
     * Configurarlo con setId() de la superclase.
     */
    public Triangulo (Integer base, Integer altura) {
        // Done - Implementar el metodo
        this.base = base;
        this.altura = altura;
        setId("Triangulo" + nroSerie);
        nroSerie++;
    }

    /**
     * Calcula el perimetro de la figura.
     * @return El perimetro.
     */
    public Double getPerimetro () {
        // Done - Implementar el metodo
        return (base.doubleValue()*3);
    }

    /**
     * Calcula la superficie de la figura.
     * @return La superficie.
     */
    public Double getSuperficie () {
        // Done - Implementar el metodo
        return (this.base.doubleValue()*this.altura.doubleValue())/2;
    }

    public Integer getBase() {
        return base;
    }

    /**
     * Configura la base controlando que sea mayor que cero
     * y menor que MAX_ALTURA.
     * @param altura La base a configurar.
     */
    public void setBase(Integer base) {
        // Done - Implementar el metodo
        if(base > 0 && base < MAX_ALTURA) {
            this.base = base;
        } else {
            System.err.println("La base establecida es invalida, vuelva a intentarlo");
        }
    }

    public Integer getAltura() {
        return altura;
    }

    /**
     * Configura la altura controlando que sea mayor que cero
     * y menor que MAX_ALTURA.
     * @param altura La altura a configurar.
     */
    public void setAltura(Integer altura) {
        // Done - Implementar el metodo
        if(altura > 0 && altura < MAX_ALTURA) {
            this.altura = altura;
        } else {
            System.err.println("La altura establecida es invalida, vuelva a intentarlo");
        }
    }

    /**
     * Compara el triangulo con cualquie otra figura geometrica
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
     * y le agrega la base y altura del triangulo con el formato
     *   " ++ Altura=x, Base=y"
     * siendo x e y los valores de los campos.
     * @return El texto asociado.
     */
    @Override
    public String toString() {
        return super.toString() + " ++ Altura=" + this.altura + ", Base=" + this.base;
    }

}
