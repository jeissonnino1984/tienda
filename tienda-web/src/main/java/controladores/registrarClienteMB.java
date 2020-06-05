
package controladores;

import com.mycompany.ejb.UsuarioXRolEJB;
import com.mycompany.entidades.UsuarioXRol;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "registrarClienteMB")
@ViewScoped
public class registrarClienteMB implements Serializable{

    @EJB
    UsuarioXRolEJB usuarioXRolEJB;
    
    private List<UsuarioXRol> listUsuarioXRol;
    private List<UsuarioXRol> listclientes;
 
    @PostConstruct
    public void init() {
        listUsuarioXRol =  usuarioXRolEJB.listaclientes1(1);
        listclientes = usuarioXRolEJB.findAll();
    }

    
       public registrarClienteMB() {
          
    }
       
       
       public void mostrar(){
       
           System.out.println("lista MB---------" +  listUsuarioXRol);
           
          
       
       }

       
       
    public List<UsuarioXRol> getListUsuarioXRol() {
        return listUsuarioXRol;
    }

    public void setListUsuarioXRol(List<UsuarioXRol> listUsuarioXRol) {
        this.listUsuarioXRol = listUsuarioXRol;
    }

    public List<UsuarioXRol> getListclientes() {
        return listclientes;
    }

    public void setListclientes(List<UsuarioXRol> listclientes) {
        this.listclientes = listclientes;
    }
       
       
       
    
}
