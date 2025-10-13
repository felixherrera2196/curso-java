import java.util.Scanner;

public class MapaDePatrullasDelMuro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();

        String[] escuadrones = new String[r];
        for (int i = 0; i < r; i++) {
            escuadrones[i] = "";
        }

        String[] nombres = scanner.nextLine().trim().split("\\s+");
        for (int i = 0; i < r && i < nombres.length; i++) {
            escuadrones[i] = nombres[i];
        }

        int[][] avistamientos = new int[r][c];
        int[] sumaEscuadrones = new int[r];
        int[] sumaZonas = new int[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (scanner.hasNextInt()) {
                    int valor = scanner.nextInt();
                    avistamientos[i][j] = valor;
                    sumaEscuadrones[i] += valor;
                    sumaZonas[j] += valor;
                }
            }
        }

        int indiceEscuadron = 0;
        for (int i = 1; i < r; i++) {
            if (sumaEscuadrones[i] > sumaEscuadrones[indiceEscuadron]) {
                indiceEscuadron = i;
            }
        }

        int indiceZona = 0;
        for (int j = 1; j < c; j++) {
            if (sumaZonas[j] > sumaZonas[indiceZona]) {
                indiceZona = j;
            }
        }

        System.out.println("Escuadrón con más avistamientos: " + escuadrones[indiceEscuadron] + " (" + sumaEscuadrones[indiceEscuadron] + ")");
        System.out.println("Zona con más actividad: " + (indiceZona + 1) + " (" + sumaZonas[indiceZona] + ")");
        scanner.close();
    }
}
