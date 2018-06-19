package com.gameficacaoTransito.gameficacaoTransito.models.Response;

import com.gameficacaoTransito.gameficacaoTransito.models.Usuario;

public class VeiculoResponse {

    private Integer id;

    private String modelo;

    private String placa;

    private String renavam;

    private Integer usuario;

    public VeiculoResponse() {
    }

    public VeiculoResponse(String modelo, String placa, String renavam, Integer usuario) {
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

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }
}
