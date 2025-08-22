public class LibroAtributos {
    String titulo;
    String autor;

    void mostrarInfo() {
        System.out.println(titulo + " - " + autor);
    }

    public static void main(String[] args) {
        LibroAtributos l = new LibroAtributos();
        l.titulo = "1984";
        l.autor = "George Orwell";
        l.mostrarInfo();
    }
}
