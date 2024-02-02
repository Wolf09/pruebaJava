package com.example.apijava.model.dao;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "phones")
public class Telefono implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String number;

    private String citycode;

    private String contrycode;

    public Telefono() {
    }

    public Telefono(String number, String citycode, String countrycode) {
        this.number = number;
        this.citycode = citycode;
        this.contrycode = countrycode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getContrycode() {
        return contrycode;
    }

    public void setContrycode(String countrycode) {
        this.contrycode = countrycode;
    }

    @Serial
    private static final long serialVersionUID=1L;
}
