package Ejemplo_1;
import java.io.*;
public class Main {
    private static final String RUTA_ARCHIVO = "datos.bin";
    // Método para escribir un arreglo de enteros en un archivo binario
    public static void escribirEnteros(int[] numeros) {
        try (DataOutputStream salida = new DataOutputStream(new
                FileOutputStream(RUTA_ARCHIVO))) {
            for (int numero : numeros) {
                salida.writeInt(numero); // Escribe cada entero en el archivo
            }
            System.out.println("Números escritos correctamente en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " +
                    e.getMessage());
        }
    }
    // Método para leer un arreglo de enteros desde un archivo binario
    public static void leerEnteros() {
        try (DataInputStream entrada = new DataInputStream(new
                FileInputStream(RUTA_ARCHIVO))) {
            System.out.println("Números leídos del archivo:");
            while (entrada.available() > 0) { // Verifica si hay más datos
                int numero = entrada.readInt(); // Lee un entero
                System.out.println(numero);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        int[] numeros = {10,20,30,40,50};
        leerEnteros();
        escribirEnteros(numeros);
    }
}