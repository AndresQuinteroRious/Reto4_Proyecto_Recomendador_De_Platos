package com.devsenior.ui;

import java.util.Scanner;

import com.devsenior.datos.DataBaseSimulada;
import com.devsenior.model.Categoria;
import com.devsenior.model.Plato;
import com.devsenior.model.Stand;
import com.devsenior.service.PlatoService;

public class Menu {
    public static void Start(){
        Scanner scanner = new Scanner(System.in);
        PlatoService platoService = new PlatoService(DataBaseSimulada.getPlatos());
        boolean continuar = true;

        System.out.println("Bienvenido al recomendador de platos");
        
        while(continuar){
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Recomendar platos por presupuesto y categoria");
            System.out.println("2. Ver top 3 platos mas saludables");
            System.out.println("3. Ver platos agrupados por categoria");
            System.out.println("4. Insertar un nuevo plato");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt(); 
            
            switch(opcion){
                case 1:
                    System.out.print("Ingrese su presupuesto: ");
                    double presupuesto = scanner.nextDouble();
                    System.out.print("Ingrese la categoria (VEGANO, DULCE, PICANTE, TRADICIONAL, BEBIDA): ");
                    String categoriaStr = scanner.next().toUpperCase();
                    try {
                        Categoria categoria = Categoria.valueOf(categoriaStr);
                        var platosFiltrados = platoService.filtrarPlatos(presupuesto, categoria);
                        System.out.println("Platos recomendados:");
                        platosFiltrados.forEach(System.out::println);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Categoria invalida.");
                    }
                    break;
                case 2:
                    var top3 = platoService.top3Saludables();
                    System.out.println("Top 3 platos mas saludables:");
                    top3.forEach(System.out::println);
                    break;
                case 3:
                    var agrupados = platoService.agruparPorCategoria();
                    agrupados.forEach((cat, platos) -> {
                        System.out.println("Categoria: " + cat);
                        platos.forEach(System.out::println);
                    });
                    break;
                case 4:
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.println("\n=== INSERTAR NUEVO PLATO ===");
                    System.out.print("Nombre del plato: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Calorias: ");
                    int calorias = scanner.nextInt();
                    System.out.print("Categoria (VEGANO, DULCE, PICANTE, TRADICIONAL, BEBIDA): ");
                    String catStr = scanner.next().toUpperCase();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Nombre del stand: ");
                    String nombreStand = scanner.nextLine();
                    
                    try {
                        Categoria cat = Categoria.valueOf(catStr);
                        Stand stand = new Stand(nombreStand);
                        Plato nuevoPlato = new Plato(nombre, precio, calorias, cat, stand);
                        platoService.agregarPlato(nuevoPlato);
                        System.out.println("Plato agregado exitosamente!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Categoria invalida. El plato no fue agregado.");
                    }
                    break;
                case 5:
                    System.out.println("Gracias por usar el recomendador de platos. Hasta pronto!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
        
        scanner.close();
    }
}
