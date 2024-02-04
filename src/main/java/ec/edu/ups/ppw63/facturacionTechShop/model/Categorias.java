package ec.edu.ups.ppw63.facturacionTechShop.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Categorias {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "cat_codigo")
	private int codigo;
	
	@Column(name = "cat_nombre", length = 60, nullable = false)
	private String nombre;
	
	@Column(name = "cat_imagen", length = 200, nullable = false)
	private String imagen;

	@OneToMany(mappedBy = "categorias", cascade = CascadeType.ALL)
	List<Productos> productosList;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public void addProductos (Productos productos) {
		if (productosList == null)
			productosList = new ArrayList<Productos>();
			
		productosList.add(productos);
	}

	@Override
	public String toString() {
		return "Categorias [codigo=" + codigo + ", nombre=" + nombre + ", imagen=" + imagen + ", productosList="
				+ productosList + "]";
	}

	
	
	
}
