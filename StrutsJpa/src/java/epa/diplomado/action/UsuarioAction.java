package epa.diplomado.action;

import com.opensymphony.xwork2.ActionSupport;
import epa.diplomado.JPAcontroler.UsuarioJPAControler;
import static epa.diplomado.JPAcontroler.UsuarioJPAControler.usuarioList;
import epa.diplomado.modelo.Usuario;
import epa.diplomado.modeloJPA.UsuarioJPA;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hellmuth
 */
public class UsuarioAction extends ActionSupport {

    private Usuario usuario;
    private ArrayList<UsuarioJPA> amigos;

    public String iniciarSesionAction() {

        String respuesta = ERROR;
        validar();
        List<UsuarioJPA> lista;
        lista = UsuarioJPAControler.iniciarSesion(getUsuario().getUs());

        if (!lista.isEmpty()) {
            if (getUsuario().getUs().equals(lista.get(0).getUs()) && getUsuario().getPass().equals(lista.get(0).getPass())) {

                getUsuario().setCedula(lista.get(0).getCedula());
                getUsuario().setNombre(lista.get(0).getNombre());
                getUsuario().setUs(lista.get(0).getUs());
                getUsuario().setPass(lista.get(0).getPass());

                respuesta = SUCCESS;
            }
        }
        return respuesta;
    }

    public String comprobacion() {
        String respuesta = SUCCESS;

        if (getUsuario().getUs().isEmpty() || getUsuario().getPass().isEmpty()) {
            addFieldError("CV", "Ingrese usuario y contraseña antes de continuar, por favor.");
            respuesta = ERROR;
        }
        return respuesta;
    }

    public String validar() {
        String respuesta = ERROR;
        comprobacion();

        if (getUsuario().getUs().trim().length() == 0 || getUsuario().getPass().trim().length() == 0) {
            addActionError("Debe ingresar los datos!");
        } else {
            addFieldError("EUC", "Usuario y/o contraseña invalidos, por favor, verifique e intente nuevamente");
        }

        return respuesta;
    }

    public String buscarAction() {
        String objCedula = getUsuario().getCedula();
        String respuesta = ERROR;

        try {
            UsuarioJPA user_res = UsuarioJPAControler.buscar(objCedula);
            getUsuario().setCedula(user_res.getCedula());
            getUsuario().setNombre(user_res.getNombre());
            getUsuario().setUs(user_res.getUs());
            getUsuario().setPass(user_res.getPass());
            respuesta = SUCCESS;
        } catch (Exception ex) {
            addFieldError("Error", "Usuario no encontrado.!");
        }
        return respuesta;
    }

    public String registrarAction() {

        String respuesta = ERROR;
        UsuarioJPA user = new UsuarioJPA();//instanciar objeto para recibir los valores

        try {
            user.setCedula(getUsuario().getCedula());
            user.setNombre(getUsuario().getNombre());
            user.setUs(getUsuario().getUs());
            user.setPass(getUsuario().getPass());

            UsuarioJPAControler.guardar(user); //llamado del metodo que recibe por parametro el objeto con sus datos
            getUsuario().setUs("");
            getUsuario().setPass("");
            respuesta = SUCCESS;
        } catch (Exception ex) {
            addFieldError("Error", "Usuario no encontrado.!");
        }
        return respuesta;
    }

    public String listarUsuarios() {
        String respuesta = ERROR;
        //try {

            UsuarioJPA[] usuario = null; 
            List<Usuario> lista = usuarioList();
            amigos =new ArrayList<UsuarioJPA>();
            
            for (int i=0;i<lista.size()-1;i++) {
                
                   usuario[i]=new UsuarioJPA();
                   usuario[i].setUs(lista.get(i).getUs());
                   usuario[i].setPass(lista.get(i).getPass());
                   usuario[i].setNombre(lista.get(i).getNombre());
                   amigos.add(usuario[i]);
            }
                respuesta = SUCCESS;
//        } catch (Exception e) {
//            System.out.println("Error" + e.getMessage());
//            e.printStackTrace();
//        }
        return respuesta;
    }

//metodos getters y setters
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the amigos
     */
    public ArrayList<UsuarioJPA> getAmigos() {
        return amigos;
    }

    /**
     * @param amigos the amigos to set
     */
    public void setAmigos(ArrayList<UsuarioJPA> amigos) {
        this.amigos = amigos;
    }


}
