package com.example;

import java.util.ArrayList;

public class Cliente extends Persona {
  private ArrayList<Vehiculo> vehiculos;

  public Cliente(String nombre, String telefono) {
      super(nombre, telefono);
      this.vehiculos = new ArrayList<>();
  }

  public void agregarVehiculo(Vehiculo vehiculo) {
      vehiculos.add(vehiculo);
  }

  public ArrayList<Vehiculo> getVehiculos(){
    return vehiculos;
  }

  @Override
  public void mostrarInfo() {
      System.out.println("Nombre: " + getNombre());
      System.out.println("Teléfono: " + getTelefono());
      System.out.println("----Vehículos----");
      int cantidad = 1;
      for (Vehiculo vehiculo : vehiculos) {
          vehiculo.mostrarInfoVehiculo();
          cantidad++;
          System.out.println("\n----Vehiculo"+cantidad+"----");
      }
  }
}
