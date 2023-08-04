package com.pucese.juego;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquarePanel extends JPanel{
    public static final int Squares = 5;

    private String[][] squareTexts;

    public void lettersPosition() {
        squareTexts = new String[Squares][Squares];

        // Aquí estableces qué cuadros mostrarán el texto:
        squareTexts[0][0] = "A";
        squareTexts[0][1] = "G";
        squareTexts[1][0] = "G";
        squareTexts[2][0] = "U";
        squareTexts[0][2] = "U";
        squareTexts[3][0] = "A";
        squareTexts[0][3] = "A";



        squareTexts[4][4] = "A";
        squareTexts[2][4] = "G";
        squareTexts[4][3] = "G";
        squareTexts[3][4] = "U";
        squareTexts[4][2] = "U";
        squareTexts[4][1] = "A";
        squareTexts[1][4] = "A";

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int side = Math.min(width, height) / Squares;
        int xOffset = (width - Squares * side) / 2;
        int yOffset = (height - Squares * side) / 2;

        if (squareTexts == null) {
            lettersPosition();
        }

        for (int i = 0; i < Squares; i++) {
            for (int j = 0; j < Squares; j++) {
                int x = xOffset + i * side;
                int y = yOffset + j * side;
                g.drawRect(x, y, side, side);

                String text = squareTexts[i][j];
                if (text != null) {
                    Text.drawText(g, x, y, side, text);
                }
            }

        }
    }

    public SquarePanel() {
        // Llama al constructor de la superclase con BorderLayout
        super(new BorderLayout());

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

        // Inicializa squareTexts
        lettersPosition();
    }
}
