package br.com.zup.catalisa.school.business.service;

import br.com.zup.catalisa.school.business.domain.dto.ProfessorDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorService {
    ProfessorDTO criar(ProfessorDTO professorDTO);
    ProfessorDTO buscarPorId(Long id);
    ProfessorDTO atualizar(Long id, ProfessorDTO professorDTO);
    boolean deletar(Long id);
}
