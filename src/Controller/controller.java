package Controller;

import processing.core.PApplet;
//import controlP5.*;
import modelo.logica;

public class controller {
	
	private PApplet app;
	//private ControlP5 cp5;
	private logica logic;
	
	public controller(PApplet app) {
		
		this.app = app;
		//cp5 = new ControlP5(app);
		logic = new logica(app);
		
	}
	
	public void texta() {
		
		logic.cuadroDeTexto();
		
	}
	
	public void guarde() {
		
		logic.guardarTxt();
		
	}

	public void draw() {
		
		logic.draw();
		texta();
		
		
	}

	public void mousePressed() {
		
		logic.mousePressed();
		
	}
	

}
