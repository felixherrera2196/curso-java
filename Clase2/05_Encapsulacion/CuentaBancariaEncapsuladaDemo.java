class CuentaBancariaEncapsulada {
    private String titular;
    private double saldo;

    public CuentaBancariaEncapsulada(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public double getSaldo() {
        return saldo;
    }
}

public class CuentaBancariaEncapsuladaDemo {
    public static void main(String[] args) {
        CuentaBancariaEncapsulada c = new CuentaBancariaEncapsulada("Luis", 1000);
        c.depositar(500);
        System.out.println("Saldo actual: " + c.getSaldo());
    }
}
