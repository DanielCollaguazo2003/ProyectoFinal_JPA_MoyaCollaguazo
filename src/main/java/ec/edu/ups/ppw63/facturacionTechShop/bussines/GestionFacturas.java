package ec.edu.ups.ppw63.facturacionTechShop.bussines;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.dao.FacturaDAO;
import ec.edu.ups.ppw63.facturacionTechShop.dao.ProductosDao;
import ec.edu.ups.ppw63.facturacionTechShop.model.CabeceraFacturas;
import ec.edu.ups.ppw63.facturacionTechShop.model.Carrito;
import ec.edu.ups.ppw63.facturacionTechShop.model.DetalleFacturas;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionFacturas {

	@Inject
	private FacturaDAO daoFactura;
	
	@Inject
	private ProductosDao daoProducto;
	
	public void actualizarFactura(CabeceraFacturas factura) throws Exception {
		CabeceraFacturas cli = daoFactura.read(factura.getCodigo());
		if (cli != null){
			daoFactura.update(factura);
		}else {
			throw new Exception("Factura no existe");
		}
	}
	
	public void guardarFacturas(Carrito carrito) {
		CabeceraFacturas fac = new CabeceraFacturas();
//		fac.setCliente(carrito.getCliente());
		//fac.setFechaEmision(new Date());
		//fac.setNumero("010101010100101");
		//fac.setTotal(1000);
		for(int i = 0; i > carrito.getDetalles().size(); i++) {
			DetalleFacturas det  = new DetalleFacturas();
			det.setCantidad(carrito.getDetalles().get(i).getCantidad());
			//det.setNombre("dsasadas");
			//det.setPrecio(1000);
			//Producto pro = daoProducto.read(carrito.getDetalles().get(i).getCodigoProducto());
			//det.setProducto(pro);
			
			fac.addDetalles(det);
		}
		
		daoFactura.insert(fac);
	}
	
	public void borrarFactura(int codigo) {
		daoFactura.remove(codigo);
	}
	
	public List<CabeceraFacturas> getFacturas(){
		return daoFactura.getAll();
	}
	
	private void generarFactura() {
		
	}
	
}
