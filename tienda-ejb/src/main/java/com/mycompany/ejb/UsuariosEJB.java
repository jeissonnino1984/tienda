/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.entidades.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class UsuariosEJB extends AbstractEJB<Usuarios> {

    @PersistenceContext(unitName = "com.mycompany_tienda-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosEJB() {
        super(Usuarios.class);
    }
    
    

    public Usuarios buscarUsuarioPorCedula(Integer id) {
        Query qr = em.createQuery("SELECT u FROM Usuarios u WHERE u.id = ?1");
        qr.setParameter(1, id);
        try {
            return (Usuarios) qr.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    
    }
    
    
    /***************************************************************************************************/
    
    
    public List<Usuarios> buscarUsuario(String us, String cl) {
        
        try {

            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ID FROM USUARIOS ");
            sb.append("WHERE USUARIO = ?1 AND CLAVE = ?2");
            Query q = em.createNativeQuery(sb.toString());
            q.setParameter(1, us);
            q.setParameter(2, cl);
            List<Usuarios> listaConsultada =  q.getResultList();
            System.out.println("listado " + listaConsultada);
            return listaConsultada;
            
        } catch (Exception e) {
            System.out.println("error no encontrado EJB" + e);
            
        }
           return null;
    }
    
    
     public List<Usuarios> listaTodosUsuarios(){
    Query q = em.createQuery("SELECT e FROM Usuarios e ");
    return  (List<Usuarios>) q.getResultList();
     }
   
   

    
}
