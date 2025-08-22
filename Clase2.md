# Clase 2 – Introducción a la POO

Guía para el estudiante

### Ejemplo motivador

Imagina que necesitas programar el sistema de una biblioteca con cientos de
libros y usuarios. Con un enfoque estructurado tendrías que llevar varias
listas paralelas (`titulos[]`, `autores[]`, `usuarios[]`) y asegurarte de que
cada posición coincida. Al registrar un préstamo, deberías buscar y actualizar
la información en todas esas listas, lo cual es lento y propenso a errores.
Con la programación orientada a objetos puedes crear clases `Libro` y
`Usuario` que contienen tanto los datos como las acciones relacionadas. Esto
permite manejar préstamos y devoluciones de forma sencilla y ordenada.

## Objetivos
- Identificar las limitaciones del enfoque estructurado.
- Comprender los conceptos de objeto y clase.
- Declarar atributos y métodos.
- Crear objetos y utilizar sus métodos en Java.
- Aplicar principios básicos de encapsulación.

## Antes de comenzar
- Repasa los fundamentos de Java vistos en la clase anterior.
- Asegúrate de que los comandos `javac` y `java` funcionan en la terminal.
- Usa un editor de texto para escribir tus archivos `.java`.

## Desarrollo de la clase

1. **Problema del enfoque estructurado**
   - En programación estructurada los datos y las funciones están separados.
   - Si intentas manejar estudiantes con arreglos `nombres[]`, `edades[]` y
     `promedios[]`, debes recordar que la posición 0 de cada arreglo representa
     al mismo estudiante. Esto hace el código difícil de leer y mantener.
   - La programación orientada a objetos agrupa estado (datos) y comportamiento
     (métodos) dentro de una misma unidad llamada objeto, lo que vuelve el
     programa más claro.

2. **Concepto de objeto y clase**
   - Una *clase* es como el plano de un coche: describe qué atributos y
     métodos tendrá.
   - Un *objeto* es el coche construido a partir del plano.
   - Cada objeto creado desde la misma clase tiene su propio estado.

3. **Atributos y métodos**
   - Los **atributos** son variables que guardan información del objeto (por
     ejemplo, `nombre` o `edad`).
   - Los **métodos** son funciones que describen acciones que el objeto puede
     realizar (por ejemplo, `saludar`).
   - Se definen dentro de la clase.
   - Ejemplo:

     ```java
     public class Persona {
         String nombre;
         int edad;

      public void saludar() {
          System.out.println("Hola, soy " + nombre);
      }
  }
  ```

4. **Creación de objetos en Java**
   - Para crear un objeto se usa el operador `new` seguido del nombre de la
     clase.
   - El objeto se guarda en una variable para poder usar sus atributos y
     métodos.
   - Ejemplo:

     ```java
       public class Main {
           public static void main(String[] args) {
               Persona p = new Persona();
               p.nombre = "Ana";
               p.edad = 30;
               p.saludar();
           }
       }
       ```

5. **Encapsulación y constructores básicos**
   - La **encapsulación** consiste en ocultar los detalles internos del objeto
     y exponer solo lo necesario.
   - Un **constructor** es un método especial que se ejecuta al crear el objeto
     y sirve para inicializar sus atributos.
   - Ejemplo de constructor:

     ```java
     public class Persona {
         String nombre;
         int edad;

       public Persona(String nombre, int edad) {
           this.nombre = nombre;
           this.edad = edad;
       }
   }
   ```


## Actividad guiada

Sigue estos pasos para practicar:
1. Implementa la clase `Persona` con un constructor y un método `saludar`.
2. En una clase `Main`, crea al menos dos objetos `Persona` y llama a sus métodos.
3. Imprime la información de cada persona en consola.

## Ejercicio independiente

Crea una clase `Coche` que:
- Tenga atributos como `marca`, `modelo` y `anio`.
- Incluya métodos para `acelerar` y `frenar` que impriman acciones en consola.
- En `main`, crea varios objetos `Coche` y manipula sus métodos.

## Recursos recomendados
- [Documentación oficial de Java](https://docs.oracle.com/javase/tutorial/)
- [Guía de Java para principiantes](https://www.w3schools.com/java/)

## Actividad adicional: Pokémon

Crea una clase `Pokemon` que:
- Tenga atributos `nombre`, `tipo`, `nivel`, `ataquePrincipal` y `sonido`.
- Incluya métodos `atacar`, `esquivar`, `huir` y `gritar` que impriman acciones en consola.
- En `main`, crea al menos dos objetos `Pokemon` y usa sus métodos para practicar.
