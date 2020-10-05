
package controladores;

import com.mycompany.ejb.UsuariosEJB;
import com.mycompany.entidades.Usuarios;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import utilitarios.Mensajes;


@Named(value = "loginMB")
@ViewScoped
public class LoginMB implements Serializable{

    @EJB
    UsuariosEJB usuariosEJB;
    
    private String usuario;
    private String contrasena;
    String redireccion = "faces/index.xhtml";
    
    
     
    public LoginMB() {
    }
    
    public String validarDatos() throws IOException{
    List<Usuarios> listuser = usuariosEJB.buscarUsuario(usuario, contrasena);
    if(listuser.size() > 0 ){
    System.out.println("usuario encontrado" + listuser);
    FacesContext.getCurrentInstance().getExternalContext().redirect(redireccion);
    
    }else {
        Mensajes.mensajeERROR("Error, Usuario no encontrado, contacte al administrador");
    }
    
    
    return "usuario no valido";
    
    }
    

    /******************************************************************************/
       
   


    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
