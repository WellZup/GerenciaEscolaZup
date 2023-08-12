package br.com.zup.catalisa.school.controller;

import br.com.zup.catalisa.school.business.domain.dto.ProfessorDTO;
import br.com.zup.catalisa.school.business.service.ProfessorService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Getter
@Setter
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;
    private ProfessorDTO professorDTO;

    @GetMapping(path = "/v1/professor/criar")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProfessorDTO> criar(@RequestBody ProfessorDTO professorDTO) {
        ProfessorDTO professorCriadoDTO = professorService.criar(professorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorCriadoDTO);
    }

    @GetMapping(path = "/v1/professor/buscarId/{id}")
    public ResponseEntity<ProfessorDTO> buscarPorId(@PathVariable Long id) {
        ProfessorDTO professorDTO = professorService.buscarPorId(id);
        if (professorDTO != null) {
            return ResponseEntity.ok(professorDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/v1/professor/atualizar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessorDTO> atualizar(@PathVariable Long id) {
        ProfessorDTO professorCriadoDTO = professorService.atualizar(id, professorDTO);
        if (professorDTO != null) {
            return ResponseEntity.ok(professorDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping(path = "/v1/professor/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = professorService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
