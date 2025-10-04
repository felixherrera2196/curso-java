# Clase 7 – Interfaces en Java

Guía para el estudiante

## Objetivos
- Comprender qué es una interfaz y cómo define contratos de comportamiento.
- Distinguir las interfaces de las clases abstractas y conocer cuándo utilizar cada una.
- Implementar interfaces en clases concretas y aprovechar la herencia múltiple de tipo.
- Utilizar métodos `default`, `static` y `private` introducidos en versiones recientes de Java.
- Diseñar ejercicios prácticos que demuestren el poder de las interfaces para desacoplar componentes.

## ¿Qué es una interfaz?
Una interfaz es un **contrato** que especifica qué métodos debe implementar una clase. No define atributos de instancia ni lógica concreta (con la excepción de métodos `default` y `static`). Su principal objetivo es **desacoplar** el “qué” del “cómo”: la interfaz describe qué operaciones están disponibles; las clases que la implementan deciden cómo realizarlas.

```java
public interface Mascota {
    void jugar();
    void alimentar();
}
```
La interfaz `Mascota` establece dos métodos. Cualquier clase que la implemente deberá proporcionar su propia versión de `jugar()` y `alimentar()`.

## Diferencias con las clases abstractas
| Característica                    | Clase abstracta                                        | Interfaz                                                  |
|----------------------------------|---------------------------------------------------------|-----------------------------------------------------------|
| Instanciación                    | No se puede instanciar directamente                     | No se puede instanciar                                    |
| Herencia                         | Herencia simple (una sola clase padre)                  | Una clase puede implementar múltiples interfaces          |
| Métodos con implementación       | Sí, con lógica completa                                 | Sí, mediante métodos `default` o `static`                 |
| Atributos                        | Puede tener atributos de instancia                      | Solo constantes (`public static final`)                   |
| Constructores                    | Sí                                                       | No                                                        |
| Uso típico                       | Compartir estado y comportamientos comunes              | Definir contratos y permitir polimorfismo por interfaz    |

## Implementar una interfaz
```java
public class Perro implements Mascota {
    @Override
    public void jugar() {
        System.out.println("El perro trae la pelota");
    }

    @Override
    public void alimentar() {
        System.out.println("Comiendo croquetas");
    }
}
```
Al implementar `Mascota`, la clase `Perro` garantiza que ofrece los métodos declarados en la interfaz, lo que permite tratar a todos los objetos que la implementen de forma uniforme.

## Métodos `default`, `static` y `private`
Desde Java 8, las interfaces pueden contener métodos con implementación:
```java
public interface Conectable {
    void conectar();

    default void reiniciar() {
        System.out.println("Reiniciando dispositivo...");
        desconectarSeguro();
        conectar();
    }

    static void mostrarVersion() {
        System.out.println("Versión de protocolo 1.2");
    }

    private void desconectarSeguro() {
        System.out.println("Desconectando recursos internos...");
    }
}
```
- `default`: proporciona una implementación reutilizable que las clases pueden sobrescribir si lo necesitan.
- `static`: pertenece a la interfaz, no a las instancias. Se invoca como `Conectable.mostrarVersion()`.
- `private`: permite reutilizar lógica dentro de la interfaz sin exponerla a las clases.

## Interfaces funcionales y expresiones lambda
Una **interfaz funcional** tiene un único método abstracto y puede utilizarse con expresiones lambda.
```java
@FunctionalInterface
public interface CalculadoraImpuesto {
    double calcular(double monto);
}

public class Impuestos {
    public static void main(String[] args) {
        CalculadoraImpuesto iva = monto -> monto * 0.21;
        System.out.println(iva.calcular(1000));
    }
}
```
Este enfoque facilita el uso de APIs como Streams.

## Composición de interfaces
Una interfaz puede extender a otra(s) interfaz(es) para reutilizar contratos:
```java
public interface Volador {
    void volar();
}

public interface AveDomestica extends Volador, Mascota {
    void limpiarPlumas();
}
```
Las clases que implementen `AveDomestica` deberán cumplir con todos los métodos de `Volador` y `Mascota` además de los propios.

