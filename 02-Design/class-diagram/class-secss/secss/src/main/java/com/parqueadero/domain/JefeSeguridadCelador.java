package com.parqueadero.domain;

public class JefeSeguridadCelador {

    //Relaciones
    private Celador celador;
    private JefeSeguridad jefeSeguridad;

    //Constructores
    public JefeSeguridadCelador() {}

    public JefeSeguridadCelador(JefeSeguridad jefeSeguridad, Celador celador) {
        this.jefeSeguridad = jefeSeguridad;
        this.celador = celador;
    }

    //Getters y Setters
    public JefeSeguridad getJefeSeguridad() { return jefeSeguridad; }
    public void setJefeSeguridad(JefeSeguridad jefeSeguridad) { this.jefeSeguridad = jefeSeguridad; }
    
    public Celador getCelador() { return celador; }
    public void setCelador(Celador celador) { this.celador = celador; }
}