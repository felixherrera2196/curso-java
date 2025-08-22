public class PersonaAtributos {
    String nombre;
    int edad;

    void saludar() {
        System.out.println("Hola, soy " + nombre);
    }

    public static void main(String[] args) {
        PersonaAtributos p = new PersonaAtributos();
        p.nombre = "Ana";
        p.edad = 25;
        p.saludar();
    }
}
