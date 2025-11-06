package com.br.tutoria.pei.fran.controllers;

import com.br.tutoria.pei.fran.dtos.UsuarioDTO;
import com.br.tutoria.pei.fran.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    public final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listaUsuarios() {
        List<UsuarioDTO> dtos = service.findAll();
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> adicionarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        UsuarioDTO dto = service.insert(usuarioDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getCpf()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
