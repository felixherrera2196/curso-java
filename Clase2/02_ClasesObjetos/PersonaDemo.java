class Persona {
    String nombre;
    int edad;
}

public class PersonaDemo {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.nombre = "Ana";
        p.edad = 30;
        System.out.println("Nombre: " + p.nombre + ", Edad: " + p.edad);
    }
}
