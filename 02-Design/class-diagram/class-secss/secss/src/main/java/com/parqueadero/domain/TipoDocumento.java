package com.parqueadero.domain;
import java.util.List;

public class TipoDocumento {

    //Atributos
    private int id;
    private String sigla;
    private String nombreDocumento;
    private String estado;

    //Relaciones
    private List<Usuario> usuariosList;

    //Constructores
    public TipoDocumento() {
    }

    public TipoDocumento(int id, String sigla, String nombreDocumento, String estado, List<Usuario> usuariosList) {
        this.id = id;
        this.sigla = sigla;
        this.nombreDocumento = nombreDocumento;
        this.estado = estado;
        this.usuariosList = usuariosList;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }

    public String getNombreDocumento() { return nombreDocumento; }
    public void setNombreDocumento(String nombreDocumento) { this.nombreDocumento = nombreDocumento; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public List<Usuario> getUsuariosList() { return usuariosList; }
    public void setUsuariosList(List<Usuario> usuariosList) { this.usuariosList = usuariosList; }
}
