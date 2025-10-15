import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio sencillo que encapsula las operaciones CRUD sobre la tabla de tareas
 * usando JDBC. Implementa AutoCloseable para poder usarse dentro de un bloque try-with-resources.
 */
public class TareasRepository implements AutoCloseable {

    private final Connection conexion;

    public TareasRepository(TareasDbHelper helper) throws SQLException {
        this.conexion = helper.abrirConexion();
    }

    public long insertar(String titulo, boolean completada, LocalDate fechaLimite) throws SQLException {
        String sql = "INSERT INTO " + TareasDbHelper.TABLE_TAREAS +
                " (" + TareasDbHelper.COL_TITULO + ", " +
                TareasDbHelper.COL_COMPLETADA + ", " +
                TareasDbHelper.COL_FECHA_LIMITE + ") VALUES (?, ?, ?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, titulo);
            statement.setInt(2, completada ? 1 : 0);
            if (fechaLimite != null) {
                statement.setString(3, fechaLimite.toString());
            } else {
                statement.setNull(3, java.sql.Types.VARCHAR);
            }
            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getLong(1);
                }
            }
        }
        return -1L;
    }

    public List<Tarea> listarTodas() throws SQLException {
        String sql = "SELECT " +
                String.join(", ",
                        TareasDbHelper.COL_ID,
                        TareasDbHelper.COL_TITULO,
                        TareasDbHelper.COL_COMPLETADA,
                        TareasDbHelper.COL_FECHA_LIMITE) +
                " FROM " + TareasDbHelper.TABLE_TAREAS +
                " ORDER BY " + TareasDbHelper.COL_FECHA_LIMITE + " IS NULL, " +
                TareasDbHelper.COL_FECHA_LIMITE + " ASC";

        List<Tarea> tareas = new ArrayList<>();
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                long id = resultSet.getLong(TareasDbHelper.COL_ID);
                String titulo = resultSet.getString(TareasDbHelper.COL_TITULO);
                boolean completada = resultSet.getInt(TareasDbHelper.COL_COMPLETADA) == 1;
                String fechaTexto = resultSet.getString(TareasDbHelper.COL_FECHA_LIMITE);
                LocalDate fecha = fechaTexto != null ? LocalDate.parse(fechaTexto) : null;
                tareas.add(new Tarea(id, titulo, completada, fecha));
            }
        }
        return tareas;
    }

    public Optional<Tarea> buscarPorId(long id) throws SQLException {
        String sql = "SELECT * FROM " + TareasDbHelper.TABLE_TAREAS +
                " WHERE " + TareasDbHelper.COL_ID + " = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapearTarea(resultSet));
                }
            }
        }
        return Optional.empty();
    }

    public boolean marcarComoCompletada(long id) throws SQLException {
        String sql = "UPDATE " + TareasDbHelper.TABLE_TAREAS +
                " SET " + TareasDbHelper.COL_COMPLETADA + " = 1 WHERE " +
                TareasDbHelper.COL_ID + " = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setLong(1, id);
            int filas = statement.executeUpdate();
            return filas > 0;
        }
    }

    public boolean eliminar(long id) throws SQLException {
        String sql = "DELETE FROM " + TareasDbHelper.TABLE_TAREAS +
                " WHERE " + TareasDbHelper.COL_ID + " = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setLong(1, id);
            int filas = statement.executeUpdate();
            return filas > 0;
        }
    }

    public void confirmarCambios() throws SQLException {
        conexion.commit();
    }

    public void deshacerCambios() {
        try {
            conexion.rollback();
        } catch (SQLException e) {
            // En un ejemplo sencillo solo imprimimos la traza.
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }

    private Tarea mapearTarea(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(TareasDbHelper.COL_ID);
        String titulo = resultSet.getString(TareasDbHelper.COL_TITULO);
        boolean completada = resultSet.getInt(TareasDbHelper.COL_COMPLETADA) == 1;
        String fechaTexto = resultSet.getString(TareasDbHelper.COL_FECHA_LIMITE);
        LocalDate fecha = fechaTexto != null ? LocalDate.parse(fechaTexto) : null;
        return new Tarea(id, titulo, completada, fecha);
    }

    public static class Tarea {
        private final long id;
        private final String titulo;
        private final boolean completada;
        private final LocalDate fechaLimite;

        public Tarea(long id, String titulo, boolean completada, LocalDate fechaLimite) {
            this.id = id;
            this.titulo = titulo;
            this.completada = completada;
            this.fechaLimite = fechaLimite;
        }

        public long getId() {
            return id;
        }

        public String getTitulo() {
            return titulo;
        }

        public boolean estaCompletada() {
            return completada;
        }

        public LocalDate getFechaLimite() {
            return fechaLimite;
        }

        @Override
        public String toString() {
            return String.format("[%d] %s - completada=%s - fecha=%s",
                    id,
                    titulo,
                    completada ? "sí" : "no",
                    fechaLimite != null ? fechaLimite : "(sin fecha)");
        }
    }
}
