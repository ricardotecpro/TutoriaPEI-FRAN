package com.br.tutoria.pei.fran.dtos;

import com.br.tutoria.pei.fran.entities.Aluno;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AlunoDTO {

    @Digits(integer = 13, fraction = 0, message = "O RA deve ter exatamente 13 dígitos")
    @NotNull(message = "Campo requerido")
    private Long ra;
    @NotBlank(message = "Campo requerido")
    private String nome;
    @NotBlank(message = "Campo requerido")
    @Email(message = "O campo deve ser um email valido")
    private String email;
    @NotNull(message = "Campo requerido")
    private LocalDate dataNasc;
    @NotNull(message = "Campo requerido")
    @Positive(message = "A idade deve ser positiva")
    private Integer idade;
    @NotNull(message = "Campo requerido")
    private Integer telefone;
    @NotBlank(message = "Campo requerido")
    private String transporte;
    @NotBlank(message = "Campo requerido")
    private String projetoVida;
    @NotBlank(message = "Campo requerido")
    private String serie;
    @NotBlank(message = "Campo requerido")
    private String endereco;
    private String imgUrl;

    @Valid
    private DadosFamiliaDTO dadoFamilia;
    @Valid
    private EscolaridadeDTO escolaridade;

    public AlunoDTO() {}

    public AlunoDTO(Long ra, String nome, String email, LocalDate dataNasc, Integer idade, Integer telefone, String transporte, String projetoVida, String serie, DadosFamiliaDTO dadosFamilia, String endereco, EscolaridadeDTO escolaridade, String imgUrl) {
        this.ra = ra;
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
        this.idade = idade;
        this.telefone = telefone;
        this.transporte = transporte;
        this.projetoVida = projetoVida;
        this.serie = serie;
        this.dadoFamilia = dadosFamilia;
        this.endereco = endereco;
        this.escolaridade = escolaridade;
        this.imgUrl = imgUrl;
    }

    public AlunoDTO(Aluno aluno) {
        ra = aluno.getRa();
        nome = aluno.getNome();
        email = aluno.getEmail();
        dataNasc = aluno.getDataNasc();
        idade = aluno.getIdade();
        telefone = aluno.getTelefone();
        transporte = aluno.getTransporte();
        projetoVida = aluno.getProjetoVida();
        serie = aluno.getSerie();
        dadoFamilia = aluno.getDadoFamilia() != null ? new DadosFamiliaDTO(aluno.getDadoFamilia()) : null;
        escolaridade = aluno.getEscolaridade() != null ? new EscolaridadeDTO(aluno.getEscolaridade()) : null;
        endereco = aluno.getEndereco();
        imgUrl = aluno.getImgUrl();
    }


    public Long getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public Integer getIdade() {
        return idade;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public String getTransporte() {
        return transporte;
    }

    public String getProjetoVida() {
        return projetoVida;
    }

    public String getSerie() {
        return serie;
    }

    public DadosFamiliaDTO getDadoFamilia() {
        return dadoFamilia;
    }

    public String getEndereco() {
        return endereco;
    }

    public EscolaridadeDTO getEscolaridade() {
        return escolaridade;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
