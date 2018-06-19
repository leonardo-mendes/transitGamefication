package com.gameficacaoTransito.gameficacaoTransito.resources;

import com.gameficacaoTransito.gameficacaoTransito.models.InfracaoUsuario;
import com.gameficacaoTransito.gameficacaoTransito.models.Response.InfracaoUsuarioResponse;
import com.gameficacaoTransito.gameficacaoTransito.services.InfracaoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/infracoes/usuarios")
public class InfracaoUsuarioResource {

    @Autowired
    private InfracaoUsuarioService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<InfracaoUsuarioResponse>> findAll() {

        List<InfracaoUsuarioResponse> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value="/{user}", method = RequestMethod.GET)
    public ResponseEntity<List<InfracaoUsuarioResponse>> findUser(@PathVariable Integer user) {

        List<InfracaoUsuarioResponse> list = service.findById(user);

        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody InfracaoUsuario usu){
        InfracaoUsuario obj = service.insert(usu);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
