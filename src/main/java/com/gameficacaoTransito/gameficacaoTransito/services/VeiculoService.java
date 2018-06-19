package com.gameficacaoTransito.gameficacaoTransito.services;

import com.gameficacaoTransito.gameficacaoTransito.models.Response.VeiculoResponse;
import com.gameficacaoTransito.gameficacaoTransito.models.Usuario;
import com.gameficacaoTransito.gameficacaoTransito.models.Veiculo;
import com.gameficacaoTransito.gameficacaoTransito.repositories.UsuarioRepository;
import com.gameficacaoTransito.gameficacaoTransito.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repo;

    @Autowired
    private UsuarioRepository userRepo;


    public List<VeiculoResponse> findAll() {
        List<Veiculo> veiculos = repo.findAll();
        ArrayList<VeiculoResponse> veiculosResponse = new ArrayList<VeiculoResponse>();

        for (int i = 0; i < veiculos.size(); i++) {
            veiculosResponse.add(this.convertToDTo(veiculos.get(i)));
        }
        return veiculosResponse;
    }

    public Veiculo insert(Veiculo obj) {
        obj.setId(null);
        obj = repo.save(obj);
        return obj;
    }

    public List<VeiculoResponse> findVeiculoByUsuario(Usuario user){
        Optional<Usuario> usuario = userRepo.findById(user.getId());
        ArrayList<VeiculoResponse> veiculosResponse = new ArrayList<VeiculoResponse>();

        for (int i = 0; i < repo.findVeiculoByUsuario(usuario).size(); i++) {
            veiculosResponse.add(this.convertToDTo(repo.findVeiculoByUsuario(usuario).get(i)));
        }
        return veiculosResponse;
    }

    private VeiculoResponse convertToDTo(Veiculo veiculo) {
        VeiculoResponse veiculoDTO = new VeiculoResponse();
        veiculoDTO.setId(veiculo.getId());
        veiculoDTO.setModelo(veiculo.getModelo());
        veiculoDTO.setPlaca(veiculo.getPlaca());
        veiculoDTO.setRenavam(veiculo.getRenavam());
        veiculoDTO.setUsuario(veiculo.getUsuario().getId());

        return veiculoDTO;
    }



}
