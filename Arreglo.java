package com.mycompany.mavenproject1;

import java.util.Scanner;

public class Arreglo {
    // Array bidimensional para las ventas: filas representan departamentos, columnas representan meses
    private double[][] ventas = {
            {1500.0, 1600.0, 1700.0, 1800.0, 1900.0, 2000.0, 2100.0, 2200.0, 2300.0, 2400.0, 2500.0, 2600.0}, // Ropa
            {1200.0, 1300.0, 1400.0, 1500.0, 1600.0, 1700.0, 1800.0, 1900.0, 2000.0, 2100.0, 2200.0, 2300.0}, // Deportes
            {1100.0, 1200.0, 1300.0, 1400.0, 1500.0, 1600.0, 1700.0, 1800.0, 1900.0, 2000.0, 2100.0, 2200.0}  // Juguetería
    };
    private final String[] departamentos = {"Ropa", "Deportes", "Juguetería"};
    private final String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};

    // Método para insertar ventas
    public void insertarVentas(int departamento, int mes, double venta) {
        if (validarDepartamento(departamento) && validarMes(mes)) {
            ventas[departamento][mes] = venta;
            System.out.println("Venta insertada correctamente.");
        } else {
            System.out.println("Departamento o mes inválido.");
        }
    }

    // Método para buscar ventas por departamento y mes
    public double buscarVenta(int departamento, int mes) {
        if (validarDepartamento(departamento) && validarMes(mes)) {
            return ventas[departamento][mes];
        } else {
            System.out.println("Departamento o mes inválido.");
            return -1;
        }
    }

    // Método para eliminar ventas de un departamento
    public void eliminarVentasDepartamento(int departamento) {
        if (validarDepartamento(departamento)) {
            for (int mes = 0; mes < 12; mes++) {
                ventas[departamento][mes] = 0;
            }
            System.out.println("Ventas eliminadas para el departamento " + departamentos[departamento]);
        } else {
            System.out.println("Departamento inválido.");
        }
    }

    // Método para validar el departamento
    private boolean validarDepartamento(int departamento) {
        return departamento >= 0 && departamento < 3;
    }

    // Método para validar el mes
    private boolean validarMes(int mes) {
        return mes >= 0 && mes < 12;
    }

    // Método para mostrar todas las ventas con diseño mejorado
    public void mostrarVentas() {
        System.out.println("Ventas Anuales por Departamento");
        System.out.println("----------------------------------------------------------");
        System.out.print("Departamento | ");
        for (String mes : meses) {
            System.out.printf("%6s ", mes);
        }
        System.out.println();
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < ventas.length; i++) {
            System.out.printf("%-12s | ", departamentos[i]);
            for (int j = 0; j < ventas[i].length; j++) {
                System.out.printf("%6.2f ", ventas[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------------");
    }

    public static void main(String[] args) {
        Arreglo va = new Arreglo();
        Scanner sc = new Scanner(System.in);
        int departamento, mes;
        double venta;
        int opcion;

        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Mostrar Ventas");
            System.out.println("2. Insertar/Modificar Venta");
            System.out.println("3. Buscar Venta");
            System.out.println("4. Eliminar Ventas de un Departamento");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    va.mostrarVentas();
                    break;
                case 2:
                    System.out.print("Ingrese el número del departamento (0=Ropa, 1=Deportes, 2=Juguetería): ");
                    departamento = sc.nextInt();
                    System.out.print("Ingrese el número del mes (0=Ene, 1=Feb, ..., 11=Dic): ");
                    mes = sc.nextInt();
                    System.out.print("Ingrese la venta a insertar/modificar: ");
                    venta = sc.nextDouble();
                    va.insertarVentas(departamento, mes, venta);
                    break;
                case 3:
                    System.out.print("Ingrese el número del departamento (0=Ropa, 1=Deportes, 2=Juguetería): ");
                    departamento = sc.nextInt();
                    System.out.print("Ingrese el número del mes (0=Ene, 1=Feb, ..., 11=Dic): ");
                    mes = sc.nextInt();
                    double resultado = va.buscarVenta(departamento, mes);
                    if (resultado != -1) {
                        System.out.println("Venta encontrada: " + resultado);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el número del departamento a eliminar (0=Ropa, 1=Deportes, 2=Juguetería): ");
                    departamento = sc.nextInt();
                    va.eliminarVentasDepartamento(departamento);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
