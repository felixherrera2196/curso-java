public class MetodosInstancia {
    String nombre;

    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }

    public static void main(String[] args) {
        MetodosInstancia p = new MetodosInstancia();
        p.nombre = "Ana";
        p.saludar();
    }
}
