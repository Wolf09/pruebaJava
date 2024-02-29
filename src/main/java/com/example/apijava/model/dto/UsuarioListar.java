package com.example.apijava.model.dto;

import com.example.apijava.model.dao.Telefono;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class UsuarioListar {


    private UUID uuid;
    private String name;

    private String email;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modified;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime last_Login;

    private String token;

    private Boolean isactive;


    private List<Telefono> phones;

    public UsuarioListar(UUID uuid, String name, String email, LocalDateTime created, LocalDateTime modified, LocalDateTime last_Login, String token, Boolean isactive,List<Telefono> phones) {

        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.created = created;
        this.modified = modified;
        this.last_Login = last_Login;
        this.token = token;
        this.isactive = isactive;
        this.phones=phones;
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



    @Override
    public String toString() {
        return "Usuario{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", last_Login=" + last_Login +
                ", token='" + token + '\'' +
                ", isactive=" + isactive +
                ", phones=" + phones +
                '}';
    }


}
