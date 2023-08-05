package com.pucese.juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class nextStep extends JPanel {
    private SquarePanel squarePanel;
    
    public nextStep(SquarePanel squarePanel){

        super();

        // Hace accesible squarePanel
        this.squarePanel = squarePanel;

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton siguientePaso = new JButton("Siguiente Paso");

        siguientePaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {avanzar();}
        });

        siguientePaso.setPreferredSize(new Dimension(200, 50));
        siguientePaso.setBackground(Color.yellow);

        buttonPanel.add(siguientePaso);

        add(buttonPanel);
    }

    public int turnos(){
        Random pasos = new Random();
        int i = pasos.nextInt(3) + 1;
        return i;
    }

    public void avanzar(){
        int num = turnos();

        if(num == 1){
            squarePanel.setY(squarePanel.getY() + 1);
        } else if (num == 2) {
            squarePanel.setY(squarePanel.getY() - 1);
        } else if (num == 3) {
            squarePanel.setX(squarePanel.getX() + 1);
        } else if(num == 4){
            squarePanel.setX(squarePanel.getX() - 1);
        }
        
        squarePanel.lettersPosition();
        squarePanel.repaint();
    }
}
