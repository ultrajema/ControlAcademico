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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carrillo
 */
@Entity
@Table(name = "tb_alumnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAlumnos.findAll", query = "SELECT t FROM TbAlumnos t")
    , @NamedQuery(name = "TbAlumnos.findByCarnet", query = "SELECT t FROM TbAlumnos t WHERE t.carnet = :carnet")
    , @NamedQuery(name = "TbAlumnos.findByNombreAlumno", query = "SELECT t FROM TbAlumnos t WHERE t.nombreAlumno = :nombreAlumno")
    , @NamedQuery(name = "TbAlumnos.findByDireccion", query = "SELECT t FROM TbAlumnos t WHERE t.direccion = :direccion")})
public class TbAlumnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARNET")
    private Integer carnet;
    @Size(max = 100)
    @Column(name = "NOMBRE_ALUMNO")
    private String nombreAlumno;
    @Size(max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @OneToMany(mappedBy = "carnet")
    private Collection<TbAsignacionCursosAlumno> tbAsignacionCursosAlumnoCollection;
    @OneToMany(mappedBy = "carnet")
    private Collection<TbInscripciones> tbInscripcionesCollection;

    public TbAlumnos() {
    }

    public TbAlumnos(Integer carnet) {
        this.carnet = carnet;
    }

    public Integer getCarnet() {
        return carnet;
    }

    public void setCarnet(Integer carnet) {
        this.carnet = carnet;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<TbAsignacionCursosAlumno> getTbAsignacionCursosAlumnoCollection() {
        return tbAsignacionCursosAlumnoCollection;
    }

    public void setTbAsignacionCursosAlumnoCollection(Collection<TbAsignacionCursosAlumno> tbAsignacionCursosAlumnoCollection) {
        this.tbAsignacionCursosAlumnoCollection = tbAsignacionCursosAlumnoCollection;
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
        hash += (carnet != null ? carnet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAlumnos)) {
            return false;
        }
        TbAlumnos other = (TbAlumnos) object;
        if ((this.carnet == null && other.carnet != null) || (this.carnet != null && !this.carnet.equals(other.carnet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbAlumnos[ carnet=" + carnet + " ]";
    }
    
}
