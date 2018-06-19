package com.gameficacaoTransito.gameficacaoTransito.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cnh;

    private String categoria;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

    @OneToMany(mappedBy = "usuario")
    private List<InfracaoUsuario> infracaoUsuario;

    public Usuario() {
    }

    public Usuario(String nome, String email, String cnh, String categoria) {
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

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void addVeiculos(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public List<InfracaoUsuario> getInfracaoUsuario() {
        return infracaoUsuario;
    }

    public void setInfracaoUsuario(InfracaoUsuario infracaoUsuario) {
        this.infracaoUsuario.add(infracaoUsuario);
    }
}