package pac;

public class Modulo {

	private long id;
	private String nombre;
	private String codigo;
	
	// Constructor vacio
	public Modulo() {
		
	}
	// Constructor con parametros
	public Modulo(long id, String nombre, String codigo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
	}
	//Getters y setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Modulo [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}

}
