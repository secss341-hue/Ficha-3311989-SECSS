package com.parqueadero.domain;
import java.util.List;

public class JefeSeguridad {

    //Atributos
    private int id;

    //Relaciones
    private Usuario usuario;
    private List<JefeSeguridadCelador> jefeSeguridadCeladorsList;

    //Constructores
    public JefeSeguridad() {}

    public JefeSeguridad(int id, Usuario usuario, List<JefeSeguridadCelador> jefeSeguridadCeladorsList) {
        this.id = id;
        this.usuario = usuario;
        this.jefeSeguridadCeladorsList = jefeSeguridadCeladorsList;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<JefeSeguridadCelador> getJefeSeguridadCeladorsList() { return jefeSeguridadCeladorsList; }
    public void setJefeSeguridadCeladorsList(List<JefeSeguridadCelador> jefeSeguridadCeladorsList) { this.jefeSeguridadCeladorsList = jefeSeguridadCeladorsList; }
}