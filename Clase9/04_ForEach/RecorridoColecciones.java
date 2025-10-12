import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecorridoColecciones {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(-2);
        numeros.add(10);
        numeros.add(-8);

        System.out.println("Recorrido con for-each:");
        for (Integer numero : numeros) {
            System.out.println("Número: " + numero);
        }

        Iterator<Integer> iterador = numeros.iterator();
        while (iterador.hasNext()) {
            Integer valor = iterador.next();
            if (valor < 0) {
                iterador.remove();
            }
        }

        System.out.println("\nLista después de eliminar negativos:");
        for (Integer numero : numeros) {
            System.out.println("Número: " + numero);
        }
    }
}
