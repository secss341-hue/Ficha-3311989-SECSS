package com.parqueadero.domain;
import java.util.List;

public class Celador {

    //Atributos
    private int id;

    //Relaciones
    private Usuario usuario;
    private List<JefeSeguridadCelador> jefeSeguridadCeladorsList;
    private List<EntSalAprendiz> entSalAprendizsList;
    private List<EntSalInvitado> entSalInvitadosList;
    private List<Reporte> reportesList;

    //Constructores
    public Celador() {}

    public Celador(int id, Usuario usuario, List<JefeSeguridadCelador> jefeSeguridadCeladorsList, List<EntSalAprendiz> entSalAprendizsList, List<EntSalInvitado> entSalInvitadosList, List<Reporte> reportesList) {
        this.id = id;
        this.usuario = usuario;
        this.jefeSeguridadCeladorsList = jefeSeguridadCeladorsList;
        this.entSalAprendizsList = entSalAprendizsList;
        this.entSalInvitadosList = entSalInvitadosList;
        this.reportesList = reportesList;

    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<JefeSeguridadCelador> getJefeSeguridadCeladorsList() { return jefeSeguridadCeladorsList; }
    public void setJefeSeguridadCeladorsList(List<JefeSeguridadCelador> jefeSeguridadCeladorsList) { this.jefeSeguridadCeladorsList = jefeSeguridadCeladorsList; }

    public List<EntSalAprendiz> getEntSalAprendizsList() { return entSalAprendizsList; }
    public void setEntSalAprendizsList(List<EntSalAprendiz> entSalAprendizsList) { this.entSalAprendizsList = entSalAprendizsList; }

    public List<EntSalInvitado> getEntSalInvitadosList() { return entSalInvitadosList; }
    public void setEntSalInvitadosList(List<EntSalInvitado> entSalInvitadosList) { this.entSalInvitadosList = entSalInvitadosList; }

    public List<Reporte> getReportesList() { return reportesList; }
    public void setReportesList(List<Reporte> reportesList) { this.reportesList = reportesList; }
}
