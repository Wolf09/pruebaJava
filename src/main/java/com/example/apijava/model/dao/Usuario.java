package com.example.apijava.model.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    @Pattern(regexp = "[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}",message = "El Correo o email debe tener un formato similar a: aaaaaaa@dominio.cl")
    private String email;

    @Transient
    @Column(name = "password", insertable = false, updatable = false)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$",message = "El password debe estar entre 8 y 12 caracteres, Al menos: 1 Mayuscula, 1 minuscula, 1 numero, nose permiten espacios en blanco, 1 caracter especial")
    private String password;


    private String password2;

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp()
    private LocalDateTime created;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modified;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_login")
    private LocalDateTime lastLogin;


    @Column(name = "token", insertable = false, updatable = false)
    private String token;

    private Boolean isactive;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_uuid")
    private List<Telefono> phones;

    public Usuario() {
        this.phones=new ArrayList<>();
    }

    public Usuario(UUID uuid, String name, String email, String password, LocalDateTime created, LocalDateTime modified, LocalDateTime lastLogin, String token, Boolean isactive) {
        this();
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.token = token;
        this.isactive = isactive;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public List<Telefono> getPhones() {
        return phones;
    }

    public void setPhones(List<Telefono> phones) {
        this.phones = phones;
    }
    public void addPhones(Telefono telf){
        this.phones.add(telf);
    }

    @Serial
    private static final long serialVersionUID=1L;

    @Override
    public String toString() {
        return "Usuario{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", lastLogin=" + lastLogin +
                ", token='" + token + '\'' +
                ", isactive=" + isactive +
                ", phones=" + phones +
                '}';
    }
}
