package com.parqueadero.domain;
import java.util.List;

public class Administrador {

    //Atributos
    private int id;

    //Relaciones
    private Usuario usuario;
    public List<Respuesta> respuestasList;
    public List<VehiculoAprendiz> vehiculoAprendizsList;

    //Constructores
    public Administrador() {}

    public Administrador(int id, Usuario usuario, List<Respuesta> respuestasList, List<VehiculoAprendiz> vehiculoAprendizsList) {
        this.id = id;
        this.usuario = usuario;
        this.respuestasList = respuestasList;
        this.vehiculoAprendizsList = vehiculoAprendizsList;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Respuesta getRespuesta() { return respuestasList.get(0); } // Assuming the first respuesta is the one to return
    public void setRespuesta(Respuesta respuesta) { this.respuestasList.add(respuesta); }

    public List<VehiculoAprendiz> getVehiculoAprendizsList() { return vehiculoAprendizsList; }
    public void setVehiculoAprendizsList(List<VehiculoAprendiz> vehiculoAprendizsList) { this.vehiculoAprendizsList = vehiculoAprendizsList; }
}
