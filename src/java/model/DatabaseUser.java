package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mm
 */

public class DatabaseUser {
    public static List <UserItem> listaUsers= new ArrayList<>();
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DvdLibraryPU");
    private EntityManager em = emf.createEntityManager();
    
     public  List <UserItem> getListaUtenti(){
        EntityManager em = emf.createEntityManager();
        try {
        listaUsers =  em.createQuery("SELECT utente FROM utenti;").getResultList();
        return listaUsers;
        }  
        catch (Exception e) { 
        String errore = e.getMessage(); }

        return ;
        }finally {
            em.close();  
        }
        
    
    
    public void addListaUsers(Utente user){
        
        
        this.listaUsers.add(user);
    }
    
    
     public void removeListaUsers(UserItem user){
         int id = listaUsers.indexOf(user);
        this.listaUsers.remove(id);
    }
     
     public static boolean controlloRegistro(String name, String psw){
         for(UserItem user : listaUsers){
             if (user.getPassword().equals (psw) && user.getUsername().equals (name)){
                 return true;
             }
         }
             return false;
    }
  
}

