package com.example;

public class Reparacion {
  private Vehiculo vehiculo;
  private String descripcion;
  private float costo;

  public Reparacion(String descripcion, float costo, String matricula, String marca, String modelo, Cliente propietario) {
      this.vehiculo = new Vehiculo(matricula, marca, modelo, propietario);
      this.descripcion = descripcion;
      this.costo = costo;
  }

  public void mostrarInfoReparacion() {
      System.out.println("Descripción: " + descripcion);
      System.out.println("Costo: " + costo+"€");
      vehiculo.mostrarInfoVehiculo();
  }
}

