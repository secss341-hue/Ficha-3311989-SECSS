package com.parqueadero.domain;
import java.util.List;

public class Aprendiz {

    //Atributos
    private int id;
    private Integer ficha;
    private String imageUrlAprendiz;
    private String direccion;
    private String imageUrlIdentificacion;

    //Relaciones
    private Usuario usuario;
    private List<VehiculoAprendiz> vehiculoAprendizsList;

    //Constructores
    public Aprendiz() {
    }

    public Aprendiz(int id, Usuario usuario, Integer ficha, String direccion, String imageUrlAprendiz, 
        String imageUrlIdentificacion, List<VehiculoAprendiz> vehiculoAprendizsList) {
        this.id = id;
        this.usuario = usuario;
        this.ficha = ficha;
        this.direccion = direccion;
        this.imageUrlAprendiz = imageUrlAprendiz;
        this.imageUrlIdentificacion = imageUrlIdentificacion;
        this.vehiculoAprendizsList = vehiculoAprendizsList;

    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Integer getFicha() { return ficha; }
    public void setFicha(Integer ficha) { this.ficha = ficha; }

    public String getImageUrlAprendiz() { return imageUrlAprendiz; }
    public void setImageUrlAprendiz(String imageUrlAprendiz) { this.imageUrlAprendiz = imageUrlAprendiz; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getImageUrlIdentificacion() { return imageUrlIdentificacion; }
    public void setImageUrlIdentificacion(String imageUrlIdentificacion) { this.imageUrlIdentificacion = imageUrlIdentificacion; }

    public List<VehiculoAprendiz> getVehiculoAprendizsList() { return vehiculoAprendizsList; }
    public void setVehiculoAprendizsList(List<VehiculoAprendiz> vehiculoAprendizsList) { this.vehiculoAprendizsList = vehiculoAprendizsList; }

}
