package com.parqueadero.domain;
import java.util.List;
import java.time.LocalDate;

public class VehiculoAprendiz {

    //Atributos
    private LocalDate fechaVinculacion;
    private LocalDate fechaTerminacion;
    private int estado;
    private String imageUrlCarnetSena;

    //Relaciones
    private Aprendiz aprendiz;
    private Vehiculo vehiculo;
    private Administrador administrador;
    private Centro centro;
    private List<EntSalAprendiz> entSalAprendizsList;

    //Constructores
    public VehiculoAprendiz() {}

    public VehiculoAprendiz(Aprendiz aprendiz, Vehiculo vehiculo, LocalDate fechaVinculacion, 
        LocalDate fechaTerminacion, int estado, Administrador administrador, Centro centro, 
        String imageUrlCarnetSena, List<EntSalAprendiz> entSalAprendizsList) {
        this.aprendiz = aprendiz;
        this.vehiculo = vehiculo;
        this.fechaVinculacion = fechaVinculacion;
        this.fechaTerminacion = fechaTerminacion;
        this.estado = estado;
        this.administrador = administrador;
        this.centro = centro;
        this.imageUrlCarnetSena = imageUrlCarnetSena;
        this.entSalAprendizsList = entSalAprendizsList;
    }

    //Getters y Setters
    public Aprendiz getAprendiz() { return aprendiz; }
    public void setAprendiz(Aprendiz aprendiz) { this.aprendiz = aprendiz;}

    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    public Administrador getAdministrador() { return administrador; }
    public void setAdministrador(Administrador administrador) { this.administrador = administrador; }

    public Centro getCentro() { return centro; }
    public void setCentro(Centro centro) { this.centro = centro; }

    public LocalDate getFechaVinculacion() { return fechaVinculacion; }
    public void setFechaVinculacion(LocalDate fechaVinculacion) { this.fechaVinculacion = fechaVinculacion; }

    public LocalDate getFechaTerminacion() { return fechaTerminacion; }
    public void setFechaTerminacion(LocalDate fechaTerminacion) { this.fechaTerminacion = fechaTerminacion; }

    public Integer getEstado() {return estado; }
    public void setEstado(int estado) { this.estado = estado; }

    public String getImageUrlCarnetSena() { return imageUrlCarnetSena; }
    public void setImageUrlCarnetSena(String imageUrlCarnetSena) { this.imageUrlCarnetSena = imageUrlCarnetSena; }

    public List<EntSalAprendiz> getEntSalAprendizsList() { return entSalAprendizsList; }
    public void setEntSalAprendizsList(List<EntSalAprendiz> entSalAprendizsList) { this.entSalAprendizsList = entSalAprendizsList; }
}