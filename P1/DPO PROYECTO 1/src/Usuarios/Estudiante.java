package Usuarios;

import java.util.ArrayList;
import Logica.actividad;
import Logica.learningPath;

public class Estudiante extends usuario{

	private ArrayList<String> logros = new ArrayList<>();
	private ArrayList<String> avances = new ArrayList<String>();
	private boolean actividadEnProgreso;
	private ArrayList<actividad> actividadesNoExitosas = new ArrayList<>();
	private ArrayList<actividad> actividadesTerminadas = new ArrayList<actividad>();
	private boolean learningPathInProgress;
	private String learningPath;
	private ArrayList<learningPath> pathsTerminados = new ArrayList<learningPath>();
	private ArrayList<learningPath> pathsNoExitosos = new ArrayList<learningPath>();
	
	public Estudiante(String login, String contrasena, String rol, ArrayList<String> logros, ArrayList<String> avances, boolean actividadEnProgreso, ArrayList<actividad> actividadesExitosas,
			ArrayList<actividad> actividadesNoExitosas, String learningPath, ArrayList<learningPath> pathsTerminados, ArrayList<learningPath> pathsNoExitosos) {
		super(login, contrasena, rol);
		this.logros = logros;
		this.avances = avances;
		this.actividadEnProgreso = actividadEnProgreso;
		this.actividadesTerminadas = actividadesExitosas;
		this.actividadesNoExitosas = actividadesNoExitosas;
		this.learningPath = learningPath;
		this.pathsTerminados = pathsTerminados;
		this.pathsNoExitosos = pathsNoExitosos;
	}

	public ArrayList<String> getLogros() {
		return logros;
	}

	public void setLogros(ArrayList<String> logros) {
		this.logros = logros;
	}

	public ArrayList<String> getAvances() {
		return avances;
	}

	public void setAvances(ArrayList<String> avances) {
		this.avances = avances;
	}

	public boolean isActividadEnProgreso() {
		return actividadEnProgreso;
	}

	public void setActividadEnProgreso(boolean actividadEnProgreso) {
		this.actividadEnProgreso = actividadEnProgreso;
	}

	public ArrayList<actividad> getActividadesNoExitosas() {
		return actividadesNoExitosas;
	}

	public void setActividadesNoExitosas(ArrayList<actividad> actividadesNoExitosas) {
		this.actividadesNoExitosas = actividadesNoExitosas;
	}

	public ArrayList<actividad> getActividadesTerminadas() {
		return actividadesTerminadas;
	}

	public void setActividadesTerminadas(ArrayList<actividad> actividadesTerminadas) {
		this.actividadesTerminadas = actividadesTerminadas;
	}

	public boolean isLearningPathInProgress() {
		return learningPathInProgress;
	}

	public void setLearningPathInProgress(boolean learningPathInProgress) {
		this.learningPathInProgress = learningPathInProgress;
	}

	public String getLearningPath() {
		return learningPath;
	}

	public void setLearningPath(String learningPath) {
		this.learningPath = learningPath;
	}

	public ArrayList<learningPath> getPathsTerminados() {
		return pathsTerminados;
	}

	public void setPathsTerminados(ArrayList<learningPath> pathsTerminados) {
		this.pathsTerminados = pathsTerminados;
	}

	public ArrayList<learningPath> getPathsNoExitosos() {
		return pathsNoExitosos;
	}

	public void setPathsNoExitosos(ArrayList<learningPath> pathsNoExitosos) {
		this.pathsNoExitosos = pathsNoExitosos;
	}
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante{");
        sb.append("login='").append(super.getLogin()).append("', ");
        sb.append("rol='").append(super.getRol()).append("', ");
        sb.append("logros=").append(logros).append(", ");
        sb.append("avances=").append(avances).append(", ");
        sb.append("actividadEnProgreso=").append(actividadEnProgreso).append(", ");
        sb.append("actividadesTerminadas=").append(actividadesTerminadas).append(", ");
        sb.append("actividadesNoExitosas=").append(actividadesNoExitosas).append(", ");
        sb.append("learningPathEnProgreso=").append(learningPathInProgress).append(", ");
        sb.append("learningPath='").append(learningPath).append("', ");
        sb.append("pathsTerminados=").append(pathsTerminados).append(", ");
        sb.append("pathsNoExitosos=").append(pathsNoExitosos);
        sb.append('}');
        return sb.toString();
    }
    
}
