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
@Table(name = "cat_facultades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatFacultades.findAll", query = "SELECT c FROM CatFacultades c")
    , @NamedQuery(name = "CatFacultades.findByIdfacultad", query = "SELECT c FROM CatFacultades c WHERE c.idfacultad = :idfacultad")
    , @NamedQuery(name = "CatFacultades.findByNombreFacultad", query = "SELECT c FROM CatFacultades c WHERE c.nombreFacultad = :nombreFacultad")})
public class CatFacultades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFACULTAD")
    private Integer idfacultad;
    @Size(max = 100)
    @Column(name = "NOMBRE_FACULTAD")
    private String nombreFacultad;
    @OneToMany(mappedBy = "idfacultad")
    private Collection<CatCarreras> catCarrerasCollection;
    @JoinColumn(name = "ID_INSTITUCION", referencedColumnName = "ID_INSTITUCION")
    @ManyToOne
    private TbInstitucion idInstitucion;

    public CatFacultades() {
    }

    public CatFacultades(Integer idfacultad) {
        this.idfacultad = idfacultad;
    }

    public Integer getIdfacultad() {
        return idfacultad;
    }

    public void setIdfacultad(Integer idfacultad) {
        this.idfacultad = idfacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    @XmlTransient
    public Collection<CatCarreras> getCatCarrerasCollection() {
        return catCarrerasCollection;
    }

    public void setCatCarrerasCollection(Collection<CatCarreras> catCarrerasCollection) {
        this.catCarrerasCollection = catCarrerasCollection;
    }

    public TbInstitucion getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(TbInstitucion idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacultad != null ? idfacultad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatFacultades)) {
            return false;
        }
        CatFacultades other = (CatFacultades) object;
        if ((this.idfacultad == null && other.idfacultad != null) || (this.idfacultad != null && !this.idfacultad.equals(other.idfacultad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CatFacultades[ idfacultad=" + idfacultad + " ]";
    }
    
}
