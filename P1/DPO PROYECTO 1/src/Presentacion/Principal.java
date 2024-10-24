package Presentacion;
import java.util.Scanner;
import Usuarios.usuario;
import Logica.Controlador;

public class Principal {
	private Controlador controlador;
	
	public Principal() {
		this.controlador = new Controlador();
		menu();
	}
	
	private void menu() {
	    int op = 0;
	    Scanner sc = new Scanner(System.in);
	    do {
	        System.out.println("Digite una opcion");
	        System.out.println("0. Salir");
	        System.out.println("1. Crear un usuario");
	        System.out.println("2. Ingresar");
	        System.out.println("3. Imprimir lista de usuarios");

	        op = sc.nextInt();
	        try {
	            if (op == 1) {
	                crearUsuario(sc);
	            } else if (op == 2) {
	                int op2 = 0;
	                System.out.println("Ingrese su login");
	                String login = sc.next();
	                System.out.println("Ingrese su contraseña");
	                String contra = sc.next();
	                inicioSecion(login, contra);
	                usuario user = controlador.buscarusuario(login);
	                String rol = user.getRol();
	                
	                if (rol.equals("Profesor")) {  
	                    do {
	                        System.out.println("Digite una opcion");
	                        System.out.println("0. volver al menu principal");
	                        System.out.println("1. crear una actividad");
	                        op2 = sc.nextInt();  
	                    } while (op2 != 0);  
	                } else {
	                    do {
	                        System.out.println("Digite una opcion");
	                        System.out.println("0. volver al menu principal");
	                        op2 = sc.nextInt();  
	                    } while (op2 != 0); 
	                }
	            } else if (op == 3) {
	                imprimirUsuarios();
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    } while (op != 0);
	    sc.close();
	} 
	
	public void crearUsuario(Scanner sc) throws Exception {
		sc.nextLine();
		System.out.println("Ingrese su login");
		String login = sc.next();
		System.out.println("Ingrese su contraseña");
		String contrasena = sc.next();
		
		int scn = 0;
		System.out.println("Por favor seleccione que tipo de usuario desea crear");
		System.out.println("1. Profesor");
		System.out.println("2. Estudiante");
		
		String rol;
		scn = sc.nextInt();
		if (scn == 1) {
			rol = "Profesor";
		}else if(scn == 2) {
			rol = "Estudiante";
		}else {
			throw new Exception("Seleccione una de las opciones mostradas en pantalla");
		}
		
		this.controlador.crearUsuario(login, contrasena, rol);
	}
	
    private void imprimirUsuarios() {
        controlador.imprimirUsuarios();
    }
    
    private void inicioSecion(String login, String contrasenia) throws Exception {
    	controlador.iniciarSecion(login, contrasenia);
    }
	
	
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.menu(); // Llamada al método del menú
        
    }
}
