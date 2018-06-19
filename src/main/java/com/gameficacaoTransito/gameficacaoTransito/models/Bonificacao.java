package com.gameficacaoTransito.gameficacaoTransito.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Bonificacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    private Integer dpvat;

    private Integer ipva;

    private Integer usuario;

    public Bonificacao() {
    }

    public Bonificacao(Integer dpvat, Integer ipva, Integer usuario) {
        this.dpvat = dpvat;
        this.ipva = ipva;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDpvat() {
        return dpvat;
    }

    public void setDpvat(Integer dpvat) {
        this.dpvat = dpvat;
    }

    public Integer getIpva() {
        return ipva;
    }

    public void setIpva(Integer ipva) {
        this.ipva = ipva;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }
}