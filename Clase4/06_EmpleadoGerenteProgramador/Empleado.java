public class Empleado {
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public void mostrarInfo() {
        System.out.println(nombre + ": $" + salario);
    }
}
