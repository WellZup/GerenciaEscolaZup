package br.com.zup.catalisa.school.controller;

import br.com.zup.catalisa.school.business.domain.dto.AlunoDTO;
import br.com.zup.catalisa.school.business.domain.entity.Aluno;
import br.com.zup.catalisa.school.business.service.AlunoService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping(path = "/v2/aluno")
@RestController
@Getter
@Setter
public class AlunoController {
    @Autowired
    private AlunoService alunoService;
    private AlunoDTO alunoDTO;
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.PUT})
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AlunoDTO> criar(@RequestBody AlunoDTO alunoDTO) {

        AlunoDTO alunoCriadoDTO = alunoService.criar(alunoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCriadoDTO);
    }
   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Aluno>> buscarTodosAlunos() {
        List<Aluno> alunoDTOS = alunoService.buscarTodosAlunos();
        return ResponseEntity.ok(alunoDTOS);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<AlunoDTO> buscarPorId(@PathVariable Long id) {
        AlunoDTO alunoDTO = alunoService.buscarPorId(id);
        try {

        if (alunoDTO !=null) {
            return ResponseEntity.ok(alunoDTO);
        }else {
            return ResponseEntity.notFound().build();
        }
        }catch (Exception e) {
            return (ResponseEntity<AlunoDTO>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlunoDTO> atualizar(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO)  {
        AlunoDTO alunoAtualizadoDTO = alunoService.atualizar(id, alunoDTO);
        if (alunoAtualizadoDTO !=null) {
            return ResponseEntity.ok(alunoAtualizadoDTO);
        }else {
            return  ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = alunoService.deletar(id);

        try {

        if (deletado) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
        }catch (Exception e) {
            return (ResponseEntity<Void>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

}
