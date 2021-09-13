/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;

import static datos.Conexion.getConnection;
import domain.Persona;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class PersonaDAO {
    
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM pruebajdbc.persona";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ? ";
    
    public PersonaDAO(){
        
    }
    
    public PersonaDAO(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public List<Persona> seleccionar() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        
        List<Persona> personas= new ArrayList<>();
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int idPersona = rs.getInt("id_persona");
                String nombre= rs.getString("nombre");
                String apellido= rs.getString("apellido");
                String email= rs.getString("email");
                String telefono= rs.getString("telefono");
                
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }
        } //catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
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
        return personas;
    }
    
    public int eliminar(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersonna());
            
            registros = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado con exito","Exitoso", JOptionPane.INFORMATION_MESSAGE);
       } // catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al eliminar" + ex,"Fracaso", JOptionPane.INFORMATION_MESSAGE);
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
    
    public int insertar(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            
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
    
    public int actualizar(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersonna());
            
            registros = stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Actualizado con exito","Exitoso", JOptionPane.INFORMATION_MESSAGE);
       } // catch (SQLException ex) {
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
