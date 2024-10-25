package operadores;

import java.util.ArrayList;
import java.util.Scanner;

public class equipo {
Scanner scanner = new Scanner(System.in);
private Integer codigoEquipo;
private String nombreEquipo;
private String tipoEquipo;
private static ArrayList<equipo> ListE = new ArrayList<equipo>();


public equipo(Integer codigoEquipo, String nombreEquipo, String tipoEquipo) {
	super();
	this.codigoEquipo = codigoEquipo;
	this.nombreEquipo = nombreEquipo;
	this.tipoEquipo = tipoEquipo;
}


public Integer getCodigoEquipo() {
	return codigoEquipo;
}


public void setCodigoEquipo(Integer codigoEquipo) {
	this.codigoEquipo = codigoEquipo;
}


public String getNombreEquipo() {
	return nombreEquipo;
}


public void setNombreEquipo(String nombreEquipo) {
	this.nombreEquipo = nombreEquipo;
}


public String getTipoEquipo() {
	return tipoEquipo;
}


public void setTipoEquipo(String tipoEquipo) {
	this.tipoEquipo = tipoEquipo;
}

public void agregarEquipo() {
	System.out.println("Para crear un nuevo equipo por favor ingrese los datos solicitados");
	System.out.println("Inserte el codigo del equipo:");
	codigoEquipo = scanner.nextInt();
	System.out.println("Inserte el nombre del equipo:");
	nombreEquipo = scanner.next();
	System.out.println("Inserte el tipo de equipo:");
	tipoEquipo= scanner.next();
	ListE.add(new equipo(codigoEquipo,nombreEquipo,tipoEquipo));
}

	

public void verRegistroEquipo() {
    for(int i = 0; i < ListE.size(); i++){ 
        equipo equipo =  ListE.get(i);      
        System.out.println("Numero de Equipo: " + equipo.getCodigoEquipo());
        System.out.println("Nombre del Equipo: " + equipo.getNombreEquipo());
        System.out.println("Grupo: " + equipo.getTipoEquipo());      
    }
	}


public void modificarEquipo(int codigoEquipo,String nombreEquipo, String tipoEquipo) throws excepcionOperadores {
	System.out.println("Ingrese el numero de Equipo que desea modificar:");
	Integer codigo = scanner.nextInt();
	for(equipo equipo:ListE) {
		if(codigo==equipo.getCodigoEquipo()) {
			System.out.println("Ingrese el nuevo nombre del equipo:");
			nombreEquipo=scanner.next();
			System.out.println("Ingrese el nuevo tipo de equipo");
			tipoEquipo=scanner.next();
			equipo.setNombreEquipo(nombreEquipo);
			equipo.setTipoEquipo(tipoEquipo);
		}
		else {
			throw new excepcionOperadores("El codigo del equipo ingresado no se encuentra registrado");
		}
		}
	}
	

public void eliminarEquipo(int codigoEquipo,String nombreEquipo, String tipoEquipo) throws excepcionOperadores {
	System.out.println("Ingrese el numero de equipo que desea modificar:");
	Integer codigo = scanner.nextInt();
	for(equipo equipo:ListE) {
		if(codigo==equipo.getCodigoEquipo()) {
			ListE.remove(codigoEquipo);	
		}else {
		throw new excepcionOperadores("El codigo ingresado no se encuentra registrado");
	}
	}
}

boolean existeEquipo(Integer claveE) {
for(equipo equipo:ListE) {
	if(claveE== equipo.getCodigoEquipo());
	return true;
}
return false;
	
}


}
