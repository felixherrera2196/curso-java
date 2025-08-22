# Clase 3 – Encapsulamiento y Constructores

Guía para el estudiante

## Objetivos
- Comprender cómo los modificadores de acceso controlan la visibilidad de los miembros de una clase.
- Utilizar métodos *getters* y *setters* para proteger los atributos.
- Crear constructores para inicializar objetos de forma segura.
- Sobrecargar constructores para ofrecer distintas maneras de construir un objeto.
- Aplicar encapsulamiento construyendo una clase `CuentaBancaria` completa.

## Antes de comenzar
- Asegúrate de tener instalado el **JDK** y que los comandos `javac` y `java` funcionen en tu terminal.
- Usa un editor de texto para escribir tus archivos `.java`.
- Recuerda que el nombre del archivo debe coincidir con el de la clase pública que contiene.

## Desarrollo de la clase

1. **Modificadores de acceso**
   - Definen desde dónde se puede acceder a los atributos, métodos o clases.
   - `public`: accesible desde cualquier parte del programa.
   - `private`: solo visible dentro de la propia clase. Es el más usado para proteger datos.
   - `protected`: accesible desde la clase, sus subclases y el mismo paquete.
   - *Sin modificador* (también llamado *package-private*): accesible únicamente dentro del mismo paquete.
   - Ejemplo:

     ```java
     public class EjemploAcceso {
         public int publico;          // libre
         private int privado;         // solo dentro de la clase
         protected int protegido;     // subclases o mismo paquete
         int paquete;                 // mismo paquete
     }
     ```

   - ¿Qué ocurre si intentamos acceder a esos campos desde otra clase?

     ```java
     public class PruebaAcceso {
         public static void main(String[] args) {
             EjemploAcceso obj = new EjemploAcceso();
             obj.publico = 1;      // OK
             obj.privado = 2;      // ❌ Error: privado tiene acceso private
             obj.protegido = 3;    // ❌ Error si no está en el mismo paquete ni es subclase
         }
     }
     ```

     Al compilar, Java mostrará mensajes como:

     ```
     PruebaAcceso.java:6: error: privado has private access in EjemploAcceso
             obj.privado = 2;
                 ^
     PruebaAcceso.java:7: error: protegido has protected access in EjemploAcceso
             obj.protegido = 3;
                 ^
     ```

     Estos errores indican que `privado` no puede usarse fuera de su clase y que `protegido` solo es visible desde el mismo paquete o una subclase.

2. **Métodos getters y setters**
   - Permiten leer o modificar atributos privados de forma controlada.
   - Los nombres siguen la convención `getAtributo` y `setAtributo`.
   - Dentro de un setter se pueden validar los datos antes de asignarlos.
   - Ejemplo:

     ```java
     public class Persona {
         private String nombre;

         public String getNombre() {
             return nombre;
         }

         public void setNombre(String nombre) {
             if (nombre != null && !nombre.isEmpty()) {
                 this.nombre = nombre;
             }
         }
     }
     ```

3. **La palabra clave `this`**
   - `this` es una referencia al objeto actual que ejecuta el código.
   - Ayuda a distinguir entre atributos y parámetros con el mismo nombre.
   - Permite llamar a métodos o constructores de la misma clase.
   - Ejemplo:

     ```java
     public class Persona {
         private String nombre;

         public Persona(String nombre) {
             this.nombre = nombre; // asigna al atributo de la instancia
         }

         public void saludar() {
             System.out.println("Hola, soy " + this.nombre);
         }
     }
     ```

   - También se puede usar `this(...)` dentro de un constructor para invocar a otro constructor de la clase.

4. **Constructores en Java**
   - Método especial que se ejecuta al crear un objeto (`new`).
   - Su nombre coincide con el de la clase y **no** tiene tipo de retorno.
   - Si no se declara, Java genera un constructor vacío por defecto.
   - Sirven para inicializar atributos desde el primer momento.
   - Ejemplo:

     ```java
     public class Punto {
         private int x;
         private int y;

         public Punto(int x, int y) {
             this.x = x;
             this.y = y;
         }
     }
     ```

5. **Sobrecarga de constructores**
   - Una clase puede tener múltiples constructores con diferentes parámetros.
   - Permite crear objetos de distintas formas según la información disponible.
   - Se puede usar `this(...)` para reutilizar la lógica de otro constructor.
   - Ejemplo:

     ```java
     public class Rectangulo {
         private int base;
         private int altura;

         public Rectangulo() {
             this(1, 1); // constructor por defecto
         }

         public Rectangulo(int base, int altura) {
             this.base = base;
             this.altura = altura;
         }
     }
     ```

6. **Aplicación: `CuentaBancaria`**
   - La clase debe encapsular su estado y ofrecer métodos seguros para modificarlo.
   - Atributos recomendados: `numeroCuenta`, `titular` y `saldo`.
   - Ofrece al menos dos constructores: uno vacío y otro que reciba datos iniciales.
   - Incluye getters, setters y métodos como `depositar` y `retirar` con validaciones.
   - Ejemplo completo:

     ```java
     public class CuentaBancaria {
         private String numeroCuenta;
         private String titular;
         private double saldo;

         // Constructor vacío
         public CuentaBancaria() {
             this.saldo = 0.0;
         }

         // Constructor con parámetros
         public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
             this.numeroCuenta = numeroCuenta;
             this.titular = titular;
             this.saldo = saldoInicial;
         }

         public String getNumeroCuenta() {
             return numeroCuenta;
         }

         public String getTitular() {
             return titular;
         }

         public double getSaldo() {
             return saldo;
         }

         public void setTitular(String titular) {
             if (titular != null && !titular.isEmpty()) {
                 this.titular = titular;
             }
         }

         public void depositar(double monto) {
             if (monto > 0) {
                 saldo += monto;
             }
         }

         public void retirar(double monto) {
             if (monto > 0 && monto <= saldo) {
                 saldo -= monto;
             }
         }
     }
     ```

## Actividad guiada

Sigue estos pasos para practicar el encapsulamiento y los constructores:
1. Implementa la clase `CuentaBancaria` mostrada arriba en tu editor.
2. Crea una clase `BancoDemo` con un método `main` que:
   - Cree dos cuentas con distintos constructores.
   - Deposite y retire dinero de cada cuenta mostrando el saldo resultante.
3. Compila y ejecuta tus archivos para verificar que funcionan correctamente.

## Ejercicio independiente

Crea una clase `Producto` que:
- Tenga atributos privados `nombre`, `precio` y `stock`.
- Incluya getters y setters con validaciones (por ejemplo, que el precio no sea negativo).
- Disponga de un constructor por defecto y otro que reciba todos los atributos.
- Ofrezca un método `vender(int cantidad)` que reduzca el stock si hay suficientes unidades.

## Recursos recomendados
- [Documentación oficial de Java](https://docs.oracle.com/javase/tutorial/)
- [Guía de Java para principiantes](https://www.w3schools.com/java/)

## Actividad adicional

Diseña una clase `Rectangulo` que calcule el área y el perímetro. Provee:
- Atributos privados `base` y `altura`.
- Constructores sobrecargados para valores por defecto o personalizados.
- Getters, setters y métodos `calcularArea` y `calcularPerimetro`.

