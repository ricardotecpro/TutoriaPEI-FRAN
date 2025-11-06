package com.br.tutoria.pei.fran.controllers;

import com.br.tutoria.pei.fran.dtos.*;
import com.br.tutoria.pei.fran.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    private final AlunoService service;

    @Autowired
    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> insert(@Valid @RequestBody AlunoDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ra}").buildAndExpand(dto.getRa()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PostMapping("/simple")
    public ResponseEntity<AlunoDTO> insertMin(@RequestBody AlunoMinDTO dto) {
        AlunoDTO aluno = service.insertMin(dto); // converte e salva
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{ra}")
                .buildAndExpand(aluno.getRa())
                .toUri();
        return ResponseEntity.created(uri).body(aluno);
    }
    @GetMapping("/simple")
    public List<AlunoMinDTO> listarAlunosSimple() {
        return service.getAllNames(); // ✅ assim funciona
    }

    @GetMapping
    public ResponseEntity<List<AlunoMinDTO>> getAllNamesAndImages() {
        List<AlunoMinDTO> result = service.getAllNames();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{ra}")
    public ResponseEntity<AlunoDTO> getAlunoByRa(@PathVariable Long ra) {
        AlunoDTO result = service.getAlunosByRa(ra);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/{ra}")
    public ResponseEntity<AlunoDTO> update(@PathVariable Long ra, @Valid @RequestBody AlunoDTO dto) {
        dto = service.update(ra, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{ra}")
    public ResponseEntity<Void> delete(@PathVariable Long ra) {
        service.delete(ra);
        return ResponseEntity.noContent().build();
    }

    //Mudar isso depois
    @PutMapping(value = "/{ra}/participacao")
    public ResponseEntity<ParticipacaoDTO> addParticipacao(@PathVariable Long ra, @RequestBody ParticipacaoDTO participacaoDTO) {
        participacaoDTO = service.addParticipacao(ra, participacaoDTO);
        return ResponseEntity.ok(participacaoDTO);
    }

    @GetMapping(value = "/{ra}/participacao")
    public ResponseEntity<ParticipacaoDTO> getParticipacao(@PathVariable Long ra) {
        ParticipacaoDTO dto = service.getParticipacao(ra);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/{ra}/avaliacoes")
    public ResponseEntity<AvaliacaoDTO> addAvaliacao(@PathVariable Long ra, @Valid @RequestBody AvaliacaoDTO dto) {
        dto = service.addAvaliacao(ra, dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping(value = "{ra}/avaliacoes")
    public ResponseEntity<List<AvaliacaoDTO>> getAllAvaliacoes(@PathVariable Long ra) {
        List<AvaliacaoDTO> dtos = service.getAllAvaliacoes(ra);
        return ResponseEntity.ok(dtos);
    }

    //Mudar isso depois
    @PutMapping(value = "/{ra}/ocorrencias")
    public ResponseEntity<OcorrenciaDTO> addOcorrencias(@PathVariable Long ra, @Valid @RequestBody OcorrenciaDTO dto) {
        dto = service.addOcorrencia(ra, dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{ra}/ocorrencias")
    public ResponseEntity<OcorrenciaDTO> getOcorrencias(@PathVariable Long ra) {
        OcorrenciaDTO dto = service.getOcorrencia(ra);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/{ra}/leituras")
    public ResponseEntity<LeituraDTO> addLeitura(@PathVariable Long ra, @Valid @RequestBody LeituraDTO dto) {
        dto = service.addLeitura(ra, dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping(value = "/{ra}/leituras")
    public ResponseEntity<List<LeituraDTO>> getAllLeituras(@PathVariable Long ra) {
        List<LeituraDTO> dtos = service.getAllLeituras(ra);
        return ResponseEntity.ok(dtos);
    }
}
