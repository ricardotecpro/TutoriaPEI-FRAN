package com.br.tutoria.pei.fran.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_registro_atendimento")
public class RegistroAtendimento {

    @EmbeddedId
    private RegistroAtendimentoPK id = new RegistroAtendimentoPK();
    private LocalDate data;
    private String assunto;
    private String observacoesProfessor;

    public RegistroAtendimento() {}

    public RegistroAtendimento(Aluno aluno, Usuario usuario, LocalDate data, String assunto, String observacoesProfessor) {
        id.setAluno(aluno);
        id.setUsuario(usuario);
        this.data = data;
        this.assunto = assunto;
        this.observacoesProfessor = observacoesProfessor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getObservacoesProfessor() {
        return observacoesProfessor;
    }

    public void setObservacoesProfessor(String observacoesProfessor) {
        this.observacoesProfessor = observacoesProfessor;
    }

    public Aluno getAluno() {
        return id.getAluno();
    }

    public void setAluno(Aluno aluno) {
        id.setAluno(aluno);
    }

    public Usuario getUsuario() {
        return id.getUsuario();
    }

    public void setUsuario(Usuario usuario) {
        id.setUsuario(usuario);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RegistroAtendimento that = (RegistroAtendimento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
