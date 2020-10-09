package com.example.parcial;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPsingleton extends Thread {

    private static TCPsingleton unique;

    public static TCPsingleton getInstance(){
        if(unique == null){
            unique = new TCPsingleton();
            unique.start();
        }
        return unique;
    }

    private TCPsingleton(){}

    private Socket cliente;
    private BufferedReader reader;
    private BufferedWriter writer;
    private OnMessageListener observer;

    public void setObserver(OnMessageListener observer){this.observer = observer;}

    @Override
    public void run(){
        Log.e(">>>", "Waiting the server...");
        try {
            cliente = new Socket("10.0.2.2", 6001);
            Log.e(">>", "We´re connected");

            InputStream is = cliente.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));

            OutputStream os = cliente.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(os));

            while(true) {
                String linea = reader.readLine();
                Log.e(">>>", linea);
                observer.OnMessage(linea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg){
        new Thread(
                ()->{
                    try {
                        writer.write(msg + "\n");
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}
