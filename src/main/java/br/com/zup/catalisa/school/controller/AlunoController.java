package br.com.zup.catalisa.school.controller;

import br.com.zup.catalisa.school.business.domain.dto.AlunoDTO;
import br.com.zup.catalisa.school.business.service.AlunoService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@Getter
@Setter
public class AlunoController {
    @Autowired
    private AlunoService alunoService;
    private AlunoDTO alunoDTO;
    @GetMapping(path = "/v1/aluno/criar")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AlunoDTO> criar(@RequestBody AlunoDTO alunoDTO) {

        AlunoDTO alunoCriadoDTO = alunoService.criar(alunoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCriadoDTO);
    }
   @GetMapping(path = "v1/aluno/buscar/{id}")
    public ResponseEntity<AlunoDTO> buscarTodosAlunos() {
        List<AlunoDTO> alunoDTOS = alunoService.buscarTodosAlunos();
        return ResponseEntity.ok((AlunoDTO) alunoDTOS);
    }


    @GetMapping(path = "v1/aluno/buscarid/{id}")
    public ResponseEntity<AlunoDTO> buscarPorId(@PathVariable Long id) {
        AlunoDTO alunoDTO = alunoService.buscarPorId(id);
        if (alunoDTO !=null) {
            return ResponseEntity.ok(alunoDTO);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping(path = "v1/alunos/atualizar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlunoDTO> atualizar(@PathVariable Long id) {
        AlunoDTO alunoAtualizadoDTO = alunoService.atualizar(id, alunoDTO);
        if (alunoAtualizadoDTO !=null) {
            return ResponseEntity.ok(alunoAtualizadoDTO);
        }else {
            return  ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping(path = "v1/aluno/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = alunoService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
