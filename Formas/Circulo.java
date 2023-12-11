public class Circulo extends FiguraGeometrica {
    private static final Double PI = Math.PI;
    // La constante se usa para BASE y ALTURA
    private static final Integer MAX_RADIO = 500;
    // El numero de serie del primer objeto es 1
    // No se puede repetir el numero para dos triangulos
    private static Integer nroSerie = 1;
    private Integer radio;

    /**
     * Constructor que recibe los valores de la base
     * y de la altura.
     * Debe generar el ID con la forma
     *    "CirculoX"
     * siendo X el numero de serie correspondiente.
     * Configurarlo con setId() de la superclase.
     */
    public Circulo(Integer diametro) {
        this.radio = (diametro)/2;
        setId("Circulo" + nroSerie);
        nroSerie++;
    }

    /**
     * Calcula el perimetro de la figura.
     * @return El perimetro.
     */
    public Double getPerimetro() {
        return PI * 2 * radio;
    }

    /**
     * Calcula la superficie de la figura.
     * @return La superficie.
     */
    public Double getSuperficie() {
        return PI * radio * radio;
    }

    public Integer getRadio() {
        return radio;
    }

    public Integer getDiametro() {
        return radio * 2;
    }

    public void setRadio(Integer radio) {
        if ((0 < radio) && (radio < MAX_RADIO)) {
            this.radio = radio;
        } else {
            System.err.println("El radio establecido es invalido, vuelva a ingresar otro");
        }
    }

    /**
     * Compara el triangulo con cualquier otra figura geometrica
     * devolviendo -1, 0 o 1 segun sea menor, igual o mayor.
     * La comparacion se hace primero por superficie y luego por ID
     * de los objetos. En ambos casos en el orden natural.
     * @return El entero indicando la comparacion.
     */
    @Override
    public int compareTo(FiguraGeometrica f) {
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
        return nroSerie;
    }

    /**
     * Devuelve lo reportado en el toString() de la superclase
     * y le agrega el radio el circulo con el formato
     *   " ++ Radio=x"
     * siendo x el valor del campo.
     * @return El texto asociado.
     */
    @Override
    public String toString() {
        return super.toString() + " ++ Radio=" + radio;
    }

}