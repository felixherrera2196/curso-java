# Clase 9 – Colecciones en Java: List, Set, Map y bucles mejorados

En esta clase conocerás las colecciones más utilizadas del paquete `java.util` y aprenderás a elegir la estructura adecuada
según el problema. Además, practicaremos el **bucle mejorado `for-each`** para recorrer colecciones de manera sencilla.

## 1. Arreglos vs colecciones

| Característica           | Arreglos (`[]`)                            | Colecciones (`java.util`)                                 |
|--------------------------|--------------------------------------------|-----------------------------------------------------------|
| Tamaño                   | Fijo desde su creación                     | Dinámico, se ajusta a los elementos añadidos o removidos  |
| Tipos permitidos         | Primitivos y objetos                       | Principalmente objetos (usar _wrappers_ para primitivos)  |
| Operaciones              | Indexación (`arr[i]`), longitud (`length`) | Métodos de alto nivel (`add`, `remove`, `contains`, etc.) |
| Uso recomendado          | Tamaño conocido y acceso por índice        | Datos cambiantes, búsquedas frecuentes o reglas especiales|

**Regla rápida:** elige colecciones cuando necesites flexibilidad o utilidades listas para usar (búsqueda, eliminación, orden,
etc.).

## 2. Comprender la jerarquía de colecciones

Java agrupa las colecciones en interfaces que definen comportamientos. Las más comunes son:

- `Collection`: raíz principal. Agrupa operaciones básicas como `add`, `remove`, `contains`, `size`.
- `List`: colecciones ordenadas e indexadas.
- `Set`: colecciones sin elementos duplicados.
- `Map`: pares clave–valor (no extiende `Collection`, pero es parte del mismo ecosistema).

> Trabajaremos con ejemplos concretos para `List`, `Set` y `Map` usando generics, que indican el tipo de dato que maneja cada
> estructura (`List<String>`, `Set<Integer>`, `Map<String, Double>`, etc.).

## 3. `List`: listas ordenadas e indexadas

### ¿Cuándo usar `List`?
- Necesitas conservar el orden de inserción.
- Requieres acceder por posición (`get(int indice)`).
- Aceptas elementos repetidos.

### Implementaciones comunes
- `ArrayList`: respaldo con arreglo dinámico. Accesos por índice muy rápidos.
- `LinkedList`: nodos enlazados. Inserciones/eliminaciones frecuentes en medio de la lista.

### Operaciones básicas
```java
import java.util.ArrayList;
import java.util.List;

public class EjemploList {
    public static void main(String[] args) {
        List<String> tareas = new ArrayList<>();
        tareas.add("Revisar correo");
        tareas.add("Preparar reporte");
        tareas.add("Revisar correo"); // permitido: duplicados

        System.out.println("Primera tarea: " + tareas.get(0));
        tareas.remove("Preparar reporte");
        System.out.println("Total de tareas: " + tareas.size());
    }
}
```

### Recorriendo una `List` con `for-each`
```java
for (String tarea : tareas) {
    System.out.println("Pendiente: " + tarea);
}
```

## 4. `Set`: colecciones sin duplicados

### ¿Cuándo usar `Set`?
- Debes garantizar unicidad (sin elementos repetidos).
- No te importa el orden, o lo controlas con una implementación específica.

### Implementaciones comunes
- `HashSet`: orden impredecible, operaciones muy rápidas.
- `LinkedHashSet`: conserva el orden de inserción.
- `TreeSet`: mantiene los elementos ordenados naturalmente o mediante un comparador.

### Operaciones básicas
```java
import java.util.HashSet;
import java.util.Set;

public class EjemploSet {
    public static void main(String[] args) {
        Set<String> invitados = new HashSet<>();
        invitados.add("Ana");
        invitados.add("Luis");
        invitados.add("Ana"); // ignorado por duplicado

        System.out.println("Total confirmados: " + invitados.size());
        System.out.println("¿Está Ana? " + invitados.contains("Ana"));
        invitados.remove("Luis");
    }
}
```

### Recorriendo un `Set` con `for-each`
```java
for (String invitado : invitados) {
    System.out.println("Invitado: " + invitado);
}
```

