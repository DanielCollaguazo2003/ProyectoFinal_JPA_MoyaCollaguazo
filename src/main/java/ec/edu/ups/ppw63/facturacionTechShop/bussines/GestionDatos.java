package ec.edu.ups.ppw63.facturacionTechShop.bussines;

import java.util.Date;
import java.util.List;


import ec.edu.ups.ppw63.facturacionTechShop.dao.CabecerasDao;
import ec.edu.ups.ppw63.facturacionTechShop.dao.CategoriaDao;
import ec.edu.ups.ppw63.facturacionTechShop.dao.ClienteDao;
import ec.edu.ups.ppw63.facturacionTechShop.dao.EmpleadoDao;
import ec.edu.ups.ppw63.facturacionTechShop.dao.ProductosDao;
import ec.edu.ups.ppw63.facturacionTechShop.model.CabeceraFacturas;
import ec.edu.ups.ppw63.facturacionTechShop.model.Categorias;
import ec.edu.ups.ppw63.facturacionTechShop.model.Cliente;
import ec.edu.ups.ppw63.facturacionTechShop.model.DetalleFacturas;
import ec.edu.ups.ppw63.facturacionTechShop.model.Direcciones;
import ec.edu.ups.ppw63.facturacionTechShop.model.Empleados;
import ec.edu.ups.ppw63.facturacionTechShop.model.Productos;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {

	@Inject
	private ClienteDao daoCliente;
	
	@Inject
	private EmpleadoDao daoEmpleado;
	
	@Inject
	private CategoriaDao daoCategoria;
	
	@Inject
	private ProductosDao daoProducto;
	
	@Inject
	private CabecerasDao daoFactura;
	
	@PostConstruct
	public void init() {
System.out.println("iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setCedulaRuc("0107193708");
		cliente.setPrimerNombre("Daniel");
		cliente.setPrimerApellido("Collaguazo");
		cliente.setCorreo("collaguazodaniel48@gmail.com");
		cliente.setContrasenia("Collaguazo123");
		
		daoCliente.insert(cliente);
		
		Cliente cliente2 = new Cliente();
		cliente2.setCedulaRuc("0102735974");
		cliente2.setPrimerNombre("Claudio");
		cliente2.setPrimerApellido("Collaguazo");
		cliente2.setCorreo("claudiocf26@gmail.com");
		cliente2.setContrasenia("Collaguazo123");
		
		daoCliente.insert(cliente2);
		
		Direcciones direcciones = new Direcciones();
		direcciones.setNombrePais("Ecuador");
		direcciones.setNombreCiudad("Cuenca");
		direcciones.setCodigoPostal("010101");
		direcciones.setDireccionPricipal("Racar");
		direcciones.setDireccionSecundaria("Camino sin nombre");
		
		direcciones.addClienteDir(cliente);
		direcciones.addClienteDir(cliente2);
		
		Empleados empleado = new Empleados();
		empleado.setNombre("Christian");
		empleado.setApellido("Collaguazo");
		
		daoEmpleado.insert(empleado);
		
		Productos producto = new Productos();
		producto.setNombre("Lampara");
		producto.setDescripcion("Lampara de cocina de 100W");
		producto.setPrecio(10);
		producto.setCantidad(200);
		producto.setImagen("/asstest/img/lampara.png");
		daoProducto.insert(producto);
		
		Productos producto2 = new Productos();
		producto2.setNombre("Cortina");
		producto2.setDescripcion("Cortina de Cuarto de 2m");
		producto2.setPrecio(15);
		producto2.setCantidad(45);
		producto2.setImagen("/asstest/img/cortina.png");
		daoProducto.insert(producto2);
		
		Productos producto3 = new Productos();
		producto3.setNombre("Mesa Familiar");
		producto3.setDescripcion("Mesa de comedor fammiliar para 6 personas");
		producto3.setPrecio(150);
		producto3.setCantidad(30);
		producto3.setImagen("/asstest/img/mesa.png");
		daoProducto.insert(producto3);
		
		
		Categorias categoria = new Categorias();
		categoria.setNombre("Hogar");
		categoria.setImagen("/asstest/img/cocina.png");
		categoria.addProductos(producto);
		categoria.addProductos(producto2);
		categoria.addProductos(producto3);
		daoCategoria.insert(categoria);
		
		DetalleFacturas det = new DetalleFacturas();
		det.setCantidad(2);
		det.setPrecioTotal(25);
		det.setPrecioIva(5);
		det.setProductos(producto);
		
		CabeceraFacturas factura = new CabeceraFacturas();
		factura.setCliente(cliente);
		factura.setEmpleados(empleado);
		factura.setFecha(new Date());
		factura.setPrecioTotal(100);
		factura.setPrecioIva(20);
		factura.setPrecioSubtotal(80);
		
		factura.addDetalles(det);
		
		DetalleFacturas det2 = new DetalleFacturas();
		det2.setCantidad(3);
		det2.setPrecioTotal(30);
		det2.setPrecioIva(6);
		det2.setProductos(producto2);
		
		factura.addDetalles(det2);
	
		DetalleFacturas det3 = new DetalleFacturas();
		det3.setCantidad(4);
		det3.setPrecioTotal(40);
		det3.setPrecioIva(7);
		det3.setProductos(producto3);
		
		factura.addDetalles(det3);
		
		
		daoFactura.insert(factura);
		
		
		/*System.out.println("\n------------- Clientes");
		List<Cliente> list = daoCliente.getAll();
		for (Cliente cli: list) {
			System.out.println(cli.getCodigo() + "\t" + cli.getNombre());
		}*/
		System.out.println("\n------------- Facturas2");
		List<CabeceraFacturas> list2 = daoFactura.getAll();
		for (CabeceraFacturas fac: list2) {
			System.out.println(fac);
		}
	}
}
