# Clase 10 – Manejo de Strings en Java

En esta clase dominarás el manejo de cadenas de texto en Java. Aprenderás por qué los `String` son inmutables, cuáles son sus
métodos más usados y cómo resolver problemas comunes como búsqueda, transformación, formateo y construcción eficiente de
textos. Cada sección incluye ejemplos prácticos y ejercicios para afianzar lo aprendido.

---

## 1. Conceptos clave: literales e inmutabilidad

En Java los `String` son objetos inmutables: una vez creados, su contenido no cambia. Las operaciones que "modifican" una cadena
en realidad devuelven una nueva instancia.

```java
String saludo = "Hola";
saludo.concat(" mundo");
System.out.println(saludo); // Imprime "Hola" porque concat devuelve un nuevo String

String saludoCompleto = saludo + " mundo"; // se crea otro String
```

**Ventajas de la inmutabilidad**
- Seguridad en entornos multi-hilo.
- Facilidad para compartir referencias sin efectos colaterales.
- Uso de _intern pool_: literales iguales comparten memoria.

**Ejercicios para el estudiante**
- Crea dos literales idénticos y compara sus referencias con `==` y `equals`. ¿Qué observas?
- ¿Qué sucede si concatenas dentro de un bucle `for`? Mide el tiempo con `System.nanoTime()`.

---

## 2. Creación y concatenación de Strings

Formas habituales de crear cadenas:

```java
String literal = "Java";                 // literal
String fromConstructor = new String("Java");
String repetido = "Ja" + "va";          // concatenación en tiempo de compilación
String conValor = String.valueOf(2024);   // conversión desde otro tipo
```

Para concatenar, puedes usar el operador `+`, `String.concat` o clases específicas como `StringBuilder` (ver sección 9).

**Ejercicios para el estudiante**
- Convierte un número decimal y uno booleano a `String` usando `String.valueOf` y concatenación.
- Implementa un método que reciba nombre y apellido y devuelva un saludo personalizado usando `concat`.

---

## 3. Propiedades básicas: longitud y contenido

### `length()`
Devuelve la cantidad de caracteres (incluye espacios y símbolos especiales).
```java
String frase = "Programar en Java";
int caracteres = frase.length(); // 18
```

### `isEmpty()` vs `isBlank()` (desde Java 11)
- `isEmpty()`: true si la longitud es 0.
- `isBlank()`: true si la cadena está vacía o solo contiene espacios en blanco.

```java
String vacio = "";
String espacios = "   ";
System.out.println(vacio.isEmpty());   // true
System.out.println(espacios.isEmpty()); // false
System.out.println(espacios.isBlank()); // true
```

**Ejercicios para el estudiante**
- Solicita una frase al usuario y muestra su longitud.
- Implementa un método `esNulaOVacia(String texto)` que regrese `true` si la cadena es `null`, vacía o en blanco.

---

## 4. Acceso y extracción de caracteres

### `charAt(int index)`
Devuelve el carácter en la posición indicada (comienza en 0).
```java
String lenguaje = "Java";
char inicial = lenguaje.charAt(0); // 'J'
```

### `substring(int beginIndex, int endIndex)`
Obtiene un segmento; `endIndex` es exclusivo.
```java
String correo = "contacto@empresa.com";
String dominio = correo.substring(correo.indexOf('@') + 1); // "empresa.com"
```

**Ejercicios para el estudiante**
- Dado un `String`, imprime su primer y último carácter (cuida cadenas de longitud 1).
- Extrae las iniciales de un nombre completo (por ejemplo, "Ada Lovelace" → "AL").

---

## 5. Búsqueda y coincidencias

### `indexOf`, `lastIndexOf`
Permiten localizar subcadenas o caracteres. Regresan `-1` si no se encuentra.
```java
String mensaje = "abracadabra";
int primeraA = mensaje.indexOf('a');      // 0
int ultimaBra = mensaje.lastIndexOf("bra"); // 8
```

### `contains`
Verifica si una subcadena está presente (internamente usa `indexOf`).
```java
boolean hayMagia = mensaje.contains("cada"); // true
```

### `startsWith`, `endsWith`
Comprueban prefijos y sufijos.
```java
String archivo = "reporte.pdf";
boolean esPdf = archivo.endsWith(".pdf"); // true
```

**Ejercicios para el estudiante**
- Pide un dominio web y valida si inicia con `www.` y termina con `.com`.
- Implementa una función que cuente cuántas veces aparece un carácter en una cadena usando `indexOf` en un bucle.

---

## 6. Comparación de Strings

### `equals` y `equalsIgnoreCase`
Comparan contenido respetando o ignorando mayúsculas/minúsculas.
```java
String clave = "Secreto";
System.out.println(clave.equals("secreto"));          // false
System.out.println(clave.equalsIgnoreCase("secreto")); // true
```

### `compareTo`
Orden lexicográfico: devuelve 0 si son iguales, negativo si el receptor es menor y positivo si es mayor.
```java
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

List<String> palabras = Arrays.asList("banana", "arándano", "cereza");
Collections.sort(palabras); // usa compareTo internamente
```

**Ejercicios para el estudiante**
- Ordena alfabéticamente una lista de ciudades ingresadas por teclado.
- Implementa verificación de contraseña sensible a mayúsculas y ofrece una pista usando `equalsIgnoreCase`.

