package com.example.proyecto_4to_semestre.crud.utils;

import java.util.Random;

public class generadorID {
    public static String generarCodigo() {
        Random random = new Random();
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";

        char letra1 = letras.charAt(random.nextInt(letras.length()));
        char numero1 = numeros.charAt(random.nextInt(numeros.length()));
        char letra2 = letras.charAt(random.nextInt(letras.length()));
        char numero2 = numeros.charAt(random.nextInt(numeros.length()));

        return "" + letra1 + numero1 + letra2 + numero2;
    }
}
