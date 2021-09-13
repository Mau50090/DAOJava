/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import datos.Conexion;
import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestUsuarioTransaccional {
    public static void main(String[] args){
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
              UsuarioDAO UsuarioDAO = new UsuarioDAO(conexion);
           Usuario actualizarUsuario = new Usuario();
           Usuario eliminarUsuario = new Usuario();
           eliminarUsuario.setIdUsuario(1);
//           actualizarUsuario.setIdUsuario(8);
//           actualizarUsuario.setNomUsuario("Rodolfo");
//           actualizarUsuario.setPassword("2387");
//           UsuarioDAO.actualizar(actualizarUsuario);
             
//            Usuario nuevoUsuario = new Usuario();
//            nuevoUsuario.setNomUsuario("Raul");
//            nuevoUsuario.setPassword("NoSe");
//            UsuarioDAO.insertar(nuevoUsuario);
              UsuarioDAO.eliminar(eliminarUsuario);
            
            conexion.commit();
            System.out.println("Todo chido bro");
        } catch (SQLException ex) {
            Logger.getLogger(testPersonaTransaccional.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nel salio mal compa");
            try { 
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
