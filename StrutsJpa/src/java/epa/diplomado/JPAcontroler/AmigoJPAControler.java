
package epa.diplomado.JPAcontroler;

import epa.diplomado.modelo.Amigo;
import epa.diplomado.modeloJPA.AmigoJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Rental Servicios
 */
public class AmigoJPAControler {

   public static AmigoJPA buscarAmigo(String cedula) {
        
        AmigoJPA user_respuesta;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StrutsJpaPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        user_respuesta = em.find(AmigoJPA.class, cedula);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
        return user_respuesta;
    }
    
   
   public static List<AmigoJPA> listaAmigos2(){
   
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StrutsJpaPU");
        EntityManager em = emf.createEntityManager();

        List<AmigoJPA> lista_amigo ;	//"SELECT a FROM AmigoJPA a WHERE a.cedula = :cedula")																	// persist,remove,merch,find , este permite accesar a las tablas
      // String jpql = "SELECT a FROM AmigoJPA a WHERE a.idAmigo= ?1";
        Query consulta = em.createNamedQuery("AmigoJPA.findAll");          
               //consulta.setParameter(1,"8838411");
        lista_amigo = consulta.getResultList();

        //cerrar en La relacion la base de datos EmtitiyManager
        if (em != null) {
            em.close();
        }
        //cerrar la relacion con el puente de la base de datos EntityManagerFactory

        if (emf != null) {
            emf.close();
        }

        return lista_amigo;
   
   }
    
   public static void eliminaAmigo(String amigo){
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StrutsJpaPU");
        EntityManager em = emf.createEntityManager();
        
        AmigoJPA user_db;
	user_db=em.find(AmigoJPA .class, amigo);
        
        
        em.remove(user_db);  
	em.getTransaction().commit();
   
        em.close();
        emf.close();
   }
   
   public static void actualizaAmigo(AmigoJPA amigo_act){
       
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("StrutsJpaPU");
      EntityManager em = emf.createEntityManager();      
      
      em.merge(amigo_act);
      em.getTransaction().commit();

      em.close();
      emf.close();
   }
    
}
