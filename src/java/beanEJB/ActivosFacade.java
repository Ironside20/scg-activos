/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEJB;

import beanModelo.Activos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ironside
 */
@Stateless
public class ActivosFacade extends AbstractFacade<Activos> implements ActivosFacadeLocal {

    @PersistenceContext(unitName = "BD_Activos")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActivosFacade() {
        super(Activos.class);
    }
    
}
