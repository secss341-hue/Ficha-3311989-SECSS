package com.parqueadero.domain;
import java.util.List;

public class Rol {
    
    //Atributos
    private int id;
    private String rol;

    //Relaciones
    private List<CuentaRol> cuentaRolsList;

    //Constructores
    public Rol() {
    }

    public Rol(int id, String rol, List<CuentaRol> cuentaRolsList) {
        this.id = id;
        this.rol = rol;
        this.cuentaRolsList = cuentaRolsList;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public List<CuentaRol> getCuentaRolsList() { return cuentaRolsList; }
    public void setCuentaRolsList(List<CuentaRol> cuentaRolsList) { this.cuentaRolsList = cuentaRolsList; }
}