package datos;

import domain.Persona;
import java.sql.*;
import java.util.*;
import static datos.Conexion.*;

import static datos.Conexion.getConnection;

public class PersonaDAO {
    private static final String JDBC_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
    private static final String JDBC_INSERT = "INSERT INTO usuario (usuario, password) VALUES (?,?)";
    private static final String JDBC_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE id_usuario = ?";
    private static final String JDBC_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

    public List<Persona> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs  =null;
        Persona persona;
        List<Persona>personas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(JDBC_SELECT);
            rs  = stmt.executeQuery();
            while(rs.next()){
                int id_usuario = rs.getInt("id_usuario");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");


                persona = new Persona(id_usuario,usuario,password);
                personas.add(persona);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;
    }

    public int insertar(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(JDBC_INSERT);
            stmt.setString(1, persona.getUsuario());
            stmt.setString(2, persona.getPassword());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    return rows;
    }

    public int actualizar(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(JDBC_UPDATE);
            stmt.setString(1,persona.getUsuario());
            stmt.setString(2, persona.getPassword());
            stmt.setInt(3,persona.getId_usuario());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try{
                close(stmt);
                close(conn);
            } catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return rows;
    }

    public int eliminar (Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(JDBC_DELETE);
            stmt.setInt(1,persona.getId_usuario());

            rows = stmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return rows;
    }
}

