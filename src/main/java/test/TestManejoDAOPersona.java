/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;
import datos.PersonaDAO;
import domain.*;
import java.sql.SQLException;
import java.util.List;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestManejoDAOPersona {
    public static void main(String[] args) throws SQLException{
        PersonaDAO personaDao = new PersonaDAO();
        Persona personax = new Persona(); 
        Persona personaAgregar = new Persona("mau","ortiz","asfiuhasdj","fefef");
        
//        List<Persona> personas = personaDao.seleccionar();
        
        personax.setIdPersonna(11);
        
//        personas.forEach(persona ->{
//            System.out.println(persona);
//        });
        //personaDao.insertar(personaAgregar);
        personaDao.eliminar(personax);
        
        /*for (Persona persona:personas){
            System.out.println("persona" + persona);
        }*/
        /////////////////////////////////////////////////////
    }
}
