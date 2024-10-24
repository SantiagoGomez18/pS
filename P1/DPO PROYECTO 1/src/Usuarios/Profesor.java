package Usuarios;

import java.util.ArrayList;
import Logica.actividad;

public class Profesor extends usuario {
	
	private ArrayList<actividad> actividades = new ArrayList<>();

	public Profesor(String login, String contrasena, String rol,  ArrayList<actividad> actividades) {
		super(login, contrasena, rol);
		this.actividades = actividades;
	}

	public ArrayList<actividad> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<actividad> actividades) {
		this.actividades = actividades;
	}
		
}
