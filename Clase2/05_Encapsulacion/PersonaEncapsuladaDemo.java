class PersonaEncapsulada {
    private String nombre;
    private int edad;

    public PersonaEncapsulada(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
}

public class PersonaEncapsuladaDemo {
    public static void main(String[] args) {
        PersonaEncapsulada p = new PersonaEncapsulada("Ana", 30);
        p.saludar();
        System.out.println("Edad: " + p.getEdad());
    }
}
