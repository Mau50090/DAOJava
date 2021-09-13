/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Examen_1;

import datos.PersonaDAO;
import datos.Conexion;
import datos.UsuarioDAO;
import domain.Persona;
import domain.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestExamen1 {

    public static void main(String[] args) throws SQLException{
        
        int contadorPrin = 0;
        int contadorObj = 0;
        int contadorInsertPer = 0;
        int contadorUpdatePer = 0;
        int contadorDeletePer = 0;
        int contadorInsertUs = 0;
        int contadorUpdateUs = 0;
        int contadorDeleteUs = 0;
        Scanner sc = new Scanner(System.in);
        Scanner Objsc = new Scanner(System.in);
        Connection conexion = null;
                                    
        System.out.println("Bienvenido a registros Pitufifantasticos");
        do{
            System.out.println("Elige alguna opcion");
            System.out.println("1.- Insertar");
            System.out.println("2.- Actualizar");
            System.out.println("3.- Eliminar");
            System.out.println("4.- Listar");
            System.out.println("5.- Para ver cuantas veces se han echo los registros");
            System.out.println("6.- Salir");
            contadorPrin = sc.nextInt();
            switch(contadorPrin){
                case 1:
                    System.out.println("Elija a quien quiere Insertar");
                    System.out.println("1.-Usuario");
                    System.out.println("2.-Persona");
                    System.out.println("3.-Para regresar a menu principal");
                    contadorObj = sc.nextInt();
                    switch(contadorObj){
                        case 1:
                                try {
                                    conexion = Conexion.getConnection();
                                    if(conexion.getAutoCommit()){
                                        conexion.setAutoCommit(false);
                                    }
                                      UsuarioDAO UsuarioDAO = new UsuarioDAO(conexion);
                                      Usuario nuevoUsuario = new Usuario();
                                      System.out.println("Ingrese el nombre del nuevo Usuario");
                                      nuevoUsuario.setNomUsuario(Objsc.nextLine());
                                      System.out.println("Ingrese la contraseña del nuevo Usuario");
                                      nuevoUsuario.setPassword(Objsc.nextLine());
                                      contadorInsertUs = UsuarioDAO.insertar(nuevoUsuario);

                                      conexion.commit();
                                      System.out.println("Todo chido bro");
                                } catch (SQLException ex) {
                                    Logger.getLogger(TestExamen1.class.getName()).log(Level.SEVERE, null, ex);
                                    System.out.println("Nel salio mal compa");
                                    try { 
                                        conexion.rollback();
                                    } catch (SQLException ex1) {
                                        ex1.printStackTrace(System.out);
                                    }
                                }
                            break;
                        case 2:
                                try {
                                    conexion = Conexion.getConnection();
                                    if(conexion.getAutoCommit()){
                                        conexion.setAutoCommit(false);
                                    }
                                      PersonaDAO PersonaDAO = new PersonaDAO(conexion);
                                      Persona nuevaPersona = new Persona();
                                      System.out.println("Ingrese el nombre de la nueva Persona");
                                      nuevaPersona.setNombre(Objsc.nextLine());
                                      System.out.println("Ingrese el apellido de la nueva Persona");
                                      nuevaPersona.setApellido(Objsc.nextLine());
                                      System.out.println("Ingrese el email de la nueva Persona");
                                      nuevaPersona.setEmail(Objsc.nextLine());
                                      System.out.println("Ingrese el contraseña de la nueva Persona");
                                      nuevaPersona.setTelefono(Objsc.nextLine());
                                      contadorInsertPer = PersonaDAO.insertar(nuevaPersona);

                                      conexion.commit();
                                      System.out.println("Todo chido bro");
                                } catch (SQLException ex) {
                                    Logger.getLogger(TestExamen1.class.getName()).log(Level.SEVERE, null, ex);
                                    System.out.println("Nel salio mal compa");
                                    try { 
                                        conexion.rollback();
                                    } catch (SQLException ex1) {
                                        ex1.printStackTrace(System.out);
                                    }
                                }
                            break;
                        default:
                            System.out.println("Regresando...");
                            break;
                    }
                break;
                case 2:
                    System.out.println("Elija a quien quiere Actualizar");
                    System.out.println("1.-Usuario");
                    System.out.println("2.-Persona");
                    System.out.println("3.-Para regresar a menu principal");
                    contadorObj = sc.nextInt();
                    switch(contadorObj){
                        case 1:
                            try {
                                    conexion = Conexion.getConnection();
                                    if(conexion.getAutoCommit()){
                                        conexion.setAutoCommit(false);
                                    }
                                      UsuarioDAO UsuarioDAO = new UsuarioDAO(conexion);
                                      Usuario actualizarUsuario = new Usuario();
                                      System.out.println("Ingrese el id del Usuario a Actualizar");
                                      actualizarUsuario.setIdUsuario(Objsc.nextInt());
                                      Objsc.nextLine();
                                      System.out.println("Ingrese el nombre nuevo");
                                      actualizarUsuario.setNomUsuario(Objsc.nextLine());
                                      System.out.println("Ingrese la contraseña nueva");
                                      actualizarUsuario.setPassword(Objsc.nextLine());
                                      contadorUpdateUs = UsuarioDAO.actualizar(actualizarUsuario);

                                      conexion.commit();
                                      System.out.println("Todo chido bro");
                                } catch (SQLException ex) {
                                    Logger.getLogger(TestExamen1.class.getName()).log(Level.SEVERE, null, ex);
                                    System.out.println("Nel salio mal compa");
                                    try { 
                                        conexion.rollback();
                                    } catch (SQLException ex1) {
                                        ex1.printStackTrace(System.out);
                                    }
                                }
                            
                            break;
                        case 2:
                            try {
                                    conexion = Conexion.getConnection();
                                    if(conexion.getAutoCommit()){
                                        conexion.setAutoCommit(false);
                                    }
                                      PersonaDAO PersonaDAO = new PersonaDAO(conexion);
                                      Persona actualizarPersona = new Persona();
                                      System.out.println("Ingrese el Id de la Persona a Actualizar");
                                      actualizarPersona.setIdPersonna(Objsc.nextInt());
                                      Objsc.nextLine();
                                      System.out.println("Ingrese el nombre nuevo");
                                      actualizarPersona.setNombre(Objsc.nextLine());
                                      System.out.println("Ingrese el apellido nuevo");
                                      actualizarPersona.setApellido(Objsc.nextLine());
                                      System.out.println("Ingrese el email nuevo");
                                      actualizarPersona.setEmail(Objsc.nextLine());
                                      System.out.println("Ingrese el telefono nuevo");
                                      actualizarPersona.setTelefono(Objsc.nextLine());
                                      contadorUpdatePer = PersonaDAO.actualizar(actualizarPersona);

                                      conexion.commit();
                                      System.out.println("Todo chido bro");
                                } catch (SQLException ex) {
                                    Logger.getLogger(TestExamen1.class.getName()).log(Level.SEVERE, null, ex);
                                    System.out.println("Nel salio mal compa");
                                    try { 
                                        conexion.rollback();
                                    } catch (SQLException ex1) {
                                        ex1.printStackTrace(System.out);
                                    }
                                }
                            break;
                        default:
                            System.out.println("Regresando...");
                            break;
                    }
                break;
                case 3:
                    System.out.println("Elija a quien quiere Eliminar");
                    System.out.println("1.-Usuario");
                    System.out.println("2.-Persona");
                    System.out.println("3.-Para regresar a menu principal");
                    contadorObj = sc.nextInt();
                    switch(contadorObj){
                        case 1:
                            try {
                                    conexion = Conexion.getConnection();
                                    if(conexion.getAutoCommit()){
                                        conexion.setAutoCommit(false);
                                    }
                                      UsuarioDAO UsuarioDAO = new UsuarioDAO(conexion);
                                      Usuario eliminarUsuario = new Usuario();
                                      
                                      System.out.println("Ingrese el id del Usuario a Eliminar");
                                      eliminarUsuario.setIdUsuario(Objsc.nextInt());
                                      
                                      contadorDeleteUs = UsuarioDAO.eliminar(eliminarUsuario);
                                      
                                      conexion.commit();
                                      System.out.println("Todo chido bro");
                                } catch (SQLException ex) {
                                    Logger.getLogger(TestExamen1.class.getName()).log(Level.SEVERE, null, ex);
                                    System.out.println("Nel salio mal compa");
                                    try { 
                                        conexion.rollback();
                                    } catch (SQLException ex1) {
                                        ex1.printStackTrace(System.out);
                                    }
                                }
                            break;
                        case 2:
                            try {
                                    conexion = Conexion.getConnection();
                                    if(conexion.getAutoCommit()){
                                        conexion.setAutoCommit(false);
                                    }
                                      PersonaDAO PersonaDAO = new PersonaDAO(conexion);
                                      Persona eliminarPersona = new Persona();
                                      System.out.println("Ingrese el Id de la Persona a Eliminar");
                                      eliminarPersona.setIdPersonna(Objsc.nextInt());
                                      contadorDeletePer = PersonaDAO.eliminar(eliminarPersona);

                                      conexion.commit();
                                      System.out.println("Todo chido bro");
                                } catch (SQLException ex) {
                                    Logger.getLogger(TestExamen1.class.getName()).log(Level.SEVERE, null, ex);
                                    System.out.println("Nel salio mal compa");
                                    try { 
                                        conexion.rollback();
                                    } catch (SQLException ex1) {
                                        ex1.printStackTrace(System.out);
                                    }
                                }
                            break;
                        case 3:
                            System.out.println("Regresando...");
                        default:
                            System.out.println("Invalido Ponga un numero del 1-2");
                            break;
                    }
                break;
                case 4:
                    System.out.println("Elija a quien quiere Listar");
                    System.out.println("1.-Usuario");
                    System.out.println("2.-Persona");
                    System.out.println("3.-Para regresar a menu principal");
                    contadorObj = sc.nextInt();
                    switch(contadorObj){
                        case 1:
                            try {
                                    conexion = Conexion.getConnection();
                                    if(conexion.getAutoCommit()){
                                        conexion.setAutoCommit(false);
                                    }
                                      UsuarioDAO UsuarioDAO = new UsuarioDAO(conexion);
                                      
                                      List<Usuario> usuarios = UsuarioDAO.seleccionar();
                                      
                                      usuarios.forEach(usuario ->{
                                        System.out.println(usuario);
                                      });
                                      
                                      conexion.commit();
                                      System.out.println("Todo chido bro");
                                } catch (SQLException ex) {
                                    Logger.getLogger(TestExamen1.class.getName()).log(Level.SEVERE, null, ex);
                                    System.out.println("Nel salio mal compa");
                                    try { 
                                        conexion.rollback();
                                    } catch (SQLException ex1) {
                                        ex1.printStackTrace(System.out);
                                    }
                                }
                            break;
                        case 2:
                            try {
                                    conexion = Conexion.getConnection();
                                    if(conexion.getAutoCommit()){
                                        conexion.setAutoCommit(false);
                                    }
                                      PersonaDAO PersonaDAO = new PersonaDAO(conexion);
                                      
                                      List<Persona> personas = PersonaDAO.seleccionar();
                                      personas.forEach(persona ->{
                                          System.out.println(persona);
                                      });
                                      
                                      conexion.commit();
                                      System.out.println("Todo chido bro");
                                } catch (SQLException ex) {
                                    Logger.getLogger(TestExamen1.class.getName()).log(Level.SEVERE, null, ex);
                                    System.out.println("Nel salio mal compa");
                                    try { 
                                        conexion.rollback();
                                    } catch (SQLException ex1) {
                                        ex1.printStackTrace(System.out);
                                    }
                                }
                            break;
                        default:
                            System.out.println("Regresando...");
                            break;
                    }
                break;
                case 5:
                    System.out.println("Inserciones en Usuario = " + contadorInsertUs);
                    System.out.println("Actualizaciones en Usuario = " + contadorUpdateUs);
                    System.out.println("Eliminados en Usuario = " + contadorDeleteUs);
                    System.out.println("Inserciones en Persona = " + contadorInsertPer);
                    System.out.println("Actualizaciones en Persona = " + contadorUpdatePer);
                    System.out.println("Eliminados en Persona = " + contadorDeletePer);
                    
                break;
                case 6:
                    System.out.println("Vuelva pronto, Adios! :D");
                    System.exit(0);
                break;
                default :
                    System.out.println("Invalido Ponga un numero del 1-4 o sero para salir");
                break;
            }
        }while(contadorPrin!=0);
    }
}
