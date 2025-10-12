import java.util.ArrayList;
import java.util.List;

public class EjemploList {
    public static void main(String[] args) {
        List<String> tareas = new ArrayList<>();
        tareas.add("Revisar correo");
        tareas.add("Preparar reporte");
        tareas.add("Revisar correo"); // permitido: duplicados

        System.out.println("Primera tarea: " + tareas.get(0));

        tareas.remove("Preparar reporte");
        System.out.println("Total de tareas: " + tareas.size());

        System.out.println("\nRecorriendo con for-each:");
        for (String tarea : tareas) {
            System.out.println("Pendiente: " + tarea);
        }
    }
}
