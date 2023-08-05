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
            squarePanel.setPirataY(squarePanel.getPirataY() + 1);
        } else if (num == 2) {
            squarePanel.setPirataY(squarePanel.getPirataY() - 1);
        } else if (num == 3) {
            squarePanel.setPirataX(squarePanel.getPirataX() + 1);
        } else if(num == 4){
            squarePanel.setPirataX(squarePanel.getPirataX() - 1);
        }

        if(squarePanel.getPirataX() > 3 || squarePanel.getPirataY() > 3
                || squarePanel.getPirataY() == 0 || squarePanel.getPirataX() == 0){
            squarePanel.lettersPosition();
            squarePanel.repaint();
            JOptionPane.showMessageDialog(null, "Perdiste");
            return;
        };

        if (squarePanel.getPirataX() == squarePanel.tesoroX
                && squarePanel.getPirataY() == squarePanel.getTesoroY()){
            squarePanel.lettersPosition();
            squarePanel.repaint();
            JOptionPane.showMessageDialog(null, "Ganaste");
            return;
        }
        squarePanel.lettersPosition();
        squarePanel.repaint();
    }
}
