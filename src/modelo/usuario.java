package modelo;

import processing.core.PApplet;

public class usuario implements Comparable <usuario> {
		
	int dia, mes, anio, hora, minuto;
	String nombre;
	PApplet app;
	logica logic;
	
	public usuario(String nombre, PApplet app) {
		
		this.nombre = nombre;
		this.dia = app.day();
		this.mes = app.month();
		this.anio = app.year();
		this.hora = app.hour();
		this.minuto = app.minute();
		
	}
	
	

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int compareTo(usuario arg0) {
		
		return this.hora - arg0.getHora();
		
	}
	
	

}
