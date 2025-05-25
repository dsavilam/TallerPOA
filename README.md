# Taller POA

Una aplicación de ejemplo que demuestra:

- **Spring Boot** para arranque rápido  
- **Spring Data JPA** para persistencia en MySQL  
- **Programación Orientada a Aspectos (AOP)** con AspectJ para logging transversal  
- **Transacciones reales** con `@Transactional`

---

## 📋 Descripción

Este proyecto gestiona una entidad sencilla `Producto` en una base de datos MySQL (Railway).  
Permite:

1. Listar todos los productos.
2. Crear un nuevo producto (nombre + precio ≥ 0).
3. Actualizar el precio de un producto.
4. Aplicar logging automático antes, después y en caso de excepción de todos los métodos de servicio, sin mezclar esa lógica con la de negocio.

---

## 🚀 Características

- **Entrada por consola** para crear productos con validación de precio.  
- **Capa de servicio** desacoplada de la capa de persistencia.  
- **Aspecto de logging** (`LoggingAspect`) que intercepta todos los métodos de `ProductoServicio`.  
- **Configuración Java‐based** (`AppConfig`) + arranque Spring Boot (`@SpringBootApplication`).  
- **Esquema de BD** se actualiza automáticamente (`hibernate.hbm2ddl.auto=update`).  

---

## 📋 Prerrequisitos

- Java 11 o superior  
- Maven 3.6+  
- Base de datos MySQL accesible (en este ejemplo: Railway)

---
