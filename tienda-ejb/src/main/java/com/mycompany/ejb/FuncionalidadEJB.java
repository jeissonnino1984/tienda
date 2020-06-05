/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.entidades.Factura;
import com.mycompany.entidades.Funcionalidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class FuncionalidadEJB extends AbstractEJB<Funcionalidad> {

    @PersistenceContext(unitName = "com.mycompany_tienda-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionalidadEJB() {
        super(Funcionalidad.class);
    }
    
}
