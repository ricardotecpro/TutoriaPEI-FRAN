package com.br.tutoria.pei.fran.dtos;

import com.br.tutoria.pei.fran.entities.DadosFamilia;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class DadosFamiliaDTO {

    @NotBlank(message = "Campo requerido")
    private String pai;
    @NotBlank(message = "Campo requerido")
    private String mae;
    private String responsavel;
    @NotBlank(message = "Campo requerido")
    private String estruturaFamiliar;
    @Positive(message = "Insira um numero valido")
    private Integer numPai;
    @Positive(message = "Insira um numero valido")
    private Integer numMae;
    @Positive(message = "Insira um numero valido")
    private Integer numResponsavel;

    public DadosFamiliaDTO() {}

    public DadosFamiliaDTO(Long id, String pai, String mae, String responsavel, String estruturaFamiliar, Integer numPai, Integer numMae, Integer numResponsavel) {
        this.pai = pai;
        this.mae = mae;
        this.responsavel = responsavel;
        this.estruturaFamiliar = estruturaFamiliar;
        this.numPai = numPai;
        this.numMae = numMae;
        this.numResponsavel = numResponsavel;
    }

    public DadosFamiliaDTO(DadosFamilia dadosFamilia) {
        pai = dadosFamilia.getPai();
        mae = dadosFamilia.getMae();
        responsavel = dadosFamilia.getResponsavel();
        estruturaFamiliar = dadosFamilia.getEstruturaFamiliar();
        numPai = dadosFamilia.getNumPai();
        numMae = dadosFamilia.getNumMae();
        numResponsavel = dadosFamilia.getNumResponsavel();
    }

    public String getPai() {
        return pai;
    }

    public String getMae() {
        return mae;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getEstruturaFamiliar() {
        return estruturaFamiliar;
    }

    public Integer getNumPai() {
        return numPai;
    }

    public Integer getNumMae() {
        return numMae;
    }

    public Integer getNumResponsavel() {
        return numResponsavel;
    }
}
