package com.pucese.juego;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Pirata {
    Icon pirata;
    Icon tesoro;
    public Pirata(){
    pirata = new ImageIcon(Objects.requireNonNull((getClass().getResource("Recursos/pirata.png"))));
    tesoro = new ImageIcon(Objects.requireNonNull((getClass().getResource("Recursos/tesoro.png"))));

    }
}
