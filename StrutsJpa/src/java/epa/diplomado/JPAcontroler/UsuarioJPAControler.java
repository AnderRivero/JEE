package epa.diplomado.JPAcontroler;

import epa.diplomado.modeloJPA.UsuarioJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Hellmuth
 */
public class UsuarioJPAControler {

    public static List iniciarSesion(String us) {

        UsuarioJPA objta;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StrutsJpaPU");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createNamedQuery("UsuarioJPA.findByUs");
        consulta.setParameter("us", us);
        List<UsuarioJPA> listado = consulta.getResultList();

        return listado;

    }

    public static UsuarioJPA buscar(String cedula) throws Exception {

        UsuarioJPA user_respuesta;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StrutsJpaPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        user_respuesta = em.find(UsuarioJPA.class, cedula);
        em.getTransaction().commit();

        em.close();
        emf.close();
        return user_respuesta;
    }

    public static void guardar(UsuarioJPA user) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StrutsJpaPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();//iniciando la transaccion

            UsuarioJPA user_db;

            user_db = em.find(UsuarioJPA.class, user.getUs());

            if (user_db == null) {
                em.persist(user);// sentencia para guardar, recibe el objeto lleno.
                em.getTransaction().commit();//confirmando la transaccion
            }
        } catch (Exception e) {
            em.getTransaction().rollback();//si la transaccion no se logra ejecutar se devuelve la ejecucion
            System.out.println("Error al guardar " + e.getMessage());
        } finally {
            //cerrar en La relacion la base de datos EmtitiyManager
            if (em != null) {
                em.close();
            }
            //cerrar la relacion con el puente de la base de datos EntityManagerFactory

            if (emf != null) {
                emf.close();
            }
        }
    }

    public static List usuarioList() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StrutsJpaPU");
        EntityManager em = emf.createEntityManager();

        List<UsuarioJPA> lista_us = null;																		// persist,remove,merch,find , este permite accesar a las tablas

        Query consulta = em.createNamedQuery("UsuarioJPA.findAll");
        lista_us = consulta.getResultList();

        //cerrar en La relacion la base de datos EmtitiyManager
        if (em != null) {
            em.close();
        }
        //cerrar la relacion con el puente de la base de datos EntityManagerFactory

        if (emf != null) {
            emf.close();
        }

        return lista_us;

    }

}
