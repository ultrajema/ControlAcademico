/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.CatCatedraticos;

/**
 *
 * @author Carrillo
 */
@Stateless
public class CatCatedraticosFacade extends AbstractFacade<CatCatedraticos> {

    @PersistenceContext(unitName = "AlumnosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatCatedraticosFacade() {
        super(CatCatedraticos.class);
    }
    
}
