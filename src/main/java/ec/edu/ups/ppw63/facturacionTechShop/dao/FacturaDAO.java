package ec.edu.ups.ppw63.facturacionTechShop.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.model.CabeceraFacturas;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class FacturaDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void insert(CabeceraFacturas factura) {
		em.persist(factura);
	}
		
	public void update(CabeceraFacturas factura) {
		em.merge(factura);	
	}

	public void remove(int codigo) {
		CabeceraFacturas factura = em.find(CabeceraFacturas.class, codigo);
		em.refresh(factura);
	}
	
	public CabeceraFacturas read(int codigo) {
		CabeceraFacturas factura = em.find(CabeceraFacturas.class, codigo);
		return factura;
	}
	
	public List<CabeceraFacturas> getAll(){
		String jpql = "SELECT f FROM CabeceraFacturas f"; //JPQL es sensible a mayusculas --- para realizar una consulta es similar pero hay q ue tener en cuenta que se tiene una variabe en lugar del alterisco y hay que referenciar a la entidad  no a la tabla
												 // Es decir se debe consultar en la entidad mas no directamente a una tabla de la base de datos 
												 // En lugar del * se coloca una variable, esa variable hace referencia al alias de la entidad
		Query q = em.createQuery(jpql, CabeceraFacturas.class);
		return q.getResultList();
	}

}
