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
@Table(name = "cat_cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatCursos.findAll", query = "SELECT c FROM CatCursos c")
    , @NamedQuery(name = "CatCursos.findByIdCurso", query = "SELECT c FROM CatCursos c WHERE c.idCurso = :idCurso")
    , @NamedQuery(name = "CatCursos.findByNombreCurso", query = "SELECT c FROM CatCursos c WHERE c.nombreCurso = :nombreCurso")
    , @NamedQuery(name = "CatCursos.findBySemestre", query = "SELECT c FROM CatCursos c WHERE c.semestre = :semestre")})
public class CatCursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CURSO")
    private Integer idCurso;
    @Size(max = 50)
    @Column(name = "NOMBRE_CURSO")
    private String nombreCurso;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @JoinColumn(name = "IDCARRERA", referencedColumnName = "IDCARRERA")
    @ManyToOne
    private CatCarreras idcarrera;
    @OneToMany(mappedBy = "idCurso")
    private Collection<TbAsignacionCursosAlumno> tbAsignacionCursosAlumnoCollection;
    @OneToMany(mappedBy = "idCurso")
    private Collection<TbAsignacionCursosCatedratico> tbAsignacionCursosCatedraticoCollection;

    public CatCursos() {
    }

    public CatCursos(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public CatCarreras getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(CatCarreras idcarrera) {
        this.idcarrera = idcarrera;
    }

    @XmlTransient
    public Collection<TbAsignacionCursosAlumno> getTbAsignacionCursosAlumnoCollection() {
        return tbAsignacionCursosAlumnoCollection;
    }

    public void setTbAsignacionCursosAlumnoCollection(Collection<TbAsignacionCursosAlumno> tbAsignacionCursosAlumnoCollection) {
        this.tbAsignacionCursosAlumnoCollection = tbAsignacionCursosAlumnoCollection;
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
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatCursos)) {
            return false;
        }
        CatCursos other = (CatCursos) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CatCursos[ idCurso=" + idCurso + " ]";
    }
    
}
