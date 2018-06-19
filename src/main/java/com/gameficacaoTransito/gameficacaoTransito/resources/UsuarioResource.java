package com.gameficacaoTransito.gameficacaoTransito.resources;

import com.gameficacaoTransito.gameficacaoTransito.models.Response.UsuarioResponse;
import com.gameficacaoTransito.gameficacaoTransito.models.Usuario;
import com.gameficacaoTransito.gameficacaoTransito.models.Veiculo;
import com.gameficacaoTransito.gameficacaoTransito.services.UsuarioService;
import com.gameficacaoTransito.gameficacaoTransito.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioResponse>> findAll() {

        List<UsuarioResponse> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value="/{user}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioResponse> findUser(@PathVariable Integer user) {

        UsuarioResponse usuario = service.findById(user);

        return ResponseEntity.ok().body(usuario);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Usuario usu){
        Usuario obj = service.insert(usu);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
