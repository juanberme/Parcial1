package modelo;

import java.util.Collections;
import java.util.LinkedList;

import processing.core.PApplet;

import controlP5.*;

public class logica {

	private PApplet app;
	private LinkedList <usuario> user;
	private nombre name;
	private ControlP5 cp5;
	private Textfield epa;
	private String textico;
	
	public logica(PApplet app) {
		
		this.app = app;
		name = new nombre();
		user = new LinkedList<usuario>();
		cp5 = new ControlP5(app);
		cp5.addTextfield("ingrese usuario").setPosition(20, 20).setSize(200,20).setAutoClear(true);
		
		
		
	}
	
	public void cuadroDeTexto() {
		
		//cp5.addTextfield().setPosition(20, 20).setSize(200,20).setAutoClear(false);
		textico = cp5.get(Textfield.class, "ingrese usuario" ).getStringValue();
		//cp5.getController();
		//System.out.println(epa.getStringValue());
		//System.out.println(textico);
		user.add(new usuario(textico,app));
		System.out.println(user.size());
	}
	
	public LinkedList<usuario> getUser(){
		
		return user;
		
	}
	
	public void setUser(LinkedList<usuario>user) {
		
		this.user = user;
		
	}
	
	
	
	public void guardarTxt() {
		
		String[] usua;
		usua = new String [user.size()];
		
		
		for(int i = 0; i < user.size(); i++) {
			
			String nombre = "nombre: "+user.get(i).getNombre();
			String anio = "anio: "+user.get(i).getAnio();
			String mes = "mes: "+user.get(i).getMes();
			String dia ="dia: "+user.get(i).getDia();
			String hora = "hora: "+user.get(i).getHora();
			String minutos = "minutos: "+user.get(i).getMinuto();
			usua[i] = nombre+anio+mes+dia+hora+minutos;
			app.saveStrings("./texto/usuario.txt", usua);
			
		}
		
		
		
		
	}

	/*public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}*/
	
	

	public void draw() {
		cuadroDeTexto();
		///System.out.println((texto.getStringValue()));
		//(texto.getStringValue());
		
	}

	public Textfield getEpa() {
		return epa;
	}

	public void setEpa(Textfield epa) {
		this.epa = epa;
	}

	public void mousePressed() {
		
		
		
	}
	
	
	
	
	
}
