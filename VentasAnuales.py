class VentasAnuales:
    def __init__(self):
        # Inicializa el arreglo bidimensional con ventas de los 3 departamentos para 12 meses
        self.departamentos = ["Ropa", "Deportes", "Juguetería"]
        self.meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                      "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]
        self.ventas = [[0.0 for _ in range(12)] for _ in range(3)]

    def insertar_ventas(self, departamento, mes, venta):
        # Inserta o modifica una venta en la posición especificada
        if self.validar_departamento(departamento) and self.validar_mes(mes):
            self.ventas[departamento][mes] = venta
            print(f"Venta insertada/modificada para {self.departamentos[departamento]} en {self.meses[mes]}: {venta}")
        else:
            print("Error: Departamento o mes inválido.")

    def buscar_venta(self, departamento, mes):
        # Busca una venta específica y la devuelve
        if self.validar_departamento(departamento) and self.validar_mes(mes):
            venta = self.ventas[departamento][mes]
            print(f"Venta encontrada para {self.departamentos[departamento]} en {self.meses[mes]}: {venta}")
            return venta
        else:
            print("Error: Departamento o mes inválido.")
            return -1

    def eliminar_ventas_departamento(self, departamento):
        # Elimina todas las ventas de un departamento (las pone en cero)
        if self.validar_departamento(departamento):
            self.ventas[departamento] = [0.0] * 12
            print(f"Todas las ventas del departamento {self.departamentos[departamento]} han sido eliminadas.")
        else:
            print("Error: Departamento inválido.")

    def validar_departamento(self, departamento):
        # Valida que el índice del departamento sea válido
        return 0 <= departamento < len(self.departamentos)

    def validar_mes(self, mes):
        # Valida que el índice del mes sea válido
        return 0 <= mes < len(self.meses)

    def mostrar_ventas(self):
        # Muestra las ventas en formato tabular para mejor claridad
        print("\nVentas Anuales:")
        print(f"{'Departamento':<12} | " + " | ".join([f"{mes:<9}" for mes in self.meses]))
        print("-" * 150)
        for i, departamento in enumerate(self.departamentos):
            ventas_str = " | ".join([f"{venta:<9.2f}" for venta in self.ventas[i]])
            print(f"{departamento:<12} | {ventas_str}")
        print("-" * 150)

def menu():
    sistema_ventas = VentasAnuales()
    while True:
        print("\n--- Menú de Opciones ---")
        print("1. Mostrar Ventas")
        print("2. Insertar/Modificar Venta")
        print("3. Buscar Venta")
        print("4. Eliminar Ventas de un Departamento")
        print("5. Salir")
        
        opcion = input("Seleccione una opción: ")
        
        if opcion == '1':
            sistema_ventas.mostrar_ventas()
        elif opcion == '2':
            departamento = int(input("Ingrese el índice del departamento (0-Ropa, 1-Deportes, 2-Juguetería): "))
            mes = int(input("Ingrese el índice del mes (0-Enero, 1-Febrero, ..., 11-Diciembre): "))
            venta = float(input("Ingrese el valor de la venta: "))
            sistema_ventas.insertar_ventas(departamento, mes, venta)
        elif opcion == '3':
            departamento = int(input("Ingrese el índice del departamento (0-Ropa, 1-Deportes, 2-Juguetería): "))
            mes = int(input("Ingrese el índice del mes (0-Enero, 1-Febrero, ..., 11-Diciembre): "))
            sistema_ventas.buscar_venta(departamento, mes)
        elif opcion == '4':
            departamento = int(input("Ingrese el índice del departamento (0-Ropa, 1-Deportes, 2-Juguetería): "))
            sistema_ventas.eliminar_ventas_departamento(departamento)
        elif opcion == '5':
            print("Saliendo del programa...")
            break
        else:
            print("Opción no válida. Por favor, seleccione una opción del 1 al 5.")

if __name__ == "__main__":
    menu()
