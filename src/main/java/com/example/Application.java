package com.example;

import com.example.model.Producto;
import com.example.service.ProductoServicio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // Arranca Spring Boot y carga application.properties
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        ProductoServicio servicio = context.getBean(ProductoServicio.class);

        Scanner scanner = new Scanner(System.in);

        // ==== Mostrar productos existentes ====
        System.out.println("\n==== Todos los productos ====");
        servicio.findAll().forEach(System.out::println);

        // ==== Pedir datos del nuevo producto ====
        System.out.println("\n==== Creando un producto nuevo ====");
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine().trim();

        double precio;
        while (true) {
            System.out.print("Ingrese precio (no negativo): ");
            try {
                precio = scanner.nextDouble();
                if (precio < 0) {
                    System.out.println("Error: el precio no puede ser negativo. Intente de nuevo.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: por favor ingrese un número válido.");
                scanner.next(); // descarta la entrada inválida
            }
        }

        Producto p = servicio.save(new Producto(null, nombre, precio));
        System.out.println("Guardado: " + p);

        // ==== Actualizar precio de ejemplo ====
        System.out.println("\n==== Actualizando precio ====");
        servicio.updatePrice(p.getId(), precio + 10);  // ejemplo: le sumamos 10
        System.out.println("Precio actualizado: " + servicio.findById(p.getId()));

        context.close();
        scanner.close();
    }
}

