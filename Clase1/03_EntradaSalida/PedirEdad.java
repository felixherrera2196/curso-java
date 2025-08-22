import java.util.Scanner;

public class PedirEdad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos años tienes? ");
        int edad = sc.nextInt();
        System.out.println("Tienes " + edad + " años");
        sc.close();
    }
}
