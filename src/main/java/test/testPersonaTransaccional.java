/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class testPersonaTransaccional {
    public static void main(String[] args){
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            PersonaDAO personaDAO = new PersonaDAO(conexion);
            Persona actualizarPersona = new Persona();
            actualizarPersona.setIdPersonna(1);
            actualizarPersona.setNombre("Luis");
            actualizarPersona.setApellido("Villalobos");
            actualizarPersona.setEmail("ioshrgiergrh");
            actualizarPersona.setTelefono("44251836");
            personaDAO.actualizar(actualizarPersona);
            
            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Ariana");
            nuevaPersona.setApellido("Grande");
            nuevaPersona.setEmail("ariana@gmail.com");
            nuevaPersona.setTelefono("44325673");
            personaDAO.insertar(nuevaPersona);
            
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
