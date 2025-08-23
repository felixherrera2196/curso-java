public class EjemploAcceso {
    public int publico;
    private int privado;
    protected int protegido;
    int paquete;

    public void mostrar() {
        System.out.println("privado: " + privado);
    }

}
