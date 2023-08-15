package com.pucese.juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class nextStep extends JPanel {
    JButton siguientePaso;
    JPanel buttonPanel;
    private SquarePanel squarePanel;
    private JLabel direccionLabel;
    int aleatorio;


    public nextStep(SquarePanel squarePanel){
        super();
        aleatorio = turnos();

        // Hace accesible squarePanel
        this.squarePanel = squarePanel;

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        direccionLabel = new JLabel("Dirección del pirata: ");
        buttonPanel.add(direccionLabel);


        siguientePaso = new JButton("Siguiente Paso");


        siguientePaso.addActionListener(e -> {

            avanzar(aleatorio);
            squarePanel.setI(1);

        });

        siguientePaso.setPreferredSize(new Dimension(200, 50));
        siguientePaso.setBackground(Color.yellow);

        buttonPanel.add(siguientePaso);

        add(buttonPanel);


    }

    public int turnos(){
        Random pasos = new Random();
        int i = pasos.nextInt(1, 4) + 1;
        return i;
    }
    public void avanzar(int sig){
        aleatorio = turnos();


        switch (sig) {
            case 1:
                squarePanel.setPirataY(squarePanel.getPirataY() + 1);
                break;
            case 2:
                squarePanel.setPirataY(squarePanel.getPirataY() - 1);
                break;
            case 3:
                squarePanel.setPirataX(squarePanel.getPirataX() + 1);
                break;
            case 4:
                squarePanel.setPirataX(squarePanel.getPirataX() - 1);
                break;
            default:
                break;
        }

        if(squarePanel.getPirataX() > 3 || squarePanel.getPirataY() > 3
                || squarePanel.getPirataY() == 0 || squarePanel.getPirataX() == 0){
            siguientePaso.setEnabled(false);
            squarePanel.lettersPosition();
            squarePanel.repaint();
            JOptionPane.showMessageDialog(null, "El pirata se ahogó.");
            return;
        };

        if (squarePanel.getPirataX() == squarePanel.tesoroX
                && squarePanel.getPirataY() == squarePanel.getTesoroY()){
            siguientePaso.setEnabled(false);
            squarePanel.lettersPosition();
            squarePanel.repaint();
            JOptionPane.showMessageDialog(null, "El pirata encontró el tesoro.");
        }

        squarePanel.lettersPosition();
        squarePanel.repaint();
        String direccion = direccionPirata(aleatorio);
        direccionLabel.setText("Dirección del pirata: " + direccion);
    }
    public String direccionPirata(int aleatorio) {
        switch (aleatorio) {
            case 1:
                return "Sur";
            case 2:
                return "Norte";
            case 3:
                return "Este";
            case 4:
                return "Oeste";
            default:
                return "Desconocida";
        }
    }



}
