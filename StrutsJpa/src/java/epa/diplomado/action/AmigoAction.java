/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epa.diplomado.action;

import com.opensymphony.xwork2.ActionSupport;
import epa.diplomado.JPAcontroler.AmigoJPAControler;
import static epa.diplomado.JPAcontroler.AmigoJPAControler.actualizaAmigo;
import static epa.diplomado.JPAcontroler.AmigoJPAControler.buscarAmigo;
import static epa.diplomado.JPAcontroler.AmigoJPAControler.eliminaAmigo;
import static epa.diplomado.JPAcontroler.AmigoJPAControler.listaAmigos2;
import epa.diplomado.modelo.Amigo;
import epa.diplomado.modelo.Usuario;
import epa.diplomado.modeloJPA.AmigoJPA;
import epa.diplomado.modeloJPA.UsuarioJPA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rental Servicios
 */
public class AmigoAction extends ActionSupport{
    private Usuario usuario;
    private Amigo amigo;
    private ArrayList<Amigo> amigos;
    private Amigo [] misAmigos=null;
    
    public String listaAmigos(){

               amigos=new ArrayList<Amigo>();      
               List<AmigoJPA> lista =  listaAmigos2();
     	
               Amigo amigo1 = new Amigo();
               Amigo amigo2 = new Amigo();
               Amigo amigo3 = new Amigo();
               Amigo amigo4 = new Amigo();
               Amigo amigo5 = new Amigo();

                   amigo1= new Amigo();
                   amigo1.setCedula(lista.get(0).getCedula());
                   amigo1.setNombre(lista.get(0).getNombre());
                   amigo1.setUs(lista.get(0).getUs());
                   amigo1.setPass(lista.get(0).getPass());
                   amigos.add(amigo1);
                   
                   amigo2= new Amigo();
                   amigo2.setCedula(lista.get(1).getCedula());
                   amigo2.setNombre(lista.get(1).getNombre());
                   amigo2.setUs(lista.get(1).getUs());
                   amigo2.setPass(lista.get(1).getPass());
                   amigos.add(amigo2);
                   
                   amigo3= new Amigo();
                   amigo3.setCedula(lista.get(2).getCedula());
                   amigo3.setNombre(lista.get(2).getNombre());
                   amigo3.setUs(lista.get(2).getUs());
                   amigo3.setPass(lista.get(2).getPass());
                   amigos.add(amigo3);
                   
                   amigo4= new Amigo();
                   amigo4.setCedula(lista.get(3).getCedula());
                   amigo4.setNombre(lista.get(3).getNombre());
                   amigo4.setUs(lista.get(3).getUs());
                   amigo4.setPass(lista.get(3).getPass());
                   amigos.add(amigo4);
                   
                   amigo5= new Amigo();
                   amigo5.setCedula(lista.get(4).getCedula());
                   amigo5.setNombre(lista.get(4).getNombre());
                   amigo5.setUs(lista.get(4).getUs());
                   amigo5.setPass(lista.get(4).getPass());
                   amigos.add(amigo5);
                   
            return SUCCESS;
    }

    public String eliminarAmigo(){
    
        eliminaAmigo(amigo.getCedula());
          
        return SUCCESS;
    }
    
    public String ModificarAmigo(){
      
        
        String respuesta = ERROR;

        try {
           AmigoJPA amigo_res = buscarAmigo(amigo.getCedula());
            getUsuario().setCedula(amigo_res.getCedula());
            getUsuario().setNombre(amigo_res.getNombre());
            getUsuario().setUs(amigo_res.getUs());
            getUsuario().setPass(amigo_res.getPass());
            respuesta = SUCCESS;
        } catch (Exception ex) {
            addFieldError("Error", "Usuario no encontrado.!");
        }
        return respuesta;
      
    }
    
    public String ActualizarAmigos(){
        String respuesta = ERROR;
           
       AmigoJPA amigo_act = new AmigoJPA();
       
       amigo_act.setCedula(usuario.getCedula());
       amigo_act.setNombre(usuario.getNombre());
       amigo_act.setUs(usuario.getUs());
       amigo_act.setPass(usuario.getPass());
       
       actualizaAmigo(amigo_act);
        
       respuesta = SUCCESS;
       
        return respuesta;
         
    }
    
    
    /**
     * @return the amigo
     */
    public Amigo getAmigo() {
        return amigo;
    }

    /**
     * @param amigo the amigo to set
     */
    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

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
    public ArrayList<Amigo> getAmigos() {
        return amigos;
    }

    /**
     * @param amigos the amigos to set
     */
    public void setAmigos(ArrayList<Amigo> amigos) {
        this.amigos = amigos;
    }
    
    
    
    
}
