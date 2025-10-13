import java.util.Scanner;

public class DecodificadorDeMensajesPokemon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mensaje = scanner.nextLine().trim();
        int columnas = Integer.parseInt(scanner.nextLine().trim());

        if (columnas <= 0) {
            System.out.println("");
            scanner.close();
            return;
        }

        int filas = (int) Math.ceil((double) mensaje.length() / columnas);
        char[][] matriz = new char[filas][columnas];
        int indice = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (indice < mensaje.length()) {
                    matriz[i][j] = mensaje.charAt(indice++);
                } else {
                    matriz[i][j] = '*';
                }
            }
        }

        StringBuilder resultado = new StringBuilder();
        for (int j = 0; j < columnas; j++) {
            for (int i = 0; i < filas; i++) {
                if (matriz[i][j] != '*') {
                    resultado.append(matriz[i][j]);
                }
            }
        }

        System.out.println(resultado.toString());
        scanner.close();
    }
}
