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
    private JLabel directionLabel;
    private String nextDirection;



    public nextStep(SquarePanel squarePanel){

        super();
        directionLabel = new JLabel();
        directionLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Hace accesible squarePanel
        this.squarePanel = squarePanel;

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        siguientePaso = new JButton("Siguiente Paso");


        siguientePaso.addActionListener(e -> {
            avanzar();
            squarePanel.setI(1);
            directionLabel.setText(nextDirection);
        });

        siguientePaso.setPreferredSize(new Dimension(200, 50));
        siguientePaso.setBackground(Color.yellow);

        buttonPanel.add(siguientePaso);

        add(buttonPanel);
        buttonPanel.add(directionLabel, BorderLayout.SOUTH);
    }

    public int turnos(){
        Random pasos = new Random();
        int i = pasos.nextInt(1,4);
        return i;
    }
    public void avanzar(){
        int aleatorio = turnos();
        int tmp = aleatorio;

        switch (aleatorio) {
            case 1:
                nextDirection = "South";
                break;
            case 2:
                nextDirection = "North";
                break;
            case 3:
                nextDirection = "East";
                break;
            case 4:
                nextDirection = "West";
                break;
            default:
                nextDirection = "Unknown";
                break;
        }



        switch (tmp) {
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


        /*if(num == 1){
            squarePanel.setPirataY(squarePanel.getPirataY() + 1);
            direction.setText("Norte");
        } else if (num == 2) {
            squarePanel.setPirataY(squarePanel.getPirataY() - 1);
            direction.setText("Sur");
        } else if (num == 3) {
            squarePanel.setPirataX(squarePanel.getPirataX() + 1);
            direction.setText("Este");
        } else if(num == 4){
            squarePanel.setPirataX(squarePanel.getPirataX() - 1);
            direction.setText("Oeste");
        }*/

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
    }
}
