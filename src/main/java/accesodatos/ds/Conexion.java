package accesodatos.ds;

import java.sql.*;

public class Conexion {
    protected Connection connection;

    public static Conexion crearConexion() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/edd?" +
                    "user=vladimir&password=amigos123");

            System.out.println("Conectado");
            return new Conexion(conn);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    public Conexion(Connection con) {
        this.connection = con;
    }

    public Connection getConnection() {
        return connection;
    }

    public void cerrarConexion() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
