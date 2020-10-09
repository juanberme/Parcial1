package View;

import processing.core.PApplet;

import java.util.LinkedList;

import Controller.controller;
import controlP5.*;

public class Main extends PApplet {

	public static void main(String[] args) {
		
		PApplet.main("View.Main");
		
	}
	
	ControlP5 cp5;
	int chimbita;
	Textfield epa;
	String hola;
	String[] nueva;
	LinkedList<Main> nuevoTexto;
	int d; 
	int m;
	int y;
	int h;
	int mi;
	String a;
	String b;
	String c;
	String e;
	String f;
	private controller cont;
	
	
	
	
	public void settings() {
		
		size(600,600);
		
	}
	
	public void setup() {
		
		cp5 = new ControlP5(this);
		cp5.addSlider("chimbita").setPosition(100,100).setRange(0, 255).setSize(200,20);
		epa = cp5.addTextfield("ingrese usuario").setPosition(20, 20).setSize(200,20);
		//println(hola);
		nuevoTexto = new LinkedList<Main>();
		d = day();
		m = month();
		y = year();
		h = hour();
		mi = minute();
		a = String.valueOf(d);
		b = String.valueOf(m);
		c = String.valueOf(y);
		e = String.valueOf(h);
		f = String.valueOf(mi);
		cont = new controller(this);
		
		
	}
	
	public void draw() {
		
		background(chimbita);
		
		//System.out.println("valor almacenado en el cuadro de texto:"+" "+ epa.getStringValue()+" "+"valor ESCRITO"+" "+ epa.getText());
		//println("valor almacenado en el cuadro de texto:"+" "+ epa.getStringValue()+" "+"valor ESCRITO"+" "+ epa.getText());
		//println(epa.getText());
		//println(epa.getStringValue());
		//hola = epa.getStringValue(); //Este muestra el valor de lo puesto en el coso
		//ordenar();
		//
		//println("dia"+" " +a+" "+ "mes"+" "+b+" "+"ano"+" "+c+" "+"hora"+" "+e+" "+"minutos"+" "+f);
		cont.draw();
		
		
		
	}
	
	public void mousePressed() {
		
		//cont.mousePressed();
		
	}
	
	public void keyPressed() {
		
	}

}
