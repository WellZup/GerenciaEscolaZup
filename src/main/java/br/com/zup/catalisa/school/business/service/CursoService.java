package br.com.zup.catalisa.school.business.service;

import br.com.zup.catalisa.school.business.domain.dto.CursoDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoService {
    CursoDTO criar(CursoDTO cursoDTO);
    CursoDTO buscarPorId(Long id);
    CursoDTO atualizar(Long id, CursoDTO cursoDTO);
    boolean deletar(Long id);
}
