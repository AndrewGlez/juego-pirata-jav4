package com.pucese.juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Botones extends JPanel{
    JPanel buttonPanel;
    JButton jugarButton;
    // Agrega una referencia a la clase Window
    private Window window;

    // Agrega un método para establecer la referencia a la clase Window
    public void setWindow(Window window) {
        this.window = window;
    }
    private SquarePanel squarePanel;
        public Botones(SquarePanel squarePanel){
            // Llama al constructor de la superclase con BorderLayout
            super();


            // Crea un panel para el botón "jugar" con FlowLayout alineado a la derecha
            buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

            // Crea el botón "jugar"
            jugarButton = new JButton("Jugar");

            // Agrega un ActionListener al botón
            jugarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Random rnd = new Random();
                    squarePanel.setPirataX(rnd.nextInt(1, 3));
                    squarePanel.setPirataY(rnd.nextInt(1, 3));
                    squarePanel.setTesoroX(rnd.nextInt(1, 3));
                    squarePanel.setTesoroY(rnd.nextInt(1, 3));
                }
            });

            // Ajusta el tamaño del botón
            jugarButton.setPreferredSize(new Dimension(100, 50));
            jugarButton.setBackground(Color.GREEN);

            // Agrega el botón al panel del botón
            buttonPanel.add(jugarButton);

            // Crea un panel para el botón "salir" con FlowLayout alineado a la izquierda
            JPanel exitButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            // Crea el botón "salir"
            JButton salirButton = new JButton("Salir");

            jugarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Genera las posiciones aleatorias


                    window.reiniciarTablero();
                }
            });

            // Agrega un ActionListener al botón
            salirButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Este método se ejecutará cuando se haga clic en el botón "Salir".
                    // Aquí puedes agregar la lógica para salir del juego o cerrar la aplicación.
                    System.exit(0);
                }
            });

            // Ajusta el tamaño del botón
            salirButton.setPreferredSize(new Dimension(100, 50));
            salirButton.setBackground(Color.RED);

            // Agrega el botón al panel del botón "salir"
            exitButtonPanel.add(salirButton);

            // Agrega los paneles de botones al panel principal, en el orden deseado
            add(exitButtonPanel, BorderLayout.WEST);
            add(buttonPanel, BorderLayout.EAST);

        }
}
