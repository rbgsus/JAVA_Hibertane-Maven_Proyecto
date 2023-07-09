package pac;

public class Profesor {
	
	private long id;
	private String nombre;
	private String sexo;
	
	// Constructor vacio
	public Profesor() {
		
	}
	// Constructor con parametros
	public Profesor(long id, String nombre, String sexo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sexo = sexo;
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


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", sexo=" + sexo + "]";
	}
	

}
