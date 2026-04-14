package com.parqueadero.domain;
import java.util.List;

public class Usuario {
    
    //Atributos
    private int id;
    private int numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String nCelular;

    //Relaciones
    private TipoDocumento tipoDocumento;
    private Cuenta cuenta;
    private Aprendiz aprendiz;
    private Administrador administrador;
    private Celador celador;
    private JefeSeguridad jefeSeguridad;
    private List<Pqrs> pqrsList;
    private List<VehiculoInvitado> vehiculoInvitadosList;

    //Constructores
    public Usuario() {
    }

    public Usuario(int id, TipoDocumento tipoDocumento, int numeroDocumento, 
                   String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Cuenta cuenta, String nCelular, List<Pqrs> pqrsList, List<VehiculoInvitado> vehiculoInvitadosList, Aprendiz aprendiz, Administrador administrador, Celador celador, JefeSeguridad jefeSeguridad) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cuenta = cuenta;
        this.nCelular = nCelular;
        this.pqrsList = pqrsList;
        this.vehiculoInvitadosList = vehiculoInvitadosList;
        this.aprendiz = aprendiz;
        this.administrador = administrador;
        this.celador = celador;
        this.jefeSeguridad = jefeSeguridad;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public TipoDocumento getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(TipoDocumento tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public int getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(int numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public String getPrimerNombre() { return primerNombre; }
    public void setPrimerNombre(String primerNombre) { this.primerNombre = primerNombre; }

    public String getSegundoNombre() { return segundoNombre; }
    public void setSegundoNombre(String segundoNombre) { this.segundoNombre = segundoNombre; }

    public String getPrimerApellido() { return primerApellido; }
    public void setPrimerApellido(String primerApellido) { this.primerApellido = primerApellido; }

    public String getSegundoApellido() { return segundoApellido; }
    public void setSegundoApellido(String segundoApellido) { this.segundoApellido = segundoApellido; }

    public Cuenta getCuenta() { return cuenta; }
    public void setCuenta(Cuenta cuenta) { this.cuenta = cuenta; }

    public Aprendiz getAprendiz() { return aprendiz; }
    public void setAprendiz(Aprendiz aprendiz) { this.aprendiz = aprendiz; }

    public Administrador getAdministrador() { return administrador; }
    public void setAdministrador(Administrador administrador) { this.administrador = administrador; }

    public Celador getCelador() { return celador; }
    public void setCelador(Celador celador) { this.celador = celador; }

    public JefeSeguridad getJefeSeguridad() { return jefeSeguridad; }
    public void setJefeSeguridad(JefeSeguridad jefeSeguridad) { this.jefeSeguridad = jefeSeguridad; }

    public String getnCelular() { return nCelular; }
    public void setnCelular(String nCelular) { this.nCelular = nCelular; }

    public List<Pqrs> getPqrsList() { return pqrsList; }
    public void setPqrsList(List<Pqrs> pqrsList) { this.pqrsList = pqrsList; }

    public List<VehiculoInvitado> getVehiculoInvitadosList() { return vehiculoInvitadosList; }
    public void setVehiculoInvitadosList(List<VehiculoInvitado> vehiculoInvitadosList) { this.vehiculoInvitadosList = vehiculoInvitadosList; }
}
