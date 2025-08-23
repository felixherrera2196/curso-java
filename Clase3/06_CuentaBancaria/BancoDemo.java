public class BancoDemo {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria();
        cuenta1.setTitular("Carlos");
        cuenta1.depositar(1000);
        cuenta1.retirar(200);
        System.out.println("Cuenta 1 saldo: " + cuenta1.getSaldo());

        CuentaBancaria cuenta2 = new CuentaBancaria("123", "Ana", 500);
        cuenta2.depositar(300);
        cuenta2.retirar(100);
        System.out.println("Cuenta 2 saldo: " + cuenta2.getSaldo());
    }
}
