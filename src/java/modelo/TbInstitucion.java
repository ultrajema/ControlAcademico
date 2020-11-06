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
@Table(name = "tb_institucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbInstitucion.findAll", query = "SELECT t FROM TbInstitucion t")
    , @NamedQuery(name = "TbInstitucion.findByIdInstitucion", query = "SELECT t FROM TbInstitucion t WHERE t.idInstitucion = :idInstitucion")
    , @NamedQuery(name = "TbInstitucion.findByNombreSede", query = "SELECT t FROM TbInstitucion t WHERE t.nombreSede = :nombreSede")
    , @NamedQuery(name = "TbInstitucion.findByDireccion", query = "SELECT t FROM TbInstitucion t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "TbInstitucion.findByTelefonoSede", query = "SELECT t FROM TbInstitucion t WHERE t.telefonoSede = :telefonoSede")})
public class TbInstitucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INSTITUCION")
    private Integer idInstitucion;
    @Size(max = 45)
    @Column(name = "NOMBRE_SEDE")
    private String nombreSede;
    @Size(max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 20)
    @Column(name = "TELEFONO_SEDE")
    private String telefonoSede;
    @OneToMany(mappedBy = "idInstitucion")
    private Collection<CatFacultades> catFacultadesCollection;

    public TbInstitucion() {
    }

    public TbInstitucion(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public Integer getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoSede() {
        return telefonoSede;
    }

    public void setTelefonoSede(String telefonoSede) {
        this.telefonoSede = telefonoSede;
    }

    @XmlTransient
    public Collection<CatFacultades> getCatFacultadesCollection() {
        return catFacultadesCollection;
    }

    public void setCatFacultadesCollection(Collection<CatFacultades> catFacultadesCollection) {
        this.catFacultadesCollection = catFacultadesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstitucion != null ? idInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbInstitucion)) {
            return false;
        }
        TbInstitucion other = (TbInstitucion) object;
        if ((this.idInstitucion == null && other.idInstitucion != null) || (this.idInstitucion != null && !this.idInstitucion.equals(other.idInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbInstitucion[ idInstitucion=" + idInstitucion + " ]";
    }
    
}
