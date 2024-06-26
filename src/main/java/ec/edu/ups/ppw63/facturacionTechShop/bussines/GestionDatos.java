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
		
///////////////////////////////////////////////////////////////////////////////////////////////
		Productos producto = new Productos();
		producto.setNombre("Lampara");
		producto.setDescripcion("Lampara de cocina de 100W");
		producto.setBreveDescripcion("Lampara de cocina de 100W con tamaño 24cmX25cm");
		producto.setPrecio(40);
		producto.setCantidad(200);
		producto.setImagen("/assets/img/productos/lampara.jpg");
		producto.setOferta(60);
		daoProducto.insert(producto);
		
		Productos producto2 = new Productos();
		producto2.setNombre("Cortina");
		producto2.setDescripcion("Cortina de Cuarto de 2m");
		producto2.setBreveDescripcion("Cortina de Cuarto de 2m");
		producto2.setPrecio(25);
		producto2.setCantidad(45);
		producto2.setImagen("/assets/img/productos/cortina.jpg");
		daoProducto.insert(producto2);
		
		Productos producto3 = new Productos();
		producto3.setNombre("Mesa Familiar");
		producto3.setDescripcion("Mesa de comedor fammiliar para 6 personas");
		producto3.setBreveDescripcion("Mesa de comedor fammiliar para 6 personas");
		producto3.setPrecio(150);
		producto3.setCantidad(30);
		producto3.setImagen("/assets/img/productos/mesa.jpg");
		producto3.setOferta(25);
		daoProducto.insert(producto3);
		
		
		Categorias categoria = new Categorias();
		categoria.setNombre("Hogar");
		categoria.setImagen("/assets/img/categorias/home.png");
		categoria.getProductosList().add(producto);
		categoria.getProductosList().add(producto2);
		categoria.getProductosList().add(producto3);
		daoCategoria.insert(categoria);
		
///////////////////////////////////////////////////////////////////////////////////////////////
		
		Productos producto4 = new Productos();
		producto4.setNombre("Iphone 15 Pro Max");
		producto4.setDescripcion("Iphone Pro Max de color nuevo y de gran calidad");
		producto4.setBreveDescripcion("Iphone Pro Max de color nuevo y de gran calidad");
		producto4.setPrecio(999);
		producto4.setCantidad(200);
		producto4.setImagen("/assets/img/productos/iphone.png");
		producto4.setOferta(25);
		daoProducto.insert(producto4);
		
		Productos producto5 = new Productos();
		producto5.setNombre("Samsung Galaxy S23+");
		producto5.setDescripcion("Celular increiblemente barato Samsung");
		producto5.setBreveDescripcion("Celular increiblemente barato Samsung");
		producto5.setPrecio(1199);
		producto5.setCantidad(45);
		producto5.setImagen("/assets/img/productos/samsung.png");
		producto5.setOferta(35);
		daoProducto.insert(producto2);
		
		Productos producto6 = new Productos();
		producto6.setNombre("Xiaomi Ultra");
		producto6.setDescripcion("Celular Chino Xiaomi Ultra");
		producto6.setBreveDescripcion("Celular Chino Xiaomi Ultra");
		producto6.setPrecio(845);
		producto6.setCantidad(30);
		producto6.setImagen("/assets/img/productos/xiaomi.png");
		daoProducto.insert(producto3);
		
		
		Categorias categoria2 = new Categorias();
		categoria2.setNombre("Celulares");
		categoria2.setImagen("/assets/img/categorias/celulares.png");
		categoria2.getProductosList().add(producto4);
		categoria2.getProductosList().add(producto5);
		categoria2.getProductosList().add(producto6);
		daoCategoria.insert(categoria2);
		
///////////////////////////////////////////////////////////////////////////////////////////////

		
		producto = new Productos();
		producto.setNombre("Maletin");
		producto.setDescripcion("Maletin de oficina");
		producto.setBreveDescripcion("Maletin de oficina color marron oscuro de tamaño 60x30");
		producto.setPrecio(59);
		producto.setCantidad(200);
		producto.setImagen("/assets/img/productos/maletin.png");
		daoProducto.insert(producto);
		
		producto2 = new Productos();
		producto2.setNombre("Cuadro de Oficina");
		producto2.setDescripcion("Cuadro de oficina para decoracion");
		producto2.setBreveDescripcion("Cuadro de oficina para decoracion");
		producto2.setPrecio(45);
		producto2.setCantidad(45);
		producto2.setImagen("/assets/img/productos/cuadro.jpg");
		daoProducto.insert(producto2);
		
		producto3 = new Productos();
		producto3.setNombre("Mesa de Oficina");
		producto3.setDescripcion("Mesa de reuniones de oficina");
		producto3.setBreveDescripcion("Mesa de reuniones de oficina");
		producto3.setPrecio(320);
		producto3.setCantidad(30);
		producto3.setImagen("/assets/img/productos/oficina.jpg");
		daoProducto.insert(producto3);
		
		
		categoria = new Categorias();
		categoria.setNombre("Oficina");
		categoria.setImagen("/assets/img/categorias/maletin.png");
		categoria.getProductosList().add(producto);
		categoria.getProductosList().add(producto2);
		categoria.getProductosList().add(producto3);
		daoCategoria.insert(categoria);
		
