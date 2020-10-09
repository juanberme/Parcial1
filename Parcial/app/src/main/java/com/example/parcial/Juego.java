package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Juego extends AppCompatActivity implements View.OnTouchListener{

    private Button arriba;
    private Button abajo;
    private Button derecha;
    private Button izquierda;
    private Button color;
    private Socket llega;
    private BufferedReader reader;
    private Boolean verificarup;
    private Boolean cambiarColor;
    private jugador player;
    private int irArriba;
    private int irAbajo;
    private int irIzquierda;
    private int irDerecha;
    private int nuevoR;
    private int nuevoG;
    private int nuevoB;
    private Gson gson;
    private String play;
    private TCPsingleton tcp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        //referencias
        arriba = findViewById(R.id.arriba);
        abajo = findViewById(R.id.abajo);
        izquierda = findViewById(R.id.izquierda);
        derecha = findViewById(R.id.derecha);
        color = findViewById(R.id.color);
        cambiarColor = false;
        tcp = TCPsingleton.getInstance();


        arriba.setOnTouchListener(this);
        abajo.setOnTouchListener(this);
        izquierda.setOnTouchListener(this);
        derecha.setOnTouchListener(this);

        color.setOnClickListener(
                (view)->{

                    if(cambiarColor == false ){
                        nuevoR = 255;
                        nuevoG = 0;
                        nuevoB = 0;
                    }else{
                        nuevoR = 0;
                        nuevoG = 0;
                        nuevoB = 255;
                    }
                }
        );

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                verificarup = true;

                new Thread(
                        ()->{
                            while (verificarup){
                                switch (view.getId()){
                                    case R.id.arriba:
                                        irArriba = player.getPosY()+2;
                                        player = new jugador(player.getPosX(), irArriba, 100, nuevoR, nuevoG, nuevoB, player.getName());
                                        play = gson.toJson(player);
                                        Log.e("^^", play);

                                        break;
                                    case R.id.abajo:
                                        irAbajo = player.getPosY()-2;
                                        player = new jugador(player.getPosX(), irAbajo, 100, nuevoR, nuevoG, nuevoB, player.getName());
                                        play = gson.toJson(player);
                                        Log.e("---", play);
                                        break;
                                    case R.id.izquierda:
                                        irIzquierda = player.getPosX()-2;
                                        player = new jugador(irIzquierda, player.getPosY(), 100, nuevoR, nuevoG, nuevoB, player.getName());
                                        play = gson.toJson(player);
                                        Log.e("iz", play);
                                        break;
                                    case R.id.derecha:
                                        Log.e("de", play);
                                        irDerecha = player.getPosX()+2;
                                        player = new jugador(irDerecha, player.getPosY(), 100, nuevoR, nuevoG, nuevoB, player.getName());
                                        play = gson.toJson(player);

                                }

                                tcp.sendMessage(play);
                            }
                        }
                ).start();
                break;
            case MotionEvent.ACTION_UP:
                verificarup = false;
                break;
        }
        return false;
    }


}