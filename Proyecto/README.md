# Recomendador de Platos

Sistema de recomendación de platos que permite filtrar, agrupar y gestionar un catálogo de comidas utilizando Java Streams.

## Descripción

Esta aplicación permite a los usuarios:
- Buscar platos según su presupuesto y categoría preferida
- Consultar los 3 platos más saludables (menor cantidad de calorías)
- Ver todos los platos agrupados por categoría
- Agregar nuevos platos al sistema
- Navegar por un menú interactivo hasta decidir salir

## Estructura del Proyecto

```
recomendador/
├── src/main/java/com/devsenior/
│   ├── Main.java                    # Punto de entrada de la aplicación
│   ├── datos/
│   │   └── DataBaseSimulada.java    # Base de datos simulada con platos iniciales
│   ├── model/
│   │   ├── Plato.java               # Modelo de datos para platos
│   │   ├── Categoria.java           # Enum de categorías
│   │   └── Stand.java               # Modelo de datos para stands
│   ├── service/
│   │   └── PlatoService.java        # Lógica de negocio con Streams
│   └── ui/
│       └── Menu.java                # Interfaz de usuario por consola
```

## Categorías Disponibles

- **VEGANO**: Platos sin ingredientes de origen animal
- **DULCE**: Postres y platos dulces
- **PICANTE**: Platos con nivel de picante
- **TRADICIONAL**: Comida tradicional
- **BEBIDA**: Bebidas y líquidos

## Funcionalidades

### 1. Recomendar platos por presupuesto y categoría
Filtra los platos que se ajustan a tu presupuesto y categoría preferida, ordenados por precio de menor a mayor.

### 2. Ver top 3 platos más saludables
Muestra los 3 platos con menor cantidad de calorías del catálogo completo.

### 3. Ver platos agrupados por categoría
Organiza y muestra todos los platos disponibles agrupados según su categoría.

### 4. Insertar un nuevo plato
Permite agregar un nuevo plato al sistema proporcionando:
- Nombre del plato
- Precio
- Calorías
- Categoría
- Nombre del stand

### 5. Salir
Cierra la aplicación de forma segura.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal
- **Java Streams API**: Para operaciones funcionales sobre colecciones
- **Scanner**: Para entrada de datos por consola

## Cómo Ejecutar

1. Asegúrate de tener Java instalado (versión 8 o superior)
2. Compila el proyecto:
   ```bash
   javac -d bin src/main/java/com/devsenior/**/*.java
   ```
3. Ejecuta la aplicación:
   ```bash
   java -cp bin com.devsenior.Main
   ```

## Ejemplo de Uso

```
Bienvenido al recomendador de platos

=== MENU PRINCIPAL ===
1. Recomendar platos por presupuesto y categoria
2. Ver top 3 platos mas saludables
3. Ver platos agrupados por categoria
4. Insertar un nuevo plato
5. Salir
Seleccione una opcion: 1
Ingrese su presupuesto: 80
Ingrese la categoria (VEGANO, DULCE, PICANTE, TRADICIONAL, BEBIDA): VEGANO
Platos recomendados:
Plato{nombre='Arroz Frito', precio=60.0, categoria=VEGANO, calorias=500, stand=Stand{nombre='Comida China'}}
Plato{nombre='Ensalada César Vegana', precio=75.0, categoria=VEGANO, calorias=400, stand=Stand{nombre='Gourmet Vegano'}}
```

## Características Técnicas

- **Programación Funcional**: Uso extensivo de Java Streams para operaciones sobre colecciones
- **Inmutabilidad**: Los métodos de servicio no modifican las colecciones originales (excepto `agregarPlato`)
- **Separación de Responsabilidades**: Arquitectura en capas (UI, Service, Model, Data)
- **Manejo de Excepciones**: Validación de categorías con try-catch

## Platos Iniciales

El sistema viene precargado con 10 platos de diferentes stands:
- Delicias Mexicanas
- Sabor Italiano
- Comida China
- Gourmet Vegano
- Parrilla Argentina

## Autor
## Andres Mauricio Quintero Rios

Proyecto desarrollado como práctica de Java Streams y programación funcional.
