package com.pucese.juego;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquarePanel extends JPanel{
    public static final int Squares = 5;

    private String[][] squareTexts;
    public ImageIcon [][] squareImages;
    private Color[][] squareBackgroundColors;


    public void lettersPosition() {
        squareTexts = new String[Squares][Squares];
        squareImages = new ImageIcon[Squares][Squares];
        squareBackgroundColors = new Color[Squares][Squares];


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

        squareImages[3][1] = new ImageIcon(getClass().getResource("Recursos/pirata_128.png"));
        squareImages[3][3] = new ImageIcon(getClass().getResource("Recursos/tesoro_128.png"));
        squareBackgroundColors[4][0] = Color.BLACK;
        squareBackgroundColors[0][4] = Color.BLACK;

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

                ImageIcon pirata = squareImages[i][j];
                if (pirata != null) {
                    Image image = pirata.getImage();
                    int imageWidth = image.getWidth(this);
                    int imageHeight = image.getHeight(this);
                    int imageX = x + (side - imageWidth) / 2;
                    int imageY = y + (side - imageHeight) / 2;
                    g.drawImage(image, imageX, imageY, this);
                }
                Color bgColor = squareBackgroundColors[i][j];
                if (bgColor != null) {
                    g.setColor(bgColor);
                    g.fillRect(x, y, side, side);
                }
            }

        }
    }

}
