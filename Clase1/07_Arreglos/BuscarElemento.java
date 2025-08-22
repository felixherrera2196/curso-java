public class BuscarElemento {
    public static void main(String[] args) {
        int[] numeros = {4, 8, 15, 16, 23, 42};
        int buscado = 15;
        boolean encontrado = false;
        for (int n : numeros) {
            if (n == buscado) {
                encontrado = true;
                break;
            }
        }
        System.out.println("Encontrado: " + encontrado);
    }
}
