package com.gameficacaoTransito.gameficacaoTransito.repositories;

import com.gameficacaoTransito.gameficacaoTransito.models.Usuario;
import com.gameficacaoTransito.gameficacaoTransito.models.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{

    public List<Veiculo> findVeiculoByUsuario(Optional<Usuario> user);
}