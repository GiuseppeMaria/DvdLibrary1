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
@Table(name = "film")
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f")
    , @NamedQuery(name = "Film.findById", query = "SELECT f FROM Film f WHERE f.id = :id")
    , @NamedQuery(name = "Film.findByTitolo", query = "SELECT f FROM Film f WHERE f.titolo = :titolo")
    , @NamedQuery(name = "Film.findByGenere", query = "SELECT f FROM Film f WHERE f.genere = :genere")
    , @NamedQuery(name = "Film.findByAnno", query = "SELECT f FROM Film f WHERE f.anno = :anno")})
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "titolo")
    private String titolo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "genere")
    private String genere;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anno")
    private int anno;

    public Film() {
    }

    public Film(Integer id) {
        this.id = id;
    }

    public Film(Integer id, String titolo, String genere, int anno) {
        this.id = id;
        this.titolo = titolo;
        this.genere = genere;
        this.anno = anno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
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
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.Film[ id=" + id + " ]";
    }
    
}
