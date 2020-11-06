/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.TbInscripciones;

/**
 *
 * @author Carrillo
 */
@Stateless
public class TbInscripcionesFacade extends AbstractFacade<TbInscripciones> {

    @PersistenceContext(unitName = "AlumnosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbInscripcionesFacade() {
        super(TbInscripciones.class);
    }
    
}
