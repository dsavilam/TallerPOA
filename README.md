# Taller POA

Ejemplo sencillo de **Spring Boot**, **Spring Data JPA** y **AOP**.

## Descripción

- Gestiona `Producto` en MySQL.
- Permite listar, crear (precio ≥ 0) y actualizar productos.
- Logging transversal con AOP para separar responsabilidades.

## Instalación

1. Clona el repositorio.  
2. Configura `src/main/resources/application.properties`.  
3. Ejecuta:
   ```bash
   mvn clean package
   mvn spring-boot:run
   ```

## Estructura

- `Application.java`: arranque y entrada por consola.  
- `AppConfig.java`: configuración de DataSource, JPA y AOP.  
- `model/Producto.java`: entidad JPA.  
- `repository/ProductoRepository.java`: interfaz `JpaRepository`.  
- `service/ProductoServicio*`: lógica de negocio con `@Transactional`.  
- `aspect/LoggingAspect.java`: advices (`@Before`, `@After`, `@Around`) para logging.

## AOP

- Usa `@Aspect` y pointcuts en servicios.  
- Advices antes, después y en excepciones.

