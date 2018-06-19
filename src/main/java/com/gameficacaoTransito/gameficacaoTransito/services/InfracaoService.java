package com.gameficacaoTransito.gameficacaoTransito.services;

import com.gameficacaoTransito.gameficacaoTransito.models.Infracao;
import com.gameficacaoTransito.gameficacaoTransito.models.Response.UsuarioResponse;
import com.gameficacaoTransito.gameficacaoTransito.models.Usuario;
import com.gameficacaoTransito.gameficacaoTransito.repositories.InfracaoRepository;
import com.gameficacaoTransito.gameficacaoTransito.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InfracaoService {

    @Autowired
    private InfracaoRepository repo;

    @Autowired
    private VeiculoService veiculoService;

    public List<Infracao> findAll() {
        List<Infracao> infracoes = repo.findAll();
        return infracoes;
    }

    public Optional<Infracao> findById(Integer id) {
        Optional<Infracao> infracao = repo.findById(id);
        return infracao;
    }

    public Infracao insert(Infracao obj) {
        obj.setId(null);
        obj = repo.save(obj);
        return obj;
    }
}
