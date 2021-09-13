/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;
import java.sql.*;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pruebajdbc?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrivial=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "Admin123";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
    }
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    public static void close(Statement stmt) throws SQLException{
        stmt.close();
    }
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
