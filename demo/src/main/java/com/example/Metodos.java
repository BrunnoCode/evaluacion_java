package com.example;

import java.util.Scanner;

public class Metodos {

  public static void buildMain() {
    cleanScreen();
    putLine();
    System.out.println("Bien venido Al Taller VehiculoNostrum");
    putLine();
    Scanner scanner = new Scanner(System.in);
    Taller taller = new Taller("Taller de Vehículos");

    int opcion;

    do {
      System.out.println("\n--- Sistema de Gestión del Taller ---\n");
      System.out.println("1. Registrar Cliente");
      System.out.println("2. Registrar Vehículo");
      System.out.println("3. Registrar Reparación");
      System.out.println("4. Listar Reparaciones");
      System.out.println("5. Listar Clientes");
      System.out.println("6. Listar Vehiculos");
      System.out.println("7. Salir");


      System.out.print("Seleccione una opción: ");
      opcion = scanner.nextInt();
      scanner.nextLine();

      switch (opcion) {
        case 1:
          cleanScreen();
          timer("Preparando Formulario Registro de Cliente: ", 80);
          registrarCliente(scanner, taller);
          break;
        case 2:
          cleanScreen();
          timer("Preparando Registrador de Vehiculos ", 45);
          registrarVehiculo(scanner, taller);
          break;
        case 3:
          cleanScreen();
          timer("Preparando Registrar Reparaciones ", 50);
          registrarReparacion(scanner, taller);
          break;
        case 4:
          cleanScreen();
          timer("Listando Reparaciones ", 65);
          listarReparaciones(taller);
          break;
        case 5:
          cleanScreen();
          timer("Listando Clientes...", 65);
          listarClientes(taller);
          break;
        case 6:
          cleanScreen();
          timer("Listando Vehiculos: ", 65);
          listarVehiculos(taller);
          break;
        case 7:
          cleanScreen();
          timer("Saliendo del sistema... ", 65);
          break;
        default:
          System.out.println("Opción no válida, intente nuevamente.");
      }

    } while (opcion != 7);

    scanner.close();
  }

  // Método para registrar un nuevo cliente
  private static void registrarCliente(Scanner scanner, Taller taller) {
    System.out.print("Ingrese el nombre del cliente: ");
    String nombre = scanner.nextLine();
    System.out.print("Ingrese el teléfono del cliente: ");
    String telefono = scanner.nextLine();

    Cliente cliente = new Cliente(nombre, telefono);
    taller.registrarCliente(cliente);
    System.out.println("\nCliente registrado exitosamente.");
  }

  // Método para registrar un nuevo vehículo
  private static void registrarVehiculo(Scanner scanner, Taller taller) {
    System.out.print("Ingrese el nombre del cliente propietario: ");
    String nombreCliente = scanner.nextLine();

    // Buscar cliente por nombre
    Cliente cliente = null;
    for (Cliente c : taller.getClientes()) {
      if (c.getNombre().equalsIgnoreCase(nombreCliente)) {
        cliente = c;
        break;
      }
    }

    if (cliente == null) {
      System.out.println("\nCliente no encontrado. Debe registrar el cliente primero.");
      return;
    }

    System.out.print("Ingrese la matrícula del vehículo: ");
    String matricula = scanner.nextLine();
    System.out.print("Ingrese la marca del vehículo: ");
    String marca = scanner.nextLine();
    System.out.print("Ingrese el modelo del vehículo: ");
    String modelo = scanner.nextLine();

    Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, cliente);
    cliente.agregarVehiculo(vehiculo);
    System.out.println("\nVehículo registrado exitosamente.");
  }

  // Método para registrar una nueva reparación
  private static void registrarReparacion(Scanner scanner, Taller taller) {
    System.out.print("Ingrese la matrícula del vehículo a reparar: ");
    String matricula = scanner.nextLine();

    // Buscar el vehículo en la lista de clientes
    Vehiculo vehiculo = null;
    Cliente propietario = null;
    for (Cliente c : taller.getClientes()) {
      for (Vehiculo v : c.getVehiculos()) {
        if (v.getMatricula().equalsIgnoreCase(matricula)) {
          vehiculo = v;
          propietario = c;
          break;
        }
      }
      if (vehiculo != null)
        break;
    }

    if (vehiculo == null) {
      System.out.println("\nVehículo no encontrado. Debe registrar el vehículo primero.");
      return;
    }

    System.out.print("Ingrese la descripción de la reparación: ");
    String descripcion = scanner.nextLine();
    System.out.print("Ingrese el costo de la reparación: ");
    float costo = scanner.nextFloat();
    scanner.nextLine(); // limpiar el buffer

    Reparacion reparacion = new Reparacion(descripcion, costo, vehiculo.getMatricula(), vehiculo.getMarca(),
        vehiculo.getModelo(), propietario);
    taller.registrarReparacion(reparacion);
    System.out.println("\nReparación registrada exitosamente.");
  }

   // Método para listar todos los clientes registrados en el taller
   private static void listarClientes(Taller taller) {

    if (taller.getClientes().isEmpty()) {
      System.out.println("\nNo hay clientes registrados. Registre un cliente primero.");
      return;
  }
    System.out.println("\n--- Lista de Clientes ---");
    for (Cliente cliente : taller.getClientes()) {
        cliente.mostrarInfo();
        putLine();
    }
}

// Método para listar todas las reparaciones registradas en el taller
private static void listarReparaciones(Taller taller) {
  System.out.println("\n--- Lista de Reparaciones ---");

  if (taller.getReparaciones().isEmpty()) {
      System.out.println("\nNo hay reparaciones registradas. Registre una reparación primero.");
      return;
  }

  for (Reparacion reparacion : taller.getReparaciones()) {
      reparacion.mostrarInfoReparacion();
      System.out.println(); // Separador entre reparaciones
  }
}


// Método para listar todos los vehículos registrados en el taller
private static void listarVehiculos(Taller taller) {
  System.out.println("\n--- Lista de Vehículos ---");

  boolean hayVehiculos = false; // Control para verificar si al menos un vehículo existe

  for (Cliente cliente : taller.getClientes()) {
      if (!cliente.getVehiculos().isEmpty()) {
          hayVehiculos = true;
          System.out.println("Propietario: " + cliente.getNombre() + " (Tel: " + cliente.getTelefono() + ")");
          for (Vehiculo vehiculo : cliente.getVehiculos()) {
              vehiculo.mostrarInfoVehiculo();
          }
          System.out.println(); // Separador entre clientes
      }
  }

  if (!hayVehiculos) {
      System.out.println("\nNo hay vehículos registrados. Registre un vehículo primero.");
  }
}

  // Metodo de poner linea
  public static void putLine() {
    System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
  }

  // Metodo limpiar pantalla
  public static void cleanScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  // Metodo Timer causa un delay en pantalla
  public static void timer(String message, int time) {
    System.out.print(message);
    for (int i = 30; i > 0; i--) {
      System.out.print("/*");
      try {
        Thread.sleep(time);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println();
  }
}
