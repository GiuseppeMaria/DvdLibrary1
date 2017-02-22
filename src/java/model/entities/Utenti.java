/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mm
 */
@Entity
@Table(name = "utenti")
@NamedQueries({
    @NamedQuery(name = "Utenti.findAll", query = "SELECT u FROM Utenti u")
    , @NamedQuery(name = "Utenti.findById", query = "SELECT u FROM Utenti u WHERE u.id = :id")
    , @NamedQuery(name = "Utenti.findByUsername", query = "SELECT u FROM Utenti u WHERE u.username = :username")
    , @NamedQuery(name = "Utenti.findByPassword", query = "SELECT u FROM Utenti u WHERE u.password = :password")
    , @NamedQuery(name = "Utenti.findByStato", query = "SELECT u FROM Utenti u WHERE u.stato = :stato")
    , @NamedQuery(name = "Utenti.findByRuolo", query = "SELECT u FROM Utenti u WHERE u.ruolo = :ruolo")})
public class Utenti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stato")
    private int stato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ruolo")
    private boolean ruolo;

    public Utenti() {
    }

    public Utenti(Integer id) {
        this.id = id;
    }

    public Utenti(Integer id, String username, String password, int stato, boolean ruolo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.stato = stato;
        this.ruolo = ruolo;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStato() {
        return stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    public boolean getRuolo() {
        return ruolo;
    }

    public void setRuolo(boolean ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utenti)) {
            return false;
        }
        Utenti other = (Utenti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.Utenti[ id=" + id + " ]";
    }
    
    
}