///////////////////////////////////////////////////////////////////////////////////////////////

		
		producto = new Productos();
		producto.setNombre("Juego de PS4 Uncharted");
		producto.setDescripcion("Juego de Ps4 original nuevo");
		producto.setBreveDescripcion("Juego de Ps4 original nuevo");
		producto.setPrecio(30);
		producto.setCantidad(200);
		producto.setImagen("/assets/img/productos/ps4.png");
		producto.setOferta(50);
		daoProducto.insert(producto);
		
		producto2 = new Productos();
		producto2.setNombre("Control de PS4");
		producto2.setDescripcion("Control de PS4 nuevo");
		producto2.setBreveDescripcion("Control de PS4 nuevo");
		producto2.setPrecio(55);
		producto2.setCantidad(45);
		producto2.setImagen("/assets/img/productos/control.png");
		producto2.setOferta(35);
		daoProducto.insert(producto2);
		
		categoria = new Categorias();
		categoria.setNombre("Video-Juegos");
		categoria.setImagen("/assets/img/categorias/xbox-logo.png");
		categoria.getProductosList().add(producto);
		categoria.getProductosList().add(producto2);
		daoCategoria.insert(categoria);
		
///////////////////////////////////////////////////////////////////////////////////////////////

		
		producto = new Productos();
		producto.setNombre("Parlante JBL");
		producto.setDescripcion("Parlante JBL nuevo");
		producto.setBreveDescripcion("Parlante JBL nuevo");
		producto.setPrecio(65);
		producto.setCantidad(200);
		producto.setImagen("/assets/img/productos/parlante.png");
		producto.setOferta(15);
		daoProducto.insert(producto);
		
		producto2 = new Productos();
		producto2.setNombre("Audifonos SONY");
		producto2.setDescripcion("Audifonos Sony nuevos");
		producto2.setBreveDescripcion("Audifonos Sony nuevos");
		producto2.setPrecio(25);
		producto2.setCantidad(45);
		producto2.setImagen("/assets/img/productos/audifonos.png");
		daoProducto.insert(producto2);
		
		categoria = new Categorias();
		categoria.setNombre("Audio");
		categoria.setImagen("/assets/img/categorias/audio.png");
		categoria.getProductosList().add(producto);
		categoria.getProductosList().add(producto2);
		daoCategoria.insert(categoria);
		
///////////////////////////////////////////////////////////////////////////////////////////////

		
		producto = new Productos();
		producto.setNombre("Arduino UNO");
		producto.setDescripcion("Componente arduino uno para electronica");
		producto.setBreveDescripcion("Componente arduino uno para electronica");
		producto.setPrecio(25);
		producto.setCantidad(200);
		producto.setImagen("/assets/img/productos/arduino.png");
		producto.setOferta(5);
		daoProducto.insert(producto);
		
		producto2 = new Productos();
		producto2.setNombre("RaspBerry Pi");
		producto2.setDescripcion("Componete electronico multiusos");
		producto2.setBreveDescripcion("Componete electronico multiusos");
		producto2.setPrecio(80);
		producto2.setCantidad(45);
		producto2.setImagen("/assets/img/productos/rasp.png");
		daoProducto.insert(producto2);
		
		categoria = new Categorias();
		categoria.setNombre("Electronica");
		categoria.setImagen("/assets/img/categorias/electronica.png");
		categoria.getProductosList().add(producto);
		categoria.getProductosList().add(producto2);
		daoCategoria.insert(categoria);
		
///////////////////////////////////////////////////////////////////////////////////////////////

		
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
//		List<Productos> list4 = daoProducto.getOfertas();
		
		daoProducto.getOfertas();
		for (Categorias fac: list3) {
			System.out.println("wazaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+fac.toString());
		}
//		for(Productos x: list4 ) {
//			System.out.println("sfajjsdkfjaskdjfsadjflksjdflkasjdlfkjsldf" + x.toString());
//		}
	}
}
