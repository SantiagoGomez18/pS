package Usuarios;

public class usuario {
	public String login;
	private String contrasena;
	private String rol;

	
	public usuario(String login, String contrasena, String rol) {
		super();
		this.login = login;
		this.contrasena = contrasena;
		this.rol = rol;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
		
	}
	
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
}
