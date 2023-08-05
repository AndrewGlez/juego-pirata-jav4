package com.pucese.juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class nextStep extends JPanel {
    private SquarePanel squarePanel;
    
    public nextStep(SquarePanel squarePanel){
        // Llama al constructor de la superclase con BorderLayout
        super();
        this.squarePanel = squarePanel;

        // Crea un panel para el botón "jugar" con FlowLayout alineado a la derecha
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Crea el botón "jugar"
        JButton siguientePaso = new JButton("Siguiente Paso");

        // Agrega un ActionListener al botón
        siguientePaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avanzar();
                // Este método se ejecutará cuando se haga clic en el botón "Jugar".
                // Aquí puedes agregar la lógica del juego o llamar a un método desde la clase principal.
            }
        });

        // Ajusta el tamaño del botón
        siguientePaso.setPreferredSize(new Dimension(200, 50));
        siguientePaso.setBackground(Color.yellow);

        // Agrega el botón al panel
        buttonPanel.add(siguientePaso);

        // Agrega el panel con el botón al panel principal (this)
        add(buttonPanel);
    }
    public int turnos(){
        Random pasos = new Random();
        int si = pasos.nextInt(1,4);
        return si;
    }
    public void avanzar(){
        int num = turnos();
        if(num==1){
            squarePanel.setY(squarePanel.getY() + 1);
        } else if (num==2) {
            squarePanel.setY(squarePanel.getY() - 1);
        } else if (num==3) {
            squarePanel.setX(squarePanel.getX() + 1);
        }
        else if(num==4){
            squarePanel.setX(squarePanel.getX() - 1);
        }
        squarePanel.repaint();
    }
}
