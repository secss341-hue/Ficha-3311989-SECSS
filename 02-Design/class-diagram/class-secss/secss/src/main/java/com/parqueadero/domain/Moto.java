package com.parqueadero.domain;

public class Moto {

    //Atributos
    private int id;
    private String placa;
    private String cilindraje;
    private String modelo;
    private String imageUrlSoat;
    private String imageUrlTecnomecanicaVigente;

    //Relaciones
    private Vehiculo vehiculo;

    //Constructores
    public Moto() {}

    public Moto(int id, Vehiculo vehiculo, String placa, String cilindraje, String modelo, 
        String imageUrlSoat, String imageUrlTecnomecanicaVigente) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.placa = placa;
        this.cilindraje = cilindraje;
        this.modelo = modelo;
        this.imageUrlSoat = imageUrlSoat;
        this.imageUrlTecnomecanicaVigente = imageUrlTecnomecanicaVigente;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getCilindraje() { return cilindraje; }
    public void setCilindraje(String cilindraje) { this.cilindraje = cilindraje; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getImageUrlSoat() { return imageUrlSoat; }
    public void setImageUrlSoat(String imageUrlSoat) { this.imageUrlSoat = imageUrlSoat; }

    public String getImageUrlTecnomecanicaVigente() { return imageUrlTecnomecanicaVigente; }
    public void setImageUrlTecnomecanicaVigente(String imageUrlTecnomecanicaVigente) { this.imageUrlTecnomecanicaVigente = imageUrlTecnomecanicaVigente; }
}