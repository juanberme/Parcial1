package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button okay;
    private EditText nombre;
    private TCPsingleton tcp;
    private jugador player;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencias
        okay = findViewById(R.id.okay);
        nombre = findViewById(R.id.nombre);
        okay.setOnClickListener(this);

        tcp = TCPsingleton.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.okay:
                userName = nombre.getText().toString();
                player = new jugador(250,250,100,0, 0,255,userName);
                Gson gson = new Gson();
                String jug = gson.toJson(player);
                tcp.sendMessage(jug);
                Log.e("---", "okay.........");
                Intent ok = new Intent(this, Juego.class);
                startActivity(ok);
                //tcp.sendMessage("pantalla1");
                break;
        }
    }
}