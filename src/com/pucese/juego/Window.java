package com.pucese.juego;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;

public class Window extends JFrame {

    public Window(){
        inicializarTablero();
        SquarePanel squarePanel = new SquarePanel();
        Botones botonesPanel = new Botones();
        nextStep siguientePaso = new nextStep(squarePanel);
        add(squarePanel, BorderLayout.CENTER);

        // Agrega el panel de botones a la ventana
        add(botonesPanel, BorderLayout.SOUTH);
        add(siguientePaso, BorderLayout.EAST);
    }
    void inicializarTablero(){
        setBounds(0, 0, 800, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Juego: Pirata pata de palo");
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Window());
    }
}
