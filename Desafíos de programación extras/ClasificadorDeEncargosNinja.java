import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClasificadorDeEncargosNinja {
    private static final String[] RANGOS = {"D", "C", "B", "A", "S"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] entradas = scanner.nextLine().trim().split("\\s+");

        Map<String, Integer> conteo = new HashMap<>();
        for (String rango : RANGOS) {
            conteo.put(rango, 0);
        }

        for (int i = 0; i < n && i < entradas.length; i++) {
            String clave = entradas[i].toUpperCase();
            if (conteo.containsKey(clave)) {
                conteo.put(clave, conteo.get(clave) + 1);
            }
        }

        for (String rango : RANGOS) {
            System.out.println(rango + ": " + conteo.get(rango));
        }
        scanner.close();
    }
}
