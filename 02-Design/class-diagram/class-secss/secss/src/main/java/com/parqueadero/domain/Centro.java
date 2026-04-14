package com.parqueadero.domain;
import java.util.List;

public class Centro {

    //Atributos
    private int id;

    //Relaciones
    private String nombreCentro;
    private List<VehiculoAprendiz> vehiculoAprendizsList;

    //Constructores
    public Centro() {}

    public Centro(int id, String nombreCentro, List<VehiculoAprendiz> vehiculoAprendizsList) {
        this.id = id;
        this.nombreCentro = nombreCentro;
        this.vehiculoAprendizsList = vehiculoAprendizsList;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreCentro() { return nombreCentro; }
    public void setNombreCentro(String nombreCentro) { this.nombreCentro = nombreCentro; }

    public List<VehiculoAprendiz> getVehiculoAprendizsList() { return vehiculoAprendizsList; }
    public void setVehiculoAprendizsList(List<VehiculoAprendiz> vehiculoAprendizsList) { this.vehiculoAprendizsList = vehiculoAprendizsList; }
}
