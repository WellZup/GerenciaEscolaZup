package br.com.zup.catalisa.school.controller;

import br.com.zup.catalisa.school.business.domain.dto.MatriculaDTO;
import br.com.zup.catalisa.school.business.domain.entity.Matricula;
import br.com.zup.catalisa.school.business.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<Matricula> realizarMatricula(@RequestBody MatriculaDTO matriculaDTO) {
        Matricula matricula = matriculaService.realizarMatricula(matriculaDTO);
        return ResponseEntity.ok(matricula);

    }

}
