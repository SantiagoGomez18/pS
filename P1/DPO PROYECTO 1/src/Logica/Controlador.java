package Logica;

import Usuarios.usuario;

import java.util.HashMap;
import java.util.Map.Entry;

import Usuarios.Estudiante;
import Usuarios.Profesor;
import java.util.ArrayList;
import Logica.learningPath;

public class Controlador {
	HashMap<String, usuario> usuarios;
	
	
	
	public Controlador(){
		this.usuarios = new HashMap<String,usuario>();
	}

	
	
	
	
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
				u = new Profesor(login, contrasena, rol, new ArrayList<>());
				agregarUsuario(login, u);
			}else if(rol.equals("Estudiante")) {
				u = new Estudiante(login, contrasena, rol, new ArrayList<String>(),
						new ArrayList<String>(), false, new ArrayList<actividad>(), new ArrayList<actividad>(),
						"", new ArrayList<learningPath>(), new ArrayList<learningPath>());
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
	
	
    
}
