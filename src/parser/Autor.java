package parser;

import java.util.Iterator;

public class Autor {

	String nombre;
	String apellido;
	String calle;
	int numero_vivienda;
	String ciudad_residente;
	
	public Autor() {
		
	}
	
	public Autor(String nombre, String apellido, String calle,	int numero_vivienda, String ciudad_residente) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.calle = calle;
		this.numero_vivienda = numero_vivienda;
		this.ciudad_residente = ciudad_residente;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero_vivienda() {
		return numero_vivienda;
	}

	public void setNumero_vivienda(int numero_vivienda) {
		this.numero_vivienda = numero_vivienda;
	}

	public String getCiudad_residente() {
		return ciudad_residente;
	}

	public void setCiudad_residente(String ciudad_residente) {
		this.ciudad_residente = ciudad_residente;
	}
	
	@Override
	public String toString() {
		String res = null;
		res = "\nNombre: "+nombre+ "\nApellido: "+apellido+ " \nCalle: " +calle+ " \nNúmero vivienda: "+numero_vivienda+" \nCiudad residente: "+ciudad_residente;
		return res;
	}
	
	
}
