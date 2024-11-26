package Ejemplo_2;

import java.io.*;

class Producto implements Serializable {
    // Requisito para Serializable
    private static final long serialVersionUID = 1L;
    private String nombre;
    private double precio;
    // Constructor
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Producto: " + nombre + ", Precio: $" + precio;
    }
}

public class Main {
    private static final String RUTA_ARCHIVO = "productos.bin";
    // Método para escribir una lista de productos en un archivo binario
    public static void escribirProductos(Producto[] productos) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            for (Producto producto : productos) {
                salida.writeObject(producto); // Escribe el objeto en el archivo
            }
            System.out.println("Productos guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir los productos: " + e.getMessage());
        }
    }
    // Método para leer productos desde un archivo binario
    public static void leerProductos() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO))) {
            System.out.println("Productos leídos del archivo:");
            while (true) {
                Producto producto = (Producto) entrada.readObject();
                System.out.println(producto);
            }
        } catch (EOFException e) {
            // Fin del archivo alcanzada, no es un error
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer los productos: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Producto[] productos = {
                new Producto("Laptop", 15000),
                new Producto("Celular", 8000),
                new Producto("Tablet", 5000)
        };
        // Escribir productos en el archivo
        escribirProductos(productos);
        leerProductos();
    }

}
