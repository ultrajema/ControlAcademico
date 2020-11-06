/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.TbAlumnos;

/**
 *
 * @author Carrillo
 */
@Stateless
public class TbAlumnosFacade extends AbstractFacade<TbAlumnos> {

    @PersistenceContext(unitName = "AlumnosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbAlumnosFacade() {
        super(TbAlumnos.class);
    }
    
}
