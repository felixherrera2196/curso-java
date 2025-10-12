import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class MiniBiblioteca {
    public static void main(String[] args) {
        Set<String> catalogo = new HashSet<>();
        Map<String, String> librosPrestados = new HashMap<>();
        List<String> historialPrestamos = new ArrayList<>();

        // Paso 2: registrar libros
        catalogo.add("Clean Code");
        catalogo.add("Effective Java");
        catalogo.add("Clean Code");

        // Paso 3: prestar y devolver
        if (catalogo.contains("Clean Code") && !librosPrestados.containsKey("Clean Code")) {
            librosPrestados.put("Clean Code", "Laura");
            historialPrestamos.add("Clean Code -> Laura");
        }

        librosPrestados.remove("Clean Code");
        historialPrestamos.add("Clean Code -> devuelto");

        // Nuevo préstamo
        librosPrestados.put("Clean Code", "Ana");
        historialPrestamos.add("Clean Code -> Ana");

        // Paso 4: reportes
        System.out.println("Catálogo disponible:");
        for (String libro : catalogo) {
            System.out.println("- " + libro);
        }

        System.out.println("\nLibros prestados:");
        for (Map.Entry<String, String> registro : librosPrestados.entrySet()) {
            System.out.println(registro.getKey() + " (" + registro.getValue() + ")");
        }

        System.out.println("\nHistorial de movimientos:");
        for (String movimiento : historialPrestamos) {
            System.out.println(movimiento);
        }
    }
}
