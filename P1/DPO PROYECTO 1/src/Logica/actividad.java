package Logica;
import java.util.ArrayList;
import java.util.List;

public class actividad {
	private String nombre;
	public String descripcion;
	public String objetivo;
	public float nivelDificultad;
	public int duracionCalculada;
	public String resultado;
	public List<String> actividadesRecomendadas = new ArrayList<>();
	public Boolean obligatorio;
	public List<String> prerequisitos = new ArrayList<>();
	
	
	public actividad(String nombre, String descripcion, String objetivo, float nivelDificultad, int duracionCalculada,
			String resultado, List<String> actividadesRecomendadas, Boolean obligatorio, List<String> prerequisitos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.nivelDificultad = nivelDificultad;
		this.duracionCalculada = duracionCalculada;
		this.resultado = resultado;
		this.actividadesRecomendadas = actividadesRecomendadas;
		this.obligatorio = obligatorio;
		this.prerequisitos = prerequisitos;
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
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public float getNivelDificultad() {
		return nivelDificultad;
	}
	public void setNivelDificultad(float nivelDificultad) {
		this.nivelDificultad = nivelDificultad;
	}
	public int getDuracionCalculada() {
		return duracionCalculada;
	}
	public void setDuracionCalculada(int duracionCalculada) {
		this.duracionCalculada = duracionCalculada;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public List<String> getActividadesRecomendadas() {
		return actividadesRecomendadas;
	}
	public void setActividadesRecomendadas(List<String> actividadesRecomendadas) {
		this.actividadesRecomendadas = actividadesRecomendadas;
	}
	public Boolean getObligatorio() {
		return obligatorio;
	}
	public void setObligatorio(Boolean obligatorio) {
		this.obligatorio = obligatorio;
	}
	public List<String> getPrerequisitos() {
		return prerequisitos;
	}
	public void setPrerequisitos(List<String> prerequisitos) {
		this.prerequisitos = prerequisitos;
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Actividad{");
	    sb.append("nombre='").append(nombre).append("', ");
	    sb.append("descripcion='").append(descripcion).append("', ");
	    sb.append("objetivo='").append(objetivo).append("', ");
	    sb.append("nivelDificultad=").append(nivelDificultad).append(", ");
	    sb.append("duracionCalculada=").append(duracionCalculada).append(", ");
	    sb.append("resultado='").append(resultado).append("', ");
	    sb.append("actividadesRecomendadas=").append(actividadesRecomendadas).append(", ");
	    sb.append("obligatorio=").append(obligatorio).append(", ");
	    sb.append("prerequisitos=").append(prerequisitos);
	    sb.append('}');
	    return sb.toString();
	}

	
}
