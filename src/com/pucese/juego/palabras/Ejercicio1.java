package com.pucese.juego.palabras;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio1 {
    private String cadena;

    public Ejercicio1(String cadena) {
        this.cadena = cadena;
    }

    // Método para contar la cantidad que se repite
    public void contarLetras() {
        Map<Character, Integer> repetidos = new HashMap<>();
        for (char c : cadena.toCharArray()) {
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                repetidos.put(lower, repetidos.getOrDefault(lower, 0) + 1);
            }
        }

        // para encontrar la letra que más se repite
        char masRepetido = ' ';
        int repeticionMax = 0;

        for (Map.Entry<Character, Integer> entrada : repetidos.entrySet()) {
            if (entrada.getValue() > repeticionMax) {
                masRepetido = entrada.getKey();
                repeticionMax = entrada.getValue();
                System.out.println(repeticionMax);
            }
        }
        // sustitución
        sustituirVocales(masRepetido);
    }

    // método para sustituir la vocal por la consonante que más se repite
    private void sustituirVocales(char letra) {
        this.cadena = cadena.replaceAll("[AEIOUaeiou]", String.valueOf(letra));
    }

    // para obtener la letra que se va a cambiar
    public String getLinea() {
        return cadena;
    }
}
