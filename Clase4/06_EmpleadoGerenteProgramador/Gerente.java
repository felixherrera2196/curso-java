public class Gerente extends Empleado {
    private String departamento;

    public Gerente(String nombre, double salario, String departamento) {
        super(nombre, salario);
        this.departamento = departamento;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Departamento: " + departamento);
    }
}