## 5. `Map`: pares clave–valor

### ¿Cuándo usar `Map`?
- Necesitas asociar valores a una clave única (por ejemplo, matrícula → estudiante).
- Requieres buscar rápidamente por clave.

### Implementaciones comunes
- `HashMap`: orden no definido, excelente rendimiento general.
- `LinkedHashMap`: conserva el orden de inserción.
- `TreeMap`: ordena por clave (alfabéticamente o con comparador).

### Operaciones básicas
```java
import java.util.HashMap;
import java.util.Map;

public class EjemploMap {
    public static void main(String[] args) {
        Map<String, Integer> inventario = new HashMap<>();
        inventario.put("Teclado", 15);
        inventario.put("Mouse", 30);
        inventario.put("Teclado", 18); // reemplaza la cantidad anterior

        System.out.println("Stock de teclados: " + inventario.get("Teclado"));
        System.out.println("¿Hay monitores? " + inventario.containsKey("Monitor"));
        inventario.remove("Mouse");
    }
}
```

### Recorrido de un `Map`
```java
// Recorrer claves
for (String producto : inventario.keySet()) {
    System.out.println("Producto: " + producto);
}

// Recorrer valores
for (Integer cantidad : inventario.values()) {
    System.out.println("Cantidad: " + cantidad);
}

// Recorrer pares clave–valor
for (Map.Entry<String, Integer> entrada : inventario.entrySet()) {
    System.out.println(entrada.getKey() + ": " + entrada.getValue());
}
```

## 6. Comparación rápida de estructuras

| Característica            | `List`                                 | `Set`                                        | `Map`                                          |
|---------------------------|----------------------------------------|-----------------------------------------------|-----------------------------------------------|
| Duplicados                | Permitidos                             | No permitidos                                 | Claves únicas, valores repetidos              |
| Orden                     | Mantiene orden de inserción            | Depende de la implementación                  | Depende de la implementación                  |
| Acceso directo            | Por índice (`get`)                     | No aplica                                     | Por clave (`get`)                             |
| Casos de uso típicos      | Listas de tareas, pasos a ejecutar     | Registro de asistentes, etiquetas únicas      | Directorios, inventarios, configuraciones     |

## 7. Bucle mejorado `for-each` e iteradores

El **for-each** simplifica el recorrido sin manejar índices manuales:
```java
for (Tipo elemento : coleccion) {
    // lógica
}
```

Cuando necesites eliminar elementos durante el recorrido, utiliza `Iterator`:
```java
Iterator<Integer> iterador = numeros.iterator();
while (iterador.hasNext()) {
    Integer valor = iterador.next();
    if (valor < 0) {
        iterador.remove();
    }
}
```

## 8. Mini proyecto integrador: control de biblioteca paso a paso

Vamos a construir un pequeño programa de consola que controle los préstamos de una biblioteca. Lo haremos en cuatro pasos para
entender qué aporta cada colección.

### Paso 1. Crear las colecciones necesarias

Necesitamos un `Set` para almacenar los títulos disponibles, un `Map` para saber quién tiene cada libro y un `List` para guardar
el historial de préstamos en orden.

```java
Set<String> catalogo = new HashSet<>();
Map<String, String> librosPrestados = new HashMap<>();
List<String> historialPrestamos = new ArrayList<>();
```

### Paso 2. Registrar libros sin duplicados con `Set`

Cada vez que llega un libro nuevo lo agregamos al catálogo. Si el título ya existe, el `Set` lo ignorará automáticamente.

```java
catalogo.add("Clean Code");
catalogo.add("Effective Java");
catalogo.add("Clean Code"); // no se duplica
```

### Paso 3. Prestar y devolver libros con `Map`

Cuando prestamos un libro guardamos la relación `titulo -> lector`. También aprovechamos para añadir un registro al historial.

```java
String titulo = "Clean Code";
String lector = "Laura";

if (catalogo.contains(titulo) && !librosPrestados.containsKey(titulo)) {
    librosPrestados.put(titulo, lector);
    historialPrestamos.add(titulo + " -> " + lector);
}

// Cuando lo devuelven
librosPrestados.remove(titulo);
```

### Paso 4. Mostrar reportes con `for-each`

