package com.parqueadero.domain;
import java.time.LocalDateTime;

public class EntSalAprendiz {

    //Atributos
    private int id;
    private LocalDateTime fechaHora;
    private String tipoIngreso;
    private String estado;

    //Relaciones
    private Celador celador;
    private ReporteEntSalAprediz reporteEntSalAprediz;
    private VehiculoAprendiz vehiculoAprendiz;

    //Constructores
    public EntSalAprendiz() {
    }

    public EntSalAprendiz(int id, LocalDateTime fechaHora, 
                                Celador celador, String tipoIngreso, String estado, ReporteEntSalAprediz reporteEntSalAprediz, VehiculoAprendiz vehiculoAprendiz) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.celador = celador;
        this.tipoIngreso = tipoIngreso;
        this.estado = estado;
        this.reporteEntSalAprediz = reporteEntSalAprediz;
        this.vehiculoAprendiz = vehiculoAprendiz;

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

    public ReporteEntSalAprediz getReporteEntSalAprediz() { return reporteEntSalAprediz; }
    public void setReporteEntSalAprediz(ReporteEntSalAprediz reporteEntSalAprediz) { this.reporteEntSalAprediz = reporteEntSalAprediz; }

    public VehiculoAprendiz getVehiculoAprendiz() { return vehiculoAprendiz; }
    public void setVehiculoAprendiz(VehiculoAprendiz vehiculoAprendiz) { this.vehiculoAprendiz = vehiculoAprendiz; }

}