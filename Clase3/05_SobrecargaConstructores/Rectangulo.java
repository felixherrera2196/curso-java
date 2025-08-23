public class Rectangulo {
    private int base;
    private int altura;

    public Rectangulo() {
        this(1, 1);
    }

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public int area() {
        return base * altura;
    }

}
