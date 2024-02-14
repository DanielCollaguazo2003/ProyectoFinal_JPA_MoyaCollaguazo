package ec.edu.ups.ppw63.facturacionTechShop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import ec.edu.ups.ppw63.facturacionTechShop.model.Productos;
import jakarta.ejb.Stateless;
import jakarta.persistence.Column;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ProductosDao {

	@PersistenceContext
	private EntityManager em;

	public void insert(Productos productos) {
		em.persist(productos);
	}

	public void update(Productos productos) {
		em.merge(productos);
	}

	public void remove(int codigo) {
		Productos productos = em.find(Productos.class, codigo);
		em.remove(productos);
	}

	public Productos read(int codigo) {
		Productos productos = em.find(Productos.class, codigo);
		return productos;
	}

	public List<Productos> getAll() {
		String jpql = "SELECT c FROM Productos c"; // JPQL es sensible a mayusculas --- para realizar una consulta es
													// similar pero hay q ue tener en cuenta que se tiene una variabe en
													// lugar del alterisco y hay que referenciar a la entidad no a la
													// tabla
													// Es decir se debe consultar en la entidad mas no directamente a
													// una tabla de la base de datos
													// En lugar del * se coloca una variable, esa variable hace
													// referencia al alias de la entidad
		Query q = em.createQuery(jpql, Productos.class);
		return q.getResultList();
	}

	public Productos getProductoPorId(int codigo) {
		String jpql = "SELECT c FROM Productos c WHERE c.codigo = :codigo";
		Query q = em.createQuery(jpql, Productos.class);
		q.setParameter("codigo", codigo);
		List<Productos> productos = q.getResultList();
		if (productos.size() > 0)
			return productos.get(0);
		return null;
	}


	public List<Productos> getOfertas(){
		String jpql = "SELECT c FROM Productos c WHERE c.oferta > 0 "
				+ "ORDER BY c.oferta DESC";
		Query q = em.createQuery(jpql, Productos.class);
		List<Productos> productos = q.getResultList();
		if (productos.size() > 0)
			return productos;
		return null;
	}



//	public List<CantidadFacturasCliente> getTotalFacturas() {
//		String sql = "SELECT codigo_cliente, nombre, count(f.codigo) " + "FROM factura f , cliente c "
//				+ "WHERE f.codigo_cliente = c.codigo GROUP BY codigo_cliente, nombre ";
//
//		Query q = em.createNativeQuery(sql);
//
//		List<Object[]> list = q.getResultList();
//		List<CantidadFacturasCliente> datos = new ArrayList<CantidadFacturasCliente>();
//		for (Object[] result : list) {
//			datos.add(new CantidadFacturasCliente(((Number) result[0]).intValue(), result[1].toString(),
//					((Number) result[2]).intValue()));
//		}
//		return datos;
//	}
}
