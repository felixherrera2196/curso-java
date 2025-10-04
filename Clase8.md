# Clase 8 – Manejo de Excepciones

En esta clase profundizaremos en el manejo de errores en Java utilizando bloques `try` y `catch`. El objetivo es comprender cómo funcionan las excepciones, cómo capturarlas correctamente y cómo crear excepciones personalizadas para mantener nuestros programas robustos y fáciles de mantener.

## 1. ¿Qué es una excepción?
Una **excepción** es un evento anómalo que ocurre durante la ejecución del programa e interrumpe el flujo normal de instrucciones. Java utiliza objetos para representar estas situaciones y detiene el programa a menos que la excepción sea gestionada adecuadamente.

### Jerarquía básica
- `Throwable`: clase base de todas las excepciones y errores.
  - `Error`: situaciones serias que normalmente no deberíamos intentar manejar (por ejemplo, `OutOfMemoryError`).
  - `Exception`: problemas que sí podemos controlar.
    - `RuntimeException`: excepciones no comprobadas (unchecked), como `NullPointerException` o `ArithmeticException`.
    - Otras excepciones comprobadas (checked), como `IOException` o `SQLException`.

## 2. Bloques try y catch
El bloque `try` contiene el código que puede lanzar una excepción. El bloque `catch` especifica cómo manejar la excepción cuando ocurre.

```java
try {
    int resultado = 10 / 0; // Provoca ArithmeticException
    System.out.println("Resultado: " + resultado);
} catch (ArithmeticException e) {
    System.out.println("Error: División por cero.");
}
```

### Flujo de ejecución
1. Se ejecuta el código dentro del `try`.
2. Si ocurre una excepción que coincide con el tipo declarado en un `catch`, se salta al bloque correspondiente.
3. El bloque `catch` recibe el objeto de la excepción y puede acceder a métodos como `getMessage()` o `printStackTrace()`.
4. Si no se produce la excepción, los bloques `catch` se omiten.

## 3. Bloques finally
El bloque `finally` contiene código que debe ejecutarse siempre, ocurra o no una excepción. Es ideal para liberar recursos.

```java
Scanner scanner = new Scanner(System.in);
try {
    int numero = scanner.nextInt();
    System.out.println("Número ingresado: " + numero);
} catch (InputMismatchException e) {
    System.out.println("Entrada inválida.");
} finally {
    scanner.close();
    System.out.println("Scanner cerrado.");
}
```

## 4. Múltiples bloques catch
Podemos capturar diferentes tipos de excepciones de manera específica. Java 7 introdujo la sintaxis de **multi-catch** para agrupar excepciones relacionadas.

```java
try {
    String texto = null;
    System.out.println(texto.length());
} catch (NullPointerException | IllegalArgumentException e) {
    System.out.println("Error relacionado con argumentos: " + e.getMessage());
}
```

## 5. Propagar excepciones con throw y throws
- `throw`: lanza manualmente una excepción dentro de un método.
- `throws`: declara que un método puede lanzar una excepción, delegando su manejo a quien llame al método.

```java
public static double dividir(int numerador, int denominador) throws ArithmeticException {
    if (denominador == 0) {
        throw new ArithmeticException("No se puede dividir entre cero");
    }
    return (double) numerador / denominador;
}
```

## 6. Excepciones personalizadas
Para representar errores de negocio, podemos extender `Exception` o `RuntimeException`.

```java
public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
```

Uso de la excepción personalizada en un servicio:

```java
public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente: " + saldo);
        }
        saldo -= monto;
    }
}
```

## 7. Buenas prácticas
- Capturar solamente las excepciones que podemos manejar.
- Mantener los bloques `try` lo más pequeños posible.
- Usar mensajes claros al lanzar excepciones.
- Registrar (`log`) las excepciones para facilitar el diagnóstico.
- Preferir `try-with-resources` al trabajar con recursos que implementan `AutoCloseable`.

### Ejemplo de try-with-resources
```java
try (BufferedReader reader = Files.newBufferedReader(Path.of("datos.txt"))) {
    String linea;
    while ((linea = reader.readLine()) != null) {
        System.out.println(linea);
    }
} catch (IOException e) {
    System.out.println("Error leyendo el archivo: " + e.getMessage());
}
```

## 8. Ejercicio práctico: Simulador de cajero automático
1. Crear una clase `CuentaBancaria` que permita depositar y retirar dinero.
2. Lanzar `SaldoInsuficienteException` cuando el usuario intenta retirar más de lo permitido.
3. Manejar `InputMismatchException` cuando el usuario ingresa datos no numéricos.
4. Utilizar `try-with-resources` para leer las opciones del usuario desde consola.
5. Mostrar mensajes adecuados para cada error y asegurar que la aplicación continúe ejecutándose.

## 9. Ejercicio práctico: Batalla Pokémon
1. Modela una clase `Pokemon` con atributos como `nombre`, `tipo` y `puntosDeVida`.
2. Implementa un método `atacar(Pokemon objetivo)` que pueda lanzar una excepción personalizada `AtaqueNoPermitidoException` cuando el tipo del atacante sea inefectivo contra el objetivo.
3. Utiliza bloques `try-catch` para capturar la excepción cuando el ataque no sea válido y mostrar un mensaje amigable al jugador.
4. Asegúrate de que, sin importar si el ataque fue válido o no, se impriman los puntos de vida actuales del objetivo utilizando un bloque `finally`.
5. Crea una simulación simple en `main` que permita ejecutar varios ataques, manejando también posibles `IllegalArgumentException` si se ingresan tipos de Pokémon inexistentes.

## 10. Recursos adicionales
- [Documentación oficial de Oracle](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
- Clean Code, Robert C. Martin – Capítulo sobre manejo de errores.

Con estas herramientas, podrás construir aplicaciones más estables y fáciles de depurar, reaccionando adecuadamente ante situaciones inesperadas.
