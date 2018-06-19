package com.gameficacaoTransito.gameficacaoTransito.repositories;

import com.gameficacaoTransito.gameficacaoTransito.models.Infracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfracaoRepository extends JpaRepository<Infracao, Integer> {

}