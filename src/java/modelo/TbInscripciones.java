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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carrillo
 */
@Entity
@Table(name = "tb_inscripciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbInscripciones.findAll", query = "SELECT t FROM TbInscripciones t")
    , @NamedQuery(name = "TbInscripciones.findByIdInscripcion", query = "SELECT t FROM TbInscripciones t WHERE t.idInscripcion = :idInscripcion")
    , @NamedQuery(name = "TbInscripciones.findByFechaInscripcion", query = "SELECT t FROM TbInscripciones t WHERE t.fechaInscripcion = :fechaInscripcion")})
public class TbInscripciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INSCRIPCION")
    private Integer idInscripcion;
    @Column(name = "FECHA_INSCRIPCION")
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;
    @JoinColumn(name = "IDCARRERA", referencedColumnName = "IDCARRERA")
    @ManyToOne
    private CatCarreras idcarrera;
    @JoinColumn(name = "CARNET", referencedColumnName = "CARNET")
    @ManyToOne
    private TbAlumnos carnet;

    public TbInscripciones() {
    }

    public TbInscripciones(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public CatCarreras getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(CatCarreras idcarrera) {
        this.idcarrera = idcarrera;
    }

    public TbAlumnos getCarnet() {
        return carnet;
    }

    public void setCarnet(TbAlumnos carnet) {
        this.carnet = carnet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInscripcion != null ? idInscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbInscripciones)) {
            return false;
        }
        TbInscripciones other = (TbInscripciones) object;
        if ((this.idInscripcion == null && other.idInscripcion != null) || (this.idInscripcion != null && !this.idInscripcion.equals(other.idInscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TbInscripciones[ idInscripcion=" + idInscripcion + " ]";
    }
    
}
