package com.gameficacaoTransito.gameficacaoTransito.services;

import com.gameficacaoTransito.gameficacaoTransito.models.Response.UsuarioResponse;
import com.gameficacaoTransito.gameficacaoTransito.models.Usuario;
import com.gameficacaoTransito.gameficacaoTransito.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private VeiculoService veiculoService;

    public List<UsuarioResponse> findAll() {
        List<Usuario> usuarios = repo.findAll();
        ArrayList<UsuarioResponse> usuariosResponse = new ArrayList<UsuarioResponse>();

        for (int i = 0; i < usuarios.size(); i++) {
            usuariosResponse.add(this.convertToDTo(usuarios.get(i)));
        }
        return usuariosResponse;
    }

    public Usuario insert(Usuario obj) {
        obj.setId(null);
        obj = repo.save(obj);
        return obj;
    }

    public UsuarioResponse findById(Integer user) {
        List<UsuarioResponse> usuarios = this.findAll();
        Usuario usuario = new Usuario();

        for(int i = 0; i<usuarios.size(); i++){
            if(usuarios.get(i).getId() == user){
                usuario.setId(usuarios.get(i).getId());
                usuario.setNome(usuarios.get(i).getNome());
                usuario.setEmail(usuarios.get(i).getEmail());
                usuario.setCnh(usuarios.get(i).getCnh());
                usuario.setCategoria(usuarios.get(i).getCategoria());
                return convertToDTo(usuario);
            }
        }

        return convertToDTo(usuario);

    }

    private UsuarioResponse convertToDTo(Usuario user) {
        UsuarioResponse userDTO = new UsuarioResponse();
        userDTO.setId(user.getId());
        userDTO.setNome(user.getNome());
        userDTO.setEmail(user.getEmail());
        userDTO.setCnh(user.getCnh());
        userDTO.setCategoria(user.getCategoria());
        userDTO.setVeiculos(veiculoService.findVeiculoByUsuario(user));

        return userDTO;
    }


}
