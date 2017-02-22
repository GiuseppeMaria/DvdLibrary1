/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.DvdItem;


public class Database {

    public static Database instance;
    public List<DvdItem> item=new ArrayList<>();
    public ArrayList<DvdItem> Libreria;
    //CREO ENTITA'
    
  //  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DvdLibraryPU");
  //  private EntityManager em = emf.createEntityManager();
    
//public static List <UserItem> listaUsers= new ArrayList<>();
   
    
    private Database() {    
    }

    public static Database getInstance(){
    if(instance==null)
        instance=new Database();
      return instance;
}

    public ArrayList<DvdItem> getLibreria() {
        return Libreria;
    }



public void addObjectToArrayList(String titolo,String genere, int year ){
    DvdItem myDvd= new DvdItem(titolo,genere,year);
    this.Libreria.add(myDvd);
}


 /*   public  List <UserItem> getListaUtenti(){
        addListaUsers(new UserItem(0,"user1",2,true,"pwd1"));
        addListaUsers(new UserItem(0,"user2",2,true,"pwd2"));
        addListaUsers(new UserItem(0,"user3",1,true,"pwd3"));
        return listaUsers;
    }
    
    public void addListaUsers(UserItem user){
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
    }*/
  
}
