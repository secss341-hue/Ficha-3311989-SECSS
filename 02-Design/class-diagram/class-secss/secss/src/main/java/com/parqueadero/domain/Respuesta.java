package com.parqueadero.domain;

public class Respuesta {
    //Atributos
    private int id;
    private String asunto;
    private String cuerpo;

    //Relaciones
    private Pqrs pqrs;
    private Administrador administrador;

    //Constructores
    public Respuesta() {
    }

    public Respuesta(int id, Pqrs pqrs, Administrador administrador, String asunto, String cuerpo) {
        this.id = id;
        this.pqrs = pqrs;
        this.administrador = administrador;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Pqrs getPqrs() { return pqrs; }
    public void setPqrs(Pqrs pqrs) { this.pqrs = pqrs; }

    public Administrador getAdministrador() { return administrador; }
    public void setAdministrador(Administrador administrador) { this.administrador = administrador; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getCuerpo() { return cuerpo; }
    public void setCuerpo(String cuerpo) { this.cuerpo = cuerpo; }
}