Usamos el bucle mejorado para recorrer cada colección y generar un resumen legible.

```java
System.out.println("Catálogo disponible:");
for (String libro : catalogo) {
    System.out.println("- " + libro);
}

System.out.println("\nLibros prestados:");
for (Map.Entry<String, String> registro : librosPrestados.entrySet()) {
    System.out.println(registro.getKey() + " (" + registro.getValue() + ")");
}

System.out.println("\nHistorial de movimientos:");
for (String movimiento : historialPrestamos) {
    System.out.println(movimiento);
}
```

### Código completo

```java
import java.util.*;

public class MiniBiblioteca {
    public static void main(String[] args) {
        Set<String> catalogo = new HashSet<>();
        Map<String, String> librosPrestados = new HashMap<>();
        List<String> historialPrestamos = new ArrayList<>();

        // Paso 2: registrar libros
        catalogo.add("Clean Code");
        catalogo.add("Effective Java");
        catalogo.add("Clean Code");

        // Paso 3: prestar y devolver
        if (catalogo.contains("Clean Code") && !librosPrestados.containsKey("Clean Code")) {
            librosPrestados.put("Clean Code", "Laura");
            historialPrestamos.add("Clean Code -> Laura");
        }

        librosPrestados.remove("Clean Code");
        historialPrestamos.add("Clean Code -> devuelto");

        // Nuevo préstamo
        librosPrestados.put("Clean Code", "Ana");
        historialPrestamos.add("Clean Code -> Ana");

        // Paso 4: reportes
        System.out.println("Catálogo disponible:");
        for (String libro : catalogo) {
            System.out.println("- " + libro);
        }

        System.out.println("\nLibros prestados:");
        for (Map.Entry<String, String> registro : librosPrestados.entrySet()) {
            System.out.println(registro.getKey() + " (" + registro.getValue() + ")");
        }

        System.out.println("\nHistorial de movimientos:");
        for (String movimiento : historialPrestamos) {
            System.out.println(movimiento);
        }
    }
}
```

En este tutorial observas cómo cada colección resuelve una tarea específica:
- `Set` impide duplicar títulos.
- `Map` relaciona libros con lectores.
- `List` conserva el orden cronológico de los movimientos.

## 9. Actividades para practicar

1. **Lista de reproducción guiada:** Crea una clase `Playlist` con un campo `List<String> canciones`. Implementa métodos para
   (a) agregar nuevas canciones, (b) intercambiar la posición de dos canciones con `Collections.swap`, y (c) mostrar la lista
   completa usando un `for-each`. Prueba los métodos desde un `main` agregando al menos cinco canciones.
2. **Filtro de duplicados paso a paso:** Escribe un método `filtrarDuplicados(List<Integer> numeros)` que cree un `HashSet` a
   partir de la lista recibida. Devuelve ese `Set` y, en el `main`, imprime cada número único con un `for-each` indicando en
   pantalla que proviene del conjunto.
3. **Agenda simple con operaciones básicas:** Declara un `Map<String, String>` para relacionar `nombre -> teléfono`. Implementa
   funciones para agregar un contacto nuevo, buscar por nombre, actualizar el teléfono y eliminar contactos. Después, recorre
   el mapa con `for-each` para mostrar un directorio ordenado alfabéticamente usando `TreeMap`.
4. **Encuesta de gustos detallada:** Crea un programa que solicite votos por categoría (por ejemplo, "Acción", "Drama",
   "Comedia") y los almacene en un `Map<String, Integer>`. Agrega un método `imprimirReporte()` que genere un `TreeMap` a partir
   de los datos y use `for-each` para mostrar los resultados ordenados, incluyendo el porcentaje de cada categoría respecto del
   total.
5. **Exploración opcional de `Queue`:** Investiga la interfaz `Queue` y escribe una función que reciba una serie de turnos de
   atención (`String`) y los encole con `LinkedList`. Muestra cómo se atienden usando `poll()` dentro de un `while` hasta que la
   fila esté vacía, explicando con comentarios qué sucede en cada paso.

Con estas herramientas dominarás el uso de las colecciones más comunes de Java y podrás elegir la estructura adecuada en cada
situación.
