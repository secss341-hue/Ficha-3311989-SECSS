package com.parqueadero.domain;

public class Bicicleta {

    //Atributos
    private int id;
    private String numeroMarco;
    private String claseBicicleta;

    //Relaciones
    private Vehiculo vehiculo;

    //Constructores
    public Bicicleta() {}

    public Bicicleta(int id, Vehiculo vehiculo, String numeroMarco, String claseBicicleta) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.numeroMarco = numeroMarco;
        this.claseBicicleta = claseBicicleta;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    public String getNumeroMarco() { return numeroMarco; }
    public void setNumeroMarco(String numeroMarco) { this.numeroMarco = numeroMarco; }

    public String getClaseBicicleta() { return claseBicicleta; }
    public void setClaseBicicleta(String claseBicicleta) { this.claseBicicleta = claseBicicleta; }
}