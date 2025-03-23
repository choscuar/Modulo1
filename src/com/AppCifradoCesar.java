package com;

import java.util.Scanner;
import java.io.*;

public class AppCifradoCesar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CifradoCesar cifradoCesar = new CifradoCesar();

        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Cifrar texto");
            System.out.println("2. Descifrar texto");
            System.out.println("3. Cifrar archivo");
            System.out.println("4. Descifrar archivo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Cifrar texto
                    System.out.print("Introduce el texto a cifrar: ");
                    String textoParaCifrar = scanner.nextLine();
                    System.out.print("Introduce el desplazamiento: ");
                    int desplazamientoTextoCifrar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Texto cifrado: " + cifradoCesar.cifrarTexto(textoParaCifrar, desplazamientoTextoCifrar));
                    break;

                case 2:
                    // Descifrar texto
                    System.out.print("Introduce el texto a descifrar: ");
                    String textoParaDescifrar = scanner.nextLine();
                    System.out.print("Introduce el desplazamiento: ");
                    int desplazamientoTextoDescifrar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Texto descifrado: " + cifradoCesar.descifrarTexto(textoParaDescifrar, desplazamientoTextoDescifrar));
                    break;

                case 3:
                    // Cifrar archivo
                    System.out.print("Introduce la ruta del archivo a cifrar: ");
                    String archivoParaCifrar = scanner.nextLine();
                    System.out.print("Introduce la ruta del archivo de salida: ");
                    String archivoSalidaCifrar = scanner.nextLine();
                    System.out.print("Introduce el desplazamiento: ");
                    int desplazamientoArchivoCifrar = scanner.nextInt();
                    scanner.nextLine();
                    cifradoCesar.procesarArchivo(archivoParaCifrar, archivoSalidaCifrar, desplazamientoArchivoCifrar, true);

                    System.out.println("\nContenido del archivo cifrado:");
                    mostrarArchivo(archivoSalidaCifrar);
                    break;

                case 4:
                    // Descifrar archivo
                    System.out.print("Introduce la ruta del archivo a descifrar: ");
                    String archivoParaDescifrar = scanner.nextLine();
                    System.out.print("Introduce la ruta del archivo de salida: ");
                    String archivoSalidaDescifrar = scanner.nextLine();
                    System.out.print("Introduce el desplazamiento: ");
                    int desplazamientoArchivoDescifrar = scanner.nextInt();
                    scanner.nextLine();
                    cifradoCesar.procesarArchivo(archivoParaDescifrar, archivoSalidaDescifrar, desplazamientoArchivoDescifrar, false);

                    System.out.println("\nContenido del archivo descifrado:");
                    mostrarArchivo(archivoSalidaDescifrar);
                    break;

                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    public static void mostrarArchivo(String rutaArchivo) {
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}