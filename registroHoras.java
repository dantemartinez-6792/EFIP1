package operadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class registroHoras {
	 public Integer idRegistroHoras;
	 public Integer idOpEntrenar;
	 public Date fechaEntrenamiento;
	 public Integer cantidadHoras;
	 public String tipoEntrenamiento;
	 private static ArrayList<registroHoras> RegistroH = new ArrayList<registroHoras>();
	 Scanner scanner = new Scanner(System.in);
	 int g;
	 double sumaHoras;
	 String estadoEntrenamiento;
	 
	public registroHoras(Integer idRegistroHoras, Integer idOpEntrenar, Date fechaEntrenamiento, Integer cantidadHoras,
			String tipoEntrenamiento) {
		super();
		this.idRegistroHoras = idRegistroHoras;
		this.idOpEntrenar = idOpEntrenar;
		this.fechaEntrenamiento = fechaEntrenamiento;
		this.cantidadHoras = cantidadHoras;
		this.tipoEntrenamiento= tipoEntrenamiento;
	}
	

	public Integer getIdRegistroHoras() {
		return idRegistroHoras;
	}

	public void setIdRegistroHoras(Integer idRegistroHoras) {
		this.idRegistroHoras = idRegistroHoras;
	}

	public Integer getIdOpEntrenar() {
		return idOpEntrenar;
	}

	public void setIdOpEntrenar(Integer idOpEntrenar) {
		this.idOpEntrenar = idOpEntrenar;
	}

	public Date getFechaEntrenamiento() {
		return fechaEntrenamiento;
	}

	public void setFechaEntrenamiento(Date fechaEntrenamiento) {
		this.fechaEntrenamiento = fechaEntrenamiento;
	}

	public double getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(Integer cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public String getTipoEntrenamiento() {
		return tipoEntrenamiento;
	}

	public void setTipoEntrenamiento(String tipoEntrenamiento) {
		this.tipoEntrenamiento = tipoEntrenamiento;
	}

	public void registrarHoras(inicioEntrenamiento inicioEntrenamiento) throws ParseException {
		g++;
		System.out.println("Ingrese el id de entrenamiento de operador:");
		Integer idOpe = scanner.nextInt();
		int claveG=idOpe;
	    		if(inicioEntrenamiento.existeEntrenamiento(claveG)) {
					idRegistroHoras=g;
					idOpEntrenar=idOpe;
					System.out.println("Ingrese la fecha de incio de entrenamiento");
					String fechaComoTexto = scanner.next();
					String formato="dd/mm/yyyy";
					SimpleDateFormat df = new SimpleDateFormat(formato);
					fechaEntrenamiento = df.parse(fechaComoTexto);
					System.out.println("Ingrese la cantidad de horas:");
					cantidadHoras= scanner.nextInt();
					System.out.println("Ingrese el tipo de entrenamiento:");
					tipoEntrenamiento=scanner.next();
					RegistroH.add(new registroHoras(idRegistroHoras, idOpEntrenar, fechaEntrenamiento, cantidadHoras, tipoEntrenamiento));
					System.out.println("Se a creado inicio de entrenamiento de operador");


	    }
	    }


	public void modificarHoras(Integer idRegistroHoras, Integer idOpEntrenar, Date fechaEntrenamiento, Integer cantidadHoras,
			String tipoEntrenamiento) throws ParseException, excepcionOperadores {
		System.out.println("Ingrese el numero del registro de horas a modificar:");
		Integer idReg = scanner.nextInt();
		for(registroHoras registroHoras:RegistroH) {
			if(idReg==registroHoras.getIdRegistroHoras()) {
				System.out.println("Ingrese la fecha de entrenamiento:");
				String fechaComoTexto = scanner.next();
				String formato="dd/mm/yyyy";
				SimpleDateFormat df = new SimpleDateFormat(formato);
				 fechaEntrenamiento = df.parse(fechaComoTexto);
				System.out.println("Ingrese cantidad de horas");
				cantidadHoras=scanner.nextInt();
				System.out.println("Ingrese tipo de entrenamiento:");
				tipoEntrenamiento=scanner.next();
				registroHoras.setFechaEntrenamiento(fechaEntrenamiento);
				registroHoras.setCantidadHoras(cantidadHoras);
				registroHoras.setTipoEntrenamiento(tipoEntrenamiento);
				System.out.println("Se ha modificado de manera correcta los datos del registro de horas.");
			}else {
				throw new excepcionOperadores("El dni ingresado no se encuentra registrado");
			
			}
		}
	}
	
	public void eliminarRegistroHoras(Integer idRegistroHoras, Integer idOpEntrenar, Date fechaEntrenamiento, Integer cantidadHoras,
			String tipoEntrenamiento) throws excepcionOperadores {
		System.out.println("Ingrese el id del registro de horas a eliminar:");
		Integer idRegis = scanner.nextInt();
		for(registroHoras registroHoras:RegistroH) {
			if(idRegis==registroHoras.getIdRegistroHoras()) {
				RegistroH.remove(idRegistroHoras);	
				System.out.println("Se a eleminado correctamente el registro de horas.");
			}else {
				throw new excepcionOperadores("El ID ingresado no es correcto");
			}
			}
		}
	
	public void verRegistroHoras() {
	    for(int i = 0; i < RegistroH.size(); i++){ 

	        registroHoras registroHoras =  RegistroH.get(i); 
	        
	        System.out.println("Id de registro: " + registroHoras.getIdRegistroHoras());
	        System.out.println("Id operador a Entrenar: " + registroHoras.getIdOpEntrenar());
	        System.out.println("Fecha de entrenamiento: " + registroHoras.getFechaEntrenamiento());
	        System.out.println("Cantidad de horas:"+ registroHoras.getCantidadHoras());
	        System.out.println("Tipo entrenamiento:" + registroHoras.getTipoEntrenamiento());
	        
	    }
		}
	
	public String estadoEntrenamiento() {
		for (int i = 0; i < RegistroH.size(); i++) {
			if(sumaHoras< 50) {
				estadoEntrenamiento= "Capacitacion en Sala";
			}
			if(sumaHoras> 50 && sumaHoras< 150) {
			   estadoEntrenamiento= "Capacitacion en campo con operador con experiencia";	
			}
			if(sumaHoras>150){
			   estadoEntrenamiento= "Capacitacion practica solo";
			}
		}
		return estadoEntrenamiento;
		        
		    
		}


	public void verAvanceEntrenamientos() throws excepcionOperadores {
		System.out.println("Ingrese el numero de Id del operador:");
		Integer idOpera = scanner.nextInt();
		sumaHoras=0;
		for(registroHoras registroHoras:RegistroH) {
			if(idOpera== registroHoras.getIdOpEntrenar()) { 
	        System.out.println("Codigo de Entrenamiento: " + idOpera);
	        System.out.println("Total Horas: " + (sumaHoras+=registroHoras.getCantidadHoras()));
	        System.out.println("Estado Entrenamientos: " + estadoEntrenamiento());

	    }else {
			throw new excepcionOperadores("El ID ingresado no es correcto.");
		}
	    }
		}
	


	boolean existeRegistroHoras(Integer claveH) {
		for(registroHoras registroHoras: RegistroH) {
			if(claveH== registroHoras.getIdOpEntrenar());
			return true;
		}
		return false;
	}
}
