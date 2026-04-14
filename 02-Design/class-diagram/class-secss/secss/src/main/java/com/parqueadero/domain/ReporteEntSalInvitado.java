package com.parqueadero.domain;

public class ReporteEntSalInvitado {

    //Atributos
    private int id;

    //Relaciones
    private Reporte reporte;
    private EntSalInvitado entSalInvitado;

    //Constructores
    public ReporteEntSalInvitado() {}

    public ReporteEntSalInvitado(Integer id, Reporte reporte, EntSalInvitado entSalInvitado) {
        this.id = id;
        this.reporte = reporte;
        this.entSalInvitado = entSalInvitado;
    }

    //Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Reporte getReporte() { return reporte; }
    public void setReporte(Reporte reporte) { this.reporte = reporte; }

    public EntSalInvitado getEntSalInvitado() { return entSalInvitado; }
    public void setEntSalInvitado(EntSalInvitado entSalInvitado) { this.entSalInvitado = entSalInvitado; }
}
