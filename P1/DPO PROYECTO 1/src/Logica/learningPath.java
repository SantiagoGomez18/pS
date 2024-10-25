package Logica;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class learningPath {
	public List<actividad> actividades = new ArrayList<>();
	public String titulo;
	public String descripcion;
	public List<String> objetivos = new ArrayList<String>();
	public float nivelDificultad;
	public int duracion;
	public float rating;
	public Date fechaCreacion = new Date();
	public Date fechaModificacion = new Date();
	public float version;
	
	
	public learningPath(List<actividad> actividades, String titulo, String descripcion, List<String> objetivos,
			float nivelDificultad, int duracion, float rating, Date fechaCreacion, Date fechaModificacion,
			float version) {
		super();
		this.actividades = actividades;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.objetivos = objetivos;
		this.nivelDificultad = nivelDificultad;
		this.duracion = duracion;
		this.rating = rating;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.version = version;
	}


	public List<actividad> getActividades() {
		return actividades;
	}


	public void setActividades(List<actividad> actividades) {
		this.actividades = actividades;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<String> getObjetivos() {
		return objetivos;
	}


	public void setObjetivos(List<String> objetivos) {
		this.objetivos = objetivos;
	}


	public float getNivelDificultad() {
		return nivelDificultad;
	}


	public void setNivelDificultad(float nivelDificultad) {
		this.nivelDificultad = nivelDificultad;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Date getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	public float getVersion() {
		return version;
	}


	public void setVersion(float version) {
		this.version = version;
	}
	
	
	
	
	
	
}
