/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carrillo
 */
@Entity
@Table(name = "tb_asignacion_cursos_alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAsignacionCursosAlumno.findAll", query = "SELECT t FROM TbAsignacionCursosAlumno t")
    , @NamedQuery(name = "TbAsignacionCursosAlumno.findByIdAsignacionCurso", query = "SELECT t FROM TbAsignacionCursosAlumno t WHERE t.idAsignacionCurso = :idAsignacionCurso")
    , @NamedQuery(name = "TbAsignacionCursosAlumno.findByFechaAsignacion", query = "SELECT t FROM TbAsignacionCursosAlumno t WHERE t.fechaAsignacion = :fechaAsignacion")
    , @NamedQuery(name = "TbAsignacionCursosAlumno.findByNotafinal", query = "SELECT t FROM TbAsignacionCursosAlumno t WHERE t.notafinal = :notafinal")
    , @NamedQuery(name = "TbAsignacionCursosAlumno.findByAprovado", query = "SELECT t FROM TbAsignacionCursosAlumno t WHERE t.aprovado = :aprovado")})
public class TbAsignacionCursosAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ASIGNACION_CURSO")
    private Integer idAsignacionCurso;
    @Column(name = "FECHA_ASIGNACION")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @Column(name = "NOTAFINAL")
    private Integer notafinal;
    @Column(name = "APROVADO")
    private Integer aprovado;
    @JoinColumn(name = "CARNET", referencedColumnName = "CARNET")
    @ManyToOne
    private TbAlumnos carnet;
    @JoinColumn(name = "ID_CURSO", referencedColumnName = "ID_CURSO")
    @ManyToOne
    private CatCursos idCurso;
    @JoinColumn(name = "ID_ASIGNACION", referencedColumnName = "ID_ASIGNACION")
    @ManyToOne
    private TbAsignacionCursosCatedratico idAsignacion;

    public TbAsignacionCursosAlumno() {
    }

    public TbAsignacionCursosAlumno(Integer idAsignacionCurso) {
        this.idAsignacionCurso = idAsignacionCurso;
    }

    public Integer getIdAsignacionCurso() {
        return idAsignacionCurso;
    }

    public void setIdAsignacionCurso(Integer idAsignacionCurso) {
        this.idAsignacionCurso = idAsignacionCurso;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Integer getNotafinal() {
        return notafinal;
    }

    public void setNotafinal(Integer notafinal) {
        this.notafinal = notafinal;
    }

    public Integer getAprovado() {
        return aprovado;
    }

    public void setAprovado(Integer aprovado) {
        this.aprovado = aprovado;
    }

    public TbAlumnos getCarnet() {
        return carnet;
    }

    public void setCarnet(TbAlumnos carnet) {
        this.carnet = carnet;
    }

    public CatCursos getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(CatCursos idCurso) {
        this.idCurso = idCurso;
    }

    public TbAsignacionCursosCatedratico getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(TbAsignacionCursosCatedratico idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacionCurso != null ? idAsignacionCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAsignacionCursosAlumno)) {
            return false;
        }
        TbAsignacionCursosAlumno other = (TbAsignacionCursosAlumno) object;
        if ((this.idAsignacionCurso == null && other.idAsignacionCurso != null) || (this.idAsignacionCurso != null && !this.idAsignacionCurso.equals(other.idAsignacionCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbAsignacionCursosAlumno[ idAsignacionCurso=" + idAsignacionCurso + " ]";
    }
    
}
