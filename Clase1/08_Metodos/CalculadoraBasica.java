import java.util.Scanner;

public class CalculadoraBasica {
    public static int sumar(int a, int b) { return a + b; }
    public static int restar(int a, int b) { return a - b; }
    public static int multiplicar(int a, int b) { return a * b; }
    public static int dividir(int a, int b) { return a / b; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número 1: ");
        int x = sc.nextInt();
        System.out.print("Número 2: ");
        int y = sc.nextInt();
        System.out.println("Suma: " + sumar(x, y));
        System.out.println("Resta: " + restar(x, y));
        System.out.println("Multiplicación: " + multiplicar(x, y));
        System.out.println("División: " + dividir(x, y));
        sc.close();
    }
}
