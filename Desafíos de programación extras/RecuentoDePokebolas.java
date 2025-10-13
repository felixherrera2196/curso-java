import java.util.Scanner;

public class RecuentoDePokebolas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int reportes = scanner.hasNextInt() ? scanner.nextInt() : 0;
        int poke = 0;
        int superBall = 0;
        int ultra = 0;
        int master = 0;

        for (int i = 0; i < reportes && scanner.hasNext(); i++) {
            String tipo = scanner.next();
            switch (tipo) {
                case "Poke":
                    poke++;
                    break;
                case "Super":
                    superBall++;
                    break;
                case "Ultra":
                    ultra++;
                    break;
                case "Master":
                    master++;
                    break;
                default:
                    // Ignora cualquier palabra que no corresponda a un tipo válido
                    break;
            }
        }

        System.out.println("Poké Ball: " + poke);
        System.out.println("Super Ball: " + superBall);
        System.out.println("Ultra Ball: " + ultra);
        System.out.println("Master Ball: " + master);

        scanner.close();
    }
}
