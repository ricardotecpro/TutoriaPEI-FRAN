package com.br.tutoria.pei.fran.dtos;

public class AlunoMinDTO {
    private Long ra;
    private String nome;

    public AlunoMinDTO() {}

    public AlunoMinDTO(Long ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }

    public Long getRa() {
        return ra;
    }

    public void setRa(Long ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
