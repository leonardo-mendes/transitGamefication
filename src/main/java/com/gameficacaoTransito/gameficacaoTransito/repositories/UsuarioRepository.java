package com.gameficacaoTransito.gameficacaoTransito.repositories;

import com.gameficacaoTransito.gameficacaoTransito.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}