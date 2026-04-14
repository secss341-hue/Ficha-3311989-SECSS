package com.parqueadero.domain;
import java.time.LocalDateTime;

public class EntSalInvitado {

    //Atributos
    private int id;
    private LocalDateTime fechaHora;
    private String tipoIngreso;
    private String estado;

    //Relaciones
    private Celador celador;
    private ReporteEntSalInvitado reporteEntSalInvitado;
    private VehiculoInvitado vehiculoInvitado;

    //Constructores
    public EntSalInvitado() {}

    public EntSalInvitado(int id, LocalDateTime fechaHora, 
                                Celador celador, String tipoIngreso, String estado, ReporteEntSalInvitado reporteEntSalInvitado, VehiculoInvitado vehiculoInvitado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.celador = celador;
        this.tipoIngreso = tipoIngreso;
        this.estado = estado;
        this.reporteEntSalInvitado = reporteEntSalInvitado;
        this.vehiculoInvitado = vehiculoInvitado;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public Celador getCelador() { return celador; }
    public void setCelador(Celador celador) { this.celador = celador; }

    public String getTipoIngreso() { return tipoIngreso; }
    public void setTipoIngreso(String tipoIngreso) { this.tipoIngreso = tipoIngreso; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public ReporteEntSalInvitado getReporteEntSalInvitado() { return reporteEntSalInvitado; }
    public void setReporteEntSalInvitado(ReporteEntSalInvitado reporteEntSalInvitado) { this.reporteEntSalInvitado = reporteEntSalInvitado; }

    public VehiculoInvitado getVehiculoInvitado() { return vehiculoInvitado; }
    public void setVehiculoInvitado(VehiculoInvitado vehiculoInvitado) { this.vehiculoInvitado = vehiculoInvitado; }
}