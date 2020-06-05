
package controladores;

import com.mycompany.ejb.LugaresEJB;
import com.mycompany.ejb.ProveedorEJB;
import com.mycompany.entidades.Lugares;
import com.mycompany.entidades.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "proveedorMB")
@ViewScoped
public class ProveedorMB implements Serializable{

    @EJB
    ProveedorEJB proveedorEJB;
    @EJB
    LugaresEJB lugaresEJB;

    private int idProveedor;
    private String nombreProveedor;
    private String nit;
    private String nombreRepresent;
    private String apellidoRepresent;
    private String correRepresent;
    private String direccionRepresent;
    private Integer ciudadId;
    private int departamentoSeleccionado;
    
    private Lugares lugares;
    
    private List<Lugares> LisDepartamentos;
    private List<Lugares> ListCiudades;
    
    /*objeto*/
    Proveedor proveedor;
    /*listado de objetos*/
    private List<Proveedor> lisProveedor;
    
    
    public ProveedorMB() {
    }
    
    
    @PostConstruct
    public void inicializar(){
    lisProveedor = proveedorEJB.findAll();
    LisDepartamentos = lugaresEJB.ListarDepartametos();
    
    }
    
     public void listarCiudad() {
        ListCiudades = lugaresEJB.ListarCiudades(departamentoSeleccionado);
    }

    
    
    public void crearProveedor(){
    proveedor = new Proveedor();
    proveedor.setNombre(nombreProveedor.toUpperCase());
    proveedor.setNit(nit);
    proveedor.setNombreRepresentante(nombreRepresent.toUpperCase());
    proveedor.setApellidoRepresentante(apellidoRepresent.toUpperCase());
    proveedor.setCorreo(correRepresent.toLowerCase());
    proveedor.setDireccion(direccionRepresent.toUpperCase());
    proveedor.setCiudadFk(lugaresEJB.find(ciudadId));
    proveedorEJB.create(proveedor);
    System.out.println("se guardo registro");    
    }
    
    public void borrarProveedor (Proveedor proveedor){
    proveedorEJB.remove(proveedor);
    }
    
    public void editarProveedor(Proveedor proveedor){
    proveedorEJB.edit(proveedor);
    }
    
   
 
    /*get y set*/

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreRepresent() {
        return nombreRepresent;
    }

    public void setNombreRepresent(String nombreRepresent) {
        this.nombreRepresent = nombreRepresent;
    }

    public String getApellidoRepresent() {
        return apellidoRepresent;
    }

    public void setApellidoRepresent(String apellidoRepresent) {
        this.apellidoRepresent = apellidoRepresent;
    }

    public String getCorreRepresent() {
        return correRepresent;
    }

    public void setCorreRepresent(String correRepresent) {
        this.correRepresent = correRepresent;
    }

    public String getDireccionRepresent() {
        return direccionRepresent;
    }

    public void setDireccionRepresent(String direccionRepresent) {
        this.direccionRepresent = direccionRepresent;
    }

    public Integer getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Integer ciudadId) {
        this.ciudadId = ciudadId;
    }

    public List<Lugares> getListCiudades() {
        return ListCiudades;
    }

    public void setListCiudades(List<Lugares> ListCiudades) {
        this.ListCiudades = ListCiudades;
    }

    public List<Proveedor> getLisProveedor() {
        return lisProveedor;
    }

    public void setLisProveedor(List<Proveedor> lisProveedor) {
        this.lisProveedor = lisProveedor;
    }

    public int getDepartamentoSeleccionado() {
        return departamentoSeleccionado;
    }

    public void setDepartamentoSeleccionado(int departamentoSeleccionado) {
        this.departamentoSeleccionado = departamentoSeleccionado;
    }

    public List<Lugares> getLisDepartamentos() {
        return LisDepartamentos;
    }

    public void setLisDepartamentos(List<Lugares> LisDepartamentos) {
        this.LisDepartamentos = LisDepartamentos;
    }
    
    
    
}
