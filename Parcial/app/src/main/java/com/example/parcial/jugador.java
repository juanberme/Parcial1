package com.example.parcial;

public class jugador {

    private int posX, posY;
    private int tam;
    private int R;
    private int G;
    private int B;
    private String name;

    public jugador(int posX, int posY, int tam, int r, int g, int b, String name) {
        super();
        this.posX = posX;
        this.posY = posY;
        this.tam = tam;
        R = r;
        G = g;
        B = b;
        this.name = name;
    }

    public jugador() {
        super();
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public int getG() {
        return G;
    }

    public void setG(int g) {
        G = g;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
