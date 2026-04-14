package com.parqueadero.domain;
import java.util.List;

public class TipoReporte {

    //Atributos
    private int id;
    private String nombreReporte;

    //Relaciones
    private List<Reporte> reportesList;


    //Constructores
    public TipoReporte() {}

    public TipoReporte(int id, String nombreReporte, List<Reporte> reportesList) {
        this.id = id;
        this.nombreReporte = nombreReporte;
        this.reportesList = reportesList;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNombreReporte() { return nombreReporte; }
    public void setNombreReporte(String nombreReporte) { this.nombreReporte = nombreReporte; }

    public List<Reporte> getReportesList() { return reportesList; }
    public void setReportesList(List<Reporte> reportesList) { this.reportesList = reportesList; }
}