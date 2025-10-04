# Clase 6 – Clases abstractas en Java

Guía para el estudiante

## Objetivos
- Comprender el concepto de abstracción y su relación con el modelado de objetos.
- Identificar cuándo conviene utilizar una clase abstracta frente a una clase concreta.
- Declarar clases, métodos y atributos abstractos en Java.
- Diseñar jerarquías de herencia basadas en clases abstractas para reutilizar código.
- Practicar con ejercicios que refuercen la creación de clases abstractas y su implementación en subclases.

## ¿Qué es la abstracción?
La abstracción permite concentrarse en las características esenciales de un objeto, dejando fuera los detalles específicos que pueden variar. En Java, las **clases abstractas** representan este concepto: son plantillas que describen comportamientos y atributos comunes, pero delegan la implementación de ciertos métodos a las subclases.

> Una clase abstracta se declara con la palabra clave `abstract` y **no puede instanciarse directamente**. Sirve como base para otras clases que sí crearán objetos concretos.

## Características principales de las clases abstractas
- Pueden contener **métodos abstractos** (sin cuerpo) y métodos concretos (con implementación).
- Pueden declarar **atributos** y **constructores** que serán utilizados por sus subclases.
- Permiten definir **comportamientos obligatorios** mediante métodos abstractos, garantizando que todas las subclases provean una implementación.
- Participan en relaciones de **herencia simple**: una clase solo puede extender a una clase abstracta a la vez.

## Sintaxis básica
```java
public abstract class Figura {
    private String color;

    public Figura(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double calcularArea();
}
```
En el ejemplo anterior, `Figura` declara un método abstracto `calcularArea()` que obliga a cada subclase a definir su propia forma de calcular el área.

## Implementación en subclases
```java
public class Circulo extends Figura {
    private double radio;

    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
```
La clase `Circulo` hereda de `Figura` e implementa el método abstracto `calcularArea()`. Ahora sí es posible crear instancias de `Circulo`.

## Métodos abstractos vs. concretos
Dentro de una misma clase abstracta puedes mezclar ambos tipos:
```java
public abstract class Animal {
    public abstract void hacerSonido();

    public void dormir() {
        System.out.println("El animal duerme");
    }
}
```
- `hacerSonido()` es abstracto y debe implementarse en cada subclase.
- `dormir()` es concreto y puede reutilizarse sin cambios.

## Uso de constructores en clases abstractas
Aunque no se puedan instanciar, las clases abstractas pueden definir constructores para inicializar atributos comunes:
```java
public abstract class Empleado {
    private String nombre;
    private double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String getNombre() { return nombre; }
    public double getSalarioBase() { return salarioBase; }

    public abstract double calcularSalarioMensual();
}
```
Las subclases llamarán a `super(...)` para reutilizar esa inicialización.

## ¿Cuándo usar clases abstractas?
- Cuando varias clases comparten **atributos y comportamientos comunes**.
- Si necesitas proveer **implementaciones parciales** que luego serán completadas.
- Cuando deseas definir una **plantilla** para un proceso y dejar algunos pasos a cargo de las subclases (patrón Template Method).

## Buenas prácticas
- Mantén el número de métodos abstractos limitado a los que realmente sean obligatorios.
- Documenta claramente qué debe implementar cada subclase.
- Utiliza nombres descriptivos para diferenciar métodos abstractos de concretos.
- Evita mezclar responsabilidades no relacionadas; si surge la necesidad de múltiples jerarquías, considera interfaces.

## Ejemplo práctico: jerarquía Pokémon con clases abstractas
Imagina que quieres modelar distintos tipos de Pokémon conservando datos y comportamientos comunes, pero permitiendo que cada
especie tenga su propio ataque especial. La clase abstracta concentra los atributos y la lógica compartida, mientras que las
subclases concretan los detalles particulares.

```java
public abstract class Pokemon {
    private final String nombre;
    private int puntosVida;

    public Pokemon(String nombre, int puntosVida) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
    }

    public String getNombre() { return nombre; }
    public int getPuntosVida() { return puntosVida; }

    public void recibirDanio(int cantidad) {
        puntosVida = Math.max(0, puntosVida - cantidad);
        System.out.println(nombre + " ahora tiene " + puntosVida + " PS");
    }

    public abstract void atacar();
}

public class Charizard extends Pokemon {
    public Charizard() {
        super("Charizard", 360);
    }

    @Override
    public void atacar() {
        System.out.println("¡Charizard usa Lanzallamas!");
    }
}

public class Blastoise extends Pokemon {
    public Blastoise() {
        super("Blastoise", 362);
    }

    @Override
    public void atacar() {
        System.out.println("¡Blastoise usa Hidrobomba!");
    }
}

public class BatallaPokemon {
    public static void main(String[] args) {
        Pokemon charizard = new Charizard();
        Pokemon blastoise = new Blastoise();

        charizard.atacar();
        blastoise.recibirDanio(90);

        blastoise.atacar();
        charizard.recibirDanio(95);
    }
}
```

Observa cómo `Pokemon` define la estructura básica (`nombre`, `puntosVida`, `recibirDanio()`) y obliga a las subclases a
implementar `atacar()`. Las clases concretas como `Charizard` y `Blastoise` reutilizan la lógica común y personalizan su
movimiento característico.

## Actividad guiada
1. Define una clase abstracta `Vehiculo` con atributos `marca`, `modelo` y un método abstracto `moverse()`.
2. Implementa las subclases `Auto` y `Bicicleta` que sobrescriban `moverse()` con mensajes diferentes.
3. Agrega un método concreto `frenar()` en `Vehiculo` que imprima un mensaje genérico y pruébalo desde las subclases.
4. Crea una clase `Transito` con un método `public static void main(String[] args)` donde instancies `Auto` y `Bicicleta` y llames sus métodos.

## Ejercicio independiente
Diseña una jerarquía para un sistema escolar:
- Clase abstracta `PersonaInstituto` con atributos `nombre`, `edad` y el método abstracto `obtenerRol()`.
- Subclases `Estudiante` y `Docente` que implementen `obtenerRol()` y agreguen comportamientos específicos.
- Una clase `InstitutoDemo` que cree una lista de `PersonaInstituto` y recorra sus elementos mostrando datos y rol.

## Recursos recomendados
- [Documentación oficial de Java sobre clases abstractas](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- [Guía de Oracle sobre herencia](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- Libro *Thinking in Java* de Bruce Eckel (capítulo de herencia y abstracción)

## Para reflexionar
Analiza una funcionalidad de tu proyecto personal y determina si existe algún conjunto de clases que pueda beneficiarse de compartir una clase abstracta. Piensa qué métodos deberían ser obligatorios y cuáles podrían tener una implementación por defecto.
