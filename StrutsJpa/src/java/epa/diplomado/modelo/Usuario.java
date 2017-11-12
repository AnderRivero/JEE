package epa.diplomado.modelo;
/**
 *
 * @author Hellmuth
 */
public class Usuario {
    private String cedula;
    private String nombre;
    private String us;
    private String pass;

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the us
     */
    public String getUs() {
        return us;
    }

    /**
     * @param us the us to set
     */
    public void setUs(String us) {
        this.us = us;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }     
}
