package com.br.tutoria.pei.fran.service;

import com.br.tutoria.pei.fran.dtos.UsuarioDTO;
import com.br.tutoria.pei.fran.entities.Usuario;
import com.br.tutoria.pei.fran.repository.UsuarioRepository;
import com.br.tutoria.pei.fran.service.exceptions.EntityAlreadyExistingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        List<Usuario> list = repository.findAll();
        return list.stream().map(UsuarioDTO::new).toList();
    }

    public UsuarioDTO insert(UsuarioDTO dto) {
        if (repository.existsByCpf((dto.getCpf()))){
            throw new EntityAlreadyExistingException("Entidade já criada!");
        }
        Usuario novo = new Usuario();
        dtoToEntity(novo, dto);
        novo = repository.save(novo);
        return new UsuarioDTO(novo);
    }

    private void dtoToEntity(Usuario entity, UsuarioDTO dto) {
        entity.setCpf(dto.getCpf());
        entity.setNome(dto.getNome());
    }
}