## ¿Cuándo usar interfaces?
- Cuando distintas clases necesitan **compartir comportamientos** sin relación de herencia directa.
- Para diseñar **APIs** que admitan múltiples implementaciones (por ejemplo, repositorios, servicios, estrategias).
- Para habilitar **polimorfismo** por contrato: las colecciones o métodos pueden trabajar con la interfaz sin conocer la implementación concreta.
- En combinación con la inyección de dependencias y pruebas unitarias, facilitando el reemplazo por dobles de prueba.

## Buenas prácticas
- Asigna nombres que describan capacidades (`Runnable`, `Serializable`).
- Mantén las interfaces enfocadas en un solo propósito.
- Documenta el significado de cada método y sus pre/postcondiciones.
- Evita agregar métodos innecesarios que obliguen a implementaciones irrelevantes.
- Utiliza interfaces funcionales solo cuando realmente representen una operación única.

## Ejemplo práctico: Pokémon que combinan interfaces
Supongamos que quieres modelar Pokémon con habilidades complementarias: algunos pueden atacar a distancia, otros recargar su
energía y otros volar. Las interfaces permiten mezclar capacidades sin forzar una jerarquía rígida.

```java
public interface AtacanteEspecial {
    void lanzarAtaqueEspecial();
}

public interface Recargable {
    void recargarEnergia();
}

public interface Volador {
    void volar();
}

public class Pikachu implements AtacanteEspecial, Recargable {
    @Override
    public void lanzarAtaqueEspecial() {
        System.out.println("¡Pikachu usa Impactrueno!");
    }

    @Override
    public void recargarEnergia() {
        System.out.println("Pikachu absorbe energía eléctrica del ambiente.");
    }
}

public class Pidgeot implements AtacanteEspecial, Volador {
    @Override
    public void lanzarAtaqueEspecial() {
        System.out.println("¡Pidgeot usa Tornado!");
    }

    @Override
    public void volar() {
        System.out.println("Pidgeot toma altura para ganar velocidad.");
    }
}

public class Entrenador {
    public static void main(String[] args) {
        AtacanteEspecial atacante = new Pikachu();
        Recargable recargable = new Pikachu();
        Volador volador = new Pidgeot();

        atacante.lanzarAtaqueEspecial();
        recargable.recargarEnergia();
        volador.volar();
    }
}
```

Gracias al polimorfismo por interfaz, `Entrenador` interactúa con los Pokémon a través de las capacidades que necesita en cada
momento. Una misma clase puede implementar múltiples interfaces (`Pikachu` es atacante y recargable), mientras que otras pueden
proporcionar combinaciones distintas (`Pidgeot` es atacante y volador). Esto favorece la flexibilidad y el desacoplamiento del
código.

## Actividad guiada
1. Define la interfaz `Reproducible` con métodos `play()` y `pause()`.
2. Implementa las clases `Cancion` y `Podcast` que proporcionen comportamiento específico.
3. Crea una interfaz `Descargable` con un método `descargar()` y haz que `Podcast` la implemente adicionalmente.
4. Escribe una clase `BibliotecaMultimedia` que reciba una lista de `Reproducible` y ejecute sus métodos sin conocer la implementación concreta.

## Ejercicio independiente
Modela un sistema de pagos:
- Interfaz `MetodoPago` con `autorizar(double monto)` y `obtenerComision()`.
- Implementaciones `TarjetaCredito`, `TransferenciaBancaria` y `Criptomoneda`.
- Agrega una interfaz `Reembolsable` con `procesarReembolso(double monto)` e impleméntala en las clases que correspondan.
- Crea una clase `Carrito` que utilice polimorfismo por interfaz para procesar distintos métodos de pago.

## Recursos recomendados
- [Documentación oficial de Java sobre interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
- [Guía de interfaces funcionales y lambdas](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
- Libro *Effective Java* de Joshua Bloch (capítulos sobre interfaces y diseños flexibles)

## Para reflexionar
Revisa la jerarquía creada en la clase anterior e identifica qué comportamientos podrían extraerse a interfaces para permitir implementaciones alternativas sin modificar el código existente.
