package com.example;

public class Vehiculo {
  private final String matricula;
  private String marca;
  private String modelo;
  private Cliente propietario;

  public Vehiculo(String matricula, String marca, String modelo, Cliente propietario) {
      this.matricula = matricula;
      this.marca = marca;
      this.modelo = modelo;
      this.propietario = propietario;
  }

  public String getMatricula() {
      return matricula;
  }

  public String getMarca() {
      return marca;
  }

  public void setMarca(String marca) {
      this.marca = marca;
  }

  public String getModelo() {
      return modelo;
  }

  public void setModelo(String modelo) {
      this.modelo = modelo;
  }

  public void mostrarInfoVehiculo() {
      System.out.println("Matrícula: " + matricula);
      System.out.println("Marca: " + marca);
      System.out.println("Modelo: " + modelo);
      System.out.println("Propietario: " + propietario.getNombre());
  }
}

