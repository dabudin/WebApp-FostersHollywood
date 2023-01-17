package model;

public class Producto {
	
	private int id;
	private String titulo;
	private String body;
	private int categoriaid;
	private String imagen;
	private String fondo;
	private String sumario;
	
	public Producto() {
		super();
	}

	public Producto(int id, String titulo, String body, int categoriaid, String imagen, String fondo, String sumario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.body = body;
		this.categoriaid = categoriaid;
		this.imagen = imagen;
		this.fondo = fondo;
		this.sumario = sumario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getCategoriaid() {
		return categoriaid;
	}

	public void setCategoriaid(int categoriaid) {
		this.categoriaid = categoriaid;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getFondo() {
		return fondo;
	}

	public void setFondo(String fondo) {
		this.fondo = fondo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", titulo=" + titulo + ", body=" + body + ", categoriaid=" + categoriaid
				+ ", imagen=" + imagen + ", fondo=" + fondo + ", sumario=" + sumario + "]";
	}

}
