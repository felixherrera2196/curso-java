import java.util.Scanner;

public class RegistroDeAmenazasDemoniacas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int reportes = scanner.hasNextInt() ? scanner.nextInt() : 0;
        int[] frecuencias = new int[6];
        int valoresLeidos = 0;
        int suma = 0;

        while (valoresLeidos < reportes && scanner.hasNextInt()) {
            int nivel = scanner.nextInt();
            if (nivel >= 1 && nivel <= 5) {
                frecuencias[nivel]++;
                suma += nivel;
                valoresLeidos++;
            }
        }

        double promedio = valoresLeidos > 0 ? (double) suma / valoresLeidos : 0.0;

        int nivelMasFrecuente = 0;
        if (valoresLeidos > 0) {
            nivelMasFrecuente = 1;
            for (int nivel = 2; nivel <= 5; nivel++) {
                if (frecuencias[nivel] > frecuencias[nivelMasFrecuente]) {
                    nivelMasFrecuente = nivel;
                }
            }
        }

        System.out.printf("Promedio de amenaza: %.2f%n", promedio);
        System.out.println("Nivel más frecuente: " + nivelMasFrecuente);

        scanner.close();
    }
}
