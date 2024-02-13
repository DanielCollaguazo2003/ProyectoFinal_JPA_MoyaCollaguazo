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
public class Productos {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "pro_codigo")
	private int codigo;
	
	@Column(name = "pro_nombre", length = 60, nullable = false)
	private String nombre;
	
	@Column(name = "pro_descripcion", length = 120, nullable = false)
	private String descripcion;
	
	@Column(name = "pro_breve_descripcion", length = 60, nullable = false)
	private String breveDescripcion;
	
	@Column(name = "pro_precio", nullable = false)
	private float precio;
	
	@Column(name = "pro_cantidad", nullable = false)
	private int cantidad;
	
	@Column(name = "pro_img", length = 500, nullable = true)
	private String imagen;
	
	
//	@ManyToOne
//	@JoinColumn(name = "cat_codigo")
//	Categorias categorias;
	
	//@OneToMany(mappedBy = "productos", cascade = CascadeType.ALL)
	//List<DetalleFacturas> detallesList;
	
	public int getCodigo() {
		return codigo;
	}
	

//	public Categorias getCategorias() {
//		return categorias;
//	}
//
//
//	public void setCategorias(Categorias categorias) {
//		this.categorias = categorias;
//	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	

	public String getBreveDescripcion() {
		return breveDescripcion;
	}


	public void setBreveDescripcion(String breveDescripcion) {
		this.breveDescripcion = breveDescripcion;
	}



	@Override
	public String toString() {
		return "Productos [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + ", cantidad=" + cantidad + ", imagen=" + imagen + "]";
	}

	
	
//	@Override
//	public String toString() {
//		return "Productos [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
//				+ precio + ", cantidad=" + cantidad + ", imagen=" + imagen + ", categorias=" + categorias
//				+ "]";
//	}


	
	
}
