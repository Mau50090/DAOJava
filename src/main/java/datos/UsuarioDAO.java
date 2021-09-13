/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;

import static datos.Conexion.getConnection;
import domain.Usuario;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UsuarioDAO {
    
    private Connection conexionTransaccional; 
    private static final String SQL_SELECT = "SELECT id_usuario, nom_usuario, password FROM pruebajdbc.usuario";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
    private static final String SQL_INSERT = "INSERT INTO usuario(nom_usuario, password) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET nom_usuario = ?, password = ? WHERE id_usuario = ? ";
    
    public UsuarioDAO(){
        
    }
    
    public UsuarioDAO(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public List<Usuario> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        
        List<Usuario> usuarios= new ArrayList<>();
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int idusuario = rs.getInt("id_usuario");
                String nombre= rs.getString("nom_usuario");
                String password= rs.getString("password");
                
                usuario = new Usuario(idusuario, nombre, password);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return usuarios;
    }
    
    public int eliminar(Usuario usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
            
            registros = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado con exito","Exitoso", JOptionPane.INFORMATION_MESSAGE);
       } // catch (SQLException ex) {

//        }
        finally{
            try {
                Conexion.close(stmt);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }  
        return registros;
    }
    
    public int insertar(Usuario usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNomUsuario());
            stmt.setString(2, usuario.getPassword());
            
            registros = stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Agregado con exito","Exitoso", JOptionPane.INFORMATION_MESSAGE);
       } // catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al agregar" + ex,"Fracaso", JOptionPane.INFORMATION_MESSAGE);
//        }
        
        finally{
            try {
                Conexion.close(stmt);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int actualizar(Usuario usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getNomUsuario());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getIdUsuario());
            
            registros = stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Actualizado con exito","Exitoso", JOptionPane.INFORMATION_MESSAGE);
        } //catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Actualizado al agregar" + ex,"Fracaso", JOptionPane.INFORMATION_MESSAGE);
//        }
        
        finally{
            try {
                Conexion.close(stmt);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
