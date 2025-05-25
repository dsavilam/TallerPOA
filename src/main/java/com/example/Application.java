package com.example;

import com.example.model.Producto;
import com.example.service.ProductoServicio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // Arrancatodo Spring Boot y carga application.properties
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        ProductoServicio servicio = context.getBean(ProductoServicio.class);

        System.out.println("\n==== Todos los productos ====");
        servicio.findAll().forEach(System.out::println);

        System.out.println("\n==== Creando un producto nuevo ====");
        Producto p = servicio.save(new Producto(null, "Camisa", 49.99));
        System.out.println("Guardado: " + p);

        System.out.println("\n==== Actualizando precio ====");
        servicio.updatePrice(p.getId(), 59.99);

        context.close();
    }
}

