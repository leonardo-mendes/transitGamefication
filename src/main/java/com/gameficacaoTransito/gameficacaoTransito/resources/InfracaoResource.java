package com.gameficacaoTransito.gameficacaoTransito.resources;

import com.gameficacaoTransito.gameficacaoTransito.models.Infracao;
import com.gameficacaoTransito.gameficacaoTransito.models.Response.VeiculoResponse;
import com.gameficacaoTransito.gameficacaoTransito.models.Veiculo;
import com.gameficacaoTransito.gameficacaoTransito.services.InfracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/infracoes")
public class InfracaoResource {

    @Autowired
    private InfracaoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Infracao>> findAll() {

        List<Infracao> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value="/{infracao}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Infracao>> findById(@PathVariable Integer id) {

        Optional<Infracao> infracao = service.findById(id);

        return ResponseEntity.ok().body(infracao);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Infracao infracao){
        Infracao obj = service.insert(infracao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


}
