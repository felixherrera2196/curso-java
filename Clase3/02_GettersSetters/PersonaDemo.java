public class PersonaDemo {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("Ana");
        p.setEdad(30);
        System.out.println("Nombre: " + p.getNombre() + ", Edad: " + p.getEdad());
    }
}
