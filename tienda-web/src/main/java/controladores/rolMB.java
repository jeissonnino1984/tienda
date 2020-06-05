
package controladores;


import com.mycompany.ejb.RolEJB;
import com.mycompany.entidades.Rol;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named(value = "rolMB")
@ViewScoped
public class rolMB implements Serializable{

    @EJB
    RolEJB rolEJB;
    
    private String descripcion;
    private Date fechaCrea;
    private int estado;
    
    Rol rol;
    
    private List<Rol> listRol;

    public rolMB() {
        estado = 1;
    }
    
    @PostConstruct
    public void inicializar(){
    iniciarListas();
    }

    public rolMB(String descripcion, Date fechaCrea, int estado, List<Rol> listRol) {
        this.descripcion = descripcion;
        this.fechaCrea = fechaCrea;
        this.estado = estado;
        this.listRol = listRol;
    }
    
    public void crearRol(){
        rol = new Rol();
        rol.setDescripcion(descripcion);
        rol.setEstado(estado);
        rol.setFechaCrea(new Date());
        rolEJB.create(rol);
        System.out.println("se crea registro");
    }
    
     public void editarRol(Rol rol){
      rolEJB.edit(rol);
    }
     
     
      public void borrarRol(Rol rol){
          rolEJB.remove(rol);
    }
      
      public void iniciarListas(){
      
      listRol = rolEJB.findAll();
      }
    
    /*GET y SET*/

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<Rol> getListRol() {
        return listRol;
    }

    public void setListRol(List<Rol> listRol) {
        this.listRol = listRol;
    }
    
}
