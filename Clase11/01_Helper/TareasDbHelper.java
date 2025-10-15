import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase de ayuda mínima para manejar una base de datos SQLite desde Java puro.
 * Imita el rol de un SQLiteOpenHelper en Android: prepara la conexión y garantiza
 * que las tablas existan antes de usarlas.
 */
public class TareasDbHelper {

    public static final String DATABASE_NAME = "tareas.db";
    public static final String TABLE_TAREAS = "tareas";
    public static final String COL_ID = "id";
    public static final String COL_TITULO = "titulo";
    public static final String COL_COMPLETADA = "completada";
    public static final String COL_FECHA_LIMITE = "fecha_limite";

    private final String url;
    private boolean esquemaPreparado;

    public TareasDbHelper(String rutaArchivo) {
        this.url = "jdbc:sqlite:" + rutaArchivo;
        this.esquemaPreparado = false;
    }

    /**
     * Abre una conexión lista para usarse. Si la tabla aún no existe, la crea.
     */
    public Connection abrirConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(url);
        conexion.setAutoCommit(false);
        prepararEsquemaSiEsNecesario(conexion);
        return conexion;
    }

    private synchronized void prepararEsquemaSiEsNecesario(Connection conexion) throws SQLException {
        if (esquemaPreparado) {
            return;
        }
        try (Statement statement = conexion.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_TAREAS + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_TITULO + " TEXT NOT NULL, " +
                    COL_COMPLETADA + " INTEGER NOT NULL DEFAULT 0, " +
                    COL_FECHA_LIMITE + " TEXT" +
                    ")");
            conexion.commit();
            esquemaPreparado = true;
        }
    }
}
