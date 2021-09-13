/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;
import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.SQLException;
import java.util.List;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestManejoDAOUsuario {
    public static void main(String[] args) throws SQLException{
    UsuarioDAO usuarioDao = new UsuarioDAO();
    Usuario usuarioAgregar = new Usuario("Roberto", "457654"); 
    Usuario usuarioEditar = new Usuario(3, "Manuel","468");
    Usuario usuarioEliminar = new Usuario(2);
    
    List<Usuario> usuarios = usuarioDao.seleccionar();
    
    //usuarioDao.insertar(usuarioAgregar);
    
    usuarios.forEach(usuario ->{
            System.out.println(usuario);
        });
    usuarioDao.actualizar(usuarioEditar);
    //usuarioDao.eliminar(usuarioEliminar);
}
}
