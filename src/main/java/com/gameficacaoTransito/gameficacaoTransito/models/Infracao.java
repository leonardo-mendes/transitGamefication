package com.gameficacaoTransito.gameficacaoTransito.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Infracao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Integer pontuacao;

    @OneToMany(mappedBy = "infracao")
    private List<InfracaoUsuario> infracaoUsuario;

    public Infracao() {
    }

    public Infracao(String nome, Integer pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
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

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<InfracaoUsuario> getInfracaoUsuario() {
        return infracaoUsuario;
    }

    public void addInfracaoUsuario(InfracaoUsuario infracaoUsuario) {
        this.infracaoUsuario.add(infracaoUsuario);
    }
}