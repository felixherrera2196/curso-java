# Clase 6 – Abstracción e Interfaces

Guía para el estudiante

## Objetivos
- Comprender la importancia de la abstracción para modelar comportamientos generales.
- Definir clases y métodos abstractos con la palabra clave `abstract`.
- Distinguir clases abstractas de interfaces.
- Implementar múltiples interfaces en una clase concreta.
- Construir una jerarquía `Animal` con una interfaz `Mascota`.

## Antes de comenzar
- Repasa la herencia y el polimorfismo de las clases anteriores.
- Asegúrate de tener instalado el **JDK** y que `javac` y `java` funcionen en tu terminal.
- Usa un editor de texto para escribir tus archivos `.java`.
- Recuerda que el nombre del archivo debe coincidir con el de la clase pública.

## Desarrollo de la clase

1. **¿Qué es la abstracción?**
   - Permite enfocarse en las características esenciales de un objeto.
   - Las clases abstractas no se pueden instanciar directamente.

2. **Clases abstractas**
   - Se declaran con la palabra clave `abstract`.
   - Pueden contener métodos concretos y abstractos.
   - Ejemplo:

   ```java
   public abstract class Figura {
       public abstract double calcularArea();
       public void descripcion() {
           System.out.println("Figura geométrica");
       }
   }
   ```

3. **Métodos abstractos**
   - Se declaran sin cuerpo y obligan a las subclases a implementarlos.
   - Ejemplo:

   ```java
   public abstract class Animal {
       public abstract void hacerSonido();
   }
   ```

4. **Interfaces en Java**
   - Definen un contrato de métodos sin implementación.
   - Las clases usan `implements` para adoptar una interfaz.
   - Desde Java 8, las interfaces pueden tener métodos `default` y `static`.
   - Ejemplo:

   ```java
   public interface Mascota {
       void jugar();
       default void dormir() {
           System.out.println("La mascota duerme");
       }
   }
   ```

5. **Implementación de múltiples interfaces**
   - Una clase puede implementar varias interfaces separándolas por comas.
   - Ejemplo:

   ```java
   public class Perro extends Animal implements Mascota, Comparable<Perro> {
       @Override
       public void hacerSonido() { System.out.println("Guau"); }

       @Override
       public void jugar() { System.out.println("El perro juega"); }

       @Override
       public int compareTo(Perro o) { return 0; }
   }
   ```

6. **Ejercicio: clase abstracta `Animal` e interfaz `Mascota`**
   - Crea la clase abstracta `Animal` con el método `hacerSonido()`.
   - Implementa `Perro` y `Gato` que extiendan `Animal` e implementen `Mascota`.
   - En una clase `Main`, crea instancias y demuestra el uso de métodos abstractos e interfaces.

## Actividad guiada
Sigue estos pasos para practicar:

1. Define la clase abstracta `Animal` y la interfaz `Mascota`.
2. Implementa las clases `Perro` y `Gato`.
3. En una clase `Zoo`, declara un arreglo de `Animal` y recórrelo invocando `hacerSonido()`.
4. Agrega métodos de `Mascota` y observa cómo se invocan mediante la interfaz.

## Ejercicio independiente
Diseña una jerarquía de dispositivos con una clase abstracta `Dispositivo` y una interfaz `Recargable`. Crea subclases como `Telefono` y `Tablet` que implementen la interfaz y sobrescriban el método abstracto `encender()`.

## Recursos recomendados
- [Documentación oficial de Java](https://docs.oracle.com/javase/tutorial/)
- [Interfaces y clases abstractas](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- [Guía de Java para principiantes](https://www.w3schools.com/java/)

## Actividad adicional
Implementa una interfaz `Nadador` con un método `nadar()`. Crea una clase abstracta `Ave` y una subclase `Pato` que extienda `Ave` e implemente `Nadador` y `Mascota`.

