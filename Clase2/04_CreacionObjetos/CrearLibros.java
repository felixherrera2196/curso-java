class LibroSimple {
    String titulo;
    String autor;
}

public class CrearLibros {
    public static void main(String[] args) {
        LibroSimple l1 = new LibroSimple();
        l1.titulo = "1984";
        l1.autor = "George Orwell";

        LibroSimple l2 = new LibroSimple();
        l2.titulo = "El Principito";
        l2.autor = "Saint-Exupéry";

        System.out.println(l1.titulo + " de " + l1.autor);
        System.out.println(l2.titulo + " de " + l2.autor);
    }
}
