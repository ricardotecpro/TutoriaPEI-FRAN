package com.br.tutoria.pei.fran.entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;

       @OneToMany(mappedBy = "id.usuario")
    Set<Tutoria> tutorias = new HashSet<>();

    @OneToMany(mappedBy = "id.usuario")
    Set<RegistroAtendimento> registroAtendimentos = new HashSet<>();

    public Usuario(Long id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Usuario() {

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

    public Set<Tutoria> getTutorias() {
        return tutorias;
    }

    public List<Aluno> getAlunosTutorias() {
        return tutorias.stream().map(Tutoria::getAluno).toList();
    }

    public Set<RegistroAtendimento> getRegistroAtendimentos() {
        return registroAtendimentos;
    }

    public List<Aluno> getAlunosRegistroAtendimentos() {
        return registroAtendimentos.stream().map(RegistroAtendimento::getAluno).toList();
    }


}
