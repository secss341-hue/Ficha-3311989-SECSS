package com.parqueadero.domain;

import java.util.List;

public class Vehiculo {

    //Atributos
    private int id;
    private String marca;
    private String color;
    private String imageUrlTarjetaPropiedad;
    private String imageUrlIdentificacionVehiculo;
    private String imageUrlVehiculo;

    //Relaciones
    private TipoVehiculo tipoVehiculo;
    private Moto moto;
    private Bicicleta bicicleta;
    private List<VehiculoAprendiz> vehiculoAprendizsList;
    private List<VehiculoInvitado> vehiculoInvitadosList;

    //Constructores
    public Vehiculo() {}

    public Vehiculo(int id, TipoVehiculo tipoVehiculo, String marca, String color, 
        String imageUrlTarjetaPropiedad, String imageUrlIdentificacionVehiculo, String imageUrlVehiculo, Moto moto, Bicicleta bicicleta, List<VehiculoAprendiz> vehiculoAprendizsList, List<VehiculoInvitado> vehiculoInvitadosList) {
        this.id = id;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.color = color;
        this.imageUrlTarjetaPropiedad = imageUrlTarjetaPropiedad;
        this.imageUrlIdentificacionVehiculo = imageUrlIdentificacionVehiculo;
        this.imageUrlVehiculo = imageUrlVehiculo;
        this.moto = moto;
        this.bicicleta = bicicleta;
        this.vehiculoAprendizsList = vehiculoAprendizsList;
        this.vehiculoInvitadosList = vehiculoInvitadosList;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public TipoVehiculo getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getImageUrlTarjetaPropiedad() { return imageUrlTarjetaPropiedad; }
    public void setImageUrlTarjetaPropiedad(String imageUrlTarjetaPropiedad) { this.imageUrlTarjetaPropiedad = imageUrlTarjetaPropiedad; }

    public String getImageUrlIdentificacionVehiculo() { return imageUrlIdentificacionVehiculo; }
    public void setImageUrlIdentificacionVehiculo(String imageUrlIdentificacionVehiculo) { this.imageUrlIdentificacionVehiculo = imageUrlIdentificacionVehiculo; }

    public String getImageUrlVehiculo() { return imageUrlVehiculo; }
    public void setImageUrlVehiculo(String imageUrlVehiculo) { this.imageUrlVehiculo = imageUrlVehiculo; }

    public Moto getMoto() { return moto; }
    public void setMoto(Moto moto) { this.moto = moto; }

    public Bicicleta getBicicleta() { return bicicleta; }
    public void setBicicleta(Bicicleta bicicleta) { this.bicicleta = bicicleta; }

    public List<VehiculoAprendiz> getVehiculoAprendizsList() { return vehiculoAprendizsList; }
    public void setVehiculoAprendizsList(List<VehiculoAprendiz> vehiculoAprendizsList) { this.vehiculoAprendizsList = vehiculoAprendizsList; }

    public List<VehiculoInvitado> getVehiculoInvitadosList() { return vehiculoInvitadosList; }
    public void setVehiculoInvitadosList(List<VehiculoInvitado> vehiculoInvitadosList) { this.vehiculoInvitadosList = vehiculoInvitadosList; }

}