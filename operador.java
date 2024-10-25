package operadores;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;

public class operador {
		Scanner scanner = new Scanner(System.in);
		private Integer dniOperador;
		private String nombreyApellido;
		private String grupo;
		private static ArrayList<operador> List = new ArrayList<operador>();



	public operador(Integer dniOperador, String nombreyApellido, String grupo) {
			this.dniOperador = dniOperador;
			this.nombreyApellido = nombreyApellido;
			this.grupo = grupo;
		}


	public Integer getDniOperador() {
		return dniOperador;
	}


	public void setDniOperador(Integer dniOperador) {
		this.dniOperador = dniOperador;
	}


	public String getNombreyApellido() {
		return nombreyApellido;
	}


	public void setNombreyApellido(String nombreyApellido) {
		this.nombreyApellido = nombreyApellido;
	}


	public String getGrupo() {
		return grupo;
	}


	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	public void agregarOperador() {

		System.out.println("Para crear un nuevo operador por favor ingrese los datos solicitados");
		System.out.println("Inserte el numero de DNI del operador:");
		dniOperador = scanner.nextInt();
		System.out.println("Inserte el nombre y apellido del operador:");
		nombreyApellido = scanner.next();
		System.out.println("Inserte el grupo al que pertenece el operador:");
		grupo= scanner.next();
		List.add(new operador(dniOperador,nombreyApellido,grupo));

	}


	public void verRegistroOperador() {
	    for(int i = 0; i < List.size(); i++){ 

	        operador operador =  List.get(i); 
	        
	        System.out.println("Dni: " + operador.getDniOperador());
	        System.out.println("Nombre y Apellido: " + operador.getNombreyApellido());
	        System.out.println("Grupo: " + operador.getGrupo());
	        
	    }
		}
	
	public void modificarOperador(Integer dniOperador,String nombreyApellido, String grupo) throws excepcionOperadores {
		System.out.println("Ingrese el numero de dni que desea modificar:");
		Integer dni = scanner.nextInt();
		for(operador operador:List) {
			if(dni==operador.getDniOperador()) {
				System.out.println("Ingrese el nombre correcto del operador:");
				nombreyApellido=scanner.next();
				System.out.println("Ingrese el nuevo grupo del operador");
				grupo=scanner.next();
				operador.setNombreyApellido(nombreyApellido);
				operador.setGrupo(grupo);
				System.out.println("Se ha modificado de manera correcta los datos del operador");
			}
			else {
				throw new excepcionOperadores("El dni ingresado no se encuentra registrado");
			}
		}
	}
	
	public void eliminarOperador(int dniOperador,String nombreyApellido, String grupo) throws excepcionOperadores {
		System.out.println("Ingrese el numero de dni que desea modificar:");
		Integer dni = scanner.nextInt();
		for(operador operador:List) {
			if(dni==operador.getDniOperador()) {
				List.remove(dniOperador);	
				System.out.println("Se a eleminado al operador del sistema.");
			}
			else {
					throw new excepcionOperadores("El dni ingresado no se encuentra registrado");
			}
		}
	}

	boolean existeOperador(Integer clave) {
		for(operador operador:List) {
			if(clave== operador.getDniOperador());
			return true;
		}
		return false;
			
		}


}

