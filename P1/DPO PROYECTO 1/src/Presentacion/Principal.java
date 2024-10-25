package Presentacion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Usuarios.usuario;
import Logica.Controlador;

public class Principal {
	private Controlador controlador;
	private ArrayList<String> actividades = new ArrayList<String>();

	
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
                        	ArrayList<String> actividadesRecomendadas = new ArrayList<String>();
                        	ArrayList<String> actividadesPrereq = new ArrayList<String>();
	                        System.out.println("Digite una opcion");
	                        System.out.println("0. Volver al menu principal");
	                        System.out.println("1. Crear una actividad");
	                        System.out.println("2. Crear un learningPath");
	                        System.out.println("3. Imprimir actividades");
	                        op2 = sc.nextInt();  
                        	String at = "";
	                        if(op2 ==1) {
	                        	System.out.println("Ingrese el nombre de la actividad, este nomnbre serbira como identificador asi que asegurese de que sea unico");
	                        	String nombre  = sc.next();
	                        	System.out.println("Ingrese la descripcion de la actividad");
	                        	String descripcion = sc.next();
	                        	System.out.println("Ingrese el objetivo de la actividad");
	                        	String objetivo = sc.next();
	                        	System.out.println("Ingrese el nivel de dificultad de la actividad");
	                        	float nivelDif = sc.nextFloat();
	                        	System.out.println("Ingrese la duracion de la actividad en minutos");
	                        	int duracion = sc.nextInt();
	                        	sc.nextLine();
	                        	System.out.println("Ingrese la lista de actividades recomendadas para tomar antes de esta, use el formato ['titulo1','titulo2'...]:, use comillas dobles. "
	                        			+ "Si no hay actividades prebias ingrese la palabra null");
	                        	at = sc.nextLine();
	                        	at = at.substring(1, at.length()-1);
	                        	String [] elementos = at.split(",\\s*");
	                            for (String elemento : elementos) {
	                                // Eliminar las comillas del inicio y del final de cada elemento
	                                elemento = elemento.trim().replaceAll("^\"|\"$", "");
	                                actividadesRecomendadas.add(elemento);
	                            }
	                            
	                            System.out.println("Ingrese si la actividad es obligatoria o no, use el formato booleano, true y false");
	                            Boolean obligatoriedad = sc.nextBoolean();
	                            sc.nextLine();
	                            
	                            System.out.println("Ingrese el nombre de las actividades que son prerequisito de la que se esta creando"
	                            		+ " use el formato ['titulo1','titulo2'...]:, use comillas dobles, si no tiene actividades como prerequisito use null");
	                            at = sc.nextLine();
	                            at = at.substring(1, at.length() - 1);
	                            String[] elementos2 = at.split(",\\s*");
	                            for (String elemento : elementos2) {
	                                // Eliminar las comillas del inicio y del final de cada elemento
	                                elemento = elemento.trim().replaceAll("^\"|\"$", "");
	                                actividadesPrereq.add(elemento);
	                            }
	                            crearActividad(nombre, descripcion, objetivo, nivelDif, duracion, objetivo, actividadesRecomendadas, obligatoriedad, actividadesPrereq);
	                            
	                        	
	                        }else if(op2 == 2) {
	                            System.out.println("Ingrese la lista de las actividades en el formato ['titulo1','titulo2'...]:, use comillas dobles.");
	                            at = sc.nextLine();
	                            at = at.substring(1, at.length() - 1);
	                            String[] elementos = at.split(",\\s*");
	                            for (String elemento : elementos) {
	                                // Eliminar las comillas del inicio y del final de cada elemento
	                                elemento = elemento.trim().replaceAll("^\"|\"$", "");
	                                actividades.add(elemento);
	                            }
	                        }else if(op2 == 3) {
	                        	imprimirActividades();
	                        }
	                    } while (op2 != 0);  
	                } else {
	                    do {
	                        System.out.println("Digite una opcion");
	                        System.out.println("0. Volver al menu principal");
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
    
    private void crearActividad(String nombre, String descripcion, String objetivo, float nivelDificultad, int duracion,
			String resultado, List<String> acttividadesRec, Boolean obligatoriedad, List<String> prerequisitos) throws Exception {
    	
    	controlador.crearActividad(nombre, descripcion, objetivo, nivelDificultad, duracion, resultado, 
    			acttividadesRec, obligatoriedad, prerequisitos);
    }
    
    private void imprimirActividades() {
    	controlador.imprimirActividades();
    }
	
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.menu(); // Llamada al método del menú
        
    }
}
