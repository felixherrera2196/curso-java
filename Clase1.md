# Clase 1 – Fundamentos de Java (sin POO)

Guía para el estudiante

## Objetivos
- Comprender la estructura básica de un programa Java.
- Declarar variables y utilizar los tipos de datos primitivos y no primitivos.
- Leer datos desde el teclado y mostrar información en consola.
- Aplicar operadores aritméticos, relacionales y lógicos.
- Controlar el flujo de ejecución mediante condicionales, ciclos `while`, `do-while` y `for` anidados.
- Manipular arreglos unidimensionales y bidimensionales.
- Distinguir y llamar métodos estáticos y de instancia.

## Antes de comenzar
- **Instala el JDK** y asegúrate de que los comandos `javac` y `java` funcionen en la terminal.
- **Usa un editor de texto** (VS Code, IntelliJ, etc.) para escribir tus archivos `.java`.
- Cada archivo debe llamarse igual que la clase pública que contiene.

## Desarrollo de la clase

1. **Estructura de un programa Java**
   - Todo programa se organiza en clases; la ejecución inicia en el método `main`.
   - El archivo debe llamarse como la clase pública: `HolaMundo.java`.
   - Ejemplo:

     ```java
     public class HolaMundo {
         // método principal: punto de entrada del programa
         public static void main(String[] args) {
             System.out.println("Hola Mundo");
         }
     }
     ```
   - Para compilar utiliza `javac HolaMundo.java` y para ejecutar `java HolaMundo`.

2. **Variables y tipos de datos**
   - Una variable reserva espacio en memoria para guardar datos.
   - **Tipos primitivos más comunes:**
     | Tipo | Ejemplo | Descripción |
     |------|---------|-------------|
     | `int` | `int edad = 20;` | Números enteros |
     | `double` | `double altura = 1.75;` | Números con decimales |
     | `boolean` | `boolean activo = true;` | Valores `true`/`false` |
     | `char` | `char inicial = 'A';` | Un carácter |
   - **Tipos de datos no primitivos:**
     - `String nombre = "Ana";` // cadenas de texto
     - `Integer numero = 5;` // clases envoltorio
     - `int[] edades = {20, 21};` // arreglos
   - Declaración, asignación y casting:

     ```java
     int edad = 25;           // declaración + asignación
     double altura = 1.75;    // número decimal
     int redondeada = (int) altura; // casting explícito
     final double PI = 3.1416; // constante
     ```

3. **Entrada y salida de datos**
   - Para leer texto desde el teclado se usa `Scanner`.
   - Ejemplo:

     ```java
     import java.util.Scanner;

     public class LeerNombre {
         public static void main(String[] args) {
             Scanner sc = new Scanner(System.in);
             System.out.print("Escribe tu nombre: ");
             String nombre = sc.nextLine();
             System.out.println("Hola, " + nombre);
             sc.close();
         }
     }
     ```

4. **Operadores**
   - Aritméticos (`+`, `-`, `*`, `/`, `%`) permiten realizar cálculos.
   - Relacionales (`>`, `<`, `==`, `!=`) y lógicos (`&&`, `||`, `!`) ayudan a tomar decisiones.
   - El operador `=` asigna valores y `++`/`--` incrementan o decrementan.
   - Ejemplo:

     ```java
     int a = 5, b = 2;
     int suma = a + b;         // 7
     boolean mayor = a > b;    // true
     a++;                      // ahora a vale 6
     ```

5. **Control de flujo**
   - Permite ejecutar instrucciones dependiendo de una condición.
   - Sentencias `if/else`:

     ```java
     int nota = 85;
     if (nota >= 90) {
         System.out.println("Excelente");
     } else if (nota >= 60) {
         System.out.println("Aprobado");
     } else {
         System.out.println("Reprobado");
     }
     ```
   - Sentencia `switch`:

     ```java
     int dia = 1;
     switch (dia) {
         case 1: System.out.println("Lunes"); break;
         case 2: System.out.println("Martes"); break;
         default: System.out.println("Otro día");
     }
     ```

6. **Ciclos**
   - Repetición de instrucciones mientras se cumpla una condición.
   - Ciclo `while`:

     ```java
     int i = 0;
     while (i < 3) {
         System.out.println(i);
         i++;
     }
     ```
   - Ciclo `do-while`:

     ```java
     int k = 0;
     do {
         System.out.println(k);
         k++;
     } while (k < 3);
     ```
   - Ciclo `for`:

     ```java
     for (int j = 0; j < 3; j++) {
         System.out.println(j);
     }
     ```
   - `for` anidado:

     ```java
     for (int fila = 1; fila <= 2; fila++) {
         for (int col = 1; col <= 3; col++) {
             System.out.print(fila + "," + col + " ");
         }
         System.out.println();
     }
     ```

7. **Arreglos**
   - Almacenan múltiples valores del mismo tipo.
   - Ejemplo unidimensional:

     ```java
     int[] numeros = {1, 2, 3};
     for (int n : numeros) {
         System.out.println(n);
     }
     ```
   - Ejemplo bidimensional:

     ```java
     int[][] matriz = {
         {1, 2},
         {3, 4}
     };
     System.out.println(matriz[0][1]); // imprime 2
     ```

8. **Métodos**
   - Los métodos encapsulan instrucciones que realizan una tarea específica.
   - **Métodos estáticos:** se definen con la palabra clave `static` y se llaman sin crear instancias.
     ```java
     public static int sumar(int x, int y) {
         return x + y;
     }

     public static void main(String[] args) {
         int resultado = sumar(3, 4);
         System.out.println("Resultado: " + resultado);
     }
     ```
   - **Métodos de instancia:** pertenecen a un objeto y requieren crear una instancia.
     ```java
     public class Persona {
         String nombre;

         public void saludar() {
             System.out.println("Hola, soy " + nombre);
         }

         public static void main(String[] args) {
             Persona p = new Persona();
             p.nombre = "Ana";
             p.saludar();
         }
     }
     ```

## Actividad guiada

Sigue estos pasos para crear una calculadora básica:
1. Crea un nuevo archivo `Calculadora.java`.
2. Dentro del método `main`, utiliza `Scanner` para pedir dos números al usuario.
3. Implementa métodos estáticos `sumar`, `restar`, `multiplicar` y `dividir`.
4. Muestra los resultados en consola.

## Ejercicio independiente

Implementa un gestor de notas que:
- Utilice un arreglo para almacenar calificaciones.
- Calcule el promedio y la calificación más alta.
- Permita buscar una nota específica.

## Recursos recomendados
- [Documentación oficial de Java](https://docs.oracle.com/javase/tutorial/)
- [Guía de Java para principiantes](https://www.w3schools.com/java/)
