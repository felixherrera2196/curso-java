class CuentaSimple {
    String titular;
    double saldo;
}

public class CrearCuentas {
    public static void main(String[] args) {
        CuentaSimple c1 = new CuentaSimple();
        c1.titular = "Luis";
        c1.saldo = 500;

        CuentaSimple c2 = new CuentaSimple();
        c2.titular = "Maria";
        c2.saldo = 800;

        System.out.println(c1.titular + ": " + c1.saldo);
        System.out.println(c2.titular + ": " + c2.saldo);
    }
}
