package com.example;

import java.util.ArrayList;

public class Taller {
    private String nombre;
    private ArrayList<Cliente> clientes;
    private ArrayList<Reparacion> reparaciones;

    public Taller(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
        this.reparaciones = new ArrayList<>();
    }

    public String getNombreTaller(){
      return nombre;
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Cliente> getClientes(){
      return clientes;
    }

    public void registrarReparacion(Reparacion reparacion) {
        reparaciones.add(reparacion);
    }

    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public static int contarReparaciones(ArrayList<Reparacion> reparaciones) {
        return reparaciones.size();
    }
}

