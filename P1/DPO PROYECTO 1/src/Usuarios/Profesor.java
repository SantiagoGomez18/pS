package Usuarios;

import java.util.ArrayList;
import Logica.actividad;

public class Profesor extends usuario {
	
	private ArrayList<String> actividades = new ArrayList<>();

	public Profesor(String login, String contrasena, String rol,  ArrayList<String> actividades) {
		super(login, contrasena, rol);
		this.actividades = actividades;
	}

	public ArrayList<String> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<String> actividades) {
		this.actividades = actividades;
	}
		
}
