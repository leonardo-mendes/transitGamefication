package com.gameficacaoTransito.gameficacaoTransito.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String modelo;

    private String placa;

    private String renavam;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "veiculo")
    private List<InfracaoUsuario> infracaoUsuario;

    public Veiculo() {
    }

    public Veiculo(String modelo, String placa, String renavam, Usuario usuario) {
        this.modelo = modelo;
        this.placa = placa;
        this.renavam = renavam;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<InfracaoUsuario> getInfracaoUsuario() {
        return infracaoUsuario;
    }

    public void setInfracaoUsuario(InfracaoUsuario infracaoUsuario) {
        this.infracaoUsuario.add(infracaoUsuario);
    }
}