public class Programador extends Empleado {
    private String lenguaje;

    public Programador(String nombre, double salario, String lenguaje) {
        super(nombre, salario);
        this.lenguaje = lenguaje;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Lenguaje: " + lenguaje);
    }
}
