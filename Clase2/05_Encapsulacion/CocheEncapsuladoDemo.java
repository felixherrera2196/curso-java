class CocheEncapsulado {
    private String marca;
    private String modelo;

    public CocheEncapsulado(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return marca + " " + modelo;
    }
}

public class CocheEncapsuladoDemo {
    public static void main(String[] args) {
        CocheEncapsulado c = new CocheEncapsulado("Toyota", "Corolla");
        System.out.println(c.getDescripcion());
    }
}
