package ec.edu.ups.ppw63.facturacionTechShop.dao;

import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.model.Empleados;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class EmpleadoDao {

	@PersistenceContext
	private EntityManager em;

	public void insert(Empleados empleados) {
		em.persist(empleados);
	}
		
	public void update(Empleados empleados) {
		em.merge(empleados);	
	}

	public void remove(int codigo) {
		Empleados empleados = em.find(Empleados.class, codigo);
		em.remove(empleados);
	}
	
	public Empleados read(int codigo) {
		Empleados empleados = em.find(Empleados.class, codigo);
		return empleados;
	}
	
	public List<Empleados> getAll(){
		String jpql = "SELECT c FROM Empleados c"; //JPQL es sensible a mayusculas --- para realizar una consulta es similar pero hay q ue tener en cuenta que se tiene una variabe en lugar del alterisco y hay que referenciar a la entidad  no a la tabla
												 // Es decir se debe consultar en la entidad mas no directamente a una tabla de la base de datos 
												 // En lugar del * se coloca una variable, esa variable hace referencia al alias de la entidad
		Query q = em.createQuery(jpql, Empleados.class);
		return q.getResultList();
	}

}