---

## 7. Transformación de Strings

### Cambio de mayúsculas/minúsculas
```java
String titulo = "curso de Java";
System.out.println(titulo.toUpperCase()); // "CURSO DE JAVA"
System.out.println(titulo.toLowerCase()); // "curso de java"
```

### `trim`, `strip`, `stripLeading`, `stripTrailing`
Eliminan espacios al inicio y/o final.
```java
String entrada = "  hola  \n";
System.out.println(entrada.trim());  // "hola"
System.out.println(entrada.strip()); // Java 11: respeta espacios Unicode
```

### `replace`, `replaceFirst`, `replaceAll`
- `replace`: reemplaza caracteres o secuencias exactas.
- `replaceFirst`/`replaceAll`: admiten expresiones regulares.

```java
String texto = "123-456-789";
System.out.println(texto.replace('-', ':'));      // "123:456:789"
System.out.println(texto.replaceAll("\\d", "#")); // "###-###-###"
```

**Ejercicios para el estudiante**
- Normaliza un nombre ingresado eliminando espacios extremos y capitalizando la primera letra.
- Reemplaza todas las vocales de una frase por asteriscos usando `replaceAll`.

---

## 8. División y unión de cadenas

### `split`
Divide la cadena según un delimitador y devuelve un arreglo.
```java
String csv = "Ana,Juan,Luisa";
String[] nombres = csv.split(",");
```

### `String.join`
Une elementos de un arreglo o colección con un delimitador.
```java
String unidos = String.join(" | ", nombres); // "Ana | Juan | Luisa"
```

**Ejercicios para el estudiante**
- Pide una lista de tareas separadas por comas y muéstralas numeradas usando `split`.
- Dado un arreglo de palabras, genera una oración concatenándolas con `String.join`.

---

## 9. Construcción eficiente: `StringBuilder` y `StringBuffer`

Cuando concatenas en ciclos o realizas muchas modificaciones, usa `StringBuilder` (no sincronizado) o `StringBuffer`
(sincronizado).

```java
StringBuilder builder = new StringBuilder();
for (int i = 1; i <= 3; i++) {
    builder.append("Iteración ").append(i).append("\n");
}
String resultado = builder.toString();
```

Métodos útiles: `append`, `insert`, `delete`, `reverse`, `capacity`, `ensureCapacity`.

**Ejercicios para el estudiante**
- Construye una tabla de multiplicar usando `StringBuilder` y muestra el resultado final.
- Implementa un método que invierta una cadena usando `StringBuilder.reverse()`.

---

## 10. Formateo y conversión

### `String.format`
Permite crear plantillas con marcadores (`%s`, `%d`, `%.2f`, etc.).
```java
String reporte = String.format("Producto: %s | Precio: %.2f", "Laptop", 1499.9);
```

### `format` en `System.out.printf`
Imprime directamente con formato.
```java
System.out.printf("%s tiene %d años%n", "Ana", 28);
```

### Conversión con `valueOf`
Convierte números, booleanos y objetos a cadena.
```java
String bool = String.valueOf(true);
String entero = String.valueOf(123);
```

**Ejercicios para el estudiante**
- Genera un resumen de compra con nombre del artículo, cantidad y precio total usando `String.format`.
- Implementa un método que reciba cualquier objeto y devuelva su representación en texto usando `String.valueOf`.

---

## 11. Buenas prácticas con Strings

- Prefiere `StringBuilder` en bucles intensivos.
- Usa `equals` en lugar de `==` para comparar contenido.
- Centraliza formatos y mensajes como constantes para facilitar mantenimiento.
- Evita concatenar literales repetidas; utiliza constantes o `String.format`.

**Ejercicios para el estudiante**
- Refactoriza un código que concatena repetidamente para que use `StringBuilder`.
- Crea una clase `Mensajes` con constantes para textos frecuentes y reutilízala en un programa de consola.

---

---

## Ejercicios finales integradores

Pon a prueba lo aprendido resolviendo los siguientes retos. Cada uno requiere combinar varios métodos comunes de `String`:

1. **Normalizador de correos**: recibe una lista de correos separados por comas, elimina espacios extra, valida que todos terminen en `@empresa.com` y devuelve un resumen indicando cuántos son válidos e inválidos. Usa `split`, `trim`/`strip`, `endsWith`, `toLowerCase` y `String.format` para presentar el resultado.
2. **Analizador de frases**: solicita una frase y genera un informe con la cantidad de palabras, la palabra más larga, cuántas veces aparece cada vocal y si la frase es palíndroma ignorando espacios y mayúsculas/minúsculas. Combina `split`, `length`, `toLowerCase`, `replaceAll`, `contains`, `indexOf`/`lastIndexOf` y `StringBuilder.reverse()`.
3. **Generador de identificadores**: dada una lista de nombres completos, crea un identificador único por persona con el formato `iniciales-aaaammdd` (fecha actual). Normaliza los nombres (`trim`, `toUpperCase`), extrae iniciales con `charAt`/`substring`, asegura que no se repitan agregando un sufijo numérico con `StringBuilder`, y presenta todos los resultados usando `String.join`.

Con este repaso tendrás una base sólida para procesar, validar y presentar información textual en tus aplicaciones Java.
