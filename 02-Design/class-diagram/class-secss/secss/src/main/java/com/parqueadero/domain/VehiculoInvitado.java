package com.parqueadero.domain;
import java.util.List;

public class VehiculoInvitado {

    //Relaciones
    private Usuario usuario;
    private Vehiculo vehiculo;
    private List<EntSalInvitado> entSalInvitadosList;

    //Constructores
    public VehiculoInvitado() {}

    public VehiculoInvitado(Usuario usuario, Vehiculo vehiculo, List<EntSalInvitado> entSalInvitadosList) {
        this.entSalInvitadosList = entSalInvitadosList;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
    }

    // Getters y Setters
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    public List<EntSalInvitado> getEntSalInvitadosList() { return entSalInvitadosList; }
    public void setEntSalInvitadosList(List<EntSalInvitado> entSalInvitadosList) { this.entSalInvitadosList = entSalInvitadosList; }
}
