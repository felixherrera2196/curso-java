class PersonaSimple {
    String nombre;
    void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
}

public class CrearPersonas {
    public static void main(String[] args) {
        PersonaSimple p1 = new PersonaSimple();
        p1.nombre = "Ana";
        p1.saludar();

        PersonaSimple p2 = new PersonaSimple();
        p2.nombre = "Juan";
        p2.saludar();
    }
}
