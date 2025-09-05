# Clase 5 – Polimorfismo

Guía para el estudiante

## Objetivos
- Comprender el polimorfismo como la capacidad de un objeto de adoptar múltiples formas.
- Diferenciar entre sobrecarga y sobreescritura de métodos.
- Utilizar referencias de la superclase para manipular objetos de subclases.
- Aplicar polimorfismo dinámico en una jerarquía de figuras geométricas.

## Antes de comenzar
- Repasa la herencia vista en la clase anterior.
- Asegúrate de tener instalado el **JDK** y que `javac` y `java` funcionen en tu terminal.
- Usa un editor de texto para escribir tus archivos `.java`.
- Recuerda que el nombre del archivo debe coincidir con el de la clase pública.

## Desarrollo de la clase

1. **Concepto de polimorfismo**
   - Significa "muchas formas". Permite tratar objetos de diferentes clases como si fueran del mismo tipo.
   - Facilita escribir código general que funciona con cualquier subclase.
   - Ejemplo:
     ```java
     class Animal { void hacerSonido() { System.out.println("Sonido genérico"); } }
     class Perro extends Animal { void hacerSonido() { System.out.println("Guau"); } }
     class Gato extends Animal { void hacerSonido() { System.out.println("Miau"); } }

     Animal a1 = new Perro();
     Animal a2 = new Gato();
     a1.hacerSonido(); // Guau
     a2.hacerSonido(); // Miau
     ```

2. **Sobrecarga de métodos (overloading)**
   - Varios métodos con el mismo nombre pero distinta lista de parámetros.
   - Se resuelve en tiempo de compilación.
   - Ejemplo:
     ```java
     class Calculadora {
         int sumar(int a, int b) { return a + b; }
         double sumar(double a, double b) { return a + b; }
     }
     ```

3. **Sobreescritura de métodos (overriding)**
   - Una subclase redefine un método heredado para ajustar su comportamiento.
   - Se indica con la anotación `@Override`.
   - Ejemplo:
     ```java
     class Ave {
         void volar() { System.out.println("Ave volando"); }
     }
     class Aguila extends Ave {
         @Override
         void volar() { System.out.println("Águila planeando"); }
     }
     ```

4. **Tipos de referencias y comportamiento dinámico**
   - Una referencia de la superclase puede apuntar a objetos de cualquier subclase (`Animal animal = new Perro();`).
   - El método invocado depende del tipo real del objeto, no del tipo de la referencia.
   - Para acceder a métodos específicos de la subclase es necesario un *casting* seguro y verificar con `instanceof`.
   - Ejemplo:
     ```java
     Animal animal = new Perro();
     animal.hacerSonido(); // Guau
     if (animal instanceof Perro) {
         Perro p = (Perro) animal;
         p.ladrar();
     }
     ```

5. **Ejercicio: Jerarquía de figuras geométricas**
   - Define una clase abstracta `Figura` con métodos `calcularArea()` y `calcularPerimetro()`.
   - Implementa `Circulo` y `Rectangulo` que sobrescriban esos métodos.
   - Crea un arreglo `Figura[]` y recórrelo para mostrar área y perímetro de cada figura.

## Actividad guiada
Sigue estos pasos para practicar:

1. Crea la clase abstracta `Figura` con los métodos mencionados.
2. Implementa las subclases `Circulo` y `Rectangulo`.
3. En una clase `FigurasDemo`, crea varias figuras y muestra sus áreas y perímetros usando un mismo arreglo de tipo `Figura`.

## Ejercicio independiente
Diseña una jerarquía de vehículos con una superclase `Vehiculo` y subclases como `Auto` y `Bicicleta`. Sobrescribe un método `mover()` y demuestra el polimorfismo recorriendo un arreglo de `Vehiculo`.

## Recursos recomendados
- [Documentación oficial de Java](https://docs.oracle.com/javase/tutorial/)
- [Guía de Java para principiantes](https://www.w3schools.com/java/)
- [Polimorfismo en Java](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)

## Actividad adicional
Implementa una clase `Instrumento` con un método `tocar()`. Crea subclases `Guitarra`, `Piano` y `Bateria` que sobrescriban ese método y prueba el comportamiento polimórfico en un arreglo de `Instrumento`.
