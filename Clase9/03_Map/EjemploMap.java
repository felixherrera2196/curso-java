import java.util.HashMap;
import java.util.Map;

public class EjemploMap {
    public static void main(String[] args) {
        Map<String, Integer> inventario = new HashMap<>();
        inventario.put("Teclado", 15);
        inventario.put("Mouse", 30);
        inventario.put("Teclado", 18); // reemplaza la cantidad anterior

        System.out.println("Stock de teclados: " + inventario.get("Teclado"));
        System.out.println("¿Hay monitores? " + inventario.containsKey("Monitor"));

        inventario.remove("Mouse");

        System.out.println("\nRecorriendo claves:");
        for (String producto : inventario.keySet()) {
            System.out.println("Producto: " + producto);
        }

        System.out.println("\nRecorriendo valores:");
        for (Integer cantidad : inventario.values()) {
            System.out.println("Cantidad: " + cantidad);
        }

        System.out.println("\nRecorriendo pares clave-valor:");
        for (Map.Entry<String, Integer> entrada : inventario.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }
}
