package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import model.jugador;
import processing.core.PApplet;

public class main extends PApplet implements OnMessageListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main.main");
	}
	
	private TCPsingleton tcp;
	private jugador player;
	private Gson gson;
	private int X, Y, R,G,B,tAm;
	private String nombre;
	
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		tcp = TCPsingleton.getInstance();
		tcp.setObserver(this);
		gson = new Gson();
		
		X = 0;
		Y = 0;
		R = 0;
		G = 0;
		B = 0;
		tAm = 100;
		nombre = "Default";
		
	}
	
	public void draw() {
		
		background(255);
		fill(R,G,B);
		ellipse(X,Y,tAm,tAm);
		text(nombre, X-20, Y+70);
	}

	@Override
	public void OnMessage(String msg) {
				
						player = gson.fromJson(msg, jugador.class);
						X = player.getPosX();
						Y = player.getPosY();
						R = player.getR();
						G = player.getG();
						B = player.getB();
						tAm = player.getTam();
						nombre = player.getName();
						System.out.println("X");
				
	}
	
}
