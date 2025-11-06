package com.br.tutoria.pei.fran.dtos;

import com.br.tutoria.pei.fran.entities.Usuario;
import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String cpf;
    @NotBlank(message = "Campo requerido")
    private String nome;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public UsuarioDTO(Usuario usuario) {
        id = usuario.getId();
        cpf = usuario.getCpf();
        nome = usuario.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
