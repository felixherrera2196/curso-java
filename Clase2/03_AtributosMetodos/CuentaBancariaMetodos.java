public class CuentaBancariaMetodos {
    String titular;
    double saldo;

    void depositar(double monto) {
        saldo += monto;
    }

    void retirar(double monto) {
        saldo -= monto;
    }

    public static void main(String[] args) {
        CuentaBancariaMetodos c = new CuentaBancariaMetodos();
        c.titular = "Luis";
        c.depositar(1000);
        c.retirar(200);
        System.out.println("Saldo final: " + c.saldo);
    }
}
