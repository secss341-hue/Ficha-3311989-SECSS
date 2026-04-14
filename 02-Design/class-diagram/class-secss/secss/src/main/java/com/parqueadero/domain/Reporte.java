package com.parqueadero.domain;
import java.time.LocalDateTime;

public class Reporte {

    //Atributos
    private int id;
    private LocalDateTime fechaHora;
    private String asunto;
    private String cuerpo;
    private String estado;

    //Relaciones
    private TipoReporte tipoReporte;
    private Celador celador;
    private ReporteEntSalAprediz reporteEntSalAprediz;
    private ReporteEntSalInvitado reporteEntSalInvitado;

    //Constructores
    public Reporte() {}

    public Reporte(int id, TipoReporte tipoReporte, Celador celador, LocalDateTime fechaHora, 
        String asunto, String cuerpo, String estado, ReporteEntSalAprediz reporteEntSalAprediz, ReporteEntSalInvitado reporteEntSalInvitado) {
        this.id = id;
        this.tipoReporte = tipoReporte;
        this.celador = celador;
        this.fechaHora = fechaHora;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.estado = estado;
        this.reporteEntSalAprediz = reporteEntSalAprediz;
        this.reporteEntSalInvitado = reporteEntSalInvitado;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public TipoReporte getTipoReporte() { return tipoReporte; }
    public void setTipoReporte(TipoReporte tipoReporte) { this.tipoReporte = tipoReporte; }

    public Celador getCelador() { return celador; }
    public void setCelador(Celador celador) { this.celador = celador; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getCuerpo() { return cuerpo; }
    public void setCuerpo(String cuerpo) { this.cuerpo = cuerpo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public ReporteEntSalAprediz getReporteEntSalAprediz() { return reporteEntSalAprediz; }
    public void setReporteEntSalAprediz(ReporteEntSalAprediz reporteEntSalAprediz) { this.reporteEntSalAprediz = reporteEntSalAprediz; }

    public ReporteEntSalInvitado getReporteEntSalInvitado() { return reporteEntSalInvitado; }
    public void setReporteEntSalInvitado(ReporteEntSalInvitado reporteEntSalInvitado) { this.reporteEntSalInvitado = reporteEntSalInvitado; }
}