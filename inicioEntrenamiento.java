package operadores;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class inicioEntrenamiento {
public int idEntrenamiento;
public int idOperador;
public int idEquipo;
public Date fechaSolicitud;
private static ArrayList<inicioEntrenamiento> Registro = new ArrayList<inicioEntrenamiento>();
Scanner scanner = new Scanner(System.in);
int b;


public inicioEntrenamiento(int idEntrenamiento, int idOperador, int idEquipo, Date fechaSolicitud) {
	this.idEntrenamiento = idEntrenamiento;
	this.idOperador = idOperador;
	this.idEquipo = idEquipo;
	this.fechaSolicitud = fechaSolicitud;
}

public int getIdEntrenamiento() {
	return idEntrenamiento;
}

public void setIdEntrenamiento(int idEntrenamiento) {
	this.idEntrenamiento = idEntrenamiento;
}

public int getIdOperador() {
	return idOperador;
}

public void setIdOperador(int idOperador) {
	this.idOperador = idOperador;
}

public int getIdEquipo() {
	return idEquipo;
}

public void setIdEquipo(int idEquipo) {
	this.idEquipo = idEquipo;
}

public Date getFechaSolicitud() {
	return fechaSolicitud;
}

public void setFechaSolicitud(Date fechaSolicitud) {
	this.fechaSolicitud = fechaSolicitud;
}



public void crearEntrenamiento(operador operador, equipo equipo) throws ParseException, excepcionOperadores{
	b++;
	System.out.println("Ingrese el numero de dni del operador a inicia entrenamiento:");
	Integer dniOpe = scanner.nextInt();
	System.out.println("Ingrese el equipo en el que entrenara el operador:");
	Integer codEquipo=scanner.nextInt();
	int clave=dniOpe;
	int claveE=codEquipo;
    		if(operador.existeOperador(clave) && equipo.existeEquipo(claveE)) {
				idEntrenamiento=b;
				idOperador=dniOpe;
				idEquipo=codEquipo;
				System.out.println("Ingrese la fecha de incio de entrenamiento");
				String fechaComoTexto = scanner.next();
				String formato="dd/mm/yyyy";
				SimpleDateFormat df = new SimpleDateFormat(formato);
				 fechaSolicitud = df.parse(fechaComoTexto);
				Registro.add(new inicioEntrenamiento(idEntrenamiento, idOperador, idEquipo, fechaSolicitud));
				System.out.println("Se a creado inicio de entrenamiento de operador");


    }else {
		throw new excepcionOperadores("El valor ingresado no se encuentra registrado");
    }
    }


public void verRegistroInicioEntrenamiento() {
    for(int i = 0; i < Registro.size(); i++){ 

        inicioEntrenamiento inicioEntrenamiento =  Registro.get(i); 
        
        System.out.println("Codigo de Entrenamiento: " + inicioEntrenamiento.getIdEntrenamiento());
        System.out.println("Id del operador: " + inicioEntrenamiento.getIdOperador());
        System.out.println("Id de equipo: " + inicioEntrenamiento.getIdEquipo());
        System.out.println("Fecha de inicio:" + inicioEntrenamiento.getFechaSolicitud());
        
    }
}

boolean existeEntrenamiento(Integer claveG) {
	for(inicioEntrenamiento inicioEntrenamiento:Registro) {
		if(claveG== inicioEntrenamiento.getIdEntrenamiento());
		return true;
	}
	return false;
		
	}
}