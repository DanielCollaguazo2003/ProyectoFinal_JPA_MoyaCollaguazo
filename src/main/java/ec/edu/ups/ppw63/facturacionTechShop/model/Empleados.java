package ec.edu.ups.ppw63.facturacionTechShop.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Empleados {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "emp_codigo")
	private int codigo;
	
	@Column(name = "emp_nombre", length = 60, nullable = false)
	private String nombre;
	
	@Column(name = "emp_apellido", length = 60, nullable = false)
	private String apellido;
	
	@OneToMany(mappedBy = "empleados", cascade = CascadeType.ALL)
	List<CabeceraFacturas> caberasList;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<CabeceraFacturas> getCaberasList() {
		return caberasList;
	}

	public void setCaberasList(List<CabeceraFacturas> caberasList) {
		this.caberasList = caberasList;
	}

	@Override
	public String toString() {
		return "Empleados [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", caberasList="
				+ caberasList + "]";
	}

	
}
