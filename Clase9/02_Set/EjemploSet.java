import java.util.HashSet;
import java.util.Set;

public class EjemploSet {
    public static void main(String[] args) {
        Set<String> invitados = new HashSet<>();
        invitados.add("Ana");
        invitados.add("Luis");
        invitados.add("Ana"); // ignorado por duplicado

        System.out.println("Total confirmados: " + invitados.size());
        System.out.println("¿Está Ana? " + invitados.contains("Ana"));

        invitados.remove("Luis");

        System.out.println("\nLista final de invitados:");
        for (String invitado : invitados) {
            System.out.println("Invitado: " + invitado);
        }
    }
}
