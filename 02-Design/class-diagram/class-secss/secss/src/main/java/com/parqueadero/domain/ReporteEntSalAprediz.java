package com.parqueadero.domain;

public class ReporteEntSalAprediz {

    //Atributos
    private int id;

    //Relaciones
    private Reporte reporte;
    private EntSalAprendiz entSalAprendiz;

    //Constructores
    public ReporteEntSalAprediz() {}

    public ReporteEntSalAprediz(int id, Reporte reporte, EntSalAprendiz entSalAprendiz) {
        this.id = id;
        this.reporte = reporte;
        this.entSalAprendiz = entSalAprendiz;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Reporte getReporte() { return reporte; }
    public void setReporte(Reporte reporte) { this.reporte = reporte; }
    
    public EntSalAprendiz getEntSalAprendiz() { return entSalAprendiz; }
    public void setEntSalAprendiz(EntSalAprendiz entSalAprendiz) { this.entSalAprendiz = entSalAprendiz; }
}
