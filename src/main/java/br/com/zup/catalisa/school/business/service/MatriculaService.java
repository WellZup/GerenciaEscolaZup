package br.com.zup.catalisa.school.business.service;

import br.com.zup.catalisa.school.business.domain.dto.MatriculaDTO;
import br.com.zup.catalisa.school.business.domain.entity.Matricula;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaService {
    Matricula realizarMatricula(MatriculaDTO matriculaDTO);

}

