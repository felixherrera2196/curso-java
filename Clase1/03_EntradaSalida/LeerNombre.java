import java.util.Scanner;

public class LeerNombre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe tu nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Hola, " + nombre);
        sc.close();
    }
}
