public class BibliotecaEstructurada {
    public static void main(String[] args) {
        String[] titulos = {"El Quijote", "Cien años de soledad"};
        String[] autores = {"Cervantes", "García Márquez"};
        boolean[] prestados = {false, true};

        for (int i = 0; i < titulos.length; i++) {
            String estado = prestados[i] ? "prestado" : "disponible";
            System.out.println(titulos[i] + " de " + autores[i] + " está " + estado);
        }
    }
}
