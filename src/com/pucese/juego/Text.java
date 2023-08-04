package com.pucese.juego;
import java.awt.*;

public class Text {
    public static void drawText(Graphics g, int x, int y, int side, String text) {
        Font font = new Font("Serif", Font.BOLD, 24);
        FontMetrics fm = g.getFontMetrics(font);
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        int textX = x + (side - textWidth) / 2;
        int textY = y + (side + textHeight) / 2;
        g.setFont(font);
        g.drawString(text, textX, textY);
    }
}
