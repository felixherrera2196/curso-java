import java.util.Locale;
import java.util.Scanner;

public class EvaluacionDeAspirantesUA {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        int aspirantes = scanner.hasNextInt() ? scanner.nextInt() : 0;
        String[] nombres = new String[aspirantes];
        double[] promedios = new double[aspirantes];

        String mejorNombre = "";
        double mejorPromedio = -1.0;

        for (int i = 0; i < aspirantes; i++) {
            if (!scanner.hasNext()) {
                break;
            }
            String nombre = scanner.next();
            int combate = scanner.hasNextInt() ? scanner.nextInt() : 0;
            int rescate = scanner.hasNextInt() ? scanner.nextInt() : 0;
            int estrategia = scanner.hasNextInt() ? scanner.nextInt() : 0;

            double promedio = (combate + rescate + estrategia) / 3.0;
            nombres[i] = nombre;
            promedios[i] = promedio;

            if (promedio > mejorPromedio) {
                mejorPromedio = promedio;
                mejorNombre = nombre;
            }
        }

        for (int i = 0; i < aspirantes; i++) {
            if (nombres[i] == null) {
                continue;
            }
            System.out.printf(Locale.US, "%s: %.2f%n", nombres[i], promedios[i]);
        }

        if (!mejorNombre.isEmpty()) {
            System.out.println("Mejor aspirante: " + mejorNombre);
        } else {
            System.out.println("Mejor aspirante: ");
        }

        scanner.close();
    }
}
