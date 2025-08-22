class Coche {
    String marca;
    String modelo;
}

public class CocheDemo {
    public static void main(String[] args) {
        Coche c = new Coche();
        c.marca = "Toyota";
        c.modelo = "Corolla";
        System.out.println("Coche: " + c.marca + " " + c.modelo);
    }
}
