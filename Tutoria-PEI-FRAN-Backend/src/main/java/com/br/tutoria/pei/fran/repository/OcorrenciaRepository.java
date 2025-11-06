package com.br.tutoria.pei.fran.repository;

import com.br.tutoria.pei.fran.entities.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

    @Query(value = "SELECT obj FROM Ocorrencia obj WHERE obj.aluno.ra = :ra")
    Ocorrencia getOcorrenciaByAlunoRa(Long ra);
}
