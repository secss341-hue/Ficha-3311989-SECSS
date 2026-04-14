package com.parqueadero.domain;
import java.time.LocalDateTime;
import java.util.List;

public class Cuenta {

    //Atributos
    private int id;
    private String correo;
    private String contrasena;
    private String login;
    private Integer activated;
    private String langKey;
    private String imageUrl;
    private String activationKey;
    private String resetKey;
    private LocalDateTime resetDate;

    //Relaciones
    private Usuario usuario;
    private List<CuentaRol> cuentaRolsList;

    //Constructores
    public Cuenta() {}

    public Cuenta(int id, String correo, String login, String contrasena, Integer activated, String langKey, String imageUrl, String activationKey, String resetKey, LocalDateTime resetDate, Usuario usuario, List<CuentaRol> cuentaRolsList) {
        this.id = id;
        this.correo = correo;
        this.login = login;
        this.contrasena = contrasena;
        this.activated = activated;
        this.langKey = langKey;
        this.imageUrl = imageUrl;
        this.activationKey = activationKey;
        this.resetKey = resetKey;
        this.resetDate = resetDate;
        this.usuario = usuario;
        this.cuentaRolsList = cuentaRolsList;
    }

    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public Integer getActivated() { return activated; }
    public void setActivated(Integer activated) { this.activated = activated; }

    public String getLangKey() { return langKey; }
    public void setLangKey(String langKey) { this.langKey = langKey; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getActivationKey() { return activationKey; }
    public void setActivationKey(String activationKey) { this.activationKey = activationKey; }

    public String getResetKey() { return resetKey; }
    public void setResetKey(String resetKey) { this.resetKey = resetKey; }
    
    public LocalDateTime getResetDate() { return resetDate; }
    public void setResetDate(LocalDateTime resetDate) { this.resetDate = resetDate; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<CuentaRol> getCuentaRolsList() { return cuentaRolsList; }
    public void setCuentaRolsList(List<CuentaRol> cuentaRolsList) { this.cuentaRolsList = cuentaRolsList; }
}
