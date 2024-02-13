package ec.edu.ups.ppw63.facturacionTechShop.bussines;

import java.util.Date;
import java.util.List;


import ec.edu.ups.ppw63.facturacionTechShop.dao.CabecerasDao;
import ec.edu.ups.ppw63.facturacionTechShop.dao.CarritoDAO;
import ec.edu.ups.ppw63.facturacionTechShop.dao.CategoriaDao;
import ec.edu.ups.ppw63.facturacionTechShop.dao.ClienteDao;
import ec.edu.ups.ppw63.facturacionTechShop.dao.ProductosDao;
import ec.edu.ups.ppw63.facturacionTechShop.model.CabeceraFacturas;
import ec.edu.ups.ppw63.facturacionTechShop.model.Carrito;
import ec.edu.ups.ppw63.facturacionTechShop.model.Categorias;
import ec.edu.ups.ppw63.facturacionTechShop.model.Cliente;
import ec.edu.ups.ppw63.facturacionTechShop.model.DetalleFacturas;
import ec.edu.ups.ppw63.facturacionTechShop.model.Detalles_Carrito;
import ec.edu.ups.ppw63.facturacionTechShop.model.Direcciones;
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
	private CategoriaDao daoCategoria;
	
	@Inject
	private ProductosDao daoProducto;
	
	@Inject
	private CabecerasDao daoFactura;
	
	@Inject
	private CarritoDAO daoCarrito;
	
	@PostConstruct
	public void init() {
System.out.println("iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setPrimerNombre("Daniel");
		cliente.setPrimerApellido("Collaguazo");
		cliente.setCorreo("collaguazodaniel48@gmail.com");
		cliente.setContrasenia("123");
		
		daoCliente.insert(cliente);
		
		Cliente cliente2 = new Cliente();
		cliente2.setPrimerNombre("Claudio");
		cliente2.setPrimerApellido("Collaguazo");
		cliente2.setCorreo("claudiocf26@gmail.com");
		cliente2.setContrasenia("123");
		
		daoCliente.insert(cliente2);
		
		Direcciones direcciones = new Direcciones();
		direcciones.setNombrePais("Ecuador");
		direcciones.setNombreCiudad("Cuenca");
		direcciones.setCodigoPostal("010101");
		direcciones.setDireccionPricipal("Racar");
		direcciones.setDireccionSecundaria("Camino sin nombre");
		

		Productos producto = new Productos();
		producto.setNombre("Lampara");
		producto.setDescripcion("Lampara de cocina de 100W");
		producto.setBreveDescripcion("Esta es una breve descripcion");
		producto.setPrecio(10);
		producto.setCantidad(200);
		producto.setImagen("/asstest/img/lampara.png");
		daoProducto.insert(producto);
		
		Productos producto2 = new Productos();
		producto2.setNombre("Cortina");
		producto2.setDescripcion("Cortina de Cuarto de 2m");
		producto2.setBreveDescripcion("Esta es una breve descripcion");
		producto2.setPrecio(15);
		producto2.setCantidad(45);
		producto2.setImagen("/asstest/img/cortina.png");
		daoProducto.insert(producto2);
		
		Productos producto3 = new Productos();
		producto3.setNombre("Mesa Familiar");
		producto3.setDescripcion("Mesa de comedor fammiliar para 6 personas");
		producto3.setBreveDescripcion("Esta es una breve descripcion");
		producto3.setPrecio(150);
		producto3.setCantidad(30);
		producto3.setImagen("/asstest/img/mesa.png");
		daoProducto.insert(producto3);
		
		
		Categorias categoria = new Categorias();
		categoria.setNombre("Hogar");
		categoria.setImagen("/assets/img/categorias/cocina.jpg");
		categoria.getProductosList().add(producto);
		categoria.getProductosList().add(producto2);
		categoria.getProductosList().add(producto3);
		daoCategoria.insert(categoria);
		
		
		Productos producto4 = new Productos();
		producto4.setNombre("Iphone 15 Pro Max");
		producto4.setDescripcion("Iphone Pro Max de color nuevo y de gran calidad");
		producto4.setBreveDescripcion("Esta es una breve descripcion");
		producto4.setPrecio(150);
		producto4.setCantidad(200);
		producto4.setImagen("/asstest/img/lampara.png");
		daoProducto.insert(producto4);
		
		Productos producto5 = new Productos();
		producto5.setNombre("Cortina");
		producto5.setDescripcion("Cortina de Cuarto de 2m");
		producto5.setBreveDescripcion("Esta es una breve descripcion");
		producto5.setPrecio(15);
		producto5.setCantidad(45);
		producto5.setImagen("/asstest/img/cortina.png");
		daoProducto.insert(producto2);
		
		Productos producto6 = new Productos();
		producto6.setNombre("Mesa Familiar");
		producto6.setDescripcion("Mesa de comedor fammiliar para 6 personas");
		producto6.setBreveDescripcion("Esta es una breve descripcion");
		producto6.setPrecio(150);
		producto6.setCantidad(30);
		producto6.setImagen("/asstest/img/mesa.png");
		daoProducto.insert(producto3);
		
		
		Categorias categoria2 = new Categorias();
		categoria2.setNombre("Celulares");
		categoria2.setImagen("/assets/img/categorias/xbox-logo.png");
		categoria2.getProductosList().add(producto4);
		categoria2.getProductosList().add(producto5);
		categoria2.getProductosList().add(producto6);
		daoCategoria.insert(categoria2);
		
		DetalleFacturas det = new DetalleFacturas();
		det.setCantidad(2);
		det.setPrecioTotal(25);
		det.setPrecioIva(5);
		det.setProductos(producto);
		
		CabeceraFacturas factura = new CabeceraFacturas();
		factura.setCliente(cliente);
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
		
		
		factura = new CabeceraFacturas();
		factura.setCliente(cliente);
		factura.setFecha(new Date());
		factura.setPrecioTotal(100);
		factura.setPrecioIva(20);
		factura.setPrecioSubtotal(80);
		
		
		DetalleFacturas det4 = new DetalleFacturas();
		det2.setCantidad(3);
		det2.setPrecioTotal(30);
		det2.setPrecioIva(6);
		det2.setProductos(producto2);

		factura.addDetalles(det4);
	
		DetalleFacturas det5 = new DetalleFacturas();
		det3.setCantidad(4);
		det3.setPrecioTotal(40);
		det3.setPrecioIva(7);
		det3.setProductos(producto3);
		
		factura.addDetalles(det5);
		
		
		daoFactura.insert(factura);
		
		/*Carrrrito*/
		Carrito car1 = new Carrito();
		car1.setCliente(cliente);
		
		Detalles_Carrito dcar1 = new Detalles_Carrito();
		dcar1.setCantidad(2);
		dcar1.setCodigoProducto(1);
		
		Detalles_Carrito dcar2 = new Detalles_Carrito();
		dcar2.setCantidad(2);
		dcar2.setCodigoProducto(2);
		
		car1.addDetalles(dcar1);
		car1.addDetalles(dcar2);
		
		daoCarrito.insert(car1);
		
		Carrito car2 = new Carrito();
		car2.setCliente(cliente2);
		
		
		Detalles_Carrito dcar3 = new Detalles_Carrito();
		dcar3.setCantidad(2);
		dcar3.setCodigoProducto(3);
		
		Detalles_Carrito dcar4 = new Detalles_Carrito();
		dcar4.setCantidad(2);
		dcar4.setCodigoProducto(4);
		
		car2.addDetalles(dcar3);
		car2.addDetalles(dcar4);
		
		daoCarrito.insert(car2);
		
		
		
		
		/*System.out.println("\n------------- Clientes");
		List<Cliente> list = daoCliente.getAll();
		for (Cliente cli: list) {
			System.out.println(cli.getCodigo() + "\t" + cli.getNombre());
		}*/
		System.out.println("\n--------------------------------------------------- Facturas2");
		List<CabeceraFacturas> list2 = daoFactura.getAll();
		List<Categorias> list3 = daoCategoria.getAll();
		for (Categorias fac: list3) {
			System.out.println("wazaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+fac.toString());
		}
	}
}
