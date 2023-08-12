package br.com.zup.catalisa.school.controller;

import br.com.zup.catalisa.school.business.domain.dto.CursoDTO;
import br.com.zup.catalisa.school.business.service.CursoService;
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
public class CursoController {
    @Autowired
    private CursoService cursoService;
    private CursoDTO cursoDTO;

    @GetMapping(path = "/v1/curso/criar")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CursoDTO> criar(@RequestBody CursoDTO cursoDTO) {
        CursoDTO cursoCriadoDTO = cursoService.criar(cursoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoCriadoDTO);
    }

    @GetMapping(path = "/v1/curso/buscarId/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<CursoDTO> buscarPorId(@PathVariable Long id) {
        CursoDTO cursoDTO = cursoService.buscarPorId(id);
        if (cursoDTO != null) {
            return ResponseEntity.ok(cursoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/v1/curso/atualizar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CursoDTO> atualizar(@PathVariable Long id) {
        CursoDTO cursoAtualizadoDTO = cursoService.atualizar(id, cursoDTO);
        if (cursoAtualizadoDTO != null) {
            return ResponseEntity.ok(cursoAtualizadoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/v1/curso/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = cursoService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
