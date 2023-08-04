package com.pucese.juego;

import javax.swing.JFrame;
import java.awt.*;

public class Window extends JFrame {

    public Window(){
        inicializarTablero();
        add(new SquarePanel());
    }
    void inicializarTablero(){
        setBounds(0, 0, 600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Juego: Pirata pata de palo");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}