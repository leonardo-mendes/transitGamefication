package com.gameficacaoTransito.gameficacaoTransito.repositories;

import com.gameficacaoTransito.gameficacaoTransito.models.Bonificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BonificacaoRepository extends JpaRepository<Bonificacao, Integer> {

    public Optional<Bonificacao> findByUsuario(Integer user);

}