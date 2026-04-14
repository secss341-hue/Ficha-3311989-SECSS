package com.parqueadero.domain;

public class CuentaRol {
    
    //Atributos
    private String estado;

    //Relaciones
    private Cuenta cuenta;
    private Rol rol;

    //Constructores
    public CuentaRol() {
    }

    public CuentaRol(Cuenta cuenta, Rol rol, String estado) {
        this.cuenta = cuenta;
        this.rol = rol;
        this.estado = estado;
    }

    //Getters y Setters
    public Cuenta getCuenta() { return cuenta; }
    public void setCuenta(Cuenta cuenta) { this.cuenta = cuenta; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}