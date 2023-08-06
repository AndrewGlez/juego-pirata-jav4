package com.pucese.juego.palabras;

import com.pucese.juego.palabras.Ejercicio1;

import java.util.Scanner;

public class Ejercicio1App {
    public static void main(String[] args) {
        int repeticion = 1;

        while (repeticion == 1) {
            Repetir();
            System.out.println("¿Deseas repetir? (1: Sí, 0: No)");
            Scanner scanner = new Scanner(System.in);
            repeticion = scanner.nextInt();
        }
    }

    public static void Repetir() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese palabras: ");
        String linea = scanner.nextLine();

        Ejercicio1 sustituir = new Ejercicio1(linea);

        // contar y sustituir
        sustituir.contarLetras();

        // imprimir
        System.out.println("Resultado: ");
        System.out.println(sustituir.getLinea());
    }
}
