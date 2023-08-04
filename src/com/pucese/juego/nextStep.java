package com.pucese.juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class nextStep extends JPanel {
    public nextStep(){
        // Llama al constructor de la superclase con BorderLayout
        super();

        // Crea un panel para el botón "jugar" con FlowLayout alineado a la derecha
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Crea el botón "jugar"
        JButton siguientePaso = new JButton("Siguiente Paso");

        // Agrega un ActionListener al botón
        siguientePaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
}
