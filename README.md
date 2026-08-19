# 🛒 API REST - Sistema de Gestión para Bazar

Una API RESTful robusta desarrollada en Java con Spring Boot para la administración integral de un bazar comercial. Este sistema permite gestionar el inventario de productos, el registro de clientes y el procesamiento de ventas, ofreciendo endpoints específicos para reportes de facturación y control de stock.

## 🚀 Tecnologías Utilizadas

*   **Lenguaje:** Java
*   **Framework:** Spring Boot
*   **Persistencia de Datos:** Spring Data JPA / Hibernate
*   **Base de Datos:** MySQL
*   **Manejo de Dependencias:** Maven
*   **Herramientas Extra:** Lombok (Reducción de código boilerplate)
*   **Arquitectura:** Multicapa (Controller, Service, Repository, Model, DTO)

## 🏗️ Características y Arquitectura

*   **Patrón DTO (Data Transfer Object):** Implementado para la transferencia segura y eficiente de reportes combinados (ej. resumen de ventas diarias) sin exponer directamente las entidades de la base de datos.
*   **Manejo Global de Excepciones:** Utilización de `@RestControllerAdvice` para centralizar la captura de errores (ej. 404 Not Found) y devolver respuestas JSON limpias y estandarizadas al cliente.
*   **Relaciones Complejas:** Mapeo de base de datos relacional utilizando `@ManyToOne` y `@ManyToMany` para vincular ventas, clientes y múltiples productos.

## ⚙️ Configuración y Puesta en Marcha

1. Clonar el repositorio.
2. Crear una base de datos en MySQL llamada `bazar`.
3. Configurar las credenciales de la base de datos en el archivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/bazar
   spring.datasource.username=TU_USUARIO
   spring.datasource.password=TU_CONTRASEÑA
   spring.jpa.hibernate.ddl-auto=update

📌 Endpoints Principales

La API cuenta con los CRUD completos estándar (GET, POST, PUT, DELETE) para las tres entidades principales, además de los siguientes endpoints de negocio y reportes:
📦 Productos

    GET /productos - Lista todos los productos.

    GET /productos/{codigo_producto} - Obtiene un producto por su ID.

    POST /productos/crear - Registra un nuevo producto.

    PUT /productos/editar/{codigo_producto} - Modifica un producto existente.

    DELETE /productos/eliminar/{codigo_producto} - Elimina un producto.

    GET /productos/falta_stock - Devuelve una lista de productos cuya cantidad disponible sea menor a 5.

👥 Clientes

    GET /clientes - Lista todos los clientes.

    GET /clientes/{codigo_cliente} - Obtiene un cliente por su ID.

    POST /clientes/crear - Registra un nuevo cliente.

    PUT /clientes/editar/{codigo_cliente} - Modifica un cliente existente.

    DELETE /clientes/eliminar/{codigo_cliente} - Elimina un cliente.

🧾 Ventas

    GET /ventas - Lista todas las ventas.

    GET /ventas/{codigo_venta} - Obtiene una venta por su ID.

    POST /ventas/crear - Registra una nueva venta.

    PUT /ventas/editar/{codigo_venta} - Modifica una venta existente.

    DELETE /ventas/eliminar/{codigo_venta} - Elimina una venta.

    GET /ventas/productos/{codigo_venta} - Devuelve la lista completa de productos que pertenecen a una venta específica.

    GET /ventas/dia/{fecha_venta} - Devuelve un reporte (DTO) con la sumatoria del monto facturado y la cantidad total de ventas de un día determinado.

Desarrollado por: Facundo Chavez