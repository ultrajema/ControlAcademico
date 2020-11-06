/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carrillo
 */
@Entity
@Table(name = "tb_asignacion_cursos_catedratico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAsignacionCursosCatedratico.findAll", query = "SELECT t FROM TbAsignacionCursosCatedratico t")
    , @NamedQuery(name = "TbAsignacionCursosCatedratico.findByIdAsignacion", query = "SELECT t FROM TbAsignacionCursosCatedratico t WHERE t.idAsignacion = :idAsignacion")
    , @NamedQuery(name = "TbAsignacionCursosCatedratico.findByFechaAsignacion", query = "SELECT t FROM TbAsignacionCursosCatedratico t WHERE t.fechaAsignacion = :fechaAsignacion")})
public class TbAsignacionCursosCatedratico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ASIGNACION")
    private Integer idAsignacion;
    @Column(name = "FECHA_ASIGNACION")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @OneToMany(mappedBy = "idAsignacion")
    private Collection<TbAsignacionCursosAlumno> tbAsignacionCursosAlumnoCollection;
    @JoinColumn(name = "ID_CURSO", referencedColumnName = "ID_CURSO")
    @ManyToOne
    private CatCursos idCurso;
    @JoinColumn(name = "ID_CATEDRATICO", referencedColumnName = "ID_CATEDRATICO")
    @ManyToOne
    private CatCatedraticos idCatedratico;

    public TbAsignacionCursosCatedratico() {
    }

    public TbAsignacionCursosCatedratico(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    @XmlTransient
    public Collection<TbAsignacionCursosAlumno> getTbAsignacionCursosAlumnoCollection() {
        return tbAsignacionCursosAlumnoCollection;
    }

    public void setTbAsignacionCursosAlumnoCollection(Collection<TbAsignacionCursosAlumno> tbAsignacionCursosAlumnoCollection) {
        this.tbAsignacionCursosAlumnoCollection = tbAsignacionCursosAlumnoCollection;
    }

    public CatCursos getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(CatCursos idCurso) {
        this.idCurso = idCurso;
    }

    public CatCatedraticos getIdCatedratico() {
        return idCatedratico;
    }

    public void setIdCatedratico(CatCatedraticos idCatedratico) {
        this.idCatedratico = idCatedratico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacion != null ? idAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAsignacionCursosCatedratico)) {
            return false;
        }
        TbAsignacionCursosCatedratico other = (TbAsignacionCursosCatedratico) object;
        if ((this.idAsignacion == null && other.idAsignacion != null) || (this.idAsignacion != null && !this.idAsignacion.equals(other.idAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbAsignacionCursosCatedratico[ idAsignacion=" + idAsignacion + " ]";
    }
    
}
