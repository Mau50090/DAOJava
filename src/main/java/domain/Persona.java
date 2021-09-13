package domain;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Persona {
    private int idPersonna;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Persona() {
    }

    public Persona(int idPersonna) {
        this.idPersonna = idPersonna;
    }

    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public Persona(int idPersonna, String nombre, String apellido, String email, String telefono) {
        this.idPersonna = idPersonna;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdPersonna() {
        return this.idPersonna;
    }

    public void setIdPersonna(int idPersonna) {
        this.idPersonna = idPersonna;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersonna=" + idPersonna + ", nombre=" + nombre + ", apellido=" + apellido 
                + ", email=" + email + ", telefono=" + telefono + '}';
    }
}
