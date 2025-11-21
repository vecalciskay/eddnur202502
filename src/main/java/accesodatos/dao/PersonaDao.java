package accesodatos.dao;

import accesodatos.ds.Conexion;
import accesodatos.dto.PersonaDto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonaDao {
    public PersonaDto get(int id) {
        Conexion conexion = Conexion.crearConexion();
        String query = "SELECT id, nombre, fechanacimiento, salario, habilitado from personas where id = " + id;
        PersonaDto resultado = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexion.getConnection().createStatement();
            rs = stmt.executeQuery(query);

            rs.next();
            int identifier = rs.getInt("id");
            String n = rs.getString("nombre");
            Date fn = rs.getDate("fechanacimiento");
            float s = rs.getFloat("salario");
            boolean h = rs.getBoolean("habilitado");
            resultado = new PersonaDto(identifier, n, fn, s, h);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                }
                stmt = null;
            }
        }
        return resultado;
    }
}
