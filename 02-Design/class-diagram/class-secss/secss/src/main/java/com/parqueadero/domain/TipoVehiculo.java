package com.parqueadero.domain;
import java.util.List;

public class TipoVehiculo {

    //Atributos
    private int id;
    private String nombreVehiculo;

    //Relaciones
    private List<Vehiculo> vehiculosList;

    //Constructores
    public TipoVehiculo() {}

    public TipoVehiculo(Integer id, String nombreVehiculo, List<Vehiculo> vehiculosList) {
        this.id = id;
        this.nombreVehiculo = nombreVehiculo;
        this.vehiculosList = vehiculosList;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreVehiculo() { return nombreVehiculo; }
    public void setNombreVehiculo(String nombreVehiculo) { this.nombreVehiculo = nombreVehiculo; }

    public List<Vehiculo> getVehiculosList() { return vehiculosList; }
    public void setVehiculosList(List<Vehiculo> vehiculosList) { this.vehiculosList = vehiculosList; }
}