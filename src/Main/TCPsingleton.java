package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

import model.jugador;

public class TCPsingleton extends Thread{

	private static TCPsingleton unica;
	
	
	public static TCPsingleton getInstance() {
		if(unica == null) {
			unica = new TCPsingleton();
			unica.start();
		}
		return unica;
	}
	
	private TCPsingleton(){};
	
	private Socket server;
	private BufferedReader reader;
	private BufferedWriter writer;
	private Gson gson;
	public jugador player;
	private OnMessageListener observer;
	
	public void setObserver(OnMessageListener observer) {
		
		this.observer = observer;
		
		}
	
	public void run() {
					try {
						ServerSocket servidor = new ServerSocket(6001);
						System.out.println("Waiting Client...");
						server = servidor.accept();
						System.out.println("Successfully connected");
						
						InputStream is = server.getInputStream();
						reader = new BufferedReader(new InputStreamReader(is));
						
						while(true) {
							
							System.out.println("Waiting info...");
							String linea = reader.readLine();
							System.out.println("I have it");
							System.out.println(linea);
							observer.OnMessage(linea);
							
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}

}
