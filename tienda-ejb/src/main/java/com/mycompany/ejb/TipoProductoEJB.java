/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.entidades.TipoProducto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class TipoProductoEJB extends AbstractEJB<TipoProducto>  {

    @PersistenceContext(unitName = "com.mycompany_tienda-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProductoEJB() {
        super(TipoProducto.class);
    }
    
    public List<TipoProducto> todosTiposProductos(){
    return (List<TipoProducto>) em.createQuery("SELECT p FROM TipoProducto p").getResultList();
    }
    
    public List<TipoProducto> BuscarTipoProductoXtipo(String tipo){
        Query q = em.createQuery("SELECT e FROM TipoProducto e WHERE e.tipo = ?1");
        q.setParameter(1, tipo);
        try {
            return (List<TipoProducto>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void editarEstado(int id, int estado) {

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE TIPO_PRODUCTO SET ESTADO = ?1");
            sb.append(" WHERE ID = ?2 ");
            Query q = em.createNativeQuery(sb.toString());
            q.setParameter(1, estado);
            q.setParameter(2, id);
            q.executeUpdate();
            System.out.println("realizada la actualizacion EJB");
        } catch (Exception e) {
            System.out.println("error EJB" + e);
        }

    }

    
}
