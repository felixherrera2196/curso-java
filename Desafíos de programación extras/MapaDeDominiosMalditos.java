import java.util.Scanner;

public class MapaDeDominiosMalditos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int filas = scanner.nextInt();
        int columnas = scanner.nextInt();

        int filaMasPeligrosa = 1;
        int energiaFilaMasPeligrosa = 0;
        int[] sumaColumnas = new int[columnas];

        for (int i = 0; i < filas; i++) {
            int sumaFila = 0;
            for (int j = 0; j < columnas; j++) {
                int valor = scanner.nextInt();
                sumaFila += valor;
                sumaColumnas[j] += valor;
            }

            if (i == 0 || sumaFila > energiaFilaMasPeligrosa) {
                energiaFilaMasPeligrosa = sumaFila;
                filaMasPeligrosa = i + 1;
            }
        }

        int columnaMasEstable = 1;
        double promedioMasBajo = 0.0;

        for (int j = 0; j < columnas; j++) {
            double promedio = (double) sumaColumnas[j] / filas;
            if (j == 0 || promedio < promedioMasBajo) {
                promedioMasBajo = promedio;
                columnaMasEstable = j + 1;
            }
        }

        System.out.println("Fila más peligrosa: " + filaMasPeligrosa + " (energía " + energiaFilaMasPeligrosa + ")");
        System.out.printf("Columna más estable: %d (promedio %.2f)%n", columnaMasEstable, promedioMasBajo);

        scanner.close();
    }
}
