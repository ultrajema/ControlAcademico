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
@Table(name = "cat_catedraticos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatCatedraticos.findAll", query = "SELECT c FROM CatCatedraticos c")
    , @NamedQuery(name = "CatCatedraticos.findByIdCatedratico", query = "SELECT c FROM CatCatedraticos c WHERE c.idCatedratico = :idCatedratico")
    , @NamedQuery(name = "CatCatedraticos.findByNombre", query = "SELECT c FROM CatCatedraticos c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CatCatedraticos.findByAreaEspecialidad", query = "SELECT c FROM CatCatedraticos c WHERE c.areaEspecialidad = :areaEspecialidad")
    , @NamedQuery(name = "CatCatedraticos.findByTelefono", query = "SELECT c FROM CatCatedraticos c WHERE c.telefono = :telefono")})
public class CatCatedraticos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CATEDRATICO")
    private Integer idCatedratico;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "AREA_ESPECIALIDAD")
    private String areaEspecialidad;
    @Size(max = 20)
    @Column(name = "TELEFONO")
    private String telefono;
    @OneToMany(mappedBy = "idCatedratico")
    private Collection<TbAsignacionCursosCatedratico> tbAsignacionCursosCatedraticoCollection;

    public CatCatedraticos() {
    }

    public CatCatedraticos(Integer idCatedratico) {
        this.idCatedratico = idCatedratico;
    }

    public Integer getIdCatedratico() {
        return idCatedratico;
    }

    public void setIdCatedratico(Integer idCatedratico) {
        this.idCatedratico = idCatedratico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAreaEspecialidad() {
        return areaEspecialidad;
    }

    public void setAreaEspecialidad(String areaEspecialidad) {
        this.areaEspecialidad = areaEspecialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<TbAsignacionCursosCatedratico> getTbAsignacionCursosCatedraticoCollection() {
        return tbAsignacionCursosCatedraticoCollection;
    }

    public void setTbAsignacionCursosCatedraticoCollection(Collection<TbAsignacionCursosCatedratico> tbAsignacionCursosCatedraticoCollection) {
        this.tbAsignacionCursosCatedraticoCollection = tbAsignacionCursosCatedraticoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatedratico != null ? idCatedratico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatCatedraticos)) {
            return false;
        }
        CatCatedraticos other = (CatCatedraticos) object;
        if ((this.idCatedratico == null && other.idCatedratico != null) || (this.idCatedratico != null && !this.idCatedratico.equals(other.idCatedratico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CatCatedraticos[ idCatedratico=" + idCatedratico + " ]";
    }
    
}
