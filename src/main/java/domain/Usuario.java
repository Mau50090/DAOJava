/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Usuario {

    private int idUsuario;
    private String nomUsuario;
    private String password;

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    public Usuario(String nomUsuario, String password) {
        this.nomUsuario = nomUsuario;
        this.password = password;
    }

    public Usuario(int idUsuario, String nomUsuario, String password) {
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.password = password;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return this.nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nomUsuario=" + nomUsuario + ", password=" + password + '}';
    }
    
    
}
