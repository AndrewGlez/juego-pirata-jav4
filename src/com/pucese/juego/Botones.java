package com.pucese.juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botones extends JPanel{
        public Botones(){
            // Llama al constructor de la superclase con BorderLayout
            super();

            // Crea un panel para el botón "jugar" con FlowLayout alineado a la derecha
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

            // Crea el botón "jugar"
            JButton jugarButton = new JButton("Jugar");

            // Agrega un ActionListener al botón
            jugarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Este método se ejecutará cuando se haga clic en el botón "Jugar".
                    // Aquí puedes agregar la lógica del juego o llamar a un método desde la clase principal.
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
