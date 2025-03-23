package com;

import java.io.*;

class CifradoCesar {
    public void procesarArchivo(String archivoEntrada, String archivoSalida, int desplazamiento, boolean cifrar) {
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida))) {

            String linea;
            while ((linea = lector.readLine()) != null) {
                String resultado = cifrar ? cifrarTexto(linea, desplazamiento) : descifrarTexto(linea, desplazamiento);
                escritor.write(resultado);
                escritor.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }

    public String cifrarTexto(String texto, int desplazamiento) {
        StringBuilder cifrado = new StringBuilder();
        desplazamiento = desplazamiento % 26;

        for (char caracter : texto.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char inicio = Character.isUpperCase(caracter) ? 'A' : 'a';
                caracter = (char) (inicio + (caracter - inicio + desplazamiento) % 26);
            }
            cifrado.append(caracter);
        }
        return cifrado.toString();
    }

    public String descifrarTexto(String texto, int desplazamiento) {
        return cifrarTexto(texto, 26 - (desplazamiento % 26));
    }
}