package com.gameficacaoTransito.gameficacaoTransito.models.Response;

import java.util.List;

public class UsuarioResponse {

    private Integer id;

    private String nome;

    private String email;

    private String cnh;

    private String categoria;

    private List<VeiculoResponse> veiculos;

    public UsuarioResponse() {
    }

    public UsuarioResponse(String nome, String email, String cnh, String categoria) {
        this.nome = nome;
        this.email = email;
        this.cnh = cnh;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<VeiculoResponse> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<VeiculoResponse> veiculos) {
        this.veiculos = veiculos;
    }
}
