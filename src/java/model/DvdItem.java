/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

 
public class DvdItem {
    private String titolo;
    private String genere;
    private int year;
    private int id;
    private static int cont=0;
    

    public DvdItem(String titolo, String genere, int year) {
        this.id=contatore();
        this.titolo = titolo;
        this.genere = genere;
        this.year = year;
        
    }
    
    public static int contatore(){
        return cont++;
    }

    public String getDvdTitolo() {
        return titolo;
    }

    public void setDvdTitolo(String dvdTitolo) {
        this.titolo = titolo;
    }

    public String getDvdGenere() {
        return genere;
    }

    public void setDvdGenere(String genere) {
        this.genere = genere;
    }

    public int getDvdYear() {
        return year;
    }

    public void setDvdYear(int DvdYear) {
        this.year = DvdYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
