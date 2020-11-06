/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carrillo
 */
@Entity
@Table(name = "cat_carreras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatCarreras.findAll", query = "SELECT c FROM CatCarreras c")
    , @NamedQuery(name = "CatCarreras.findByIdcarrera", query = "SELECT c FROM CatCarreras c WHERE c.idcarrera = :idcarrera")
    , @NamedQuery(name = "CatCarreras.findByNombreCarrera", query = "SELECT c FROM CatCarreras c WHERE c.nombreCarrera = :nombreCarrera")})
public class CatCarreras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCARRERA")
    private Integer idcarrera;
    @Size(max = 100)
    @Column(name = "NOMBRE_CARRERA")
    private String nombreCarrera;
    @JoinColumn(name = "IDFACULTAD", referencedColumnName = "IDFACULTAD")
    @ManyToOne
    private CatFacultades idfacultad;
    @OneToMany(mappedBy = "idcarrera")
    private Collection<CatCursos> catCursosCollection;
    @OneToMany(mappedBy = "idcarrera")
    private Collection<TbInscripciones> tbInscripcionesCollection;

    public CatCarreras() {
    }

    public CatCarreras(Integer idcarrera) {
        this.idcarrera = idcarrera;
    }

    public Integer getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Integer idcarrera) {
        this.idcarrera = idcarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public CatFacultades getIdfacultad() {
        return idfacultad;
    }

    public void setIdfacultad(CatFacultades idfacultad) {
        this.idfacultad = idfacultad;
    }

    @XmlTransient
    public Collection<CatCursos> getCatCursosCollection() {
        return catCursosCollection;
    }

    public void setCatCursosCollection(Collection<CatCursos> catCursosCollection) {
        this.catCursosCollection = catCursosCollection;
    }

    @XmlTransient
    public Collection<TbInscripciones> getTbInscripcionesCollection() {
        return tbInscripcionesCollection;
    }

    public void setTbInscripcionesCollection(Collection<TbInscripciones> tbInscripcionesCollection) {
        this.tbInscripcionesCollection = tbInscripcionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcarrera != null ? idcarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatCarreras)) {
            return false;
        }
        CatCarreras other = (CatCarreras) object;
        if ((this.idcarrera == null && other.idcarrera != null) || (this.idcarrera != null && !this.idcarrera.equals(other.idcarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CatCarreras[ idcarrera=" + idcarrera + " ]";
    }
    
}
