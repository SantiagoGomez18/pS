package Logica;

import Usuarios.usuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import Usuarios.Estudiante;
import Usuarios.Profesor;

import java.sql.Date;
import java.util.ArrayList;
import Logica.learningPath;

public class Controlador {
	HashMap<String, usuario> usuarios;
	HashMap<String, actividad> actividades;
	HashMap<String, learningPath> learningPaths;

	
	
	
	public Controlador(){
		this.usuarios = new HashMap<String,usuario>();
		this.actividades = new HashMap<String, actividad>();
		actividades.put("null",null);
		this.learningPaths = new HashMap<String, learningPath>();
		
	}

	
	
	//Usuarios
	
	public HashMap<String, usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(HashMap<String, usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
    public boolean existeUsuario(String id) {
    	if(usuarios.keySet().contains(id)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public void agregarUsuario(String login, usuario usuario) {
    	usuarios.put(login, usuario);
    }
    
	public void crearUsuario(String login, String contrasena, String rol) throws Exception {
		if(existeUsuario(login)) {
			throw new Exception("El usuario con el login dado ya existe");
		}else {
			usuario u;
			
			if (rol.equals("Profesor")) {
				u = new Profesor(login, contrasena, rol, new ArrayList<String>());
				agregarUsuario(login, u);
			}else if(rol.equals("Estudiante")) {
				u = new Estudiante(login, contrasena, rol, new ArrayList<String>(),
						new ArrayList<String>(), false, new ArrayList<String>(), new ArrayList<String>(),
						"", new ArrayList<String>(), new ArrayList<String>());
				agregarUsuario(login, u);
			}
		}
	}
    
    public usuario buscarusuario(String login) {
    	for(String log : this.usuarios.keySet()) {
			if(log.equals(login)) {
				return usuarios.get(log);
			}
		}
		System.out.println("No se encontro el usuario");
		return null;
    }
    
    public void imprimirUsuarios() {
        System.out.println("Usuarios de la aplicacion:");
        for (Entry<String, usuario> entry : usuarios.entrySet()) {
            String clave = entry.getKey();
            usuario usuario = entry.getValue();
            if (usuario.getRol().equals("Estudiante")) {
            	System.out.println("ID: " + clave + ", Información: " + ((Estudiante) usuario).toString());
            }
            else {
                System.out.println("ID: " + clave + ", Informacion: " + usuario.toString());
            }

        }}
    
	public void iniciarSecion(String login, String contrasenia) throws Exception {
    	if(!existeUsuario(login)) {
    		throw new Exception("El login dado no existe");
    	}
    	else{
    		usuario usuarioBuscado = buscarusuario(login);
    		String contra = usuarioBuscado.getContrasena();
    		if(!contrasenia.equals(contra)) {
    			throw new Exception("La contraseña es incorrecta");
    		}
    		else {
    			System.out.println("Inicio de sesion exitoso");
    		}
    	}
    }
	
	//Actividades

	public HashMap<String, actividad> getActividades() {
		return actividades;
	}


	public void setActividades(HashMap<String, actividad> actividades) {
		this.actividades = actividades;
	}
	
	public void agregarActividad(String nombre, actividad actividad) {
		actividades.put(nombre, actividad);
	}
	
	public boolean existeActividad(String nombre) {
		if(actividades.keySet().contains(nombre)) {
			return true;
		}else {
			return false;
		}
	}
	
    public actividad buscarActividad(String nombre) {
    	for(String name : this.actividades.keySet()) {
			if(name.equals(nombre)) {
				return actividades.get(name);
			}
		}
		System.out.println("No se encontro la actividad");
		return null;
    }
	
	public void crearActividad(String nombre, String descripcion, String objetivo, float nivelDificultad, int duracion,
			String resultado, List<String> acttividadesRec, Boolean obligatoriedad, List<String> prerequisitos) throws Exception{
		
		actividad respuesta;
		
		if(existeActividad(nombre)) {
			throw new Exception("La actividad con el nombre dado ya existe");
		}else {
			respuesta = new actividad(nombre, descripcion, objetivo, nivelDificultad, duracion, 
					resultado, acttividadesRec, obligatoriedad, prerequisitos);
			actividades.put(nombre, respuesta);
			
		}
	}

    public void imprimirActividades() {
        System.out.println("Actividades de la aplicacion:");
        for (Entry<String, actividad> entry : actividades.entrySet()) {
            String clave = entry.getKey();
            if(!clave.equals("null")) {
            	actividad act = actividades.get(clave);
            	System.out.println("ID: " + clave + " Informacion " + act.toString());
            }
        }
    }
    
    
	//LearningPaths
	
	public HashMap<String, learningPath> getLearningPaths() {
		return learningPaths;
	}

	public void setLearningPaths(HashMap<String, learningPath> learningPaths) {
		this.learningPaths = learningPaths;
	}
	
	public void agregarLearningPath(String titulo, learningPath learning) {
		learningPaths.put(titulo, learning);
	}
	
	public boolean existeLearning(String titulo) {
		if(learningPaths.keySet().contains(titulo)) {
			return true;
		}else {
			return false;
		}
	}
	
    public learningPath buscarPath(String titulo) {
    	for(String title : this.learningPaths.keySet()) {
			if(title.equals(titulo)) {
				return learningPaths.get(titulo);
			}
		}
		System.out.println("No se encontro la actividad");
		return null;
    }
	
    public void crearLearningPath(List<actividad> activities, String titulo, String descripcion, List<String> objetivos, float nivelDificultad, 
    		int duracion, float rating, Date fechaCreacion, Date fechaModificacion, float version) throws Exception {
    	
    	learningPath answer;
    	for (actividad act : activities) {
    		String nombre = act.getNombre();
    		if(!actividades.keySet().contains(nombre)) {
    			throw new Exception("La actividad" + nombre + "no se encuentra creada en la base de datos");
    		}
    	}
    	
    	if (existeLearning(titulo)) {
    		throw new Exception("Ya existe un LearningPath con el titulo dado, por favor seleccione uno nuevo");
    	}else {
    		answer = new learningPath(activities, titulo, descripcion, objetivos, nivelDificultad, duracion, rating, fechaCreacion, fechaModificacion, version);
    		learningPaths.put(titulo, answer);
    	}
    }

	
    
}
