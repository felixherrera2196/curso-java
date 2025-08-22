# Clase 1 – Repaso de Java (sin POO)

Guía para el estudiante

## Objetivos
- Comprender la estructura básica de un programa Java.
- Declarar variables y utilizar los tipos de datos primitivos.
- Aplicar operadores aritméticos, relacionales y lógicos.
- Controlar el flujo de ejecución mediante condicionales y ciclos.
- Manipular arreglos unidimensionales y bidimensionales.
- Definir y llamar métodos estáticos.

## Desarrollo de la clase

1. **Estructura de un programa Java**
   - Un programa Java inicia en el método `main` dentro de una clase pública.
   - Ejemplo:

     ```java
     public class HolaMundo {
         public static void main(String[] args) {
             System.out.println("Hola Mundo");
         }
     }
     ```
   - Para compilar utiliza `javac HolaMundo.java` y para ejecutar `java HolaMundo`.

2. **Variables y tipos de datos primitivos**
   - Las variables almacenan datos de un tipo específico, como `int`, `double` o `boolean`.
   - Declaración, asignación y casting:

     ```java
     int edad = 25;
     double altura = 1.75;
     int edadRedondeada = (int) altura; // casting explícito
     ```

3. **Operadores**
   - Aritméticos (`+`, `-`, `*`, `/`, `%`) permiten realizar cálculos.
   - Relacionales (`>`, `<`, `==`, `!=`) y lógicos (`&&`, `||`, `!`) ayudan a tomar decisiones.
   - Ejemplo:

     ```java
     int a = 5, b = 2;
     boolean mayor = a > b;        // true
     boolean condicion = mayor && (b != 0); // true
     ```

4. **Control de flujo**
   - Permite ejecutar instrucciones dependiendo de una condición.
   - Ejemplo:

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

5. **Ciclos**
   - Repetición de instrucciones mientras se cumpla una condición.
   - Ejemplo con `for`:

     ```java
     for (int i = 0; i < 5; i++) {
         System.out.println("Iteración: " + i);
     }
     ```

6. **Arreglos**
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
     int[][] matriz = {{1, 2}, {3, 4}};
     System.out.println(matriz[0][1]); // 2
     ```

7. **Métodos estáticos**
   - Definidos con la palabra clave `static`, se llaman sin crear instancias.
   - Ejemplo:

     ```java
     public static int sumar(int x, int y) {
         return x + y;
     }

     public static void main(String[] args) {
         System.out.println(sumar(3, 4));
     }
     ```

## Actividad guiada

Sigue estos pasos para crear una calculadora básica:
1. Crea un nuevo archivo `Calculadora.java`.
2. Dentro del método `main`, pide dos números al usuario.
3. Implementa métodos estáticos para sumar, restar, multiplicar y dividir.
4. Muestra los resultados en consola.

## Ejercicio independiente

Implementa un gestor de notas que:
- Utilice un arreglo para almacenar calificaciones.
- Calcule el promedio y la calificación más alta.
- Permita buscar una nota específica.

## Recursos recomendados
- [Documentación oficial de Java](https://docs.oracle.com/javase/tutorial/)
- [Guía de Java para principiantes](https://www.w3schools.com/java/)
