package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.entities.Utenti;

/**
 *
 * @author mm
 */

public class DatabaseUser {
    public static List <Utenti> listaUsers= new ArrayList<>();
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DvdLibraryPU");
    private EntityManager em = emf.createEntityManager();
    
     public  List <Utenti> getListaUtenti(){
        EntityManager em = emf.createEntityManager();
        try {
        listaUsers =  em.createQuery("SELECT u FROM u;").getResultList();
        return listaUsers;
        }  
        catch (Exception e) { 
        String errore = e.getMessage(); 
        return null;
     }finally {
            em.close();  
        }
        
     }
    
    public void addListaUsers(Utenti user){
            
        this.listaUsers.add(user);
    }
        
    
    
    
     public void removeListaUsers(UserItem user){
         int id = listaUsers.indexOf(user);
        this.listaUsers.remove(id);
    }
     
     public static boolean controlloRegistro(String name, String psw){
         for(Utenti user : listaUsers){
             if (user.getPassword().equals (psw) && user.getUsername().equals (name)){
                 return true;
             }
         }
             return false;
    } 
  
}

