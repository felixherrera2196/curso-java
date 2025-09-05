public class Main {
    public static void main(String[] args) {
        Gerente g = new Gerente("Ana", 5000, "Ventas");
        Programador p = new Programador("Luis", 4000, "Java");

        g.mostrarInfo();
        p.mostrarInfo();
    }
}
