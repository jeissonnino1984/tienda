
package controladores;

import com.mycompany.ejb.ParametroEJB;
import com.mycompany.ejb.ProductoEJB;
import com.mycompany.ejb.PromocionesEJB;
import com.mycompany.ejb.ProveedorEJB;
import com.mycompany.ejb.SkuEJB;
import com.mycompany.ejb.TipoProductoEJB;
import com.mycompany.entidades.Producto;
import com.mycompany.entidades.Promociones;
import com.mycompany.entidades.Proveedor;
import com.mycompany.entidades.Sku;
import com.mycompany.entidades.TipoProducto;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "productosMB")
@ViewScoped
public class ProductosMB implements Serializable{

   @EJB
    ProductoEJB productoEJB;
    @EJB
    TipoProductoEJB tipoProductoEJB;
    @EJB
    ProveedorEJB proveedorEJB;
    @EJB
    SkuEJB skuEJB;
    @EJB
    ParametroEJB parametroEJB;
    
    private int id;
    private String nombre;
    private int valorUnitario;
    private int unidadesDisponibles;
    private int proveedorId;
    private int tipoProductoId;
    private int valorComprado;
    private int skuId; 
    private int numFactura;
    private String observacion;
    /*porceje a ganar*/
    private int valorGanancia;
   
    private String fechaIngreso;
    private Date fechaIvence;
    
    private String rutaImagenesProducto;

    Producto producto;
    Promociones promociones;

    private TipoProducto tipoProducto;
    private Proveedor proveedor;

    private List<Proveedor> listProveedor;
    private List<TipoProducto> listTipoProducto;
    private List<Producto> listProducto;
    private List<Promociones> ListPromociones;
    private List<Sku> listSku;
    
    public ProductosMB() {
        
    }
    
    @PostConstruct
    public void inicializar() {
        listTipoProducto = tipoProductoEJB.findAll();
        listProveedor = proveedorEJB.findAll();
        listProducto = productoEJB.findAll();
        listSku = skuEJB.findAll();
        rutaImagenesProducto = parametroEJB.rutaImagenProducto().getValor();
    }

    public void crearProducto() {
        producto = new Producto();
        producto.setNombre(nombre);
        producto.setUnidadesDisponibles(unidadesDisponibles);
        producto.setSkuFk(skuEJB.find(skuId));
        producto.setValorComprado(valorComprado);
        producto.setValorGanacia(valorGanancia);
        producto.setValorUnitario(valorProducto(valorComprado, valorGanancia));
        /*utilizamos el metodo de AbstractEJB*/
        producto.setTipoProductoId(tipoProductoEJB.find(tipoProductoId));
        producto.setProveedorId(proveedorEJB.find(proveedorId));
        producto.setFechaIngresa(setiarFecha(new Date()));
        producto.setFechaVence(setiarFecha(fechaIvence));
        producto.setNumFacturaProveedor(numFactura);
        producto.setObservacion(observacion);
        productoEJB.create(producto);
        System.out.println("se guardo registro");

    }

    public void editarProducto(Producto producto) {
       
        producto.setValorUnitario(valorProducto(producto.getValorComprado(), producto.getValorGanacia()));
        productoEJB.edit(producto);
        System.out.println("se edito registro");
    }

    public void borrarProducto(Producto producto) {
        productoEJB.remove(producto);
    }

   
    public Integer valorProducto(int valorCom, int valorGana  ) {
        valorUnitario = (valorCom + (valorCom * valorGana / 100));
        return valorUnitario;

    }

    public Date setiarFecha(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        return date;
    }

    public void onClick(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        System.out.println(dateFormat.format(date));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public int getTipoProductoId() {
        return tipoProductoId;
    }

    public void setTipoProductoId(int tipoProductoId) {
        this.tipoProductoId = tipoProductoId;
    }

    public int getValorComprado() {
        return valorComprado;
    }

    public void setValorComprado(int valorComprado) {
        this.valorComprado = valorComprado;
    }

    public int getValorGanancia() {
        return valorGanancia;
    }

    public void setValorGanancia(int valorGanancia) {
        this.valorGanancia = valorGanancia;
    }

  

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaIvence() {
        return fechaIvence;
    }

    public void setFechaIvence(Date fechaIvence) {
        this.fechaIvence = fechaIvence;
    }

    public List<Proveedor> getListProveedor() {
        return listProveedor;
    }

    public void setListProveedor(List<Proveedor> listProveedor) {
        this.listProveedor = listProveedor;
    }

    public List<TipoProducto> getListTipoProducto() {
        return listTipoProducto;
    }

    public void setListTipoProducto(List<TipoProducto> listTipoProducto) {
        this.listTipoProducto = listTipoProducto;
    }

    public List<Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(List<Producto> listProducto) {
        this.listProducto = listProducto;
    }

    public List<Promociones> getListPromociones() {
        return ListPromociones;
    }

    public void setListPromociones(List<Promociones> ListPromociones) {
        this.ListPromociones = ListPromociones;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public List<Sku> getListSku() {
        return listSku;
    }

    public void setListSku(List<Sku> listSku) {
        this.listSku = listSku;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getRutaImagenesProducto() {
        return rutaImagenesProducto;
    }

    public void setRutaImagenesProducto(String rutaImagenesProducto) {
        this.rutaImagenesProducto = rutaImagenesProducto;
    }
    
    
    
}
