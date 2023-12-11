public enum Forma {
    CIRCULO("Circulo"), RECTANGULO("Rectangulo"), TRIANGULO("Triangulo");

    private String tipo;

    private Forma(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }

}
