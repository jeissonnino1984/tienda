

package controladores;

import com.mycompany.ejb.RolEJB;
import com.mycompany.ejb.UsuarioXRolEJB;
import com.mycompany.ejb.UsuariosEJB;
import com.mycompany.entidades.Rol;
import com.mycompany.entidades.UsuarioXRol;
import com.mycompany.entidades.Usuarios;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.DualListModel;




@Named(value = "asignarRolMB")
@ViewScoped
public class AsignarRolMB implements Serializable{

    @EJB
    UsuarioXRolEJB usuarioxRolEJB;
    @EJB
    UsuariosEJB usuariosEJB;
    @EJB
    RolEJB rolEJB;
    
    UsuarioXRol usuarioXRol;
    private Usuarios usuarioSeleccionado;
    
    private int usuarioId;
    int rolId;
    Date fechaCrea;
    
    List<Usuarios>  listUser;
    List<Rol> listRol;
    private List<Rol> listRolSeleccionado;
    private List<Usuarios> listUsuariosSeleccionados;
    List<Rol> listRolTarget;
    List<UsuarioXRol> ListUsuarioXRols;
    private DualListModel<Rol>  DuallistModelRol;
  
    
    Usuarios us;
    Rol ro;
     
    public AsignarRolMB() {
    }
    

    
    @PostConstruct
    public void init () {
    listUser = usuariosEJB.findAll();
    listRol =  rolEJB.findAll();
    listRolTarget = rolEJB.findAll();
    ListUsuarioXRols = usuarioxRolEJB.findAll();
                                        
    }
    
    
   
    
    public void crearAsignarRol() {

        for (Rol r : listRolSeleccionado) {
            usuarioxRolEJB.insertXIdRolxIdUsuario(setiarFecha(new Date()), usuarioId, r.getId());

        }
    }

    public void borrarRolxUsuario(UsuarioXRol usuarioXRol){
    
        usuarioxRolEJB.remove(usuarioXRol);
     
    }
    
    
     public Date setiarFecha(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        return date;
    }
    /**********************************************************************************************************/
    
   
    

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public List<Usuarios> getListUser() {
        return listUser;
    }

    public void setListUser(List<Usuarios> listUser) {
        this.listUser = listUser;
    }

    public List<Rol> getListRol() {
        return listRol;
    }

    public void setListRol(List<Rol> listRol) {
        this.listRol = listRol;
    }

    public List<UsuarioXRol> getListUsuarioXRols() {
        return ListUsuarioXRols;
    }

    public void setListUsuarioXRols(List<UsuarioXRol> ListUsuarioXRols) {
        this.ListUsuarioXRols = ListUsuarioXRols;
    }

    public DualListModel<Rol> getDuallistModelRol() {
        return DuallistModelRol;
    }

    public void setDuallistModelRol(DualListModel<Rol> DuallistModelRol) {
        this.DuallistModelRol = DuallistModelRol;
    }

    public List<Rol> getListRolSeleccionado() {
        return listRolSeleccionado;
    }

    public void setListRolSeleccionado(List<Rol> listRolSeleccionado) {
        this.listRolSeleccionado = listRolSeleccionado;
    }

    public List<Usuarios> getListUsuariosSeleccionados() {
        return listUsuariosSeleccionados;
    }

    public void setListUsuariosSeleccionados(List<Usuarios> listUsuariosSeleccionados) {
        this.listUsuariosSeleccionados = listUsuariosSeleccionados;
    }

    public Usuarios getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuarios usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

  
 
    
    
    
}
