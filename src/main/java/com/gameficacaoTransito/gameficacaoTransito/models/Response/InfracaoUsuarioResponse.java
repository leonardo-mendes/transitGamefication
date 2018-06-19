package com.gameficacaoTransito.gameficacaoTransito.models.Response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class InfracaoUsuarioResponse {

    private Integer id;

    private String usuario;

    private String infracao;

    private String veiculo;

    private Date instante;

    public InfracaoUsuarioResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getInfracao() {
        return infracao;
    }

    public void setInfracao(String infracao) {
        this.infracao = infracao;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }
}
