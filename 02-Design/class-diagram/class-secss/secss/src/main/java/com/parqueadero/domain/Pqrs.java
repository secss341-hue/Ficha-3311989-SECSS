package com.parqueadero.domain;
import java.time.LocalDateTime;

public class Pqrs {

    //Atributos
    private int id;
    private LocalDateTime fechaHora;
    private String asunto;
    private String cuerpo;
    private String estado;

    //Relaciones
    private Usuario usuario;
    private Respuesta respuesta;

    //Constructores
    public Pqrs() {}

    public Pqrs(int id, Usuario usuario, LocalDateTime fechaHora, String asunto, String cuerpo, 
        String estado, Respuesta respuesta) {
        this.id = id;
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.estado = estado;
        this.respuesta = respuesta;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getCuerpo() { return cuerpo; }
    public void setCuerpo(String cuerpo) { this.cuerpo = cuerpo; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Respuesta getRespuesta() { return respuesta; }
    public void setRespuesta(Respuesta respuesta) { this.respuesta = respuesta; }
}