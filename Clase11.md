# Clase 11 – SQLite desde Java (pensando en Android)

En esta clase trabajaremos con **SQLite usando únicamente Java estándar**. La idea es que practiques los
conceptos básicos (crear tablas, insertar, consultar, actualizar y borrar) en un entorno sencillo de consola.
Así, cuando llegues a Android Studio reconocerás los mismos pasos y no tendrás que aprender dos cosas a la vez.

---

## 1. ¿Qué es SQLite y por qué practicarlo en Java?
- Es un motor de base de datos ligero que guarda la información en un único archivo `.db`.
- No necesitas un servidor aparte; basta con abrir el archivo desde tu aplicación Java.
- Android también usa SQLite internamente, por eso dominarlo aquí reduce la curva de aprendizaje cuando migres a
  `SQLiteOpenHelper` o Room.

**Ejercicio rápido:** Imagina una app de tareas pendientes. Haz una lista de datos que te gustaría guardar en una tabla
`tareas` (título, estado, fecha límite, etc.).

---

## 2. Preparar el entorno
1. Descarga el driver [sqlite-jdbc](https://github.com/xerial/sqlite-jdbc) y colócalo en la carpeta `libs/` de tu
   proyecto (o agrégalo como dependencia en tu herramienta de construcción favorita).
2. Asegúrate de usar Java 8 o superior.
3. Crea una carpeta `Clase11` con dos subcarpetas para organizar los ejemplos:
   - `01_Helper` para la clase que configura la base.
   - `02_CRUD` para la clase que realiza operaciones con los datos.

**Tip:** Si ejecutas los ejemplos desde la línea de comandos, recuerda agregar el `.jar` del driver al classpath, por
   ejemplo: `java -cp .:libs/sqlite-jdbc-3.45.2.0.jar Main` (en Windows usa `;` en lugar de `:`).

---

## 3. Clase de ayuda: `TareasDbHelper`
El archivo [`Clase11/01_Helper/TareasDbHelper.java`](Clase11/01_Helper/TareasDbHelper.java) concentra la lógica para
abrir la base de datos y asegurarse de que la tabla exista.

```java
public class TareasDbHelper {
    private final String url;

    public TareasDbHelper(String rutaArchivo) {
        this.url = "jdbc:sqlite:" + rutaArchivo;
    }

    public Connection abrirConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(url);
        conexion.setAutoCommit(false);
        crearTablaSiNoExiste(conexion);
        return conexion;
    }
}
```

- El constructor recibe la ruta del archivo donde se guardará la base (`tareas.db`).
- `abrirConexion` devuelve un `Connection` listo para usarse y llama a `crearTablaSiNoExiste` para asegurarse de que
  la tabla esté creada.
- Configuramos `autoCommit` en `false` para que puedas decidir cuándo confirmar tus cambios, igual que en Android
  cuando usas transacciones manuales.

**Ejercicio propuesto:** Agrega una columna `descripcion` a la sentencia `CREATE TABLE` y vuelve a ejecutar el programa.
Si la base ya existía, bórrala para que la nueva columna se cree.

---

## 4. Operaciones CRUD con `TareasRepository`
El archivo [`Clase11/02_CRUD/TareasRepository.java`](Clase11/02_CRUD/TareasRepository.java) muestra cómo realizar las
operaciones básicas usando JDBC.

### Insertar
```java
long idGenerado = tareasRepository.insertar("Comprar frutas", false, LocalDate.parse("2024-05-05"));
```
- El método devuelve el `rowId` de la nueva fila, igual que en Android cuando usas `db.insert(...)`.
- Los datos se envían con `PreparedStatement`, así evitas concatenar SQL y previenes inyecciones.

### Consultar
```java
List<Tarea> tareas = tareasRepository.listarTodas();
for (Tarea tarea : tareas) {
    System.out.println(tarea.getTitulo());
}
```
- `listarTodas` usa `ResultSet` para recorrer los registros. En Android harías algo equivalente con un `Cursor`.
- El repositorio convierte cada fila en un objeto `Tarea` para que trabajar con los datos sea más cómodo.

### Actualizar y eliminar
```java
boolean actualizada = tareasRepository.marcarComoCompletada(idGenerado);
boolean eliminada = tareasRepository.eliminar(idGenerado);
```
- Ambos métodos devuelven `true` si afectaron al menos una fila.
- Recuerda llamar a `confirmarCambios()` para realizar el `commit` y a `cerrar()` cuando termines.

**Ejercicio propuesto:** Implementa un método `buscarPorTitulo(String texto)` que utilice `LIKE '%texto%'` y devuelva
una lista filtrada.

---

## 5. Probando todo desde un `main`
Crea una clase `Main` con este flujo:

```java
public static void main(String[] args) {
    TareasDbHelper helper = new TareasDbHelper("tareas.db");
    try (TareasRepository repo = new TareasRepository(helper)) {
        long id = repo.insertar("Repasar comandos", false, LocalDate.now());
        repo.confirmarCambios();
        System.out.println("Tarea creada con id " + id);

        repo.marcarComoCompletada(id);
        repo.confirmarCambios();

        repo.listarTodas().forEach(System.out::println);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
```

- El `try-with-resources` cierra automáticamente el repositorio (y la conexión) al final.
- Practica agregando más operaciones dentro del `try` para ver cómo se comporta la base.

---

## 6. Relación con Android
Aunque aquí no usamos Android Studio, los pasos son muy parecidos a los de un `SQLiteOpenHelper`:
- `TareasDbHelper` equivale a la clase que extiende `SQLiteOpenHelper` y crea las tablas en `onCreate`.
- `TareasRepository` encapsula el acceso a datos, igual que harías con un repositorio o DAO en Android.
- `PreparedStatement` ≈ `ContentValues`/`Cursor`: en ambos casos evitas concatenar SQL crudo y manejas bien los tipos.
- `confirmarCambios()` refleja cuándo llamarías a `db.setTransactionSuccessful()` y `db.endTransaction()`.

Cuando estés en Android solo cambiará la forma de obtener la conexión, pero la lógica de SQL y el orden de los pasos
serán casi idénticos.

---

## 7. Buenas prácticas
- Usa constantes para los nombres de tablas y columnas; así evitas errores al escribir consultas.
- Versiona tu esquema manualmente: guarda la versión actual en una constante y documenta los cambios.
- Maneja las excepciones `SQLException` mostrando mensajes claros o encapsulándolos en tus propias excepciones.
- Realiza copias de seguridad del archivo `.db` antes de experimentar con cambios grandes.

**Desafío:** Crea una segunda tabla `categorias` con un `id` y `nombre`. Agrega una columna `categoria_id` a `tareas` y
practica un `INNER JOIN` para mostrar el nombre de la categoría.

---

## 8. Recursos adicionales
- [Documentación oficial de JDBC](https://docs.oracle.com/javase/tutorial/jdbc/)
- [Guía de SQLite (sqlite.org)](https://www.sqlite.org/docs.html)
- [Driver sqlite-jdbc (Xerial)](https://github.com/xerial/sqlite-jdbc)

¡Listo! Practica estos ejemplos y verás que, cuando llegues a Android, la base de datos te resultará familiar.
