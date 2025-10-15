import java.util.Scanner;

public class BrujulaDelGrandLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int corrientePrincipal = 0;
        int corrienteInversa = 0;
        int intensidadMaxima = 0;
        int filaIsla = 0;
        int columnaIsla = 0;
        boolean primerValor = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int valor = scanner.nextInt();

                if (i == j) {
                    corrientePrincipal += valor;
                }
                if (i + j == n - 1) {
                    corrienteInversa += valor;
                }

                if (primerValor || valor > intensidadMaxima || (valor == intensidadMaxima && (i < filaIsla || (i == filaIsla && j < columnaIsla)))) {
                    intensidadMaxima = valor;
                    filaIsla = i;
                    columnaIsla = j;
                    primerValor = false;
                }
            }
        }

        int diferenciaAbsoluta = Math.abs(corrientePrincipal - corrienteInversa);

        System.out.println("Corriente principal: " + corrientePrincipal);
        System.out.println("Corriente inversa: " + corrienteInversa);
        System.out.println("Diferencia absoluta: " + diferenciaAbsoluta);
        System.out.println("Isla más agitada: fila " + (filaIsla + 1) + ", columna " + (columnaIsla + 1));

        scanner.close();
    }
}
