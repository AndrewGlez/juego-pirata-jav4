package com.pucese.juego;

import javax.swing.JPanel;
import java.awt.*;

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
}
