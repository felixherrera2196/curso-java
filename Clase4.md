# Clase 4 – Herencia

Guía para el estudiante

## Objetivos

- Comprender cómo la herencia permite reutilizar y especializar código.
- Definir superclases y subclases en Java con la palabra clave `extends`.
- Reconocer que Java admite herencia simple.
- Acceder a miembros de la superclase mediante `super`.
- Construir una jerarquía `Empleado` con subclases `Gerente` y `Programador`.

## Antes de comenzar

- Revisa los conceptos de encapsulamiento y constructores de la clase anterior.
- Asegúrate de tener instalado el **JDK** y que `javac` y `java` funcionen en
  tu terminal.
- Usa un editor de texto para escribir tus archivos `.java`.

## Desarrollo de la clase

1. **Concepto de herencia en POO**
   - La herencia permite crear nuevas clases basadas en otras ya
     implementadas, reutilizando código y evitando duplicación.
   - Las clases derivadas (*hijas*) heredan atributos y métodos públicos y
     protegidos de la clase base (*padre*).
   - De esta forma podemos escribir comportamientos generales en la
     superclase y especializarlos en las subclases.
   - Ejemplo de una superclase:

     ```java
     public class Animal {
         public void comer() {
             System.out.println("El animal come");
         }
     }
     ```

   - Una subclase puede extender `Animal` para reutilizar `comer` y agregar
     nuevas habilidades:

     ```java
     public class Perro extends Animal {
         public void ladrar() {
             System.out.println("Guau");
         }
     }

     Perro firulais = new Perro();
     firulais.comer();  // usa el método heredado de Animal
     firulais.ladrar(); // método propio de Perro
     ```

2. **Uso de la palabra clave `extends`**
   - Para heredar de una clase se coloca `extends` seguido del nombre de la
     superclase.
   - La subclase puede añadir sus propios métodos o atributos además de los
     heredados:

     ```java
     public class Perro extends Animal {
         public void ladrar() {
             System.out.println("Guau");
         }
     }

     Perro perro = new Perro();
     perro.comer();   // heredado de Animal
     perro.ladrar();  // definido en Perro
     ```

   - `Perro` hereda el método `comer` de `Animal` sin necesidad de volver a
     escribirlo.

3. **Herencia simple en Java**
   - Una clase solo puede extender de una única superclase; esto se llama
     *herencia simple*.
   - Es posible construir cadenas de herencia: una subclase puede ser
     superclase de otra.
   - Ejemplo de herencia en varios niveles:

     ```java
     public class PastorAleman extends Perro {
         public void vigilar() {
             System.out.println("Vigilando la casa");
         }
     }

     PastorAleman max = new PastorAleman();
     max.comer();   // Animal
     max.ladrar();  // Perro
     max.vigilar(); // PastorAleman
     ```

   - Intentar heredar de más de una clase produce error de compilación:

     ```java
     // Error: no se puede extender dos clases a la vez
     public class PerroRobot extends Perro, Robot {}
     ```

4. **Superclases y subclases**
   - Las clases que heredan de otra se llaman *subclases* y la clase de la
     cual se hereda es la *superclase* o clase base.
   - Las subclases pueden sobrescribir métodos para cambiar el comportamiento
     heredado. La anotación `@Override` indica al compilador que se está
     reemplazando un método existente.

     ```java
     public class Gato extends Animal {
         @Override
         public void comer() {
             System.out.println("El gato come pescado");
         }

         public void maullar() {
             System.out.println("Miau");
         }
     }

     Gato michi = new Gato();
     michi.comer();   // usa la versión sobrescrita
     michi.maullar(); // método propio de Gato
     ```

5. **Uso de `super`**
   - `super` permite acceder a miembros de la superclase, incluso cuando han
     sido sobrescritos.

     ```java
     public class PerroGuia extends Perro {
         @Override
         public void comer() {
             super.comer(); // llama a comer de Animal
             System.out.println("El perro guía come balanceado");
         }
     }
     ```

   - `super` también se utiliza en los constructores para inicializar los
     atributos heredados:

     ```java
     public class Empleado {
         protected String nombre;

         public Empleado(String nombre) {
             this.nombre = nombre;
         }
     }

     public class Gerente extends Empleado {
         private String departamento;

         public Gerente(String nombre, String departamento) {
             super(nombre); // llama al constructor de Empleado
             this.departamento = departamento;
         }
     }
     ```

6. **Ejercicio guiado: Empleado, Gerente y Programador**
   - Crea una clase base `Empleado` con atributos `nombre` y `salario` y un
     método `mostrarInfo()`:

     ```java
     public class Empleado {
         protected String nombre;
         protected double salario;

         public Empleado(String nombre, double salario) {
             this.nombre = nombre;
             this.salario = salario;
         }

         public void mostrarInfo() {
             System.out.println(nombre + ": $" + salario);
         }
     }
     ```

   - `Gerente` hereda de `Empleado` y agrega `departamento`:

     ```java
     public class Gerente extends Empleado {
         private String departamento;

         public Gerente(String nombre, double salario, String departamento) {
             super(nombre, salario);
             this.departamento = departamento;
         }

         @Override
         public void mostrarInfo() {
             super.mostrarInfo();
             System.out.println("Departamento: " + departamento);
         }
     }
     ```

   - `Programador` hereda de `Empleado` y agrega `lenguaje`:

     ```java
     public class Programador extends Empleado {
         private String lenguaje;

         public Programador(String nombre, double salario, String lenguaje) {
             super(nombre, salario);
             this.lenguaje = lenguaje;
         }

         @Override
         public void mostrarInfo() {
             super.mostrarInfo();
             System.out.println("Lenguaje: " + lenguaje);
         }
     }
     ```

   - Finalmente, crea una clase `Main` para probar las subclases:

     ```java
     public class Main {
         public static void main(String[] args) {
             Gerente g = new Gerente("Ana", 5000, "Ventas");
             Programador p = new Programador("Luis", 4000, "Java");

             g.mostrarInfo();
             p.mostrarInfo();
         }
     }
     ```

## Ejercicio independiente

Implementa una subclase `Becario` que herede de `Empleado` e incluya un
atributo `duracionMeses`. Comprueba que puede usar los métodos heredados y que
su versión de `mostrarInfo()` añade la duración de la beca.

## Recursos recomendados

- [Tutorial de herencia en Java](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- [Guía de Java para principiantes](https://www.w3schools.com/java/java_inheritance.asp)

## Actividad adicional

Crea una jerarquía de Pokémon que practique herencia y sobrescritura:

- Clase base `Pokemon` con atributos `nombre` y `puntosVida`, y un método
  `atacar()` que muestre "Embestida".
- Subclases `Charmander`, `Squirtle` y `Bulbasaur` que extiendan `Pokemon`.
  Cada una sobrescribe `atacar()` con su movimiento característico:
  `lanzallamas`, `chorro de agua` y `latigazo cepa`.
- Utiliza `super` en los constructores de las subclases para inicializar los
  atributos heredados.
- Agrega una clase `Batalla` con un método `main` que cree instancias de los
  Pokémon iniciales y llame a `atacar()`.
