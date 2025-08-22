public class EstudiantesEstructura {
    public static void main(String[] args) {
        String[] nombres = {"Ana", "Luis", "Marta"};
        int[] edades = {20, 21, 19};
        double[] promedios = {8.5, 9.0, 7.8};

        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i] + " tiene " + edades[i] + " años y promedio " + promedios[i]);
        }

        // Si se elimina un elemento en un arreglo, se debe ajustar en los demás.
        // Esto hace que el código sea propenso a errores.
    }
}
