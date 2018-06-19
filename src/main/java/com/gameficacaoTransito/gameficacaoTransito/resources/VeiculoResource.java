package com.gameficacaoTransito.gameficacaoTransito.resources;

import com.gameficacaoTransito.gameficacaoTransito.models.Response.VeiculoResponse;
import com.gameficacaoTransito.gameficacaoTransito.models.Veiculo;
import com.gameficacaoTransito.gameficacaoTransito.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {

    @Autowired
    private VeiculoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<VeiculoResponse>> findAll() {

        List<VeiculoResponse> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Veiculo veiculo){
        Veiculo obj = service.insert(veiculo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


}
