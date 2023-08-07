package com.pucese.juego;

import javax.swing.*;
import java.awt.*;

public class LabelSiguiente extends JPanel {
    private JLabel siguiente;
    public LabelSiguiente(SquarePanel squarePanel){
        setVisible(true);
        siguiente = new JLabel();
        this.siguiente.setFont(new Font("Arial", Font.PLAIN, 21));
        if (squarePanel.lettersPosition() == 1){
            siguiente.setText("Norte");
        } else if (squarePanel.lettersPosition() == 2) {
            siguiente.setText("Sur");
        } else if (squarePanel.lettersPosition() == 3) {
            siguiente.setText("Este");
        } else if (squarePanel.lettersPosition() == 4) {
            siguiente.setText("Oeste");
        }
        add(siguiente, BorderLayout.WEST);
    }
}
