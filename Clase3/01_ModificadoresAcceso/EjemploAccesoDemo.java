public class EjemploAccesoDemo {
    public static void main(String[] args) {
        EjemploAcceso obj = new EjemploAcceso();
        obj.publico = 1;
        obj.protegido = 2;
        obj.paquete = 3;
        // obj.privado = 4; // No permitido
        obj.mostrar();
        System.out.println("publico: " + obj.publico + ", protegido: " + obj.protegido + ", paquete: " + obj.paquete);
    }
}
