import java.util.Scanner;

public class Arreglo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int Departamentos = 3; // Ropa, Deportes, Juguetes
        int Meses = 12;
        double[][] ventas = new double[Departamentos][Meses];

        // Insertar ventas por departamento y mes
        insertarVentas(ventas, s);

        // Mostrar las ventas
        mostrarVentas(ventas);

        // Buscar un elemento en particular (por ejemplo, ventas de Ropa en marzo)
        buscarElemento(ventas, "Ropa", 3);

        // Eliminar las ventas de un departamento en particular (por ejemplo, Juguetes)
        eliminarVentasDepartamento(ventas, "Juguetes");

        s.close();
    }

    // Método para insertar las ventas
    public static void insertarVentas(double[][] ventas, Scanner s) {
        // Implementa la lógica para ingresar las ventas por departamento y mes
        // Puedes usar bucles para recorrer el arreglo y solicitar las ventas al usuario
    }

    // Método para mostrar las ventas
    public static void mostrarVentas(double[][] ventas) {
        // Implementa la lógica para mostrar las ventas por departamento y mes
    }

    // Método para buscar un elemento en particular
    public static void buscarElemento(double[][] ventas, String departamento, int mes) {
        // Implementa la lógica para buscar las ventas de un departamento en un mes específico
    }

    // Método para eliminar las ventas de un departamento en particular
    public static void eliminarVentasDepartamento(double[][] ventas, String departamento) {
        // Implementa la lógica para eliminar las ventas de un departamento
    }
}

